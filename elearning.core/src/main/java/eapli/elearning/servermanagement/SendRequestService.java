package eapli.elearning.servermanagement;


import eapli.elearning.postitmanagement.dto.PostItDTO;
import eapli.elearning.sharedboardmanagement.domain.SendArchiveSharedBoardRequestService;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.elearning.sharedboardparticipationmanagement.domain.UserPermission;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.aspectj.apache.bcel.generic.RET;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

@ApplicationService
public class SendRequestService {
    private static InetAddress serverIP;
    private static Socket sock;
    private DataOutputStream sOut;
    private DataInputStream sIn;
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final SendArchiveSharedBoardRequestService archiveService = new SendArchiveSharedBoardRequestService();
    private void sendRequest() throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.STUDENT, ElearningRoles.TEACHER);

        try {
            serverIP = InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
            sock = new Socket(serverIP, 9999);
        }catch (UnknownHostException e) {
            throw new IllegalArgumentException("Failed to establish TCP connection");
        }catch (Exception e){
            throw new IllegalArgumentException("An error occurred: " + e);
        }

        sOut = new DataOutputStream(sock.getOutputStream());
        sIn = new DataInputStream(sock.getInputStream());
    }

    public String sendArchiveBoardRequest(String sharedBoardTitle) throws IOException {
        sendRequest();
        SystemUser user = authz.session().get().authenticatedUser();
        return archiveService.sendArchiveBoardRequest(sharedBoardTitle, user, sOut, sIn);
    }

    public String sendPostItCreationRequest(Integer row, Integer column, String content, SharedBoardDTO sharedBoard) throws IOException {
        sendRequest();
        sOut.writeInt(1);
        sOut.writeInt(row);
        sOut.writeInt(column);
        sOut.writeUTF(content);
        sOut.writeUTF(sharedBoard.getSharedBoardTitle());

        return sIn.readUTF();
    }


    //mandar shared board em vesz de postit e limnha e coluna nova
    public String sendPostItChangeRequest(Integer newRow, Integer newColumn,Integer exRow, Integer exColumn, String content, SharedBoardDTO board) throws IOException {
        sendRequest();
        sOut.writeInt(3);
        sOut.writeInt(newRow);
        sOut.writeInt(newColumn);
        sOut.writeInt(exRow);
        sOut.writeInt(exColumn);
        sOut.writeUTF(content);
        sOut.writeUTF(board.getSharedBoardTitle());
        return sIn.readUTF();
    }

    public String  sendShareSharedBoardRequest(SharedBoardDTO sharedBoard, List<SystemUser> user, List<UserPermission> permit) throws IOException{

        for (int i = 0; i < user.size(); i++) {
            sendRequest();
            sOut.writeInt(4);
            sOut.writeUTF(sharedBoard.getSharedBoardTitle());
            sOut.writeUTF(user.get(i).username().toString());
            sOut.writeUTF(permit.get(i).toString());
        }
        //string sharedboard
        //string username
        //int userpermission


        return sIn.readUTF();
    }
    public String sendPostItUndoRequest(String sharedBoardTitle) throws IOException{
        sendRequest();
        sOut.writeInt(5);
        sOut.writeUTF(sharedBoardTitle);
        return sIn.readUTF();
    }

    public String sendViewHistorySharedBoardRequest(String sharedBoardTitle) throws IOException{
        sendRequest();
        sOut.writeInt(6);
        sOut.writeUTF(sharedBoardTitle);
        return sIn.readUTF();
    }

    public String sendVisualizeSharedBoardRequest(String sharedBoardTitle) throws IOException{
        sendRequest();
        sOut.writeInt(7);
        sOut.writeUTF(sharedBoardTitle);
        return sIn.readUTF();
    }




    /**
     * Pode-se adicionar aqui outros pedidos, por exemplo: criação de post-it, alteração de post-it, etc...
     */


}

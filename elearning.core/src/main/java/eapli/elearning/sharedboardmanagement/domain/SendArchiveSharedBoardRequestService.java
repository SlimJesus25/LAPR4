package eapli.elearning.sharedboardmanagement.domain;

import eapli.framework.domain.services.DomainService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@DomainService
public class SendArchiveSharedBoardRequestService {

    public String sendArchiveBoardRequest(String sharedBoardTitle, SystemUser authenticatedUser, DataOutputStream sOut
            , DataInputStream sIn) throws IOException {
        sOut.writeInt(2);
        sOut.writeUTF(sharedBoardTitle);
        sOut.writeUTF(authenticatedUser.identity().toString());

        return sIn.readUTF();
    }
}

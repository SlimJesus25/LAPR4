package eapli.Rcomp;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.postitmanagement.domain.PostIt;
import eapli.elearning.sharedboardmanagement.application.FindSharedBoardByTitleService;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardmanagement.repositories.SharedBoardRepository;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



/**
 *
 * @author ANDRE MOREIRA (asc@isep.ipp.pt)
 */
public class HttpServerAjaxVoting implements Runnable{

    //private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("eapli.base");

    static private final String BASE_FOLDER="/home/ricardo/IdeaProjects/teste2/elearning.server/src/main/java/eapli/Rcomp/www";
    static private ServerSocket sock;
    private static SharedBoard sb;
    private FindSharedBoardByTitleService ctrl = new FindSharedBoardByTitleService();

    public static SharedBoardRepository repoBoard = PersistenceContext.repositories().sharedBoards();

    public HttpServerAjaxVoting() {
    }

    @Override
    public void run() {

        Socket s = null;
        System.out.println(".");
        try {
            sock = new ServerSocket(9998); }
        catch(IOException ex) {
            System.out.println("Server failed to open local port " + 9998);
            System.exit(1);
        }
        while(true) {
            try {
                s = sock.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                DataInputStream in = new DataInputStream(s.getInputStream());
                sb = ctrl.findSharedBoardByTitle(in.readUTF());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            HttpAjaxVotingRequest req = new HttpAjaxVotingRequest(s, BASE_FOLDER);
                req.start();
                }
        } 
	
    
    // DATA ACCESSED BY THREADS - LOCKING REQUIRED
    
    private static final int candidatesNumber = 4;
    private static final String[] candidateName = new String[candidatesNumber];
    private static final int[] candidateVotes = new int[candidatesNumber];
    private static SharedBoard updatedSharedBoard;





    public static synchronized String getSharedBoardInHTML() {

        System.out.println("updating view");
        //EntityManager entityManager = emf.createEntityManager();
        //EntityTransaction transaction = entityManager.getTransaction();
        //transaction.begin();
        updatedSharedBoard = sb;
        //System.out.println("participants: " + sharedBoard.getParticipants());
        System.out.println("new title: " + updatedSharedBoard.title());
        //System.out.println("changes: " + updatedSharedBoard.getAuditLog());

        //transaction.commit();

        //entityManager.close();


        String textHtml = "<h1>" + updatedSharedBoard.title()+ "</h1>\n";

        textHtml += "<table>\n" +
                "    <thead>\n" +
                "      <tr>\n" +
                "        <th>Title:" + updatedSharedBoard.title() + "</th></tr>\n";
        PostIt[][] schemaUpdated = updatedSharedBoard.schema();


        for (int i = 0; i < updatedSharedBoard.getColumn(); i++) {
            textHtml+="<tr>";
            for (int j = 0; j < updatedSharedBoard.getRow(); j++) {
                textHtml += "<th>" + schemaUpdated[j][i] + "</th>\n";
            }
            textHtml+="</tr>";
        }

        return textHtml;
    }

    public static synchronized void castVote(String i) {
        int cN;
        try { cN=Integer.parseInt(i); }
        catch(NumberFormatException ne) { return; }
        cN--;
        if(cN >= 0 && cN < candidatesNumber) candidateVotes[cN]++;
    }



}

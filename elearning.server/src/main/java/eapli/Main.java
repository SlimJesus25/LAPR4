package eapli;

import eapli.Rcomp.HttpServerAjaxVoting;
import eapli.elearning.app.common.console.ELearningBaseApplication;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.postitmanagement.application.*;
import eapli.elearning.sharedboardmanagement.application.*;
import eapli.elearning.sharedboardmanagement.domain.Action;
import eapli.elearning.sharedboardmanagement.domain.BoardAction;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardparticipationmanagement.domain.UserPermission;
import eapli.elearning.usermanagement.domain.ElearningPasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.eventpubsub.EventDispatcher;
import lombok.SneakyThrows;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Main extends ELearningBaseApplication{
    static ServerSocket sock;
    public ArrayList<SharedBoard> sharedBoards = new ArrayList<>();

    private static final String POWERUSER_PWD = "poweruserA1";
    private static final String POWERUSER = "poweruser";
//    private final AuthorizationService authz = AuthzRegistry.authorizationService();
//    private final AuthenticationService authenticationService = AuthzRegistry.authenticationService();

    public static void main(String args[]){
        new Main().run(args);
    }

    @Override
    protected void configureAuthz() {
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new ElearningPasswordPolicy(),
                new PlainTextEncoder());
    }

    @Override
    protected void doMain(String[] args) {
        Socket cliSock;

        try {
            sock = new ServerSocket(9999);
        } catch (IOException ex) {
            System.out.println("Failed to open server socket");
            System.exit(1);
        }

        Thread thread = new Thread(new HttpServerAjaxVoting());
        thread.start();

        while (true) {
            try {
                cliSock = sock.accept();
                new Thread(new Server(cliSock, sharedBoards, thread)).start();
            }catch (Exception e){
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }

    @Override
    protected String appTitle() {
        return "Shared Board Server";
    }

    @Override
    protected String appGoodbye() {
        return "Exiting...";
    }

    @Override
    protected void doSetupEventHandlers(EventDispatcher dispatcher) {

    }
}

    class Server implements Runnable {
        private Socket s;
        private Socket httpSocket;
        private List<SharedBoard> sharedBoards;
        private Thread http;
        private InetAddress httpIP;
        private final int CREATE_POST_IT = 1;
        private final int ARCHIVE_BOARD = 2;
        private final int CHANGE_POST_IT = 3;
        private final int SHARE_BOARD = 4;
        private final int UNDO_CHANGE = 5;
        private final int VIEW_HISTORY = 6;
        private final int VISUALIZE_BOARD = 7;

        private Object[][] locks = new Object[50][50];

        private final CreatePostItController postItController = new CreatePostItControllerImpl();

        private final ViewSharedBoardHistoryController viewHistoryOfUpdates = new ViewSharedBoardHistoryControllerImpl();
        private final ChangePostItController postItChangeController = new ChangePostItControllerImpl();
        private final SendArchiveBoardRequestController archiveBoardController = new SendArchiveBoardRequestControllerImpl();
        private final FindSharedBoardByTitleService findSharedBoardByTitleService = new FindSharedBoardByTitleService();
        private final SendShareSharedBoardController shareBoardController = new SendShareSharedBoardControllerImpl();
        private final UndoChangeController undoChangeController = new UndoChangeControllerImpl();
        private final VisualizeSharedBoardController visualizeBoardController = new VisualizeSharedBoardController();
        public Server(Socket cli_s, List<SharedBoard> sharedBoardList, Thread http) throws IOException {
            s=cli_s;
            sharedBoards = sharedBoardList;
            this.http = http;
            httpIP = InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
            httpSocket = new Socket(httpIP, 9998);
        }

        @SneakyThrows
        public void run() {

            for(int i=0;i<50;i++)
                for(int j=0;j<50;j++)
                    locks[i][j] = new Object();


            InetAddress clientIP;

            clientIP=s.getInetAddress();
            System.out.println("New client connection from " + clientIP.getHostAddress() +
                    ", port number " + s.getPort());

            DataOutputStream sOut = new DataOutputStream(s.getOutputStream());
            DataInputStream sIn = new DataInputStream(s.getInputStream());

            try {

                int choice = sIn.readInt();
                SharedBoard sharedBoard;
                String boardTitle;
                String username;
                UserPermission permission;
                switch(choice){
                    case CREATE_POST_IT:
                        int row = sIn.readInt();
                        int column = sIn.readInt();
                        String content = sIn.readUTF();
                        String sharedBoardTitle = sIn.readUTF();
                        synchronized (this) {
                            System.out.println("Creating post-it for client " + clientIP.getHostAddress());
                            try {
                                sharedBoard = sharedBoards.stream().findAny().filter(e -> e.title()
                                        .equals(sharedBoardTitle)).get();
                            } catch (NoSuchElementException ex) {
                                sharedBoard = findSharedBoardByTitleService.findSharedBoardByTitle(sharedBoardTitle);
                                sharedBoards.add(sharedBoard);
                            }
                        }

                        postItController.createPostIt(row, column, content, sharedBoard);

                        System.out.println("Post-it created for " + clientIP.getHostAddress());

                        break;
                    case CHANGE_POST_IT:
                        System.out.println("Changing post-it for client " + clientIP.getHostAddress());
                        int newRow = sIn.readInt();
                        int newColumn=sIn.readInt();
                        int exRow= sIn.readInt();
                        int exColumn=sIn.readInt();
                        String newContent=sIn.readUTF();
                        sharedBoardTitle=sIn.readUTF();
                        synchronized (this) {
                        try {
                            sharedBoard = sharedBoards.stream().findAny().filter(e -> e.title()
                                    .equals(sharedBoardTitle)).get();
                        } catch (NoSuchElementException ex) {
                            sharedBoard = findSharedBoardByTitleService.findSharedBoardByTitle(sharedBoardTitle);
                            sharedBoards.add(sharedBoard);
                        }
                        }

                        postItChangeController.changePostIt(newRow, newColumn, exRow, exColumn, newContent, sharedBoard);

                        System.out.println("Post-it changed for client " + clientIP.getHostAddress());
                        break;
                    case ARCHIVE_BOARD:
                        boardTitle = sIn.readUTF();
                        username = sIn.readUTF();
                        synchronized (this){
                            System.out.println("Archiving shared board for client " + clientIP.getHostAddress());
                            try{
                                sharedBoard = sharedBoards.stream().findAny().filter(e -> e.title()
                                        .equals(boardTitle)).get();
                            }catch (NoSuchElementException ex){
                                sharedBoard = findSharedBoardByTitleService.findSharedBoardByTitle(boardTitle);
                                sharedBoards.add(sharedBoard);
                            }
                            archiveBoardController.archiveBoard(sharedBoard, username);
                            System.out.println("Shared board archived for " + clientIP.getHostAddress());
                        }
                        break;

                    case SHARE_BOARD:
                        boardTitle = sIn.readUTF();
                        username = sIn.readUTF();
                        permission = UserPermission.valueOf(sIn.readUTF());
                        synchronized (this){
                            System.out.println("Sharing the board for client " + clientIP.getHostAddress());
                            try{
                                sharedBoard = sharedBoards.stream().findAny().filter(e -> e.title()
                                        .equals(boardTitle)).get();
                            }catch (NoSuchElementException ex){
                                sharedBoard = findSharedBoardByTitleService.findSharedBoardByTitle(boardTitle);
                                sharedBoards.add(sharedBoard);
                            }
                            shareBoardController.shareBoard(sharedBoard, username, permission);
                            System.out.println("Board shared for " + clientIP.getHostAddress());
                        }
                        break;
                    case UNDO_CHANGE:
                        boardTitle = sIn.readUTF();
                        synchronized (this) {
                            System.out.println("Undoing the last change for client " + clientIP.getHostAddress());
                            try {
                                sharedBoard = sharedBoards.stream().findAny().filter(e -> e.title()
                                        .equals(boardTitle)).get();
                            } catch (NoSuchElementException ex) {
                                sharedBoard = findSharedBoardByTitleService.findSharedBoardByTitle(boardTitle);
                                sharedBoards.add(sharedBoard);
                            }
                        }
                        undoChangeController.undoChange(sharedBoard);
                        System.out.println("Undo made for " + clientIP.getHostAddress());
                        break;
                    case VIEW_HISTORY:
                        System.out.println("View shared Board for client " + clientIP.getHostAddress());
                        sharedBoardTitle=sIn.readUTF();
                        synchronized (this) {
                            try {
                                sharedBoard = sharedBoards.stream().findAny().filter(e -> e.title()
                                        .equals(sharedBoardTitle)).get();
                            } catch (NoSuchElementException ex) {
                                sharedBoard = findSharedBoardByTitleService.findSharedBoardByTitle(sharedBoardTitle);
                                sharedBoards.add(sharedBoard);
                            }
                            Stack<BoardAction> history = viewHistoryOfUpdates.viewHistoryOfUpdates(sharedBoard);
                            String a="";
                            for (BoardAction action : history) {
                               if(action.action()== Action.CREATE_POST_IT){
                                   a+="\nCreat Post it";
                                   a+="\nRow" + action.newRow();
                                   a+="\nColumn " + action.newColumn();
                                   a+="\nContent " + action.oldContent();


                               }
                                if(action.action()== Action.CHANGE_POST_IT_CONTENT){
                                    a+="\nChange Post It Content";
                                    a+="\nNew Content " + action.oldContent();

                                }
                                if(action.action()== Action.CHANGE_POST_IT_PLACE){
                                    a+="\nChange Post It Place";
                                    a+="\nOld Row" + action.oldRow();
                                    a+="\nOld Column " + action.oldColumn();
                                    a+="\nNew Row" + action.newRow();
                                    a+="\nNew Column " + action.newColumn();

                                }
                            }
                            sOut.writeUTF(a);
                        }
                        break;
                    case VISUALIZE_BOARD:
                        sharedBoardTitle = sIn.readUTF();
                        synchronized (this) {
                            System.out.println("Showing the board actual aspect to client " + clientIP.getHostAddress());
                            try {
                                sharedBoard = sharedBoards.stream().findAny().filter(e -> e.title()
                                        .equals(sharedBoardTitle)).get();
                            } catch (NoSuchElementException ex) {
                                sharedBoard = findSharedBoardByTitleService.findSharedBoardByTitle(sharedBoardTitle);
                                sharedBoards.add(sharedBoard);
                            }
                        }
                        String aspect = sharedBoard.visualizeBoard();
                        sOut.writeUTF(aspect);
                        break;
                }

                sOut.writeUTF("");
            }
            catch(Exception e) {
                sOut.writeUTF(e.getMessage());
            }
        }

//        protected void authenticateForServer() {
//            authz(ElearningRoles.POWER_USER);
//            Invariants.ensure(authz.hasSession());
//        }

     }
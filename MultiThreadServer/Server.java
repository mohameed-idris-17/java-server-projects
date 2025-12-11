
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;





public class Server {
     
    public Consumer<Socket> getConsumer() {
        return (clientSocket) -> {
            try {
                 PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
                 toClient.println("hi, message from server Side");
                 toClient.close();
                 clientSocket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
               
        };
    } 
    
    public static void main(String[] args) {
        Server server = new Server();
        try {
             int port = 8080;
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("server is listening at "+port);
            while (true) { 
                Socket acceptSocket = serverSocket.accept();
                Thread thread = new Thread(() -> server.getConsumer().accept(acceptSocket));
                thread.start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       

    }
}
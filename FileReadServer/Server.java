
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {
     
    public Consumer<Socket> getConsumer() throws IOException{
        return (clientSocket) -> {
           
            try { 
                FileReader fileReader = new FileReader("java_full_stack_notes.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
                
                // Read and print file content line by line
                String line;
                System.out.println("=== File Content ===");
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);  // Print to server console
                    toClient.println(line);     // Send to client
                }
                System.out.println("=== End of File ===");
                
                bufferedReader.close();
                fileReader.close();
                toClient.close();
                clientSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } 
    };

    }
    public static void main(String[] args) {
        Server server = new Server();
        try {
            int port = 8080;
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(15000);
            System.out.println("Server is listening at "+port);
            while(true){
                Socket acceptSocket = serverSocket.accept();
                Thread thread = new Thread(()-> {
                    try {
                        server.getConsumer().accept(acceptSocket);
                    } catch (IOException ex) {
                    }
                });
                thread.start();


            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
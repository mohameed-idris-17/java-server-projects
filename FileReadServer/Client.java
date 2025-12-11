import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
public class Client {

    public Runnable getRunnable() throws IOException,UnknownHostException{
           return () -> {
               try {
                   int port = 8080;
                   InetAddress inetAddress = InetAddress.getByName("localhost");
                   Socket socket = new Socket(inetAddress,port);
                   PrintWriter toServer = new PrintWriter(socket.getOutputStream());
                   BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                   
                   // Read all lines from the server
                   String line;
                   System.out.println("=== Received from Server ===");
                   while ((line = fromServer.readLine()) != null) {
                       System.out.println(line);
                   }
                   System.out.println("=== End of Message ===");
                   
                   toServer.close();
                   fromServer.close();
                   socket.close();
               } catch (IOException ex) {
               }
           };
    }
   


    public static void main(String[] args) {
        Client client = new Client();
        try {
            for (int i =0 ; i < 100; i++){
            Thread thread = new Thread(client.getRunnable());
            thread.start();
        }
        } catch (Exception e) {
        }
        
            
        }
    
}
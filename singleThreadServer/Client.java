import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
public class Client {

    public void run() throws UnknownHostException, IOException {
        int port = 8081;
        InetAddress inetAddress = InetAddress.getByName("localhost");
        Socket socket = new Socket(inetAddress,port);
        PrintWriter toServer = new PrintWriter(socket.getOutputStream());
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toServer.println("From the Client side");
        toServer.flush();
        String message = fromServer.readLine();
        System.out.println("Response from the server side"+message);
       
        toServer.close();
        fromServer.close();
         socket.close();

    }
    public static void main(String[] args) throws IOException{
        Client client = new Client();
        client.run();
    }
}

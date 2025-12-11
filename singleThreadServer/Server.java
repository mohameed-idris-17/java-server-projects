import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public void run() throws IOException{
		int port = 8081;
		ServerSocket serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
		while (true) { 
			try {
				System.out.println("socket is listening at"+port);	
				Socket acceptedConnection = serverSocket.accept();
				System.out.println("connection is accepted "+ acceptedConnection.getRemoteSocketAddress());
				PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
				BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
				toClient.println("Hello, Message from Server");
				toClient.flush();
				
				toClient.close();
				fromClient.close();
				acceptedConnection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			

		}
	}



	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.run();
		
	}

}

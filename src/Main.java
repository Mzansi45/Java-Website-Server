import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	private static ServerSocket connection = null;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		connection = new ServerSocket(2022);
		
		while(true)
		{
			try
			{
				System.out.println("waiting for connection on port 2022");
				Socket socket = connection.accept();
				Server server = new Server(socket);
				server.start();
				
			}catch(IOException e)
			{
				e.printStackTrace();
			}

		}

	}

}

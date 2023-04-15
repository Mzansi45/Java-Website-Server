import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer{
	private ServerSocket connection = null;
	
	public MyServer()
	{
		try {
			connection = new ServerSocket(2023);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void runServer()
	{
		while(true)
		{
			System.out.println("Waiting for connection on port 2023");
			try {
				Socket socket = connection.accept();
				Thread thread = new Thread(new ServerHandler(socket));
				
				thread.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}



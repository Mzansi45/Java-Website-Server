import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ServerHandler implements Runnable{
	private Socket socket = null;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;

	public ServerHandler(Socket socket) {
	    this.socket = socket;
	}

	@Override
	public void run() {
	    try {
	        dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
	        dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

	        byte[] data = new byte[dis.available()];
	        dis.read(data);

	        String message = new String(data);

	        String response = "";
	        
	        if(message.startsWith("OPTIONS"))
	        {
	        	response = "HTTP/1.1 200 OK\r\n"
	        			+ "Access-Control-Allow-Origin: *\r\n"
	        			+ "Access-Control-Allow-Methods: GET, POST, PUT, DELETE\r\n"
	        			+ "Access-Control-Allow-Headers: Content-Type, Authorization\r\n"
	        			+ "Access-Control-Allow-Credentials: true\r\n"
	        			+ "Access-Control-Max-Age: 86400\r\n"
	        			+ "";
	        	dos.write(response.getBytes());
	            dos.flush();
	        }else if(message.startsWith("POST"))
	        {
	            String msg = new String(extractContentFromPOST(message));
	            System.out.println("The message: " + msg);
	            
	            String responseMsg = "{\"message\":\"yah this actually works\"}";
	            String responseHeader = "HTTP/1.1 200 OK\r\n" +
	                                    "Access-Control-Allow-Origin: *\r\n" +
	                                    "Content-Type: application/json\r\n" +
	                                    "Content-Length: " + responseMsg.length() + "\r\n" +
	                                    "Connection: close\r\n" +
	                                    "\r\n";
	            
	            dos.write(responseHeader.getBytes());
	            dos.write(responseMsg.getBytes());
	            dos.flush();
	        }
	        else if(message.startsWith("GET"))
	        {
	        	GETHandler handleGet = new GETHandler(message,dos);
	        	handleGet.handleMessage();
	        }
	        else
	        {
	        	System.out.println(message);
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            socket.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	public static byte[] extractContentFromPOST(String postString) {
	    String[] parts = postString.split("\r\n\r\n");
	    if (parts.length == 2) {
	        return parts[1].getBytes();
	    }
	    return new byte[0];
	}



}

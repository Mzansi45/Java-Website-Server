import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringTokenizer;

public class GETHandler {
	private String message;
	private DataOutputStream dos = null;
	
	public GETHandler(String message,DataOutputStream dos)
	{
		this.message = message;
		this.dos = dos;
	}
	
	public void handleMessage()
	{
		String input = message;

		StringTokenizer token = new StringTokenizer(input);
		
		String first = token.nextToken();
		
		//handle HTTP requests
		if(first.equals("GET"))	
		{
			String filename = token.nextToken();
			filename = filename.substring(1);
			
			File file = new File("data",filename);
			Writter(file, dos);
		}
	}
	
	private void Writter(File file, DataOutputStream output)
	{	
		/// in case the file requested does not exist we serve a 404 error
		if(!file.exists())
		{
			file = new File("data","error404.html");
		}
	
		//write bytes to the data output stream
		try {
			// this function handles requests with different file extensions
			handleFileExtensions(file, output);
			
			//read file into memory and write it out to the client
			BufferedInputStream inputFile = new BufferedInputStream(new FileInputStream(file));
			
			//write bytes to stream
			while(inputFile.available()>0)
			{
				output.write(inputFile.readAllBytes());
			}
			
			output.writeBytes("\r\n");
			output.flush();
			
			inputFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void handleFileExtensions(File file,DataOutputStream dos)
	{
		try {
			// determine type of file and server its content correctly
			String filename = file.getName();
				
				if(filename.endsWith("mp4"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: video/mp4\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("mp3"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: audio/mpeg\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("mv4"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: video/m4v\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("eot"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: application/vnd.ms-fontobject\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("pdf"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: application/pdf\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("png"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: image/png\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("jpg"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: image/jpg\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("html"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: text/html\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("js"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: application/javascript\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("svg"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: image/svg+xml\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("scss"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: text/scss\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("css"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: text/css\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("ttf"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: font/ttf\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("woff2"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: font/woff2\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("woff"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: font/woff\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("php"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: application/x-httpd-php\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("gif"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: image/gif\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("xml"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: application/xml\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("webm"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: video/webm\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("ppt"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: application/vnd.ms-powerpoint\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("json"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: application/json\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("doc"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: application/msword\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("ico"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: image/vnd.microsoft.icon\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
				else if(filename.endsWith("m4a"))
				{
					dos.writeBytes("HTTP/1.1 200 OK \r\n");
					dos.writeBytes("Connection: close \r\n");
					dos.writeBytes("Content-Type: audio/m4a\r\n");
					dos.writeBytes("Content-Length:"+ file.length()+"\r\n");
					dos.writeBytes("\r\n");
				}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}

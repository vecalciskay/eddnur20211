package red;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorImitador {
	public static final int PUERTO = 6849;
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket srv = new ServerSocket(PUERTO);
		Socket cltSocket = srv.accept();
		
		PrintWriter out = new PrintWriter(cltSocket.getOutputStream());
		out.flush();
		
		BufferedReader inReader = 
				new BufferedReader(new InputStreamReader(cltSocket.getInputStream()));
		
		while(!cltSocket.isClosed()) {
			// Recibe
			String solicitud = inReader.readLine();
			if (solicitud == null)
				break;
			System.out.println("Recibe de cliente: " + solicitud);
			// Envia
			out.println("[Respondido: " + solicitud + "]");
			out.flush();
		}
		
		inReader.close();
		out.close();
		cltSocket.close();
		srv.close();
	}
}

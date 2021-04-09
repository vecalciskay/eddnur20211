package red;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Imitador {
	
	public static final int PUERTO = 6849;

	public static void main(String[] args) throws IOException {
		
		ServerSocket srv = new ServerSocket(PUERTO);
		Socket cltSocket = srv.accept();
		
		PrintWriter out = new PrintWriter(cltSocket.getOutputStream());
		out.println("HOLA");
		out.flush();
		
		BufferedReader inReader = new BufferedReader(new InputStreamReader(cltSocket.getInputStream()));
		
		String linea = inReader.readLine();
		
		while(!linea.equals("FIN")) {
			out.println("Imitando: " + linea);
			out.flush();
			
			linea = inReader.readLine();
		}
		inReader.close();
		out.close();
		cltSocket.close();
		srv.close();
	}
}

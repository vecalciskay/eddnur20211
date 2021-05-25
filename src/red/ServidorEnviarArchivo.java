package red;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.stream.FileImageOutputStream;

public class ServidorEnviarArchivo {
	public static final int PUERTO = 6849;
	public static void main(String[] args) throws IOException {
		ServerSocket srv = new ServerSocket(PUERTO);
		
		System.out.println("Esperando cliente");
		Socket cltSocket = srv.accept();

		System.out.println("Cliente conectado");
		OutputStream outputstreamSocket = cltSocket.getOutputStream();

		byte[] bytesArchivo = Files.readAllBytes(Paths.get("e:/temp/powerbike.png"));
		
		PrintWriter out = new PrintWriter(cltSocket.getOutputStream());
		out.println("ENVIAR powerbike.png " + bytesArchivo.length);
		out.flush();
		System.out.println("Mensaje para enviar archivo");

		BufferedReader inReader = new BufferedReader(new InputStreamReader(cltSocket.getInputStream()));

		String linea = inReader.readLine();
		
		if (!linea.equals("OK")) {
			System.out.println("ERROR");
			inReader.close();
			out.close();
			cltSocket.close();
			srv.close();
			System.exit(0);
		}
		System.out.println("Cliente listo para recibir");
		
		int inicio = 0;
		int bufsize = 4096;
		int left = bytesArchivo.length;
		
		while(left > 0) {
			if (left < bufsize)
				bufsize = left;
			
			System.out.println("Enviando " + bufsize + " bytes");
			outputstreamSocket.write(bytesArchivo, inicio, bufsize);
			outputstreamSocket.flush();
			
			left -= bufsize;
			inicio += bufsize;
		}
		System.out.println("Archivo enviado");
		
		linea = inReader.readLine();

		while (!linea.equals("FIN")) {
			out.println("Error: " + linea);
			out.flush();

			linea = inReader.readLine();
		}
		
		System.out.println("Se envio todo y el cliente respondio bien.");
		
		outputstreamSocket.close();
		inReader.close();
		out.close();
		cltSocket.close();
		srv.close();
	}
}

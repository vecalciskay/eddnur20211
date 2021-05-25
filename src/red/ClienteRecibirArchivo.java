package red;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ClienteRecibirArchivo {
	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket cltSocket = new Socket("127.0.0.1", ServidorEnviarArchivo.PUERTO);
		System.out.println("Conectado al servidor");
		
		PrintWriter out = new PrintWriter(cltSocket.getOutputStream());
		out.flush();
		
		InputStream inputstreamSocket = cltSocket.getInputStream();
		BufferedReader inReader = 
				new BufferedReader(new InputStreamReader(cltSocket.getInputStream()));
		
		String entrada = inReader.readLine();
		
		if (!entrada.startsWith("ENVIAR")) {
			inReader.close();
			out.close();
			cltSocket.close();
			System.exit(0);
		}
		
		String[] entradaStrings = entrada.split(" ");
		int cantidadBytes = Integer.parseInt(entradaStrings[2]);
		System.out.println("Listo para recibir archivo " + entradaStrings[1]);
		
		out.println("OK");
		out.flush();
		
		ByteArrayOutputStream archivoStream = new ByteArrayOutputStream(cantidadBytes);
		byte[] bytesBuffer = null;
		
		int inicio = 0;
		
		while(inputstreamSocket.available() == 0) {;}
		
		int available = inputstreamSocket.available();
		System.out.println("Dice que hay " + available + " bytes para leer");
		while(available > 0) { 
			bytesBuffer = inputstreamSocket.readNBytes(available);
			System.out.println("Leyo parcialmente " + available + " bytes");
			
			archivoStream.write(bytesBuffer);
			System.out.println("Copio esos bytes a archivo de bytes");
			inicio += available;
			
			available = inputstreamSocket.available();
		}
		archivoStream.flush();
		
		byte[] archivo = archivoStream.toByteArray();
		archivoStream.close();
		
		Files.write(Paths.get("e:/temp/basura1111.png"), archivo);
		System.out.println("Recibio " + archivo.length + " bytes del archivo y escribio en disco");
		
		out.println("FIN");
		out.flush();
		
		inputstreamSocket.close();
		inReader.close();
		out.close();
		cltSocket.close();
	}
}

package daoaf.conexion;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.sql.ResultSet;

import com.google.gson.Gson;
import daoaf.dto.Perro;
import listas.oficial.Lista;

public class ConexionJson extends Conexion {

	public static String PATH_ARCHIVO = "E:/temp/db.json"; 
	
	private String archivo;
	
	public ConexionJson() {
		archivo = PATH_ARCHIVO;
	}
	
	@Override
	public Lista<Perro> ejecutarConsultaPerro(String query) throws Exception {
		return getListaPerros();
	}

	@Override
	public void ejecutarComando(String cmd, String query) throws Exception {
		// Serialization
		Gson gson = new Gson();
				
		if (cmd.startsWith("INSERT")) {
			String objPerro = query;
			Perro obj = gson.fromJson(objPerro, Perro.class);
			
			Lista<Perro> lista = getListaPerros();
			
			lista.add(obj);
			
			guardaListaPerros(lista);
		}
	}

	private void guardaListaPerros(Lista<Perro> lista) throws IOException {

		Gson gson = new Gson();
		
		String jsonString = gson.toJson(arrayPerro(lista)); 
		
		Files.write(Paths.get(archivo), jsonString.getBytes());
	}

	private Perro[] arrayPerro(Lista<Perro> lista) {
		Perro[] arreglo = new Perro[lista.tamano()];
		int i = 0;
		for (Perro persona : lista) {
			arreglo[i] = persona;
			i++;
		}
		
		return arreglo;
	}

	private Lista<Perro> getListaPerros() throws IOException {
		Gson gson = new Gson();
		byte[] encoded = Files.readAllBytes(Paths.get(archivo));
		String allDb = new String(encoded, StandardCharsets.UTF_8); 
		
		Perro[] ppp = gson.fromJson(allDb, Perro[].class);
		
		Lista<Perro> lista = new Lista<Perro>();
		for (int i = 0; i < ppp.length; i++) {
			lista.add(ppp[i]);
		}
		
		return lista;
	}

	@Override
	public void cerrarConexion() {
		// TODO Auto-generated method stub
		
	}

}

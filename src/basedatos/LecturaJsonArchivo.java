package basedatos;

import com.google.gson.Gson;

import basedatos.dao.DTOpersona;
import listas.oficial.Lista;

public class LecturaJsonArchivo {
	public static void main(String[] args) {
		// Serialization
		Gson gson = new Gson();
		
		DTOpersona persona  =new DTOpersona(4,"Gabriel");
		System.out.println(gson.toJson(persona));
		
		Lista<DTOpersona> lista = new Lista<DTOpersona>();
		lista.add(new DTOpersona(1,"Hugo"));
		lista.add(new DTOpersona(2,"Paco"));
		lista.add(new DTOpersona(3,"Luis"));
		
		System.out.println(gson.toJson(arrayPersona(lista)));
		
		/*
		 * {"id":4,"nombre":"Gabriel"}
		 * [{"id":1,"nombre":"Hugo"},{"id":2,"nombre":"Paco"},{"id":3,"nombre":"Luis"}]
		 */
		String unobjeto = "{\"id\":4,\"nombre\":\"Gabriel\"}";
		DTOpersona p = gson.fromJson(unobjeto, persona.getClass());
		System.out.println(p);
		
		String variosobjeto = "[{\"id\":1,\"nombre\":\"Hugo\"},{\"id\":2,\"nombre\":\"Paco\"},{\"id\":3,\"nombre\":\"Luis\"}]";
		DTOpersona[] ppp = gson.fromJson(variosobjeto, DTOpersona[].class);
		System.out.println(toListaPersona(ppp));
	}
	
	private static Lista<DTOpersona> toListaPersona(DTOpersona[] ppp) {
		Lista<DTOpersona> lista = new Lista<>();
		for (int i = 0; i < ppp.length; i++) {
			lista.add(ppp[i]);
		}
		return lista;
	}

	public static DTOpersona[] arrayPersona(Lista<DTOpersona> lista) {
		DTOpersona[] arreglo = new DTOpersona[lista.tamano()];
		int i = 0;
		for (DTOpersona persona : lista) {
			arreglo[i] = persona;
			i++;
		}
		
		return arreglo;
	}
}

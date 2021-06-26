package basedatos;

import basedatos.dao.DAOpersona;
import basedatos.dao.DTOpersona;
import listas.oficial.Lista;

public class ConexionConDao {
	public static void main(String[] args) {

		DAOpersona dao = new DAOpersona();
		
		// SELECTS
		Lista<DTOpersona> personas = dao.getTodos();		
		for (DTOpersona p : personas) {
			System.out.println(p);
		}
		
		// CRUD
		DTOpersona h = dao.getPorId(1);
		System.out.println(h);
		h.setNombre("huguito");
		dao.actualizar(h);
	}
}

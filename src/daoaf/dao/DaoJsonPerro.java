package daoaf.dao;

import com.google.gson.Gson;

import daoaf.conexion.Conexion;
import daoaf.dto.Perro;
import listas.oficial.Lista;

public class DaoJsonPerro extends DaoPerro {

	@Override
	public Lista<Perro> getTodos() {
		Conexion conexion = Conexion.getOrCreate();
		
		Lista<Perro> lista = null;
		try {
			lista = conexion.ejecutarConsultaPerro("");
		} catch (Exception e) {
			lista = null;
		}
		
		return lista;
	}

	@Override
	public void insertar(Perro obj) throws Exception {
		Conexion conexion = Conexion.getOrCreate();
		
		Gson gson = new Gson();
		
		conexion.ejecutarComando("INSERT", gson.toJson(obj));
	}

}

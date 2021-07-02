package daoaf.conexion;

import java.sql.ResultSet;

import daoaf.dto.Perro;
import listas.oficial.Lista;

public abstract class Conexion implements IConexion {

	private static Conexion instancia = null;
	
	public static Conexion getOrCreate() {
		if (instancia == null)
			instancia = new ConexionJson(); // Aqui el unico lugar donde se cambia
		return instancia;
	}
	
	public ResultSet ejecutarConsulta(String query) throws Exception {
		return null;
	}
	
	public Lista<Perro> ejecutarConsultaPerro(String query) throws Exception {
		return new Lista<Perro>();
	}
	@Override
	public void ejecutarComando(String query) throws Exception {
		
	}
	@Override
	public void ejecutarComando(String cmd, String query) throws Exception {
	
	}
	
	@Override
	public void cerrarConexion() {
		
	}
}

package daoaf.conexion;

import java.sql.ResultSet;

public interface IConexion {
	public ResultSet ejecutarConsulta(String query) throws Exception;
	public listas.oficial.Lista<daoaf.dto.Perro> ejecutarConsultaPerro(String query) throws Exception;
	public void ejecutarComando(String query) throws Exception;
	public void ejecutarComando(String cmd,String query) throws Exception;
	public void cerrarConexion();
}

package daoaf.dao;

import daoaf.dto.Perro;
import listas.oficial.Lista;

public abstract class DaoPerro {

	public abstract Lista<Perro> getTodos();
	public abstract void insertar(Perro obj) throws Exception;
	
}

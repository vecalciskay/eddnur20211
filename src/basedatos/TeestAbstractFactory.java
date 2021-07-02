package basedatos;

import daoaf.dao.DaoPerro;
import daoaf.dao.FactoryDao;
import daoaf.dto.Perro;

/**
 * Tiene que tener un archivo con el string que representa un arreglo json vacio: []
 * en la carpeta de DaoJson 
 * @author Vladimir
 *
 */
public class TeestAbstractFactory {
	public static void main(String[] args) {
		Perro perro = new Perro(1, "Hugo Guau");
		FactoryDao factoryDao = FactoryDao.getOrCreate();
		DaoPerro daoPerro = factoryDao.getDaoPerro();
		try {
			daoPerro.insertar(perro);
		} catch (Exception e) {
			System.out.println("No pudo insertart perro: " + e.getMessage());
		}
	}
}

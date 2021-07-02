package daoaf.dao;

public abstract class FactoryDao {

	private static FactoryDao instance = null;
	
	public static FactoryDao getOrCreate() {
		if (instance == null)
			instance = new FactoryDaoJson(); // Este es el unico otro lugar donde se cambia el codigo
		
		return instance;
	}
	
	public abstract DaoPerro getDaoPerro();
}

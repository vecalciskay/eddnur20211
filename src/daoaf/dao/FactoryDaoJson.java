package daoaf.dao;

public class FactoryDaoJson extends FactoryDao {

	public FactoryDaoJson() {
		
	}
	
	@Override
	public DaoPerro getDaoPerro() {
		return new DaoJsonPerro();
	}

}

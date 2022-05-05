package misl.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import misl.dao.impl.DAO;
import misl.spring.model.StudentModel;
import misl.spring.model.extra.ResultMap;

public class StudentDAO implements DAO<StudentModel> {

	@Override
	public int Add(StudentModel bean) throws SQLException   {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Delete(StudentModel bean)throws SQLException  {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Update(StudentModel bean)throws SQLException  {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<StudentModel> FindAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentModel FindByID(StudentModel bean) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentModel MappingBeans(ResultMap map) throws SQLException  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentModel FindByID(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentModel FindByUUID(String uuid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}

package misl.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import misl.spring.model.extra.ResultMap;

public interface DAO<T>{
	int Add (T bean) throws SQLException;
	int Delete(T bean) throws SQLException;
	int Update(T bean) throws SQLException;
	ArrayList<T> FindAll() throws SQLException;
	T FindByID(T bean) throws SQLException;
	T FindByID(int id) throws SQLException;
	T FindByUUID(String uuid) throws SQLException;
	T MappingBeans(ResultMap map) throws SQLException;
}

package misl.dao.impl;

import java.util.ArrayList;
import misl.spring.model.extra.ResultMap;

public interface DAOView<T>{
	ArrayList<T> FindAll();
	T MappingBeans(ResultMap map);
}

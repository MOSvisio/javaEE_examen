package org.exam.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IDao<T> {
	
	void create(T object);
	void update(T object);
	void delete(T object);
	T read(String numero);
	ArrayList<T> getAll();
	
}

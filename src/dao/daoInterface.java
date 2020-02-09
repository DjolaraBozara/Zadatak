package dao;

import java.util.List;
import java.util.Optional;

import exceptions.DataAlreadyExists;
import exceptions.DataNotFoundException;

public interface DaoInterface<T> {

	public void add(T t) throws  DataAlreadyExists;
	public void delete(T t) throws DataNotFoundException;
	public void izmeni(T t) throws DataNotFoundException;
	public Optional<T> returnOne(T t);
	public List<T> returnAll();
	public void printAll();
	
}

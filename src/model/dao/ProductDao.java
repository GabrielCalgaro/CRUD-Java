package model.dao;

import java.util.List;

import model.entities.Category;
import model.entities.Product;

public interface ProductDao {

	void insert(Product obj);
	void update(Product obj);
	void deleteById(Integer id);
	void deleteByName(String name);
	Product findById(Integer id);
	List<Product> findAllByName();
	List<Product> findAllByQuantity();
	List<Product> findMaxAndMinByQuantity();
	List<Product> findByCategory(Category category);
}
package application;

import java.sql.Connection;
import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.ProductDao;
import model.entities.Category;
import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		ProductDao productDao = DaoFactory.createProductDao();

		System.out.println("== TEST 1: product findById ==");
		Product product = productDao.findById(3);
		System.out.println(product);
		
		System.out.println("\n== TEST 2: product findByCategory ==");
		Category category = new Category(2,null);
		List<Product> list = productDao.findByCategory(category);
		for(Product obj : list) {
			System.out.println(obj);
		}
	}

}

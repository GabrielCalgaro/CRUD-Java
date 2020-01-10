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
		Category category = new Category(3,null);
		List<Product> list = productDao.findByCategory(category);
		for(Product obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n== TEST 3: product findByAll ==");
		list = productDao.findAll();
		for(Product obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n== TEST 4: product insert ==");
		Product newProduct = new Product(null,"Silmarillion", 50.0, 1, category);
		productDao.insert(newProduct);
		System.out.println("INSERTED!! New id = " + newProduct.getId());
		
		System.out.println("\n== TEST 5: product update ==");
		product = productDao.findById(1);
		product.setName("Smartphone");
		productDao.update(product);
		System.out.println("UPDATE COMPLETED");
	}

}

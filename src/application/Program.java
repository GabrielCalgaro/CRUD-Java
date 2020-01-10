package application;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.ProductDao;
import model.entities.Category;
import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ProductDao productDao = DaoFactory.createProductDao();

		System.out.println("== TEST 1: product findById ==");
		Product product = productDao.findById(3);
		System.out.println(product);
		
		System.out.println("\n== TEST 2: product findByCategory ==");
		System.out.println("Digite o id da categoria dos produtos a serem listados:");
		int catId = sc.nextInt();
		Category category = new Category(catId,null);
		List<Product> list = productDao.findByCategory(category);
		for(Product obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n== TEST 3: product findAllByName==");
		list = productDao.findAllByName();
		for(Product obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n== TEST 4: product findAllByQuantity==");
		list = productDao.findAllByQuantity();
		for(Product obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n== TEST 5: product findMaxAndMinByQuantity==");
		list = productDao.findMaxAndMinByQuantity();
		for(Product obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n== TEST 6: product insert ==");
		Product newProduct = new Product(null,"Silmarillion", 50.0, 1, category);
		productDao.insert(newProduct);
		System.out.println("INSERTED!! New id = " + newProduct.getId());
		
		System.out.println("\n== TEST 7: product update ==");
		product = productDao.findById(1);
		product.setName("Smartphone");
		productDao.update(product);
		System.out.println("UPDATE COMPLETED");
		
		System.out.println("\n== TEST 8: product delete ==");
		System.out.println("Digite o id do produto a ser excluido:");
		int id = sc.nextInt();
		productDao.deleteById(id);
		System.out.println("DELETE COMPLETED");
		
		System.out.println("\n== TEST 9: product delete by name==");
		System.out.println("Digite o nome do produto a ser excluido:");
		String name = sc.next();
		productDao.deleteByName(name);
		System.out.println("DELETE COMPLETED");
		
		sc.close();
	}

}

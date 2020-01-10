package application;

import java.sql.Connection;

import db.DB;
import model.entities.Category;
import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Category obj = new Category(1,"book");
		
		Product product = new Product(4, "lotr", 10, 50.0, obj);
		System.out.println(product);
	}

}

package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Statement;

import db.DB;
import db.DbException;
import model.dao.ProductDao;
import model.entities.Category;
import model.entities.Product;


public class ProductDaoJDBC implements ProductDao{
	
	private Connection conn;
	
	public ProductDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Product obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Product obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT product.*,category.Name as CatName "
					+"FROM product INNER JOIN category "
					+"ON product.CategoryId = category.Id "
					+"WHERE product.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Category cat = instantiateCategory(rs);
				Product obj = instantiateProduct(rs, cat);
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Product instantiateProduct(ResultSet rs, Category cat) throws SQLException {
		Product obj = new Product();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setPrice(rs.getDouble("Price"));
		obj.setId(rs.getInt("Quantity"));
		obj.setCategory(cat);
		return obj;
	}

	private Category instantiateCategory(ResultSet rs) throws SQLException {
		Category cat = new Category();
		cat.setId(rs.getInt("CategoryId"));
		cat.setName(rs.getString("CatName"));
		return cat;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
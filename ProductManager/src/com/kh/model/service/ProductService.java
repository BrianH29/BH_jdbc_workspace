package com.kh.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.model.dao.ProductDao;
import com.kh.model.vo.Product; 

public class ProductService {

	public ArrayList<Product> printList() {
		
		Connection conn = getConnection(); 
		ArrayList<Product> list = new ProductDao().printList(conn); 
		
		close(conn); 
		return list; 
	}//e.printlist
	
	public int addProduct(Product p) {
		Connection conn = getConnection(); 
		int result = new ProductDao().addProduct(conn,p);
		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn); 
		}
		close(conn);
		return result; 
		
	}//e.addproduct
	
	public int updateProduct(Product p) {
		Connection conn = getConnection(); 
		int result = new ProductDao().updateProduct(conn, p);
		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result; 
		
	}//e.updateProduct
	
	public int deleteProduct(String userId) {
		Connection conn = getConnection();
		int result = new ProductDao().deleteProduct(conn, userId);
		
		if(result > 0) {
			commit(conn); 
		}else {
			rollback(conn);
		}
		
		close(conn); 
		return result; 
		
	}//e.deleteProduct	
	
	public ArrayList<Product> searchProduct(String userId) {
		Connection conn = getConnection(); 
		ArrayList<Product> list = new ProductDao().searchProduct(conn,userId);
		
		close(conn);
		return list; 
	}
}









package com.kh.model.dao;

import static com.kh.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Product;
import com.kh.model.vo.ProductIO;

public class ProductDao {

	private Properties prop = new Properties();

	public ProductDao() { // constructor을 통해서 파일에있는 내용을 가져온다.
		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//e.productdao

	public ArrayList<Product> printList(Connection conn) {
		ArrayList<Product> list = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("printList");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery(); 
			
			while(rset.next()) {
				list.add(new Product(rset.getString("PRODUCT_ID"),
									 rset.getString("P_NAME"),
									 rset.getInt("PRICE"),
									 rset.getString("DESCRIPTION"),
									 rset.getInt("STOCK")
									 ));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}//e.printlist
	
	public int addProduct(Connection conn, Product p) {
		int result = 0; 
		PreparedStatement pstmt = null; 
		
		String sql = prop.getProperty("addProduct"); 
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getProductId());
			pstmt.setString(2, p.getpName());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getDescription());
			pstmt.setInt(4, p.getPrice());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}//e.addproduct
	
	public int updateProduct(Connection conn, Product p) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,p.getpName());
			pstmt.setInt(2,p.getPrice());
			pstmt.setString(3, p.getDescription());
			pstmt.setInt(4, p.getStock());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result; 
	}//e.updateProduct
	
	public int deleteProduct(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result; 
		
	}//e.deleteProduct

	public ArrayList<Product> searchProduct(Connection conn, String userId) {
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
	
			if(rset.next()) {
				list.add(new Product(rset.getString("PRODUCT_ID"),
									 rset.getString("P_NAME"),
									 rset.getInt("PRICE"),
									 rset.getString("DESCRIPTION"),
									 rset.getInt("STOCK")
									 ));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list; 
		
	}//e.searchProduct
	
	public ArrayList<ProductIO> fullList(Connection conn) {
		ArrayList<ProductIO> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		
		String sql = prop.getProperty("fullList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new ProductIO(rset.getInt("IO_NUM"),
									   rset.getString("PRODUCT_ID"),
									   rset.getString("P_NAME"),
									   rset.getDate("IO_DATE"),
									   rset.getInt("AMOUNT"),
									   rset.getString("STATUS")
									   ));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list; 
		
	}//e.fullList
	
	public ArrayList<ProductIO> warehouseList(Connection conn) {
		ArrayList<ProductIO> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		
		String sql=prop.getProperty("warehouseList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new ProductIO(rset.getInt("IO_NUM"),
									   rset.getString("PRODUCT_ID"),
									   rset.getString("P_NAME"),
									   rset.getDate("IO_DATE"),
									   rset.getInt("AMOUNT"),
									   rset.getString("STATUS")
									   ));
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close(); 
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list; 	
				
		
	}//e.warehouseList
	
	public ArrayList<ProductIO> unstoreList(Connection conn) {
		ArrayList<ProductIO> list = new ArrayList<>();
		
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		String sql = prop.getProperty("unstoreList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new ProductIO(rset.getInt("IO_NUM"),
									   rset.getString("PRODUCT_ID"),
									   rset.getString("P_NAME"),
									   rset.getDate("IO_DATE"),
									   rset.getInt("AMOUNT"),
									   rset.getString("STATUS")
									   ));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list; 
	}//e.unstoringlist
	
	public int warehousePro(Connection conn, ProductIO p) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("warehousePro");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getProductId());
			pstmt.setInt(2,p.getAmount());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result; 
		
	}//e.warehousePro
	
	public int unstorePro(Connection conn, ProductIO p) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("unstorePro");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getProductId());
			pstmt.setInt(2, p.getAmount());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return result; 
		
	}//e.unstorePro
}






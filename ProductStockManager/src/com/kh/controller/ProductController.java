package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.ProductService;
import com.kh.model.vo.Product;
import com.kh.model.vo.ProductIO;
import com.kh.view.ProductMenu;

public class ProductController {
	
	public void printList() {
		ArrayList<Product> list = new ProductService().printList(); 
		
		if(list.isEmpty()) {
			new ProductMenu().displayNoData("조회된 결과가 없습니다.");
		}else {
			new ProductMenu().displayProductList(list);
		}
		
	}// e.printlist
	
	public void addProduct(Product p) {
		int result = new ProductService().addProduct(p);
		
		if(result>0) {	// 성공
			new ProductMenu().displaySuccess("상품추가 성고했습니다.");
		}else {//실패 
			new ProductMenu().displayFail("상품추가 실패했습니다.");
		}
	}// e.addproduct
	
	public void updateProduct(Product p) {
		int result = new ProductService().updateProduct(p); 
		
		if(result >0) {
			new ProductMenu().displaySuccess("업데이트 성공했습니다.");
		}else {
			new ProductMenu().displayFail("엡데이트 실패했습니다.");
		}
	}//e.updateProduct
	
	public void deleteProduct(String userId) {
		int result = new ProductService().deleteProduct(userId); 
		
		if(result >0) {
			new ProductMenu().displaySuccess("삭제 성공했습니다.");
		} else {
			new ProductMenu().displayFail("삭제 실패했습니다.");
		}
	}//e.deleteProduct
	
	public void searchProduct(String userId) {
		ArrayList<Product> list = new ProductService().searchProduct(userId);
		
		if(list.isEmpty()) {
			new ProductMenu().displayNoData("검색하신 제품 정보가 없습니다");
		}else {
			new ProductMenu().displayProductList(list);
		}
			
	}//e.searchProduct
	
	public void fullList() {
		ArrayList<ProductIO> list = new ProductService().fullList(); 
		
		if(list.isEmpty()) {
			new ProductMenu().displayNoData("조회된 결과가 없습니다.");
		}else {
			new ProductMenu().displayProList(list);
			
		}
	}//e.fullList
	
	public void warehouseList() {
		ArrayList<ProductIO> list = new ProductService().warehouseList();
		
		if(list.isEmpty()) {
			new ProductMenu().displayNoData("조회된 결과가 없습니다.");
		}else {
			new ProductMenu().displayProList(list);
		}
	}//e.warehouseList
	
	public void unstoreList() {
		ArrayList<ProductIO> list = new ProductService().unstoreList();
		
		if(list.isEmpty()) {
			new ProductMenu().displayNoData("조회된 결과가 없습니다.");
		}else {
			new ProductMenu().displayProList(list); 
		}
		
	}// e.unstoringlist
	
	public void warehousePro(ProductIO p) {
		int result = new ProductService().warehousePro(p);
		
		if(result>0) {
			new ProductMenu().displaySuccess("성공적으로 입고하였습니다.\n");
		} else {
			new ProductMenu().displayFail("입고 실패했습니다\n");
		}

	}//e.warehousePro
	
	public void unstorePro(ProductIO p) {
		int result = new ProductService().unstorePro(p);
		
		if(result>0) {
			new ProductMenu().displaySuccess("성공적으로 출고하였습니다.\n");
		}else {
			new ProductMenu().displayFail("출고 실패했습니다.");
		}
		
	}//e.unstorePro
	
	

}

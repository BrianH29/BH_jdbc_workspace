package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.ProductController;
import com.kh.model.vo.Product;

public class ProductMenu {
	
	private Scanner sc = new Scanner(System.in);
	ProductController pc = new ProductController(); 
	public void mainMenu() {
		
		int menu;
		while(true) {
		System.out.println("\n=====프로덕트 관리 프로그램======");
		System.out.println("1. 상품 조회 하기");
		System.out.println("2. 상품 추가 하기");
		System.out.println("3. 상품 수정 하기");
		System.out.println("4. 상품 삭제 하기");
		System.out.println("5. 상품 검색 하기");
		System.out.println("0. 프로그램 종료하기");
		System.out.print("메뉴 선택 하세요:");
		menu = sc.nextInt(); 
		sc.nextLine(); 
		
		switch(menu) {
		case 1 : pc.printList(); break;
		case 2 : addProduct(); break;
		case 3 : updateProduct(); break;
		case 4 : pc.deleteProduct(inputProId()); break;
		case 5 : pc.searchProduct(inputProId()); break;
		case 0 : System.out.print("프로그램 종료하시겠습니까(y/n)?");
		         if(sc.nextLine().toUpperCase().charAt(0) == 'Y') {
		        	 System.out.println("종료합니다."); return;
		         } else {
		        	 break; 
		         }
		default : System.out.println("번호를 다시 입력해주세요");
		
			
		}//e.switch
		
		} //e.loop
		
	} //e.mainMenu 
	
	
	public String inputProId() {
		System.out.print("상품 아이디:"); // 아이디로 검색 
		return sc.nextLine(); 
	}
	
	
	public void addProduct() {
		
		System.out.println("\n===상품 추가===");
		Product p = new Product(); 
		
		p.setProductId(inputProId());
		
		System.out.print("추가 상품명: ");
		p.setpName(sc.nextLine());
		
		System.out.print("추가 상품가격: ");
		p.setPrice(sc.nextInt());
		sc.nextLine(); 
		
		System.out.print("추가 상품상세정보: ");
		p.setDescription(sc.nextLine());
		
		System.out.print("추가 재고수량: ");
		p.setStock(sc.nextInt());
		sc.nextLine();
		
		pc.addProduct(p); 
		
	}
	public void updateProduct() {
		System.out.println("\n====상품 정보 수정====");
		
		Product p = new Product();
		p.setProductId(inputProId());
		
		System.out.print("상품명 수정: " );
		p.setpName(sc.nextLine());
		
		System.out.print("가격 수정: ");
		p.setPrice(sc.nextInt());
		sc.nextLine(); 
		
		System.out.print("상세정보 수정: ");
		p.setDescription(sc.nextLine());
		
		System.out.print("재고 수정: ");
		p.setStock(sc.nextInt());
		sc.nextLine();
		
		pc.updateProduct(p); 
		
	}//e.updateProduct
	
	
	public void displayNoData(String message) {
		System.out.println("\n" + message);
	}
	
	public void displayProductList(ArrayList<Product> list) {
		System.out.println("\n조회 결과: ");
		for(Product p : list) {
			System.out.println(p);
		}
		
	}
	
	public void displaySuccess(String message) {
		System.out.println(message);
	}
	
	public void displayFail(String message) {
		System.out.println(message);
	}
}

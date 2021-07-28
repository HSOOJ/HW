package com.ssafy.hw07;

import java.util.List;
import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgrImpl product = new ProductMgrImpl();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("# 전체 상품 목록");
		List<Product> p0 = product.searchAll();
		for (int i = 0; i < p0.size(); i++) { 
			System.out.println(p0.get(i));
		} System.out.println();
		
		
		System.out.println("# 상품 검색\n  (상품번호 : TV1)");
		System.out.println(product.serNumSearch("TV1"));
		
		System.out.println("# 상품명으로 검색\n  (상품명 : QLED 8K");
		System.out.println(product.nameSearch("QLED 8K"));
		System.out.println("# 상품명으로 검색\n  (상품명 : 4도어");
		System.out.println(product.nameSearch("4도어"));
		
		System.out.println("# TV 검색");
		System.out.println(product.TV());
		
		System.out.println("# 냉장고 검색");
		System.out.println(product.Refrigerator());
		
		System.out.println("# 400L이상 냉장고");
		System.out.println(product.R400());

		System.out.println("# 50인치이상 TV");
		System.out.println(product.T50());
		
		System.out.print("# 변경할 상품의 상품번호 입력 : ");
		String updateSerNum = sc.next();
		System.out.print("  변경할 상품 가격 입력 : ");
		int updatePrice = sc.nextInt();
		
		// 입력받은 값들을 Product형으로 묶기
		Product p1 = new Product(updateSerNum, null, updatePrice, 0);
		product.update(p1);
		System.out.println("\n# 전체 상품 목록");
		List<Product> p11 = product.searchAll();
		for (int i = 0; i < p11.size(); i++) { 
			System.out.println(p11.get(i));
		} System.out.println();
	
		System.out.println("# 전체 재고 상품 금액");	
		System.out.println(product.totalPrice());
		

		sc.close();
	}// main

}

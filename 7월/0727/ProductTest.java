package com.ssafy.hw06;

public class ProductTest {

	public static void main(String[] args) {
		
		// 상품 정보 객체 생성
		ProductMgr pm = new ProductMgr();

		// 상품 정보 전체 검색
		pm.products();

		// 상품번호로 상품 검색
		pm.serNumSearch("TV1");
		
		// 상품명으로 상품 검색
		pm.nameSearch("QLED 8K");
		pm.nameSearch("4도어");

		// TV 정보만 검색  
		pm.TV();
		
		// Refrigerator 정보만 검색
		pm.Refrigerator();
		
		// 상품번호로 상품 삭제
		pm.serNumDelete("TV2");
		pm.products();

		// 전체 재고 상품 금액
		pm.totalPrice();

	}

}

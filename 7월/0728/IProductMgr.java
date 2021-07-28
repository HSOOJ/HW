package com.ssafy.hw07;

import java.util.List;

public interface IProductMgr {

	/**
	 * 상품 전체를 검색하는 기능
	 * 
	 * @return : Product ArrayList
	 */
	List<Product> searchAll();

	/**
	 * 상품번호로 상품을 검색하는 기능
	 * 
	 * @param serNum : 상품 번호
	 */
	Product serNumSearch(String serNum);

	/**
	 * 상품명으로 상품을 검색하는 기능 상품명 부분 검색 가능
	 * 
	 * @param name : 상품명
	 */
	Product nameSearch(String name);

	/**
	 * TV만 검색
	 * 
	 * @return : TV toString()
	 */
	String TV();

	/**
	 * Refrigerator 검색
	 */
	String Refrigerator();

	/**
	 * 400L 이상의 냉장고만 검색
	 */
	String R400();

	/**
	 * 50인치 이상의 TV만 검색
	 */
	String T50();

	/**
	 * 상품 번호와 가격을 입력받아 상품 가격을 변경할 수 있는 기능
	 * 
	 * @param oldProduct : 상품 번호와 가격을 product로 묶음
	 */
	void update(Product oldProduct);

	/**
	 * 상품번호로 상품을 삭제하는 기능
	 * 
	 * @param delProduct : 상품 번호를 product로
	 */
	void serNumDelete(Product delProduct);

	/**
	 * 전체 재고 상품 금액을 구하는 기능
	 * 
	 * @return : 출력 String
	 */
	String totalPrice();

}

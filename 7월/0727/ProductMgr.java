package com.ssafy.hw06;

public class ProductMgr {
	int totalPrice = 0;

	// 상품 정보를 객체 배열을 활용하여 저장
	Product[] product = { new TV("TV1", "QLED 8K", 1200000, 50, 85, "QLED"),
			new TV("TV2", "LED 16K", 1000000, 100, 70, "LED"),
			new Refrigerator("RF1", "BESPOKE 냉장고 4도어 키친핏", 1400000, 100, 615) };

	int size = product.length; // 상품 개수

	// 상품정보 전체를 검색하는 기능
	void products() {
		System.out.println("### 전체 상품");
		for (Product p : product) {
			if (p != null)
				System.out.println(p);
		}
		System.out.println();
	} // product

	// 상품번호로 상품을 검색하는 기능
	void serNumSearch(String serNum) {
		System.out.println("### 상품번호로 상품 검색");
		for (Product p : product) {
			if (!(p == null) && p.serNum.equals(serNum))
				System.out.println(p.toString());
		}
		System.out.println();
	} // serNumSearch

	// 상품명으로 상품을 검색하는 기능(상품명 부분 검색 가능)
	void nameSearch(String name) {
		System.out.println("### 상품명으로 상품 검색");
		System.out.print(name + " -> ");
		for (Product p : product) {
			if (p.name.contains(name))
				System.out.println(p.toString());
		}
		System.out.println();
	} // nameSearch

	// TV정보만 검색
	void TV() {
		System.out.println("### TV");
		for (int i = 0; i < size; ++i) {
			if (product[i] instanceof TV)
				System.out.println(product[i].toString());
		}
		System.out.println();
	} // TV()

	// Refrigerator만 검색
	void Refrigerator() {
		System.out.println("### Refrigerator");
		for (int i = 0; i < size; ++i) {
			if (!(product[i] instanceof TV))
				System.out.println(product[i].toString());
		}
		System.out.println();
	} // Refrigerator()

	// 상품번호로 상품을 삭제하는 기능
	void serNumDelete(String serNum) {
		System.out.println("### 상품번호로 상품 삭제");
		for (int i = 0; i < size; i++) {
			if (product[i].serNum.equals(serNum)) {
				product[i] = product[size - 1];
				product[size - 1] = null;
				size--;
				System.out.println(serNum + " 삭제 완료");
				break;
			}

		}
		System.out.println();
	} // serNumDelete

	// 전체 재고 상품 금액을 구하는 기능
	void totalPrice() {
		System.out.println("### 전체 재고 상품 금액");
		for (Product p : product) {
			if (p != null)
				totalPrice += (p.price * p.quantity);
		}
		System.out.println("전체 재고 상품 금액 : " + totalPrice + "원");
	} // totalPrice

}

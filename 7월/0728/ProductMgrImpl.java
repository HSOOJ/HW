package com.ssafy.hw07;

import java.util.ArrayList;
import java.util.List;

public class ProductMgrImpl implements IProductMgr{

	List<Product> p = new ArrayList<>(); // 객체를 담을 ArrayList 생성
	// p: Product형의 List
	
	// 생성자
	public ProductMgrImpl() {
		// 상품정보를 저장
		// 객체가 생성되면 ArrayList에 값 추가하기 (add)
		p.add(new TV("TV1", "QLED 8K", 1200000, 100, 85, "QLED"));
		p.add(new TV("TV2", "LED 16K", 1000000, 40, 40, "LED"));
		p.add(new Refrigerator("RF1", "BESPOKE 4도어", 1400000, 100, 500));
	}
	
	
	public ProductMgrImpl(String updateSerNum, List<Product> p, int updatePrice, Object object, Object object2) {
		super();
		this.p = p;
	}


	// 상품 전체 목록
	@Override
	public List<Product> searchAll() {
		return p;
	}

	// 상품번호로 상품을 검색하는 기능
	@Override
	public Product serNumSearch(String serNum) {
		String tmp;
		for(int i = 0; i < p.size(); i++) {			
			tmp = p.get(i).getSerNum();				
			if(tmp.equals(serNum))					
				return p.get(i);
		}
		return null;
	}

	// 상품명으로 상품을 검색하는 기능(상품명 부분 검색 가능)
	@Override
	public Product nameSearch(String name) {
		String tmp;
		for(int i = 0; i < p.size(); i++) {				// for (int i = 0; i < arr.length; i++) {
			tmp = p.get(i).getName();					// 		tmp = arr[i];
			if(tmp.contains(name)) // 부분 검색			// }
				return p.get(i);
		}
		return null;		
	}

	// TV정보만 검색
	@Override
	public String TV() {
		String printTV = "";
		for(Product tv: p) {							// for(int x: arr) {
			if(tv instanceof TV)						// 		System.out.println(x);
				printTV += tv.toString() + "\n";		// }
		}
		return printTV;
	}

	// 냉장고만 검색
	@Override
	public String Refrigerator() {
		String printRf = "";
		for (int i = 0; i < p.size(); i++) {
			if (p.get(i) instanceof Refrigerator)
				printRf += p.get(i).toString() + "\n";
		}		
		return printRf;
	}
	
	// 용량이 400 이상인 냉장고 검색
	@Override
	public String R400() {
		Product tmp;
		String printRf = "";
		for (int i = 0; i < p.size(); i++) {
			tmp = p.get(i);
			if (tmp instanceof Refrigerator && ((Refrigerator) tmp).getCapacity() >= 400)
					printRf += tmp.toString() + "\n";
		}
		return printRf;
	}
	
	// 50인치 이상인 TV 검색
	@Override
	public String T50() {
		Product tmp;
		String printTV = "";
		for(int i = 0; i < p.size(); i++) {
			tmp = p.get(i);
			if (tmp instanceof TV && ((TV) tmp).getInch() >= 50)
				printTV += tmp.toString() + "\n";
		}
		return printTV;
	}

	// 상품 번호와 가격을 입력받아 상품 가격을 변경할 수 있는 기능
	@Override
	public void update(Product newProduct) {
		for(int i = 0; i < p.size(); i++) {
			Product oldProduct = p.get(i);
			
			if(oldProduct.getSerNum().equals(newProduct.getSerNum()))
				oldProduct.setPrice(newProduct.getPrice());
		}
	}

	// 상품번호로 상품을 삭제하는 기능
	@Override
	public void serNumDelete(Product delProduct) {
		for(int i = 0; i < p.size(); i++) {
			if(p.get(i).getSerNum().equals(delProduct.getSerNum()))
				p.remove(i);
		}
	}
	
	// 전체 재고 상품 금액을 구하는 기능
	@Override
	public String totalPrice() {
		int total = 0;
		for(Product ps : p) {
			total += ps.getPrice() * ps.getQuantity();
		}
		return "전체 재고 상품의 금액은 " + total + "원";
	}

}

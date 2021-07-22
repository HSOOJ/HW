package com.ssafy.hw;

public class ProductTest {

	public static void main(String[] args) {
		TV tv = new TV();
		tv.setSerNum("KQ85QNA800FXKR");
		tv.setName("Neo QLED 8K");
		tv.setPrice(14230000);
		tv.setQuantity(50);
		tv.setInch(85);
		tv.setDisplay("QLED");
		
		Refrigerator rf = new Refrigerator();
		rf.setSerNum("RF85A98T1AP");
		rf.setName("BESPOKE 냉장고 4도어 키친핏");
		rf.setPrice(3090000);
		rf.setQuantity(100);
		rf.setCapacity(615);
		
		System.out.println(tv.toString());
		System.out.println(rf.toString());
		
	}

}

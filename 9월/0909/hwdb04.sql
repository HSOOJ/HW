use productorder;

desc customer;
insert into customer values(1, 'hwang', '서울시 도봉구', '010-1234-5678', '010-9876-5432'),
							(2, 'lee', '서울시 강북구', '010-5678-0789', '010-1243-3645');
                   
desc product;
insert into product values('com1', 'computer', 1000000),
							('com2', 'notebook', 950000),
                            ('pad1', 'ipad', 500000);

desc order_;
insert into order_ values('o1', 1000000, 1, 0, 1, 1, 'com1'), 
						('o2', 1000000, 1, 1, 1, 2, 'com2'),
                        ('o3', 500000, 0, 0, 2, 1, 'pad1');
                        
select o.oname "주문번호", o.oprice "주문금액", o.payment "결제여부", o.shippment " 배송여부",
		p.code "상품코드", p.pname "상품명", p.price "가격", o.quantity "수량",
        c.cnum "고객번호", c.cname "고객명", c.addr "고객주소", c.phoneNum1 "고객 연락처 1", c.phoneNum2 "고객 연락처 2"
from order_ o join customer c
on o.cnum = c.cnum
join product p
on o.pcode = p.code;

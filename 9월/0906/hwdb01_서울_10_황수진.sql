# 1. 상품 정보를 저장할 수 있는 테이블 구성
create table product (
	pcode int(4) primary key,
    pname varchar(10),
    price int(10)
);

# 2. 상품 데이터를 5개 이상 저장하는 SQL을 작성
insert into product values(0001, "tv", 800000);
insert into product values(0002, "laptop", 1000000);
insert into product values(0003, "monitor", 250000);
insert into product values(0004, "ipad", 740000);
insert into product values(0005, "keyboard", 60000);

# 3. 15% 인하된 가격의 상품 정보를 출력
select pcode, pname, truncate(price * 0.85, 0) as "15% 할인 가격"
from product;

 
# 4. TV관련 상품 가격을 20% 인하하여 저장하고 출력
update product
set price = (price * 0.8)
where pname = 'tv';

select *
from product;

# 5. 저장된 상품 가격의 총 금액을 출력
select sum(price) as "총 금액"
from product;

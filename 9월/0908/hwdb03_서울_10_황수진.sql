use scott;

# 1
select e.ename, e.sal, d.dname
from emp e join dept d
on e.deptno = d.deptno;

# 2
select d.dname
from emp e join dept d
on e.deptno = d.deptno
where e.ename = 'king';

# 3
select e.ename, d.deptno, d.dname, e.sal
from emp e left outer join dept d
on e.deptno = d.deptno;

# 4
select concat(e.ename, "의 매니저는 ", m.ename, "이다.") "사원-매니저"
from emp e join emp m
on e.mgr = m.empno;

# 5
select e.ename, d.dname, e.sal, e.job
from emp e join dept d
on e.deptno = d.deptno
where e.deptno = (
					select deptno
					from emp
					where ename = 'scott'
					)
	and e.ename != "scott";
    
# 6
select empno, ename, hiredate, sal
from emp 
where deptno in (
					select deptno
					from emp
					where ename = 'scott'
					);
                    
# 7
select e.empno, e.ename, d.dname, e.hiredate, d.loc, e.sal
from emp e join dept d
on e.deptno = d.deptno
where e.sal > (select avg(sal) from emp);

# 8
select e.empno, e.ename, d.dname, d.loc, e.sal
from emp e join dept d
on e.deptno = d.deptno
where e.job in (select job
				from emp
				where deptno = 30
                )
order by e.sal desc;

# 9
select e.empno, e.ename, d.dname, e.hiredate, d.loc, e.sal
from emp e join dept d
on e.deptno = d.deptno
where d.deptno = 10
and job not in (
				select job
                from emp
                where deptno = 30
                );


# 10
select empno, ename, sal
from emp
where sal in (
				select sal
				from emp
				where ename in ("king", "james"));
                
# 11
select empno, ename, sal
from emp
where sal > (
				select max(sal)
                from emp
                where deptno = 30
                );
                
# 12
create index ename on emp(ename);

# 13
select ename, sal
from emp
where year(hiredate) in (
					select year(hiredate)
					from emp
					where ename = 'allen'
                    );
                    
# 14
create view salary
as
select sum(sal) "부서별 합계" 
from emp
group by deptno;

# 15번
select * 
from salary
order by `부서별 합계` desc
limit 3;


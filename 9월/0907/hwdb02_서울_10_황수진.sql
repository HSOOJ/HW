use scott;

# 1
select e.ename, e.job, e.sal
from emp e join dept d
on e.deptno = d.deptno
where d.loc = "CHICAGO";

# 2
select empno, ename, job, deptno
from emp
where mgr is null;

# 3
select ename, job, mgr
from emp
where mgr = (
				select mgr
				from emp
				where ename = 'BLAKE'
                );
                
# 4
select *
from emp
order by hiredate
limit 5;

# 5
select e.ename, e.job, d.dname
from emp e join dept d on e.deptno = d.deptno
where mgr = (
				select empno
				from emp
                where ename = 'JONES'
                );
select*
from emp;
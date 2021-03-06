# 175
SELECT p.firstname,p.lastname,a.city,a.state FROM person p LEFT JOIN address a ON p.personid = a.personid;

# 176
## 方法一
SELECT MAX(salary) SecondHighestSalary FROM employee WHERE salary!=(SELECT MAX(salary) FROM employee);
## 方法二(mysql)
SELECT COALESCE((SELECT DISTINCT salary FROM employee ORDER BY salary DESC LIMIT 1 OFFSET 1), NULL) AS SecondHighestSalary;

# 177
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT ifnull((SELECT DISTINCT salary FROM employee ORDER BY salary DESC LIMIT N,1), NULL)
  );
END

# 178
select a.score score,( select count(distinct(score)) from scores b where b.score >= a.score ) as rank from scores a order by score desc;

# 180
SELECT distinct(l1.num) AS ConsecutiveNums
FROM logs l1, logs l2, logs l3
WHERE l1.id = l2.id - 1 AND l2.id = l3.id - 1 AND l1.num = l2.num AND l2.num = L3.num;

# 181
select e1.name Employee from employee e1, employee e2 where e1.managerid = e2.id and e1.salary > e2.salary;

# 182
## 方法一:(时间12.97%)
select distinct(p1.email) Email from person p1, person p2 where p1.id != p2.id and p1.email = p2.email;
## 方法二:(时间34.97%)
select email Email from (select email,count(1) count from person group by email) as statistics where count > 1;
## 方法三:(最简洁的方法)
select Email from Person group by Email having count(Email) > 1;

# 183
select Name Customers from customers c left join orders o on c.id = o.customerid where o.id is NULL

# 184
SELECT d.name Department,e.name Employee,e.salary Salary
FROM employee e,department d
WHERE e.departmentid = d.id
AND (d.id, e.salary) IN (
    select departmentid,Max(salary) from employee group by departmentid
);

# 196
DELETE p1 FROM Person p1,
    Person p2
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id
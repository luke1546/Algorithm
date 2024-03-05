-- 코드를 입력하세요
SELECT f.flavor
from first_half f
join ICECREAM_INFO i 
on f.flavor = i.flavor
where INGREDIENT_TYPE = 'fruit_based' and TOTAL_ORDER > 3000
order by TOTAL_ORDER desc
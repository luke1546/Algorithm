-- 코드를 입력하세요
-- SELECT end_date - start_date
-- from CAR_RENTAL_COMPANY_RENTAL_HISTORY

-- if(조건문, 참, 거짓)

# select history_id, car_id, date_format(start_date, '%Y-%m-%d') start_date, date_format(end_date,'%Y-%m-%d') end_date, if(end_date - start_date>=30, "장기 대여", "단기 대여") rent_type
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# where year(start_date) = "2022" and month(start_date) = "9"
# order by history_id desc;

select history_id, car_id, date_format(start_date, '%Y-%m-%d') 
start_date, date_format(end_date,'%Y-%m-%d') end_date, 
if(datediff(end_date,start_date)>=29,"장기 대여", "단기 대여") rent_type
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where year(start_date) = "2022" and month(start_date) = "9"
order by history_id desc;
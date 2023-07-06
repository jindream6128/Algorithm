select
    HISTORY_ID,    (DAILY_FEE * DURATION) * (1 - (COALESCE(DISCOUNT_RATE,0) * 0.01)) FEE
from (
    select
        HISTORY_ID,
        CAR_TYPE,
        DAILY_FEE,
        (END_DATE - START_DATE + 1) DURATION,
        (
            CONCAT((case
                when (END_DATE - START_DATE + 1) >= 90 then 90
                when (END_DATE - START_DATE + 1) >= 30 then 30
                when (END_DATE - START_DATE + 1) >= 7 then 7
                else 0
            end),'일 이상')
        ) DURATION_TYPE
    from
        CAR_RENTAL_COMPANY_RENTAL_HISTORY
    left outer join
        CAR_RENTAL_COMPANY_CAR
    using(CAR_ID)
    where
        CAR_TYPE = '트럭') H
left outer join
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN
using(CAR_TYPE,DURATION_TYPE)
order by
    2 desc ,1 desc
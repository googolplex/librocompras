create or replace view vista_elultimo as
select w.per_yyyy || '/' || trim(to_char(w.per_mm,'99')) as YYYYMM
from periodos w
where w.lastupdated in (
select max(lastupdated) as ultimo 
from periodos k )
union all
select w.per_yyyy ||'/99' as YYYYMM
from periodos w
where w.lastupdated in (
select max(lastupdated) as ultimo 
from periodos k )

-- 1)
select DATE_FORMAT("2012/03/01", "%M") as Month , sum(amount) as total_ingresos from billing
where charged_datetime >= "2012/03/01" AND charged_datetime <= "2012/03/31";

-- 2)
select client_id, sum(amount) as total_ingresos from billing
where client_id = 2;

-- 3)
select c.client_id, c.first_name, s.domain_name from clients as c
left join sites as s on s.client_id = c.client_id
where c.client_id = 10;

-- 4)
select client_id, count(domain_name) as number_of_websites, monthname(created_datetime) as Month, 
year(created_datetime) as Year from sites
where client_id = 1
GROUP BY DATE(created_datetime);

-- 5)
select s.domain_name, count(l.leads_id) as total_leads from sites as s 
join leads as l ON s.site_id = l.site_id
where l.registered_datetime >= "2011/01/01" AND l.registered_datetime <= "2011/02/15"
group by s.domain_name;

-- 6
select concat(c.first_name, " ", c.last_name) as client_name, count(l.leads_id) as number_of_leads
FROM clients as c
JOIN sites as s ON c.client_id = s.client_id
JOIN leads as l ON s.site_id = l.site_id
WHERE l.registered_datetime >= "2011/01/01" AND l.registered_datetime <= "2011/12/31"
group BY client_name; 

-- 7 
select concat(c.first_name, " ", c.last_name) as client_name, count(l.leads_id) as number_of_leads, DATE_FORMAT(l.registered_datetime, "%M") as month_generated
FROM clients as c
JOIN sites as s ON c.client_id = s.client_id
JOIN leads as l ON s.site_id = l.site_id
WHERE l.registered_datetime >= "2011/01/01" AND l.registered_datetime <= "2011/06/30"
group BY DATE(l.registered_datetime);

-- 8
select concat(c.first_name, " ", c.last_name) as client_name, s.domain_name, 
count(l.leads_id) as total_leads, DATE_FORMAT(l.registered_datetime, "%M %d, %Y") as date_generated
FROM clients as c
INNER JOIN sites as s ON c.client_id = s.client_id
INNER JOIN leads as l ON s.site_id = l.site_id
WHERE l.registered_datetime >= "2011/01/01" AND l.registered_datetime <= "2011/12/31"
group by c.client_id, s.site_id;

-- 9
select concat (c.first_name, " ", c.last_name) as client_name, sum(b.amount) as total_amount,
 date_format(b.charged_datetime, "%M") as month_charge, year(b.charged_datetime) as year_charge
FROM clients as c
INNER JOIN billing as b ON c.client_id = b.client_id
group BY c.client_id, month(b.charged_datetime)
order by client_name, date(b.charged_datetime);

-- 10
select concat (c.first_name, " ", c.last_name) as client_name, group_concat(s.domain_name SEPARATOR " / ") as sites
FROM clients as c
INNER JOIN sites as s ON c.client_id = s.client_id
group by client_name;


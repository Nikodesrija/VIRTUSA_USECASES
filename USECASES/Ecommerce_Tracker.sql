-- ================E-commerce Logistics Tracker============== --
-- Database creation

create database Ecommerce;
use Ecommerce; 

-- Table creation
create table Partners(partner_id int primary key auto_increment,
partner_name varchar(100),partner_phonenumber varchar(10) CHECK(partner_phonenumber regexp '^[0-9]{10}$'),
partner_email varchar(100) CHECK (partner_email like '%@%.%'),partner_rating int check(partner_rating Between 1 and 5));

create table Shipments(shipment_id int primary key auto_increment,partner_id int,order_id varchar(50),arrival_city varchar(100),target_city varchar(100),promised_date date,actual_delivery_date date,
shipment_status varchar(50),foreign key(partner_id) references partners(partner_id),delivery_zone varchar(50)
);

create table DeliveryLogs (
deliverylog_id int primary key auto_increment,
shipment_id int,status_update varchar(50),update_time datetime,
location varchar(100),
foreign key(shipment_id) references Shipments(shipment_id));

INSERT INTO Partners (partner_name, partner_phonenumber, partner_email, partner_rating)
VALUES
('SkyRoute Logistics', '9847889056', 'sky@logistics.com', 5),
('RapidGo Couriers', '8184928825', 'rapid@gmail.com', 4),
('NextGen Delivery', '9131634590', 'gen@delivery.com', 3),
('FlashShip Express', '8598765432', 'flashship@yahoo.com', 2),
('SpeedX Transport', '8445679901', 'speedx@transport.com', 5);

insert  into Shipments (partner_id, order_id, arrival_city, target_city, promised_date, actual_delivery_date, shipment_status, delivery_zone)
values
(1, 'OID001', 'Hyderabad', 'Mumbai', '2026-04-03', '2026-04-07', 'Delivered', 'West'),
(2, 'OID002', 'Chennai', 'Delhi', '2026-04-14', '2026-04-14', 'Delivered', 'North'),
(1, 'OID003', 'Bangalore', 'Pune', '2026-04-05', '2026-04-06', 'Returned', 'West'),
(3, 'OID004', 'Kolkata', 'Hyderabad', '2026-04-03', '2026-04-04', 'Delivered', 'South'),
(2, 'OID005', 'Pune', 'Bangalore', '2026-04-02', '2026-04-07', 'Delivered', 'south');

INSERT INTO DeliveryLogs (shipment_id, status_update, update_time, location)
VALUES
(1, 'Picked Up', '2026-04-01 09:00:00', 'Hyderabad'),
(1, 'In Transit', '2026-04-02 15:00:00', 'Nagpur'),
(1, 'Delivered', '2026-04-03 17:00:00', 'Mumbai'),
(2, 'Picked Up', '2026-04-13 08:30:00', 'Chennai'),
(2, 'Delivered', '2026-04-14 20:00:00', 'Delhi'),
(3, 'Picked Up', '2026-04-01 10:00:00', 'Bangalore'),
(3, 'In Transit', '2026-04-03 12:00:00', 'Mumbai'),
(3, 'Returned', '2026-04-06 16:00:00', 'Pune'),
(4, 'Picked Up', '2026-04-03 07:45:00', 'Kolkata'),
(4, 'Delivered', '2026-04-04 19:00:00', 'Hyderabad'),
(5, 'Picked Up', '2026-04-05 09:30:00', 'Pune'),
(5, 'Delivered', '2026-04-07 15:00:00', 'Bangalore');

-- queries
-- Delayed Shipment Query
select * from Shipments
where actual_delivery_date>promised_date;

-- Performance Ranking
select p.partner_name,count(*) as shipments_count,
sum(case when s.shipment_status='Delivered' then 1 else 0 end) as Successful,
sum(case when s.shipment_status='Returned' then 1 else 0 end) as returned from Partners p
join Shipments s on p.partner_id=s.partner_id
group by p.partner_name;

-- Zone Filter
select target_city as destination_city,count(*) as total_orders
from Shipments
where promised_date>=curdate() -interval 30 day
group by target_city
order by total_orders desc
limit 1;

-- partner scorecard
select partner_name,round(successful_del*100.0/tot_shipments,2) as success_percent
from(
	select p.partner_name,count(s.shipment_id) as tot_shipments,
		sum(case when s.actual_delivery_date>s.promised_date
		then 1 else 0 
		end) as delayed_shipments,
		sum(case when s.shipment_status='Delivered'
       then 1 else 0
	   end) as successful_del,
		sum(case when s.shipment_status='Returned'
		then 1 else 0
        end) as returned_del
	from partners p
	join shipments s on p.partner_id=s.partner_id
	group by p.partner_name)
as score
order by delayed_shipments asc,success_percent desc;

use networth_db;

insert into role(type)
values('user'),('admin');

insert into user(email,user_name, first_name, last_name, password, role_id)
values ('aastevens1126', 'astevens09','Anthony','Stevens','$2a$10$GsOi9SscCwtgCSgf0D1AVeIlEORlgr8AEsUHoeFLkvv2qg849ZdIy',2),
       ('casanovageary@gmail.com', 'cgeary','Cas','Geary','$2a$10$GsOi9SscCwtgCSgf0D1AVeIlEORlgr8AEsUHoeFLkvv2qg849ZdIy',2);

insert into follower(user_id,follower_user_id)
values (1,2),(2,1);

insert into portfolio(name,dollar_limit,is_default,is_private,user_id)
values ('portfolio1',1000, true, false, 1),
       ('portfolio2',1000,true, false,2);

insert into asset(name,ticker,current_price,purchase_price,quantity,portfolio_id)
values ('Bitcoin','BTC',19000,23000, 1.2, )





insert into role(type)
values('user1'),('admin1');

insert into user(email,user_name, first_name, last_name, password, role_id)
values('aastevens1126', 'astevens09','Anthony','Stevens','$2a$10$GsOi9SscCwtgCSgf0D1AVeIlEORlgr8AEsUHoeFLkvv2qg849ZdIy',2),
       ('casanovageary@gmail.com', 'cgeary','Cas','Geary','$2a$10$GsOi9SscCwtgCSgf0D1AVeIlEORlgr8AEsUHoeFLkvv2qg849ZdIy',2);

insert into follower(user_id,follower_user_id)
values (1,2),(2,1);

insert into portfolio(name,dollar_limit,is_default,is_private,user_id)
values ('portfolio1',1000, true, false, 1),
       ('portfolio2',1000,true, false,2);

# insert into asset(name,ticker,current_price)
# values ('bitcoin','BTC',19000),
#        ('ethereum','ETH',1200);

# insert into portfolio_asset(portfolio_id, asset_id, quantity,purchase_price,purchase_date)
# values (1,1,1.2,23000,CURRENT_DATE),(1,2,2.2,1200,CURRENT_DATE),(2,1,.8,17000,CURRENT_DATE),(2,2,4,1600,CURRENT_DATE);

insert into post(title,description,user_id,img_url)
values ('Anthony\'s first post','Creating the next big thing', 1,'https://cdn.filestackcontent.com/B1HWOZWnRdOm25QzgdfM'),
       ('Cas\'s first post', 'Jp makes the world go around',2, 'https://cdn.filestackcontent.com/5j0rqMzIQd2zk0vK5oUL');

insert into comment(message,user_id, post_id)
values ('I 100% agree!',1,2),
       ('Good luck!',2,1);

insert into post_like(post_id, user_id)
values (1,1),(1,2);

insert into post_dislike(post_id, user_id)
values (2,1), (2,2);







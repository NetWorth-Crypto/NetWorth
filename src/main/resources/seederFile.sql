use networth_db;

insert into role(type)
values('user'),('admin');

select *
from role;

insert into user(email,user_name, first_name, last_name, password, role_id)
values ('shawn@gmail.com','shawnm','Shawn','Mars','password',1),
       ('Amber@gmail.com','amberb','Amber','Bird','password',1),
       ('stevensa.2009@gmail.com','anthonys','Anthony','Stevens','adminpassword',2),
       ('marion@gmail.com','marionw','Marion', 'Williams', 'password',1),
       ('casanovageary@gmail.com','casg','Cas','Geary','adminpassword',2),
       ('amida.fombutu@gmail.com','amidaf','Amida','Fombutu','adminpassword',2),
       ('yogeshadhikari81@gmail.com','yogesha','Yogesh','Adhikari','adminpassword',2),
       ('jay@codeup.com','jayi','Jay','Instructor','password',1),
       ('jordy@codeup.com','jordyi','Jordy','Instructor','password',1),
       ('nikki@codeup.com','nikkii','Nikki','Instructor','password',1);

select *
from user;


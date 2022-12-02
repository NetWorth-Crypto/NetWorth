use networth_db;

truncate role;
truncate user;

insert into role(type)
values('user'),('admin');

select *
from role;

insert into user(email, first_name, last_name, password, role_id)
values ('shawn@gmail.com','Shawn','Mars','password',1),
       ('Amber@gmail.com','Amber','Bird','password',1),
       ('stevensa.2009@gmail.com','Anthony','Stevens','adminpassword',2),
       ('marion@gmail.com','Marion', 'Williams', 'password',1),
       ('casanovageary@gmail.com','Cas','Geary','adminpassword',2),
       ('amida.fombutu@gmail.com','Amida','Fombutu','adminpassword',2),
       ('yogeshadhikari81@gmail.com','Yogesh','Adhikari','adminpassword',2),
       ('jay@codeup.com','Jay','Instructor','password',1),
       ('jordy@codeup.com','Jordy','Instructor','password',1),
       ('nikki@codeup.com','Nikki','Instructor','password',1);

select *
from user;


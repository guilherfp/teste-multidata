create table user (
  id integer auto_increment primary key,
  username varchar(100),
  name varchar(100),
  password varchar(30),
  active boolean default true
);

insert into user (username, name, password) values ('user1', 'Usuario 1', '1');
insert into user (username, name, password) values ('user2', 'Usuario 2', '2');
insert into user (username, name, password) values ('user3', 'Usuario 3', '3');
insert into user (username, name, password) values ('user4', 'Usuario 4', '4');
insert into user (username, name, password) values ('user5', 'Usuario 5', '5');
insert into user (username, name, password) values ('user6', 'Usuario 6', '6');
insert into user (username, name, password) values ('user7', 'Usuario 7', '7');
insert into user (username, name, password) values ('user8', 'Usuario 8', '8');
insert into user (username, name, password) values ('user9', 'Usuario 9', '9');
insert into user (username, name, password, active) values ('user10', 'Usuario 10', '10', false);
insert into user (username, name, password, active) values ('user11', 'Usuario 11', '11', false);
insert into user (username, name, password, active) values ('user12', 'Usuario 12', '12', false);
insert into user (username, name, password, active) values ('user13', 'Usuario 13', '13', false);
insert into user (username, name, password, active) values ('user14', 'Usuario 14', '14', false);
insert into user (username, name, password, active) values ('user15', 'Usuario 15', '15', false);
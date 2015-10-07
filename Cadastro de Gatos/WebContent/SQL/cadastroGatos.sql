create database if not exists cadastrogatos;
use cadastrogatos;

create table gatos(
id int(8) unsigned not null auto_increment,
nome varchar(45) not null,
raca varchar(45) not null,
primary key (id)
);

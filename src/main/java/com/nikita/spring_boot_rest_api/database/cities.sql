create database cities;

create table cities (
    id serial primary key,
    country varchar(30),
    name varchar(30),
    population bigint
);

select * from cities;
delete from cities where id = ?
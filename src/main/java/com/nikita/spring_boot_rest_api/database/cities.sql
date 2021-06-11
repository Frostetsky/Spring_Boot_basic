create database cities;

create table city (
    id serial primary key,
    country varchar(30),
    name varchar(30),
    population bigint
);

create table sight (
    id serial primary key,
    name varchar(40),
    city_id int references city(id)
);

select * from city;
delete from city where id = ?
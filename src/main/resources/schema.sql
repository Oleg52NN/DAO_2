create table if not exists CUSTOMERS (
    id SERIAL,
    name varchar(25) not null ,
    surname varchar(25) not null ,
    age int not null check ( age > 0 ),
    phone_number varchar(15),
    primary key (id));

create table if not exists ORDERS (
    id SERIAL primary key,
    date date,
    customer_id int,
    product_name varchar(100),
    amount decimal,

    foreign key (customer_id) references CUSTOMERS(id));

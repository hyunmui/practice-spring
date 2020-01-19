-- create SCHEMA order_system;
-- use order_system;

create table customer (
    customer_id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    address varchar(20) null,
    email varchar(40) null,
    PRIMARY KEY (customer_id)
);

create table order_item (
    order_item_id integer not null AUTO_INCREMENT,
    amount integer not null,
    product_id integer NULL,
    order_id integer NULL,
    PRIMARY KEY (order_item_id)
);

create table orders (
    order_id integer not null AUTO_INCREMENT,
    order_date Date not null,
    customer_id integer null,
    PRIMARY KEY (order_id)
);

create table product (
    product_id integer not null AUTO_INCREMENT,
    name varchar(20) not null,
    price integer not null,
    description varchar(60) null,
    PRIMARY KEY (product_id)
);

alter table order_item
ADD FOREIGN KEY R_5 (product_id) REFERENCES product (product_id);

alter table order_item
ADD FOREIGN KEY R_6 (order_id) REFERENCES orders (order_id);

alter table orders 
ADD FOREIGN KEY R_7 (customer_id) REFERENCES customer (customer_id);
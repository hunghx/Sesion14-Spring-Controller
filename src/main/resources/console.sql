create database jdbc_template ;
use jdbc_template;
create table dao(
    id int primary key  auto_increment,
    name varchar(100),
    height double,
    weight double,
    birthday date,
    price double
);

insert into dao(name, height, weight, birthday, price)  value (?,?,?,?,?);
update dao set name= ? , height=? ,weight=? ,birthday=?, price = ? where id = ?;


create table product(
                        id int primary key   auto_increment,
                        name varchar(100) ,
                        description text ,
                        price DECIMAL(10,2),
                        imageUrl varchar(255),
                        status bit default 1
);

create table productImage(
                             id int primary key auto_increment,
                             product_id int not null ,
                             img_url varchar(255),
                             foreign key (product_id) references product(id)

);
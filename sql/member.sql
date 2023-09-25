CREATE TABLE Member (
                        seq INT AUTO_INCREMENT PRIMARY KEY,
                        id  VARCHAR(255) UNIQUE NOT NULL,
                        name VARCHAR(255) NOT NULL,
                        email VARCHAR(255) UNIQUE NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        phoneNumber VARCHAR(20),
                        address VARCHAR(255), -- Changed data type to VARCHAR for address
                        gender VARCHAR(10), -- Changed data type to VARCHAR for gender
                        birthDate VARCHAR(20),
                        profileImage VARCHAR(255),
                        emailNotifications BOOLEAN,
                        role        VARCHAR(20) default '01'
);



SHOW DATABASES;

CREATE DATABASE ecommerce;

Select * from Member where email = "sujin941220@gmail.com";

select *
from ecommerce.member;

drop table member;


SELECT seq,id,password FROM member WHERE id = "수진" and password = "tnwls23131231";
update
delete
insert commit

trasnac
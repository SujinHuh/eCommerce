CREATE TABLE Member (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        email VARCHAR(255) UNIQUE NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        phoneNumber VARCHAR(20),
                        address VARCHAR(255), -- Changed data type to VARCHAR for address
                        gender VARCHAR(10), -- Changed data type to VARCHAR for gender
                        birthDate VARCHAR(20),
                        profileImage VARCHAR(255),
                        emailNotifications BOOLEAN
);

show databases ;

CREATE DATABASE ecommerce;

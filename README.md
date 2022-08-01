# productRestApi #JAVA #mysql #springboot #Cache #actuator #logger #unitTest #Junit4 #profiles #Service #API


productRestApi Springboot service
enabled cache through productCacheConfig file, springboot cache and hazelcast
enabled Springboot actuator
Custom Health indicators
SL4J logger
MySQL database connection
unit Testing using Junit 4
example of profiles for dev env. etc
test controller on postman/ soapUI

controller

/product -- GET
get list of all products

/product/{id}  -- GET
get product as per ID, @Cacheable

/product  -- POST
create / add product

/product  --PUT
update product 

/product/{id} -- DELETE
Delete product as per ID, @CacheEvict

Database use mysql

create database mydb
use mydb
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`id`)
)



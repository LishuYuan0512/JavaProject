DROP DATABASE IF EXISTS finalproject;

CREATE DATABASE finalproject;
USE finalproject;

-- Location table
CREATE TABLE Location (
                          locationID INT PRIMARY KEY auto_increment,
                          locationName VARCHAR(255) NOT NULL
);

insert into Location(locationName) values("Ottawa");
insert into Location(locationName) values("Toronto");

create Table Consumer(
userID INT PRIMARY KEY auto_increment,
    userName VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    userType VARCHAR(50),
    locationID INT,
    FOREIGN KEY (locationID) REFERENCES Location(locationID)
);

create Table Retailer(
	userID INT PRIMARY KEY auto_increment,
    userName VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    userType VARCHAR(50),
    locationID INT,
    FOREIGN KEY (locationID) REFERENCES Location(locationID)
);

create Table Charity(
userID INT PRIMARY KEY auto_increment,
    userName VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    userType VARCHAR(50),
    locationID INT,
    FOREIGN KEY (locationID) REFERENCES Location(locationID)
);

-- 修改自增键
CREATE TABLE PriceType2 (
	priceTypeID INT primary KEY,
    priceType VARCHAR(50)
);

-- Inserting data into PriceType2 table
INSERT INTO PriceType2 (priceTypeID, priceType) VALUES (1, 'donate');
INSERT INTO PriceType2 (priceTypeID, priceType) VALUES (2, 'sales');

-- FoodItems table
-- 添加isPlus字段
CREATE TABLE FoodItem2 (
    itemID INT PRIMARY KEY auto_increment,
    userID INT,
    itemName VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    restockTime DATE,
    expirationDate DATE,
    price DECIMAL(10, 2) NOT NULL,
    priceTypeID INT,
    isPlus INT,
    FOREIGN KEY (userID) REFERENCES Retailer(userID),
    FOREIGN KEY (priceTypeID) REFERENCES PriceType2(priceTypeID)
);


-- Purchase table
CREATE TABLE Purchase (
                          purchaseID INT PRIMARY KEY auto_increment,
                          purchaseTime DATETIME NOT NULL,
                          userID INT,
                          itemID INT,
                          quantity INT NOT NULL,
                          price DECIMAL(10, 2) NOT NULL,
                          priceTypeID INT,
                          FOREIGN KEY (userID) REFERENCES Retailer(userID),
                          FOREIGN KEY (itemID) REFERENCES FoodItem2(itemID),
                          FOREIGN KEY (priceTypeID) REFERENCES PriceType2(priceTypeID)
);

-- AlertType table
CREATE TABLE AlertType (
                           alertTypeID INT PRIMARY KEY auto_increment,
                           alertTypeName VARCHAR(255) NOT NULL
);


-- Alerts table
-- CREATE TABLE Alerts (
 --                       alertID INT PRIMARY KEY auto_increment,
  --                      userID INT,
  --                      itemID INT,
  --                      alertTypeID INT,
  --                      alertTime DATETIME NOT NULL,
  --                      email VARCHAR(255),
   --                     phone VARCHAR(20),
  --                      FOREIGN KEY (userID) REFERENCES Users(userID),
 --                       FOREIGN KEY (itemID) REFERENCES FoodItem2(itemID),
 --                       FOREIGN KEY (alertTypeID) REFERENCES AlertType(alertTypeID)
-- --);



-- Subscription table
--  CREATE TABLE Subscription (
 --                             subscriptionID INT PRIMARY KEY auto_increment,
   --                           userID INT,
     --                         location INT,
       --                       foodPrefer VARCHAR(255),
         --                     email VARCHAR(255),
           --                   phone VARCHAR(20),
             --                 FOREIGN KEY (userID) REFERENCES Users(userID),
               --               FOREIGN KEY (location) REFERENCES Location(locationID)
-- );


INSERT INTO Retailer (userName, password, email, phone, userType, locationID) 
VALUES ('retailer1', 'password123', 'retailer1@example.com', '123-456-7890', 'Retailer', 1);

INSERT INTO Retailer (userName, password, email, phone, userType, locationID) 
VALUES ('retailer2', 'password456', 'retailer2@example.com', '098-765-4321', 'Retailer', 2);

INSERT INTO consumer (userName, password, email, phone, userType, locationID) 
VALUES ('consumer1', 'password123', 'consumer1@example.com', '123-444-9999', 'consumer', 1);

INSERT INTO consumer (userName, password, email, phone, userType, locationID) 
VALUES ('consumer2', 'password123', 'consumer2@example.com', '333-445-7890', 'consumer', 2);

INSERT INTO charity (userName, password, email, phone, userType, locationID) 
VALUES ('charity1', 'password123', 'charity1@example.com', '333-000-7890', 'charity', 1);

INSERT INTO charity (userName, password, email, phone, userType, locationID) 
VALUES ('charity2', 'password123', 'charity2@example.com', '404-445-7890', 'charity', 2);

-- Inserting data into the FoodItem2 table
INSERT INTO FoodItem2 (userID, itemName, quantity, restockTime, expirationDate, price, priceTypeID, isPlus) 
VALUES (1, 'Apple', 100, '2024-08-01', '2024-08-15', 0.50, 1, 1);

INSERT INTO FoodItem2 (userID, itemName, quantity, restockTime, expirationDate, price, priceTypeID, isPlus) 
VALUES (2, 'Banana', 150, '2024-08-02', '2024-08-10', 0.30, 2, 0);

INSERT INTO FoodItem2 (userID, itemName, quantity, restockTime, expirationDate, price, priceTypeID, isPlus) 
VALUES (1, 'Orange', 200, '2024-08-03', '2024-08-12', 0.40, 1, 1);

INSERT INTO FoodItem2 (userID, itemName, quantity, restockTime, expirationDate, price, priceTypeID, isPlus) 
VALUES (2, 'Grapes', 250, '2024-08-04', '2024-08-18', 1.00, 2, 0);

INSERT INTO FoodItem2 (userID, itemName, quantity, restockTime, expirationDate, price, priceTypeID, isPlus) 
VALUES (2, 'Mango', 300, '2024-08-05', '2024-08-20', 1.50, 1, 1);




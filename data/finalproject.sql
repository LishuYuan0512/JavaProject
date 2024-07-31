DROP DATABASE IF EXISTS finalproject;
CREATE DATABASE finalproject;
USE finalproject;

-- Location table
CREATE TABLE Location (
    locationID INT PRIMARY KEY auto_increment,
    locationName VARCHAR(255) NOT NULL
);

-- Location table
CREATE TABLE Users (
    userID INT PRIMARY KEY auto_increment,
    userName VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    userType VARCHAR(50),
    locationID INT,
    FOREIGN KEY (locationID) REFERENCES Location(locationID)
);

-- PriceType table
CREATE TABLE PriceType (
	priceTypeID INT PRIMARY KEY auto_increment,
    priceType VARCHAR(50)
);

-- FoodItems table
CREATE TABLE FoodItems (
    itemID INT PRIMARY KEY auto_increment,
    userID INT,
    itemName VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    restockTime DATETIME,
    expirationDate DATETIME,
    price DECIMAL(10, 2) NOT NULL,
    priceTypeID INT,
    FOREIGN KEY (userID) REFERENCES Users(userID),
    FOREIGN KEY (priceTypeID) REFERENCES PriceType(priceTypeID)
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
    FOREIGN KEY (userID) REFERENCES Users(userID),
    FOREIGN KEY (itemID) REFERENCES FoodItems(itemID),
    FOREIGN KEY (priceTypeID) REFERENCES PriceType(priceTypeID)
);

-- AlertType table
CREATE TABLE AlertType (
    alertTypeID INT PRIMARY KEY auto_increment,
    alertTypeName VARCHAR(255) NOT NULL
);


-- Alerts table
CREATE TABLE Alerts (
    alertID INT PRIMARY KEY auto_increment,
    userID INT,
    itemID INT,
    alertTypeID INT,
    alertTime DATETIME NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(20),
    FOREIGN KEY (userID) REFERENCES Users(userID),
    FOREIGN KEY (itemID) REFERENCES FoodItems(itemID),
    FOREIGN KEY (alertTypeID) REFERENCES AlertType(alertTypeID)
);



-- Subscription table
CREATE TABLE Subscription (
    subscriptionID INT PRIMARY KEY auto_increment,
    userID INT,
    location INT,
    foodPrefer VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(20),
    FOREIGN KEY (userID) REFERENCES Users(userID),
    FOREIGN KEY (location) REFERENCES Location(locationID)
);
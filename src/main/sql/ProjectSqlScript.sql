CREATE TABLE `booking_request` (
  `userEmail` varchar(255) DEFAULT NULL,
  `productName` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `bookingStatus` tinyint(1) DEFAULT NULL,
  `imageUrl` varchar(255) DEFAULT NULL,
  `bookingUserName` varchar(255) DEFAULT NULL,
  `bookingTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `categoryOfItem` varchar(50) DEFAULT NULL,
  `productAge` int DEFAULT NULL,
  `bookingid` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`bookingid`)
) 

CREATE TABLE users (
    userId INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    email VARCHAR(100),
    password VARCHAR(255),
    isActive BOOLEAN
);

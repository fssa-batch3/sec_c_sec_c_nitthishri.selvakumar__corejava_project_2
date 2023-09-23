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
  `reason` varchar(500) DEFAULT NULL,
  `bookingid` int NOT NULL AUTO_INCREMENT,
  `pickupId` int DEFAULT 0,
  PRIMARY KEY (`bookingid`)
)  


   CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    email_id VARCHAR(255),
    user_name VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE pickup_request (
    PickupId INT AUTO_INCREMENT PRIMARY KEY,
    PickupName VARCHAR(255) DEFAULT NULL,
    PickupPhoneNumber BIGINT DEFAULT NULL,
    PickupAddress VARCHAR(255) DEFAULT NULL,
    PickupLandMark VARCHAR(255) DEFAULT NULL,
    PickupPincode INT DEFAULT NULL,
    PickupDate DATE DEFAULT NULL,
    PickupTime TIME DEFAULT NULL,
    Email VARCHAR(255) DEFAULT NULL,
    BookId INT DEFAULT 0 -- You can specify a default value here, e.g., 0
);
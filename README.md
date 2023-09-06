# Antique Restoration Project

## Project Overview

Antique Restoration Project is a web application aimed at helping antique enthusiasts and collectors restore and preserve their valuable antique items. Antique items often require specialized care, and this project provides a platform for users to access restoration services, tips, and resources.

## Problem Statement

Antique collectors and enthusiasts face several challenges when it comes to restoring and preserving their valuable items:

1. **Lack of Expertise**: Finding skilled restoration experts can be difficult and expensive.

2. **Information Scarcity**: Accessing reliable information on antique restoration techniques and materials can be challenging.

3. **Inventory Management**: Keeping track of the condition and restoration history of multiple antique items can be cumbersome.

## Solution

Our project aims to address these challenges by providing the following features:

1. **Service Directory**: Users can search for and connect with experienced antique restoration professionals in their area.

2. **Resource Hub**: Access a comprehensive library of articles, videos, and tutorials on antique restoration techniques, materials, and best practices.

3. **Inventory Management**: Users can create and manage a digital inventory of their antique items, including restoration history and condition updates.

## Project Structure

The core components of the Antique Restoration Project are organized as follows:

- **src/main/java/com/antiquerestoration/model**: Contains model classes representing antique items, user profiles, and service providers.

- **src/main/java/com/antiquerestoration/service**: Includes service classes that implement business logic for the Antique Restoration Project.

- **src/main/java/com/antiquerestoration/dao**: Data Access Object (DAO) classes are stored in this directory. They handle interactions with the database and provide methods for CRUD operations.

- **src/test/java/com/antiquerestoration**: Contains unit test cases for the project's backend components.


#product_booking
| Field           | Type         | Null | Key | Default            | Extra          |
|-----------------|--------------|------|-----|--------------------|----------------|
| userEmail       | varchar(255) | NO   |     |                    |                |
| productName     | varchar(255) | NO   |     |                    |                |
| bookingId       | int          | NO   | PRI | AUTO_INCREMENT    |                |
| phoneNumber     | varchar(20)  | YES  |     | NULL               |                |
| bookingStatus   | tinyint      |      |     | 0                  |                |
| imageUrl        | text         | YES  |     |                    |                |
| bookingUserName | varchar(255) | YES  |     | NULL               |                |
| bookingTime     | datetime     | YES  |     | NULL               |                |
| categoryOfItem  | varchar(30)  | YES  |     | NULL               |                |
| productAge      | int          | NO   |     |                    |                |


![image](https://github.com/fssa-batch3/sec_c_sec_c_nitthishri.selvakumar__corejava_project_2/assets/116252627/979c8ad3-6bc5-4f11-8770-a00676fd9466)

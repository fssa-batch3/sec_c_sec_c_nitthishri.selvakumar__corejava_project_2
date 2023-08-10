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

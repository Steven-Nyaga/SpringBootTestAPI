CREATE TABLE IF NOT EXISTS CUSTOMERS(

	idNumber INT PRIMARY KEY,
	customerName VARCHAR(250) NOT NULL,
	dateOfBirth DATE NOT NULL,
	nextOfKinName VARCHAR(250) NOT NULL,
	occupation VARCHAR(250) NOT NULL,

);

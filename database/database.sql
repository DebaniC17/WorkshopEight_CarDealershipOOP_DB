DROP DATABASE IF EXISTS dealership_DB;

CREATE DATABASE IF NOT EXISTS dealerships_DB;

USE dealerships_DB;

DROP TABLE IF EXISTS `Inventory`;
DROP TABLE IF EXISTS `Sales_Contracts`;
DROP TABLE IF EXISTS `Lease_Contracts`;
DROP TABLE IF EXISTS `Vehicles`;
DROP TABLE IF EXISTS `Dealerships`;

CREATE TABLE `Dealerships` (
  `Dealership_ID` INTEGER NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NOT NULL,
  `Address` VARCHAR(100),
  `Phone` VARCHAR(15),
  CONSTRAINT `pk_Dealerships` PRIMARY KEY (`Dealership_ID`)
);

CREATE TABLE `Vehicles` (
  `Make` VARCHAR(50),
  `Model` VARCHAR(50),
  `Type` VARCHAR(50),
  `Color` VARCHAR(50),
  `Odometer` VARCHAR(50),
  `Price` VARCHAR(100),
  `Year` VARCHAR(50),
  `VIN` VARCHAR(50),
  `Sold` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`VIN`)
);

CREATE TABLE `Inventory` (
  `Dealership_ID` INT,
  `VIN` VARCHAR(50),
  PRIMARY KEY (`Dealership_ID`, `VIN`),
  FOREIGN KEY (`Dealership_ID`) REFERENCES `Dealerships`(`Dealership_ID`),
  FOREIGN KEY (`VIN`) REFERENCES `Vehicles`(`VIN`)
);

CREATE TABLE `Sales_Contracts` (
  `Customer_Name` VARCHAR(100),
  `Customer_Email` VARCHAR(100),
  `ID` INT AUTO_INCREMENT,
  `VIN` VARCHAR(50),
  `Sale_Date` DATE,
  `Sale_Price` DECIMAL(12,2),
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`VIN`) REFERENCES `Vehicles`(`VIN`)
);

CREATE TABLE `Lease_Contracts` (
  `Customer_Name` VARCHAR(100),
  `Customer_Email` VARCHAR(100),
  `ID` INT AUTO_INCREMENT,
  `VIN` VARCHAR(50),
  `Lease_Start_Date` DATE,
  `Lease_End_Date` DATE,
  `Monthly_Payment` DECIMAL(12,2),
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`VIN`) REFERENCES `Vehicles`(`VIN`)
);

# ---------------------------------------------------------------------- #
# Add info into "Dealerships"                                            #
# ---------------------------------------------------------------------- #

-- TRUNCATE TABLE Dealerships;
INSERT INTO `Dealerships` (`Name`, `Address`, `Phone`)
VALUES
('Prime Auto', '123 Main St, Springfield, IL', '217-555-1234'),
('Auto World', '456 Elm St, Chicago, IL', '312-555-5678'),
('City Motors', '789 Maple Ave, Naperville, IL', '630-555-9101'),
('Elite Cars', '101 Oak Dr, Peoria, IL', '309-555-1122'),
('Luxury Wheels', '202 Pine Rd, Rockford, IL', '815-555-3344');

# ---------------------------------------------------------------------- #
# Add info into "Vehicles"                                               #
# ---------------------------------------------------------------------- #

-- TRUNCATE TABLE Vehicles;
INSERT INTO `Vehicles` (`Make`, `Model`, `Type`, `Color`, `Odometer`, `Price`, `Year`, `VIN`, `Sold`)
VALUES
('Toyota', 'Camry', 'Sedan', 'White', '32000', '25000', '2020', '1HGCM82633A123456', 0),
('Honda', 'CR-V', 'SUV', 'Black', '15000', '28000', '2021', '2HGCM82633B654321', 1),
('Ford', 'F-150', 'Truck', 'Blue', '45000', '30000', '2019', '3FGCM82633C789012', 0),
('Tesla', 'Model 3', 'Sedan', 'Red', '12000', '50000', '2022', '5TESM82633D345678', 1),
('Chevrolet', 'Malibu', 'Sedan', 'Gray', '55000', '20000', '2018', '6CHVM82633E901234', 0),
('Nissan', 'Altima', 'Sedan', 'Silver', '40000', '22000', '2019', '1N4AL3AP9JC123456', 0),
('Hyundai', 'Santa Fe', 'SUV', 'White', '20000', '30000', '2021', '2HSME5HB4GH123456', 1),
('BMW', 'X5', 'SUV', 'Black', '35000', '45000', '2020', '5UXFE43578L123456', 0),
('Mercedes-Benz', 'C-Class', 'Sedan', 'Blue', '28000', '40000', '2020', 'WDDGF8HB4EF123456', 1),
('Jeep', 'Wrangler', 'SUV', 'Green', '15000', '37000', '2022', '1C4HJWEG8LL123456', 0),
('Subaru', 'Outback', 'Wagon', 'Gray', '30000', '32000', '2020', '4S4BSENC8L3223456', 1),
('Kia', 'Soul', 'Crossover', 'Yellow', '25000', '20000', '2021', 'KNDJT2A58D7123456', 0),
('Volkswagen', 'Jetta', 'Sedan', 'Red', '50000', '19000', '2018', '3VWD17AJ6EM123456', 1),
('Mazda', 'CX-5', 'SUV', 'White', '22000', '27000', '2021', 'JM3KFBDM7J1234567', 0),
('GMC', 'Sierra', 'Truck', 'Black', '42000', '34000', '2019', '1GT12TEY1KF123456', 1),
('Ram', '1500', 'Truck', 'Silver', '50000', '32000', '2018', '1C6RR7KT4HS123456', 0),
('Lexus', 'RX 350', 'SUV', 'Blue', '33000', '45000', '2020', '2T2BZMCA9KC123456', 1),
('Audi', 'A4', 'Sedan', 'Gray', '15000', '38000', '2021', 'WAUENAF48KN123456', 0),
('Cadillac', 'Escalade', 'SUV', 'Black', '28000', '70000', '2020', '1GYS4HKJ4JR123456', 1),
('Chevrolet', 'Equinox', 'SUV', 'White', '37000', '25000', '2019', '2GNAXSEV4K6234567', 0),
('Ford', 'Escape', 'SUV', 'Silver', '46000', '23000', '2018', '1FMCU9J90JH123456', 1),
('Toyota', 'Tacoma', 'Truck', 'Green', '30000', '35000', '2020', '5TFCZ5AN8LX123456', 0),
('Honda', 'Accord', 'Sedan', 'Blue', '18000', '28000', '2021', '1HGCV1F14MA123456', 1),
('Tesla', 'Model X', 'SUV', 'Black', '10000', '90000', '2022', '5YJXCDE29LF123456', 0),
('Hyundai', 'Elantra', 'Sedan', 'Gray', '42000', '18000', '2019', 'KMHD84LF8KU123456', 1),
('Volkswagen', 'Tiguan', 'SUV', 'Red', '27000', '29000', '2020', '3VV2B7AX4LM123456', 0),
('BMW', '3 Series', 'Sedan', 'Black', '22000', '41000', '2021', 'WBA8E9C51JK123456', 1),
('Nissan', 'Rogue', 'SUV', 'White', '38000', '24000', '2019', 'JN8AT2MV0KW123456', 0),
('Subaru', 'Forester', 'SUV', 'Silver', '34000', '28000', '2020', 'JF2SKARC3LH123456', 1),
('Ford', 'Explorer', 'SUV', 'Black', '29000', '36000', '2021', '1FM5K8AR3LGB12345', 0),
('Kia', 'Telluride', 'SUV', 'Blue', '12000', '42000', '2022', '5XYP54HC1NG123456', 1),
('Ram', '2500', 'Truck', 'Red', '45000', '45000', '2018', '3C6UR5FL9JG123456', 0),
('Chevrolet', 'Colorado', 'Truck', 'Silver', '38000', '30000', '2020', '1GCGTBEN1L1134567', 1),
('Lexus', 'ES 350', 'Sedan', 'White', '25000', '39000', '2021', '58ABZ1B18MU123456', 0),
('Mercedes-Benz', 'GLA', 'SUV', 'Gray', '18000', '43000', '2022', 'WDCTG4GB1JJ123456', 1);

# ---------------------------------------------------------------------- #
# Add info into "Inventory"                                              #
# ---------------------------------------------------------------------- #

-- TRUNCATE TABLE Inventory;
INSERT INTO `Inventory` (`Dealership_ID`, `VIN`)
VALUES
(1, '1HGCM82633A123456'),
(2, '2HGCM82633B654321'),
(3, '3FGCM82633C789012'),
(4, '5TESM82633D345678'),
(5, '6CHVM82633E901234'),
(1, '1N4AL3AP9JC123456'),
(2, '2HSME5HB4GH123456'),
(3, '5UXFE43578L123456'),
(4, 'WDDGF8HB4EF123456'),
(5, '1C4HJWEG8LL123456'),
(1, '4S4BSENC8L3223456'),
(2, 'KNDJT2A58D7123456'),
(3, '3VWD17AJ6EM123456'),
(4, 'JM3KFBDM7J1234567'),
(5, '1GT12TEY1KF123456'),
(1, '1C6RR7KT4HS123456'),
(2, '2T2BZMCA9KC123456'),
(3, 'WAUENAF48KN123456'),
(4, '1GYS4HKJ4JR123456'),
(5, '2GNAXSEV4K6234567'),
(1, '1FMCU9J90JH123456'),
(2, '5TFCZ5AN8LX123456'),
(3, '1HGCV1F14MA123456'),
(4, '5YJXCDE29LF123456'),
(5, 'KMHD84LF8KU123456'),
(1, '3VV2B7AX4LM123456'),
(2, 'WBA8E9C51JK123456'),
(3, 'JN8AT2MV0KW123456'),
(4, 'JF2SKARC3LH123456'),
(5, '1FM5K8AR3LGB12345'),
(1, '5XYP54HC1NG123456'),
(2, '3C6UR5FL9JG123456'),
(3, '1GCGTBEN1L1134567'),
(4, '58ABZ1B18MU123456'),
(5, 'WDCTG4GB1JJ123456');


# ---------------------------------------------------------------------- #
# Add info into "Sales_Contracts"                                              #
# ---------------------------------------------------------------------- #

INSERT INTO `Sales_Contracts` (`Customer_Name`, `Customer_Email`, `VIN`, `Sale_Date`, `Sale_Price`)
VALUES
('John Doe', 'john.doe@example.com', '2HGCM82633B654321', '2024-01-15', 28000.00),
('Jane Smith', 'jane.smith@example.com', '5TESM82633D345678', '2024-02-10', 50000.00),
('Mark Johnson', 'mark.johnson@example.com', '3FGCM82633C789012', '2024-03-01', 30000.00),
('Alice Brown', 'alice.brown@example.com', '6CHVM82633E901234', '2024-04-18', 19000.00),
('Tom Wilson', 'tom.wilson@example.com', '1HGCM82633A123456', '2024-05-22', 25000.00),
('Chris Evans', 'chris.evans@example.com', '1N4AL3AP9JC123456', '2024-01-30', 22000.00),
('Emma Watson', 'emma.watson@example.com', '2HSME5HB4GH123456', '2024-02-15', 30000.00),
('Sophia Johnson', 'sophia.johnson@example.com', '5UXFE43578L123456', '2024-03-25', 45000.00),
('Oliver Martinez', 'oliver.martinez@example.com', 'WDDGF8HB4EF123456', '2024-04-10', 40000.00),
('Mia Lee', 'mia.lee@example.com', '1C4HJWEG8LL123456', '2024-05-05', 37000.00),
('Liam Brown', 'liam.brown@example.com', '4S4BSENC8L3223456', '2024-06-12', 32000.00),
('Noah Wilson', 'noah.wilson@example.com', 'KNDJT2A58D7123456', '2024-07-18', 20000.00),
('Ava Martinez', 'ava.martinez@example.com', '3VWD17AJ6EM123456', '2024-08-20', 19000.00),
('Isabella Davis', 'isabella.davis@example.com', 'JM3KFBDM7J1234567', '2024-09-14', 27000.00),
('James Taylor', 'james.taylor@example.com', '1GT12TEY1KF123456', '2024-10-10', 34000.00),
('Charlotte Brown', 'charlotte.brown@example.com', '1C6RR7KT4HS123456', '2024-11-05', 32000.00),
('Amelia White', 'amelia.white@example.com', '2T2BZMCA9KC123456', '2024-12-01', 45000.00),
('Lucas Green', 'lucas.green@example.com', 'WAUENAF48KN123456', '2025-01-18', 38000.00),
('Ethan Scott', 'ethan.scott@example.com', '1GYS4HKJ4JR123456', '2025-02-22', 70000.00),
('Harper Clark', 'harper.clark@example.com', '2GNAXSEV4K6234567', '2025-03-15', 25000.00);


# ---------------------------------------------------------------------- #
# Add info into "Lease_Contracts"                                              #
# ---------------------------------------------------------------------- #

INSERT INTO `Lease_Contracts` (`Customer_Name`, `Customer_Email`, `VIN`, `Lease_Start_Date`, `Lease_End_Date`, `Monthly_Payment`)
VALUES
('Emily Carter', 'emily.carter@example.com', '2HGCM82633B654321', '2024-01-01', '2026-01-01', 450.00),
('Michael Lee', 'michael.lee@example.com', '5TESM82633D345678', '2024-03-01', '2027-03-01', 650.00),
('Samantha Green', 'samantha.green@example.com', '1HGCM82633A123456', '2024-05-01', '2025-05-01', 350.00),
('Daniel Wright', 'daniel.wright@example.com', '3FGCM82633C789012', '2024-06-01', '2026-06-01', 500.00),
('Laura Martin', 'laura.martin@example.com', '6CHVM82633E901234', '2024-07-01', '2027-07-01', 400.00),
('Henry Cooper', 'henry.cooper@example.com', '1N4AL3AP9JC123456', '2024-01-15', '2026-01-15', 425.00),
('Grace Baker', 'grace.baker@example.com', '2HSME5HB4GH123456', '2024-02-20', '2027-02-20', 620.00),
('Victoria King', 'victoria.king@example.com', '5UXFE43578L123456', '2024-03-10', '2026-03-10', 700.00),
('Benjamin Hill', 'benjamin.hill@example.com', 'WDDGF8HB4EF123456', '2024-04-18', '2026-04-18', 550.00),
('Madison Wright', 'madison.wright@example.com', '1C4HJWEG8LL123456', '2024-05-05', '2026-05-05', 600.00),
('Elijah Adams', 'elijah.adams@example.com', '4S4BSENC8L3223456', '2024-06-01', '2026-06-01', 470.00),
('Scarlett Turner', 'scarlett.turner@example.com', 'KNDJT2A58D7123456', '2024-07-15', '2026-07-15', 360.00),
('Mason Phillips', 'mason.phillips@example.com', '3VWD17AJ6EM123456', '2024-08-10', '2026-08-10', 375.00),
('Ella Brooks', 'ella.brooks@example.com', 'JM3KFBDM7J1234567', '2024-09-01', '2026-09-01', 580.00),
('Alexander Price', 'alexander.price@example.com', '1GT12TEY1KF123456', '2024-10-01', '2027-10-01', 610.00);

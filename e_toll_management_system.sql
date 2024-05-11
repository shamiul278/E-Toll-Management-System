-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2024 at 10:27 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `e_toll_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `tollbooths`
--

CREATE TABLE `tollbooths` (
  `BoothID` int(11) NOT NULL,
  `Location` varchar(50) DEFAULT NULL,
  `Type` varchar(20) DEFAULT NULL,
  `LaneCount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tollbooths`
--

INSERT INTO `tollbooths` (`BoothID`, `Location`, `Type`, `LaneCount`) VALUES
(701, 'Main Street', 'Toll Booth', 3),
(702, 'Highway 101', 'Toll Booth', 4),
(703, 'Interstate 80', 'Toll Booth', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tollplaza`
--

CREATE TABLE `tollplaza` (
  `PlazaID` int(20) NOT NULL,
  `Date` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tollplaza`
--

INSERT INTO `tollplaza` (`PlazaID`, `Date`) VALUES
(1, '11/05/24'),
(2, '15/5/24'),
(3, '17/05/2024');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `TransactionID` int(11) NOT NULL,
  `Timestamp` varchar(20) DEFAULT NULL,
  `Amount` decimal(10,2) DEFAULT NULL,
  `LicensePlate` varchar(20) DEFAULT NULL,
  `BoothID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`TransactionID`, `Timestamp`, `Amount`, `LicensePlate`, `BoothID`) VALUES
(501, '2024-04-01 10:00:00', 220.00, 'ABC123', 701),
(502, '2024-04-02 11:30:00', 1000.00, 'DEF456', 702),
(503, '2024-04-03 12:45:00', 100.00, 'GHI789', 703);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `UserID` int(11) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `AddressType` varchar(20) DEFAULT NULL,
  `Phone` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UserID`, `Name`, `Email`, `AddressType`, `Phone`) VALUES
(101, 'Sami', 'Sami@gmail.com', 'Home', 2147483647),
(102, 'Shamiul', 'Shamiul@gamil.com', 'Work', 2147483647),
(103, 'Naimur', 'Naimur@email.com', 'Home', 2147483647);

-- --------------------------------------------------------

--
-- Table structure for table `vehicles`
--

CREATE TABLE `vehicles` (
  `LicensePlate` varchar(20) NOT NULL,
  `VehicleType` varchar(20) DEFAULT NULL,
  `UserID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vehicles`
--

INSERT INTO `vehicles` (`LicensePlate`, `VehicleType`, `UserID`) VALUES
('ABC123', 'Car', 101),
('DEF456', 'Truck', 102),
('GHI789', 'Motorcycle', 103);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tollbooths`
--
ALTER TABLE `tollbooths`
  ADD PRIMARY KEY (`BoothID`);

--
-- Indexes for table `tollplaza`
--
ALTER TABLE `tollplaza`
  ADD PRIMARY KEY (`PlazaID`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`TransactionID`),
  ADD KEY `LicensePlate` (`LicensePlate`),
  ADD KEY `BoothID` (`BoothID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`UserID`);

--
-- Indexes for table `vehicles`
--
ALTER TABLE `vehicles`
  ADD PRIMARY KEY (`LicensePlate`),
  ADD KEY `UserID` (`UserID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`LicensePlate`) REFERENCES `vehicles` (`LicensePlate`),
  ADD CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`BoothID`) REFERENCES `tollbooths` (`BoothID`);

--
-- Constraints for table `vehicles`
--
ALTER TABLE `vehicles`
  ADD CONSTRAINT `vehicles_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `users` (`UserID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

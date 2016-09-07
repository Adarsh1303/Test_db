-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 07, 2016 at 11:50 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Test`
--

-- --------------------------------------------------------

--
-- Table structure for table `Customers`
--

CREATE TABLE `Customers` (
  `Customer_id` int(5) NOT NULL,
  `Customer_email` varchar(30) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `Customer_name` varchar(30) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `Cutomer_phone` varchar(15) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Customers`
--

INSERT INTO `Customers` (`Customer_id`, `Customer_email`, `Customer_name`, `Cutomer_phone`) VALUES
(1401, 'coe13b003@iiitdm.ac.in', 'Adarsh Shrivastava', '9941680803'),
(1402, 'coe13b012@iiitdm.ac.in', 'Bhanu Moorthy', '9479261246');

-- --------------------------------------------------------

--
-- Table structure for table `Logs`
--

CREATE TABLE `Logs` (
  `Transaction_id` varchar(100) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `Previous_state` varchar(100) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `Operation` varchar(100) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `Message` varchar(100) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Logs`
--

INSERT INTO `Logs` (`Transaction_id`, `Previous_state`, `Operation`, `Message`) VALUES
('TR01', 'CART', 'PAYMENT', 'No connection to internet'),
('TR01', 'CART', 'PAYMENT', 'No connection to internet'),
('TR02', 'Payment', 'Money Reduction', 'Insufficient Money in wallet.'),
('TR02', 'Payment', 'Money Reduction', 'Insufficient Money in wallet.');

-- --------------------------------------------------------

--
-- Table structure for table `Products`
--

CREATE TABLE `Products` (
  `Product_id` int(5) NOT NULL,
  `Product_name` varchar(10) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `Product_type` varchar(10) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `Quantity` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Products`
--

INSERT INTO `Products` (`Product_id`, `Product_name`, `Product_type`, `Quantity`) VALUES
(1301, 'Japani Tel', 'Lubricant', 2),
(1302, 'Condom', 'Safety', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Customers`
--
ALTER TABLE `Customers`
  ADD PRIMARY KEY (`Customer_id`);

--
-- Indexes for table `Products`
--
ALTER TABLE `Products`
  ADD PRIMARY KEY (`Product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Customers`
--
ALTER TABLE `Customers`
  MODIFY `Customer_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1403;
--
-- AUTO_INCREMENT for table `Products`
--
ALTER TABLE `Products`
  MODIFY `Product_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1302;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

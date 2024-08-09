-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 17, 2024 at 01:57 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `formhopital`
--

-- --------------------------------------------------------

--
-- Table structure for table `chambres`
--

CREATE TABLE `chambres` (
  `numero` varchar(11) NOT NULL,
  `service` varchar(30) NOT NULL,
  `categorie` varchar(30) NOT NULL,
  `prix` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chambres`
--

INSERT INTO `chambres` (`numero`, `service`, `categorie`, `prix`) VALUES
('85', 'bon', 'VIP', 15000),
('784', 'Traiteur', 'Chambre', 30000),
('4872', 'Pediatrie', 'Chambre', 30000),
('56', 'Urgent', 'Chambre', 30000);

-- --------------------------------------------------------

--
-- Table structure for table `malades`
--

CREATE TABLE `malades` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `adresse` varchar(70) NOT NULL,
  `nationalite` varchar(40) NOT NULL,
  `genre` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `malades`
--

INSERT INTO `malades` (`id`, `nom`, `prenom`, `adresse`, `nationalite`, `genre`) VALUES
(1, 'DUSHIME', 'Marc', 'Bujumbura', 'Burundi', 'M'),
(2, 'INEZA', 'Mia', 'Kinindo', 'Burundi', 'F');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `malades`
--
ALTER TABLE `malades`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `malades`
--
ALTER TABLE `malades`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

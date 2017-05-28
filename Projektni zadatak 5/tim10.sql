-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2017 at 03:54 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tim10`
--

-- --------------------------------------------------------

--
-- Table structure for table `fotografija`
--

CREATE TABLE `fotografija` (
  `id` bigint(20) NOT NULL,
  `link` varchar(255) DEFAULT NULL,
  `oglas_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `id` bigint(20) NOT NULL,
  `admin` bit(1) DEFAULT NULL,
  `broj_objava` int(11) DEFAULT NULL,
  `e_mail` varchar(255) DEFAULT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `is_verified` bit(1) NOT NULL,
  `korisnicko_ime` varchar(255) DEFAULT NULL,
  `pravo_objave` bit(1) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `sifra` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`id`, `admin`, `broj_objava`, `e_mail`, `ime`, `is_verified`, `korisnicko_ime`, `pravo_objave`, `prezime`, `sifra`, `role_id`) VALUES
(1, b'0', 0, 'zdragnic@gmail.com', 'Zerina', b'1', 'zdragnic', b'1', 'Dragnic', 'Zerina123', 1),
(2, b'0', 0, 'sebi@gmail.com', 'Sebi', b'0', 'sebi', b'1', 'Catic', 'Sebi123', 1),
(3, b'0', 0, 'lejla@gmail.com', 'Lejla', b'0', 'lejla', b'1', 'Dzanko', 'Lejla123', 1);

-- --------------------------------------------------------

--
-- Table structure for table `oglas`
--

CREATE TABLE `oglas` (
  `id` bigint(20) NOT NULL,
  `adresa` varchar(255) DEFAULT NULL,
  `aktivan` bit(1) DEFAULT NULL,
  `broj_pregleda` int(11) DEFAULT NULL,
  `broj_prostorija` int(11) DEFAULT NULL,
  `broj_spratova` int(11) DEFAULT NULL,
  `cijena` double DEFAULT NULL,
  `datum_objave` datetime NOT NULL,
  `grad` varchar(255) DEFAULT NULL,
  `kvadratura` double DEFAULT NULL,
  `naziv_oglasa` varchar(255) DEFAULT NULL,
  `placen` bit(1) DEFAULT NULL,
  `slika` varchar(255) DEFAULT NULL,
  `vrsta_nekrenine` varchar(255) DEFAULT NULL,
  `vrsta_oglasa` varchar(255) DEFAULT NULL,
  `korisnik_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `oglas`
--

INSERT INTO `oglas` (`id`, `adresa`, `aktivan`, `broj_pregleda`, `broj_prostorija`, `broj_spratova`, `cijena`, `datum_objave`, `grad`, `kvadratura`, `naziv_oglasa`, `placen`, `slika`, `vrsta_nekrenine`, `vrsta_oglasa`, `korisnik_id`) VALUES
(1, 'Adresa 1', b'1', 12, 6, 1, 650, '2017-05-28 00:00:00', 'Sarajevo', 67, 'Stan 1', b'0', NULL, 'Stan', 'Izdavanje', 1),
(2, 'Adresa 2', b'1', 23, 6, 2, 678, '2017-05-28 00:00:00', 'Sarajevo', 55, 'Stan 2', b'0', NULL, 'Stan', 'Izdavanje', 2),
(3, 'Adresa 3', b'1', 43, 9, 2, 789, '2017-05-28 00:00:00', 'Tuzla', 89, 'Stan 3', b'0', NULL, 'Stan', 'Izdavanje', 3),
(4, 'Adresa 4', b'1', 2, 6, 2, 766, '2017-05-28 00:00:00', 'Mostar', 56, 'Stan 4', b'0', NULL, 'Stan', 'Izdavanje', 1),
(5, 'Adresa 5', b'1', 12, 12, 3, 900, '2017-05-28 00:00:00', 'Sarajevo', 100, 'Stan 5', b'0', NULL, 'Stan', 'Izdavanje', 1),
(6, 'Adresa 6', b'1', 4, 10, 2, 156000, '2017-05-28 00:00:00', 'Sarajevo', 55, 'Stan 6', b'0', NULL, 'Stan', 'Prodaja', 2);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role_name`) VALUES
(1, 'korisnik'),
(2, 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `zainteresovani_korisnik`
--

CREATE TABLE `zainteresovani_korisnik` (
  `id` bigint(20) NOT NULL,
  `korisnik_id` bigint(20) DEFAULT NULL,
  `oglas_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fotografija`
--
ALTER TABLE `fotografija`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcy309niv250kkp28m48tqj4yy` (`oglas_id`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4rt7vilssgmb37geum3ubisqh` (`role_id`);

--
-- Indexes for table `oglas`
--
ALTER TABLE `oglas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9f1sjp6k4paarws71u6dbnmc4` (`korisnik_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `zainteresovani_korisnik`
--
ALTER TABLE `zainteresovani_korisnik`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKa1cy0jrkn4w6kq5tbpf59w05g` (`korisnik_id`),
  ADD KEY `FKgj8o35nhqwxaire91pru249ky` (`oglas_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fotografija`
--
ALTER TABLE `fotografija`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `oglas`
--
ALTER TABLE `oglas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `zainteresovani_korisnik`
--
ALTER TABLE `zainteresovani_korisnik`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

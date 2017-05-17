-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2017 at 06:11 PM
-- Server version: 5.7.14
-- PHP Version: 7.0.8

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
  `e_mail` varchar(255) DEFAULT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `korisnicko_ime` varchar(255) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `sifra` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`id`, `e_mail`, `ime`, `korisnicko_ime`, `prezime`, `sifra`) VALUES
(1, 'zdragnic@gmail.com', 'Zerina', 'zdragnic', 'Dragnic', 'zerina');

-- --------------------------------------------------------

--
-- Table structure for table `lokacija`
--

CREATE TABLE `lokacija` (
  `id` bigint(20) NOT NULL,
  `adresa` varchar(255) DEFAULT NULL,
  `grad` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lokacija`
--

INSERT INTO `lokacija` (`id`, `adresa`, `grad`) VALUES
(1, 'Zmaja od bosne bb', 'Sarajevo');

-- --------------------------------------------------------

--
-- Table structure for table `oglas`
--

CREATE TABLE `oglas` (
  `id` bigint(20) NOT NULL,
  `aktivan` bit(1) DEFAULT NULL,
  `broj_pregleda` int(11) DEFAULT NULL,
  `broj_prostorija` int(11) DEFAULT NULL,
  `broj_spratova` int(11) DEFAULT NULL,
  `cijena` double DEFAULT NULL,
  `datum_objave` datetime NOT NULL,
  `kvadratura` double DEFAULT NULL,
  `naziv_oglasa` varchar(255) DEFAULT NULL,
  `placen` bit(1) DEFAULT NULL,
  `vrsta_nekrenine` varchar(255) DEFAULT NULL,
  `vrsta_oglasa` varchar(255) DEFAULT NULL,
  `korisnik_id` bigint(20) DEFAULT NULL,
  `lokacija_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `oglas`
--

INSERT INTO `oglas` (`id`, `aktivan`, `broj_pregleda`, `broj_prostorija`, `broj_spratova`, `cijena`, `datum_objave`, `kvadratura`, `naziv_oglasa`, `placen`, `vrsta_nekrenine`, `vrsta_oglasa`, `korisnik_id`, `lokacija_id`) VALUES
(1, b'0', 12, 2, 1, 1200, '2017-05-17 00:00:00', 56, 'Stan broj 1', b'0', 'Stan', 'Izdavanje', 1, 1);

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
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lokacija`
--
ALTER TABLE `lokacija`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `oglas`
--
ALTER TABLE `oglas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9f1sjp6k4paarws71u6dbnmc4` (`korisnik_id`),
  ADD KEY `FK2cpr1j30hv6qdk3xmx004i7qg` (`lokacija_id`);

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
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `lokacija`
--
ALTER TABLE `lokacija`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `oglas`
--
ALTER TABLE `oglas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `zainteresovani_korisnik`
--
ALTER TABLE `zainteresovani_korisnik`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

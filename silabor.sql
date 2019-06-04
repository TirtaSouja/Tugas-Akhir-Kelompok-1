-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2019 at 05:24 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `silabor`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_jadwal`
--

CREATE TABLE `tbl_jadwal` (
  `id` bigint(20) NOT NULL,
  `staff_id` bigint(20) DEFAULT NULL,
  `tanggal` date NOT NULL,
  `waktu_mulai` time NOT NULL,
  `waktu_selesai` time NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_jadwal`
--

INSERT INTO `tbl_jadwal` (`id`, `staff_id`, `tanggal`, `waktu_mulai`, `waktu_selesai`) VALUES
(1, 2, '2019-06-15', '01:00:00', '03:00:00'),
(2, 2, '2019-06-15', '01:00:00', '03:00:00'),
(3, 2, '2019-06-15', '01:00:00', '03:00:00'),
(4, 2, '2019-06-15', '01:00:00', '03:00:00'),
(5, 2, '2019-06-15', '01:00:00', '03:00:00'),
(6, 2, '2019-06-15', '01:00:00', '03:00:00'),
(7, 2, '2019-06-15', '01:00:00', '03:00:00'),
(8, 2, '2019-06-15', '01:00:00', '03:00:00'),
(9, 2, '2019-06-15', '01:00:00', '03:00:00'),
(10, 2, '2019-06-15', '01:00:00', '03:00:00'),
(11, 2, '2019-06-15', '01:00:00', '03:00:00'),
(12, 2, '2019-06-15', '01:00:00', '03:00:00'),
(13, 2, '2019-06-15', '01:00:00', '03:00:00'),
(14, 2, '2019-06-15', '01:00:00', '03:00:00'),
(15, 3, '2019-06-20', '03:00:00', '07:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_jenis_pemeriksaan`
--

CREATE TABLE `tbl_jenis_pemeriksaan` (
  `id` bigint(20) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `id_supplies` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_jenis_pemeriksaan`
--

INSERT INTO `tbl_jenis_pemeriksaan` (`id`, `nama`, `id_supplies`) VALUES
(1, 'Gila', 22);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_kebutuhan`
--

CREATE TABLE `tbl_kebutuhan` (
  `id` bigint(20) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `status` bigint(20) DEFAULT NULL,
  `tanggal_update` datetime DEFAULT NULL,
  `id_reagen` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_kebutuhan`
--

INSERT INTO `tbl_kebutuhan` (`id`, `jumlah`, `status`, `tanggal_update`, `id_reagen`) VALUES
(1, 7, 1, '2019-06-02 06:38:53', 22),
(2, 7, 1, '2019-06-02 06:43:40', 22),
(3, 9, 1, '2019-06-02 06:43:47', 21),
(4, 9, 1, '2019-06-02 06:44:08', 22),
(5, 9, 1, '2019-06-02 06:44:43', 22);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pasien`
--

CREATE TABLE `tbl_pasien` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_pasien`
--

INSERT INTO `tbl_pasien` (`id`, `nama`) VALUES
(1, 'Jujum'),
(2, 'Minten');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pemeriksaan`
--

CREATE TABLE `tbl_pemeriksaan` (
  `id` bigint(20) NOT NULL,
  `hasil` varchar(255) DEFAULT NULL,
  `status_id` bigint(20) NOT NULL,
  `tanggal_pemeriksaan` date DEFAULT NULL,
  `tanggal_pengajuan` date DEFAULT NULL,
  `jadwal_id` bigint(20) NOT NULL,
  `jenis_id` bigint(20) NOT NULL,
  `pasien_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_pemeriksaan`
--

INSERT INTO `tbl_pemeriksaan` (`id`, `hasil`, `status_id`, `tanggal_pemeriksaan`, `tanggal_pengajuan`, `jadwal_id`, `jenis_id`, `pasien_id`) VALUES
(1, 'Bagus', 1, '2019-06-04', '2019-06-01', 1, 1, 1),
(2, 'Biasa', 2, '2019-06-12', '2019-06-07', 1, 1, 2),
(3, '-', 3, '2019-05-02', '2019-06-10', 1, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_staff`
--

CREATE TABLE `tbl_staff` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_staff`
--

INSERT INTO `tbl_staff` (`id`, `nama`) VALUES
(1, 'Budi'),
(2, 'Minah'),
(3, 'Aing');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_supplies`
--

CREATE TABLE `tbl_supplies` (
  `id` bigint(20) NOT NULL,
  `deskripsi` varchar(255) NOT NULL,
  `jenis` varchar(255) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_supplies`
--

INSERT INTO `tbl_supplies` (`id`, `deskripsi`, `jenis`, `jumlah`, `nama`) VALUES
(22, 'Membuat ikatan karbon', 'Grignard', 99, 'Magnesium'),
(21, 'Menguji kandungan aldehida', 'Fehling', 76, 'Natrium Hidroksida'),
(20, 'Mengoksidasi Zat Kompleks', 'Alkohol', 57, 'Collins');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id` bigint(20) NOT NULL,
  `password` longtext NOT NULL,
  `role` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`id`, `password`, `role`, `username`) VALUES
(1, '$2a$10$AhriFuDF0/MhKamspgrdGewNCZjddoibaFw3kHOAGIWM.znelfChe', 'admin', 'tirta'),
(2, '$2a$10$AhriFuDF0/MhKamspgrdGewNCZjddoibaFw3kHOAGIWM.znelfChe', 'staff', 'souja');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_jadwal`
--
ALTER TABLE `tbl_jadwal`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_jenis_pemeriksaan`
--
ALTER TABLE `tbl_jenis_pemeriksaan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgwnyaulid52xmmqotx5dro99u` (`id_supplies`);

--
-- Indexes for table `tbl_kebutuhan`
--
ALTER TABLE `tbl_kebutuhan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKm2wu427l1wtp21u7n2enmlj01` (`id_reagen`);

--
-- Indexes for table `tbl_pasien`
--
ALTER TABLE `tbl_pasien`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_pemeriksaan`
--
ALTER TABLE `tbl_pemeriksaan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtlls60ekdwu7dnlqxtdrsb3jp` (`jadwal_id`),
  ADD KEY `FK8j08u4fu5qm0rcjs55pofwfln` (`jenis_id`),
  ADD KEY `FK6c0m2pp4mx6fyhaj3hsqm7lw2` (`pasien_id`);

--
-- Indexes for table `tbl_staff`
--
ALTER TABLE `tbl_staff`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_supplies`
--
ALTER TABLE `tbl_supplies`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_jadwal`
--
ALTER TABLE `tbl_jadwal`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `tbl_jenis_pemeriksaan`
--
ALTER TABLE `tbl_jenis_pemeriksaan`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_kebutuhan`
--
ALTER TABLE `tbl_kebutuhan`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `tbl_pasien`
--
ALTER TABLE `tbl_pasien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_pemeriksaan`
--
ALTER TABLE `tbl_pemeriksaan`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_staff`
--
ALTER TABLE `tbl_staff`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_supplies`
--
ALTER TABLE `tbl_supplies`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

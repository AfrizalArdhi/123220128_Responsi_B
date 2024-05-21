-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Bulan Mei 2024 pada 05.03
-- Versi server: 10.3.16-MariaDB
-- Versi PHP: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_bullkinggym`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_penyewa`
--

CREATE TABLE `data_penyewa` (
  `Nama_Penyewa` varchar(50) NOT NULL,
  `Nama_Alat` varchar(20) NOT NULL,
  `Nomor_Telepon` varchar(13) NOT NULL,
  `Waktu_Sewa` int(2) NOT NULL,
  `Biaya_Sewa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `data_penyewa`
--

INSERT INTO `data_penyewa` (`Nama_Penyewa`, `Nama_Alat`, `Nomor_Telepon`, `Waktu_Sewa`, `Biaya_Sewa`) VALUES
('ucup', 'barbel', '123', 2, 0),
('asdasd', 'asdads', 'adsads', 3, 50000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

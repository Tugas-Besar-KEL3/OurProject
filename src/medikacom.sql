-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Waktu pembuatan: 05. Februari 2018 jam 06:09
-- Versi Server: 5.5.16
-- Versi PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `medikacom`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_mapel`
--

CREATE TABLE IF NOT EXISTS `data_mapel` (
  `kodemapel` varchar(18) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idpengajar` int(18) NOT NULL,
  `mapel` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pkeahlian` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kurikulum` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`kodemapel`,`idpengajar`),
  KEY `idpengajar` (`idpengajar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `data_mapel`
--

INSERT INTO `data_mapel` (`kodemapel`, `idpengajar`, `mapel`, `pkeahlian`, `kurikulum`) VALUES
('A7612', 726362, 'Java Mobile Android', 'RPL', '2013'),
('T25KJ', 641279, 'Kerja Proyek', 'RPL', '2013');

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_nilai`
--

CREATE TABLE IF NOT EXISTS `data_nilai` (
  `nis` int(12) NOT NULL,
  `kodemapel` varchar(18) COLLATE utf8mb4_unicode_ci NOT NULL,
  `uts` smallint(6) NOT NULL,
  `uas` smallint(6) NOT NULL,
  PRIMARY KEY (`nis`,`kodemapel`),
  KEY `kodemapel` (`kodemapel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `data_nilai`
--

INSERT INTO `data_nilai` (`nis`, `kodemapel`, `uts`, `uas`) VALUES
(4999, 'A7612', 87, 78),
(8889, 'A7612', 98, 100);

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_pengajar`
--

CREATE TABLE IF NOT EXISTS `data_pengajar` (
  `idpengajar` int(18) NOT NULL,
  `nama` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jk` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`idpengajar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `data_pengajar`
--

INSERT INTO `data_pengajar` (`idpengajar`, `nama`, `jk`) VALUES
(641279, 'Jessica Putri', 'Perempuan'),
(726362, 'Wawan Setiawan', 'Laki-laki');

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_siswa`
--

CREATE TABLE IF NOT EXISTS `data_siswa` (
  `nis` int(12) NOT NULL,
  `nama` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kelas` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jk` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ttl` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nohp` int(12) NOT NULL,
  PRIMARY KEY (`nis`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `data_siswa`
--

INSERT INTO `data_siswa` (`nis`, `nama`, `kelas`, `jk`, `ttl`, `alamat`, `nohp`) VALUES
(4999, 'Dian', 'TKJ XII-A', 'Perempuan', 'Bandung,12 Februari 1997', 'Jl. Semar Luar', 2147483647),
(6273, 'Mia Anggitasari', 'RPL XII-B', 'Perempuan', 'Bandung,23 Juni 1997', 'Jln. Binong', 182729123),
(8889, 'Ayu Aprilianti', 'AKN XII-D', 'Perempuan', 'Garut, 12 Oktober 1999', 'Jln. Menteng', 127648381),
(616616, 'Putria', 'RPL XII-C', 'Perempuan', 'Bandung,25 Maret 1999', 'Jln.Sekar', 98787256);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `data_mapel`
--
ALTER TABLE `data_mapel`
  ADD CONSTRAINT `data_mapel_ibfk_1` FOREIGN KEY (`idpengajar`) REFERENCES `data_pengajar` (`idpengajar`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ketidakleluasaan untuk tabel `data_nilai`
--
ALTER TABLE `data_nilai`
  ADD CONSTRAINT `data_nilai_ibfk_1` FOREIGN KEY (`nis`) REFERENCES `data_siswa` (`nis`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `data_nilai_ibfk_2` FOREIGN KEY (`kodemapel`) REFERENCES `data_mapel` (`kodemapel`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

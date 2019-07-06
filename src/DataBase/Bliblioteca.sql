-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.17-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for biblioteca
CREATE DATABASE IF NOT EXISTS `biblioteca` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `biblioteca`;

-- Dumping structure for table biblioteca.empleado
CREATE TABLE IF NOT EXISTS `empleado` (
  `id_empleado` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre_Emp` varchar(50) NOT NULL DEFAULT 'Sin Nombre',
  `pasword` varchar(50) NOT NULL DEFAULT '12345',
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table biblioteca.empleado: ~4 rows (approximately)
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` (`id_empleado`, `Nombre_Emp`, `pasword`) VALUES
	(1, 'Juan Gomez', '12345'),
	(2, 'Elizabeth Ozorio', '12345'),
	(3, 'Gerardo Guevara', '12345'),
	(4, 'Martin Lutero', '12345');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;

-- Dumping structure for table biblioteca.libro
CREATE TABLE IF NOT EXISTS `libro` (
  `Id_Libro` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre_Libro` varchar(50) NOT NULL,
  `ISBN` varchar(50) NOT NULL,
  `Categoria` enum('Sin Categoria','Fantacia','Cientifico','Terror','Comic','Tecnologia') NOT NULL DEFAULT 'Sin Categoria',
  PRIMARY KEY (`Id_Libro`),
  UNIQUE KEY `ISBN` (`ISBN`),
  KEY `Nombre_Libro` (`Nombre_Libro`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table biblioteca.libro: ~3 rows (approximately)
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` (`Id_Libro`, `Nombre_Libro`, `ISBN`, `Categoria`) VALUES
	(1, 'Reader', 'a5d45a4d5asd', 'Fantacia'),
	(2, 'Arte de La Guerra', 'dadad3232', 'Sin Categoria'),
	(3, 'principito', 'ada32', 'Terror');
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;

-- Dumping structure for table biblioteca.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `Id_Persona` mediumint(9) NOT NULL AUTO_INCREMENT,
  `Nombre_Persona` varchar(50) NOT NULL,
  `Direccion` varchar(50) NOT NULL DEFAULT 'Sin Direccion',
  `Telefono` varchar(13) NOT NULL DEFAULT 'Sin Telefono',
  `Categoria` enum('A','B','C','N') NOT NULL DEFAULT 'N' COMMENT 'A es pare cliente excelente, B para cliente Bueno, Cpara clientes Malos, N para  Clientes Malos',
  PRIMARY KEY (`Id_Persona`),
  KEY `Nombre_Persona` (`Nombre_Persona`),
  KEY `Telefono` (`Telefono`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumping data for table biblioteca.persona: ~8 rows (approximately)
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`Id_Persona`, `Nombre_Persona`, `Direccion`, `Telefono`, `Categoria`) VALUES
	(1, 'Juanito Clavito', 'Sin Direccion', 'Sin Telefono', 'N'),
	(2, 'Maria Maria', 'Casita de Chocolate', '77554455', 'N'),
	(3, ' Lore alias mi mor', 'Casita con Pandito', '7777777', 'N'),
	(4, 'Pedro Pablo Escobar', 'Medellin Clolombia', '7273223', 'N'),
	(5, 'Miguel Gavidia', 'No tiene Casa', '77558866', 'N'),
	(6, 'Juan Luis', 'No tiene Casa', '', 'N'),
	(7, 'tito', 'Infervania', '', 'N'),
	(8, 'PEdro Pablo Puchinski', 'casa del infierno', '', 'N');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;

-- Dumping structure for table biblioteca.prestamo
CREATE TABLE IF NOT EXISTS `prestamo` (
  `id_prestamo` mediumint(9) NOT NULL AUTO_INCREMENT,
  `id_empleado` mediumint(8) unsigned NOT NULL,
  `id_cliente` mediumint(8) unsigned NOT NULL,
  `id_libro` mediumint(8) unsigned NOT NULL,
  `Fecha_salida` date NOT NULL,
  `Fecha_Entrada` date DEFAULT NULL,
  `Estado` enum('P','F') NOT NULL DEFAULT 'P' COMMENT 'P es para prestamo pendiente, F para prestamo Finalizado',
  PRIMARY KEY (`id_prestamo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table biblioteca.prestamo: ~1 rows (approximately)
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
INSERT INTO `prestamo` (`id_prestamo`, `id_empleado`, `id_cliente`, `id_libro`, `Fecha_salida`, `Fecha_Entrada`, `Estado`) VALUES
	(1, 1, 4, 1, '2019-07-03', NULL, 'P');
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-11-2021 a las 04:52:10
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hospital`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patients`
--

CREATE TABLE `patients` (
  `idPatient` int(11) NOT NULL,
  `namee` varchar(100) NOT NULL,
  `document` varchar(10) NOT NULL,
  `direction` varchar(100) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `operator` varchar(50) NOT NULL,
  `daysHospitalization` int(11) NOT NULL,
  `drugCost` float NOT NULL,
  `totalPay` float NOT NULL,
  `companyName` varchar(50) NOT NULL,
  `costOfTreatment` float NOT NULL,
  `idTreatmentFK` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `treatment`
--

CREATE TABLE `treatment` (
  `idTreatment` int(1) NOT NULL,
  `nameTreatment` varchar(50) NOT NULL,
  `treatmentValue` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `treatment`
--

INSERT INTO `treatment` (`idTreatment`, `nameTreatment`, `treatmentValue`) VALUES
(1, 'Tratamiento de Neumoconiosis', 500000),
(2, 'Tratamiento de Vértigo', 300000),
(3, 'Tratamiento de problemas respiratorios', 250000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`idPatient`),
  ADD KEY `idTreatmentFK` (`idTreatmentFK`);

--
-- Indices de la tabla `treatment`
--
ALTER TABLE `treatment`
  ADD PRIMARY KEY (`idTreatment`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `patients`
--
ALTER TABLE `patients`
  MODIFY `idPatient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `patients`
--
ALTER TABLE `patients`
  ADD CONSTRAINT `patients_ibfk_1` FOREIGN KEY (`idTreatmentFK`) REFERENCES `treatment` (`idTreatment`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

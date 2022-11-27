-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 27-11-2022 a las 23:28:30
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ADSI`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `info_ranking`
--

CREATE TABLE `info_ranking` (
  `user` varchar(50) NOT NULL,
  `dificultad` varchar(50) NOT NULL,
  `puntuacion` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `info_ranking`
--

INSERT INTO `info_ranking` (`user`, `dificultad`, `puntuacion`) VALUES
('fran', 'fácil', 20),
('Jose', 'fácil', 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ranking`
--

CREATE TABLE `ranking` (
  `dificultad` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ranking`
--

INSERT INTO `ranking` (`dificultad`) VALUES
('Fácil');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `user` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `pswd` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`user`, `email`, `pswd`) VALUES
('fran', 'fragonzcuriel@gmail.com', '1234'),
('Jose', 'jose@gmail.com', '1234');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `info_ranking`
--
ALTER TABLE `info_ranking`
  ADD KEY `user` (`user`),
  ADD KEY `ranking` (`dificultad`);

--
-- Indices de la tabla `ranking`
--
ALTER TABLE `ranking`
  ADD PRIMARY KEY (`dificultad`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`user`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `info_ranking`
--
ALTER TABLE `info_ranking`
  ADD CONSTRAINT `ranking` FOREIGN KEY (`dificultad`) REFERENCES `ranking` (`dificultad`) ON DELETE CASCADE,
  ADD CONSTRAINT `user` FOREIGN KEY (`user`) REFERENCES `usuario` (`user`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

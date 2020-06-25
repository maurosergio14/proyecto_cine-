-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-06-2020 a las 04:57:02
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `su boleteria_cine`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `butaca`
--

CREATE TABLE `butaca` (
  `id_butaca` int(10) NOT NULL,
  `id_verPelicula` int(11) NOT NULL,
  `fila` int(11) NOT NULL,
  `columna` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `butaca`
--

INSERT INTO `butaca` (`id_butaca`, `id_verPelicula`, `fila`, `columna`, `estado`) VALUES
(23, 4, 1, 1, 1),
(24, 6, 1, 1, 1),
(25, 8, 1, 1, 1),
(26, 9, 1, 1, 1),
(27, 10, 1, 1, 1),
(28, 11, 1, 1, 1),
(29, 12, 1, 1, 1),
(30, 13, 1, 1, 1),
(31, 14, 1, 1, 1),
(32, 15, 1, 1, 1),
(33, 16, 1, 1, 1),
(34, 17, 1, 1, 1),
(35, 18, 1, 1, 1),
(36, 19, 1, 1, 1),
(37, 20, 1, 1, 1),
(38, 21, 1, 1, 1),
(39, 22, 1, 1, 1),
(40, 23, 1, 1, 1),
(41, 24, 1, 1, 1),
(42, 25, 1, 1, 1),
(43, 26, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(10) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `dni` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombre`, `apellido`, `dni`) VALUES
(33, 'Cesar', 'Noso', 222),
(35, 'Cesar', 'Noso', 252),
(37, 'Cesar', 'Noso', 256);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcionverpelicula`
--

CREATE TABLE `funcionverpelicula` (
  `id_verPelicula` int(11) NOT NULL,
  `id_pelicula` int(11) NOT NULL,
  `id_sala` int(11) NOT NULL,
  `horario_desde` time NOT NULL DEFAULT current_timestamp(),
  `horario_hasta` time NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `funcionverpelicula`
--

INSERT INTO `funcionverpelicula` (`id_verPelicula`, `id_pelicula`, `id_sala`, `horario_desde`, `horario_hasta`) VALUES
(4, 14, 15, '00:00:00', '12:10:10'),
(5, 14, 15, '00:00:00', '12:10:10'),
(6, 15, 16, '00:00:00', '12:10:10'),
(7, 15, 16, '00:00:00', '12:10:10'),
(8, 16, 17, '00:00:00', '12:10:10'),
(9, 17, 18, '00:00:00', '12:10:10'),
(10, 18, 19, '00:00:00', '12:10:10'),
(11, 19, 20, '00:00:00', '12:10:10'),
(12, 20, 21, '00:00:00', '12:10:10'),
(13, 21, 22, '00:00:00', '12:10:10'),
(14, 22, 23, '09:10:10', '12:10:10'),
(15, 23, 24, '09:10:10', '12:10:10'),
(16, 24, 25, '09:10:10', '12:10:10'),
(17, 25, 26, '09:10:10', '12:10:10'),
(18, 26, 27, '09:10:10', '12:10:10'),
(19, 27, 28, '09:10:10', '12:10:10'),
(20, 28, 29, '09:10:10', '12:10:10'),
(21, 29, 30, '09:10:10', '12:10:10'),
(22, 30, 31, '09:10:10', '12:10:10'),
(23, 31, 32, '09:10:10', '12:10:10'),
(24, 32, 33, '09:10:10', '12:10:10'),
(25, 33, 34, '09:10:10', '12:10:10'),
(26, 34, 35, '09:10:10', '12:10:10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `id_pelicula` int(8) NOT NULL,
  `titulo` varchar(20) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `idioma` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`id_pelicula`, `titulo`, `genero`, `idioma`) VALUES
(1, 'Spederman', 'comedia', 'Español Latino'),
(2, 'vengadores', 'accion', 'ingles'),
(3, 'rambo 2', 'accion', 'español'),
(4, 'dead pool', 'comedia', 'ruso'),
(5, 'Señor de los anillos', 'Aventura', 'ruso'),
(6, 'dead pool', 'comedia', 'ruso'),
(7, 'Spederman', 'comedia', 'Español Latino'),
(8, 'Guardianes', 'comedia', 'Latino'),
(9, 'dead pool', 'comica', 'latino'),
(10, 'dead pool', 'comica', 'latino'),
(11, 'dead pool', 'comica', 'latino'),
(12, 'dead pool', 'comica', 'latino'),
(13, 'dead pool', 'comica', 'latino'),
(14, 'dead pool', 'comica', 'latino'),
(15, 'dead pool', 'comica', 'latino'),
(16, 'dead pool', 'comica', 'latino'),
(17, 'dead pool', 'comica', 'latino'),
(18, 'dead pool', 'comica', 'latino'),
(19, 'dead pool', 'comica', 'latino'),
(20, 'dead pool', 'comica', 'latino'),
(21, 'dead pool', 'comica', 'latino'),
(22, 'dead pool', 'comica', 'latino'),
(23, 'dead pool', 'comica', 'latino'),
(24, 'dead pool', 'comica', 'latino'),
(25, 'dead pool', 'comica', 'latino'),
(26, 'dead pool', 'comica', 'latino'),
(27, 'dead pool', 'comica', 'latino'),
(28, 'dead pool', 'comica', 'latino'),
(29, 'dead pool', 'comica', 'latino'),
(30, 'dead pool', 'comica', 'latino'),
(31, 'dead pool', 'comica', 'latino'),
(32, 'dead pool', 'comica', 'latino'),
(33, 'dead pool', 'comica', 'latino'),
(34, 'dead pool', 'comica', 'latino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE `sala` (
  `id_sala` int(8) NOT NULL,
  `ubucacion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sala`
--

INSERT INTO `sala` (`id_sala`, `ubucacion`) VALUES
(3, 'actualiza'),
(4, 'actualiza'),
(5, 'actualiza'),
(6, 'actualiza'),
(7, 'actualiza'),
(8, 'actualiza'),
(9, 'actualiza'),
(10, 'actualiza'),
(11, 'actualiza'),
(12, 'actualiza'),
(13, 'actualiza'),
(14, 'actualiza'),
(15, 'actualiza'),
(16, 'actualiza'),
(17, 'actualiza'),
(18, 'actualiza'),
(19, 'actualiza'),
(20, 'actualiza'),
(21, 'actualiza'),
(22, 'actualiza'),
(23, 'actualiza'),
(24, 'actualiza'),
(25, 'actualiza'),
(26, 'actualiza'),
(27, 'actualiza'),
(28, 'actualiza'),
(29, 'actualiza'),
(30, 'actualiza'),
(31, 'actualiza'),
(32, 'actualiza'),
(33, 'actualiza'),
(34, 'actualiza'),
(35, 'actualiza');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `id_ticket` int(8) NOT NULL,
  `id_cliente` int(8) NOT NULL,
  `id_sala` int(8) NOT NULL,
  `id_butaca` int(10) NOT NULL,
  `id_pelicula` int(8) NOT NULL,
  `fecha_ticket` datetime NOT NULL,
  `hora_ticket` time NOT NULL,
  `monto` double NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `metodo_de_pago` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ticket`
--

INSERT INTO `ticket` (`id_ticket`, `id_cliente`, `id_sala`, `id_butaca`, `id_pelicula`, `fecha_ticket`, `hora_ticket`, `monto`, `estado`, `metodo_de_pago`) VALUES
(5, 35, 28, 36, 27, '2021-12-23 00:00:00', '10:10:10', 200.23, 21, 'metodoDePago'),
(7, 37, 30, 38, 29, '2021-12-23 00:00:00', '10:10:10', 200.23, 21, 'metodoDePago');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `butaca`
--
ALTER TABLE `butaca`
  ADD PRIMARY KEY (`id_butaca`),
  ADD KEY `id_sala` (`id_verPelicula`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `funcionverpelicula`
--
ALTER TABLE `funcionverpelicula`
  ADD PRIMARY KEY (`id_verPelicula`),
  ADD KEY `id_pelicula` (`id_pelicula`),
  ADD KEY `id_sala` (`id_sala`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`id_pelicula`);

--
-- Indices de la tabla `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`id_sala`);

--
-- Indices de la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id_ticket`),
  ADD KEY `id_cliente` (`id_cliente`,`id_butaca`),
  ADD KEY `id_butaca` (`id_butaca`),
  ADD KEY `id_sala` (`id_sala`),
  ADD KEY `id_pelicula` (`id_pelicula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `butaca`
--
ALTER TABLE `butaca`
  MODIFY `id_butaca` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT de la tabla `funcionverpelicula`
--
ALTER TABLE `funcionverpelicula`
  MODIFY `id_verPelicula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `id_pelicula` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
  MODIFY `id_sala` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id_ticket` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `butaca`
--
ALTER TABLE `butaca`
  ADD CONSTRAINT `butaca_ibfk_1` FOREIGN KEY (`id_verPelicula`) REFERENCES `funcionverpelicula` (`id_verPelicula`);

--
-- Filtros para la tabla `funcionverpelicula`
--
ALTER TABLE `funcionverpelicula`
  ADD CONSTRAINT `funcionverpelicula_ibfk_1` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id_pelicula`),
  ADD CONSTRAINT `funcionverpelicula_ibfk_2` FOREIGN KEY (`id_sala`) REFERENCES `sala` (`id_sala`);

--
-- Filtros para la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`id_butaca`) REFERENCES `butaca` (`id_butaca`),
  ADD CONSTRAINT `ticket_ibfk_4` FOREIGN KEY (`id_sala`) REFERENCES `sala` (`id_sala`),
  ADD CONSTRAINT `ticket_ibfk_5` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id_pelicula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

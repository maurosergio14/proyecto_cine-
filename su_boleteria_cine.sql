-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-06-2020 a las 01:00:56
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
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
(1, 'juan', 'perez', 22222),
(3, 'Cesar', 'Noso', 222),
(4, 'Armando', 'Paredes', 223),
(5, 'Monica', 'Galindo', 224),
(6, 'nombre', 'apellido', 227),
(7, 'lucas', 'perez', 5555);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcionverpelicula`
--

CREATE TABLE `funcionverpelicula` (
  `id_verPelicula` int(11) NOT NULL,
  `id_pelicula` int(11) NOT NULL,
  `id_sala` int(11) NOT NULL,
  `horario_desde` datetime NOT NULL DEFAULT current_timestamp(),
  `horario_hasta` time NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `id_pelicula` int(8) NOT NULL,
  `titulo` varchar(20) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `duracion` varchar(50) NOT NULL,
  `autor` varchar(50) NOT NULL,
  `idioma` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`id_pelicula`, `titulo`, `genero`, `duracion`, `autor`, `idioma`) VALUES
(1, 'rambo', 'accion', '2horas', 'pepe', 'español'),
(2, 'vengadores', 'accion', '3horas', 'juancito', 'ingles'),
(3, 'rambo 2', 'accion', '2horas', 'pepe', 'español');

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
(1, 'sur'),
(2, 'norte');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `id_ticket` int(8) NOT NULL,
  `id_cliente` int(8) NOT NULL,
  `id_butaca` int(10) NOT NULL,
  `fecha_ticket` datetime NOT NULL,
  `hora_ticket` datetime NOT NULL,
  `monto` double NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `metodo_de_pago` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  ADD KEY `id_butaca` (`id_butaca`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `butaca`
--
ALTER TABLE `butaca`
  MODIFY `id_butaca` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `funcionverpelicula`
--
ALTER TABLE `funcionverpelicula`
  MODIFY `id_verPelicula` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `id_pelicula` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
  MODIFY `id_sala` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id_ticket` int(8) NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`id_butaca`) REFERENCES `butaca` (`id_butaca`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

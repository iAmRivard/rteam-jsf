-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-11-2019 a las 09:22:01
-- Versión del servidor: 10.3.16-MariaDB
-- Versión de PHP: 7.1.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `rteambdd`
--
CREATE DATABASE IF NOT EXISTS `rteambdd` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci;
USE `rteambdd`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alineacion`
--

CREATE TABLE `alineacion` (
  `id` int(11) NOT NULL,
  `id_equipo` int(11) NOT NULL,
  `id_jugador` int(11) NOT NULL,
  `posicion` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `estado` varchar(200) COLLATE utf8_spanish2_ci NOT NULL DEFAULT 'Activa'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` text COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`, `descripcion`) VALUES
(1, 'Acción', 'Juegos de muchísima acción'),
(3, 'Terror', 'Juegos de  terror'),
(4, 'RPG', 'Juegos de rpg'),
(5, 'Supervivencia', 'Juegos de supervivencia y sandbox'),
(7, 'Autos', 'Juegos de automoviles'),
(8, 'Arcade', 'Juegos de arcade'),
(9, 'MOBA', 'El MOBA es un género de videojuegos que se desarrolla en una arena virtual en conexión con otros jugadores para cumplir un objetivo claro y especifico, dominar en batalla al otro equipo.'),
(10, 'ROL', 'Un juego de rol o JDR (traducción típica en español del inglés role-playing game o sus siglas RPG, literalmente «juego de interpretación de roles») es un juego en el que, tal como indica su nombre, uno o más jugadores desempeñan un determinado rol, papel o personalidad. Cuando una persona hace el papel de X significa que está interpretando el papel de un personaje jugador (término generalmente abreviado con la sigla «PJ»).');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `correo` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `password` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `fundacion` date NOT NULL,
  `representante` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` text COLLATE utf8_spanish2_ci NOT NULL,
  `id_juego` int(11) NOT NULL,
  `estado` varchar(200) COLLATE utf8_spanish2_ci NOT NULL DEFAULT 'Activo',
  `foto` text COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`id`, `nombre`, `correo`, `password`, `fundacion`, `representante`, `telefono`, `descripcion`, `id_juego`, `estado`, `foto`) VALUES
(7, 'Olympus Gods', 'olympus@gods.com', 'olympus', '0008-04-07', 'Carlos Serrano', '72213636', 'Somos un equipo profesional de League Of Legends.', 9, 'Activo', NULL),
(8, 'Death Squad', 'death@squad.com', 'death', '2018-06-15', 'Erick Rivas', '78546921', 'Somos un equipo profesional de Arena Of Valor.', 11, 'Activo', NULL),
(9, 'Isurus Gaming', 'usuarus@gaming.com', 'isurus', '2011-04-15', 'Belen Arckhman', '74568921', 'Somos un equipo original de grandes ligas.', 9, 'Activo', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juego`
--

CREATE TABLE `juego` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` text COLLATE utf8_spanish2_ci NOT NULL,
  `lanzamiento` date NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `id_plataforma` int(11) NOT NULL,
  `foto` text COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `juego`
--

INSERT INTO `juego` (`id`, `nombre`, `descripcion`, `lanzamiento`, `id_categoria`, `id_plataforma`, `foto`) VALUES
(9, 'League Of Legends', 'League of Legends es un videojuego del género multijugador de arena de batalla en línea y deporte electrónico el cual fue desarrollado por Riot Games para Microsoft Windows y OS X.', '2009-10-27', 9, 8, 'https://i.ytimg.com/vi/n_KrxgXrU4w/maxresdefault.jpg'),
(11, 'Arena Of Valor', 'Es una adaptación internacional de Wangzhe Rongyao.', '2016-10-14', 9, 10, 'https://i.ytimg.com/vi/n_KrxgXrU4w/maxresdefault.jpg'),
(12, 'asd', 'asd', '2019-11-07', 1, 8, 'https://i.ytimg.com/vi/n_KrxgXrU4w/maxresdefault.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `id` int(11) NOT NULL,
  `usuario` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `rol` varchar(200) COLLATE utf8_spanish2_ci NOT NULL DEFAULT 'Jugador',
  `posicion` varchar(200) COLLATE utf8_spanish2_ci NOT NULL DEFAULT 'Diverso',
  `liga` varchar(200) COLLATE utf8_spanish2_ci NOT NULL DEFAULT 'Sin liga',
  `descripcion` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `nivel` int(11) NOT NULL,
  `id_juego` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`id`, `usuario`, `rol`, `posicion`, `liga`, `descripcion`, `id_usuario`, `nivel`, `id_juego`) VALUES
(5, 'Frankestein', 'Asesino', 'Midlaner', 'Oro III', 'Soy bueno farmeando.', 2, 123, 9),
(1, 'Grimmlock', 'Asesino', 'Midlaner', 'Oro II', 'Soy súper buena onda', 2, 128, 11),
(7, 'Grimmlock2', 'Asesino', 'Midlaner', 'Oro III', 'Soy bueno matando.', 2, 123, 9),
(8, 'Juanka', 'Asesino', 'Midlaner', 'Oro III', 'Soy un jugador bueno.', 2, 123, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `logs`
--

CREATE TABLE `logs` (
  `ID_LOG` int(11) NOT NULL,
  `LOG_DATE` date NOT NULL,
  `LOGGER` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `LEVEL` varchar(12) COLLATE utf8_spanish2_ci NOT NULL,
  `MESSAGE` varchar(1000) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `logs`
--

INSERT INTO `logs` (`ID_LOG`, `LOG_DATE`, `LOGGER`, `LEVEL`, `MESSAGE`) VALUES
(2, '2019-11-15', 'sv.edu.udb.www.beans.CategoriaBean', 'WARN', 'La categoría ya existejavax.ejb.EJBException: Transaction aborted'),
(3, '2019-11-16', 'sv.edu.udb.www.beans.CategoriaBean', 'INFO', 'Se ha modificado una categoria: Edit'),
(4, '2019-11-16', 'sv.edu.udb.www.beans.CategoriaBean', 'INFO', 'Se ha modificado una categoria: Editasdasd>Editasdasd'),
(5, '2019-11-16', 'sv.edu.udb.www.beans.CategoriaBean', 'INFO', 'Se ha actualizado la cateogira:Categoria'),
(6, '2019-11-16', 'sv.edu.udb.www.beans.CategoriaBean', 'INFO', 'Se ha eliminado la categoria:null'),
(7, '2019-11-16', 'sv.edu.udb.www.beans.CategoriaBean', 'INFO', 'Se ha actualizado la cateogira:ROL'),
(8, '2019-11-16', 'sv.edu.udb.www.beans.CategoriaBean', 'WARN', 'Laadasd no puede ser modificada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plataforma`
--

CREATE TABLE `plataforma` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `lanzamiento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `plataforma`
--

INSERT INTO `plataforma` (`id`, `nombre`, `lanzamiento`) VALUES
(8, 'Windows 10', '2017-07-29'),
(10, 'Android', '2008-09-23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud`
--

CREATE TABLE `solicitud` (
  `id` int(11) NOT NULL,
  `id_jugador` int(11) NOT NULL,
  `id_vacante` int(11) NOT NULL,
  `estado` varchar(200) COLLATE utf8_spanish2_ci NOT NULL DEFAULT 'En proceso',
  `justificacion` text COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `solicitud`
--

INSERT INTO `solicitud` (`id`, `id_jugador`, `id_vacante`, `estado`, `justificacion`) VALUES
(3, 5, 5, 'Pendiente', NULL),
(4, 7, 5, 'Pendiente', NULL),
(8, 8, 5, 'Pendiente', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `correo` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `clave` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `nacimiento` date NOT NULL,
  `estado` varchar(200) COLLATE utf8_spanish2_ci DEFAULT 'Activo',
  `rol` varchar(200) COLLATE utf8_spanish2_ci DEFAULT 'Jugador',
  `foto` text COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `correo`, `clave`, `nacimiento`, `estado`, `rol`, `foto`) VALUES
(1, 'Carlos Serrano', 'charliehcontact@gmail.com', '12345', '2000-07-15', 'Activo', 'Administrador', NULL),
(2, 'Erick García Rivas', 'erick@gmail.com', '12345', '2019-10-23', 'Activo', 'Jugador', NULL),
(3, 'Ricardo Rodríguez Bellaco', 'ricardo@gmail.com', '12345', '2019-10-11', 'Activo', 'Jugador', NULL),
(4, 'Ana Linares Rojas', 'ana@gmail.com', '12345', '2019-10-16', 'Activo', 'Jugador', NULL),
(5, 'Sergio Blanco Carrasco', 'sergio@blanco.com', 'sergio', '1993-10-17', 'Activo', 'Jugador', NULL),
(6, 'Carlos Serrano', 'loco@gmail.com', '12345', '2000-12-15', 'Activo', 'Jugador', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacante`
--

CREATE TABLE `vacante` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `requisitos` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `id_equipo` int(11) NOT NULL,
  `estado` varchar(200) COLLATE utf8_spanish2_ci NOT NULL DEFAULT 'Activa',
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `vacante`
--

INSERT INTO `vacante` (`id`, `nombre`, `descripcion`, `requisitos`, `id_equipo`, `estado`, `fecha`) VALUES
(5, '¡Buscamos Midlaner!', '¿Quieres formar parte de nuestro equipo? ¡Aplica ya!', 'Ser platino II en adelante, discord y actitud para seguir órdenes y aprender,', 7, 'Activa', '2019-10-11'),
(7, '¡Buscamos Toplaner!', '¿Quieres formar parte de nuestro equipo? ¡Aplica ya!', 'Ser platino II en adelante, discord y actitud para seguir órdenes y aprender,', 7, 'Inactiva', '2019-10-11'),
(8, 'Urgente: Requerimos Coach', 'Si crees tener las capacidades de entrenar a nuestros integrantes aplica.', 'Experiencia en coaching.', 8, 'Activa', '2019-10-11');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alineacion`
--
ALTER TABLE `alineacion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_equipo` (`id_equipo`),
  ADD KEY `id_jugador` (`id_jugador`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`,`id_juego`),
  ADD UNIQUE KEY `correo` (`correo`),
  ADD KEY `id_juego` (`id_juego`);

--
-- Indices de la tabla `juego`
--
ALTER TABLE `juego`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`,`id_categoria`,`id_plataforma`),
  ADD UNIQUE KEY `nombre_2` (`nombre`,`id_plataforma`),
  ADD KEY `id_categoria` (`id_categoria`),
  ADD KEY `id_plataforma` (`id_plataforma`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `usuario` (`usuario`,`id_juego`),
  ADD UNIQUE KEY `usuario_3` (`usuario`,`rol`,`posicion`,`liga`,`descripcion`,`id_usuario`,`nivel`,`id_juego`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_juego` (`id_juego`);

--
-- Indices de la tabla `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`ID_LOG`);

--
-- Indices de la tabla `plataforma`
--
ALTER TABLE `plataforma`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_jugador_2` (`id_jugador`,`id_vacante`),
  ADD KEY `id_jugador` (`id_jugador`),
  ADD KEY `id_vacante` (`id_vacante`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- Indices de la tabla `vacante`
--
ALTER TABLE `vacante`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`,`descripcion`,`requisitos`,`id_equipo`,`estado`,`fecha`),
  ADD KEY `id_equipo` (`id_equipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alineacion`
--
ALTER TABLE `alineacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `equipo`
--
ALTER TABLE `equipo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `juego`
--
ALTER TABLE `juego`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `logs`
--
ALTER TABLE `logs`
  MODIFY `ID_LOG` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `plataforma`
--
ALTER TABLE `plataforma`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `vacante`
--
ALTER TABLE `vacante`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alineacion`
--
ALTER TABLE `alineacion`
  ADD CONSTRAINT `alineacion_ibfk_1` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `alineacion_ibfk_2` FOREIGN KEY (`id_jugador`) REFERENCES `jugador` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `equipo_ibfk_1` FOREIGN KEY (`id_juego`) REFERENCES `juego` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `juego`
--
ALTER TABLE `juego`
  ADD CONSTRAINT `juego_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `juego_ibfk_2` FOREIGN KEY (`id_plataforma`) REFERENCES `plataforma` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD CONSTRAINT `jugador_ibfk_1` FOREIGN KEY (`id_juego`) REFERENCES `juego` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `jugador_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD CONSTRAINT `solicitud_ibfk_1` FOREIGN KEY (`id_jugador`) REFERENCES `jugador` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `solicitud_ibfk_2` FOREIGN KEY (`id_vacante`) REFERENCES `vacante` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `vacante`
--
ALTER TABLE `vacante`
  ADD CONSTRAINT `vacante_ibfk_1` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

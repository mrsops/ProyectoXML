-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-03-2019 a las 08:56:06
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `instalaciones_deportivas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instalaciones`
--

CREATE TABLE `instalaciones` (
  `IdInstalacion` int(11) NOT NULL,
  `Localizacion` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `Lugar` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `Longitud` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `Latitud` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `Es_Barrio` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `instalaciones`
--

INSERT INTO `instalaciones` (`IdInstalacion`, `Localizacion`, `Lugar`, `Longitud`, `Latitud`, `Es_Barrio`) VALUES
(1, 'CAZALLA', 'Centro de capacitación agraria', '-1.6872167587280273', '37.654245892818686', 0),
(2, 'PULGARA', 'AAVV Pulgara', '-1.681208610534668', '37.66857054857509', 0),
(3, 'SAN JOSE', 'Recinto institutos José Ibañez Martín y Francisco Ros Giner', '-1.6995227336883545', '37.669015740291044', 1),
(5, 'HOYA (LA)', 'Junto colegio de La Hoya', '-1.5864729881286621', '37.714173356222439', 0),
(6, 'SAN CRISTOBAL', 'Complejo Deportivo Europa', '-1.6888582706451416', '37.677373702407252', 1),
(7, 'SUTULLENA', 'Colegio Muñoz Barberán', '-1.6951212286949158', '37.669482558423176', 1),
(8, 'COY', 'Colegio de Coy', '-1.8129962682724', '37.949530033303311', 0),
(9, 'ANGELES (LOS)-APOLONIA', 'Parque de Los Angeles', '-1.6815733909606934', '37.685438329494495', 1),
(10, 'TOVA (LA)', 'Colegio de La Tova', '-1.8978989124298096', '37.728591849038942', 0),
(11, 'SAN CRISTOBAL', 'Parque San Diego', '-1.6923880577087402', '37.679851320896304', 1),
(12, 'SUTULLENA', 'Colegio José Robles', '-1.6949307918548584', '37.668873226154581', 1),
(13, 'BEJAR', 'Polígono industrial de Lorca', '-1.7613744735717773', '37.61600868889353', 0),
(14, 'RAMONETE', 'Las Librilleras', '-1.4540362358093262', '37.535058808569751', 0),
(15, 'SUTULLENA', 'Avenida de Santa Clara. Pabellón Alamedas', '-1.6925168037414551', '37.668472221222018', 1),
(16, 'SAN CRISTOBAL', 'Alfonso Embarre', '-1.6902637481689453', '37.68761666059325', 1),
(17, 'SAN ANTONIO', 'Parque de San Antonio', '-1.712418794631958', '37.65726125278001', 1),
(18, 'SAN ANTONIO', 'I.E.S. San Juan Bosco', '-1.7114344239234924', '37.658777380465679', 1),
(19, 'SAN ANTONIO', 'Complejo deportivo San Antonio', '-1.7113137245178223', '37.659386530192037', 1),
(20, 'AVILES', 'Colegio de Avilés', '-1.801385321832754', '37.907906693461321', 0),
(21, 'CARRASQUILLA', 'Campo López', '-1.5771442651748657', '37.588095652374669', 0),
(22, 'ZARCILLA DE RAMOS', 'Complejo piscinas de Zarcilla de Ramos', '-1.8666243553161621', '37.837726152097254', 0),
(23, 'SAN JOSE', 'I.E.S. Francisco Ros Giner', '-1.6998660564422607', '37.668005131341921', 1),
(24, 'RAMONETE', 'Rambla de Ramonete', '-1.4446377754211426', '37.5340038388823', 0),
(25, 'CAMPILLO', 'Colegio de El Campillo', '-1.6908162832260132', '37.649618298140474', 0),
(26, 'TORRECILLA', 'Ciudad deportiva de La Torrecilla', '-1.7310762405395508', '37.644431853410921', 0),
(27, 'SAN JOSE', 'Subida al Calvario', '-1.7043131589889526', '37.671981405328125', 1),
(28, 'TOVA (LA)', 'Entrada a La Parroquia', '-1.8879318237304688', '37.727095976037', 0),
(29, 'PARROQUIAS ALTAS', 'San Juan', '-1.69938325881958', '37.67835326982653', 1),
(30, 'MORATA', 'Frente colegio de Morata', '-1.4939314126968384', '37.58717746250602', 0),
(31, 'SAN JOSE', 'I.E.S. José Ibañez Martín', '-1.6992974281311035', '37.669295990755664', 1),
(32, 'PARRILLA', 'El Consejero', '-1.7606019973754883', '37.694717947129945', 0),
(33, 'PURIAS', 'Colegio de Purias', '-1.6713166236877441', '37.577041285970068', 0),
(34, 'SUTULLENA', 'Colegio de San Fernando', '-1.6940617561340332', '37.668378803481183', 1),
(35, 'ESCUCHA', 'La Campana casa animas', '-1.7315053939819336', '37.463656791199682', 0),
(36, 'MARCHENA', 'Colegio Narciso Yepes', '-1.6434860229492188', '37.668259908004579', 0),
(37, 'ZARCILLA DE RAMOS', 'Colegio de Zarcilla de Ramos', '-1.8740916252136231', '37.84076317064261', 0),
(38, 'MORATA', 'Colegio de San Juan', '-1.4903318881988525', '37.588699271025064', 0),
(40, 'SAN JOSE', 'Pabellón de San José', '-1.7049944400787354', '37.66629147016841', 1),
(41, 'TERCIA', 'Colegio Villaespesa', '-1.6448700428009033', '37.682746768460369', 0),
(42, 'SANTIAGO', 'Avenida de Santa Clara. Pista monopatín', '-1.6928778073283866', '37.677955305301346', 1),
(43, 'SAN CRISTOBAL', 'Colegio Sagrado Corazón', '-1.6933375597000122', '37.680744750469316', 1),
(44, 'ZARCILLA DE RAMOS', 'Salida hacia La Paca', '-1.8678903579711914', '37.852341881041362', 0),
(45, 'HOYA (LA)', 'Los Toyos', '-1.593468189239502', '37.700380235666913', 0),
(46, 'VIÑA (LA)', 'Colegio Pérez de Hita', '-1.7114746570587158', '37.663036811610148', 1),
(47, 'SAN CRISTOBAL', 'Colegio San Cristóbal', '-1.6945338249206543', '37.685984510238185', 1),
(48, 'AGUADERAS', 'Carretera de Campo López', '-1.5929853916168213', '37.634910704085677', 0),
(49, 'ALMENDRICOS', 'Afueras del casco de Almendricos', '-1.7760944366455078', '37.46439394507928', 0),
(50, 'PARROQUIAS ALTAS', 'Colegio de Santa María', '-1.7010462284088135', '37.678533711554095', 1),
(51, 'SAN CRISTOBAL', 'AAVV Río', '-1.7033153772354126', '37.687482141878249', 1),
(52, 'PURIAS', 'Instituto de Purias', '-1.6713970899581909', '37.579677159421536', 0),
(53, 'SAN JOSE', 'Colegio Alfonso X', '-1.7056542634963989', '37.665637524298965', 1),
(54, 'SUTULLENA', 'Avenida Sutullena', '-1.6977953910827637', '37.6613721378027', 1),
(55, 'SANTIAGO', 'I.E.S. Ramón Arcas Meca', '-1.6944533586502075', '37.676651921578276', 1),
(56, 'PURIAS', 'Junto instituto de Purias', '-1.671096682548523', '37.580110794180008', 0),
(57, 'CAZALLA', 'Colegio Virgen de Las Huertas', '-1.6776037216186523', '37.66099471453844', 0),
(58, 'VIÑA (LA)', 'Parque de La Viña', '-1.7070704698562622', '37.662720176115826', 1),
(59, 'ESCUCHA', 'La Campana unitaria', '-1.7267096042633057', '37.474375144631637', 0),
(60, 'HOYA (LA)', 'Colegio nuevo de La Hoya', '-1.5864676237106323', '37.713744747124984', 0),
(61, 'ALMENDRICOS', 'Colegio viejo Almendricos', '-1.7772048711776733', '37.47253169408453', 0),
(62, 'ZARZADILLA DE TOTANA', 'Colegio de Zarzadilla de Totana', '-1.7092108726501465', '37.878728317733078', 0),
(63, 'COY', 'Salida a Bullas', '-1.8194818496704102', '37.949033256123755', 0),
(64, 'PACA (LA)', 'Junto I.E.S. La Paca', '-1.836615800857544', '37.876873714780871', 0),
(65, 'PACA (LA)', 'Colegio de La Paca', '-1.8343734741210938', '37.8684022326721', 0),
(66, 'PACA (LA)', 'La Terreras', '-1.7890763282775879', '37.850396073137361', 0),
(67, 'HOYA (LA)', 'Colegio viejo de La Hoya', '-1.5958070755004883', '37.706976452711828', 0),
(68, 'ALMENDRICOS', 'Colegio nuevo Almendricos', '-1.7759817838668823', '37.469389634323754', 0),
(69, 'TORRECILLA', 'Estadio Francisco Artés Carrasco', '-1.7349386215209961', '37.638878396169829', 0),
(70, 'PACA (LA)', 'I.E.S. La Paca', '-1.8371790647506714', '37.876303933692533', 0),
(71, 'VIÑA (LA)', 'C.E.E. Pilar Soubrier', '-1.7105278372764587', '37.662871195224994', 1),
(72, 'ALMENDRICOS', 'Junto colegio nuevo de Almendricos', '-1.7767274379730225', '37.469234497023429', 0),
(73, 'RAMONETE', 'Puntas de Calnegre', '-1.4013630151748657', '37.510970780948078', 0),
(74, 'PARROQUIAS ALTAS', 'San Pedro. Detrás del plan social', '-1.7045089602470398', '37.675754860287348', 1),
(75, 'SAN CRISTOBAL', 'Colegio Juan González', '-1.6890567541122437', '37.6857967900816', 1),
(76, 'SAN CRISTOBAL', 'I.E.S. Príncipe de Asturias', '-1.6897058486938477', '37.679121072873791', 1),
(77, 'RIO (EL)', 'Huerta del nublo', '-1.7600977420806885', '37.697994826496675', 0),
(78, 'SAN JOSE', 'Colegio Andrés García Soler', '-1.7062577605247498', '37.670109799198073', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subinstalaciones`
--

CREATE TABLE `subinstalaciones` (
  `IdSubInstalacion` int(11) NOT NULL,
  `Uso` varchar(255) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `subinstalaciones`
--

INSERT INTO `subinstalaciones` (`IdSubInstalacion`, `Uso`) VALUES
(1, 'Vestuario'),
(2, 'Fútbol 7'),
(3, 'Pista polideportiva'),
(4, 'Fútbol'),
(5, 'Pista de tamaño reducido'),
(6, 'Pista polideportiva múltiple'),
(7, 'Modulo escolar nivel 3 (bm y vestuarios)'),
(8, 'Pista de petanca'),
(9, 'Gimnasio'),
(10, 'Circuito de cross'),
(11, 'Piscina de competición'),
(12, 'Piscina de chapoteo'),
(13, 'Pista de baloncesto'),
(14, 'Pista polideportiva múltiple cubierta'),
(15, 'Piscina de enseñanza'),
(16, 'Modulo escolar nivel 4 (bm, vestuarios, gradas)'),
(17, 'Pabellón polivalente'),
(18, 'Pista de voleibol'),
(19, 'Estadio de fútbol'),
(20, 'Modulo escolar nivel 2 (bc y vestuarios)'),
(21, 'Pista de monopatín'),
(22, 'Sala de tenis de mesa'),
(23, 'Circuitos deportivos'),
(24, 'Jacuzzi'),
(25, 'Masaje deportivo'),
(26, 'Pista de entrenamiento'),
(27, 'Sala de Judo'),
(28, 'Aula para reuniones, proyecciones, cursos, etc.'),
(29, 'Sauna'),
(30, 'Squash'),
(31, 'Sala de musculación'),
(32, 'Pista transversal'),
(33, 'Pista central'),
(34, 'Frontón'),
(35, 'Rocódromo'),
(36, 'Velódromo'),
(37, 'Pista de atletismo'),
(38, 'Piscina polivalente'),
(39, 'Pista de tenis');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienesubinstalaciones`
--

CREATE TABLE `tienesubinstalaciones` (
  `IdInstalacion` int(11) NOT NULL,
  `IdSubInstalacion` int(11) NOT NULL,
  `Cantidad` varchar(255) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `tienesubinstalaciones`
--

INSERT INTO `tienesubinstalaciones` (`IdInstalacion`, `IdSubInstalacion`, `Cantidad`) VALUES
(1, 1, '1'),
(1, 2, '1'),
(1, 3, '1'),
(2, 5, '1'),
(3, 10, '1'),
(5, 16, '1'),
(6, 11, '1'),
(6, 15, '3'),
(6, 22, '1'),
(6, 23, '1'),
(6, 24, '4'),
(6, 25, '4'),
(6, 26, '1'),
(6, 27, '1'),
(6, 28, '1'),
(6, 29, '4'),
(6, 30, '4'),
(6, 31, '1'),
(6, 32, '3'),
(6, 33, '1'),
(7, 5, '1'),
(8, 5, '1'),
(9, 1, '1'),
(9, 2, '1'),
(10, 3, '1'),
(11, 6, '1'),
(11, 8, '12'),
(12, 3, '2'),
(13, 1, '1'),
(13, 4, '1'),
(14, 1, '1'),
(14, 3, '1'),
(15, 16, '1'),
(16, 1, '2'),
(16, 2, '2'),
(16, 4, '1'),
(17, 2, '1'),
(17, 8, '4'),
(18, 1, '1'),
(18, 6, '1'),
(18, 9, '1'),
(19, 1, '7'),
(19, 7, '1'),
(19, 12, '1'),
(19, 15, '1'),
(20, 3, '1'),
(21, 5, '1'),
(22, 1, '1'),
(22, 12, '1'),
(22, 15, '1'),
(23, 3, '2'),
(23, 6, '1'),
(24, 4, '1'),
(25, 1, '1'),
(25, 6, '1'),
(26, 1, '5'),
(26, 3, '2'),
(26, 4, '2'),
(26, 6, '2'),
(26, 10, '1'),
(26, 11, '1'),
(26, 12, '1'),
(26, 15, '2'),
(26, 34, '1'),
(26, 35, '1'),
(26, 36, '1'),
(26, 37, '1'),
(26, 38, '1'),
(26, 39, '7'),
(27, 1, '1'),
(27, 3, '1'),
(28, 1, '1'),
(28, 2, '1'),
(28, 11, '1'),
(28, 12, '1'),
(29, 13, '1'),
(30, 3, '1'),
(31, 1, '1'),
(31, 3, '1'),
(31, 6, '1'),
(31, 9, '1'),
(32, 5, '1'),
(33, 1, '1'),
(33, 5, '1'),
(33, 6, '1'),
(34, 1, '1'),
(34, 3, '1'),
(34, 5, '1'),
(34, 9, '1'),
(35, 1, '1'),
(35, 3, '1'),
(35, 4, '1'),
(36, 1, '1'),
(36, 3, '1'),
(36, 5, '1'),
(37, 1, '1'),
(37, 14, '1'),
(38, 5, '1'),
(40, 1, '1'),
(40, 29, '1'),
(40, 31, '1'),
(40, 32, '3'),
(40, 33, '1'),
(41, 1, '1'),
(41, 3, '2'),
(42, 21, '1'),
(43, 1, '1'),
(43, 3, '1'),
(44, 1, '1'),
(44, 4, '1'),
(45, 1, '1'),
(45, 2, '2'),
(45, 4, '1'),
(46, 1, '1'),
(46, 3, '1'),
(46, 5, '1'),
(46, 14, '1'),
(47, 1, '1'),
(47, 3, '3'),
(48, 1, '1'),
(48, 3, '1'),
(48, 4, '1'),
(49, 1, '1'),
(49, 4, '1'),
(50, 1, '1'),
(50, 3, '2'),
(51, 5, '1'),
(52, 3, '1'),
(52, 9, '1'),
(52, 18, '2'),
(53, 6, '3'),
(54, 3, '1'),
(55, 1, '1'),
(55, 3, '3'),
(55, 9, '1'),
(56, 17, '1'),
(57, 1, '1'),
(57, 14, '1'),
(58, 3, '1'),
(59, 5, '1'),
(60, 3, '1'),
(61, 1, '1'),
(62, 1, '1'),
(62, 4, '1'),
(62, 17, '1'),
(63, 1, '1'),
(63, 3, '1'),
(63, 4, '1'),
(64, 1, '1'),
(64, 4, '1'),
(65, 1, '1'),
(65, 3, '1'),
(66, 4, '1'),
(67, 3, '1'),
(68, 1, '1'),
(68, 3, '1'),
(69, 1, '1'),
(69, 2, '1'),
(69, 4, '2'),
(69, 19, '1'),
(70, 3, '1'),
(70, 9, '1'),
(71, 3, '1'),
(72, 7, '1'),
(73, 5, '1'),
(74, 3, '1'),
(75, 1, '1'),
(75, 3, '2'),
(75, 9, '1'),
(76, 6, '2'),
(76, 20, '1'),
(77, 1, '1'),
(77, 4, '1'),
(78, 1, '1'),
(78, 3, '1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `instalaciones`
--
ALTER TABLE `instalaciones`
  ADD PRIMARY KEY (`IdInstalacion`);

--
-- Indices de la tabla `subinstalaciones`
--
ALTER TABLE `subinstalaciones`
  ADD PRIMARY KEY (`IdSubInstalacion`),
  ADD KEY `IdSubInstalacion` (`IdSubInstalacion`);

--
-- Indices de la tabla `tienesubinstalaciones`
--
ALTER TABLE `tienesubinstalaciones`
  ADD PRIMARY KEY (`IdInstalacion`,`IdSubInstalacion`),
  ADD KEY `IdSubInstalacion` (`IdSubInstalacion`),
  ADD KEY `IdInstalacion` (`IdInstalacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `instalaciones`
--
ALTER TABLE `instalaciones`
  MODIFY `IdInstalacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- AUTO_INCREMENT de la tabla `subinstalaciones`
--
ALTER TABLE `subinstalaciones`
  MODIFY `IdSubInstalacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tienesubinstalaciones`
--
ALTER TABLE `tienesubinstalaciones`
  ADD CONSTRAINT `tienesubinstalaciones_ibfk_1` FOREIGN KEY (`IdInstalacion`) REFERENCES `instalaciones` (`IdInstalacion`),
  ADD CONSTRAINT `tienesubinstalaciones_ibfk_2` FOREIGN KEY (`IdSubInstalacion`) REFERENCES `subinstalaciones` (`IdSubInstalacion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

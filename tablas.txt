-- MariaDB dump 10.18  Distrib 10.5.7-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: tienda
-- ------------------------------------------------------
-- Server version	10.5.7-MariaDB-1:10.5.7+maria~focal

-- Miercoles 12 de Enero de 2021 20:23 (8:23 pm)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `anuncio`
--

DROP TABLE IF EXISTS `anuncio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `anuncio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `id_comprador` int(11),
  `id_catalogo_condicion` int(11) NOT NULL,
  `id_catalogo_forma_pago` int(11) NOT NULL,
  `id_catalogo_zona_entrega` int(11) NOT NULL,
  `id_catalogo_departamento` int(11) NOT NULL,
  `descripcion` varchar(2048) NOT NULL,
  `vigencia` date NOT NULL,
  `datos_contacto` varchar(256) DEFAULT NULL,
  `validado` tinyint(1) NOT NULL,
  `notificado` tinyint(1) NOT NULL,
  `revisado` tinyint(1) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `comprado` tinyint(1) DEFAULT NULL,
  `fecha_compra` date DEFAULT NULL,
  `estrellas_ven` int(11) DEFAULT NULL,
  `estrellas_com` int(11) DEFAULT NULL,
  `nombre` varchar(64) not null,
  `precio` double(8,2) not null,
  `comentario` varchar(1024) DEFAULT NULL,
  `comentario_aprobado` tinyint(1),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anuncio`
--

LOCK TABLES `anuncio` WRITE;
/*!40000 ALTER TABLE `anuncio` DISABLE KEYS */;
/*!40000 ALTER TABLE `anuncio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalogo`
--

DROP TABLE IF EXISTS `catalogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catalogo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_catalogo_categoria` int(11) NOT NULL,
  `nombre` varchar(128) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_catalogo_categoria` (`id_catalogo_categoria`),
  CONSTRAINT `fk_catalogo_categoria` FOREIGN KEY (`id_catalogo_categoria`) REFERENCES `catalogo_maestro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalogo`
--

LOCK TABLES `catalogo` WRITE;

INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (1, "Usado", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (1, "Semi nuevo", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (1, "Nuevo", 1);

INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (2, "Mascotas", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (2, "Linea Blanca", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (2, "Electronica", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (2, "Deportes", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (2, "Musica", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (2, "Belleza", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (2, "Salud - Cuidado personal", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (2, "Productos del hogar", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (2, "Alimentos", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (2, "Hogar", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (2, "Otros", 1);

INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (3, "Alvaro Obregon", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (3, "Azcapotzalco", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (3, "Benito Juarez", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (3, "Coyoacan", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (3, "Cuajimalpa", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (3, "Cuauhtemoc", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (3, "Gustavo A. Madero", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (3, "Iztacalco", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (3, "Iztapalapa", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (3, "Magdalena Contreras", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (3, "Miguel Hidalgo", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (3, "Milpa Alta", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (3, "Tlahuac", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (3, "Tlalpan", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (3, "Venustiano Carranza", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (3, "Xochimilco", 1);

INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (4, "Tarjeta", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (4, "Cheque", 1);
INSERT INTO catalogo (id_catalogo_categoria,nombre, activo) VALUES (4, "Efectivo", 1);

delimiter $$
CREATE TRIGGER otros_lock BEFORE UPDATE ON catalogo
FOR EACH ROW
BEGIN 
    IF old.nombre = "Otros" THEN
        SET new.nombre = "Otros";
        SET new.activo = 1;
    END IF;
END$$
delimiter ;


/*!40000 ALTER TABLE `catalogo` DISABLE KEYS */;
/*!40000 ALTER TABLE `catalogo` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `catalogo_maestro`
--

DROP TABLE IF EXISTS `catalogo_maestro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catalogo_maestro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_catalogo` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalogo_maestro`
--

LOCK TABLES `catalogo_maestro` WRITE;

INSERT into catalogo_maestro (tipo_catalogo) VALUES ("Condicion"); 
INSERT into catalogo_maestro (tipo_catalogo) VALUES ("Departamento");
INSERT into catalogo_maestro (tipo_catalogo) VALUES ("Alcaldia");
INSERT into catalogo_maestro (tipo_catalogo) VALUES ("Forma de pago");

/*!40000 ALTER TABLE `catalogo_maestro` DISABLE KEYS */;
/*!40000 ALTER TABLE `catalogo_maestro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_anuncio` int(11) NOT NULL,
  `id_remitente` int(11) NOT NULL,
  `id_hilo_padre` int(11) NOT NULL,
  `mensaje` varchar(200) NOT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_anuncio` (`id_anuncio`),
  KEY `fk_id_remitente` (`id_remitente`),
  CONSTRAINT `fk_id_anuncio` FOREIGN KEY (`id_anuncio`) REFERENCES `anuncio` (`id`),
  CONSTRAINT `fk_id_remitente` FOREIGN KEY (`id_remitente`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `multimedia`
--

DROP TABLE IF EXISTS `multimedia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `multimedia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_anuncio` int(11) NOT NULL,
  `tipo` varchar(32) NOT NULL,
  `url` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_multimedia_anuncio` (`id_anuncio`),
  CONSTRAINT `fk_multimedia_anuncio` FOREIGN KEY (`id_anuncio`) REFERENCES `anuncio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `multimedia`
--

LOCK TABLES `multimedia` WRITE;
/*!40000 ALTER TABLE `multimedia` DISABLE KEYS */;
/*!40000 ALTER TABLE `multimedia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preregistro`
--

DROP TABLE IF EXISTS `preregistro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preregistro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick` varchar(32) NOT NULL,
  `correo` varchar(92) NOT NULL,
  `clave_hash` varchar(128) NOT NULL,
  `telefono` varchar(32) NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `random_string` varchar(32) NOT NULL,
  `instante_registro` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_preregistro_random_string` (`random_string`),
  UNIQUE KEY `idx_preregistro_correo` (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preregistro`
--

LOCK TABLES `preregistro` WRITE;
/*!40000 ALTER TABLE `preregistro` DISABLE KEYS */;
/*!40000 ALTER TABLE `preregistro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;

insert into rol values(1, 'admin', true);
insert into rol values(2, 'normal', true);
insert into rol values(3, 'operador', true);
insert into rol values(4, 'capturista', true);

/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(128) NOT NULL,
  `clave` varchar(128) NOT NULL DEFAULT 'temp',
  `creado` bigint(20) NOT NULL DEFAULT 0,
  `activo` tinyint(1) NOT NULL DEFAULT 0,
  `acceso_negado_contador` int(11) NOT NULL DEFAULT 0,
  `instante_bloqueo` bigint(20) NOT NULL DEFAULT 0,
  `instante_ultimo_acceso` bigint(20) NOT NULL DEFAULT 0,
  `instante_ultimo_cambio_clave` bigint(20) NOT NULL DEFAULT 0,
  `regenera_clave_token` varchar(128) NOT NULL DEFAULT 'NA',
  `regenera_clave_instante` bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_usuario_correo` (`correo`),
  KEY `idx_usuario_regenera` (`regenera_clave_token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_detalle`
--

DROP TABLE IF EXISTS `usuario_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_detalle` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `apellido_paterno` varchar(32) NOT NULL,
  `apellido_materno` varchar(32) NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `nick_name` varchar(128) NOT NULL,
  `telefono_celular` varchar(128) NOT NULL,
  `foto` varchar(128) DEFAULT NULL,
  `descripcion` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `fk_usuario_detalle_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_detalle`
--

LOCK TABLES `usuario_detalle` WRITE;
/*!40000 ALTER TABLE `usuario_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_rol`
--

DROP TABLE IF EXISTS `usuario_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_rol` (
  `id_usuario` int(11) NOT NULL,
  `id_rol` int(12) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_rol`),
  KEY `fk_rol` (`id_rol`),
  CONSTRAINT `fk_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`),
  CONSTRAINT `fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_rol`
--

LOCK TABLES `usuario_rol` WRITE;
/*!40000 ALTER TABLE `usuario_rol` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_rol` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-30  1:17:19
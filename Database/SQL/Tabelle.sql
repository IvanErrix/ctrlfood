CREATE DATABASE  IF NOT EXISTS `ctrlfood` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ctrlfood`;

--
-- Table structure for table `amministratore`
--

DROP TABLE IF EXISTS `amministratore`;
CREATE TABLE `amministratore` (
  `idamministratore` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idamministratore`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `carrello`
--

DROP TABLE IF EXISTS `carrello`;
CREATE TABLE `carrello` (
  `idcarrello` int(11) NOT NULL AUTO_INCREMENT,
  `pagato` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`idcarrello`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `carrello_prodotto`
--

DROP TABLE IF EXISTS `carrello_prodotto`;
CREATE TABLE `carrello_prodotto` (
  `idcarrello` int(11) NOT NULL,
  `idprodotto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `carta_fedelta`
--

DROP TABLE IF EXISTS `carta_fedelta`;
CREATE TABLE `carta_fedelta` (
  `idcarta_fedelta` int(11) NOT NULL AUTO_INCREMENT,
  `punti` double NOT NULL DEFAULT '0',
  `punti_ortofrutta` double NOT NULL DEFAULT '0',
  `punti_latticini` double NOT NULL DEFAULT '0',
  `punti_farinacei` double NOT NULL DEFAULT '0',
  `punti_uova` double NOT NULL DEFAULT '0',
  `punti_confezionati` double NOT NULL DEFAULT '0',
  `data` date NOT NULL,
  `chiavecliente` int(11) NOT NULL,
  PRIMARY KEY (`idcarta_fedelta`),
  KEY `fk_cliente_idx` (`chiavecliente`),
  CONSTRAINT `fk_cliente` FOREIGN KEY (`chiavecliente`) REFERENCES `cliente` (`idcliente`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `codice_fiscale` varchar(45) NOT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `deposito`
--

DROP TABLE IF EXISTS `deposito`;
CREATE TABLE `deposito` (
  `iddeposito` int(11) NOT NULL AUTO_INCREMENT,
  `luogo` varchar(45) NOT NULL,
  `grandezza` int(11) NOT NULL,
  PRIMARY KEY (`iddeposito`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `deposito_prodotto`
--

DROP TABLE IF EXISTS `deposito_prodotto`;
CREATE TABLE `deposito_prodotto` (
  `iddeposito` int(11) NOT NULL,
  `idprodotto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `negozio`
--

DROP TABLE IF EXISTS `negozio`;
CREATE TABLE `negozio` (
  `idnegozio` int(11) NOT NULL DEFAULT '1',
  `nome` varchar(45) NOT NULL,
  `luogo` varchar(45) NOT NULL,
  `grandezza` int(11) NOT NULL,
  PRIMARY KEY (`idnegozio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `negozio_prodotto`
--

DROP TABLE IF EXISTS `negozio_prodotto`;
CREATE TABLE `negozio_prodotto` (
  `idnegozio` int(11) NOT NULL,
  `idprodotto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
CREATE TABLE `pagamento` (
  `idpagamento` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `chiavecarrello` int(11) NOT NULL,
  `chiavecarta_fedelta` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpagamento`),
  KEY `fk_carrello_idx` (`chiavecarrello`),
  KEY `fk_carta_fedelta_idx` (`chiavecarta_fedelta`),
  CONSTRAINT `fk_carrello` FOREIGN KEY (`chiavecarrello`) REFERENCES `carrello` (`idcarrello`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_carta_fedelta` FOREIGN KEY (`chiavecarta_fedelta`) REFERENCES `carta_fedelta` (`idcarta_fedelta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `prodotto`
--

DROP TABLE IF EXISTS `prodotto`;
CREATE TABLE `prodotto` (
  `idprodotto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `prezzo` double NOT NULL,
  `quantita` int(11) NOT NULL,
  `data_scadenza` date NOT NULL,
  `ortofrutta` tinyint(4) DEFAULT '0',
  `latticino` tinyint(4) DEFAULT '0',
  `farinaceo` tinyint(4) DEFAULT '0',
  `uovo` tinyint(4) DEFAULT '0',
  `confezionato` tinyint(4) DEFAULT '0',
  `data_raccolta` date DEFAULT NULL,
  `data_produzione` date DEFAULT NULL,
  `data_mungitura` date DEFAULT NULL,
  `data_deposizione` date DEFAULT NULL,
  `data_confezionamento` date DEFAULT NULL,
  PRIMARY KEY (`idprodotto`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE DATABASE  IF NOT EXISTS `ctrlfood` ;
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
DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%`TRIGGER `ctrlfood`.`carrello_BEFORE_DELETE` BEFORE DELETE ON `carrello` FOR EACH ROW
BEGIN
	DELETE FROM prodotto WHERE idprodotto IN (SELECT idprodotto FROM carrello_prodotto);
END ;;
DELIMITER ;
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
DELIMITER ;;

CREATE DEFINER=`ctrlfood`@`%` TRIGGER `ctrlfood`.`carta_fedelta_BEFORE_INSERT` BEFORE INSERT ON `carta_fedelta` FOR EACH ROW
BEGIN
	IF NEW.data!=curdate() THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'ERRORE DATA CARTA FEDELTA';
	END IF;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` TRIGGER `ctrlfood`.`carta_fedelta_BEFORE_UPDATE` BEFORE UPDATE ON `carta_fedelta` FOR EACH ROW
BEGIN
	IF NEW.data!=curdate() THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'ERRORE DATA CARTA FEDELTA';
	END IF;
END ;;
DELIMITER ;
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
DELIMITER ;;

CREATE DEFINER=`ctrlfood`@`%` TRIGGER `ctrlfood`.`cliente_BEFORE_INSERT` BEFORE INSERT ON `cliente` FOR EACH ROW
BEGIN
	IF CHAR_LENGTH(NEW.codice_fiscale)!=16 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'ERRORE CODICE FISCALE';
	END IF;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` TRIGGER `ctrlfood`.`cliente_CREA_CARTAFEDELTA` AFTER INSERT ON `cliente` FOR EACH ROW
BEGIN
	INSERT INTO carta_fedelta (chiavecliente, data)
    VALUES (NEW.idcliente, CURDATE());
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` TRIGGER `ctrlfood`.`cliente_BEFORE_UPDATE` BEFORE UPDATE ON `cliente` FOR EACH ROW
BEGIN
	IF CHAR_LENGTH(NEW.codice_fiscale)!=16 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'ERRORE CODICE FISCALE';
	END IF;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` TRIGGER `ctrlfood`.`cliente_AFTER_DELETE` AFTER DELETE ON `cliente` FOR EACH ROW
BEGIN
	DELETE FROM carta_fedelta WHERE chiavecliente=OLD.idcliente;
END ;;
DELIMITER ;
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
DELIMITER ;;

CREATE DEFINER=`ctrlfood`@`%` TRIGGER `ctrlfood`.`pagamento_AFTER_DELETE` AFTER DELETE ON `pagamento` FOR EACH ROW
BEGIN
	DELETE FROM carrello WHERE idcarrello = OLD.chiavecarrello;
END ;;
DELIMITER ;
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
DELIMITER ;;

CREATE DEFINER=`ctrlfood`@`%` TRIGGER `ctrlfood`.`prodotto_BEFORE_INSERT` BEFORE INSERT ON `prodotto` FOR EACH ROW
BEGIN
	-- CONTROLLO DATA SCADENZA
	IF NEW.data_scadenza>=curdate() THEN
    
		/*CONTROLLO INSERIMENTO ORTOFRUTTA*/
        IF NEW.ortofrutta=1 AND NEW.latticino=0 AND NEW.farinaceo=0 AND NEW.uovo=0 AND NEW.confezionato=0 THEN
			IF NEW.data_scadenza<NEW.data_raccolta OR NEW.data_raccolta IS NULL OR NEW.data_produzione IS NOT NULL OR NEW.data_mungitura IS NOT NULL OR NEW.data_deposizione IS NOT NULL OR NEW.data_confezionamento IS NOT NULL THEN
				SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'DATI INCORRETTI ORTOFRUTTA';
			END IF;
            
		-- CONTROLLO INSERIMENTO LATTICINO           
		ELSEIF NEW.latticino=1 AND NEW.ortofrutta=0 AND NEW.farinaceo=0 AND NEW.uovo=0 AND NEW.confezionato=0 THEN
			IF NEW.data_mungitura>NEW.data_produzione OR NEW.data_scadenza<NEW.data_produzione OR NEW.data_scadenza<NEW.data_mungitura OR NEW.data_mungitura IS NULL OR NEW.data_produzione IS NULL OR NEW.data_raccolta IS NOT NULL OR NEW.data_deposizione IS NOT NULL OR NEW.data_confezionamento IS NOT NULL THEN
				SIGNAL SQLSTATE '45000'
				SET MESSAGE_TEXT = 'DATI INCORRETTI LATTICINO';
			END IF;
            
		-- CONTROLLO INSERIMENTO FARINACEO
		ELSEIF NEW.farinaceo=1 AND NEW.ortofrutta=0 AND NEW.latticino=0 AND NEW.uovo=0 AND NEW.confezionato=0 THEN
			IF NEW.data_scadenza<NEW.data_produzione OR NEW.data_produzione IS NULL OR NEW.data_raccolta IS NOT NULL OR NEW.data_mungitura IS NOT NULL OR NEW.data_deposizione IS NOT NULL OR NEW.data_confezionamento IS NOT NULL THEN
				SIGNAL SQLSTATE '45000'
				SET MESSAGE_TEXT = 'DATI INCORRETTI FARINACEO';
			END IF;
            
		-- CONTROLLO INSERIMENTO UOVO
		ELSEIF NEW.uovo=1 AND NEW.ortofrutta=0 AND NEW.latticino=0 AND NEW.farinaceo=0 AND NEW.confezionato=0 THEN
			IF NEW.data_scadenza<NEW.data_deposizione OR NEW.data_deposizione IS NULL OR NEW.data_raccolta IS NOT NULL OR NEW.data_produzione IS NOT NULL OR NEW.data_mungitura IS NOT NULL OR NEW.data_confezionamento IS NOT NULL THEN
				SIGNAL SQLSTATE '45000'
				SET MESSAGE_TEXT = 'DATI INCORRETTI UOVO';
			END IF;
            
		-- CONTROLLO INSERIMENTO CONFEZIONATO
		ELSEIF NEW.confezionato=1 AND NEW.ortofrutta=0 AND NEW.latticino=0 AND NEW.farinaceo=0 AND NEW.uovo=0 THEN
			IF NEW.data_scadenza<NEW.data_confezionamento OR NEW.data_confezionamento IS NULL OR NEW.data_raccolta IS NOT NULL OR NEW.data_produzione IS NOT NULL OR NEW.data_mungitura IS NOT NULL OR NEW.data_deposizione IS NOT NULL THEN
				SIGNAL SQLSTATE '45000'
				SET MESSAGE_TEXT = 'DATI INCORRETTI CONFEZIONATO';
			END IF;
            
		ELSE
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'DATI NON CORRETTI';
		END IF;
        
	ELSE
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'ERRORE DATA SCADENZA';
	END IF;
    
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` TRIGGER `ctrlfood`.`prodotto_BEFORE_UPDATE` BEFORE UPDATE ON `prodotto` FOR EACH ROW
BEGIN
	-- CONTROLLO DATA SCADENZA
	IF NEW.data_scadenza>=curdate() THEN
    
		-- CONTROLLO INSERIMENTO ORTOFRUTTA
        IF NEW.ortofrutta=1 AND NEW.latticino=0 AND NEW.farinaceo=0 AND NEW.uovo=0 AND NEW.confezionato=0 THEN
			IF NEW.data_scadenza<NEW.data_raccolta OR NEW.data_raccolta IS NULL OR NEW.data_produzione IS NOT NULL OR NEW.data_mungitura IS NOT NULL OR NEW.data_deposizione IS NOT NULL OR NEW.data_confezionamento IS NOT NULL THEN
				SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'DATI INCORRETTI ORTOFRUTTA';
			END IF;
            
		-- CONTROLLO INSERIMENTO LATTICINO          
		ELSEIF NEW.latticino=1 AND NEW.ortofrutta=0 AND NEW.farinaceo=0 AND NEW.uovo=0 AND NEW.confezionato=0 THEN
			IF NEW.data_mungitura>NEW.data_produzione OR NEW.data_scadenza<NEW.data_produzione OR NEW.data_scadenza<NEW.data_mungitura OR NEW.data_mungitura IS NULL OR NEW.data_produzione IS NULL OR NEW.data_raccolta IS NOT NULL OR NEW.data_deposizione IS NOT NULL OR NEW.data_confezionamento IS NOT NULL THEN
				SIGNAL SQLSTATE '45000'
				SET MESSAGE_TEXT = 'DATI INCORRETTI LATTICINO';
			END IF;
            
		-- CONTROLLO INSERIMENTO FARINACEO
		ELSEIF NEW.farinaceo=1 AND NEW.ortofrutta=0 AND NEW.latticino=0 AND NEW.uovo=0 AND NEW.confezionato=0 THEN
			IF NEW.data_scadenza<NEW.data_produzione OR NEW.data_produzione IS NULL OR NEW.data_raccolta IS NOT NULL OR NEW.data_mungitura IS NOT NULL OR NEW.data_deposizione IS NOT NULL OR NEW.data_confezionamento IS NOT NULL THEN
				SIGNAL SQLSTATE '45000'
				SET MESSAGE_TEXT = 'DATI INCORRETTI FARINACEO';
			END IF;
            
		-- CONTROLLO INSERIMENTO UOVO
		ELSEIF NEW.uovo=1 AND NEW.ortofrutta=0 AND NEW.latticino=0 AND NEW.farinaceo=0 AND NEW.confezionato=0 THEN
			IF NEW.data_scadenza<NEW.data_deposizione OR NEW.data_deposizione IS NULL OR NEW.data_raccolta IS NOT NULL OR NEW.data_produzione IS NOT NULL OR NEW.data_mungitura IS NOT NULL OR NEW.data_confezionamento IS NOT NULL THEN
				SIGNAL SQLSTATE '45000'
				SET MESSAGE_TEXT = 'DATI INCORRETTI UOVO';
			END IF;
            
		-- CONTROLLO INSERIMENTO CONFEZIONATO
		ELSEIF NEW.confezionato=1 AND NEW.ortofrutta=0 AND NEW.latticino=0 AND NEW.farinaceo=0 AND NEW.uovo=0 THEN
			IF NEW.data_scadenza<NEW.data_confezionamento OR NEW.data_confezionamento IS NULL OR NEW.data_raccolta IS NOT NULL OR NEW.data_produzione IS NOT NULL OR NEW.data_mungitura IS NOT NULL OR NEW.data_deposizione IS NOT NULL THEN
				SIGNAL SQLSTATE '45000'
				SET MESSAGE_TEXT = 'DATI INCORRETTI CONFEZIONATO';
			END IF;
            
		ELSE
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'DATI NON CORRETTI';
		END IF;
        
	ELSE
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'ERRORE DATA SCADENZA';
	END IF;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` TRIGGER `ctrlfood`.`prodotto_AFTER_DELETE` AFTER DELETE ON `prodotto` FOR EACH ROW
BEGIN
	DELETE FROM deposito_prodotto WHERE idprodotto = OLD.idprodotto;
    DELETE FROM negozio_prodotto WHERE idprodotto = OLD.idprodotto;
END ;;
DELIMITER ;
--
-- Dumping routines for database 'ctrlfood'
--
DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` FUNCTION `controlla_dati_login`(username_login VARCHAR(20), password_login VARCHAR(20)) RETURNS int(11)
BEGIN
	DECLARE idamministratore_da_restituire INTEGER;
	SELECT idamministratore INTO idamministratore_da_restituire
    FROM amministratore
    WHERE username=username_login AND password=password_login;
RETURN idamministratore_da_restituire;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `aggiorna_carrello`(idcarrello_selezionato INT)
BEGIN
	UPDATE carrello SET pagato=true WHERE idcarrello=idcarrello_selezionato;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `aggiorna_dati_cliente`(idcliente_selezionato INT, nome_modificato VARCHAR(20), cognome_modificato VARCHAR(20), codice_fiscale_modificato VARCHAR(16))
BEGIN
	UPDATE cliente SET nome=nome_modificato, cognome=cognome_modificato, codice_fiscale=codice_fiscale_modificato WHERE idcliente=idcliente_selezionato;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `aggiorna_punti`(puntiortofrutta double, puntilatticini double, puntifarinacei double, puntiuova double, punticonfezionati double, puntitotali double, cartafedelta int)
BEGIN
	UPDATE carta_fedelta SET punti_ortofrutta = punti_ortofrutta + puntiortofrutta, punti_latticini = punti_latticini + puntilatticini, 
    punti_farinacei = punti_farinacei + puntifarinacei, punti_uova = punti_uova + puntiuova, punti_confezionati = punti_confezionati + punticonfezionati, punti = punti + puntitotali 
    WHERE idcarta_fedelta=cartafedelta;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `aggiungi_cliente`(nome VARCHAR(20), cognome VARCHAR(20), codice_fiscale VARCHAR(20))
BEGIN
	INSERT INTO cliente (nome, cognome, codice_fiscale)
    VALUES (nome, cognome, codice_fiscale);
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `aggiungi_confezionato_depostio`(nome VARCHAR(20), prezzo DOUBLE, quantita INT(11), data_scadenza DATE, confezionato TINYINT(4), data_confezionamento DATE)
BEGIN
	INSERT INTO prodotto (nome, prezzo, quantita, data_scadenza, confezionato, data_confezionamento)
    VALUES (nome, prezzo, quantita, data_scadenza, confezionato, data_confezionamento);
    INSERT INTO deposito_prodotto (iddeposito, idprodotto)
    VALUES (1, last_insert_id());
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `aggiungi_farinaceo_deposito`(nome VARCHAR(20), prezzo DOUBLE, quantita INT, data_scadenza Date, farinaceo TINYINT(4), data_produzione DATE)
BEGIN
	INSERT INTO prodotto (nome, prezzo, quantita, data_scadenza, farinaceo, data_produzione)
    VALUES (nome, prezzo, quantita, data_scadenza, farinaceo, data_produzione);
    INSERT INTO deposito_prodotto (iddeposito, idprodotto)
    VALUES (1, last_insert_id());
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `aggiungi_latticino_deposito`(nome VARCHAR(20), prezzo DOUBLE, quantita INT(11), data_scadenza DATE, latticino TINYINT(4), data_mungitura DATE, data_produzione DATE)
BEGIN
	INSERT INTO prodotto (nome, prezzo, quantita, data_scadenza, latticino, data_mungitura, data_produzione)
    VALUES (nome, prezzo, quantita, data_scadenza, latticino, data_mungitura, data_produzione);
    INSERT INTO deposito_prodotto (iddeposito, idprodotto)
    VALUES (1, last_insert_id());
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `aggiungi_ortofrutta_deposito`(nome VARCHAR(20), prezzo DOUBLE, quantita INT(11), data_scadenza DATE, ortofrutta TINYINT(4), data_raccolta DATE)
BEGIN
	INSERT INTO prodotto (nome, prezzo, quantita, data_scadenza, ortofrutta, data_raccolta)
    VALUES (nome, prezzo, quantita, data_scadenza, ortofrutta, data_raccolta);
    INSERT INTO deposito_prodotto (iddeposito, idprodotto)
    VALUES (1, last_insert_id());
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `aggiungi_pagamento`(chiavecarrello_selezionato int, chiavecarta_fedelta_selezionata int)
BEGIN
	INSERT INTO pagamento (data, chiavecarrello, chiavecarta_fedelta)
    VALUES (curdate(), chiavecarrello_selezionato, chiavecarta_fedelta_selezionata);
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `aggiungi_prodotto_carrello`(idcarrello_selezionato int, idprodotto_selezionato int, quantita_selezionata int)
BEGIN
CREATE TEMPORARY TABLE tab2 AS (
SELECT *
FROM prodotto 
WHERE idprodotto IN ( SELECT idprodotto 
					FROM negozio_prodotto 
					WHERE idprodotto=idprodotto_selezionato));
UPDATE tab2 SET quantita=quantita_selezionata WHERE idprodotto= idprodotto_selezionato;
INSERT INTO prodotto (nome, prezzo, quantita, data_scadenza, ortofrutta, latticino, farinaceo, uovo, confezionato, data_raccolta, data_produzione, data_mungitura, data_deposizione, data_confezionamento)
			SELECT nome, prezzo, quantita, data_scadenza, ortofrutta, latticino, farinaceo, uovo, confezionato, data_raccolta, data_produzione, data_mungitura, data_deposizione, data_confezionamento 
			FROM tab2
			WHERE idprodotto=idprodotto_selezionato;
DROP TEMPORARY TABLE IF EXISTS tab2;
INSERT INTO carrello_prodotto (idprodotto, idcarrello)
VALUES (last_insert_id(), idcarrello_selezionato);
UPDATE prodotto SET quantita= quantita-quantita_selezionata WHERE idprodotto=idprodotto_selezionato;
DELETE FROM prodotto WHERE quantita = 0;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `aggiungi_prodotto_negozio`(idprodotto_da_cercare INT, quantita_selezionata INT)
BEGIN
CREATE TEMPORARY TABLE vecchio AS (
SELECT *
FROM prodotto 
WHERE idprodotto IN ( SELECT idprodotto 
					FROM deposito_prodotto 
					WHERE idprodotto=idprodotto_da_cercare));
UPDATE vecchio SET quantita=quantita_selezionata WHERE idprodotto= idprodotto_da_cercare;
INSERT INTO prodotto (nome, prezzo, quantita, data_scadenza, ortofrutta, latticino, farinaceo, uovo, confezionato, data_raccolta, data_produzione, data_mungitura, data_deposizione, data_confezionamento)
			SELECT nome, prezzo, quantita, data_scadenza, ortofrutta, latticino, farinaceo, uovo, confezionato, data_raccolta, data_produzione, data_mungitura, data_deposizione, data_confezionamento 
			FROM vecchio
			WHERE idprodotto=idprodotto_da_cercare;
DROP TEMPORARY TABLE IF EXISTS vecchio;
INSERT INTO negozio_prodotto (idprodotto, idnegozio)
VALUES (last_insert_id(), 1);
UPDATE prodotto SET quantita= quantita-quantita_selezionata WHERE idprodotto=idprodotto_da_cercare;
DELETE FROM prodotto WHERE quantita = 0;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `aggiungi_uovo_deposito`(nome VARCHAR(20), prezzo DOUBLE, quantita INT, data_scadenza DATE, uovo TINYINT(4), data_deposizione DATE)
BEGIN
	INSERT INTO prodotto (nome, prezzo, quantita, data_scadenza, uovo, data_deposizione)
    VALUES (nome, prezzo, quantita, data_scadenza, uovo, data_deposizione);
    INSERT INTO deposito_prodotto (iddeposito, idprodotto)
    VALUES (1, last_insert_id());
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `crea_carrello`()
BEGIN
	INSERT INTO carrello ()
    VALUES ();
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `elimina_carrelli_non_pagati`()
BEGIN
	CREATE TEMPORARY TABLE IF NOT EXISTS tab3 AS (
    SELECT idcarrello, idprodotto FROM carrello_prodotto WHERE idcarrello IN (SELECT idcarrello FROM carrello WHERE pagato=0)
    );
    UPDATE tab3 SET idcarrello=1;
	DELETE FROM carrello_prodotto WHERE idcarrello IN (SELECT idcarrello FROM carrello WHERE pagato=0);
	DELETE FROM carrello WHERE pagato=0;
    INSERT INTO negozio_prodotto (idnegozio, idprodotto)
    SELECT idcarrello, idprodotto FROM tab3;
    DROP TEMPORARY TABLE IF EXISTS tab3;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `elimina_cliente`(idcliente_da_eliminare INT)
BEGIN
	DELETE FROM cliente WHERE idcliente=idcliente_da_eliminare;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `elimina_prodotto`(idprodotto_da_eliminare INT)
BEGIN
	DELETE FROM prodotto WHERE idprodotto=idprodotto_da_eliminare;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `elimina_prodotto_carrello`(idprodotto_selezionato INT)
BEGIN
	INSERT INTO negozio_prodotto (idnegozio, idprodotto)
    VALUES (1, idprodotto_selezionato);
    DELETE FROM carrello_prodotto WHERE idprodotto = idprodotto_selezionato;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `recupera_carrello`()
BEGIN
	SELECT idcarrello FROM carrello WHERE pagato=0;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `recupera_clienti`()
BEGIN
	SELECT *
    FROM cliente;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `recupera_prodotti_carrello`()
BEGIN
CREATE TEMPORARY TABLE tab AS (
SELECT idprodotto
FROM carrello_prodotto
WHERE idcarrello IN (SELECT idcarrello 
					FROM carrello
					WHERE pagato=0));
SELECT * 
FROM prodotto 
WHERE idprodotto IN 
    (SELECT idprodotto 
    FROM tab);
DROP TEMPORARY TABLE IF EXISTS tab;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `recupera_prodotti_deposito`()
BEGIN
	SELECT * 
    FROM prodotto
    WHERE idprodotto IN ( SELECT idprodotto 
						  FROM deposito_prodotto );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `recupera_prodotti_negozio`()
BEGIN
	SELECT * 
    FROM prodotto
    WHERE idprodotto IN ( SELECT idprodotto FROM negozio_prodotto );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `recupera_punti_fedelta`()
BEGIN
	SELECT * FROM carta_fedelta;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` PROCEDURE `sposta_prodotto_dal_negozio`(idprodotto_selezionato int)
BEGIN
	DELETE FROM negozio_prodotto WHERE idprodotto=idprodotto_selezionato;
	INSERT INTO deposito_prodotto (iddeposito, idprodotto)
    VALUES (1, idprodotto_selezionato);
END ;;
DELIMITER ;

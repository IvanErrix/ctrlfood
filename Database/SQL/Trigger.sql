DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` TRIGGER `ctrlfood`.`carrello_BEFORE_DELETE` BEFORE DELETE ON `carrello` FOR EACH ROW
BEGIN
	DELETE FROM prodotto WHERE idprodotto IN (SELECT idprodotto FROM carrello_prodotto);
END ;;
DELIMITER ;

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

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` TRIGGER `ctrlfood`.`pagamento_AFTER_DELETE` AFTER DELETE ON `pagamento` FOR EACH ROW
BEGIN
	DELETE FROM carrello WHERE idcarrello = OLD.chiavecarrello;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`ctrlfood`@`%` TRIGGER `ctrlfood`.`prodotto_BEFORE_INSERT` BEFORE INSERT ON `prodotto` FOR EACH ROW
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
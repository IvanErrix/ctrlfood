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
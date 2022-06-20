CREATE PROCEDURE 'looping_while'(vNumInicial INT, vNumFinal INT)
BEGIN
    DECLARE vContador INT;
    DELETE FROM TAB_LOOPING;
    SET vContador = vNumFinal;

    WHILE vContador <= vNumFinal
    DO 
        INSERT INTO TAB_LOOPING (ID)
        VALUES (vContador);
        SET vContador = vContador + 1;

    END WHILE;

    SELECT * FROM TAB_LOOPING;
END


CREATE PROCEDURE `counting_fiscal_notes_for_date`(start_note_v DATE, end_note_v DATE)
BEGIN
	DECLARE contador_p DATE;
    DECLARE number_sales INT;
    DELETE FROM sales_for_day;
    
    WHILE start_note_v <= end_note_v
    DO
		SELECT count(*)
        INTO number_sales
        FROM notas_fiscais
        WHERE start_note_v = data_venda;
        
        INSERT INTO sales_for_day (date_sales, amount) 
        VALUES (start_note_v, number_sales);
        
        SELECT adddate(start_note_v, INTERVAL 1 DAY)
        INTO start_note_v;
        
    END WHILE;
    
    SELECT * FROM sales_for_day;
END
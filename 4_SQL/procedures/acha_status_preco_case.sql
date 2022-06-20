/*senha: adminroot*/
CREATE PROCEDURE `acha_status_preco_case` (vProduto VARCHAR(50))
BEGIN
	DECLARE preco_v FLOAT;
    DECLARE mensagem_v VARCHAR(30);
    
    SELECT PRECO_DE_LISTA
    INTO preco_v
    FROM tabela_de_produtos
    WHERE codigo_do_produto = vProduto;
    
    CASE
    WHEN preco_v >= 12 THEN SET mensagem_v = 'PRODUTO CARO' ;
    WHEN preco_v >= 7 AND preco_v <12 THEN SET mensagem_v = 'PRODUTO EM CONTA' ;
    WHEN preco_v < 7 THEN SET mensagem_v = 'PRODUTO BARATO';
    END CASE;
    
    SELECT mensagem_v;
END
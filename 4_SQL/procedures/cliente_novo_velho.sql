USE `sucos_vendas`
DROP procedure IF EXISTS `cliente_novo_velho`;
DELIMITER $$

USE `sucos_vendas` $$
CREATE PROCEDURE `cliente_novo_velho`(cpf_p varchar(20))
BEGIN
    DECLARE result_w varchar(20);
    DECLARE date_nascimento_w DATE;

    SELECT date_de_nascimento
    INTO date_nascimento_w
    FROM tabela_de_cliente
    WHERE cpf = cpf_p;

    IF date_nascimento_w < '20000101' THEN  
        SET result_w = 'Cliente velho'
    ELSE 
        SET result_w = 'Cliente novo'
    END IF;

    SELECT result_w;
ENDE$$
DELIMITER;

call cliente_novo_velho('24229004885');
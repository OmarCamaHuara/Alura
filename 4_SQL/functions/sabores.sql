CREATE FUNCTION `f_acha_tipo_sabor`(sabor_p varchar(20))
RETURNS varchar(20)
BEGIN
	declare retorno_w varchar(20) default "";
    case sabor_p
		when 'Lima/Limao' then set retorno_w = 'Citrico';
        when 'Lima/Limao' then set retorno_w = 'Citrico';
        when 'Lima/Limao' then set retorno_w = 'Citrico';
        when 'Lima/Limao' then set retorno_w = 'Neutro';
        when 'Lima/Limao' then set retorno_w = 'Neutro';
        else set retorno_w = 'Acidos';
    end case;
RETURN retorno_w;
END;




SET GLOBAL log_bin_trust_function_creators = 1;
CREATE FUNCTION `f_numero_aleatorio` (max int, min int)
RETURNS INTEGER
BEGIN
	declare retorno_w int;
    select floor(rand() * (max-min+1) + min)
    into retorno_w;
RETURN 1;
END
create function `f_numero_notas`(data_venda_p date)
return int
begin
    declare numero_notas int;
    select count(*)
    into numero_notas
    from notas_fiscais
    where data_venda = data_venda_p
return numero_notas;
end;
create function `f_get_cpf_aleatory`
returns varchar(11)
begin 
    declare result_p varchar;
    declare aleatorio_p int;

    set aleatorio_p = f_numero_aleatorio() - 1;

    select cpf
    into result_p
    from tabela_de_clientes
    limit (aleatorio_p, 1)

    return result_p;

end
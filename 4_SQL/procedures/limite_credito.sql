create procedure `limite_credito`()
begin
    declare limite_credito_w float default 0;
    declare limite_credito_acumulado_w float default 0;
    declare fim_do_cursor_w int default 0;

    declare c 
    cursor for select limite_de_credito
               from tabela_de_clientes;
    declare continue handler for not found set fim_do_cursor_w = 1;

    open c;

        while fim_do_cursor_w = 0
        do 
            fetch c into limite_credito_w;
            if fim_do_cursor_w = 0 then
                set limite_credito_acumulado_w = limite_credito_acumulado_w + limite_credito_w;
            end if;
        end while;
    close c;
    
    select limite_credito_acumulado_w;
end;
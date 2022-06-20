create procedure `looping_cursor_multiplas_colunas`
begin
    declare fim_do_cursor int default 0;
    declare cidade_w, estado_w, cep_w varchar(50);
    declare nome_w, endereco_w varchar(150);
    
    declare c cursor for
    select nome, endereco_1, cidade, estado, cep
    from tabela_de_clientes;
    limit 4;

    declare continue handler for not found set fim_do_cursor = 1;

    open c;
        while fim_do_cursor = 0
        do
            fetch c into nome_w, endereco_w, cidade_w, estado_w, cep_w;
            if fim_do_cursor = 0 then
                select concat(nome_w, 
                              ' Endereco ', endereco_w, 
                              ' , ', cidade_w, 
                              ' - ', estado_w, 
                              ' CEP: ', cep_w);
            end if;
        end while;
    close c;
end;
create procedure `cursor_teste`()
begin
    declare nome_w varchar(50);
    declare fim_do_cursor int default 0;

    declare c 
    cursor for select nome 
               from tabela_de_clientes
               limit 4;
    declare continue handler for not found set fim_do_cursor = 1;
    open c;
        while fim_do_cursor = 0
        do
            fetch c into nome_w
            if fim_do_cursor = 0 then
                select nome_w
            end if;
        end while;
    close c;
end;

/*
Cursor
Cursor e uma estrutura implementada no MYSQL que permite uma interatividade linha a linha atraves de uma determinada ordem.

Fases para uso do Cursor:
    - Declaracao - Onde definimos qual consulta SQL estara sendo carregado ao Cursor.
    - Abentura: Abrimos o Cursor para percorre-lo linha a linha.
    - Percorre linha a linha ate o seu final.
    - Fecha o Cursor.
    - Limpa o Cursor de memoria.

*/
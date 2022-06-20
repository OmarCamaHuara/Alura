create procedure `faturamento_mes_ano`
begin
    declare fim_do_cursor int default 0;
    declare acumulador float default 0;
    declare quantidade_w float default 0;
    declare preco_w float default 0;


    declare c cursor for
        select inf.quantidade, inf.preco
        from itens_notas_fiscais inf
        inner join notas_fiscais nf 
        on nf.numero = inf.numero
        where month(nf.data_venda) = 1
        and year(nf.data_venda) = 2017;

    declare continue handler for not found set fim_do_cursor = 1;

    open c;
        while fim_do_cursor = 0
        do
            fetch c into quantidade_w, preco_w
            if fim_do_cursor = 0 then
                set acumulador = acumulador + (quantidade_w * preco_w)
            end if;
        end while;
    close c;
    select acumulador;
end;
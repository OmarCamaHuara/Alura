create procedure `acha_tipo_sabor`(produto_p varchar(50))
begin
    declare sabor_w varchar(50);

    select sabor 
    into sabor_w
    from tabela_de_produtos
    where codigo_do_produto = produto_p;

    case sabor_w
    when 'Lima/Limao' then select 'Citrico';
    when 'Laranja' then select 'Citrico';
    when 'Morango/Limao' then select 'Citrico';
    when 'Uva' then select 'Neutro';
    when 'Morango' then select 'Neutro';
    else select 'Acido'
    end case;
end;
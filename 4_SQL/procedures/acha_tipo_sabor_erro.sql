create procedure `acha_tipo_sabor_erro`(produto_p varchar(50))
begin
    declare sabor_w varchar(50);
    declare msg_erro varchar(30);

    declare continue handler for 1339 set msg_erro = 'O case nao esta completo'

    select sabor
    into sabor_w
    from tabela_de_produtos
    where codigo_do_produto = produto_p
    case sabor_w
    when 'Lima/Limao' then select 'Citrico';
    when 'Laranja' then select 'Citrico';
    when 'Morango/Limao' then select 'Citrico';
    when 'Uva' then select 'Neutro';
    when 'Morango' then select 'Neutro';
    end case;

    select msg_erro
end;
use `sucos_vendas`;
drop procedure if exists `acha_status_preco`;
delimiter $$

use `sucos_vendas` $$
create procedure `acha_status_preco` (produto_p varchar(50))
begin 
    declare preco_w float;
    declare mensagem_w varchar(30);

    select preco_de_lista 
    into preco_w
    from tabela_de_produtos
    where codigo_do_produto = produto_p;

    if preco_w >=2 then 
        set mensagem_w = 'Produto caro';
    elseif preco_w >= 7 and preco_w < 12 then
        set mensagem_w = 'Produto em conta'
    else
        set mensagem_w = 'Produto barato'
    end if;

    select mensagem_w
end$$
delimiter;
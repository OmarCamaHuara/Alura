-- config WHEB 
usuario = tasy
senha = aloisk

-- abrir sql no terminal
sqlplus

-- Adicionando uma coluna
alter table ONBOARDING_SQL
add (DS_MODELO varchar2(30))

--Excluir coluna
alter table ONBOARDING_SQL drop column DS_MODELO;

-- Adicionando a primary key
alter table ONBOARDING_SQL
add constraint PK_SEQ primary key (NR_SEQUENCIA)

-- criando uma sequencia
create sequencia SEQ_ONBOARDING
increment by 1
start with 1
maxvalue 999999
nocycle;

-- Resetar sequencia para 1
alter sequencia SEQ_ONBOARDING restart start with 1

-- Adicionando uma sequencia na tabela
alter table ONBOARDING_SQL
modify (NR_SEQUENCIA default SEQ_ONBOARDING.NEXTVAL)

-- Deletar tabela
drop table ONBOARDING_SQL

--
select * 
from ONBOARDING_SQL 
order by NR_SEQUENCIA

-- Insert registro na tabela 
insert into ONBOARDING_SQL(NM_USUARIO, DS_MARCA, DS_MODELO) 
values ('ohcama', 'marca', 'modelo');

-- Apagar registro na tabela
delete ONBOARDING_SQL
where NR_SEQUENCIA = 2;

-- Atualizar registro da tabela
update ONBOARDING_SQL 
set DS_MARCA = 'exemplo 3',
    DS_MODELO = 'Teste update',
where NR_SEQUENCIA = 2;


-- criar uma chave primaria
ALTER TABLE ONBOARDING_SQL ADD CONSTRAINT PK_TB_CLIENTES PRIMARY KEY (CPF);


SELECT * FROM TABELA_DE_VENDEDORES WHERE TO_CHAR(DATA_ADMISSAO, 'YYYY') >= '2016';

-- Habilitar saida no ternimal
set serveroutput on; 

select *
from bifrost_layer_log
where nm_event = 'pathoxIntegracaoAnatomiaEvent'
order by dt_integration desc;

select * 
from all_source
where lower(text) like lower('%NOME_PROCEDURe%')
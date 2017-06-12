create table pessoa (
  IDPessoa integer not null,
  Nome     varchar2(30) not null,
    constraint PK_Pessoa primary key (IDPessoa)
    );
    
Create sequence SQPessoa;

Insert Into Pessoa (IDPessoa, Nome)
values (SQPessoa.nextval, 'Christopher');

select * from pessoa;

commit

select * from pedido
select * from pedidoitem


select * from pedido 
where datapedido  
BETWEEN '12-02-17' AND '12-09-17'

select IDProduto, Nome
From Produto prod
Left join  


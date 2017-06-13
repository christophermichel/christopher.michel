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


SELECT IDProduto, Nome
FROM Produto 
WHERE IDProduto NOT IN
(SELECT IDProduto 
FROM PedidoItem pit
INNER JOIN Pedido ped
ON pit.IDPedido = ped.IDPedido 
WHERE DataPedido >= ADD_MONTHS(SYSDATE,-4)) 


UPDATE Produto 
SET Situacao = 'I'
WHERE IDProduto NOT IN
(SELECT IDProduto 
FROM PedidoItem pit
INNER JOIN Pedido ped
ON pit.IDPedido = ped.IDPedido 
WHERE DataPedido >= ADD_MONTHS(SYSDATE,-4)) 
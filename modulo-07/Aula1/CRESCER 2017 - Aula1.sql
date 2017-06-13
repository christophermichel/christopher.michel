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

create view vwProdutos_sem_compra as
SELECT IDProduto, Nome
FROM Produto 
WHERE IDProduto NOT IN
(SELECT IDProduto 
FROM PedidoItem pit
INNER JOIN Pedido ped
ON pit.IDPedido = ped.IDPedido 
WHERE DataPedido >= ADD_MONTHS(SYSDATE,-4));

select * from user_tables;

EXEC dbms_stats.gather_schema_stats(USER);


UPDATE Produto 
SET Situacao = 'I'
WHERE IDProduto NOT IN;

SELECT IDProduto 
FROM PedidoItem pit
INNER JOIN Pedido ped
ON pit.IDPedido = ped.IDPedido 
WHERE DataPedido >= ADD_MONTHS(SYSDATE,-4);

---Usando o exists
UPDATE Produto 
SET Situacao = 'I'
WHERE exists (Select IDProduto
              from vwProdutos_Sem_Compra vw
              where Produto.IDProduto = vw.IDProduto);
              
Select sum(item.Quantidade) qtde
from PedidoItem item 
  inner join Pedido ped on ped.IDPedido - item.IDPedido
where item.IDProduto = :p_IDProduto
and ped.DataPedido >= trunc(sysdate, 'yyyy');


Begin
 DBMS_OUTPUT.PUT_LINE('Buenas tarde!');
End;






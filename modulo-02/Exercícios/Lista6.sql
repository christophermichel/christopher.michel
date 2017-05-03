/*
Exercício 1
Primeiro nome
Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.
*/

/*
Exercício 2
Total do Mês
Liste o total de pedidos (quantidade e valor) realizados no mês de abril/2017.
*/
SELECT COUNT(Pedido.IDPedido) AS Quantidade, 
		SUM(Pedido.ValorPedido) AS ValorPedido 
FROM Pedido
WHERE MONTH(Pedido.DataPedido) = 4
   AND YEAR(Pedido.DataPedido) = 2017;
/*
Exercício 3
Estados x Clientes
Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior número de clientes 
(tabela Cliente), liste também qual o Estado possuí o menor número de clientes.
*/

/*
Exercício 4
Novo Produto
Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
Nome: Galocha Maragato
Preço de custo: 35.67
Preço de venda: 77.95
Situação: A
*/
BEGIN TRANSACTION
GO
INSERT INTO Produto(Nome ,PrecoCusto, PrecoVenda, Situacao)
	VALUES('Galocha Maragato',35.67,77.95,'A');
/*
Exercício 5
Produtos não comprados
Identifique e liste os produtos que não tiveram nenhum pedido, considere os relacionamentos no modelo de dados, pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem).
=> Obs.: o produto criado anteriormente deverá ser listado (apenas este)
*/
SELECT * 
FROM Produto 
LEFT JOIN PedidoItem ON Produto.IDProduto = PedidoItem.IDProduto
LEFT JOIN Pedido ON PedidoItem.IDPedido = Pedido.IDPedido
WHERE Pedido.IDPedido IS NULL;
/*
Exercício 6
Principais Produtos
Liste os 30 produtos que mais geraram lucro em 2016.
*/
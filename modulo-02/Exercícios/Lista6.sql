/*
Exerc�cio 1
Primeiro nome
Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.
*/

/*
Exerc�cio 2
Total do M�s
Liste o total de pedidos (quantidade e valor) realizados no m�s de abril/2017.
*/
SELECT COUNT(Pedido.IDPedido) AS Quantidade, 
		SUM(Pedido.ValorPedido) AS ValorPedido 
FROM Pedido
WHERE MONTH(Pedido.DataPedido) = 4
   AND YEAR(Pedido.DataPedido) = 2017;
/*
Exerc�cio 3
Estados x Clientes
Identifique qual o estado (coluna UF da tabela Cidade) possu� o maior n�mero de clientes 
(tabela Cliente), liste tamb�m qual o Estado possu� o menor n�mero de clientes.
*/

/*
Exerc�cio 4
Novo Produto
Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es:
Nome: Galocha Maragato
Pre�o de custo: 35.67
Pre�o de venda: 77.95
Situa��o: A
*/
BEGIN TRANSACTION
GO
INSERT INTO Produto(Nome ,PrecoCusto, PrecoVenda, Situacao)
	VALUES('Galocha Maragato',35.67,77.95,'A');
/*
Exerc�cio 5
Produtos n�o comprados
Identifique e liste os produtos que n�o tiveram nenhum pedido, considere os relacionamentos no modelo de dados, pois n�o h� relacionamento direto entre Produto e Pedido (ser� preciso relacionar PedidoItem).
=> Obs.: o produto criado anteriormente dever� ser listado (apenas este)
*/
SELECT * 
FROM Produto 
LEFT JOIN PedidoItem ON Produto.IDProduto = PedidoItem.IDProduto
LEFT JOIN Pedido ON PedidoItem.IDPedido = Pedido.IDPedido
WHERE Pedido.IDPedido IS NULL;
/*
Exerc�cio 6
Principais Produtos
Liste os 30 produtos que mais geraram lucro em 2016.
*/
SELECT * INTO CidadeAux FROM Cidade ;

Truncate table CidadeAux;

-- Copiar valores da Tabela Cidade onde o estado é RS
INSERT INTO CidadeAux (IDCidade, Nome, UF)
	SELECT IDCidade, Nome, UF
	FROM Cidade 
	WHERE uf = 'RS';

select * from CidadeAux;

-- Criar tabela de informações de produtos
Create table InfoProdutos 
(
  Codigo    int    identity    not null,
  NomeCurto      varchar(10) not null,
  NomeDescritivo        varchar(30)  not null,
  DataDaCriacao         date not null,
  LocalnoEstoque        varchar(10) not null,
  Quantidade			int not null,
  Preco                 decimal (7,3) not null,
    constraint PK_InfoProdutos primary key (Codigo)
);	
-- Inserir valores na tabela
insert into InfoProdutos(NomeCurto, NomeDescritivo, DataDaCriacao, LocalnoEstoque, Quantidade, Preco)
   values ('Caderno', 'Caderno com 96 folhas', '13/12/2016', 'A00A01', 5, 6.50);
insert into InfoProdutos(NomeCurto, NomeDescritivo, DataDaCriacao, LocalnoEstoque, Quantidade, Preco)
   values ('Caderno', 'Caderno com 200 folhas', '15/12/2016', 'A00A02', 10, 9.50);



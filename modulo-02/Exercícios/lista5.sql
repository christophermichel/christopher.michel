/*Exerc�cio 1

M�ltiplos acessos

Liste o nome do empregado, o nome do gerente e o departamento de cada um. */

Select e.NomeEmpregado as NomeEmpregado, 
	   dep.NomeDepartamento,
	   g.NomeEmpregado as NomeGerente 
From Empregado e 
LEFT JOIN Empregado g ON e.IDGerente = g.IDEmpregado
LEFT JOIN Departamento dep ON e.IDDepartamento = dep.IDDepartamento;

/* Exerc�cio 2

Maior Sal�rio

Liste o deparamento (id e nome) com o empregado de maior sal�rio.*/

Select distinct emp.IDDepartamento as ID,
	   NomeDepartamento as Departamento
From Departamento dep
Inner join Empregado emp on dep.IDDepartamento = emp.IDDepartamento
Where emp.Salario = (Select MAX(Salario) 
					From Empregado
					where IDDepartamento is not null);

/*Exerc�cio 3

Reajuste salarial

Aplique uma altera��o salarial em todos os empregados que o departamento fique na localidade de SAO PAULO, este reajuste deve ser de 17,3%. Por seguran�a fa�a uma c�pia da tabela Empregado antes de iniciar esta tarefa.*/
SELECT * INTO EmpregadoAux from Empregado;
BEGIN Transaction
go

UPDATE Empregado
Set Salario = Salario*1.173
From Empregado
INNER JOIN Departamento on Empregado.IDDepartamento = Departamento.IDDepartamento
Where Departamento.Localizacao = 'SAO PAULO';


/*Exerc�cio 4

Cidades duplicadas

Liste todas as cidades duplicadas (nome e UF iguais).*/

SELECT COUNT(1) as [Cidades Iguais],
		Nome as [Cidade], 
		UF as [Estado] 
FROM CIDADE 
GROUP BY Nome,uf
having COUNT(1) >= 2


/*Exerc�cio 5

Definindo Cidades

Fa�a uma altera�ao nas cidades que tenham nome+UF duplicados, adicione no final do nome um asterisco. Mas aten��o! apenas a cidade com maior ID deve ser alterada.

Explica��o adicional - VIEW

Para reaproveitar uma consulta SQL um dos recursos oferecidos � a cria��o de VIEWS. Neste recurso o comando SQL � salvo no dicion�rio de dados do SGBD e pode ser reutilizado novamente. */

BEGIN TRANSACTION
UPDATE Cidade 
SET Nome = Nome + '*'
WHERE Nome IN (SELECT Nome as [Nome Da Cidade] 
FROM Cidade 
GROUP BY Nome
having Count(1) >= 2) 
AND IDCidade in (Select Max(IDCidade) 
				From Cidade 
				Group by Nome 
				Having Nome = Cidade.Nome);
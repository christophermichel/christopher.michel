/*Exercício 1

Múltiplos acessos

Liste o nome do empregado, o nome do gerente e o departamento de cada um. */

Select e.NomeEmpregado as NomeEmpregado, 
	   dep.NomeDepartamento,
	   g.NomeEmpregado as NomeGerente 
From Empregado e 
LEFT JOIN Empregado g ON e.IDGerente = g.IDEmpregado
LEFT JOIN Departamento dep ON e.IDDepartamento = dep.IDDepartamento;

/* Exercício 2

Maior Salário

Liste o deparamento (id e nome) com o empregado de maior salário.*/

Select distinct emp.IDDepartamento as ID,
	   NomeDepartamento as Departamento
From Departamento dep
Inner join Empregado emp on dep.IDDepartamento = emp.IDDepartamento
Where emp.Salario = (Select MAX(Salario) 
					From Empregado
					where IDDepartamento is not null);

/*Exercício 3

Reajuste salarial

Aplique uma alteração salarial em todos os empregados que o departamento fique na localidade de SAO PAULO, este reajuste deve ser de 17,3%. Por segurança faça uma cópia da tabela Empregado antes de iniciar esta tarefa.*/
SELECT * INTO EmpregadoAux from Empregado;
BEGIN Transaction
go

UPDATE EmpregadoAux
Set Salario = emp.Salario*1.173
From Empregado emp
INNER JOIN Departamento dep on emp.IDDepartamento = dep.IDDepartamento
Where dep.Localizacao = 'SAO PAULO';

select*
from EmpregadoAux;

select*
from Empregado;
/*Exercício 4

Cidades duplicadas

Liste todas as cidades duplicadas (nome e UF iguais).*/


/*Exercício 5

Definindo Cidades

Faça uma alteraçao nas cidades que tenham nome+UF duplicados, adicione no final do nome um asterisco. Mas atenção! apenas a cidade com maior ID deve ser alterada.

Explicação adicional - VIEW

Para reaproveitar uma consulta SQL um dos recursos oferecidos é a criação de VIEWS. Neste recurso o comando SQL é salvo no dicionário de dados do SGBD e pode ser reutilizado novamente. */
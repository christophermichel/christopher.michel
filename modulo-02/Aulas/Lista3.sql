-- Fa�a uma consulta que liste o total de empregados admitidos no ano de 1980. Deve ser projetado 
-- nesta consulta: ID, Nome e Idade no momento da admiss�o.

 SELECT IDEmpregado AS ID, 
		NomeEmpregado AS Nome, 
		FLOOR(DATEDIFF(Year,DataNascimento, DataAdmissao)) as [Idade na admiss�o] 
 FROM empregado 
 WHERE YEAR(DataAdmissao) = 1980;

-- Qual o cargo (tabela empregado) possui mais empregados ? Deve ser projetado apenas um registro. 
-- ** DICA: Pesquise recursos espec�ficos para esta funcionalidade.

SELECT TOP 1 Cargo, count(1) as [Empregados por cargo]  
FROM EMPREGADO 
GROUP BY Cargo 
ORDER BY  [Empregados por cargo] DESC;

-- Liste os estados (atributo UF) e o total de cidades existente em cada estado na tabela cidade.

SELECT UF as Estado, Count(1)
FROM CIDADE
GROUP BY UF
ORDER BY UF;

-- Crie um novo departamento, denominado 'Inova��o' com localiza��o em 'S�O LEOPOLDO'. 
-- Todos os empregados que foram admitidos no m�s de dezembro (qualquer ano) que n�o ocupam o 
-- cargo de 'Atendente' devem ser ter o departamento (IDDepartamento) atualizado para este novo 
-- registro (inova��o).

BEGIN TRANSACTION
INSERT INTO Departamento (IDDepartamento, NomeDepartamento, Localizacao)
	   VALUES(70,'Inova��o','SAO LEOPOLDO');
UPDATE EMPREGADO 
SET IDDepartamento = 70
WHERE CARGO != 'ATENDENTE' 
	  AND DATEPART(Month,DataAdmissao) = 12;
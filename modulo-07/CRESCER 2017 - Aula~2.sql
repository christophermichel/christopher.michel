SELECT NOME,UF, COUNT(*)  as quantidade
  from   CIDADE cid
  group  by  NOME,UF
  having count(*) > 1; 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  SELECT cli.NOME
  FROM CLIENTE cli
  INNER JOIN cidade cid ON cli.IDCidade = cid.IDCIDADE
  where cid.NOME = nomeCidade AND cid.UF = nomeUF;
  
  BEGIN 
    FOR cidade IN C_CidadesRepetidas LOOP
        FOR cliente IN C_CLIENTES_DA_CIDADE(cidade.NOME, cidade.UF) LOOP
          DBMS_OUTPUT.PUT_LINE('Nome do cliente: ' || cliente.NOME || '  Nome da Cidade: '|| cidade.NOME || '  Nome da UF: ' || cidade.UF);
        END LOOP;
    END LOOP;
  END;
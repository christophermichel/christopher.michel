//1

DECLARE
 CURSOR C_ListaDeCidades IS
     SELECT NOME,UF, COUNT(*)  as quantidade
  from   CIDADE cid
  group  by  NOME,UF
  having count(*) > 1;
 CURSOR C_ClientesPorCidades(cidade IN string) IS
  SELECT cli.Nome AS NomeCliente, cid.Nome AS NomeCidade FROM Cliente cli JOIN Cidade cid ON cli.IDCIDADE = cid.IDCIDADE
  WHERE cid.Nome LIKE cidade;
  
BEGIN
  DBMS_OUTPUT.PUT_LINE('Cidades duplicadas');
   FOR reg IN C_ListaDeCidades LOOP
    DBMS_OUTPUT.PUT_LINE('Cidade' || reg.nome);
    FOR item  in C_ClientesPorCidades(reg.nome) LOOP
      DBMS_OUTPUT.PUT_LINE('Cliente - ' || item.nomeCliente);
     END LOOP;
   END LOOP;
END;

//2

DECLARE
  CURSOR C_PEDIDO(IDPEDIDO IN number) IS
    SELECT QUANTIDADE , PRECOUNITARIO  
    FROM PEDIDOITEM 
    where IDPEDIDO = IDPEDIDO;
  vPEDIDO PEDIDO.IDPEDIDO%TYPE;
  vValor PEDIDO.VALORPEDIDO%TYPE;
BEGIN
  vPEDIDO := 30;
  vValor := 0.0;
  FOR x IN C_PEDIDO(vPedido) LOOP
    vValor := vValor + ( x.quantidade * x.precounitario);
  END LOOP;
  UPDATE PEDIDO 
  SET VALORPEDIDO =  vValor
  WHERE IDPEDIDO = vPEDIDO;
END;
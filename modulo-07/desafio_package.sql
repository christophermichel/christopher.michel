---criar estrutura inicial do package
create package pck_cidade as
  procedure eliminar_cidades_duplicadas;
end;

create package body pck_cidade as
    procedure eliminar_cidades_duplicadas is
---Selecionar cidades que repetem e já guardar o menor ID
        cursor c_cidades is
             select Nome, UF, MIN(IDCidade) as primeiro_cadastro
             from   Cidade
             group  by Nome, UF
             having count(1) >1;
---Fazer intersecção das tabelas cliente e cidade pelo IDCidade e verificar igualdade
        cursor c_clientes (pNome in varchar2, 
               pUF   in varchar2) is
           select cli.IDCliente,
                  cli.Nome as Nome_Cliente,
                  cid.Nome as Nome_Cidade,
                  cid.UF
           from   Cliente cli
           inner join Cidade cid on cid.IDCidade = cli.IDCidade
           where  cid.Nome = pNome
           and    cid.UF   = pUF;
---Percorrer cidades e clientes, alterando os clientes e deletando as cidades repetidas (com exceção da primeira) utilizando os cursores acima
      BEGIN
        FOR cidade in c_cidades LOOP            
            FOR cliente in c_clientes (cidade.Nome, cidade.UF) LOOP
                 update cliente
                 set IDCidade = cidade.primeiro_cadastro
                 where IDCliente = cliente.IDCliente;
            END LOOP;
            delete from cidade
            where cidade.nome = cidade.nome
            and cidade.uf = cidade.uf
            and cidade.idcidade != cidade.primeiro_cadastro;
        END LOOP;             
      END;
   END; 
END;
Create table LogAposta 
  IDLogAposta   integer not null,
  IDAposta   integer not null,
  IDConcurso_Antigo        integer,
  IDConcurso_Novo        integer,
  Data_hora           date default sysdate,  
  Operacao       char(1) not null,
  Usuario        varchar2(50)
      constraint PK_LogAposta 
       primary key (IDAposta)
);

Create sequence sqLogAposta;

create or replace trigger TR_AUD1_Apostas
    after insert or update or delete on APOSTA
    for each row
Declare
  v_operacao char(1);
  v_IDAposta integer;
  v_IDConcurso_Antigo Aposta.IdConcurso%type;
  v_IDConcurso_Novo Aposta.IdConcurso%type;

Begin

  if INSERTING then
     v_operacao := 'I';
     v_IDConcurso_Antigo   := NULL; 
     v_IDConcurso_Novo := :new.idconcurso;
  elsif UPDATING then
     v_operacao := 'U';   
     v_IDConcurso_Novo := :new.idconcurso;
     v_IDConcurso_Antigo   := :old.idconcurso; 

  else
     v_operacao := 'D';
     v_IDConcurso_Novo := null;
     v_IDConcurso_Antigo   := :old.idconcurso; 
  end if;
  Insert into LogCliente_Operacao (idlogaposta, IDAposta, IDConcurso, Data_hora, operacao, Usuario)
      values (sqLogAposta.nextval, v_IDAposta, v_IDConcurso, sysdate, v_operacao, user);

End TR_AUD1_Apostas;



Create table LogNumeroAposta 
  IDLogNumeroAposta   integer not null,
  IDAposta   integer not null,
  IDConcurso        integer not null,
  Data_hora           date default sysdate,  
  Operacao       char(1) not null,
      constraint PK_LogAposta 
       primary key (IDAposta)
);

Create sequence sqLogAposta;

create or replace trigger TR_AUD1_Apostas
    after insert or update or delete on APOSTA
    for each row
Declare
  v_operacao char(1);
  v_IDAposta Aposta.IdAposta%type;
  v_IDConcurso Aposta.IdConcurso%type;
Begin

  if INSERTING then
     v_operacao := 'I';
  elsif UPDATING then
     v_operacao := 'U';       
  else
     v_operacao := 'D';
  end if;
  Insert into LogCliente_Operacao (idlogaposta, IDAposta, IDConcurso, Data_hora, operacao)
      values (sqLogAposta.nextval, v_IDAposta, v_IDConcurso, sysdate, v_operacao);

End TR_AUD1_Apostas;


Create table LogNumeroAposta (
  IDLogNumeroAposta  integer not null,
  Usuario        varchar2(30),
  Data_hora           date default sysdate,  
  Operacao       char(1) not null,
  IDNumeroAposta_Antigo       integer,
  IDNumeroAposta_Novo       integer,
    constraint PK_LogNumeroAposta 
       primary key (IDLogNumeroAposta)
);

SELECT Count(*) as QtdApostas, Cid.UF, IDConcurso
FROM Aposta apo 
INNER JOIN CIDADE cid ON cid.IDCidade = apo.IDCidade
GROUP BY UF, IDConcurso
ORDER BY QtdApostas;

SELECT Sum(Valor) as Arrecadacao, Cid.UF, IDConcurso
FROM Aposta apo 
INNER JOIN CIDADE cid ON cid.IDCidade = apo.IDCidade
GROUP BY UF, IDConcurso;

--Falta relacionar com a cidade
SELECT Count(*) as QtdGanhadores, Cid.UF, IDConcurso
FROM Aposta apo 
INNER JOIN Aposta_premiada prem ON prem.IDAposta = apo.IDAposta
GROUP BY UF, IDConcurso;
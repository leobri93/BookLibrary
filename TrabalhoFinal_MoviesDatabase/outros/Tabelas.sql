DROP USER gui CASCADE;
CREATE USER gui IDENTIFIED BY gui;
GRANT CONNECT, RESOURCE TO gui;

CONNECT gui/gui

DROP TABLE AUTOR CASCADE CONSTRAINTS;
DROP SEQUENCE SEQ_AUTOR;

DROP TABLE LIVRO CASCADE CONSTRAINTS;
DROP SEQUENCE SEQ_LIVRO;

CREATE SEQUENCE SEQ_AUTOR;
CREATE SEQUENCE SEQ_LIVRO;


CREATE TABLE AUTOR
(ID             NUMBER(5)
   CONSTRAINT AUTOR_ID_PK
   PRIMARY KEY,
 NOME          VARCHAR2(30)
   CONSTRAINT AUTOR_NOME_NN
   NOT NULL,
 DATA_NASCIMENTO   DATE
   CONSTRAINT AUTOR_DATA_NASCIMENTO_NN
   NOT NULL);
   
CREATE TABLE LIVRO
(ID             NUMBER(5)
   CONSTRAINT LIVRO_ID_PK
   PRIMARY KEY,
 NOME           VARCHAR2(30) 
   CONSTRAINT LIVRO_NOME_UNIQUE
   UNIQUE
   CONSTRAINT LIVRO_NOME_NN
   NOT NULL,
 SINOPSE      VARCHAR2(40),
 DATA_CADASTRO  DATE
   CONSTRAINT LIVRO_DATA_CADASTRO_NN
   NOT NULL,
 NUMERO_EXEMPLARES     NUMBER(5),
 AUTOR_ID     NUMBER(5)
   CONSTRAINT LIVRO_AUTOR_FK
   REFERENCES AUTOR(ID)
   CONSTRAINT LIVRO_AUTOR_ID_NN
   NOT NULL);


INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'DAN BROWN', SYSDATE);
   
INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'TOLKIEN', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Paulo Coelho', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Fernando Pessoa', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Machado de Assis', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, '�lvares de Campos', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abeu Neves', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abeu Pinto', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abeu Rodriguez', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abeu Salazar', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abeu Sousa Dias', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abrahan Lincon', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Blade', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Blake', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Fake', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Fawer', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Foulds', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Grant', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Philips', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan William', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelina Gimeno', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelina Piteira', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelina Santos', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelino Cunha', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelino Torres', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelino Wadman', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Cristina', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Alves', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Ferr�o', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Pereira', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Rodrigues', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Silva', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana de Jesus', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Solsa', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Draga', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Duarte', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Elias', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Farias', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Flausino', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Gomes', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Godinho', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'DAN BROWN', SYSDATE);
   
INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'TOLKIEN', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Paulo Coelho', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Fernando Pessoa', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Machado de Assis', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, '�lvares de Campos', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abeu Neves', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abeu Pinto', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abeu Rodriguez', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abeu Salazar', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abeu Sousa Dias', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abrahan Lincon', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Blade', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Blake', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Fake', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Fawer', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Foulds', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Grant', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Philips', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan William', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelina Gimeno', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelina Piteira', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelina Santos', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelino Cunha', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelino Torres', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelino Wadman', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Cristina', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Alves', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Ferr�o', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Pereira', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Rodrigues', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Silva', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana de Jesus', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Solsa', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Draga', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Duarte', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Elias', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Farias', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Flausino', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Gomes', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Godinho', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'DAN BROWN', SYSDATE);
   
INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'TOLKIEN', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Paulo Coelho', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Fernando Pessoa', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Machado de Assis', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, '�lvares de Campos', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abeu Neves', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abeu Pinto', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abeu Rodriguez', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abeu Salazar', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abeu Sousa Dias', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Abrahan Lincon', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Blade', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Blake', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Fake', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Fawer', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Foulds', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Grant', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan Philips', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adan William', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelina Gimeno', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelina Piteira', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelina Santos', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelino Cunha', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelino Torres', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Adelino Wadman', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Cristina', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Alves', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Ferr�o', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Pereira', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Rodrigues', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Silva', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana de Jesus', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Solsa', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Draga', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Duarte', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Elias', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Farias', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Flausino', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Gomes', SYSDATE);

INSERT INTO AUTOR(ID, NOME, DATA_NASCIMENTO)
VALUES(SEQ_AUTOR.NEXTVAL, 'Ana Godinho', SYSDATE);



INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'ANJOS E DEMONIOS', 'BLA BLA BLA', SYSDATE, 50, 1);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'FORTALEZA DIGITAL', 'BLA BLA BLA BLA', SYSDATE, 50, 1);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'SENHOR DOS ANEIS', 'SDADNASKDNK', SYSDATE, 50, 2);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'A arte de cuidar e se deixar cuidar', 'SDADNASKDNK', SYSDATE, 50, 3);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'A caminho do Brasil ', 'SDADNASKDNK', SYSDATE, 50, 3);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Anemona', 'SDADNASKDNK', SYSDATE, 50, 4);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Amn�sia', 'SDADNASKDNK', SYSDATE, 50, 4);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'A miss�o', 'SDADNASKDNK', SYSDATE, 50, 5);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'A Tristeza de Tob', 'SDADNASKDNK', SYSDATE, 50, 6);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'A vida em poesias', 'SDADNASKDNK', SYSDATE, 50, 7);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Alma Urbana', 'SDADNASKDNK', SYSDATE, 50, 8);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Amor Efetivo', 'SDADNASKDNK', SYSDATE, 50, 9);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Arte e Cura', 'SDADNASKDNK', SYSDATE, 50, 9);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Azar o Seu!', 'SDADNASKDNK', SYSDATE, 50, 10);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'A Caminho da Sepultura', 'SDADNASKDNK', SYSDATE, 50, 11);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'A Procura de Audrey', 'SDADNASKDNK', SYSDATE, 50, 12);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Al�m do T�mulo', 'SDADNASKDNK', SYSDATE, 50, 12);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Alguma Coisa Acontece no Meu Cora��o', 'SDADNASKDNK', SYSDATE, 50, 12);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Alma?', 'SDADNASKDNK', SYSDATE, 50, 13);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Alta Fidelidade', 'SDADNASKDNK', SYSDATE, 50, 6);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Amada Imortal', 'SDADNASKDNK', SYSDATE, 50, 7);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Amante Sombrio', 'SDADNASKDNK', SYSDATE, 50, 4);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Ame o que � seu', 'SDADNASKDNK', SYSDATE, 50, 15);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Amigos Inimigos', 'SDADNASKDNK', SYSDATE, 50, 20);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Amor Amargo', 'SDADNASKDNK', SYSDATE, 50, 17);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Amy & Rogers', 'SDADNASKDNK', SYSDATE, 50, 18);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Anexos', 'SDADNASKDNK', SYSDATE, 50, 14);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Anjos do Sagrado Cora��o', 'SDADNASKDNK', SYSDATE, 50, 11);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Anna e o Beijo Franc�s', 'SDADNASKDNK', SYSDATE, 50, 12);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Antes de Dormir', 'SDADNASKDNK', SYSDATE, 50, 19);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Antes Que Eu V�', 'SDADNASKDNK', SYSDATE, 50, 20);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Apaixonada por palavras', 'SDADNASKDNK', SYSDATE, 50, 12);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'A Coisa', 'SDADNASKDNK', SYSDATE, 50, 3);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Aprendendo a Seduzir', 'SDADNASKDNK', SYSDATE, 50, 4);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Aprendiz de Assassino', 'SDADNASKDNK', SYSDATE, 50, 23);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Arcano Nove. O', 'SDADNASKDNK', SYSDATE, 50, 2);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Aura Negra', 'SDADNASKDNK', SYSDATE, 50, 18);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Ap�trida', 'SDADNASKDNK', SYSDATE, 50, 22);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Ap�trida I', 'SDADNASKDNK', SYSDATE, 50, 23);

INSERT INTO LIVRO(ID, NOME, SINOPSE, DATA_CADASTRO, NUMERO_EXEMPLARES, AUTOR_ID)
VALUES(SEQ_LIVRO.NEXTVAL, 'Am�rica', 'SDADNASKDNK', SYSDATE, 50, 24);



COMMIT;

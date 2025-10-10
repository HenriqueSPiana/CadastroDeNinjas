-- migration para adicionar coluna de rank na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN ranque VARCHAR(2) NOT NULL;
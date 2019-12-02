--Criar Banco de dados primeiro -- 

CREATE DATABASE ocorrencia_db;

-- Criar as Tabelas com alguns conteudos dentro de cada --

CREATE TABLE produto (
    idProduto SERIAL NOT NULL PRIMARY KEY,
    nomeProduto VARCHAR(50) NOT NULL,
    modeloProduto VARCHAR(50) NOT NULL
);


INSERT INTO produto (nomeProduto, modeloProduto) VALUES 
('Teclado Gamer','TM2000 - Preto'),
('Teclado Gamer','TM2200 H30 - Preto/Vermelho'),
('Teclado Mecânico','DX300 - Preto'),
('Teclado Mecânico','DX320 - Preto'),
('Teclado Convencional','TM3030'),
('Teclado Gamer','TM2440 - Branco'),
('Mouse Gamer','WarHammer Line Premmiun / 3200DPI'),
('Mouse Gamer','Raptor Line / 4000DPI'),
('Mouse Gamer','G402 HyperMax - Azul / 3200DPI'),
('HeadSet','G321 Prodigy / Vermelho'),
('HeadSet','Pro-Audio Max H2'),
('Speaker','HD Master - TW3200'),
('Speaker','Pro-Audio Max S2'),
('HeadPhone','HP Line-Pro / P2-P10');

CREATE TABLE ocorrencia (
    protocolo SERIAL NOT NULL PRIMARY KEY,
    titulo VARCHAR(200),
    nomeCliente VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL,
    problemas VARCHAR(200) NOT NULL,
    data DATE NOT NULL,
    produto VARCHAR(50) NOT NULL,
    departamento VARCHAR(50) NOT NULL,
    idProduto INTEGER NOT NULL,
    idDepartamento INTEGER NOT NULL,
    idRevendedor INTEGER NOT NULL
);

CREATE TABLE revendedor (
    idRevendedor SERIAL NOT NULL PRIMARY KEY,
    cnpj VARCHAR(50) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    endereco VARCHAR(300) NOT NULL,
    responsavel VARCHAR(200) NOT NULL
);

CREATE TABLE departamento (
    idDepartamento SERIAL NOT NULL PRIMARY KEY,
    nomeDepartamento VARCHAR(100) NOT NULL,
    codigoDepartamento VARCHAR(20) NOT NULL
);

INSERT INTO departamento (nomeDepartamento,codigoDepartamento) VALUES
('Administração','1212'),
('Suporte','1313'),
('Financeiro','1414'),
('Logística','1515');


CREATE TABLE observacao (
    idMensagem SERIAL NOT NULL PRIMARY KEY,
    data DATE,
    mensagem VARCHAR(500) NOT NULL,
    protocolo INTEGER NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    departamento VARCHAR(100) NOT NULL,
    revendedor VARCHAR(100) NOT NULL
);

ALTER TABLE ocorrencia ADD CONSTRAINT produto_ocorrencia_fk
FOREIGN KEY (idProduto)
REFERENCES produto (idProduto);

ALTER TABLE ocorrencia ADD CONSTRAINT revendedor_ocorrencia_fk
FOREIGN KEY (idrevendedor)
REFERENCES revendedor (idrevendedor);

ALTER TABLE ocorrencia ADD CONSTRAINT departamento_ocorrencia_fk
FOREIGN KEY (iddepartamento)
REFERENCES departamento (iddepartamento);

ALTER TABLE observacao ADD CONSTRAINT ocorrencia_observacao_fk
FOREIGN KEY (protocolo)
REFERENCES ocorrencia (protocolo);
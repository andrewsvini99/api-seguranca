CREATE TABLE cliente(
	codigo_cliente BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	sobrenome varchar(50) NOT NULL,
	idade integer NOT NULL,
	sexo char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
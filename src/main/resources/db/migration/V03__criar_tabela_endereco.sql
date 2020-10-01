CREATE TABLE endereco(
	codigo_endereco BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	rua varchar(50) NOT NULL,
	estado varchar(25) NOT NULL,
	numero integer NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
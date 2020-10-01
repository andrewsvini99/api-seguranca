CREATE TABLE produto(
	codigo_produto BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	tipo varchar(10) NOT NULL,
	fabricante varchar(50) NOT NULL,
	valor integer NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
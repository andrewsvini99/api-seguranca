CREATE TABLE estoque(
	codigo_estoque BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome varchar(50) NOT NULL,
	tipo varchar(50) NOT NULL,
	fabricante varchar(50) NOT NULL,
	valor integer NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
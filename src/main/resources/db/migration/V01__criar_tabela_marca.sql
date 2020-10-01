CREATE TABLE marca(
	codigo_marca BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	tipo varchar (50) NOT NULL,
	fabrica varchar(50) NOT NULL,
	valor integer NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
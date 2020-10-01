ALTER TABLE cliente ADD CONSTRAINT fk_grupo_cliente
FOREIGN KEY(codigo_cliente) REFERENCES grupo(codigo_grupo);

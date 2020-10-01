ALTER TABLE marca ADD CONSTRAINT fk_grupo_marca
FOREIGN KEY(codigo_marca) REFERENCES grupo(codigo_grupo);
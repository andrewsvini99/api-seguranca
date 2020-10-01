ALTER TABLE endereco ADD CONSTRAINT fk_grupo_endereco
FOREIGN KEY(codigo_endereco) REFERENCES grupo(codigo_grupo);

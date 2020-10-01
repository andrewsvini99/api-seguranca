ALTER TABLE produto ADD CONSTRAINT fk_grupo_produto
FOREIGN KEY(codigo_produto) REFERENCES grupo(codigo_grupo);

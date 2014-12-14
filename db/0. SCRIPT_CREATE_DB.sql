
-- TABLA USUARIO
CREATE TABLE public.usuario (
	nombre VARCHAR NOT NULL,
	password VARCHAR NOT NULL,
	CONSTRAINT usuario_pk PRIMARY KEY (nombre)
);

-- TABLA CATEGORIA
CREATE SEQUENCE public.categoria_id_seq;

CREATE TABLE public.categoria (
	id INTEGER NOT NULL DEFAULT nextval('public.categoria_id_seq'),
	descripcion VARCHAR NOT NULL,
	CONSTRAINT categoria_pk PRIMARY KEY (id)
);

ALTER SEQUENCE public.categoria_id_seq OWNED BY public.categoria.id;


-- TABLA POST
CREATE SEQUENCE public.post_id_seq;

CREATE TABLE public.post (
	id INTEGER NOT NULL DEFAULT nextval('public.post_id_seq'),
	titulo VARCHAR NOT NULL,
	detalle VARCHAR NOT NULL,
	fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	categoria INTEGER NOT NULL,
	CONSTRAINT post_pk PRIMARY KEY (id),
	CONSTRAINT post_categoria_fk FOREIGN KEY (categoria) REFERENCES categoria(id)	
);

ALTER SEQUENCE public.post_id_seq OWNED BY public.post.id;


-- USUARIO DE PRUEBA
INSERT INTO USUARIO VALUES ('admin', '912ec803b2ce49e4a541068d495ab570');
INSERT INTO USUARIO VALUES ('juan', '912ec803b2ce49e4a541068d495ab570');

-- CATEGORIAS (MAESTROS)
INSERT INTO CATEGORIA (descripcion) VALUES('Pregunta');
INSERT INTO CATEGORIA (descripcion) VALUES('Publicacion');
INSERT INTO CATEGORIA (descripcion) VALUES('Agumentacion');
INSERT INTO CATEGORIA (descripcion) VALUES('Respuesta');



-- 14-12-2014

-- Agrega la columna AUTOR a la tabla POST.
ALTER TABLE public.post ADD COLUMN autor VARCHAR NOT NULL DEFAULT '';

-- Si la tabla post no está vacía es necesario realizar update.
-- UPDATE public.post SET autor = 'juan' ;

-- Clave foránea de POST a USUARIO.
ALTER TABLE public.post ADD CONSTRAINT post_usuario_fk 
FOREIGN KEY (autor) REFERENCES public.usuario (nombre);


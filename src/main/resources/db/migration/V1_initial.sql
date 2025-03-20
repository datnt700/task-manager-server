CREATE TABLE IF NOT EXISTS public.board
(
    id bigint NOT NULL DEFAULT nextval('"Board_id_seq"'::regclass),
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    create_at timestamp(6) without time zone,
    CONSTRAINT "Board_pkey" PRIMARY KEY (id)
    )

CREATE TABLE IF NOT EXISTS public.tag
(
    name character varying(255) COLLATE pg_catalog."default",
    id bigint NOT NULL DEFAULT nextval('tag_id_seq'::regclass),
    CONSTRAINT tag_pkey PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS public.task
(
    id bigint NOT NULL DEFAULT nextval('tasks_id_seq'::regclass),
    title character varying(255) COLLATE pg_catalog."default",
    status character varying(255) COLLATE pg_catalog."default",
    background character varying(255) COLLATE pg_catalog."default",
    board_id bigint,
    CONSTRAINT tasks_pkey PRIMARY KEY (id),
    CONSTRAINT board_id_fk FOREIGN KEY (board_id)
    REFERENCES public.board (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID
)
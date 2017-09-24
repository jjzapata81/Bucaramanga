CREATE TABLE ta_proveedor
(
  nmproveedor numeric(10,0) NOT NULL,
  nit numeric(10,0),
  razonsocial character varying(100),
  direccion character varying(100),
  telefono character varying(20),
  correo character varying(80),
  observacion character varying(200),
  CONSTRAINT pk_ta_proveedor PRIMARY KEY (nmproveedor)
);

CREATE SEQUENCE sq_ta_proveedor
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE sq_ta_proveedor
  OWNER TO postgres;

--  DROP TABLE ta_usuarios;

CREATE TABLE ta_usuarios
(
  nmusuario numeric(20,0) NOT NULL,
  nombre character varying(100),
  apellido character varying(100),
  nombreusuario character varying(10),
  pass character varying(100),
  snactivo character varying(1),
  feingreso date,
  febaja date,
  CONSTRAINT pk_ta_usuarios PRIMARY KEY (nmusuario),
  CONSTRAINT uk_ta_usuarios_nombre_apellido UNIQUE (nombre, apellido)
);

CREATE TABLE ta_usuario_audi
(
  id numeric(10,0) NOT NULL,
  nmusuario numeric(20,0) NOT NULL,
  accion character varying(15),
  fecha date,
  snactivo character varying(1),
  CONSTRAINT pk_ta_usuario_audi PRIMARY KEY (id),
  CONSTRAINT ta_usuario_audi_nmusuario_fkey FOREIGN KEY (nmusuario)
    REFERENCES ta_usuarios (nmusuario) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE SEQUENCE sq_ta_usuario_audi
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE sq_ta_usuario_audi
  OWNER TO postgres;

CREATE TABLE ta_productos
(
  codproducto character varying(20) NOT NULL,
  nombre character varying(100),
  observacion character varying(200),
  sniva character varying (1) NOT NULL DEFAULT 'N'::character varying,
  porcentajeiva numeric (5,2),
  snactivo character varying(1) NOT NULL DEFAULT 'S'::character varying,
  CONSTRAINT pk_ta_productos PRIMARY KEY (codproducto),
  CONSTRAINT uk_ta_productos_nombre UNIQUE (nombre)
);

CREATE TABLE ta_entrada
(
  nmentrada numeric(10,0) NOT NULL,
  nmproveedor numeric(10,0) NOT NULL,
  nmfacturacompra numeric(10,0),
  fefacturacompra date,
  CONSTRAINT pk_ta_entrada PRIMARY KEY (nmentrada),
  CONSTRAINT ta_entrada_nmproveedor_fkey FOREIGN KEY (nmproveedor)
    REFERENCES ta_proveedor (nmproveedor) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE ta_salida
(
  nmsalida numeric(10,0) NOT NULL,
  nmfacturaventa numeric (10,0),
  fefacturaventa date,
  CONSTRAINT pk_ta_salida PRIMARY KEY (nmsalida)
);


CREATE TABLE ta_kardex
(
  nmkardex numeric(10,0) NOT NULL,
  codproducto numeric(10,0),
  nmentrada numeric(10,0),
  nmsalida numeric(10,0),
  tipo character varying(3),
  saldoanterior numeric(12,0),
  cantidadentrada numeric (10,0),
  cantidadsalida numeric (10,0),
  saldoactual numeric (12,0),
  preciocompra numeric (10,2),
  ivapreciocompra numeric (10,2),
  preciounitario numeric(10,2),
  ivapreciounitario numeric (10,2),
  preciocomercial numeric (10,2),
  CONSTRAINT pk_ta_kardex PRIMARY KEY (nmkardex),
  CONSTRAINT ta_kardex_codproducto_fkey FOREIGN KEY (codproducto)
      REFERENCES ta_productos (codproducto) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE SEQUENCE sq_ta_kardex
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE sq_ta_kardex
  OWNER TO postgres;

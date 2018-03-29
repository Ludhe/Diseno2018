-- User: mortal2018
-- DROP USER mortal2018;

CREATE USER mortal2018 WITH
  LOGIN
  NOSUPERUSER
  INHERIT
  NOCREATEDB
  NOCREATEROLE
  NOREPLICATION;

ALTER USER mortal2018 WITH PASSWORD 'mortal';

  --
  -- PostgreSQL database dump
  --

  -- Dumped from database version 9.6.6
  -- Dumped by pg_dump version 9.6.6

  -- Started on 2018-03-28 23:50:07 CST

  SET statement_timeout = 0;
  SET lock_timeout = 0;
  SET idle_in_transaction_session_timeout = 0;
  SET client_encoding = 'UTF8';
  SET standard_conforming_strings = on;
  SET check_function_bodies = false;
  SET client_min_messages = warning;
  SET row_security = off;

  --
  -- TOC entry 1 (class 3079 OID 12393)
  -- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
  --

  CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


  --
  -- TOC entry 2377 (class 0 OID 0)
  -- Dependencies: 1
  -- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
  --

  COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


  SET search_path = public, pg_catalog;

  SET default_tablespace = '';

  SET default_with_oids = false;

  --
  -- TOC entry 230 (class 1259 OID 17011)
  -- Name: calendario; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE calendario (
      id_fecha integer NOT NULL,
      fecha date,
      descripcion text
  );


  ALTER TABLE calendario OWNER TO mortal2018;

  --
  -- TOC entry 192 (class 1259 OID 16817)
  -- Name: calendario_excepcion; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE calendario_excepcion (
      id_excepcion integer NOT NULL,
      fecha date NOT NULL,
      estado boolean,
      descripcion text
  );


  ALTER TABLE calendario_excepcion OWNER TO mortal2018;

  --
  -- TOC entry 191 (class 1259 OID 16815)
  -- Name: calendario_excepcion_id_excepcion_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE calendario_excepcion_id_excepcion_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE calendario_excepcion_id_excepcion_seq OWNER TO mortal2018;

  --
  -- TOC entry 2378 (class 0 OID 0)
  -- Dependencies: 191
  -- Name: calendario_excepcion_id_excepcion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE calendario_excepcion_id_excepcion_seq OWNED BY calendario_excepcion.id_excepcion;


  --
  -- TOC entry 229 (class 1259 OID 17009)
  -- Name: calendario_id_fecha_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE calendario_id_fecha_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE calendario_id_fecha_seq OWNER TO mortal2018;

  --
  -- TOC entry 2379 (class 0 OID 0)
  -- Dependencies: 229
  -- Name: calendario_id_fecha_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE calendario_id_fecha_seq OWNED BY calendario.id_fecha;


  --
  -- TOC entry 218 (class 1259 OID 16948)
  -- Name: diagnostico; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE diagnostico (
      id_diagnostico integer NOT NULL,
      nombre character varying(50) NOT NULL,
      descripcion text
  );


  ALTER TABLE diagnostico OWNER TO mortal2018;

  --
  -- TOC entry 217 (class 1259 OID 16946)
  -- Name: diagnostico_id_diagnostico_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE diagnostico_id_diagnostico_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE diagnostico_id_diagnostico_seq OWNER TO mortal2018;

  --
  -- TOC entry 2380 (class 0 OID 0)
  -- Dependencies: 217
  -- Name: diagnostico_id_diagnostico_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE diagnostico_id_diagnostico_seq OWNED BY diagnostico.id_diagnostico;


  --
  -- TOC entry 228 (class 1259 OID 17003)
  -- Name: diagnostico_parte; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE diagnostico_parte (
      id_diagnostico_parte integer NOT NULL,
      id_diagnostico integer,
      id_parte integer
  );


  ALTER TABLE diagnostico_parte OWNER TO mortal2018;

  --
  -- TOC entry 227 (class 1259 OID 17001)
  -- Name: diagnostico_parte_id_diagnostico_parte_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE diagnostico_parte_id_diagnostico_parte_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE diagnostico_parte_id_diagnostico_parte_seq OWNER TO mortal2018;

  --
  -- TOC entry 2381 (class 0 OID 0)
  -- Dependencies: 227
  -- Name: diagnostico_parte_id_diagnostico_parte_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE diagnostico_parte_id_diagnostico_parte_seq OWNED BY diagnostico_parte.id_diagnostico_parte;


  --
  -- TOC entry 200 (class 1259 OID 16858)
  -- Name: equipo; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE equipo (
      id_quipo integer NOT NULL,
      correlativo character varying(20) NOT NULL,
      observaciones text
  );


  ALTER TABLE equipo OWNER TO mortal2018;

  --
  -- TOC entry 204 (class 1259 OID 16877)
  -- Name: equipo_detalle; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE equipo_detalle (
      id_equipo_detalle bigint NOT NULL,
      id_parte integer,
      id_modelo integer,
      id_equipo integer,
      id_marca integer
  );


  ALTER TABLE equipo_detalle OWNER TO mortal2018;

  --
  -- TOC entry 203 (class 1259 OID 16875)
  -- Name: equipo_detalle_id_equipo_detalle_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE equipo_detalle_id_equipo_detalle_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE equipo_detalle_id_equipo_detalle_seq OWNER TO mortal2018;

  --
  -- TOC entry 2382 (class 0 OID 0)
  -- Dependencies: 203
  -- Name: equipo_detalle_id_equipo_detalle_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE equipo_detalle_id_equipo_detalle_seq OWNED BY equipo_detalle.id_equipo_detalle;


  --
  -- TOC entry 199 (class 1259 OID 16856)
  -- Name: equipo_id_quipo_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE equipo_id_quipo_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE equipo_id_quipo_seq OWNER TO mortal2018;

  --
  -- TOC entry 2383 (class 0 OID 0)
  -- Dependencies: 199
  -- Name: equipo_id_quipo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE equipo_id_quipo_seq OWNED BY equipo.id_quipo;


  --
  -- TOC entry 210 (class 1259 OID 16907)
  -- Name: estado; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE estado (
      id_estado integer NOT NULL,
      nombre character varying(50) NOT NULL,
      activo boolean,
      descripcion text
  );


  ALTER TABLE estado OWNER TO mortal2018;

  --
  -- TOC entry 209 (class 1259 OID 16905)
  -- Name: estado_id_estado_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE estado_id_estado_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE estado_id_estado_seq OWNER TO mortal2018;

  --
  -- TOC entry 2384 (class 0 OID 0)
  -- Dependencies: 209
  -- Name: estado_id_estado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE estado_id_estado_seq OWNED BY estado.id_estado;


  --
  -- TOC entry 216 (class 1259 OID 16940)
  -- Name: estado_mantenimiento_detalle; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE estado_mantenimiento_detalle (
      id_estado_mantenimiento_detalle integer NOT NULL,
      id_mantenimiento_detalle integer,
      id_estado integer,
      id_responsable integer,
      id_paso integer
  );


  ALTER TABLE estado_mantenimiento_detalle OWNER TO mortal2018;

  --
  -- TOC entry 215 (class 1259 OID 16938)
  -- Name: estado_mantenimiento_detalle_id_estado_mantenimiento_detall_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE estado_mantenimiento_detalle_id_estado_mantenimiento_detall_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE estado_mantenimiento_detalle_id_estado_mantenimiento_detall_seq OWNER TO mortal2018;

  --
  -- TOC entry 2385 (class 0 OID 0)
  -- Dependencies: 215
  -- Name: estado_mantenimiento_detalle_id_estado_mantenimiento_detall_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE estado_mantenimiento_detalle_id_estado_mantenimiento_detall_seq OWNED BY estado_mantenimiento_detalle.id_estado_mantenimiento_detalle;


  --
  -- TOC entry 202 (class 1259 OID 16869)
  -- Name: mantenimiento_detalle; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE mantenimiento_detalle (
      id_mantenimiento_detalle bigint NOT NULL,
      id_equipo_detalle integer,
      id_oden_trabajo integer
  );


  ALTER TABLE mantenimiento_detalle OWNER TO mortal2018;

  --
  -- TOC entry 201 (class 1259 OID 16867)
  -- Name: mantenimiento_detalle_id_mantenimiento_detalle_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE mantenimiento_detalle_id_mantenimiento_detalle_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE mantenimiento_detalle_id_mantenimiento_detalle_seq OWNER TO mortal2018;

  --
  -- TOC entry 2386 (class 0 OID 0)
  -- Dependencies: 201
  -- Name: mantenimiento_detalle_id_mantenimiento_detalle_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE mantenimiento_detalle_id_mantenimiento_detalle_seq OWNED BY mantenimiento_detalle.id_mantenimiento_detalle;


  --
  -- TOC entry 206 (class 1259 OID 16885)
  -- Name: marca; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE marca (
      id_marca integer NOT NULL,
      nombre character varying(50),
      activo boolean,
      descripcion text
  );


  ALTER TABLE marca OWNER TO mortal2018;

  --
  -- TOC entry 205 (class 1259 OID 16883)
  -- Name: marca_id_marca_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE marca_id_marca_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE marca_id_marca_seq OWNER TO mortal2018;

  --
  -- TOC entry 2387 (class 0 OID 0)
  -- Dependencies: 205
  -- Name: marca_id_marca_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE marca_id_marca_seq OWNED BY marca.id_marca;


  --
  -- TOC entry 208 (class 1259 OID 16896)
  -- Name: modelo; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE modelo (
      id_modelo integer NOT NULL,
      nombre character varying(50) NOT NULL,
      activo boolean,
      descripcion text
  );


  ALTER TABLE modelo OWNER TO mortal2018;

  --
  -- TOC entry 207 (class 1259 OID 16894)
  -- Name: modelo_id_modelo_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE modelo_id_modelo_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE modelo_id_modelo_seq OWNER TO mortal2018;

  --
  -- TOC entry 2388 (class 0 OID 0)
  -- Dependencies: 207
  -- Name: modelo_id_modelo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE modelo_id_modelo_seq OWNED BY modelo.id_modelo;


  --
  -- TOC entry 198 (class 1259 OID 16847)
  -- Name: orden_trabajo; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE orden_trabajo (
      id_orden_trabajo bigint NOT NULL,
      fecha_inicio date,
      observaciones text,
      fecha_estimada date,
      id_solicitud integer,
      id_tipo_mantenimiento integer,
      id_unidad integer,
      id_prioridad integer,
      id_equipo integer
  );


  ALTER TABLE orden_trabajo OWNER TO mortal2018;

  --
  -- TOC entry 232 (class 1259 OID 17022)
  -- Name: orden_trabajo_calendario; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE orden_trabajo_calendario (
      id_orden_trabajo_calendario integer NOT NULL,
      id_fecha integer,
      id_orden_trabajo integer
  );


  ALTER TABLE orden_trabajo_calendario OWNER TO mortal2018;

  --
  -- TOC entry 231 (class 1259 OID 17020)
  -- Name: orden_trabajo_calendario_id_orden_trabajo_calendario_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE orden_trabajo_calendario_id_orden_trabajo_calendario_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE orden_trabajo_calendario_id_orden_trabajo_calendario_seq OWNER TO mortal2018;

  --
  -- TOC entry 2389 (class 0 OID 0)
  -- Dependencies: 231
  -- Name: orden_trabajo_calendario_id_orden_trabajo_calendario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE orden_trabajo_calendario_id_orden_trabajo_calendario_seq OWNED BY orden_trabajo_calendario.id_orden_trabajo_calendario;


  --
  -- TOC entry 197 (class 1259 OID 16845)
  -- Name: orden_trabajo_id_orden_trabajo_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE orden_trabajo_id_orden_trabajo_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE orden_trabajo_id_orden_trabajo_seq OWNER TO mortal2018;

  --
  -- TOC entry 2390 (class 0 OID 0)
  -- Dependencies: 197
  -- Name: orden_trabajo_id_orden_trabajo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE orden_trabajo_id_orden_trabajo_seq OWNED BY orden_trabajo.id_orden_trabajo;


  --
  -- TOC entry 226 (class 1259 OID 16992)
  -- Name: parte; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE parte (
      id_parte integer NOT NULL,
      nombre character varying(50) NOT NULL,
      descripcion text,
      id_tipo_parte integer
  );


  ALTER TABLE parte OWNER TO mortal2018;

  --
  -- TOC entry 225 (class 1259 OID 16990)
  -- Name: parte_id_parte_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE parte_id_parte_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE parte_id_parte_seq OWNER TO mortal2018;

  --
  -- TOC entry 2391 (class 0 OID 0)
  -- Dependencies: 225
  -- Name: parte_id_parte_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE parte_id_parte_seq OWNED BY parte.id_parte;


  --
  -- TOC entry 222 (class 1259 OID 16970)
  -- Name: paso; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE paso (
      id_paso integer NOT NULL,
      nombre character varying(50) NOT NULL,
      descripcion text,
      id_procedimiento integer
  );


  ALTER TABLE paso OWNER TO mortal2018;

  --
  -- TOC entry 221 (class 1259 OID 16968)
  -- Name: paso_id_paso_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE paso_id_paso_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE paso_id_paso_seq OWNER TO mortal2018;

  --
  -- TOC entry 2392 (class 0 OID 0)
  -- Dependencies: 221
  -- Name: paso_id_paso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE paso_id_paso_seq OWNED BY paso.id_paso;


  --
  -- TOC entry 196 (class 1259 OID 16836)
  -- Name: prioridad; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE prioridad (
      id_prioridad integer NOT NULL,
      nombre character varying(50) NOT NULL,
      descripcion text,
      activo boolean
  );


  ALTER TABLE prioridad OWNER TO mortal2018;

  --
  -- TOC entry 195 (class 1259 OID 16834)
  -- Name: prioridad_id_prioridad_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE prioridad_id_prioridad_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE prioridad_id_prioridad_seq OWNER TO mortal2018;

  --
  -- TOC entry 2393 (class 0 OID 0)
  -- Dependencies: 195
  -- Name: prioridad_id_prioridad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE prioridad_id_prioridad_seq OWNED BY prioridad.id_prioridad;


  --
  -- TOC entry 220 (class 1259 OID 16959)
  -- Name: procedimiento; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE procedimiento (
      id_procedimiento integer NOT NULL,
      nombre character varying(50) NOT NULL,
      activo boolean,
      descripcion text,
      id_diagnostico integer
  );


  ALTER TABLE procedimiento OWNER TO mortal2018;

  --
  -- TOC entry 219 (class 1259 OID 16957)
  -- Name: procedimiento_id_procedimiento_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE procedimiento_id_procedimiento_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE procedimiento_id_procedimiento_seq OWNER TO mortal2018;

  --
  -- TOC entry 2394 (class 0 OID 0)
  -- Dependencies: 219
  -- Name: procedimiento_id_procedimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE procedimiento_id_procedimiento_seq OWNED BY procedimiento.id_procedimiento;


  --
  -- TOC entry 214 (class 1259 OID 16929)
  -- Name: responsable; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE responsable (
      id_responsable integer NOT NULL,
      nombre character varying(50),
      activo boolean,
      descripcion text,
      id_tipo_responsable integer
  );


  ALTER TABLE responsable OWNER TO mortal2018;

  --
  -- TOC entry 213 (class 1259 OID 16927)
  -- Name: responsable_id_responsable_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE responsable_id_responsable_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE responsable_id_responsable_seq OWNER TO mortal2018;

  --
  -- TOC entry 2395 (class 0 OID 0)
  -- Dependencies: 213
  -- Name: responsable_id_responsable_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE responsable_id_responsable_seq OWNED BY responsable.id_responsable;


  --
  -- TOC entry 194 (class 1259 OID 16828)
  -- Name: solicitud; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE solicitud (
      id_solicitud integer NOT NULL,
      solicitante character varying(255),
      fecha_solicitud date,
      activo boolean
  );


  ALTER TABLE solicitud OWNER TO mortal2018;

  --
  -- TOC entry 193 (class 1259 OID 16826)
  -- Name: solicitud_id_solicitud_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE solicitud_id_solicitud_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE solicitud_id_solicitud_seq OWNER TO mortal2018;

  --
  -- TOC entry 2396 (class 0 OID 0)
  -- Dependencies: 193
  -- Name: solicitud_id_solicitud_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE solicitud_id_solicitud_seq OWNED BY solicitud.id_solicitud;


  --
  -- TOC entry 186 (class 1259 OID 16784)
  -- Name: sub_tipo_mantenimiento; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE sub_tipo_mantenimiento (
      id_sub_tipo_mantenimiento integer NOT NULL,
      nombre character varying(50) NOT NULL,
      descripcion text
  );


  ALTER TABLE sub_tipo_mantenimiento OWNER TO mortal2018;

  --
  -- TOC entry 185 (class 1259 OID 16782)
  -- Name: sub_tipo_mantenimiento_id_sub_tipo_mantenimiento_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE sub_tipo_mantenimiento_id_sub_tipo_mantenimiento_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE sub_tipo_mantenimiento_id_sub_tipo_mantenimiento_seq OWNER TO mortal2018;

  --
  -- TOC entry 2397 (class 0 OID 0)
  -- Dependencies: 185
  -- Name: sub_tipo_mantenimiento_id_sub_tipo_mantenimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE sub_tipo_mantenimiento_id_sub_tipo_mantenimiento_seq OWNED BY sub_tipo_mantenimiento.id_sub_tipo_mantenimiento;


  --
  -- TOC entry 188 (class 1259 OID 16795)
  -- Name: tipo_mantenimiento; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE tipo_mantenimiento (
      id_tipo_mantenimiento integer NOT NULL,
      nombre character varying(60) NOT NULL,
      descipcion text,
      activo boolean,
      id_sub_tipo_mantenimiento integer
  );


  ALTER TABLE tipo_mantenimiento OWNER TO mortal2018;

  --
  -- TOC entry 187 (class 1259 OID 16793)
  -- Name: tipo_mantenimiento_id_tipo_mantenimiento_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE tipo_mantenimiento_id_tipo_mantenimiento_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE tipo_mantenimiento_id_tipo_mantenimiento_seq OWNER TO mortal2018;

  --
  -- TOC entry 2398 (class 0 OID 0)
  -- Dependencies: 187
  -- Name: tipo_mantenimiento_id_tipo_mantenimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE tipo_mantenimiento_id_tipo_mantenimiento_seq OWNED BY tipo_mantenimiento.id_tipo_mantenimiento;


  --
  -- TOC entry 224 (class 1259 OID 16981)
  -- Name: tipo_parte; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE tipo_parte (
      id_tipo_parte integer NOT NULL,
      nombre character varying(50) NOT NULL,
      descripcion text
  );


  ALTER TABLE tipo_parte OWNER TO mortal2018;

  --
  -- TOC entry 223 (class 1259 OID 16979)
  -- Name: tipo_parte_id_tipo_parte_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE tipo_parte_id_tipo_parte_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE tipo_parte_id_tipo_parte_seq OWNER TO mortal2018;

  --
  -- TOC entry 2399 (class 0 OID 0)
  -- Dependencies: 223
  -- Name: tipo_parte_id_tipo_parte_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE tipo_parte_id_tipo_parte_seq OWNED BY tipo_parte.id_tipo_parte;


  --
  -- TOC entry 212 (class 1259 OID 16918)
  -- Name: tipo_responsable; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE tipo_responsable (
      id_tipo_responsable integer NOT NULL,
      nombre character varying(50),
      descripciont text
  );


  ALTER TABLE tipo_responsable OWNER TO mortal2018;

  --
  -- TOC entry 211 (class 1259 OID 16916)
  -- Name: tipo_responsable_id_tipo_responsable_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE tipo_responsable_id_tipo_responsable_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE tipo_responsable_id_tipo_responsable_seq OWNER TO mortal2018;

  --
  -- TOC entry 2400 (class 0 OID 0)
  -- Dependencies: 211
  -- Name: tipo_responsable_id_tipo_responsable_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE tipo_responsable_id_tipo_responsable_seq OWNED BY tipo_responsable.id_tipo_responsable;


  --
  -- TOC entry 190 (class 1259 OID 16806)
  -- Name: unidad; Type: TABLE; Schema: public; Owner: mortal2018
  --

  CREATE TABLE unidad (
      id_unidad integer NOT NULL,
      nombre character varying(50) NOT NULL,
      codigo character varying
  );


  ALTER TABLE unidad OWNER TO mortal2018;

  --
  -- TOC entry 189 (class 1259 OID 16804)
  -- Name: unidad_id_unidad_seq; Type: SEQUENCE; Schema: public; Owner: mortal2018
  --

  CREATE SEQUENCE unidad_id_unidad_seq
      START WITH 1
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;


  ALTER TABLE unidad_id_unidad_seq OWNER TO mortal2018;

  --
  -- TOC entry 2401 (class 0 OID 0)
  -- Dependencies: 189
  -- Name: unidad_id_unidad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mortal2018
  --

  ALTER SEQUENCE unidad_id_unidad_seq OWNED BY unidad.id_unidad;


  --
  -- TOC entry 2183 (class 2604 OID 17014)
  -- Name: calendario id_fecha; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY calendario ALTER COLUMN id_fecha SET DEFAULT nextval('calendario_id_fecha_seq'::regclass);


  --
  -- TOC entry 2164 (class 2604 OID 16820)
  -- Name: calendario_excepcion id_excepcion; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY calendario_excepcion ALTER COLUMN id_excepcion SET DEFAULT nextval('calendario_excepcion_id_excepcion_seq'::regclass);


  --
  -- TOC entry 2177 (class 2604 OID 16951)
  -- Name: diagnostico id_diagnostico; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY diagnostico ALTER COLUMN id_diagnostico SET DEFAULT nextval('diagnostico_id_diagnostico_seq'::regclass);


  --
  -- TOC entry 2182 (class 2604 OID 17006)
  -- Name: diagnostico_parte id_diagnostico_parte; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY diagnostico_parte ALTER COLUMN id_diagnostico_parte SET DEFAULT nextval('diagnostico_parte_id_diagnostico_parte_seq'::regclass);


  --
  -- TOC entry 2168 (class 2604 OID 16861)
  -- Name: equipo id_quipo; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY equipo ALTER COLUMN id_quipo SET DEFAULT nextval('equipo_id_quipo_seq'::regclass);


  --
  -- TOC entry 2170 (class 2604 OID 16880)
  -- Name: equipo_detalle id_equipo_detalle; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY equipo_detalle ALTER COLUMN id_equipo_detalle SET DEFAULT nextval('equipo_detalle_id_equipo_detalle_seq'::regclass);


  --
  -- TOC entry 2173 (class 2604 OID 16910)
  -- Name: estado id_estado; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY estado ALTER COLUMN id_estado SET DEFAULT nextval('estado_id_estado_seq'::regclass);


  --
  -- TOC entry 2176 (class 2604 OID 16943)
  -- Name: estado_mantenimiento_detalle id_estado_mantenimiento_detalle; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY estado_mantenimiento_detalle ALTER COLUMN id_estado_mantenimiento_detalle SET DEFAULT nextval('estado_mantenimiento_detalle_id_estado_mantenimiento_detall_seq'::regclass);


  --
  -- TOC entry 2169 (class 2604 OID 16872)
  -- Name: mantenimiento_detalle id_mantenimiento_detalle; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY mantenimiento_detalle ALTER COLUMN id_mantenimiento_detalle SET DEFAULT nextval('mantenimiento_detalle_id_mantenimiento_detalle_seq'::regclass);


  --
  -- TOC entry 2171 (class 2604 OID 16888)
  -- Name: marca id_marca; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY marca ALTER COLUMN id_marca SET DEFAULT nextval('marca_id_marca_seq'::regclass);


  --
  -- TOC entry 2172 (class 2604 OID 16899)
  -- Name: modelo id_modelo; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY modelo ALTER COLUMN id_modelo SET DEFAULT nextval('modelo_id_modelo_seq'::regclass);


  --
  -- TOC entry 2167 (class 2604 OID 16850)
  -- Name: orden_trabajo id_orden_trabajo; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY orden_trabajo ALTER COLUMN id_orden_trabajo SET DEFAULT nextval('orden_trabajo_id_orden_trabajo_seq'::regclass);


  --
  -- TOC entry 2184 (class 2604 OID 17025)
  -- Name: orden_trabajo_calendario id_orden_trabajo_calendario; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY orden_trabajo_calendario ALTER COLUMN id_orden_trabajo_calendario SET DEFAULT nextval('orden_trabajo_calendario_id_orden_trabajo_calendario_seq'::regclass);


  --
  -- TOC entry 2181 (class 2604 OID 16995)
  -- Name: parte id_parte; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY parte ALTER COLUMN id_parte SET DEFAULT nextval('parte_id_parte_seq'::regclass);


  --
  -- TOC entry 2179 (class 2604 OID 16973)
  -- Name: paso id_paso; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY paso ALTER COLUMN id_paso SET DEFAULT nextval('paso_id_paso_seq'::regclass);


  --
  -- TOC entry 2166 (class 2604 OID 16839)
  -- Name: prioridad id_prioridad; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY prioridad ALTER COLUMN id_prioridad SET DEFAULT nextval('prioridad_id_prioridad_seq'::regclass);


  --
  -- TOC entry 2178 (class 2604 OID 16962)
  -- Name: procedimiento id_procedimiento; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY procedimiento ALTER COLUMN id_procedimiento SET DEFAULT nextval('procedimiento_id_procedimiento_seq'::regclass);


  --
  -- TOC entry 2175 (class 2604 OID 16932)
  -- Name: responsable id_responsable; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY responsable ALTER COLUMN id_responsable SET DEFAULT nextval('responsable_id_responsable_seq'::regclass);


  --
  -- TOC entry 2165 (class 2604 OID 16831)
  -- Name: solicitud id_solicitud; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY solicitud ALTER COLUMN id_solicitud SET DEFAULT nextval('solicitud_id_solicitud_seq'::regclass);


  --
  -- TOC entry 2161 (class 2604 OID 16787)
  -- Name: sub_tipo_mantenimiento id_sub_tipo_mantenimiento; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY sub_tipo_mantenimiento ALTER COLUMN id_sub_tipo_mantenimiento SET DEFAULT nextval('sub_tipo_mantenimiento_id_sub_tipo_mantenimiento_seq'::regclass);


  --
  -- TOC entry 2162 (class 2604 OID 16798)
  -- Name: tipo_mantenimiento id_tipo_mantenimiento; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY tipo_mantenimiento ALTER COLUMN id_tipo_mantenimiento SET DEFAULT nextval('tipo_mantenimiento_id_tipo_mantenimiento_seq'::regclass);


  --
  -- TOC entry 2180 (class 2604 OID 16984)
  -- Name: tipo_parte id_tipo_parte; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY tipo_parte ALTER COLUMN id_tipo_parte SET DEFAULT nextval('tipo_parte_id_tipo_parte_seq'::regclass);


  --
  -- TOC entry 2174 (class 2604 OID 16921)
  -- Name: tipo_responsable id_tipo_responsable; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY tipo_responsable ALTER COLUMN id_tipo_responsable SET DEFAULT nextval('tipo_responsable_id_tipo_responsable_seq'::regclass);


  --
  -- TOC entry 2163 (class 2604 OID 16809)
  -- Name: unidad id_unidad; Type: DEFAULT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY unidad ALTER COLUMN id_unidad SET DEFAULT nextval('unidad_id_unidad_seq'::regclass);


  --
  -- TOC entry 2230 (class 2606 OID 17019)
  -- Name: calendario pk_calendario; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY calendario
      ADD CONSTRAINT pk_calendario PRIMARY KEY (id_fecha);


  --
  -- TOC entry 2192 (class 2606 OID 16825)
  -- Name: calendario_excepcion pk_calendario_excepcion; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY calendario_excepcion
      ADD CONSTRAINT pk_calendario_excepcion PRIMARY KEY (id_excepcion);


  --
  -- TOC entry 2218 (class 2606 OID 16956)
  -- Name: diagnostico pk_diagnostico; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY diagnostico
      ADD CONSTRAINT pk_diagnostico PRIMARY KEY (id_diagnostico);


  --
  -- TOC entry 2228 (class 2606 OID 17008)
  -- Name: diagnostico_parte pk_diagnostico_parte; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY diagnostico_parte
      ADD CONSTRAINT pk_diagnostico_parte PRIMARY KEY (id_diagnostico_parte);


  --
  -- TOC entry 2200 (class 2606 OID 16866)
  -- Name: equipo pk_equipo; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY equipo
      ADD CONSTRAINT pk_equipo PRIMARY KEY (id_quipo);


  --
  -- TOC entry 2204 (class 2606 OID 16882)
  -- Name: equipo_detalle pk_equipo_detalle; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY equipo_detalle
      ADD CONSTRAINT pk_equipo_detalle PRIMARY KEY (id_equipo_detalle);


  --
  -- TOC entry 2210 (class 2606 OID 16915)
  -- Name: estado pk_estado; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY estado
      ADD CONSTRAINT pk_estado PRIMARY KEY (id_estado);


  --
  -- TOC entry 2216 (class 2606 OID 16945)
  -- Name: estado_mantenimiento_detalle pk_estado_mantenimiento_detalle; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY estado_mantenimiento_detalle
      ADD CONSTRAINT pk_estado_mantenimiento_detalle PRIMARY KEY (id_estado_mantenimiento_detalle);


  --
  -- TOC entry 2202 (class 2606 OID 16874)
  -- Name: mantenimiento_detalle pk_mantenimiento_detalle; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY mantenimiento_detalle
      ADD CONSTRAINT pk_mantenimiento_detalle PRIMARY KEY (id_mantenimiento_detalle);


  --
  -- TOC entry 2206 (class 2606 OID 16893)
  -- Name: marca pk_marca; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY marca
      ADD CONSTRAINT pk_marca PRIMARY KEY (id_marca);


  --
  -- TOC entry 2208 (class 2606 OID 16904)
  -- Name: modelo pk_modelo; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY modelo
      ADD CONSTRAINT pk_modelo PRIMARY KEY (id_modelo);


  --
  -- TOC entry 2198 (class 2606 OID 16855)
  -- Name: orden_trabajo pk_orden_trabajo; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY orden_trabajo
      ADD CONSTRAINT pk_orden_trabajo PRIMARY KEY (id_orden_trabajo);


  --
  -- TOC entry 2232 (class 2606 OID 17027)
  -- Name: orden_trabajo_calendario pk_orden_trabajo_calendario; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY orden_trabajo_calendario
      ADD CONSTRAINT pk_orden_trabajo_calendario PRIMARY KEY (id_orden_trabajo_calendario);


  --
  -- TOC entry 2226 (class 2606 OID 17000)
  -- Name: parte pk_parte; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY parte
      ADD CONSTRAINT pk_parte PRIMARY KEY (id_parte);


  --
  -- TOC entry 2222 (class 2606 OID 16978)
  -- Name: paso pk_paso; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY paso
      ADD CONSTRAINT pk_paso PRIMARY KEY (id_paso);


  --
  -- TOC entry 2196 (class 2606 OID 16844)
  -- Name: prioridad pk_prioridad; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY prioridad
      ADD CONSTRAINT pk_prioridad PRIMARY KEY (id_prioridad);


  --
  -- TOC entry 2220 (class 2606 OID 16967)
  -- Name: procedimiento pk_procedimiento; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY procedimiento
      ADD CONSTRAINT pk_procedimiento PRIMARY KEY (id_procedimiento);


  --
  -- TOC entry 2214 (class 2606 OID 16937)
  -- Name: responsable pk_rsponsable; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY responsable
      ADD CONSTRAINT pk_rsponsable PRIMARY KEY (id_responsable);


  --
  -- TOC entry 2194 (class 2606 OID 16833)
  -- Name: solicitud pk_solicitud; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY solicitud
      ADD CONSTRAINT pk_solicitud PRIMARY KEY (id_solicitud);


  --
  -- TOC entry 2186 (class 2606 OID 16792)
  -- Name: sub_tipo_mantenimiento pk_sub_tipo_mantenimiento; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY sub_tipo_mantenimiento
      ADD CONSTRAINT pk_sub_tipo_mantenimiento PRIMARY KEY (id_sub_tipo_mantenimiento);


  --
  -- TOC entry 2188 (class 2606 OID 16803)
  -- Name: tipo_mantenimiento pk_tipo_mantenimiento; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY tipo_mantenimiento
      ADD CONSTRAINT pk_tipo_mantenimiento PRIMARY KEY (id_tipo_mantenimiento);


  --
  -- TOC entry 2224 (class 2606 OID 16989)
  -- Name: tipo_parte pk_tipo_parte; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY tipo_parte
      ADD CONSTRAINT pk_tipo_parte PRIMARY KEY (id_tipo_parte);


  --
  -- TOC entry 2212 (class 2606 OID 16926)
  -- Name: tipo_responsable pk_tipo_responsable; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY tipo_responsable
      ADD CONSTRAINT pk_tipo_responsable PRIMARY KEY (id_tipo_responsable);


  --
  -- TOC entry 2190 (class 2606 OID 16814)
  -- Name: unidad pk_unidad; Type: CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY unidad
      ADD CONSTRAINT pk_unidad PRIMARY KEY (id_unidad);


  --
  -- TOC entry 2251 (class 2606 OID 17118)
  -- Name: diagnostico_parte fk_diagnostico_parte_diagnostico; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY diagnostico_parte
      ADD CONSTRAINT fk_diagnostico_parte_diagnostico FOREIGN KEY (id_diagnostico) REFERENCES diagnostico(id_diagnostico) MATCH FULL;


  --
  -- TOC entry 2250 (class 2606 OID 17113)
  -- Name: diagnostico_parte fk_diagnostico_parte_parte; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY diagnostico_parte
      ADD CONSTRAINT fk_diagnostico_parte_parte FOREIGN KEY (id_parte) REFERENCES parte(id_parte) MATCH FULL;


  --
  -- TOC entry 2240 (class 2606 OID 17063)
  -- Name: equipo_detalle fk_equipo_detalle_equipo; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY equipo_detalle
      ADD CONSTRAINT fk_equipo_detalle_equipo FOREIGN KEY (id_equipo) REFERENCES equipo(id_quipo) MATCH FULL;


  --
  -- TOC entry 2242 (class 2606 OID 17073)
  -- Name: equipo_detalle fk_equipo_detalle_marca; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY equipo_detalle
      ADD CONSTRAINT fk_equipo_detalle_marca FOREIGN KEY (id_marca) REFERENCES marca(id_marca) MATCH FULL;


  --
  -- TOC entry 2241 (class 2606 OID 17068)
  -- Name: equipo_detalle fk_equipo_detalle_modelo; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY equipo_detalle
      ADD CONSTRAINT fk_equipo_detalle_modelo FOREIGN KEY (id_modelo) REFERENCES modelo(id_modelo) MATCH FULL;


  --
  -- TOC entry 2245 (class 2606 OID 17088)
  -- Name: estado_mantenimiento_detalle fk_estado_mantenimiento_detalle_estado; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY estado_mantenimiento_detalle
      ADD CONSTRAINT fk_estado_mantenimiento_detalle_estado FOREIGN KEY (id_estado) REFERENCES estado(id_estado) MATCH FULL;


  --
  -- TOC entry 2244 (class 2606 OID 17083)
  -- Name: estado_mantenimiento_detalle fk_estado_mantenimiento_detalle_mantenimiento_detalle; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY estado_mantenimiento_detalle
      ADD CONSTRAINT fk_estado_mantenimiento_detalle_mantenimiento_detalle FOREIGN KEY (id_mantenimiento_detalle) REFERENCES mantenimiento_detalle(id_mantenimiento_detalle) MATCH FULL;


  --
  -- TOC entry 2246 (class 2606 OID 17093)
  -- Name: estado_mantenimiento_detalle fk_estado_mantenimiento_detalle_responsable; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY estado_mantenimiento_detalle
      ADD CONSTRAINT fk_estado_mantenimiento_detalle_responsable FOREIGN KEY (id_responsable) REFERENCES responsable(id_responsable) MATCH FULL;


  --
  -- TOC entry 2239 (class 2606 OID 17058)
  -- Name: mantenimiento_detalle fk_mantenimiento_detalle_orden_trabajo; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY mantenimiento_detalle
      ADD CONSTRAINT fk_mantenimiento_detalle_orden_trabajo FOREIGN KEY (id_oden_trabajo) REFERENCES orden_trabajo(id_orden_trabajo) MATCH FULL;


  --
  -- TOC entry 2252 (class 2606 OID 17123)
  -- Name: orden_trabajo_calendario fk_orden_trabajo_calendario_calendario; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY orden_trabajo_calendario
      ADD CONSTRAINT fk_orden_trabajo_calendario_calendario FOREIGN KEY (id_fecha) REFERENCES calendario(id_fecha) MATCH FULL;


  --
  -- TOC entry 2253 (class 2606 OID 17128)
  -- Name: orden_trabajo_calendario fk_orden_trabajo_calendario_orden_trabajo; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY orden_trabajo_calendario
      ADD CONSTRAINT fk_orden_trabajo_calendario_orden_trabajo FOREIGN KEY (id_orden_trabajo) REFERENCES orden_trabajo(id_orden_trabajo) MATCH FULL;


  --
  -- TOC entry 2238 (class 2606 OID 17053)
  -- Name: orden_trabajo fk_orden_trabajo_equipo; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY orden_trabajo
      ADD CONSTRAINT fk_orden_trabajo_equipo FOREIGN KEY (id_equipo) REFERENCES equipo(id_quipo) MATCH FULL;


  --
  -- TOC entry 2237 (class 2606 OID 17048)
  -- Name: orden_trabajo fk_orden_trabajo_prioridad; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY orden_trabajo
      ADD CONSTRAINT fk_orden_trabajo_prioridad FOREIGN KEY (id_prioridad) REFERENCES prioridad(id_prioridad) MATCH FULL;


  --
  -- TOC entry 2236 (class 2606 OID 17043)
  -- Name: orden_trabajo fk_orden_trabajo_solicitud; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY orden_trabajo
      ADD CONSTRAINT fk_orden_trabajo_solicitud FOREIGN KEY (id_solicitud) REFERENCES solicitud(id_solicitud) MATCH FULL;


  --
  -- TOC entry 2234 (class 2606 OID 17033)
  -- Name: orden_trabajo fk_orden_trabajo_tipo_mantenimiento; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY orden_trabajo
      ADD CONSTRAINT fk_orden_trabajo_tipo_mantenimiento FOREIGN KEY (id_tipo_mantenimiento) REFERENCES tipo_mantenimiento(id_tipo_mantenimiento) MATCH FULL;


  --
  -- TOC entry 2235 (class 2606 OID 17038)
  -- Name: orden_trabajo fk_orden_trabajo_unidad; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY orden_trabajo
      ADD CONSTRAINT fk_orden_trabajo_unidad FOREIGN KEY (id_unidad) REFERENCES unidad(id_unidad) MATCH FULL;


  --
  -- TOC entry 2249 (class 2606 OID 17108)
  -- Name: parte fk_parte_tipo_parte; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY parte
      ADD CONSTRAINT fk_parte_tipo_parte FOREIGN KEY (id_tipo_parte) REFERENCES tipo_parte(id_tipo_parte) MATCH FULL;


  --
  -- TOC entry 2248 (class 2606 OID 17103)
  -- Name: paso fk_paso_procedimiento; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY paso
      ADD CONSTRAINT fk_paso_procedimiento FOREIGN KEY (id_procedimiento) REFERENCES procedimiento(id_procedimiento) MATCH FULL;


  --
  -- TOC entry 2247 (class 2606 OID 17098)
  -- Name: procedimiento fk_procedimiento_diagnostico; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY procedimiento
      ADD CONSTRAINT fk_procedimiento_diagnostico FOREIGN KEY (id_diagnostico) REFERENCES diagnostico(id_diagnostico) MATCH FULL;


  --
  -- TOC entry 2243 (class 2606 OID 17078)
  -- Name: responsable fk_responsable_tipo_responsable; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY responsable
      ADD CONSTRAINT fk_responsable_tipo_responsable FOREIGN KEY (id_tipo_responsable) REFERENCES tipo_responsable(id_tipo_responsable) MATCH FULL;


  --
  -- TOC entry 2233 (class 2606 OID 17028)
  -- Name: tipo_mantenimiento fk_tipo_mantenimiento_sub_tipo_mantenimiento; Type: FK CONSTRAINT; Schema: public; Owner: mortal2018
  --

  ALTER TABLE ONLY tipo_mantenimiento
      ADD CONSTRAINT fk_tipo_mantenimiento_sub_tipo_mantenimiento FOREIGN KEY (id_sub_tipo_mantenimiento) REFERENCES sub_tipo_mantenimiento(id_sub_tipo_mantenimiento) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


  -- Completed on 2018-03-28 23:50:07 CST

  --
  -- PostgreSQL database dump complete
  --

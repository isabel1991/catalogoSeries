/* 
- Paquete de fuentes que almacenará los archivos SQL
 */
/**
 * Author:  cadit
 * Created: 13 abr. 2020
 */
DROP TABLE SERIE; /* IMPORTANTE: Debemos borrar primero la tabla principal debido a las PK*/
DROP TABLE GENERO;
DROP TABLE NACIONALIDAD;
DROP TABLE IDIOMA;
CREATE TABLE GENERO (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    CODIGO CHAR(2),
    NOMBRE VARCHAR(20) NOT NULL,
    CONSTRAINT ID_GENERO_PK PRIMARY KEY (ID)
);

CREATE TABLE NACIONALIDAD (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    PAIS VARCHAR(20) NOT NULL,
    CONSTRAINT ID_NACIONALIDAD_PK PRIMARY KEY (ID)
);

CREATE TABLE IDIOMA (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    CODIGO CHAR(3),
    NOMBRE VARCHAR(20) NOT NULL,
    CONSTRAINT ID_IDIOMA_PK PRIMARY KEY (ID)
);
CREATE TABLE SERIE (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, -- Id autonumérico
    TÍTULO VARCHAR(20) NOT NULL,
    GENERO INTEGER NOT NULL,
    PAIS INTEGER NOT NULL,
    IDIOMA INTEGER NOT NULL,
    FECHA_ESTRENO DATE,
    CAPITULOS INTEGER,
    PRECIO DECIMAL(7,2),
    VALORACION BOOLEAN,
    VISIONADA BOOLEAN,
    FOTO VARCHAR(30),
    CONSTRAINT ID_SERIE_PK PRIMARY KEY (ID),
    CONSTRAINT PROV_SERIE_FK FOREIGN KEY (GENERO) REFERENCES GENERO (ID),
    CONSTRAINT NAC_SERIE_FK FOREIGN KEY (PAIS) REFERENCES NACIONALIDAD(ID),
    CONSTRAINT IDIOM_SERIE_FK FOREIGN KEY (IDIOMA) REFERENCES IDIOMA (ID)
);
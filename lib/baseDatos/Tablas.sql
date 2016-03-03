CREATE DATABASE autoservicio;

\connect autoservicio

CREATE TABLE venta(
id_venta INTEGER NOT NULL PRIMARY KEY,
fecha_venta DATE NOT NULL,
total_venta DOUBLE PRECISION CHECK (total_venta >= 0)
);

CREATE TABLE capturista(
id_capturista INTEGER NOT NULL PRIMARY KEY,
nombre_capturista VARCHAR(200) NOT NULL,
apellido_paterno_capturista VARCHAR(200) NOT NULL,
apellido_materno_capturista VARCHAR(200)
);

CREATE TABLE venta_capturista(
id_venta INTEGER NOT NULL PRIMARY KEY,
id_capturista INTEGER NOT NULL,
FOREIGN KEY (id_venta) REFERENCES venta(id_venta),
FOREIGN KEY (id_capturista) REFERENCES capturista(id_capturista)
);

/*

drop table if exists TRABAJADOR;

CREATE TABLE TRABAJADOR (
    cod int(3) Primary key,
    dni varchar(9),
    nombre varchar(20),
    apellido varchar(40)
);


CREATE TABLE cliente (
    nCliente int(4) Primary key,
    DNIC varchar(9),
    nombreC varchar(20),
    apellidoC varchar(40),
    cod int(3),
    FOREIGN KEY (cod) REFERENCES trabajador(cod)
);

CREATE TABLE servicio (
    codServicio int(4) Primary key,
    tipopServicio varchar(80),
    codCliente int(4),
    FOREIGN KEY (codCliente) REFERENCES cliente(nCliente)
);
*/
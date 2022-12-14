CREATE TABLE USUARIO(
    nombre varchar(50),
    email varchar(50),
    pswd varchar(50),
    admin int,
    Fondo int,
    ladrillo int,
    PRIMARY KEY(nombre)
);
CREATE TABLE RANKING(
    dificultad varchar(50),
    PRIMARY KEY(Dificultad)
);
CREATE TABLE INFO_RANKING(
    nombre varchar(50),
    puntuacion int,
    dificultad varchar(50),
    FOREIGN KEY(nombre)
    REFERENCES USUARIO(nombre)
    ON DELETE CASCADE,
    FOREIGN KEY(dificultad)
    REFERENCES RANKING(Dificultad)
    ON DELETE CASCADE
);
INSERT INTO USUARIO VALUES('admin','admin@admin.com','admin',1,1,1);
INSERT INTO RANKING VALUES('Fácil');
INSERT INTO RANKING VALUES('Medio');
INSERT INTO RANKING VALUES('Difícil');

    
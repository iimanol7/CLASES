CREATE DATABASE examen3BD DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;

-- Creación de la tabla Equipos
CREATE TABLE examen3BD.Equipos (
    idEquipo INT primary key,
    nombre VARCHAR(100),
		fundacion INT,
    presupuesto DOUBLE
);

-- Creación de la tabla Jugador
CREATE TABLE examen3BD.Jugadores (
    idJugador VARCHAR(10) primary key,
    nombre VARCHAR(100),
    apellidos VARCHAR(100),
    dorsal INT,
    sueldo DOUBLE,
    idEquipo INT
);

-- INSERTs adicionales para la tabla Equipos
INSERT INTO examen3BD.Equipos VALUES
(1, 'Txapelbeltzak Sport Club', 1998, 6000000.0),
(2, 'Sorginak United', 1940, 7000000.0),
(3, 'Euria Kirol Elkartea', 2005, 4000000.0),
(4, 'Udaberri Azidoa Kluba', 2010, 5500000.0);

-- INSERTs adicionales para la tabla Jugadores
INSERT INTO examen3BD.Jugadores VALUES
('01', 'Aitor', 'Aramburu', 6, 550000, 1),
('02', 'Maialen', 'Etxeberria', 10, 380000, 1),
('03', 'Gorka', 'Zabala', 4, 250000, 1),
('04', 'Leire', 'Goikoetxea', 7, 480000, 2),
('05', 'Mikel', 'Zubizarreta', 9, 320000, 2),
('06', 'Maider', 'Agirre', 10, 320000, 2),
('07', 'Ane', 'Ugarte', 7, 450000, 3),
('08', 'Irati', 'Itsasartu', 9, 380000, 3),
('09', 'Leire', 'Larrañaga', 6, 400000, 3),
('10', 'Maite', 'Ibarra', 11, 420000, 4),
('11', 'Unai', 'Azkarraga', 5, 300000, 4),
('12', 'Nerea', 'Mendizabal', 8, 370000, 4),
('13', 'Jon', 'Ormaetxea', 4, 450000, 1),
('14', 'Izaro', 'Otxoa', 7, 420000, 2),
('15', 'Aratz', 'Zabarte', 7, 420000, 3),
('16', 'Eneko', 'Agirrebeitia', 9, 380000, 4);
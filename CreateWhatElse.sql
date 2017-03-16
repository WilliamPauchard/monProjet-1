-- Script de création pour MySQL de la base WhatElse
--
-- Peter DAEHNE - 04.03.2017
-- Encodage UTF-8

--
-- Base de données: WhatElse
--
DROP DATABASE IF EXISTS WhatElse;
CREATE DATABASE WhatElse;
USE WhatElse;

--
-- Table TypeCafe
--
CREATE TABLE IF NOT EXISTS TypeCafe (
  Id INT NOT NULL AUTO_INCREMENT,
  Nom VARCHAR(30) NOT NULL,
  PRIMARY KEY (Id)
);

INSERT INTO TypeCafe (Id, Nom) VALUES
(1, 'Intenso'),
(2, 'Espresso'),
(3, 'Pure origin'),
(4, 'Lungo'),
(5, 'Decaffeinato'),
(6, 'Variations');

--
-- Table Capsule
--
CREATE TABLE IF NOT EXISTS Capsule (
  Id INT NOT NULL AUTO_INCREMENT,
  Nom VARCHAR(30) NOT NULL,
  Prix DOUBLE NOT NULL,
  Intensite INT NOT NULL,
  Tasse INT NOT NULL,
  IdTypeCafe INT NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (IdTypeCafe) REFERENCES TypeCafe (Id)
);

INSERT INTO Capsule (Id, Nom, Prix, Intensite, Tasse, IdTypeCafe) VALUES
(1, 'Kazaar', 0.57, 12, 25, 1),
(2, 'Dharkan', 0.57, 11, 25, 1),
(3, 'Ristretto', 0.5, 10, 25, 1),
(4, 'Arpegio', 0.5, 9, 25, 1),
(5, 'Roma', 0.5, 8, 25, 1),
(6, 'Livanto', 0.5, 6, 40, 2),
(7, 'Capriccio', 0.5, 5, 40, 2),
(8, 'Volluto', 0.5, 4, 40, 2),
(9, 'Cosi', 0.5, 4, 40, 2),
(10, 'Indriya', 0.57, 10, 25, 3),
(11, 'Rosabaya', 0.57, 6, 40, 3),
(12, 'Dulsão', 0.57, 4, 40, 3),
(13, 'Bukeela Ka', 0.57, 3, 110, 3),
(14, 'Fortissio', 0.52, 8, 110, 4),
(15, 'Vivalto', 0.52, 4, 110, 4),
(16, 'Linizio', 0.52, 4, 110, 4),
(17, 'Arpeggio Dec.', 0.52, 9, 25, 5),
(18, 'Volluto Dec.', 0.52, 4, 40, 5),
(19, 'Vivalto Dec.', 0.54, 4, 110, 5),
(20, 'Intenso Dec.', 0.5, 7, 40, 5),
(21, 'Carmelito', 0.57, 6, 40, 6),
(22, 'Ciocattino', 0.57, 6, 40, 6),
(23, 'Vanilio', 0.57, 6, 40, 6);

--
-- Table Employe
--
CREATE TABLE IF NOT EXISTS Employe (
  Id INT NOT NULL AUTO_INCREMENT,
  Nom VARCHAR(50) NOT NULL,
  Prenom VARCHAR(50) NOT NULL,
  PRIMARY KEY (Id)
);

INSERT INTO Employe (Id, Nom, Prenom) VALUES
(1, 'Dupont', 'Sam'),
(2, 'Santschi', 'Naomi'),
(3, 'Mechi', 'Cyril'),
(4, 'Godel', 'Emilie'),
(5, 'Schaffter', 'Cédric'),
(6, 'Simeon', 'Thibault'),
(7, 'Amruthalingam', 'Cécilia'),
(8, 'Vasquez', 'Marie'),
(9, 'Gillard', 'Martin'),
(10, 'Uzan', 'Matteo'),
(11, 'Borgeaud', 'Nathan'),
(12, 'Antenen', 'Sébastien'),
(13, 'Uhde', 'Sarah'),
(14, 'Lueber', 'Nelson'),
(15, 'Fleury', 'Keziah'),
(16, 'Kreis', 'Tanguy'),
(17, 'Weyrich', 'Flavien'),
(18, 'Pinto', 'Camille'),
(19, 'Ding', 'Sylvain'),
(20, 'Kistler', 'Laura');

--
-- Table Commande
--
CREATE TABLE IF NOT EXISTS Commande (
  Id INT NOT NULL AUTO_INCREMENT,
  IdEmploye INT NOT NULL,
  IdCapsule INT NOT NULL,
  Nombre INT NOT NULL,
  Date DATE NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (IdEmploye) REFERENCES Employe (Id),
  FOREIGN KEY (IdCapsule) REFERENCES Capsule (Id)
);

INSERT INTO Commande (Id, IdEmploye, IdCapsule, Nombre, Date) VALUES
(1, 19, 3, 3, '2017-03-05'),
(2, 19, 9, 9, '2017-03-05'),
(3, 12, 1, 1, '2017-03-05'),
(4, 19, 5, 5, '2017-03-05'),
(5, 19, 8, 8, '2017-03-05'),
(6, 19, 4, 4, '2017-03-05'),
(7, 11, 11, 21, '2017-03-05'),
(8, 19, 2, 2, '2017-03-05'),
(9, 7, 7, 10, '2017-03-05'),
(10, 1, 3, 10, '2017-03-05'),
(11, 1, 5, 20, '2017-03-05'),
(12, 19, 6, 6, '2017-03-05'),
(13, 19, 1, 1, '2017-03-05'),
(14, 11, 8, 13, '2017-03-05'),
(15, 19, 7, 7, '2017-03-05'),
(16, 1, 5, 15, '2017-03-05'),
(17, 7, 14, 10, '2017-03-05'),
(18, 7, 17, 10, '2017-03-05'),
(19, 11, 5, 15, '2017-03-05'),
(20, 11, 3, 10, '2017-03-05'),
(21, 11, 6, 12, '2017-03-05'),
(22, 11, 15, 11, '2017-03-06'),
(23, 1, 3, 12, '2017-03-06'),
(24, 11, 8, 12, '2017-03-06'),
(25, 1, 23, 8, '2017-03-06'),
(26, 11, 7, 17, '2017-03-06'),
(27, 11, 6, 7, '2017-03-06'),
(28, 1, 5, 5, '2017-03-06'),
(29, 11, 4, 33, '2017-03-06'),
(30, 7, 7, 5, '2017-03-06');

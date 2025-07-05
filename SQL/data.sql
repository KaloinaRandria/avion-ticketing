-- MODELES D'AVIONS
INSERT INTO modele (libelle) VALUES
('Boeing 737'),
('Airbus A320'),
('Embraer E190');

-- TYPES DE SIEGES
INSERT INTO type_siege (libelle) VALUES
('Economique'),
('Affaires'),
('Premiere Classe');

-- VILLES
INSERT INTO ville (nom) VALUES
('Antananarivo'),
('Paris'),
('Johannesburg'),
('Nairobi'),
('Bangkok');

-- AVIONS
INSERT INTO avion (libelle, date_fabrication, id_modele) VALUES
('Avion Boeing TNR', '2015-06-01', 1),
('Avion Airbus Paris', '2018-09-15', 2),
('Avion Embraer Nairobi', '2020-01-10', 3);

-- SIEGE_MODELE
-- Boeing 737: 120 sieges economiques, 20 affaires
INSERT INTO siege_modele (nb_siege, id_modele, id_type_siege) VALUES
(120, 1, 1),
(20, 1, 2);

-- Airbus A320: 140 sieges economiques, 10 premiere
INSERT INTO siege_modele (nb_siege, id_modele, id_type_siege) VALUES
(140, 2, 1),
(10, 2, 3);

-- Embraer E190: 88 economiques, 12 affaires
INSERT INTO siege_modele (nb_siege, id_modele, id_type_siege) VALUES
(88, 3, 1),
(12, 3, 2);

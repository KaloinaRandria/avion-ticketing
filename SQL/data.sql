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


-- VOL(id, avion_id, ville_depart_id, ville_arrivee_id, date_depart, date_arrivee)
-- Format: 'YYYY-MM-DD HH:MM:SS'

INSERT INTO vol (id, avion_id, ville_depart_id, ville_arrivee_id, date_depart, date_arrivee) VALUES
                                                                                                 (1, 1, 1, 2, '2025-07-10 08:00:00', '2025-07-10 15:30:00'),  -- Tana -> Paris
                                                                                                 (2, 2, 2, 1, '2025-07-11 10:00:00', '2025-07-11 17:45:00'),  -- Paris -> Tana
                                                                                                 (3, 3, 4, 5, '2025-07-12 06:15:00', '2025-07-12 12:45:00'),  -- Nairobi -> Bangkok
                                                                                                 (4, 1, 1, 3, '2025-07-13 07:00:00', '2025-07-13 12:30:00'),  -- Tana -> Johannesburg
                                                                                                 (5, 2, 3, 1, '2025-07-14 13:00:00', '2025-07-14 18:45:00'),  -- Johannesburg -> Tana
                                                                                                 (6, 3, 5, 4, '2025-07-15 09:30:00', '2025-07-15 16:00:00');  -- Bangkok -> Nairobi

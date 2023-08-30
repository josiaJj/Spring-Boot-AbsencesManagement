INSERT INTO subjects 
VALUES 
    ('WEB1', 'Developpement Web'), 
    ('PROG1', 'Programmation de base'), 
    ('THEORIE1', 'Cours Théoriques'),
    ('MGT1', 'Ouils de travail collaboratif'),
    ('PROG3', 'Programmation S3'),
    ('PROJET1', 'Projet S3');

INSERT INTO courses 
VALUES 
    (DEFAULT, '2023-08-01', 'WEB1'),
    (DEFAULT, '2023-08-01', 'MGT1'),
    (DEFAULT, '2023-08-01', 'PROG1'), 
    (DEFAULT, '2023-08-02', 'PROG3'), 
    (DEFAULT, '2023-08-02', 'WEB1'),
    (DEFAULT, '2023-08-02', 'PROG1'),
    (DEFAULT, '2023-08-03', 'THEORIE1'), 
    (DEFAULT, '2023-08-03', 'WEB1'),
    (DEFAULT, '2023-08-03', 'THEORIE1'),
    (DEFAULT, '2023-08-04', 'PROG3'),
    (DEFAULT, '2023-08-04', 'MGT1'), 
    (DEFAULT, '2023-08-04', 'THEORIE1'),
    (DEFAULT, '2023-08-05', 'THEORIE1'), 
    (DEFAULT, '2023-08-05', 'THEORIE1'), 
    (DEFAULT, '2023-08-05', 'PROG1'),
    (DEFAULT, '2023-08-06', 'PROJET1'), 
    (DEFAULT, '2023-08-06', 'PROJET1'), 
    (DEFAULT, '2023-08-06', 'MGT1');

INSERT INTO "group"(code_group) 
VALUES ('G1'), ('G2'), ('H1'), ('H2'), ('H3');

INSERT INTO students 
VALUES 
    ('STD21001', 'RAKOTO', 'Tiana', 'hei.tiana@gmail.com', 1),
    ('STD21002', 'RASATA', 'Niaina', 'hei.niaina@gmail.com', 1),
    ('STD21003', 'RAJERY', 'Haja', 'hei.haja@gmail.com', 1),

    ('STD21031', 'ILAINA', 'Foana', 'hei.foana@gmail.com', 2),
    ('STD21032', 'RAKOTOBE', 'Augustin', 'hei.augustin@gmail.com', 2),
    ('STD21033', 'ZIONA', 'Vaovao', 'heivaovao.@gmail.com', 2),

    ('STD22005', 'ANDRIAMIHAJA', 'Nathanael', 'hei.nathanael@gmail.com', 3),
    ('STD22007', 'ANDRIANAIVO', 'Haingo', 'hei.haingo@gmail.com', 3),
    ('STD22014', 'MIORA NOMENJANAHARY', 'Rivo', 'hei.rivo@gmail.com', 3),
    ('STD22028', 'RATOETRARIVO', 'Andy', 'hei.andy@gmail.com', 3),
    ('STD22020', 'RANAIVOSOA', 'Nantenaina', 'hei.nantenaina@gmail.com', 3),
    ('STD22025', 'RASOANAIVO', 'Rotsy', 'hei.rotsy@gmail.com', 3),
    ('STD22026', 'RASOANIRINA', 'Mialisoa', 'hei.mialisoa@gmail.com', 3),

    ('STD22037', 'RAFALIARISON', 'Riantsoa', 'hei.riantsoa@gmail.com', 4),
    ('STD22044', 'RAKOTO HARISATA', 'Andrinirina', 'hei.andrinirina@gmail.com', 4),
    ('STD22056', 'RANDRIANARIJAONA', 'Manoa', 'hei.manoa@gmail.com', 4),
    ('STD22057', 'RANDRIANARIVELO', 'Faniry', 'hei.faniry@gmail.com', 4),
    ('STD22058', 'RAVOHARY', 'Asaramanitra', 'hei.asaramanitra@gmail.com', 4),
    ('STD22006', 'ANDRIAMPARANTINA', 'Fanambinantsoa', 'hei.fanambinantsoa@gmail.com', 4),
    ('STD22038', 'RAFANOMEZANTSOA', 'Dera', 'hei.dera@gmail.com', 4),

    ('STD22064', 'ANDRIAMAHERILALA', 'josia', 'hei.josia@gmail.com', 5),
    ('STD22069', 'ANDRIANJAZA', 'Sanda', 'hei.sanda@gmail.com', 5),
    ('STD22091', 'ROBINARY', 'Tsinjo', 'hei.tsinjo@gmail.com', 5),
    ('STD22092', 'TSANTANIAINA', 'Sarobidy', 'hei.sarobidy@gmail.com', 5),
    ('STD22066', 'ANDRIANARILANTO', 'Patricia', 'hei.patricia@gmail.com', 5),
    ('STD22067', 'ANDRIANARY', ' Gracia', 'hei.gracia@gmail.com', 5),
    ('STD22086', 'RAVOAJANAHARY', 'Fiantso', 'hei.fiantso@gmail.com', 5);
    

INSERT INTO present (isPresent, jusifiy, id_course, std) 
VALUES 
    (DEFAULT, DEFAULT, 1, 'STD22005'),
    (DEFAULT, DEFAULT, 1, 'STD22007'),
    (DEFAULT, DEFAULT, 1, 'STD22014'),
    (DEFAULT, DEFAULT, 1, 'STD22028'),
    (DEFAULT, DEFAULT, 1, 'STD22020'),
    (false, true, 1, 'STD22025'),
    (DEFAULT, DEFAULT, 1, 'STD22026'),
    
    (DEFAULT, DEFAULT, 2, 'STD22037'),
    (DEFAULT, DEFAULT, 2, 'STD22044'),
    (DEFAULT, DEFAULT, 2, 'STD22056'),
    (DEFAULT, DEFAULT, 2, 'STD22057'),
    (false, false, 2, 'STD22058'),
    (false, true, 2, 'STD22006'),
    (FALSE, FALSE, 2, 'STD22038'),
    
    (FALSE, TRUE, 3, 'STD22064'),
    (FALSE, FALSE, 3, 'STD22069'),
    (FALSE, TRUE, 3, 'STD22091'),
    (DEFAULT, DEFAULT, 3, 'STD22092'),
    (DEFAULT, DEFAULT, 3, 'STD22066'),
    (DEFAULT, DEFAULT, 3, 'STD22067'),
    (DEFAULT, DEFAULT, 3, 'STD22086'),

    (DEFAULT, DEFAULT, 4, 'STD21001'),
    (DEFAULT, DEFAULT, 4, 'STD21002'),
    (DEFAULT, DEFAULT, 4, 'STD21003'),

    (DEFAULT, DEFAULT, 5, 'STD22005'),
    (DEFAULT, DEFAULT, 5, 'STD22007'),
    (FALSE, TRUE, 5, 'STD22014'),
    (DEFAULT, DEFAULT, 5, 'STD22028'),
    (DEFAULT, DEFAULT, 5, 'STD22020'),
    (DEFAULT, DEFAULT, 5, 'STD22025'),
    (DEFAULT, DEFAULT, 5, 'STD22026'),

    (DEFAULT, DEFAULT, 6, 'STD22037'),
    (DEFAULT, DEFAULT, 6, 'STD22044'),
    (DEFAULT, DEFAULT, 6, 'STD22056'),
    (DEFAULT, DEFAULT, 6, 'STD22057'),
    (DEFAULT, DEFAULT, 6, 'STD22058'),
    (false, true, 6, 'STD22006'),
    (FALSE, TRUE, 6, 'STD22038'),

    (DEFAULT, DEFAULT, 16, 'STD21031'),
    (DEFAULT, DEFAULT, 16, 'STD21032'),
    (DEFAULT, DEFAULT, 16, 'STD21033'),

    (DEFAULT, DEFAULT, 17, 'STD21001'),
    (FALSE, FALSE, 17, 'STD21002'),
    (DEFAULT, DEFAULT, 17, 'STD21003');
CREATE TABLE mygarage.models
(
    modelId int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    makeId int(11) NOT NULL,
    modelName varchar(45) NOT NULL,
    CONSTRAINT fk_models_makes FOREIGN KEY (makeId) REFERENCES makes (makeId)
);
CREATE INDEX fk_models_makes_idx ON mygarage.models (makeId);
INSERT INTO mygarage.models (makeId, modelName) VALUES (1, 'A4');
INSERT INTO mygarage.models (makeId, modelName) VALUES (1, 'A6');
INSERT INTO mygarage.models (makeId, modelName) VALUES (1, 'A7');
INSERT INTO mygarage.models (makeId, modelName) VALUES (1, 'Q7');
INSERT INTO mygarage.models (makeId, modelName) VALUES (1, 'TT');
INSERT INTO mygarage.models (makeId, modelName) VALUES (2, 'Escort');
INSERT INTO mygarage.models (makeId, modelName) VALUES (2, 'Fiesta');
INSERT INTO mygarage.models (makeId, modelName) VALUES (2, 'Focus');
INSERT INTO mygarage.models (makeId, modelName) VALUES (2, 'GT');
INSERT INTO mygarage.models (makeId, modelName) VALUES (2, 'Mustang');
INSERT INTO mygarage.models (makeId, modelName) VALUES (3, '3');
INSERT INTO mygarage.models (makeId, modelName) VALUES (3, '6');
INSERT INTO mygarage.models (makeId, modelName) VALUES (3, 'CX-5');
INSERT INTO mygarage.models (makeId, modelName) VALUES (4, 'Patrol');
INSERT INTO mygarage.models (makeId, modelName) VALUES (4, 'Skyline');
INSERT INTO mygarage.models (makeId, modelName) VALUES (4, 'Qashqai');
INSERT INTO mygarage.models (makeId, modelName) VALUES (4, 'Micra');
INSERT INTO mygarage.models (makeId, modelName) VALUES (4, 'Leaf');
INSERT INTO mygarage.models (makeId, modelName) VALUES (5, 'Astra');
INSERT INTO mygarage.models (makeId, modelName) VALUES (5, 'Frontera');
INSERT INTO mygarage.models (makeId, modelName) VALUES (5, 'Mokka');
INSERT INTO mygarage.models (makeId, modelName) VALUES (5, 'Corsa');
INSERT INTO mygarage.models (makeId, modelName) VALUES (6, 'Boxer');
INSERT INTO mygarage.models (makeId, modelName) VALUES (6, '807');
INSERT INTO mygarage.models (makeId, modelName) VALUES (6, '407');
INSERT INTO mygarage.models (makeId, modelName) VALUES (7, 'Logan');
INSERT INTO mygarage.models (makeId, modelName) VALUES (7, 'Megane');
INSERT INTO mygarage.models (makeId, modelName) VALUES (7, 'Master');
INSERT INTO mygarage.models (makeId, modelName) VALUES (7, 'Captur');
INSERT INTO mygarage.models (makeId, modelName) VALUES (7, 'Clio');
INSERT INTO mygarage.models (makeId, modelName) VALUES (8, 'Model S');
INSERT INTO mygarage.models (makeId, modelName) VALUES (8, 'Model X');
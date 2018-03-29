CREATE TABLE mygarage.fueltypes
(
    fuelTypeId int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fuelTypeName varchar(255) NOT NULL
);
INSERT INTO mygarage.fueltypes (fuelTypeName) VALUES ('petro');
INSERT INTO mygarage.fueltypes (fuelTypeName) VALUES ('petrol/electric hybrid');
INSERT INTO mygarage.fueltypes (fuelTypeName) VALUES ('diesel');
INSERT INTO mygarage.fueltypes (fuelTypeName) VALUES ('diesel/electric hybrid');
INSERT INTO mygarage.fueltypes (fuelTypeName) VALUES ('electric');
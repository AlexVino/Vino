CREATE TABLE mygarage.transmissions
(
    transmissionId int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    transmissionName varchar(255) NOT NULL
);
INSERT INTO mygarage.transmissions (transmissionName) VALUES ('Automatic');
INSERT INTO mygarage.transmissions (transmissionName) VALUES ('Manual');
INSERT INTO mygarage.transmissions (transmissionName) VALUES ('Semi Automatic');
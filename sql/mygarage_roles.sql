CREATE TABLE mygarage.roles
(
    roleId int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    roleName varchar(255) NOT NULL
);
INSERT INTO mygarage.roles (roleName) VALUES ('ROLE_ADMIN');
INSERT INTO mygarage.roles (roleName) VALUES ('ROLE_USER');
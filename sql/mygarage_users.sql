CREATE TABLE mygarage.users
(
    userId int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    firstname varchar(255) NOT NULL,
    lastname varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    phone varchar(255) NOT NULL,
    username varchar(255) NOT NULL,
    roleId int(11) NOT NULL,
    CONSTRAINT fk_users_roles FOREIGN KEY (roleId) REFERENCES roles (roleId)
);
CREATE INDEX fk_users_roles_idx ON mygarage.users (roleId);
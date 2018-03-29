CREATE TABLE mygarage.orders
(
    orderId int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    status varchar(255) NOT NULL,
    carId int(11) NOT NULL,
    userId int(11) NOT NULL,
    CONSTRAINT fk_orders_cars FOREIGN KEY (carId) REFERENCES cars (carId),
    CONSTRAINT fk_orders_users FOREIGN KEY (userId) REFERENCES users (userId)
);
CREATE INDEX fk_orders_cars_idx ON mygarage.orders (carId);
CREATE INDEX fk_orders_users_idx ON mygarage.orders (userId);
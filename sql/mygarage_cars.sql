CREATE TABLE mygarage.cars
(
    carId int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    mileage int(11) NOT NULL,
    price int(11) NOT NULL,
    year int(11) NOT NULL,
    bodystyleId int(11) NOT NULL,
    colorId int(11) NOT NULL,
    fuelTypeId int(11) NOT NULL,
    modelId int(11) NOT NULL,
    transmissionId int(11) NOT NULL,
    CONSTRAINT fk_cars_bodystyles FOREIGN KEY (bodystyleId) REFERENCES bodystyles (bodystyleId),
    CONSTRAINT fk_cars_colors FOREIGN KEY (colorId) REFERENCES colors (colorId),
    CONSTRAINT fk_cars_fueltypes FOREIGN KEY (fuelTypeId) REFERENCES fueltypes (fuelTypeId),
    CONSTRAINT fk_cars_models FOREIGN KEY (modelId) REFERENCES models (modelId),
    CONSTRAINT fk_cars_transmissions FOREIGN KEY (transmissionId) REFERENCES transmissions (transmissionId)
);
CREATE INDEX fk_cars_bodystyles_idx ON mygarage.cars (bodystyleId);
CREATE INDEX fk_cars_colors_idx ON mygarage.cars (colorId);
CREATE INDEX fk_cars_fueltypes_idx ON mygarage.cars (fuelTypeId);
CREATE INDEX fk_cars_models_idx ON mygarage.cars (modelId);
CREATE INDEX fk_cars_transmissions_idx ON mygarage.cars (transmissionId);
package by.vino.mygarage.dao.api;

import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.rest.dto.SearchCarDto;

import java.util.List;

public interface CarDao extends CrudDao<Car> {
    List<Car> getAll();
    List<Car> getAllBySearchDto(SearchCarDto search);
}

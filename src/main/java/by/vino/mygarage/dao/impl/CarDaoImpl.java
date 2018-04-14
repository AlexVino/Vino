package by.vino.mygarage.dao.impl;

import by.vino.mygarage.dao.api.BaseDao;
import by.vino.mygarage.dao.api.CarDao;
import by.vino.mygarage.dao.jpa.*;
import by.vino.mygarage.rest.dto.SearchCarDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CarDaoImpl extends BaseDao<Car> implements CarDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Car get(int id) {
        return entityManager.find(Car.class, id);
    }

    public List<Car> getAll() {
        CriteriaQuery<Car> query = entityManager.getCriteriaBuilder().createQuery(Car.class);
        query.from(Car.class);
        return super.getAll(query);
    }

    @Override
    public List<Car> getAllBySearchDto(SearchCarDto search) {
        CriteriaQuery<Car> query = entityManager.getCriteriaBuilder().createQuery(Car.class);
        Root<Car> car = query.from(Car.class);
        Join<Car, Model> model = car.join(Car_.model);
        Join<Car, Bodystyle> bodystyle = car.join(Car_.bodystyle);
        Join<Car, Transmission> transmission = car.join(Car_.transmission);
        Join<Car, FuelType> fuelType = car.join(Car_.fuelType);
        Join<Car, Color> color = car.join(Car_.color);
        return super.getAll(query.where(
                //entityManager.getCriteriaBuilder().equal(model.get(Model_.modelName), search.getModel()),
                entityManager.getCriteriaBuilder().equal(bodystyle.get(Bodystyle_.bodystyleName), search.getModel())
//                entityManager.getCriteriaBuilder().equal(transmission.get(Transmission_.transmissionName), search.getTransmission()),
//                entityManager.getCriteriaBuilder().equal(fuelType.get(FuelType_.fuelTypeName), search.getFuelType()),
//                entityManager.getCriteriaBuilder().equal(color.get(Color_.colorName), search.getColor()),
//                entityManager.getCriteriaBuilder().le(car.get(Car_.price), search.getMaxPrice()),
//                entityManager.getCriteriaBuilder().ge(car.get(Car_.price), search.getMinPrice()),
//                entityManager.getCriteriaBuilder().le(car.get(Car_.year), search.getYear()),
//                entityManager.getCriteriaBuilder().le(car.get(Car_.price), search.getMileage())
        ));
    }
}

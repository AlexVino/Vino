package by.vino.mygarage.dao.impl;

import by.vino.mygarage.dao.api.BaseDao;
import by.vino.mygarage.dao.jpa.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CarDaoImpl extends BaseDao<Car> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Car get(int id) {
        return entityManager.find(Car.class, id);
    }
}

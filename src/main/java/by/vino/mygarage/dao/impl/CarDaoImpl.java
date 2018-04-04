package by.vino.mygarage.dao.impl;

import by.vino.mygarage.dao.api.BaseDao;
import by.vino.mygarage.dao.api.CarDao;
import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.dao.jpa.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
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
        Root<Car> car = query.from(Car.class);
        return super.getAll(query);
    }
}

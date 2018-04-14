package by.vino.mygarage.dao.api;

import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.dao.jpa.QCar;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends
        CrudRepository<Car, Integer>, QuerydslPredicateExecutor<Car>, QuerydslBinderCustomizer<QCar> {

    @Override
    default void customize(QuerydslBindings bindings, QCar root) {
        //bindings.bind(root.bodystyle).first(((path, value) -> root.bodystyle.eq(path)));
    }
}
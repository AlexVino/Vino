package by.vino.mygarage.dao.api;

import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.dao.jpa.QCar;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(exported = false)
public interface CarRepository extends
        CrudRepository<Car, Integer>, QuerydslPredicateExecutor<Car>, QuerydslBinderCustomizer<QCar> {

    @Override
    default void customize(QuerydslBindings bindings, QCar root) {
        bindings.bind(String.class).first(
                (SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }
}
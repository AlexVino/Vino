package by.vino.mygarage.dao.api;

import by.vino.mygarage.dao.jpa.Car;
import by.vino.mygarage.dao.jpa.QCar;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import javafx.beans.binding.IntegerExpression;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Optional;

@Repository
@RepositoryRestResource(exported = false)
public interface CarRepository extends
        CrudRepository<Car, Integer>, QuerydslPredicateExecutor<Car>, QuerydslBinderCustomizer<QCar> {

    @Override
    default void customize(QuerydslBindings bindings, QCar root) {
        bindings.bind(root.complectation.bodystyle.bodystyleName).all((path, value) -> Optional.of(path.in(value)));
        bindings.bind(root.color.colorName).all((path, value) -> Optional.of(path.in(value)));
        bindings.bind(root.mileage).first(NumberExpression::loe);
        bindings.bind(String.class).first(
                (SingleValueBinding<StringPath, String>) StringExpression::equalsIgnoreCase);
        bindings.bind(root.price).all((path, value) -> {
            Iterator<? extends Integer> iterator = value.iterator();
            return Optional.of(path.between(iterator.next(), iterator.next()));
        });
        bindings.bind(root.complectation.year).all((path, value) -> {
            Iterator<? extends Integer> iterator = value.iterator();
            int year = new GregorianCalendar().get(Calendar.YEAR);
            int delta = iterator.next();
            return Optional.of(path.between(year - delta, year));
        });
    }
}
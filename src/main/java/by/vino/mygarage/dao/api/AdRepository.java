package by.vino.mygarage.dao.api;

import by.vino.mygarage.dao.jpa.Ad;
import by.vino.mygarage.dao.jpa.QAd;
import com.querydsl.core.types.NullExpression;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import javafx.beans.binding.IntegerExpression;
import javafx.beans.binding.NumberExpression;
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
public interface AdRepository  extends
        CrudRepository<Ad, Integer>, QuerydslPredicateExecutor<Ad>, QuerydslBinderCustomizer<QAd> {

    @Override
    default void customize(QuerydslBindings bindings, QAd root) {
        bindings.bind(root.car.complectation.bodystyle.bodystyleName).all((path, value) -> Optional.of(path.in(value)));
        bindings.bind(root.car.color.colorName).all((path, value) -> Optional.of(path.in(value)));
        //bindings.bind(root.mileage).first(NumberExpression::loe);



        bindings.bind(root.dateDelete).all((path, value) -> {
            //Iterator<? extends java.util.Date> iterator = value.iterator();
            //java.util.Date delta = iterator.next();
            return Optional.of(path.isNull());
        });

        bindings.bind(root.car.mileage).all((path, value) -> {
            Iterator<? extends Integer> iterator = value.iterator();
            Integer delta = iterator.next();
            if (delta.equals(100001)){
                return Optional.of(path.goe(delta));
            }else{
                return Optional.of(path.loe(delta));
            }
        });

        bindings.bind(String.class).first(
                (SingleValueBinding<StringPath, String>) StringExpression::equalsIgnoreCase);
        bindings.bind(root.car.price).all((path, value) -> {
            Iterator<? extends Integer> iterator = value.iterator();
            return Optional.of(path.between(iterator.next(), iterator.next()));
        });
        bindings.bind(root.car.complectation.year).all((path, value) -> {
            Iterator<? extends Integer> iterator = value.iterator();
            int year = new GregorianCalendar().get(Calendar.YEAR);
            int delta = iterator.next();
            return Optional.of(path.between(year - delta, year));
        });
    }
}

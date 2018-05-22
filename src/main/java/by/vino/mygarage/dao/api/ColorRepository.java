package by.vino.mygarage.dao.api;

import by.vino.mygarage.dao.jpa.Color;
import by.vino.mygarage.dao.jpa.QColor;
import by.vino.mygarage.dao.jpa.QTransmission;
import by.vino.mygarage.dao.jpa.Transmission;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface ColorRepository extends
        CrudRepository<Color, Integer>, QuerydslPredicateExecutor<Color>, QuerydslBinderCustomizer<QColor> {

    Color findByColorNameIgnoreCase(String color);

    @Override
    default void customize(QuerydslBindings bindings, QColor root) {
        bindings.bind(String.class).first(
                (SingleValueBinding<StringPath, String>) StringExpression::equalsIgnoreCase);
    }
}
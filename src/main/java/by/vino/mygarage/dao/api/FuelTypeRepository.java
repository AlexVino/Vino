package by.vino.mygarage.dao.api;

import by.vino.mygarage.dao.jpa.FuelType;
import by.vino.mygarage.dao.jpa.QFuelType;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface FuelTypeRepository extends
        CrudRepository<FuelType, Integer>, QuerydslPredicateExecutor<FuelType>, QuerydslBinderCustomizer<QFuelType> {

    FuelType findByFuelTypeNameIgnoreCase(String modelName);

    @Override
    default void customize(QuerydslBindings bindings, QFuelType root) {
        bindings.bind(String.class).first(
                (SingleValueBinding<StringPath, String>) StringExpression::equalsIgnoreCase);
    }
}
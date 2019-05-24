package by.vino.mygarage.dao.api;

import by.vino.mygarage.dao.jpa.Drivetype;
import by.vino.mygarage.dao.jpa.QDrivetype;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface DriveTypeRepository extends
        CrudRepository<Drivetype, Integer>, QuerydslPredicateExecutor<Drivetype>, QuerydslBinderCustomizer<QDrivetype> {

    Drivetype findByDrivetypeNameIgnoreCase(String modelName);

    @Override
    default void customize(QuerydslBindings bindings, QDrivetype root) {
        bindings.bind(String.class).first(
                (SingleValueBinding<StringPath, String>) StringExpression::equalsIgnoreCase);
    }
}
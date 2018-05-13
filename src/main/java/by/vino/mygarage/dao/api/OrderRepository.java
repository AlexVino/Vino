package by.vino.mygarage.dao.api;

import by.vino.mygarage.dao.jpa.Order;
import by.vino.mygarage.dao.jpa.QOrder;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(exported = false)
public interface OrderRepository extends
        CrudRepository<Order, Integer>, QuerydslPredicateExecutor<Order>, QuerydslBinderCustomizer<QOrder> {

    Order findByCar_CarIdAndUser_Username(int carId, String username);
    Order findByCar_CarId(int carId);
    List<Order> findAllByUser_Username(String username);

    @Override
    default void customize(QuerydslBindings bindings, QOrder root) {
    }
}
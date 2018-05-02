package by.vino.mygarage.dao.api;

import by.vino.mygarage.dao.jpa.QUser;
import by.vino.mygarage.dao.jpa.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface UserRepository extends
        CrudRepository<User, Integer>, QuerydslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {

    User findByUsername(String username);

    @Override
    default void customize(QuerydslBindings bindings, QUser root) { }
}
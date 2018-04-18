package by.vino.mygarage.dao.api;

import by.vino.mygarage.dao.jpa.Make;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface MakeRepository extends
        CrudRepository<Make, Integer>, QuerydslPredicateExecutor<Make> {
}
package by.vino.mygarage.dao.impl;

import by.vino.mygarage.dao.api.BaseDao;
import by.vino.mygarage.dao.api.UserDao;
import by.vino.mygarage.dao.jpa.User;
import by.vino.mygarage.dao.jpa.User_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByUsername(String username) {
        CriteriaQuery<User> query = entityManager.getCriteriaBuilder().createQuery(User.class);
        Root<User> user = query.from(User.class);
        return super.get(query.where(entityManager.getCriteriaBuilder().equal(user.get(User_.username), username)));
    }

    @Override
    public User findById(int id) {
        CriteriaQuery<User> query = entityManager.getCriteriaBuilder().createQuery(User.class);
        Root<User> user = query.from(User.class);
        return super.get(query.where(entityManager.getCriteriaBuilder().equal(user.get(User_.userId), id)));
    }
}

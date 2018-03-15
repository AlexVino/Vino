package by.vino.mygarage.dao.impl;

import by.vino.mygarage.dao.api.UserDao;
import by.vino.mygarage.dao.jpa.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findUserByUsername(String username) {
        try {
            return (User) entityManager.createQuery("FROM User WHERE username=:username")
                    .setParameter("username", username).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }
}

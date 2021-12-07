package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp<T> implements UserDao<T> {

    private T t;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(T user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCars() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("FROM Car");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUser(Car car) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from User as u where u.car.series = :paramSeries and u.car.model = :paramModel");
        query.setParameter("paramSeries", car.getSeries()).setParameter("paramModel", car.getModel());
        return (User) query.getResultList().get(0);
    }
}

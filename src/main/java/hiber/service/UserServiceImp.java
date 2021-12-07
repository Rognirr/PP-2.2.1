package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp<T> implements UserService<T> {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(T user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCars() {
        return userDao.listCars();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(Car car) {
        return userDao.getUser(car);
    }
}

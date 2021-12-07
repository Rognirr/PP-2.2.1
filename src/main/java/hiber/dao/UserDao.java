package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao<T> {
    void add(T user);

    List<User> listUsers();

    List<Car> listCars();

    User getUser(Car car);
}

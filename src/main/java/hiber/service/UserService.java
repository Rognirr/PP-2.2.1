package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService<T> {
    void add(T user);

    List<User> listUsers();

    List<Car> listCars();

    User getUser(Car car);
}

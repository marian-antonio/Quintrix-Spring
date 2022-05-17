package com.quintrix.jfs.QuintrixSpring.service;

import com.quintrix.jfs.QuintrixSpring.models.Car;
import com.quintrix.jfs.QuintrixSpring.models.GetCarsResponse;

public interface CarsService {

  Car getCarDetailsById(Long id);

  Car addCar(Car car);

  GetCarsResponse getCars(String make);

}

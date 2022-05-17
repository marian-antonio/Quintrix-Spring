package com.quintrix.jfs.QuintrixSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jfs.QuintrixSpring.models.Car;
import com.quintrix.jfs.QuintrixSpring.models.GetCarsResponse;
import com.quintrix.jfs.QuintrixSpring.service.CarsService;

@RestController
public class CarController {
  @Autowired
  CarsService carsService;

  // query parameter
  // @RequestMapping(method = RequestMethod.GET, value = "/cars")
  // List<Car> getCar(@RequestParam(name = "make", required = false) String make) {
  // return carsService.getCars(make);
  // }

  @RequestMapping(method = RequestMethod.GET, value = "/cars")
  GetCarsResponse getCar(@RequestParam(name = "make", required = false) String make) {

    return carsService.getCars(make);
  }

  // path parameter
  @RequestMapping(method = RequestMethod.GET, value = "/cars/{id}")
  Car getCarDetails(@PathVariable("id") Long id) {
    return carsService.getCarDetailsById(id);
  }


  @RequestMapping(method = RequestMethod.POST, value = "/cars")
  Car addCar(@RequestBody Car car) {
    return carsService.addCar(car);
  }
}

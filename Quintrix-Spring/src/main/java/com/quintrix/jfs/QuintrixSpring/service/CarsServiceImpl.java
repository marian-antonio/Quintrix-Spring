package com.quintrix.jfs.QuintrixSpring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.quintrix.jfs.QuintrixSpring.models.Car;
import com.quintrix.jfs.QuintrixSpring.models.ClientCar;
import com.quintrix.jfs.QuintrixSpring.models.GetCarsResponse;
import com.quintrix.jfs.QuintrixSpring.models.agent.Agents;
import com.quintrix.jfs.QuintrixSpring.repository.CarRepository;

@Service
public class CarsServiceImpl implements CarsService {
  @Autowired
  CarRepository carRepository;

  @Autowired
  RestTemplate restTemplate;

  List<Car> carsList = new ArrayList<>(
      Arrays.asList(new Car(1L, "Ford", "Explorer", 2011), new Car(2L, "Honda", "Civic", 2015)));

  @Override
  public GetCarsResponse getCars(String make) {
    GetCarsResponse getCarsResponse = new GetCarsResponse();
    if (make != null) {
      getCarsResponse.setAvailableCarsList(carsList.stream().filter(c -> c.getMake().equals(make))
          .map(c -> new ClientCar(c.getMake(), c.getModel(), c.getYear()))
          .collect(Collectors.toList()));
    } else {
      getCarsResponse.setAvailableCarsList(null);
    }
    getCarsResponse.setAvailableWarranty("2 Years Warranty");


    List<Agents> agentsList =
        restTemplate.getForObject("https://gorest.co.in/public/v2/users", List.class);

    return getCarsResponse;
  }

  @Override
  public Car getCarDetailsById(Long id) {
    // Optional<Car> result =
    // carsList.stream().filter(c -> c.getId().longValue() == id.longValue()).findAny();
    Optional<Car> result = carRepository.findById(id);
    if (result.isPresent()) {
      return result.get();
    } else {
      return new Car();
    }
  }

  @Override
  public Car addCar(Car car) {
    // carsList.add(car);
    Car newCar = carRepository.save(car);
    return newCar;
  }
}

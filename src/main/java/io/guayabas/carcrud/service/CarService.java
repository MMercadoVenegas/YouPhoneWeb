package io.guayabas.carcrud.service;

import io.guayabas.carcrud.endpoint.model.Car;
import io.guayabas.carcrud.repository.CarRepository;
import io.guayabas.carcrud.repository.DataBaseCars;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.guayabas.carcrud.repository.model.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    public List<Car> getAllCars(){
        List<Car> finalCars = new ArrayList<>();
        List<CarEntity> cars = (List<CarEntity>)carRepository.findAll();
        for(CarEntity entity: cars){
            Car car = new Car();
            car.setId(entity.getId());
            car.setPlateCode(entity.getPlateCode());
            car.setBrand(entity.getBrand());
            car.setModel(entity.getModel());
            car.setColor(entity.getColor());
            finalCars.add(car);
        }
        return finalCars;
    }

    public Car findCarById(int id){
        Optional<CarEntity> foundCar = carRepository.findById(id);
        boolean isFound = foundCar.isPresent();
        if(isFound) {
            CarEntity dbCar = foundCar.get();
            Car car = new Car();
            car.setBrand(dbCar.getBrand());
            car.setColor(dbCar.getColor());
            car.setModel(dbCar.getModel());
            car.setPlateCode(dbCar.getPlateCode());
            return car;
        }
        return null;
    }

    public Car deleteCarById(int id) {
            Optional<CarEntity> foundCar = carRepository.findById(id);
            boolean isFound = foundCar.isPresent();
            if(isFound){
                CarEntity dbCar = foundCar.get();
                Car car = new Car();
                car.setBrand(dbCar.getBrand());
                car.setColor(dbCar.getColor());
                car.setModel(dbCar.getModel());
                car.setPlateCode(dbCar.getPlateCode());
                carRepository.delete(dbCar);
                return car;
        }
        return null;
    }

    public boolean addCar(Car aCar) {
        CarEntity newCar = new CarEntity();
        newCar.setBrand(aCar.getBrand());
        newCar.setModel(aCar.getModel());
        newCar.setColor(aCar.getColor());
        newCar.setPlateCode(aCar.getPlateCode());
        carRepository.save(newCar);
        return true;
    }

    public Car updateCarById(int id, Car aCar) {
        Optional<CarEntity> foundCar = carRepository.findById(id);
        boolean isFound = foundCar.isPresent();
        if(isFound){
            CarEntity car = foundCar.get();
            car.setBrand(aCar.getBrand());
            car.setColor(aCar.getColor());
            car.setModel(aCar.getModel());
            car.setPlateCode(aCar.getPlateCode());
            carRepository.save(car);
            return aCar;
        }
        return null;
    }
}

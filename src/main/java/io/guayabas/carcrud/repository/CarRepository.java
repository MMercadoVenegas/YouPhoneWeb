package io.guayabas.carcrud.repository;

import io.guayabas.carcrud.repository.model.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository
        extends CrudRepository<CarEntity, Integer> {
}

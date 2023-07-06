package io.guayabas.carcrud.endpoint;


import io.guayabas.carcrud.endpoint.model.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCarResponse {
    private Car car;
}

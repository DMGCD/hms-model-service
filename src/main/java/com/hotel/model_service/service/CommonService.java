package com.hotel.model_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface CommonService<T, ID> {
    T add(T t);

    List<T> getAll();


    T findById(ID id);

    T updateDetails(T t, ID id) throws JsonProcessingException;

    String deleteDetails(ID id);


    String say(String x);
}

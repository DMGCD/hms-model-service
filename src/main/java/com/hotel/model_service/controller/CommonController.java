package com.hotel.model_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface CommonController<T, ID> {

    ResponseEntity<T> add(T t) throws Exception;

    ResponseEntity<List<T>> getAll() throws Exception;

    ResponseEntity<T> findById(ID id) throws Exception;

    ResponseEntity<T> update(T t, ID id) throws Exception;

    ResponseEntity<String> delete(ID id) throws Exception;
    ResponseEntity<String> say(String x)throws Exception;

}

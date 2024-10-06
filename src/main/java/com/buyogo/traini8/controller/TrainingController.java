package com.buyogo.traini8.controller;

import com.buyogo.traini8.model.TrainingCenter;
import com.buyogo.traini8.service.TrainingService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TrainingController {

    @Autowired
    private TrainingService service;

    /*
    *  This URI is for saving Training Center Data in DataBase
    */
    @PostMapping("api/traini8")
    public ResponseEntity<Map<String, Object>> saveTrainingCenter(@Valid @RequestBody TrainingCenter center){
        return  service.saveTrainingCenterDetail(center);
    }

    /*
     *  This URI is for retrieving  Training Center Data from DataBase
     */
    @GetMapping("api/traini8")
    public ResponseEntity<Map<String, Object>> findAllCenter(){
        return service.getAllTrainingCenters();
    }

    /*
     *   This URI is filter data based on Student Capacity
     * */
    @GetMapping("api/traini8/capacity/{capacity}")
    public ResponseEntity<Map<String, Object>> filterDataByCapacity(@PathVariable(name = "capacity") int capacity){
        return service.filterData(capacity);
    }

    /*
    *   This URI is filter data based on city
    * */
    @GetMapping("api/traini8/city/{city}")
    public ResponseEntity<Map<String, Object>> filterDataByCourses(@PathVariable(name = "city") String city){
        return service.filterData(city);
    }
}

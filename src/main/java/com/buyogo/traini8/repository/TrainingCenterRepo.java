package com.buyogo.traini8.repository;

import com.buyogo.traini8.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainingCenterRepo extends JpaRepository<TrainingCenter, Integer> {
    List<TrainingCenter> findByStudentCapacity(int capacity);

    @Query("select c from TrainingCenter c where c.address.city = ?1")
    List<TrainingCenter> findByCity(String city);
}

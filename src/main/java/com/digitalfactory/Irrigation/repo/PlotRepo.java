package com.digitalfactory.Irrigation.repo;

import com.digitalfactory.Irrigation.entity.Plot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlotRepo extends JpaRepository<Plot, Integer> {

    Optional<Plot> findById(Integer id);
    @Query("SELECT p FROM Plot p")
    List<Plot> findAllPlots();


}

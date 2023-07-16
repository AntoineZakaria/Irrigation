package com.digitalfactory.Irrigation.repo;

import com.digitalfactory.Irrigation.entity.IrrigationTimeSlot;
import com.digitalfactory.Irrigation.entity.Plot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface IrrigationTimeSlotRepo extends JpaRepository<IrrigationTimeSlot, Integer> {
    Optional<IrrigationTimeSlot> findById(Integer id);
    @Query("SELECT s FROM IrrigationTimeSlot s")
    List<IrrigationTimeSlot> findAllTimeSlots();

}

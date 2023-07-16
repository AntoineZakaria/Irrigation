package com.digitalfactory.Irrigation.service;

import com.digitalfactory.Irrigation.dto.TimeSlotDto;
import com.digitalfactory.Irrigation.dto.request.CreateTimeSlotRequest;
import com.digitalfactory.Irrigation.dto.response.CreateTimeSlotResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface TimeSlotService {

    List<TimeSlotDto> getAllTimeSlots();


    TimeSlotDto getTimeSlotById(Integer id);

    CreateTimeSlotResponse createTimeSlot(@Valid CreateTimeSlotRequest createTimeSlotResponse);
}

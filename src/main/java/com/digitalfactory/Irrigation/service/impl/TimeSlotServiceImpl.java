package com.digitalfactory.Irrigation.service.impl;


import com.digitalfactory.Irrigation.dto.TimeSlotDto;
import com.digitalfactory.Irrigation.dto.request.CreateTimeSlotRequest;
import com.digitalfactory.Irrigation.dto.response.CreateTimeSlotResponse;
import com.digitalfactory.Irrigation.mapper.TimeSlotMapper;
import com.digitalfactory.Irrigation.repo.IrrigationTimeSlotRepo;
import com.digitalfactory.Irrigation.service.TimeSlotService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

    private final IrrigationTimeSlotRepo timeSlotRepo;

    private final TimeSlotMapper timeSlotMapper;


    public TimeSlotServiceImpl(IrrigationTimeSlotRepo timeSlotRepo, TimeSlotMapper timeSlotMapper) {
        this.timeSlotRepo = timeSlotRepo;
        this.timeSlotMapper = timeSlotMapper;
    }

    @Override
    public List<TimeSlotDto> getAllTimeSlots() {
      return timeSlotRepo.findAllTimeSlots().stream().map(timeSlotMapper::toDto).toList();
    }

    @Override
    public TimeSlotDto getTimeSlotById(Integer id) {
        return null;
    }

    @Override
    public CreateTimeSlotResponse createTimeSlot( CreateTimeSlotRequest createTimeSlotRequest) {
        CreateTimeSlotResponse createTimeSlotResponse = timeSlotMapper.toCreateTimeSlotResponse(timeSlotRepo.save(timeSlotMapper.toEntity(createTimeSlotRequest)));
        return createTimeSlotResponse ;
    }
}

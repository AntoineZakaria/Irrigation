package com.digitalfactory.Irrigation.controller;


import com.digitalfactory.Irrigation.common.Constants;
import com.digitalfactory.Irrigation.dto.PlotDto;
import com.digitalfactory.Irrigation.dto.TimeSlotDto;
import com.digitalfactory.Irrigation.dto.request.CreatePlotRequest;
import com.digitalfactory.Irrigation.dto.request.CreateTimeSlotRequest;
import com.digitalfactory.Irrigation.dto.response.AllTimeSlotsResponse;
import com.digitalfactory.Irrigation.dto.response.CreatePlotResponse;
import com.digitalfactory.Irrigation.dto.response.CreateTimeSlotResponse;
import com.digitalfactory.Irrigation.service.TimeSlotService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(TimeSlotController.TIMESLOT_BASE_URL)
public class TimeSlotController {
    final static String TIMESLOT_BASE_URL = Constants.API_BASE_URL + "/timeslot";


    private final TimeSlotService timeSlotService;

    public TimeSlotController(TimeSlotService timeSlotService) {
        this.timeSlotService = timeSlotService;
    }


    @GetMapping()
    public ResponseEntity<AllTimeSlotsResponse> getAllPlots() {
        AllTimeSlotsResponse allTimeSlotsResponse = AllTimeSlotsResponse.builder()
                .timeSlots(timeSlotService.getAllTimeSlots()).build();
        return new ResponseEntity<>(allTimeSlotsResponse, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeSlotDto> getPlotById(@PathVariable Integer id) {
        TimeSlotDto timeSlotDto = timeSlotService.getTimeSlotById(id);
        return new ResponseEntity<>(timeSlotDto, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<CreateTimeSlotResponse> createNewPlot(@RequestBody @Valid CreateTimeSlotRequest createTimeSlotRequest) {
        CreateTimeSlotResponse createTimeSlotResponse = timeSlotService.createTimeSlot(createTimeSlotRequest);
        return new ResponseEntity<>(createTimeSlotResponse, HttpStatus.CREATED);

    }


}

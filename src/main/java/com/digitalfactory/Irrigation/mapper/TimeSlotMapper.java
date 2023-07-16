package com.digitalfactory.Irrigation.mapper;


import com.digitalfactory.Irrigation.dto.PlotDto;
import com.digitalfactory.Irrigation.dto.TimeSlotDto;
import com.digitalfactory.Irrigation.dto.request.CreatePlotRequest;
import com.digitalfactory.Irrigation.dto.request.CreateTimeSlotRequest;
import com.digitalfactory.Irrigation.dto.response.CreatePlotResponse;
import com.digitalfactory.Irrigation.dto.response.CreateTimeSlotResponse;
import com.digitalfactory.Irrigation.entity.IrrigationTimeSlot;
import com.digitalfactory.Irrigation.entity.Plot;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)

public interface TimeSlotMapper {
    TimeSlotDto toDto(IrrigationTimeSlot slot);
    IrrigationTimeSlot toEntity(CreateTimeSlotRequest createTimeSlotRequest);
    CreateTimeSlotResponse toCreateTimeSlotResponse(IrrigationTimeSlot irrigationTimeSlot);
}

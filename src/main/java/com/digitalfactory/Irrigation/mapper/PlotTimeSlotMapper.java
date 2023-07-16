package com.digitalfactory.Irrigation.mapper;


import com.digitalfactory.Irrigation.dto.request.ConfigurePlotRequest;
import com.digitalfactory.Irrigation.dto.response.ConfigurePlotResponse;
import com.digitalfactory.Irrigation.entity.PlotTimeslot;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)

public interface PlotTimeSlotMapper {
    PlotTimeslot toEntity(ConfigurePlotRequest configurePlotRequest);

    ConfigurePlotResponse toConfigurePlotResponse(PlotTimeslot save);
}

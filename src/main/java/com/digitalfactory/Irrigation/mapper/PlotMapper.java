package com.digitalfactory.Irrigation.mapper;


import com.digitalfactory.Irrigation.dto.PlotDto;
import com.digitalfactory.Irrigation.dto.request.CreatePlotRequest;
import com.digitalfactory.Irrigation.dto.response.CreatePlotResponse;
import com.digitalfactory.Irrigation.entity.Plot;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)

public interface PlotMapper {
    PlotDto toDto(Plot plot);
    Plot toEntity(CreatePlotRequest createPlotRequest);
    CreatePlotResponse toCreatePlotResponse(Plot plot);
}

package com.digitalfactory.Irrigation.service;

import com.digitalfactory.Irrigation.dto.PlotDto;
import com.digitalfactory.Irrigation.dto.request.CreatePlotRequest;
import com.digitalfactory.Irrigation.dto.response.CreatePlotResponse;

import java.util.List;

public interface PlotService {

    List<PlotDto> getAllPlots() ;

    PlotDto getPlotById(Integer id);

    CreatePlotResponse createPlot(CreatePlotRequest createPlotRequest);
}

package com.digitalfactory.Irrigation.service.impl;

import com.digitalfactory.Irrigation.dto.PlotDto;
import com.digitalfactory.Irrigation.dto.request.CreatePlotRequest;
import com.digitalfactory.Irrigation.dto.response.CreatePlotResponse;
import com.digitalfactory.Irrigation.entity.Plot;
import com.digitalfactory.Irrigation.exception.customexception.EntityNotFoundException;
import com.digitalfactory.Irrigation.mapper.PlotMapper;
import com.digitalfactory.Irrigation.repo.PlotRepo;
import com.digitalfactory.Irrigation.service.PlotService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlotServiceImpl implements PlotService {


    private final PlotRepo plotRepo;
    private final PlotMapper plotMapper;


    public PlotServiceImpl(PlotRepo plotRepo, PlotMapper plotMapper) {
        this.plotRepo = plotRepo;
        this.plotMapper = plotMapper;
    }

    @Override
    public List<PlotDto> getAllPlots() {
        return plotRepo.findAllPlots().stream().map(plotMapper::toDto).toList();

    }
    @Override
    public PlotDto getPlotById(Integer id) {
        Plot plot = plotRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No Plots with Id: " + id)
        );
        return plotMapper.toDto(plot);
    }

    @Override
    public CreatePlotResponse createPlot(CreatePlotRequest createPlotRequest) {
        CreatePlotResponse createPlotResponse = plotMapper.toCreatePlotResponse(plotRepo.save(plotMapper.toEntity(createPlotRequest)));
        return createPlotResponse ;
    }
}

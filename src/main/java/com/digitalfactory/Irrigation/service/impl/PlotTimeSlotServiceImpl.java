package com.digitalfactory.Irrigation.service.impl;

import com.digitalfactory.Irrigation.dto.request.ConfigurePlotRequest;
import com.digitalfactory.Irrigation.dto.response.ConfigurePlotResponse;
import com.digitalfactory.Irrigation.exception.customexception.EntityNotFoundException;
import com.digitalfactory.Irrigation.mapper.PlotTimeSlotMapper;
import com.digitalfactory.Irrigation.repo.IrrigationTimeSlotRepo;
import com.digitalfactory.Irrigation.repo.PlotRepo;
import com.digitalfactory.Irrigation.repo.PlotTimeSlotRepo;
import com.digitalfactory.Irrigation.service.PlotTimeSlotService;
import org.springframework.stereotype.Service;

@Service
public class PlotTimeSlotServiceImpl implements PlotTimeSlotService {

    private final PlotTimeSlotRepo plotTimeSlotRepo;
    private  final IrrigationTimeSlotRepo timeSlotRepo;
    private final PlotRepo plotRepo;

    private final PlotTimeSlotMapper plotTimeSlotMapper;

    public PlotTimeSlotServiceImpl(PlotTimeSlotRepo plotTimeSlotRepo, IrrigationTimeSlotRepo timeSlotRepo, PlotRepo plotRepo, PlotTimeSlotMapper plotTimeSlotMapper) {
        this.plotTimeSlotRepo = plotTimeSlotRepo;
        this.timeSlotRepo = timeSlotRepo;
        this.plotRepo = plotRepo;
        this.plotTimeSlotMapper = plotTimeSlotMapper;
    }

    @Override
    public ConfigurePlotResponse configurePlot(ConfigurePlotRequest configurePlotRequest, Integer plotId) {

        plotRepo.findById(plotId).orElseThrow(
                () -> new EntityNotFoundException("no plots found with id: " + plotId)//TODO move all strings to constants file
        );
        timeSlotRepo.findById(configurePlotRequest.getIrrigationTimeSlotId()).orElseThrow(
                ()->new EntityNotFoundException("no timeSlots found with id: " + configurePlotRequest.getIrrigationTimeSlotId())
        );
       ConfigurePlotResponse configurePlotResponse =plotTimeSlotMapper.toConfigurePlotResponse( plotTimeSlotRepo.save(plotTimeSlotMapper.toEntity(configurePlotRequest)));
       configurePlotResponse.setPlotId(plotId);
        return configurePlotResponse ;
    }
}

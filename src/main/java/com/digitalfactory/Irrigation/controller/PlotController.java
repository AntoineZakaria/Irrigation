package com.digitalfactory.Irrigation.controller;


import com.digitalfactory.Irrigation.common.Constants;
import com.digitalfactory.Irrigation.dto.PlotDto;
import com.digitalfactory.Irrigation.dto.request.ConfigurePlotRequest;
import com.digitalfactory.Irrigation.dto.request.CreatePlotRequest;
import com.digitalfactory.Irrigation.dto.response.AllPlotsResponse;
import com.digitalfactory.Irrigation.dto.response.ConfigurePlotResponse;
import com.digitalfactory.Irrigation.dto.response.CreatePlotResponse;
import com.digitalfactory.Irrigation.service.PlotService;
import com.digitalfactory.Irrigation.service.PlotTimeSlotService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PlotController.PLOT_BASE_URL)
public class PlotController {
    final static String PLOT_BASE_URL = Constants.API_BASE_URL + "/plot";


    private final PlotService plotService;
    private final PlotTimeSlotService plotTimeSlotService;


    public PlotController(PlotService plotService, PlotTimeSlotService plotTimeSlotService) {
        this.plotService = plotService;
        this.plotTimeSlotService = plotTimeSlotService;
    }


    @GetMapping()
    public ResponseEntity<AllPlotsResponse> getAllPlots() {
        AllPlotsResponse allPlotsResponse = AllPlotsResponse.builder()
                .plots(plotService.getAllPlots()).build();
        return new ResponseEntity<>(allPlotsResponse, HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<PlotDto> getPlotById(@PathVariable Integer id) {
        PlotDto plotDto = plotService.getPlotById(id);
        return new ResponseEntity<>(plotDto, HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<CreatePlotResponse> createNewPlot(@RequestBody @Valid CreatePlotRequest createPlotRequest) {
        CreatePlotResponse createPlotResponse = plotService.createPlot(createPlotRequest);
        return new ResponseEntity<>(createPlotResponse, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/configure")
    public ResponseEntity<ConfigurePlotResponse> createNewPlot(@PathVariable Integer id ,@RequestBody @Valid ConfigurePlotRequest configurePlotRequest) {
        ConfigurePlotResponse configurePlotResponse = plotTimeSlotService.configurePlot(configurePlotRequest,id);
        return new ResponseEntity<>(configurePlotResponse, HttpStatus.CREATED);
    }


}

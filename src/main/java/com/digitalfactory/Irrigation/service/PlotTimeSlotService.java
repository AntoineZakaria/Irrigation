package com.digitalfactory.Irrigation.service;

import com.digitalfactory.Irrigation.dto.request.ConfigurePlotRequest;
import com.digitalfactory.Irrigation.dto.response.ConfigurePlotResponse;

public interface PlotTimeSlotService {
    ConfigurePlotResponse configurePlot(ConfigurePlotRequest configurePlotRequest,Integer plotId);
}

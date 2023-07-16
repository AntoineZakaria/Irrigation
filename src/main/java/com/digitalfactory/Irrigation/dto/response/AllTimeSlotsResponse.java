package com.digitalfactory.Irrigation.dto.response;


import com.digitalfactory.Irrigation.dto.PlotDto;
import com.digitalfactory.Irrigation.dto.TimeSlotDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllTimeSlotsResponse {
    List<TimeSlotDto> timeSlots ;


}

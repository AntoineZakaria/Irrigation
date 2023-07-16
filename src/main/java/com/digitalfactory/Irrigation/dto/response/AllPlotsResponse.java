package com.digitalfactory.Irrigation.dto.response;


import com.digitalfactory.Irrigation.dto.PlotDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllPlotsResponse {
    List<PlotDto> plots ;
}

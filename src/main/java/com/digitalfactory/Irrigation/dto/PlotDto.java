package com.digitalfactory.Irrigation.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlotDto {
    private Integer id;
    Double area ;
    private Integer irrigationTimeSlotIds ;


}

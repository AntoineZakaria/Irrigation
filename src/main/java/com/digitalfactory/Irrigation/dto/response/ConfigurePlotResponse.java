package com.digitalfactory.Irrigation.dto.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfigurePlotResponse {

    private Integer irrigationTimeSlotId ;
    private Double waterAmountInLitres ;
    private Integer plotId ;



}

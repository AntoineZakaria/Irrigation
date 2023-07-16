package com.digitalfactory.Irrigation.dto.request;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConfigurePlotRequest {

    @NotNull
    private Integer irrigationTimeSlotId ;
    @NotNull
    @Positive
    private Double waterAmountInLitres ;


}

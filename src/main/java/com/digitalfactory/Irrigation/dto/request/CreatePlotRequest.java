package com.digitalfactory.Irrigation.dto.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePlotRequest {
    @NotNull
    @Positive
    Double area ;

}

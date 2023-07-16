package com.digitalfactory.Irrigation.dto.response;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTimeSlotResponse {


    private Integer id ;
    private LocalTime startTime;
    private LocalTime endTime;

}

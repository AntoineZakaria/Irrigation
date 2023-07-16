package com.digitalfactory.Irrigation.dto.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTimeSlotRequest {
    @NotNull
    private LocalTime startTime;
    @NotNull
    private LocalTime endTime;


}

package com.digitalfactory.Irrigation.dto;

import lombok.*;

import java.time.LocalTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeSlotDto {
    private Integer id;
    private LocalTime startTime;
    private LocalTime endTime;

}

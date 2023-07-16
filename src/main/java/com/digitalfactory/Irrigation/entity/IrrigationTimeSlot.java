package com.digitalfactory.Irrigation.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "irrigation_time_slot")
public class IrrigationTimeSlot {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "start_time")
    private LocalTime startTime ;
    @Column(name = "end_time")
    private LocalTime endTime ;
    
}

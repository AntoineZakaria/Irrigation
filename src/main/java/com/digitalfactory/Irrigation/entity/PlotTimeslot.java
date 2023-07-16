package com.digitalfactory.Irrigation.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "plot_timeslot")
public class PlotTimeslot {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "irrigation_timeslot_id")
    private Integer irrigationTimeSlotId ;
    @Column(name = "plot_id")
    private Integer plotId ;
    @Column(name = "water_amount")
    private Double waterAmountInLitres ;

}

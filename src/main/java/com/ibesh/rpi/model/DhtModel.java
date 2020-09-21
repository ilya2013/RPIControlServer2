package com.ibesh.rpi.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DhtModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cgen")
    @SequenceGenerator(name = "cgen", sequenceName = "CUSTOMER_SEQUENCE", allocationSize = 1)
    private Long id;
    private String deviceName;
    private String location;
    private Float temperature;
    private Float humidity;
    private String sensorModel;
    private String pin;
    private LocalDateTime time;
    @Column(name="comment_", length=500, nullable=true, unique=false)
    private String comment;

}

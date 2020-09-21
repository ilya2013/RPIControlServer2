package com.ibesh.rpi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DhtDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("device_name")
    private String deviceName;
    @JsonProperty("location")
    private String location;
    @JsonProperty("temperature")
    private Float temperature;
    @JsonProperty("humidity")
    private Float humidity;
    @JsonProperty("sensor_model")
    private String sensorModel;
    @JsonProperty("pin")
    private String pin;
    @JsonProperty("time")
    private String time;
    @JsonProperty("comment")
    private String comment;

    public DhtDto(String deviceName, String location, Float temperature, Float humidity, String sensorModel, String pin, String time, String comment) {
        this.deviceName = deviceName;
        this.location = location;
        this.temperature = temperature;
        this.humidity = humidity;
        this.sensorModel = sensorModel;
        this.pin = pin;
        this.time = time;
        this.comment = comment;
    }

    public LocalDateTime transformTimeInLocalDateTime(DateTimeFormatter dateTimeFormatter){
        return LocalDateTime.parse(time, dateTimeFormatter);
    }
}

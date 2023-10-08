package com.parkme.app.model.entity;
import lombok.*;


import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TimeRange {

    private List<Boolean> dailyHours;
}

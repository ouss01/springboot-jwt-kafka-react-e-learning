package com.kafka.kafka_messaging.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private Long instructorId;
    private List<Long> lessonIds;
}

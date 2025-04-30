package com.kafka.kafka_messaging.dto;

import lombok.Data;

@Data
public class LessonDTO {
    private Long id;
    private String title;
    private String content;
    private Long courseId;
}

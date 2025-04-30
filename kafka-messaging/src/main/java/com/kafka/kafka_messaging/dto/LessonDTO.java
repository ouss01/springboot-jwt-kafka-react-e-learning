package com.kafka.kafka_messaging.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonDTO {

    private Long id;
    private String title;
    private String content;
    private int duration;
    private Long courseId; // Assuming you want to store the course ID

    // Constructor
    public LessonDTO(Long id, String title, String content, int duration, Long courseId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.duration = duration;
        this.courseId = courseId;
    }
}

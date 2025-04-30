package com.kafka.kafka_messaging.Service;

import com.kafka.kafka_messaging.Entity.Lesson;
import com.kafka.kafka_messaging.dto.LessonDTO;

import java.util.List;
import java.util.Optional;

public interface LessonService {
    List<LessonDTO> getAllLessons();
    Optional<LessonDTO> getLessonById(Long id);
    LessonDTO saveLesson(LessonDTO lessonDTO);
    LessonDTO updateLesson(Long id, LessonDTO lessonDTO);
    void deleteLesson(Long id);
}

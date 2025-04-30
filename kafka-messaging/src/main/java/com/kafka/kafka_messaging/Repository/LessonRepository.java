package com.kafka.kafka_messaging.Repository;

import com.kafka.kafka_messaging.Entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    // Custom queries can be added here if needed, such as finding lessons by course, title, etc.
}

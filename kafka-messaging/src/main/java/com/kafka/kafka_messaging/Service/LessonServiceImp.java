package com.kafka.kafka_messaging.Service;

import com.kafka.kafka_messaging.Entity.Lesson;
import com.kafka.kafka_messaging.dto.LessonDTO;
import com.kafka.kafka_messaging.Repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class LessonServiceImp implements LessonService {

    private final LessonRepository lessonRepository;

    public LessonServiceImp(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public List<LessonDTO> getAllLessons() {
        return lessonRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LessonDTO> getLessonById(Long id) {
        return lessonRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public LessonDTO saveLesson(LessonDTO lessonDTO) {
        Lesson lesson = convertToEntity(lessonDTO);
        Lesson savedLesson = lessonRepository.save(lesson);
        return convertToDTO(savedLesson);
    }

    @Override
    public LessonDTO updateLesson(Long id, LessonDTO lessonDTO) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow();
        lesson.setTitle(lessonDTO.getTitle());  // Using getter
        lesson.setContent(lessonDTO.getContent());  // Using getter
        lesson.setDuration(lessonDTO.getDuration());  // Using getter
        Lesson updatedLesson = lessonRepository.save(lesson);
        return convertToDTO(updatedLesson);
    }

    @Override
    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }

    // Convert Lesson Entity to LessonDTO
    private LessonDTO convertToDTO(Lesson lesson) {
        return new LessonDTO(
                lesson.getId(),
                lesson.getTitle(),
                lesson.getContent(),
                lesson.getDuration(),
                lesson.getCourse().getId()  // Assuming you want the course ID
        );
    }

    // Convert LessonDTO to Lesson Entity
    private Lesson convertToEntity(LessonDTO lessonDTO) {
        Lesson lesson = new Lesson();
        lesson.setTitle(lessonDTO.getTitle());  // Using getter
        lesson.setContent(lessonDTO.getContent());  // Using getter
        lesson.setDuration(lessonDTO.getDuration());  // Using getter
        // You may need to set the course entity here as well
        return lesson;
    }
}

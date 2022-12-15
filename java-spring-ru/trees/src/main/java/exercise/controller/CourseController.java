package exercise.controller;

import exercise.model.Course;
import exercise.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(path = "")
    public Iterable<Course> getCorses() {
        return courseRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Course getCourse(@PathVariable long id) {
        return courseRepository.findById(id);
    }

    // BEGIN
    @GetMapping("/{id}/previous")
    public List<Optional<Course>> getPreviousCourses(@PathVariable long id) {
        String path = courseRepository.findById(id).getPath();
        if (path == null) {
            return new ArrayList<>();
        }

        List<Optional<Course>> parentIds = Arrays.stream(path.split("\\."))
                .toList().stream()
                .map(Long::valueOf)
                .map(ids -> courseRepository.findById(ids))
                .toList();
        return parentIds;
    }
    // END

}

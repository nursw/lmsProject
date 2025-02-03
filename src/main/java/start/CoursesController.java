package start;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import start.service.CoursesService;

@Controller
@RequiredArgsConstructor
public class CoursesController {

    private final CoursesService coursesService;

    @GetMapping("/courses/results")
    public String getCoursesResults(Model model) {
        model.addAttribute("courses", coursesService.getAllCourses());
        return "result"; // Имя HTML страницы result.html
    }
}

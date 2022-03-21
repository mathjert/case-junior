package no.sikt.caseoppgave.student;

import no.sikt.caseoppgave.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/students", produces = APPLICATION_JSON_VALUE)
public class StudentController {

    private static Logger log = LoggerFactory.getLogger(StudentController.class);

    @Inject
    private StudentProvider studentProvider;


    @GetMapping
    public List<Student> getStudents() {
        return studentProvider.getAllStudents();
    }


    // complete the implementation
    public String getStudent(String studentId) {
        return ""; // return a single student
    }


    // complete the implementation.
    // If successful this should return the 201 CREATED http status code.
    public String postStudieprogramStudent(String body) {
        // you can make a request body object and use that instead.
        log.debug(body);
        return "";
    }
}

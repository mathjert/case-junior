package no.sikt.caseoppgave.student;

import no.sikt.caseoppgave.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RequestScope
@Service
public class StudentProvider {

    @PersistenceContext
    private EntityManager em;

    public List<Student> getAllStudents() {
        return em.createNamedQuery(StudentSql.ALLE_STUDENTER_QUERY, Student.class).getResultList();
    }
}

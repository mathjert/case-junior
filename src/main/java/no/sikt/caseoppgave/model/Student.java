package no.sikt.caseoppgave.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import no.sikt.caseoppgave.student.StudentSql;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NamedQuery(name = StudentSql.ALLE_STUDENTER_QUERY, query = StudentSql.ALLE_STUDENTER_SQL)
public class Student {

    @Id
    @Column(name = "studentnr")
    private Integer studentnr;

    @Column(name = "fodselsnr")
    @JsonIgnore
    private String fodselsnr;

    @JsonProperty("personinfo")
    @OneToOne
    @JoinColumn(name = "fodselsnr", referencedColumnName = "fodselsnr", insertable = false, updatable = false, nullable = false)
    private Person person;

    public Integer getStudentnr() {
        return studentnr;
    }

    public void setStudentnr(Integer studentnr) {
        this.studentnr = studentnr;
    }

    public String getFodselsnr() {
        return fodselsnr;
    }

    public void setFodselsnr(String fodselsnr) {
        this.fodselsnr = fodselsnr;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

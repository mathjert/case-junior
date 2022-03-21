DROP TABLE caseoppgave.Studieprogram_Student;
DROP TABLE caseoppgave.Studieprogram;
DROP TABLE caseoppgave.Semester;
DROP TABLE caseoppgave.Student;
DROP TABLE caseoppgave.Person;



CREATE TABLE caseoppgave.Person
(
    fodselsnr VARCHAR(11) NOT NULL,
    fornavn   VARCHAR(40),
    etternavn VARCHAR(50),
    PRIMARY KEY (fodselsnr)
);

CREATE TABLE caseoppgave.Student
(
    studentnr int UNSIGNED AUTO_INCREMENT,
    fodselsnr VARCHAR(11) NOT NULL,
    PRIMARY KEY (studentnr),
    CONSTRAINT P_studentFnr FOREIGN KEY (fodselsnr) REFERENCES Person (fodselsnr)
);

CREATE TABLE caseoppgave.Semester
(
    semesterkode  VARCHAR(2) NOT NULL,
    semester_navn VARCHAR(7),
    PRIMARY KEY (semesterkode)
);

CREATE TABLE caseoppgave.Studieprogram
(
    studieprogramkode  VARCHAR(10) NOT NULL,
    studieprogram_navn VARCHAR(100),
    fakultetkode       VARCHAR(5),
    instnr             int,
    PRIMARY KEY (studieprogramkode)
);

CREATE TABLE caseoppgave.Studieprogram_Student
(
    studentnr                   int UNSIGNED NOT NULL,
    studieprogramkode           VARCHAR(10) NOT NULL,
    uteksaminering_aar          int,
    uteksaminering_semesterkode VARCHAR(2),
    PRIMARY KEY (studentnr, studieprogramkode),
    CONSTRAINT P_StudprogstudStudnr FOREIGN KEY (studentnr)
        REFERENCES Student (studentnr),
    CONSTRAINT P_StudprogstudStudieprogKode FOREIGN KEY (studieprogramkode)
        REFERENCES Studieprogram (studieprogramkode),
    CONSTRAINT P_StudprogstudSemsterkode FOREIGN KEY (uteksaminering_semesterkode)
        REFERENCES Semester (semesterkode)
);



INSERT INTO caseoppgave.Person
VALUES ('17912099997', 'Karl', 'Marx'),
       ('29822099635', 'Princess', 'Diana'),
       ('05840399895', 'Donald', 'Duck'),
       ('12829499914', 'Mikke', 'Mus'),
       ('12905299938', 'Alle', 'André');

INSERT INTO caseoppgave.Student (fodselsnr)
VALUES ('17912099997'),
       ('29822099635'),
       ('05840399895'),
       ('12829499914'),
       ('12905299938');

INSERT INTO caseoppgave.Semester
VALUES ('VI', 'Vinter'),
       ('VA', 'Vår'),
       ('SO', 'Sommer'),
       ('HO', 'Høst');

INSERT INTO caseoppgave.Studieprogram
VALUES ('GAM-PC', 'Gaming på PC - Master', 'IFI', 1),
       ('MAT-10', 'Mat og helse - Bachelor', 'SAM', 1),
       ('POD-RAD', 'Podcast og Radio - Årsstudium', 'RAD', 2),
       ('GAM-PS', 'Gaming på Play Station', 'NAT', 3),
       ('GAM-XB', 'Gaming på XBOX', 'NAT', 3);


INSERT INTO caseoppgave.Studieprogram_Student
VALUES (4, 'POD-RAD', 2025, 'VA');
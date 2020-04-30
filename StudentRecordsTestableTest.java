import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class StudentRecordsTestableTest {
    StudentRecordsTestable test;

    @BeforeEach
    void setUp() {
        test = new StudentRecordsTestable();
    }

   @Test
    void beforeSave(){
        assertEquals(2, test.student.getSchedule().getClasses().size());
    }
    @Test
    void saveClass(){
        test.saveClass("012","015");
        assertEquals(3, test.student.getSchedule().getClasses().size());
    }

    @Test
    void beforeDrop(){
        assertEquals(2, test.student.getSchedule().getClasses().size());
    }

    @Test
    void dropCourse() {
        test.dropCourse("012",0);
        assertEquals(1, test.student.getSchedule().getClasses().size());
    }

    @Test
    void beforeInsert(){
        assertEquals(0, test.classInSched2.getGrade());
    }
    @Test
    void insertGrade() {
        test.insertGrade("012", "013", 2.00);
        assertEquals(2,test.classInSched2.getGrade());
    }

    @Test
    void beforeInsertAttendance(){
        assertEquals(0, test.classInSched2.getAbsences());
    }

    @Test
    void insertAttendance() {
        test.insertAttendance("012", "013", "A");
        assertEquals("A", test.classInSched2.getAbsences());
    }

    @Test
    void scheduleView() {
        test.scheduleView("012");
        assertEquals("John", test.student.getFirstName());
    }

    @Test
    void transcriptView() {
        test.transcriptView("012");
        assertEquals(3.1, test.student.getGPA());
    }
}

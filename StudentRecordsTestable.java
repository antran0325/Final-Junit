import java.util.ArrayList;
        import java.util.HashMap;

public class StudentRecordsTestable{
    Student student;
    HashMap<String, Course>allClasses;
    ArrayList<String> newDays;
    Course newClass;
    Course classInSched;
    Course classInSched2;

    StudentRecordsTestable() {
        student = new Student();
        classInSched = new Course("013", "World History", newDays, "10:00", "11:30", "Emily Monet", "Fall 2017", 15);
        student.getSchedule().addClass(classInSched);
        classInSched2 = new Course("014", "European History", newDays, "10:00", "11:30", "Emily Monet", "Fall 2017", 15);
        student.getSchedule().addClass(classInSched2);
        allClasses = new HashMap<String, Course>();
        allClasses.put("Class 1", classInSched);
        newDays = new ArrayList<String>();
        newDays.add("Wednesday");
        newClass = new Course("012", "Art History", newDays, "9:00", "10:30", "Emily Monet", "Fall 2017", 15);
        allClasses.put("Class 2", newClass);
    }
    public void saveClass(String student_id, String course_id) {
        /*
         * @author Theo
         * @author Jamie
         */
        //pull wanted class from DB
        Course newClass=allClasses.get("Class 2");
        //ensures class can be added
        if(student.getIdNum().equals(student_id)&&student.getSchedule().getClasses().size()<4&&!(student.getSchedule().getClasses().contains(newClass))){
            //put the class in the right spot in their schedule
            student.getSchedule().addClass(newClass);
            System.out.println("Class added!");
        } else {
            System.out.println("Drop a class first");
        }
    }

    public void dropCourse(String student_id, int dropNum){
        /*
         * @author Theo
         * @author Jamie
         */
        if(student.getIdNum().equals(student_id)) {
            //displays all of their classes
            System.out.println(student.getSchedule().toString());
            //picks the appropriate columns in the DB to update, sets appropriate columns to null
            Course course = student.getSchedule().getClasses().get(dropNum);
            student.getSchedule().dropClass(course);
            System.out.println("Class dropped!");
            System.out.println(student.getSchedule().toString());

        }
    }


    //selects the courses inline with the correct student ID, finds which one matches, inserts grade for that course (1, 2, 3, or 4)
    public void insertGrade(String student_id,String course_id,double newGrade){
        /*
         * @author Theo
         * @author Caitlin
         * @author Jamie
         */
        if(student.getIdNum().equals(student_id)) {
            //display schedule
            System.out.println(student.getSchedule().toString());
            //updates the grade for the correct class
            Course course = allClasses.get(course_id);
            if(student.getSchedule().getClasses().contains(course)){
                course.setGrade(newGrade);
            }
        }
    }


    //finds correct course with the same method used in insertGrade, then inserts attendance instead (if grade and attendance weren't different data types, these methods could be combined) - my connection isn't working, so this has not been tested
    public void insertAttendance(String student_id,String course_id,String attendance){
        /*
         * @author Theo
         * @author Caitlin
         * @author Jamie
         */
        if(student.getIdNum().equals(student_id)){
            //display schedule
            System.out.println(student.getSchedule().toString());
            //figures out which course matches the course id
            Course course = allClasses.get(course_id);
            //if there's a match update attendance
            if(student.getSchedule().getClasses().contains(course)){
                course.setAbsences(attendance);
            }
        }
    }
    public void scheduleView(String student_id) {
        /*
         * @Author An*/
        if (student.getIdNum().equals(student_id)) {
            System.out.println("Here is the schedule! ");
            System.out.println("Course ID: " + classInSched.getCourse_id() +
                    "\n Course: " + classInSched.getName() +
                    "\n Days: " + classInSched.getDays() +
                    "\n Start: " + classInSched.getStartTime() +
                    "\n End: " + classInSched.getEndTime() +
                    "\n Faculty: " + classInSched.getFaculty()+
                    "\n Course ID: " + classInSched2.getCourse_id() +
                    "\n Course: " + classInSched2.getName() +
                    "\n Days: " + classInSched2.getDays() +
                    "\n Start: " + classInSched2.getStartTime() +
                    "\n End: " + classInSched2.getEndTime() +
                    "\n Faculty: " + classInSched2.getFaculty());
        }
    }
    public void transcriptView(String student_id){
        /*
        * @Author: An*/
        if (student.getIdNum().equals(student_id)){
            System.out.println("Here is the transcript! ");
              System.out.println("ID: " + student.getIdNum() +
                      "\n First Name: " + student.getFirstName() +
                      "\n Last Name: " + student.getLastName() +
                      "\n Email: " + student.getEmail() +
                      "\n Phone number: " + student.getPhoneNum() +
                      "\n GPA: " + student.getGPA() +
                      "\n Semester: " + classInSched.getSemester() +
                      "\n Course: " + classInSched.getCourse_id() +
                      "\n Course name: " + classInSched.getName()+
                      "\n Grade: " + classInSched.getGrade() +
                      "\n Absence: " + classInSched.getAbsences()+
                      "\n Course: " + classInSched2.getCourse_id() +
                      "\n Course name: " + classInSched2.getName() +
                      "\n Grade: " + classInSched2.getGrade() +
                      "\n Absence: " + classInSched2.getAbsences()
              );
        }
    }
}


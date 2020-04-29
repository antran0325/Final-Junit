/** Student Class
     * @author Theo
     */

    public class Student {
        //attributes
        private String firstName;
        private String lastName;
        private String idNum;
        private String email;
        private double gpa;
        private String phoneNum;
        private Schedule schedule;

        public Student(){
            firstName="John";
            lastName="Smith";
            idNum="012";
            email="johnsmith@email.com";
            gpa=3.1;
            phoneNum="7";
            schedule= new Schedule();
        }

        public Student(String studentFirstName, String studentLastName, String student_id, String studentEmail, double gradepa, String studentphone){
            firstName=studentFirstName;
            lastName=studentLastName;
            idNum=student_id;
            email=studentEmail;
            gpa=gradepa;
            phoneNum=studentphone;
            schedule=new Schedule();
        }

        //get student attribute values

        public double getGPA() {
            return gpa;
        }

        public String getFirstName(){
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getPhoneNum() {
            return phoneNum;
        }

        public Schedule getSchedule(){
            return schedule;
        }

        public String getIdNum() {
            return idNum;
        }
    }



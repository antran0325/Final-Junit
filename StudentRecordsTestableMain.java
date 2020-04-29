public class StudentRecordsTestableMain {
    public static void main (String[]args){
        StudentRecordsTestable sr = new StudentRecordsTestable();
        System.out.println(sr.classInSched.getGrade());
        sr.insertGrade("012", "014", 1.5);
        System.out.println(sr.classInSched2.getGrade());

}
}
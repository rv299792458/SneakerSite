package NotesForPrep;


class Student{
    int rollNo;
    int age;
    String gender;
    String name;
    String lastName;

    Student(StudentBuilder sb)
    {
        this.rollNo=sb.rollNo;
        this.age=sb.age;
        this.gender=sb.gender;
        this.name=sb.name;
        this.lastName=sb.lastName;
    }

}

class StudentBuilder{
    int rollNo;
    int age;
    String gender;
    String name;
    String lastName;

    public StudentBuilder withRollNo(int rn)
    {
        rollNo=rn;
        return this;
    }


}
public class BuilderDesign {



}

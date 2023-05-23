package com.example.test2.Service;
import com.example.test2.Model.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student> students=new ArrayList<>();

    public ArrayList<Student> getStudent() {
        return students;
    }


    public boolean addStudent(Student Student){
        for (int i=0;i<students.size();i++) {
            if (students.get(i).getId() == Student.getId()) {
                return false;
            }
        }
        students.add(Student);
        return true;

    }

    public boolean updateStudent( Student Student, int id){
        for (int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                students.set(i,Student);
                return true;
            }
        }
        return false;
    }


    public boolean deleteStudent(  int id){
        for (int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                students.remove(i);
                return true;
            }
        }
        return false;
    }


    public String getOneStudent(String name ){
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getName().equalsIgnoreCase(name)){
                return students.get(i).toString();
            }
        }
        return "Students not existed";
    }
}

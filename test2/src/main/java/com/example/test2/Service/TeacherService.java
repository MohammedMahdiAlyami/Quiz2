package com.example.test2.Service;
import com.example.test2.Model.Teacher;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getTeacher() {
        return teachers;
    }


    public boolean addTeacher(Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == teacher.getId()) {
                return false;
            }
        }
        teachers.add(teacher);
        return true;
    }

    public boolean updateTeacher(Teacher teacher, int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }


    public String getOneTeacher(int id ){
        for (int i = 0; i < teachers.size(); i++){
            if (teachers.get(i).getId()==id){
                return teachers.get(i).toString();
            }
        }
        return "teacher not existed";
    }


}
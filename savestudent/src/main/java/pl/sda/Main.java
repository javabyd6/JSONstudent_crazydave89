package pl.sda;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Student> createStudentList(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Dawid","Kamasz",1));
        studentList.add(new Student("Marcin","Marsz",2));
        studentList.add(new Student("Antek","Hash",3));
        studentList.add(new Student("Andrzej","Gar",4));
        studentList.add(new Student("Witek","Won",5));
        return studentList;
    }

    public static void writeToJson(){
        List<Student> studentList = new ArrayList<>();
        studentList.addAll(createStudentList());
        ObjectMapper objectMapper= new ObjectMapper();
        try {
            String result =objectMapper.writeValueAsString(studentList);
            Files.write(Paths.get("student.json"),result.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        writeToJson();

    }

}

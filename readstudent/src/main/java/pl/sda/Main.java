package pl.sda;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void wyswieltJsona(){
        ObjectMapper objectMapper= new ObjectMapper();
        try {
            Student[]  students = objectMapper.readValue(new File("student.json"), Student[].class);
            List<Student> studentList1= Arrays.asList(students);
            System.out.println(studentList1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void wyswieltNaLitere(char a){
        ObjectMapper objectMapper= new ObjectMapper();
        try {
            Student[]  students = objectMapper.readValue(new File("student.json"), Student[].class);
            List<Student> studentList1= Arrays.asList(students);
            List<Student> list= studentList1.stream()
                    .filter(x->x.getName().startsWith(String.valueOf(a)))
                    .collect(Collectors.toList());
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       // wyswieltJsona();
        wyswieltNaLitere('D');
    }
}

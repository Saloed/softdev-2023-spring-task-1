package task1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudeTest {
    @Test
    public void testStudents() {

        Students students = new Students(3530901);
        Students check = new Students(3530901);
        Map<String, List<Integer>> grade = new HashMap<>();
        Map<String, List<Integer>> gr = new HashMap<>();

        students.addStudent("Смирнов Игнат");
        students.addStudent("Кириллов Данил");

        check.students.put("Смирнов Игнат", grade);
        check.students.put("Кириллов Данил", gr);
        assertEquals(check.students, students.students);



        check.students.get("Кириллов Данил").put("Информатика", new ArrayList<>());
        check.students.get("Смирнов Игнат").put("Информатика", new ArrayList<>());
        check.students.get("Смирнов Игнат").get("Информатика").add(3);
        check.students.get("Смирнов Игнат").get("Информатика").add(4);
        check.students.get("Смирнов Игнат").get("Информатика").add(5);

        students.addSubject("Информатика");
        students.addGrade("Смирнов Игнат", "Информатика", 3);
        students.addGrade("Смирнов Игнат", "Информатика", 4);
        students.addGrade("Смирнов Игнат", "Информатика", 5);
        assertEquals(check.students, students.students);

    }
}

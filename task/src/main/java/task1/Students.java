package task1;
import java.util.*;
enum Fives {
    ONE, TWO, THREE, FOUR, FIVE
}

public class Students {
    Integer number;
    Map<String, Map<String, List<Fives>>> students = new HashMap<String, Map<String, List<Fives>>>();

    public Students(Integer number) {
        this.number = number;
    }
    public String getValue() {
        return number.toString() + ": " + students;
    }
    void addStudent(String name) {
        Map<String, List<Fives>> grades = new HashMap<>();
        students.put(name, grades);
    }
    void removeStudent(String name) {
        students.remove(name);
    }
    public void addSubject(String subject) {
        for (String name : students.keySet()) {
            students.get(name).put(subject, new ArrayList<>());
        }
    }
    public void removeSubject(String subject) {
        for (String name : students.keySet()) {
            students.get(name).remove(subject);
        }
    }
    void addGrade(String name, String subject, Fives grade) {
        students.get(name).get(subject).add(grade);
    }
    void removeGrade(String subject, String name, Integer index) {
        students.get(name).get(subject).remove(index);
    }
    void changeGrade(String name, String subject, Integer index, Fives grade) {
        students.get(name).get(subject).set(index, grade);
    }
}

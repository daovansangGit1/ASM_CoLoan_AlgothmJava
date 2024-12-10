/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist_nangcao;

import java.util.Objects;

/**
 *
 * @author sangd
 */
public class Student {
    private String id;
    private String fullName;
    private int age;
    private float gpa;

    public Student() {
    }

    public Student(String id, String fullName, int age, float gpa) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", fullName=" + fullName + ", age=" + age + ", gpa=" + gpa + '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Nếu là cùng đối tượng, trả về true
        if (o == null || getClass() != o.getClass()) return false; // Kiểm tra kiểu đối tượng
        Student student = (Student) o; // Ép kiểu đối tượng thành Student
        return age == student.age && 
           Float.compare(gpa, student.gpa) == 0 && // So sánh GPA
           id.equals(student.id) && // So sánh id
           fullName.equals(student.fullName); // So sánh fullName
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, age, gpa); // Tạo mã băm từ các thuộc tính
    }
    
    // Phương thức để so sánh theo tên
    public boolean equalsByName(Student student) {
        return this.fullName.equals(student.fullName); // So sánh theo tên
    }
}

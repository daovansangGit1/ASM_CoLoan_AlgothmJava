/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist_nangcao;

/**
 *
 * @author sangd
 */
public class StudentMS {

    private final LinkedList<Student> list;

    public StudentMS() {
        this.list = new LinkedList<>();
    }

    public LinkedList<Student> getList() {
        return list;
    }

    // Thêm sinh viên với xử lý ngoại lệ
    public void addStudent(Student student) {
        try {
            if (student == null) {
                throw new IllegalArgumentException("Sinh viên không được null.");
            }
            this.list.addLast(student);
            System.out.println("Thêm sinh viên thành công.");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi khi thêm sinh viên: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi không xác định: " + e.getMessage());
        }
    }

    // In danh sách sinh viên
    public void printList() {
        this.list.traverse();
    }

    public boolean findStudent(Student student) {
        return list.findItem(student);
    }

    // Tìm sinh viên theo tên
    public void findStudentByName(String name) {
        list.findItemByName(name); // Gọi phương thức tìm kiếm trong danh sách
    }

    // Cập nhật thông tin sinh viên với xử lý ngoại lệ
    public void updateStudent(Student student) {
        try {
            if (student == null || student.getId() == null) {
                throw new IllegalArgumentException("Thông tin sinh viên không hợp lệ.");
            }

            Node<Student> tmp = list.getHead();
            boolean updated = false;

            while (tmp != null) {
                Student st = tmp.getData();
                if (st.getId().equals(student.getId())) {
                    st.setFullName(student.getFullName());
                    st.setAge(student.getAge());
                    st.setGpa(student.getGpa());
                    updated = true;
                    break;
                }
                tmp = tmp.getNext();
            }

            if (!updated) {
                throw new IllegalArgumentException("Không tìm thấy sinh viên có ID: " + student.getId());
            }

            System.out.println("Cập nhật thông tin sinh viên thành công.");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi khi cập nhật sinh viên: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi không xác định: " + e.getMessage());
        }
    }

    // Xóa sinh viên với xử lý ngoại lệ
    public void removeStudent(Student student) {
        try {
            if (student == null) {
                throw new IllegalArgumentException("Sinh viên không được null.");
            }

            boolean removed = this.list.remove(student);

            if (!removed) {
                throw new IllegalArgumentException("Không tìm thấy sinh viên để xóa.");
            }

            System.out.println("Xóa sinh viên thành công.");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi khi xóa sinh viên: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi không xác định: " + e.getMessage());
        }
    }

    // Đếm số lượng sinh viên theo loại GPA
    public void countByGPA() {
        int excellent = 0; // Sinh viên loại giỏi
        int good = 0;      // Sinh viên loại khá
        int average = 0;   // Sinh viên loại trung bình

        Node<Student> tmp = list.getHead(); // Lấy node đầu tiên trong linked list
        while (tmp != null) {
            float gpa = tmp.getData().getGpa(); // Lấy GPA của sinh viên

            if (gpa > 8.0 && gpa < 11.0) { // GPA lớn hơn 8.0 mới là Giỏi
                excellent++;
            } else if (gpa >= 6.5 && gpa < 8.0) { // GPA từ 6.5 đến 8.0 là Khá
                good++;
            } else if (gpa < 6.5) { // GPA dưới 6.5 là Trung bình
                average++;
            }

            tmp = tmp.getNext(); // Chuyển sang node tiếp theo
        }

        System.out.println("So Luong Sinh Vien GIOI: " + excellent);
        System.out.println("So Luong Sinh Vien KHA: " + good);
        System.out.println("So Luong Sinh Vien TRUNG BINH: " + average);
    }

    // Sắp xếp sinh viên theo GPA
    public void bubbleSortByGPA() {
        Node<Student> current = list.getHead();
        boolean swapped;

        do {
            swapped = false;
            current = list.getHead();
            while (current != null && current.getNext() != null) {
                Student currentStudent = current.getData();
                Student nextStudent = current.getNext().getData();

                if (currentStudent.getGpa() < nextStudent.getGpa()) {
                    current.setData(nextStudent);
                    current.getNext().setData(currentStudent);
                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
    }
}

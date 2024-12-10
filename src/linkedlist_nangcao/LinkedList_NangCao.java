/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlist_nangcao;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 *
 * @author sangd
 */
public class LinkedList_NangCao {

     public static void main(String[] args) {
        StudentMS sms = new StudentMS();

        System.out.println("He Thong Quan Ly Sinh Vien");

        try (Scanner scanner = new Scanner(System.in)) {
            boolean isRunning = true;

            while (isRunning) {
                try {
                    System.out.println("\n=========== MENU =============");
                    System.out.println("1. Them Sinh Vien");
                    System.out.println("2. Danh Sach Sinh Vien");
                    System.out.println("3. Tim Kiem Sinh Vien");
                    System.out.println("4. Cap Nhat Sinh Vien");
                    System.out.println("5. So Luong Xep Loai Sinh Vien");
                    System.out.println("6. Xoa Sinh Vien");
                    System.out.println("7. Sap xep sinh vien theo GPA");
                    System.out.println("8. Thoat");
                    System.out.println("==============================\n");
                    System.out.print("Nhap Lua Chon Cua Ban: ");

                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ dòng trống

                    switch (choice) {
                        case 1 -> {
                            try {
                                System.out.println("\n====--- Them Sinh Vien ---====");
                                System.out.print("Nhap Id Sinh Vien: ");
                                String id = scanner.nextLine();
                                System.out.print("Nhap Ten Sinh Vien: ");
                                String name = scanner.nextLine();
                                System.out.print("Nhap Tuoi: ");
                                int age = scanner.nextInt();
                                System.out.print("Nhap GPA: ");
                                float gpa = scanner.nextFloat();
                                scanner.nextLine(); // Đọc bỏ dòng trống

                                if (gpa < 0 || gpa > 10) {
                                    throw new IllegalArgumentException("GPA phai trong khoang 0-10.");
                                }

                                Student newStudent = new Student(id, name, age, gpa);
                                sms.addStudent(newStudent);
                                System.out.println("Them Sinh Vien Thanh Cong!");
                                sms.printList();
                            } catch (InputMismatchException ex) {
                                System.out.println("Loi: Nhap Sai Kieu Du Lieu!");
                                scanner.nextLine(); // Xóa dữ liệu không hợp lệ
                            } catch (IllegalArgumentException ex) {
                                System.out.println("Loi: " + ex.getMessage());
                            }
                        }
                        case 2 -> {
                            System.out.println("\n======= **** Danh Sach Sinh Vien **** ========");
                            sms.printList();
                        }
                        case 3 -> {
                            try {
                                System.out.println("\n---+++ Tim Sinh Vien +++---");
                                System.out.print("Nhap Ten Sinh Vien Can Tim: ");
                                String searchName = scanner.nextLine();
                                sms.findStudentByName(searchName);
                            } catch (Exception ex) {
                                System.out.println("Loi khi tim kiem: " + ex.getMessage());
                            }
                        }
                        case 4 -> {
                            try {
                                System.out.println("\n---@@@ Cap Nhat Sinh Vien @@@---");
                                System.out.print("Nhap Ma Sinh Vien Can Cap Nhat: ");
                                String updateId = scanner.nextLine();
                                System.out.print("Nhap Ten Moi: ");
                                String newName = scanner.nextLine();
                                System.out.print("Nhap Tuoi Moi: ");
                                int newAge = scanner.nextInt();
                                System.out.print("Nhap GPA Moi: ");
                                float newGpa = scanner.nextFloat();
                                scanner.nextLine();

                                if (newGpa < 0 || newGpa > 10) {
                                    throw new IllegalArgumentException("GPA phai trong khoang 0-10.");
                                }

                                Student updatedStudent = new Student(updateId, newName, newAge, newGpa);
                                sms.updateStudent(updatedStudent);
                                System.out.println("Cap Nhat Thanh Cong!");
                                sms.printList();
                            } catch (InputMismatchException ex) {
                                System.out.println("Loi: Nhap Sai Kieu Du Lieu!");
                                scanner.nextLine();
                            } catch (IllegalArgumentException ex) {
                                System.out.println("Loi: " + ex.getMessage());
                            }
                        }
                        case 6 -> {
                            try {
                                System.out.println("\n---%%% Xoa Sinh Vien %%%---");
                                System.out.print("Nhap Ma So Sinh Vien Can Xoa: ");
                                String removeId = scanner.nextLine();

                                Node<Student> tmp = sms.getList().getHead();
                                boolean found = false;
                                while (tmp != null) {
                                    if (tmp.getData().getId().equals(removeId)) {
                                        sms.removeStudent(tmp.getData());
                                        System.out.println("Xoa Sinh Vien Thanh Cong!");
                                        sms.printList();
                                        found = true;
                                        break;
                                    }
                                    tmp = tmp.getNext();
                                }
                                if (!found) {
                                    throw new NullPointerException("Khong Tim Thay Sinh Vien Voi Ma So: " + removeId);
                                }
                            } catch (Exception ex) {
                                System.out.println("Loi: " + ex.getMessage());
                            }
                        }
                        case 8 -> {
                            System.out.println("Thoat Chuong Trinh > Tam Biet!");
                            isRunning = false;
                        }
                        default -> System.out.println("Lua Chon Khong Hop Le.");
                    }
                } catch (Exception ex) {
                    System.out.println("Loi He Thong: " + ex.getMessage());
                }
            }
        }
    }
}

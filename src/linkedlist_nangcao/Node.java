/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist_nangcao;

/**
 *
 * @author sangd
 */
public class Node<T> {
    // thuộc tính data dùng để lưu trữ đối tượng sinh viên
    private T data;
    // Thuộc tính này dùng để trỏ đến Node tiếp theo trong danh sách
    private Node<T> next;

    // Con tructor và phương thức get, set
    public Node() {
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    // Dùng để lấy ra đối tượng sinh viên nằm trong node này
    public T getData() {
        return data;
    }

    // set đối tượng sinh viên vào trong node này
    public void setData(T data) {
        this.data = data;
    }

    // phần này dùng để lấy node tiếp theo, đi đến node tiếp theo
    public Node<T> getNext() {
        return next;
    }

    // phần này để xác định node tiếp theo
    public void setNext(Node<T> next) {
        this.next = next;
    }
      
}

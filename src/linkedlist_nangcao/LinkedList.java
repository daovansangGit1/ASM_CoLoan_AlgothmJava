/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist_nangcao;

/**
 *
 * @author sangd
 */
public class LinkedList<T> {
    private Node<T> head;

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    
    public LinkedList() {
        this.head = null;
    }
    
    // Duyệt từng phần tử trong linkedList
    public void traverse() {
        Node<T> tmp = head;
        
        if (tmp == null) {
            System.out.println("Khong co Sinh vien Nao trong danh sach");
        }
        
        while(tmp != null){
            // In phần tử ra
            System.out.println(tmp.getData());
            
            tmp = tmp.getNext();
        }
    }
    
    // Thêm phần tử Node vào đầu danh sách
    public void addFirstNode(T item) { // item ở đây là 1 sinh viên
        // Bước 1:
        // hàm khởi tạo nhận 1 sinh viên và trở đến node đầu tiên - thêm ptu vào đầu
        Node<T> newNode = new Node<>(item, this.head);
        
        // Bước 2: sau đó gắn head là node mới
        this.head = newNode;
    }
    
    
    // Thêm node vào cuối
    public void addLast(T item){
        if (head == null) { // nếu danh sách trống thêm vào đầu danh sách
            addFirstNode(item);
        }
        else { // nếu danh sách không trống: thì duyệt danh sách và thêm node vào phần null của danh sách
            // Bước 1: tạo node mới
            Node<T> newNode = new Node<T>(item, null); // node mới là cuối cùng nên next là null
            
            // 
            Node<T> tmp = head;
            while(tmp.getNext() != null) { // duyệt đến khi nào gặp null thì nó sẽ thoát ra ngoài
                tmp = tmp.getNext();
            }
            // node tiếp là null thì thêm node mới vào
            tmp.setNext(newNode);
        }
    }
    
    // thêm node mới vào phía sau node nào đó trong danh sách: chèn hàng
    public void insertAfter(T key, T toInsert) { // key = node trc đó là gì, toInsert node mới
        
        
        //B2
        Node<T> tmp = head;
        while(tmp != null && !tmp.getData().equals(key)){ // duyệt đến khi nào gặp đc node mình muốn chèn vào sau
            tmp = tmp.getNext(); 
        }
        // tmp bây giờ có 2 trường hợp: null và node trước node cần thêm
        // set next của node trc là node mới và next của node mới tới node tiếp theo của node trước
        if (tmp != null) { // khi tmp tìm thấy node đằng trước node mới
            // B1
            Node<T> newNode = new Node<>();
            newNode.setData(toInsert);
            // B2
            // next của node mới là node tiếp theo của node trước
            newNode.setNext(tmp.getNext());
            
            // cách 2: = B1 + B2
            //Node<T> newNode = new Node<>(toInsert, tmp.getNext());
            
            // B3
            // sau đó đặt next của node trc tới node mới
            tmp.setNext(newNode);
        }
        else {
            // logic không tìm thấy node trước để thêm
        }
    }
    
    
    // Xóa một node trong linkedList
    public boolean remove(T key) { // key là đối tượng cần xóa
        if(head == null) {
            return false;
        }
        
        // Trường hợp 1 xóa node đầu tiên
        // khi xóa node đầu tiên thì phải chuyển head là node tiếp theo
        if (head.getData().equals(key)) { 
            this.head = head.getNext();
            return true;
        }
        
        // xóa node ở vị trí ngẫu nhiên
        // đặt next của node trước node cần xóa tham chiếu đến node tiếp theo của node cần xóa
        Node<T> prev = null; 
        Node<T> cur = head; 
        
        // xác định node cần xóa và node trước đó
        while(cur != null && !cur.getData().equals(key)) { // điều kiện dừng khi tìm thấy node cần xóa và hết danh sách
            // mỗi khi lặp thì cur sẽ tiến đến node tiếp theo, 
            //sử dụng gán lại cur cho prev để lưu trữ node trước đó trước khi chuyển qua node tiếp theo
            prev = cur;
            cur = cur.getNext();
        }
        
        // nếu không thấy node cần xóa return false
        if (cur == null) {
            return false;
        }
        
        // Đảm bảo rằng prev không phải là null khi tiến hành xóa
        if (prev != null) {
            prev.setNext(cur.getNext()); // trỏ node trước đó sang node tiếp theo
        }
        return true;
    }

        // pHương thức kiểm tra xem danh sách có bị rỗng hay không
    public boolean isEmpty() {
        return head == null;
    }
    
    // Phương thức danh sách có bao nhiêu phần tử
    public int size() {
        int count = 0;
        
        Node<T> tmp = head;
        while (tmp != null) {
            count++;
            //chuyển đến phần tử tiếp theo
            tmp = tmp.getNext();
        }
        return count;
    }
    
    // tìm sinh viên trong danh sách hay không
    public boolean findItem(T item) {
        Node<T> tmp = head;
        
        while (tmp != null) { // hết danh sách
            if (tmp.getData().equals(item)) { //  tìm thấy node cần tìm
                return true;
            }
            // chuyển đến node tiếp theo
            tmp = tmp.getNext();
        }
        return false; // ra ngoài mà không thấy return false
    }
    
    // Tìm sinh viên theo tên
    // lặp hết danh sách tìm ra đối tượng,
    // từ đối tượng lấy fullname so sanh với fullname truyền vào 
    // in ra thông tin của đối tượng tìm được
    public void findItemByName(String fullName) { 
        Node<T> tmp = head;
    
        while (tmp != null) { 
            Student student = (Student) tmp.getData(); // Ép kiểu đối tượng sang Student
            if (student.getFullName().equals(fullName)) { // Kiểm tra tên
            // Hiển thị thông tin sinh viên
                System.out.println("Sinh Vien Tim Thay:");
                System.out.println("ID: " + student.getId());
                System.out.println("Ten: " + student.getFullName());
                System.out.println("Tuoi: " + student.getAge());
                System.out.println("GPA: " + student.getGpa());
                return; // Kết thúc khi tìm thấy
            }
            tmp = tmp.getNext();
        }
        System.out.println("Khong Tim Thay Sinh Vien Voi Ten: " + fullName);
    }
}

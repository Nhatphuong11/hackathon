package ra.run;

import ra.bussinessImp.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
public class Main {
    public static List<Book> bookList = new ArrayList<>();
    public static int choice;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("*****************************Product Management*****************************");
            System.out.println("1. Nhập số sách và nhập thông tin sách");
            System.out.println("2. Hiển thị thông tin các sách");
            System.out.println("3. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm sách theo tên sách");
            System.out.println("6. Thay đổi trạng thái của sách theo mã sách");
            System.out.println("7. Thoát");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                     show();
                    break;
                case 3:
                    sortDownInterest();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    tradeStatus();
                    break;
                case 7:
                    System.out.println("Đã thoát!");
                    System.exit(0);
                    break;
            }
        } while (true);
    }
    public static void add(){
        System.out.print("Nhập số lượng sách cần thêm mới: ");
        int numBooksToAdd = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numBooksToAdd; i++) {
            Book book = new Book();
            book.inputData(sc);
            bookList.add(book); // Thêm sách vào danh sách bookList
        }

        System.out.println(numBooksToAdd + " sách đã được thêm vào danh sách.");
    }
    public static void show(){
        for (Book book : bookList){
            book.displayData();
        }
    }
    public static void delete(){
        System.out.println("Nhập mã sách cần xoá");
        int deleteId = Integer.parseInt(sc.nextLine());
        boolean check = false;
        Book deleteBook = new Book();
        for (Book element : bookList) {
            if(element.getBookId() == deleteId){
                deleteBook = element;
                check = true;
                break;
            }
        }
        if(check){
            bookList.remove(deleteBook);
        }else {
            System.out.println("Mã sách cần xoá không tìm thấy");
        }
    }
    public static void sortDownInterest() {
        Collections.sort(bookList,(s1, s2)->Double.compare(s2.getInterest(), s1.getInterest()));
        for (Book element : bookList) {
            element.displayData();
        }
    }
    public static void search(){
        System.out.printf("Nhập tên sách cần tìm: ");
        String name = sc.nextLine();
        boolean found = false;
        for (Book book : bookList) {
            if (book.getBookName().equalsIgnoreCase(name)) {
                book.displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách với tên " + name);
        }
    }
    public static  Void tradeStatus(){
        System.out.print("Nhập mã sách cần thay đổi trạng thái: ");
        int changeStatusBookId = Integer.parseInt(sc.nextLine());
        for (Book book : bookList) {
            if (book.getBookId() == changeStatusBookId) {
                book.setBookStatus(!book.isBookStatus());
                System.out.println("Trạng thái của sách đã được thay đổi.");
                break;
            }
        }
        return null;
    }
}

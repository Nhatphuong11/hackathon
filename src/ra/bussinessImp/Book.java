package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Scanner;

public class Book implements IBook {
    public static int nextId = 1;
    private int bookId;
    private String bookName;
    private int numberOfPages;
    private String title;
    private double importPrice;
    private double exportPrice ;
    private float interest;
    private boolean bookStatus = true ;
    public Book() {
        this.bookId = nextId++;
    }

    public Book( String bookName, String title, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        this.bookName = bookName;
        this.title = title;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public static void remove(Book bookToDelete) {
    }


    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getImportPrice() {
        return importPrice;
    }
    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }
    public double getExportPrice() {
        return exportPrice;
    }
    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }
    public float getInterest() {
        return interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }
    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
    public void calculateInterest() {
        this.interest = (float) (this.exportPrice - this.importPrice);
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sách: %d - Tên sách: %s - Tiêu đề: %s - Sô trang sách: %d\n", this.bookId, this.bookName, this.title, this.numberOfPages);
        System.out.printf("Giá nhập: %f - Giá bán: %f - Lợi nhuận: %f - Trạng thái: %b\n", this.importPrice, this.exportPrice, this.interest, this.bookStatus);
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhập vào mã sách");
        this.bookId = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập tên sách");
        this.bookName = sc.nextLine();

        System.out.println("Nhập tiêu đề");
        this.title = sc.nextLine();

        System.out.println("Nhập số trang sách");
        this.numberOfPages = Integer.parseInt(sc.nextLine());

        System.out.println("Giá nhâp");
        this.importPrice = Double.parseDouble(sc.nextLine());

        System.out.println("Giá bán");
        this.exportPrice = Double.parseDouble(sc.nextLine());

        System.out.println("Nhập trạng thái");
        String isActive = sc.nextLine();
        if (isActive.equals("con hang")) {
            bookStatus = true;
        } else if (isActive.equals("het hang")) {
            bookStatus= false;
        } else {
            bookStatus = false;
        }


    }

}


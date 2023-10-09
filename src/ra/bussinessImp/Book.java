package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Scanner;

import static ra.run.Main.sc;

public class Book implements IBook{
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice ;
    private float interest;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;

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

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = this.exportPrice - this.exportPrice;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
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
        this.importPrice = Float.parseFloat(sc.nextLine());

        System.out.println("Giá bán");
        this.exportPrice = Float.parseFloat(sc.nextLine());

        this.interest = this.exportPrice - this.importPrice;

        System.out.println("Nhập trạng thái");
        this.bookStatus = Boolean.parseBoolean(sc.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sách: %d - Tên sách: %s - Tiêu đề: %s - Số trang sách: %d\n", this.bookId, this.bookName, this.title, this.numberOfPages);
        System.out.printf("Giá nhập: %f - Giá bán: %f - Lợi nhuận: %f - Trạng thái: %s\n", this.importPrice, this.exportPrice, this.interest, this.bookStatus ? "Còn hàng" : "Hết hàng");
    }
}
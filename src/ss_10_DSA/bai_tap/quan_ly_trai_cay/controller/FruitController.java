package ss_10_DSA.bai_tap.quan_ly_trai_cay.controller;

import java.util.Scanner;

import static ss_10_DSA.bai_tap.quan_ly_trai_cay.view.FruitView.*;

public class FruitController {
    private static Scanner scanner = new Scanner(System.in);

    public static void Menu() {
        while (true) {
            System.out.println("==== MENU QUẢN LÝ TRÁI CÂY ====");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Xoá theo ID");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Chọn cách hiển thị:");
                    System.out.println("1. Hiển thị theo keySet()");
                    System.out.println("2. Hiển thị theo entrySet()");
                    System.out.print("Lựa chọn: ");
                    String displayChoice = scanner.nextLine();

                    if (displayChoice.equals("1")) {
                        displayByKeySet();
                    } else if (displayChoice.equals("2")) {
                        displayByEntrySet();
                    } else {
                        System.out.println("Lựa chọn không hợp lệ, hiển thị mặc định theo entrySet()");
                        displayByEntrySet();
                    }
                    break;
                case "2":
                    add();
                    break;
                case "3":
                    removeById();
                    break;
                case "4":
                    System.out.println("Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}

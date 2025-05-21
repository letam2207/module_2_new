package ss_10_DSA.bai_tap.quan_ly_trai_cay.controller;

import ss_10_DSA.bai_tap.quan_ly_trai_cay.entity.Fruit;
import ss_10_DSA.bai_tap.quan_ly_trai_cay.service.FruitService;
import ss_10_DSA.bai_tap.quan_ly_trai_cay.service.IFruitService;
import ss_10_DSA.bai_tap.quan_ly_trai_cay.view.FruitView;

import java.util.List;
import java.util.Scanner;

public class FruitController {
    private static Scanner scanner = new Scanner(System.in);
    private static IFruitService fruitService = new FruitService();
    public static void Menu() {
        boolean check = true;

        do {
            System.out.println("-----ỨNG DỤNG QUẢN LÝ TRÁI CÂY------\n"
                    + "1. Hiển thị danh sách\n"
                    + "2. Thêm mới\n"
                    + "3. Thoát \n"
                    +"------Nhập Lựa Chọn-----");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    List<Fruit> fruitList = fruitService.findAll();
                    FruitView.display(fruitList);
                    break;
                case 2:
                    FruitView.add();
                    System.out.println("Thêm mới thành công !");
                    break;
                case 3:
                    System.exit(0);
            }
        } while (check);
    }
}

package ss_10_DSA.bai_tap.quan_ly_trai_cay.view;

import ss_10_DSA.bai_tap.quan_ly_trai_cay.entity.Fruit;
import ss_10_DSA.bai_tap.quan_ly_trai_cay.service.FruitService;
import ss_10_DSA.bai_tap.quan_ly_trai_cay.service.IFruitService;

import java.util.List;
import java.util.Scanner;

public class FruitView {
    private static IFruitService fruitService = new FruitService();
    private static Scanner scanner = new Scanner(System.in);

    public static void display(List<Fruit> fruits) {
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }
    }

    public static void add() {
        System.out.println("Nhập tên trái cây :");
        String fruitName = scanner.nextLine();
        System.out.println("Nhập loại trái cây :");
        String fruitType = scanner.nextLine();
        System.out.println("Nhập ngày sản xuất :");
        String productionDate = scanner.nextLine();
        System.out.println("Nhập hạn sử dụng :");
        String expiry = scanner.nextLine();
        System.out.println("Nhập nơi sản xuất :");
        String origin = scanner.nextLine();
        System.out.println("Nhập giá :");
        double price = Integer.parseInt(scanner.nextLine());
        fruitService.add(new Fruit(fruitName, fruitType, productionDate, expiry, origin, price));
    }
}

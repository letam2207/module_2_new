package ss_10_DSA.bai_tap.quan_ly_trai_cay.view;

import ss_10_DSA.bai_tap.quan_ly_trai_cay.entity.Fruit;
import ss_10_DSA.bai_tap.quan_ly_trai_cay.service.FruitService;
import ss_10_DSA.bai_tap.quan_ly_trai_cay.service.IFruitService;
import ss_10_DSA.bai_tap.quan_ly_trai_cay.utils.Regex;

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
        String fruitName, fruitType, productionDate, expiry, origin;
        double price;
        System.out.println("Nhập tên trái cây :");
        fruitName = Regex.inputName(scanner);

        System.out.println("Nhập loại trái cây :");
        fruitType = scanner.nextLine();
        boolean check;
        do {
            System.out.println("Nhập ngày sản xuất:");
            productionDate = scanner.nextLine();
            check = Regex.isValidProductionDate(productionDate);
            if (!check) {
                System.out.println("Ngày sản xuất không hợp lệ. Vui lòng nhập lại (định dạng dd/MM/yyyy, và không lớn hơn ngày hiện tại).");
            }
        } while (!check);
        do {
            System.out.println("Nhập hạn sử dụng :");
            expiry = scanner.nextLine();
            check = Regex.isValidExpirationDate(productionDate, expiry);
            if (!check) {
                System.out.println("Hạn sử dụng không hợp lệ. Vui lòng nhập lại (định dạng dd/MM/yyyy, và không nhỏ hơn ngày sản xuất).");
            }
        } while (!check);

        System.out.println("Nhập nơi sản xuất :");
        origin = scanner.nextLine();

        while (true) {
            System.out.print("Nhập giá: ");
            String input = scanner.nextLine();

            try {
                price = Integer.parseInt(input);

                if (price > 0) {
                    break;
                } else {
                    System.out.println(" Giá phải là số nguyên lớn hơn 0. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Đầu vào không hợp lệ. Vui lòng nhập một số nguyên.");
            }
        }

        fruitService.add(new Fruit(fruitName, fruitType, productionDate, expiry, origin, price));
    }
}

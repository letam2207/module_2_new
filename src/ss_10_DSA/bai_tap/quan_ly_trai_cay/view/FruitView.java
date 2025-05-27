package ss_10_DSA.bai_tap.quan_ly_trai_cay.view;

import ss_10_DSA.bai_tap.quan_ly_trai_cay.entity.Fruit;
import ss_10_DSA.bai_tap.quan_ly_trai_cay.service.FruitService;
import ss_10_DSA.bai_tap.quan_ly_trai_cay.service.IFruitService;
import ss_10_DSA.bai_tap.quan_ly_trai_cay.utils.Regex;

import java.util.List;
import java.util.Scanner;

public class FruitView {
    private static final IFruitService fruitService = new FruitService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void display(List<Fruit> fruits) {
        for (Fruit fruit : fruits) {
            System.out.println(fruit);
        }
    }
    public static void displayByKeySet() {
        List<Fruit> fruits = fruitService.findAllByKeySet();
        for (Fruit fruit : fruits) {
            System.out.println(fruit);
        }
    }

    public static void displayByEntrySet() {
        List<Fruit> fruits = fruitService.findAllByEntrySet();
        for (Fruit fruit : fruits) {
            System.out.println(fruit);
        }
    }


    public static void add() {
        int id = generateId();
        String fruitName, fruitType, productionDate, expiry, origin;
        double price;

        System.out.println("Nhập tên trái cây:");
        fruitName = Regex.inputName(scanner);

        System.out.println("Nhập loại trái cây:");
        fruitType = scanner.nextLine();

        boolean check;
        do {
            System.out.println("Nhập ngày sản xuất:");
            productionDate = scanner.nextLine();
            check = Regex.isValidProductionDate(productionDate);
            if (!check) {
                System.out.println("Ngày sản xuất không hợp lệ. Định dạng: dd/MM/yyyy và không lớn hơn ngày hiện tại.");
            }
        } while (!check);

        do {
            System.out.println("Nhập hạn sử dụng:");
            expiry = scanner.nextLine();
            check = Regex.isValidExpirationDate(productionDate, expiry);
            if (!check) {
                System.out.println("Hạn sử dụng không hợp lệ. Phải lớn hơn ngày sản xuất.");
            }
        } while (!check);

        System.out.println("Nhập nơi sản xuất:");
        origin = scanner.nextLine();

        while (true) {
            System.out.print("Nhập giá: ");
            String input = scanner.nextLine();
            try {
                price = Double.parseDouble(input);
                if (price > 0) {
                    break;
                } else {
                    System.out.println("Giá phải lớn hơn 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ.");
            }
        }

        Fruit newFruit = new Fruit(id, fruitName, fruitType, productionDate, expiry, origin, price);
        fruitService.add(newFruit);
        System.out.println(" Thêm trái cây thành công!");
    }

    private static int generateId() {
        List<Fruit> fruitList = fruitService.findAll();
        int maxId = 0;
        for (Fruit fruit : fruitList) {
            if (fruit.getId() > maxId) {
                maxId = fruit.getId();
            }
        }
        return maxId + 1;
    }
    public static void removeById() {
        System.out.print("Nhập ID của trái cây cần xoá: ");
        String input = scanner.nextLine();

        try {
            int id = Integer.parseInt(input);
            Fruit fruit = fruitService.findById(id);
            if (fruit == null) {
                System.out.println("Không tìm thấy trái cây với ID: " + id);
                return;
            }

            System.out.println("Bạn có chắc muốn xoá trái cây này? (Y/N)");
            System.out.println(fruit);
            String confirm = scanner.nextLine().trim().toUpperCase();
            if (confirm.equals("Y")) {
                fruitService.remove(id);
                System.out.println(" Đã xoá thành công!");
            } else {
                System.out.println(" Đã huỷ thao tác xoá.");
            }

        } catch (NumberFormatException e) {
            System.out.println(" ID không hợp lệ. Vui lòng nhập số nguyên.");
        }
    }

}

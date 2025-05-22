package ss_10_DSA.bai_tap.quan_ly_trai_cay.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {

    public static String inputName(Scanner scanner) {
        String nameRegex = "^[A-ZÀ-Ỵ][a-zà-ỹ]+$";
        Pattern pattern = Pattern.compile(nameRegex);
        String name;

        do {
            System.out.print("Nhập tên trái cây (Viết hoa chữ cái đầu): ");
            name = scanner.nextLine();
            if (pattern.matcher(name).matches()) {
                return name;
            } else {
                System.out.println("Sai định dạng. Vui lòng nhập lại.");
            }
        } while (true);
    }


    private static final String DATE_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/[0-9]{4}$";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static boolean isValidDateFormat(String dateStr) {
        return Pattern.matches(DATE_REGEX, dateStr);
    }
    public static boolean isValidProductionDate(String productionDateStr) {
        if (!isValidDateFormat(productionDateStr)) return false;

        try {
            LocalDate productionDate = LocalDate.parse(productionDateStr, DATE_FORMATTER);
            return !productionDate.isAfter(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isValidExpirationDate(String productionDateStr, String expirationDateStr) {
        if (!isValidDateFormat(productionDateStr) || !isValidDateFormat(expirationDateStr)) return false;

        try {
            LocalDate productionDate = LocalDate.parse(productionDateStr, DATE_FORMATTER);
            LocalDate expirationDate = LocalDate.parse(expirationDateStr, DATE_FORMATTER);
            return expirationDate.isAfter(productionDate);
        } catch (DateTimeParseException e) {
            return false;
        }
    }




}

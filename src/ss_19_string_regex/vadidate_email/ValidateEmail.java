package ss_19_string_regex.vadidate_email;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {
    public static void validateEmail(){
        Scanner scanner = new Scanner(System.in);
        String validateEmail;
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);

        do {
            System.out.print("Nhập Email: ");
            validateEmail = scanner.nextLine();
            Matcher matcher = pattern.matcher(validateEmail);
            if (matcher.matches()) {
                System.out.println("Email hợp lệ!");
                break;
            } else {
                System.out.println("Sai định dạng. Vui lòng nhập lại.");
            }
        } while (true);
    }
    public static void main(String[] args) {
       validateEmail();
    }
}

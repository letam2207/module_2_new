package ss_8_clean_code.bai_tap.clean_code;

public class CleanCode {
    public int sum(int num1, int num2, int num3) {
        int total = num1 + num2 + num3;
        return total;
    }

    private void employeeDetails(Employee employee) {

    }


    public boolean isLeapYear(int year) {
        // Năm nhuận nếu chia hết cho 4 nhưng không chia hết cho 100, trừ khi chia hết cho 400
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public int getDayOfMonth(int month, int year) {
        if (month < 1 || month > 12) {
            return -1;
        }

        if (month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12) {
            return 31;
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }

        return isLeapYear(year) ? 29 : 28;
    }
}

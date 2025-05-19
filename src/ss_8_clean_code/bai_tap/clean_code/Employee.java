package ss_8_clean_code.bai_tap.clean_code;

public class Employee {
    private String name;
    private String age;
    private String awards;
    private String ctc;
    private String experience;

    public Employee(String name, String age, String awards, String ctc, String experience) {
        this.name = name;
        this.age = age;
        this.awards = awards;
        this.ctc = ctc;
        this.experience = experience;
    }


    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getAwards() {
        return awards;
    }

    public String getCtc() {
        return ctc;
    }

    public String getExperience() {
        return experience;
    }
}

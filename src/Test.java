import java.util.*;




public class Test {
    public static void testSet(){
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("apple"); // sẽ bị bỏ qua vì "apple" đã tồn tại
        System.out.println(set); // [banana, apple]
    }


    public static void main(String[] args) {
   testSet();
    }
}

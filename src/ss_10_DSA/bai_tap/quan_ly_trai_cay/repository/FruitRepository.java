package ss_10_DSA.bai_tap.quan_ly_trai_cay.repository;

import ss_10_DSA.bai_tap.quan_ly_trai_cay.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitRepository implements IFruitRepository {
   private static final List<Fruit> fruitList = new ArrayList<>();
    static {
         fruitList.add(new Fruit("Thơm","Quả","12/02/2025", "18/02/2025","Đà Nẵng",50000));
         fruitList.add(new Fruit("Táo","Quả","15/02/2025","20/02/2025","Quảng Nam",65000));
         fruitList.add(new Fruit("Chuối","Quả","22/04/2025","30/04/2025","Đà Nẵng",55000));
    }
    @Override
    public List<Fruit> findAll() {
        return fruitList;
    }

    @Override
    public void add(Fruit fruit) {
        fruitList.add(fruit);
    }
}

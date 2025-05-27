package ss_10_DSA.bai_tap.quan_ly_trai_cay.repository;

import ss_10_DSA.bai_tap.quan_ly_trai_cay.entity.Fruit;

import java.util.*;

public class FruitRepository implements IFruitRepository {

    private static final Map<Integer, Fruit> fruitMap = new LinkedHashMap<>();

    static {
        fruitMap.put(1, new Fruit(1, "Thơm", "Quả", "12/02/2025", "18/02/2025", "Đà Nẵng", 50000));
        fruitMap.put(2, new Fruit(2, "Táo", "Quả", "15/02/2025", "20/02/2025", "Quảng Nam", 65000));
        fruitMap.put(3, new Fruit(3, "Chuối", "Quả", "22/04/2025", "30/04/2025", "Đà Nẵng", 55000));
    }

    public List<Fruit> findAllByKeySet() {
        List<Fruit> list = new ArrayList<>();
        for (Integer key : fruitMap.keySet()) {
            list.add(fruitMap.get(key));
        }
        return list;
    }

    public List<Fruit> findAllByEntrySet() {
        List<Fruit> list = new ArrayList<>();
        for (Map.Entry<Integer, Fruit> entry : fruitMap.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

    @Override
    public List<Fruit> findAll() {
        return findAllByEntrySet();
    }

    @Override
    public void add(Fruit fruit) {
        fruitMap.put(fruit.getId(), fruit);
    }

    @Override
    public Fruit findById(int id) {
        return fruitMap.get(id);
    }

    @Override
    public void remove(int id) {
        fruitMap.remove(id);
    }
}

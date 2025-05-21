package ss_10_DSA.bai_tap.quan_ly_trai_cay.service;

import ss_10_DSA.bai_tap.quan_ly_trai_cay.entity.Fruit;
import ss_10_DSA.bai_tap.quan_ly_trai_cay.repository.FruitRepository;
import ss_10_DSA.bai_tap.quan_ly_trai_cay.repository.IFruitRepository;

import java.util.List;

public class FruitService implements IFruitService {
    private static IFruitRepository fruitRepository = new FruitRepository();
    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public void add(Fruit fruit) {
     fruitRepository.add(fruit);
    }
}

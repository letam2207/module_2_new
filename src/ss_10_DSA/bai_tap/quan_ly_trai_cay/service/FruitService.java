package ss_10_DSA.bai_tap.quan_ly_trai_cay.service;

import ss_10_DSA.bai_tap.quan_ly_trai_cay.entity.Fruit;
import ss_10_DSA.bai_tap.quan_ly_trai_cay.repository.FruitRepository;
import ss_10_DSA.bai_tap.quan_ly_trai_cay.repository.IFruitRepository;

import java.util.List;

public class FruitService implements IFruitService {
    private static final IFruitRepository fruitRepository = new FruitRepository();

    public  List<Fruit> findAllByKeySet() {
        return  ((FruitRepository) fruitRepository).findAllByKeySet();
    }

    public  List<Fruit> findAllByEntrySet() {
        return ((FruitRepository) fruitRepository).findAllByEntrySet();
    }


    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public void add(Fruit fruit) {
        fruitRepository.add(fruit);
    }

    @Override
    public Fruit findById(int id) {
        return fruitRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        fruitRepository.remove(id);
    }

}

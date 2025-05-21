package ss_10_DSA.bai_tap.quan_ly_trai_cay.repository;

import ss_10_DSA.bai_tap.quan_ly_trai_cay.entity.Fruit;

import java.util.List;

public interface IFruitRepository {
    List<Fruit> findAll();

    void add(Fruit fruit);
}

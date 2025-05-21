package ss_10_DSA.bai_tap.quan_ly_trai_cay.service;

import ss_10_DSA.bai_tap.quan_ly_trai_cay.entity.Fruit;

import java.util.List;

public interface IFruitService {
    List<Fruit> findAll();

    void add(Fruit fruit);
}

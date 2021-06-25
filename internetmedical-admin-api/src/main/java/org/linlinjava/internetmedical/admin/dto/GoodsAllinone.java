package org.linlinjava.internetmedical.admin.dto;

import org.linlinjava.internetmedical.db.domain.InternetmedicalGoods;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoodsAttribute;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoodsProduct;
import org.linlinjava.internetmedical.db.domain.InternetmedicalGoodsSpecification;

public class GoodsAllinone {
    InternetmedicalGoods goods;
    InternetmedicalGoodsSpecification[] specifications;
    InternetmedicalGoodsAttribute[] attributes;
    InternetmedicalGoodsProduct[] products;

    public InternetmedicalGoods getGoods() {
        return goods;
    }

    public void setGoods(InternetmedicalGoods goods) {
        this.goods = goods;
    }

    public InternetmedicalGoodsProduct[] getProducts() {
        return products;
    }

    public void setProducts(InternetmedicalGoodsProduct[] products) {
        this.products = products;
    }

    public InternetmedicalGoodsSpecification[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(InternetmedicalGoodsSpecification[] specifications) {
        this.specifications = specifications;
    }

    public InternetmedicalGoodsAttribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(InternetmedicalGoodsAttribute[] attributes) {
        this.attributes = attributes;
    }

}

package com.csy.lambda.lambdashare;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>Description：</p>
 *
 * @author shuyun.cheng
 * @date 2020/10/28 20:55
 */
public class ConstructMethodRefTest {
    public static void main(String[] args) {
        ItemCreatorBlankConstruct creator = () -> new Item();
        Item item = creator.getItem();

        ItemCreatorBlankConstruct creator2 = Item::new;
        Item item2 = creator2.getItem();

        ItemCreatorParamConstruct creator3 = Item::new;
        Item item3 = creator3.getItem(1, "深入理解Java虚拟机", 135.99);
    }

    interface ItemCreatorBlankConstruct {
        Item getItem();
    }

    interface ItemCreatorParamConstruct {
        Item getItem(int id, String name, double price);
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class Item {
    private Integer id;
    private String name;
    private Double price;
}

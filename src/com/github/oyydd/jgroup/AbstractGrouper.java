package com.github.oyydd.jgroup

import java.util.*;

abstract public class AbstractGrouper<Item> implements Grouper<Item>{

    private  <B> void appendGroupMap(Map<Object, Iterable<B>> map, Object key, B obj) {
        if (map.containsKey(key)) {
            ((LinkedList<B>) map.get(key)).add(obj);
        }
        else {
            List<B> list = new LinkedList<B>();
            list.add(obj);
            map.put(key, list);
        }
    }

    @Override
    public Iterable<Iterable<Item>> group(Iterable<Item> it, Object... obj) {
        Map<Object, Iterable<Item>> collect = new HashMap<Object, Iterable<Item>>();

        for (Item row : it) {
            appendGroupMap(collect, calHashObject(row, obj),  row);
        }
        return collect.values();
    }

    /**
     * 由子类实现的模板方法
     * 通过分组元信息(s) 判别是否同一组
     *
     * @param item 被分组的项
     * @param s 分组元信息
     * @return 若项为同一组，则此对象hashcode equals均相等, 即将其分为同一组
     */
    abstract protected Object calHashObject(Item item, Object... s);
}


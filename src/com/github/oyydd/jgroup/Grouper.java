package com.github.oyydd.jgroup

public interface Grouper<Item> {
    /**
     * @param it 需要分组的
     * @param sectionObj 分组标识对象
     * @return
     */
    Iterable<Iterable<Item>> group(Iterable<Item> it, Object... sectionObj);

}

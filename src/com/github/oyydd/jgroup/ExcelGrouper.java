package com.github.oyydd.jgroup

import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;

public class ExcelGrouper extends AbstractGrouper<Row> {

    protected Object calHashObject(Row row, Object... colNums) {
        ArrayList<Object> groupByCells = new ArrayList<Object>();
        for (Object colNum : colNums) {
            groupByCells.add(row.getCell((Integer) colNum).toString());
        }
        return groupByCells;
    }
}

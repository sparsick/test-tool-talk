package com.github.sparsick.test.tool.concurrency;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyDemo {
    // Pseudo Concurrency

    private boolean newItem = false;

    private List<String> items = new ArrayList<>();

    void addItem (String item) {
        newItem = false;
        try {
            Thread.sleep(10000);
            items.add(item);
            newItem = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    boolean hasNewItem(){
        return newItem;
    }

    List<String> allItems() {
        return items;
    }
}

package com.gildedrose.exceptions;

public class UnknownItemTypeExceptions extends Exception {

    public UnknownItemTypeExceptions(String type) {
        super("Unknown item type: " + type);
    }

}

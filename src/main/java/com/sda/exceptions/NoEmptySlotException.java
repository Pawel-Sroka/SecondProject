package com.sda.exceptions;

public class NoEmptySlotException extends Exception{
    public NoEmptySlotException() {
        super("no moge room for items");
    }
}
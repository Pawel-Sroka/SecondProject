package com.sda.exceptions;

public class NoEmptySlotException extends Exception{
    public NoEmptySlotException() {
        super("No more room for items");
    }
}

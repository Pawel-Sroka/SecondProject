package com.sda.listners;

import com.sda.exceptions.GameOverException;
import com.sda.exceptions.InvalidTypeException;
import com.sda.exceptions.NoEmptySlotException;
import com.sda.mode.FightMode;
import com.sda.model.characters.Warior;
import com.sda.model.inventory.Food;
import com.sda.model.inventory.InventoryObject;
import com.sda.model.inventory.Weapon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sda.serwice.Game.*;

public class MoveListner extends JFrame implements KeyListener {

    public MoveListner() throws HeadlessException {
        super("hello");
        addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
       char key = e.getKeyChar();
       String keyString = Character.toString(key).toUpperCase();



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



}

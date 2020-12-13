package com.sda.model.characters;

import com.sda.exceptions.GameOverException;

public interface Vunerable {
    void recieveDamage (int points) throws GameOverException;

}

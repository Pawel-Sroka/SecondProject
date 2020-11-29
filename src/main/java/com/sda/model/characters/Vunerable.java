package com.sda.model.characters;

import com.sda.model.exceptions.GameOverException;

public interface Vunerable {
    void recieveDamage (int points) throws GameOverException;

}

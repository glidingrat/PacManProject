package UNITtest;

import Entities.Player;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Test {

    private Player player;

    {
        try {
            player = new Player(30, 30, 30, 30);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @org.junit.jupiter.api.Test
    public void testUpdatePosition_Left() {
        player.setLeft(true);
        player.updatePosition();

        int expectedX = 30; // The x-position should remain unchanged since gameMap does have wall (tile 5) to the left
        int expectedY = 30; // The y-position should remain unchanged

        assertEquals(expectedX, player.getX());
        assertEquals(expectedY, player.getY());
    }

    @org.junit.jupiter.api.Test
    public void testUpdatePosition_Up() {
        player.setUp(true);
        player.updatePosition();

        int expectedX = 30; // The x-position should remain unchanged
        int expectedY = 30; // The y-position should remain unchanged since gameMap does have wall (tile 5) above

        assertEquals(expectedX, player.getX());
        assertEquals(expectedY, player.getY());
    }


    @org.junit.jupiter.api.Test
    public void testUpdatePosition_Right() {
        player.setRight(true);
        player.updatePosition();

        int expectedX = 31; // Since the speed is 1 and the gameMap does not have wall (tile 5) to the right
        int expectedY = 30; // The y-position should remain unchanged

        assertEquals(expectedX, player.getX());
        assertEquals(expectedY, player.getY());
    }

    @org.junit.jupiter.api.Test
    public void testUpdatePosition_Down() {
        player.setDown(true);
        player.updatePosition();

        int expectedX = 30; // The x-position should remain unchanged
        int expectedY = 31; // Since the speed is 1 and the gameMap does not have wall (tile 5) below

        assertEquals(expectedX, player.getX());
        assertEquals(expectedY, player.getY());
    }

    @org.junit.jupiter.api.Test
    public void testCoinAdd_ScoreIncreased() {
        player.setX(390); // sets the position on coin tile 1
        player.setY(30);
        player.coinAdd();

        int expectedScore = 1; // The player collects a coin at position (1, 13) on the gameMap

        assertEquals(expectedScore, player.getScore());
    }

    @org.junit.jupiter.api.Test
    public void testCoinAdd_ScoreNotIncreased() {
        player.setX(30); // sets the position on path tile 0
        player.setY(30);
        player.coinAdd();

        int expectedScore = 0; // The player does not collect a coin at position (1, 1) on the gameMap

        assertEquals(expectedScore, player.getScore());
    }
}

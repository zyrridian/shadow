package com.example.entity;

import com.example.common.GamePanel;
import com.example.common.KeyHandler;
import java.awt.Color;
import java.awt.Graphics2D;

public class Player extends Entity {
    
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update() {
        if (keyHandler.upPressed == true) {
            y -= speed;
        } else if (keyHandler.downPressed == true) {
            y += speed;
        } else if (keyHandler.leftPressed == true) {
            x -= speed;
        } else if (keyHandler.rightPressed == true) {
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
    }

}

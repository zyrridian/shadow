package com.example.entity;

import com.example.common.GamePanel;
import com.example.common.KeyHandler;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Entity {
    
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up0 = ImageIO.read(getClass().getResourceAsStream("/player/mc_walk_up_0.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/mc_walk_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/mc_walk_up_2.png"));
            down0 = ImageIO.read(getClass().getResourceAsStream("/player/mc_walk_down_0.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/mc_walk_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/mc_walk_down_2.png"));
            left0 = ImageIO.read(getClass().getResourceAsStream("/player/mc_walk_left_0.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/mc_walk_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/mc_walk_left_2.png"));
            right0 = ImageIO.read(getClass().getResourceAsStream("/player/mc_walk_right_0.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/mc_walk_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/mc_walk_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyHandler.upPressed == true || keyHandler.downPressed == true || keyHandler.leftPressed || keyHandler.rightPressed) {
            if (keyHandler.upPressed == true) {
                direction = "up";
                y -= speed;
            } else if (keyHandler.downPressed == true) {
                direction = "down";
                y += speed;
            } else if (keyHandler.leftPressed == true) {
                direction = "left";
                x -= speed;
            } else if (keyHandler.rightPressed == true) {
                direction = "right";
                x += speed;
            }
            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNumber == 1) {
                    spriteNumber = 2;
                } else if (spriteNumber == 2) {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (spriteNumber == 1) { image = up1; }
                if (spriteNumber == 2) { image = up2; }
                break;
            case "down":
                if (spriteNumber == 1) { image = down1; }
                if (spriteNumber == 2) { image = down2; }
                break;
            case "left":
                if (spriteNumber == 1) { image = left1; }
                if (spriteNumber == 2) { image = left2; }
                break;
            case "right":
                if (spriteNumber == 1) { image = right1; }
                if (spriteNumber == 2) { image = right2; }
                break;
        }
        g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }

}

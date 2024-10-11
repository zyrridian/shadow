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
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                image = up0;
                break;
            case "down":
                image = down0;
                break;
            case "left":
                image = left0;
                break;
            case "right":
                image = right0;
                break;
        }
        g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }

}

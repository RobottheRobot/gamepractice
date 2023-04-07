package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Tanks extends Sprite {
    public Tanks(){
        //constructor
        Texture texture= new Texture(Gdx.files.internal("Tiger_export/merged/german_tiger_merged1.png"));
        Sprite tank = new Sprite(texture);
    }

    public void update(float mouseX, float mouseY) {
        // Calculate the angle between the tank and the mouse position
        Double angle = (float) Math.atan2(mouseY - getY(), mouseX - getX()) * 180 / Math.PI;

        System.out.println(angle);
    }
}

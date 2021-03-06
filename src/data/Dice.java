/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Random;

/**
 *
 * @author nbp184
 */
public class Dice {
    
    private static final Random rand = new Random();
    
    public final int amount;
    public final int sides;
    public final int modifier;
    
    public Dice(int amount, int sides, int modifier) {
        this.amount = amount;
        this.sides = sides;
        this.modifier = modifier;
    }
    
    public int roll() {
        int result = modifier;
        for(int i = 0; i < amount; i++) {
            result += rand.nextInt(sides) + 1;
        }
        return result;
    }
    
    @Override
    public String toString() {
        return amount+"d"+sides+"+"+modifier;
    }
    
}

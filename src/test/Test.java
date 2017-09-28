/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author nbp184
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String rv = "";
        for(int i = 0; i < 3; i++) {
            rv += (char)(Math.random()*26 + 'a');
        }
        System.out.println(rv);
    }
    
}

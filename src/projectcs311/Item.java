/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectcs311;

/**
 *
 * @author NorahAbdullah
 */
public class Item {
     int value;
    int weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public double ratio() {
        return (double) value / weight;
    }

    
}

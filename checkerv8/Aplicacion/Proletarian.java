package Aplicacion;

import Presentacion.*;
/**
 * Creates a dama of type "Proletarian", this "Proletarian" dies when it becomes king
 * 
 * @author Alayon Molina
 * @author Castro Ortega
 * @version 1.0
 */
public class Proletarian implements Dama
{
    private Triangle prole;
    private boolean isProle;
    private int xPosition;
    private int yPosition;
    private Circle circulo;
    private boolean isKing;
    private King fichaKing;
    
    /**
     * Constructor for objects of class Proletarian
     */
    public Proletarian()
    {
        // initialise instance variables
        isKing = false;
        circulo = new Circle();
        isProle = true;
        prole = new Triangle();
        prole.moveTriangle(xPosition + 15, yPosition + 5);
        prole.changeColor("blue");
    }
    /**
     * Makes the Proletarian into a King, therefore it dies
     */
    public boolean makeKing(){
        circulo.makeInvisible();
        prole.makeInvisible();
        return false;

    }
    
    
    /**
     * Make this circle visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        circulo.makeVisible();
        prole.makeVisible();
        
    }
    
    /**
     * Make this circle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        
        prole.makeInvisible();
        circulo.makeInvisible();
    }
    
    /**
     * Changes the position of the proletarian
     * @param x position X
     * @param y position Y
     */
    public void changePosition(int x, int y){
        circulo.changePosition(x,y);
        prole.moveTriangle(x + 15, y + 5);
        
    }
    /**
     * Changes the permanent color of the proletarian
     * @param nuevoColor the new permanent color of the proletarian. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColorFijo(String nuevoColor){
        circulo.changeColorFijo(nuevoColor);
        prole.makeVisible();
        
        
        
    } 
    
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        circulo.changeColor(newColor);
        prole.makeVisible();
    }
    
    @Override
    
    public  boolean debeContinuar(){
        return true;
    
    }
    
    /**
     * Returns if the dama is King or not
     * @return isKing true if the dama is King, false if not is King
     */
    public boolean getIsKing(){
        return isKing;
    
    }
    
    /**
     * Returns color of the dama
     * @return color the color of the dama
     */
    public String getColor(){
        
        return circulo.getColor();
    
    }
    
    /**
     * Returns the position y of the dama
     * @return PositionY the position y of the dama
     */
    public int getPositionY(){
        
        return circulo.getPositionY();
    
    }
    /**
     * Returns the position x of the dama
     * @return PositionX the position x of the dama
     */
    public int getPositionX(){
        
        return circulo.getPositionX();
    
    }
    
    /**
     * Returns the permanent color of the dama
     * @return ColorFijo the permanent color of the dama
     */
    public String  getColorFijo(){
        return circulo.getColorFijo();
    
    }
    
    @Override
    
    public  boolean debeComer(){
        return true;
    
    }
    
    @Override
    
    public  boolean debeTraicionar(){
        return false;
    
    }
    
    @Override
    
    public  boolean debeSaltarOtraVez(){
        return false;
    
    }
    
    @Override
    
    public  boolean puedeSerComido(){
        return true;
    
    }
    
}

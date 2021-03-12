package Aplicacion;

import Presentacion.*;
/**
 * Creates a dama of type "Lazy", this "Lazy" in one move will only jump once
 * 
 * @author Alayon Molina
 * @author Castro Ortega
 * @version 1.0
 */
public class Lazy implements Dama
{
    private Triangle lazyTr;
    private boolean isLazy;
    private int xPosition;
    private int yPosition;
    private Circle circulo;
    private boolean isKing;
    private King fichaKing;
    
    /**
     * Constructor for objects of class Lazy
     */
    public Lazy()
    {
        // initialise instance variables
        isKing = false;
        circulo = new Circle();
        isLazy = true;
        lazyTr = new Triangle();
        lazyTr.moveTriangle(xPosition + 15, yPosition + 5);
        lazyTr.changeColor("red");
        
        
    }

    /**
     * Make this circle visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        circulo.makeVisible();
        lazyTr.makeVisible();
        
        
    }
    
    /**
     * Make this circle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        
        lazyTr.makeInvisible();
        circulo.makeInvisible();
    }
    
    /**
     * Changes the position of the lazy
     * @param x position X
     * @param y position Y
     */
    public void changePosition(int x, int y){
        circulo.changePosition(x,y);
        lazyTr.moveTriangle(x + 15, y + 5);
        
    }
    /**
     * Changes the permanent color of the lazy
     * @param nuevoColor the new permanent color of the lazy. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColorFijo(String nuevoColor){
        circulo.changeColorFijo(nuevoColor);
        lazyTr.makeVisible();
        
        
        
    } 
    
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        circulo.changeColor(newColor);
        lazyTr.makeVisible();
    }
    
    @Override
    
    public  boolean debeContinuar(){
        return false;
    
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
    
    /**
     * Makes the dama into a King
     */
    public boolean makeKing(){
        if(isKing == false){
            isKing = true;
            fichaKing = new King(getPositionX(), getPositionY());
            
            
        }
        return true;
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

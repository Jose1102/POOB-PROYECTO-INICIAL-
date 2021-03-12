package Aplicacion;

import Presentacion.*;
/**
 * Creates a dama of type "Hurried", this "Hurried" will repeat the movement if can be, 
 * 
 * @author Alayon Molina
 * @author Castro Ortega
 * @version 1.0
 */
public class Hurried implements Dama
{
    private Rectangle hurried;
    private boolean isHurried;
    private int xPosition;
    private int yPosition;
    private Circle circulo;
    private boolean isKing;
    private King fichaKing;
    
    /**
     * Constructor for objects of class Hurried
     */
    public Hurried()
    {
        // initialise instance variables
        
        isKing = false;
        circulo = new Circle();
        isHurried = true;
        hurried = new Rectangle();
        hurried.changeSize(10,10);
        hurried.moveP(xPosition+10, yPosition+10);
        hurried.changeColor("blue");
    }
    /**
     * Make this hurried visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        circulo.makeVisible();
        hurried.makeVisible();
        
    }

    /**
     * Make this hurried invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        hurried.makeInvisible();
        circulo.makeInvisible();
    }
    /**
     * Changes the position of the hurried
     * @param x position X
     * @param y position Y
     */
    
    public void changePosition(int x, int y){
        circulo.changePosition(x,y);
        hurried.moveP(x+10, y+10);
        
    }
    /**
     * Changes the permanent color of the hurried
     * @param nuevoColor the new permanent color of the hurried. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColorFijo(String nuevoColor){
        circulo.changeColorFijo(nuevoColor);
        hurried.makeVisible();

    } 
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        circulo.changeColor(newColor);
        hurried.makeVisible();
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
        return true;
    
    }
    
    @Override
    
    public  boolean puedeSerComido(){
        return true;
    
    }
}
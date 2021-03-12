package Aplicacion;
import Presentacion.*;
import java.util.ArrayList;

/**
 * Write a description of class Token here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Token implements Dama
{
    // instance variables - replace the example below with your own
    public Circle circulo;
    private boolean isKing;
    private King fichaKing;
    private boolean isProletariano;

    /**
     * Constructor for objects of class Token
     */
    public Token()
    {
        circulo = new Circle();
        isKing = false;
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
    /**
     * Make this dama visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        circulo.makeVisible();
        if(isKing){
            fichaKing.makeVisible();
        
        }

    }
    
    /**
     * Make this dama invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        circulo.makeInvisible();
        if(isKing){
            fichaKing.makeInvisible();
        
        }
        
    }
    
    /**
     * Returns the permanent color of the dama
     * @return ColorFijo the permanent color of the dama
     */
    public String  getColorFijo(){
        return circulo.getColorFijo();
    
    }
    /**
     * Returns the position x of the dama
     * @return PositionX the position x of the dama
     */
    public int getPositionX(){
        
        return circulo.getPositionX();
    
    }
    /**
     * Returns the position y of the dama
     * @return PositionY the position y of the dama
     */
    public int getPositionY(){
        
        return circulo.getPositionY();
    
    }
    /**
     * Returns color of the dama
     * @return color the color of the dama
     */
    public String getColor(){
        
        return circulo.getColor();
    
    }
    /**
     * Changes the permanent color of the dama
     * @param nuevoColor the new permanent color of the dama. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColorFijo(String nuevoColor){
        circulo.changeColorFijo(nuevoColor);
        if(isKing){
            fichaKing.makeVisible();
        }
    } 
    
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        circulo.changeColor(newColor);
        if(isKing){
            
            fichaKing.makeVisible();
        
        }
    }
    /**
     * Changes the position of the dama
     * @param x position X
     * @param y position Y
     */
    public void changePosition(int x, int y){
        circulo.changePosition(x,y);
        
        if(isKing){
            fichaKing.changePosition(x,y);
            fichaKing.makeVisible();
        
        }
    }
    /**
     * Returns if the dama is King or not
     * @return isKing true if the dama is King, false if not is King
     */
    public boolean getIsKing(){
        return isKing;
    
    }
    @Override
    
    public  boolean debeContinuar(){
        return true;
    
    }
    
    @Override
    
    public  boolean debeTraicionar(){
        return false;
    
    }
    
    @Override
    
    public  boolean debeComer(){
        return true;
    
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

package Aplicacion;

import Presentacion.*;
import java.util.ArrayList;
/**
 * Creates a dama that can be manipulated.
 * 
 * @author Alayon Molina
 * @author Castro Ortega
 * @version 1.0
 */
public interface  Dama 
{
    // instance variables - replace the example below with your own
    
    
    /**
     * Makes the dama into a King
     */
    public abstract boolean makeKing();
        
    
    /**
     * Make this dama visible. If it was already visible, do nothing.
     */
    public abstract void makeVisible();
       

    
    
    /**
     * Make this dama invisible. If it was already invisible, do nothing.
     */
    public abstract void makeInvisible();
        
    
    
    /**
     * Returns the permanent color of the dama
     * @return ColorFijo the permanent color of the dama
     */
    public abstract String  getColorFijo();
        
    
    /**
     * Returns the position x of the dama
     * @return PositionX the position x of the dama
     */
    public abstract int getPositionX();
       
    /**
     * Returns the position y of the dama
     * @return PositionY the position y of the dama
     */
    public abstract int getPositionY();
    /**
     * Returns color of the dama
     * @return color the color of the dama
     */
    public abstract String getColor();
    /**
     * Changes the permanent color of the dama
     * @param nuevoColor the new permanent color of the dama. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public abstract void changeColorFijo(String nuevoColor);
    
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public abstract void changeColor(String newColor);
    /**
     * Changes the position of the dama
     * @param x position X
     * @param y position Y
     */
    public abstract void changePosition(int x, int y);
    
    /**
     * Returns if the dama is King or not
     * @return isKing true if the dama is King, false if not is King
     */
    public abstract boolean getIsKing();
        
    public abstract boolean debeContinuar();
    
    
    public abstract boolean debeComer();
 
    
    public abstract boolean debeTraicionar();
    
    public abstract boolean debeSaltarOtraVez();
    
    public abstract boolean puedeSerComido();
}

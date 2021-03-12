package Aplicacion;

import Presentacion.*;
/**
 * Creates a dama of the type King.
 * 
 * @author Alayon Molina
 * @author Castro Ortega
 * @version 1.0
 */
public class King {
    private Triangle King;
    private boolean isKing;
    private int xPosition;
    private int yPosition;
    
    /**
     * Constructor for objects of class King
     */
    public King(int xPosition, int yPosition)
    {
        // initialise instance variables
        
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        isKing = true;
        King = new Triangle();
        King.moveTriangle(xPosition + 15, yPosition + 5);
    }
    /**
     * Make this king visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        
        King.makeVisible();
        
    }
    
    /**
     * Make this king invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        
        King.makeInvisible();
    }
    
    /**
     * Changes the position of the King
     * @param x position X
     * @param y position Y
     */
    public void changePosition(int x, int y){
        King.moveTriangle(x + 15, y + 5);
    }
    

}
package Aplicacion;

import Presentacion.*;
/**
 * Creates a dama of type "Traidora", this "Traidora" will change color when jumping another dama.
 * 
 * @author Alayon Molina
 * @author Castro Ortega
 * @version 1.0
 */
public class Traidora implements Dama
{
    private Rectangle traidora;
    private boolean isTraidora;
    private int xPosition;
    private int yPosition;
    private Circle circulo;
    private boolean isKing;
    private King fichaKing;
    
    /**
     * Constructor for objects of class "Traidora"
     */
    public Traidora()
    {
        isKing = false;
        circulo = new Circle();
        isTraidora = true;
        traidora = new Rectangle();
        traidora.changeSize(10,10);
        traidora.moveP(xPosition+10, yPosition+10);
        traidora.changeColor("yellow");
    }
    /**
     * Make this Traidora visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        circulo.makeVisible();
        traidora.makeVisible();
        
    }
    /**
     * Make this Traidora invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        
        traidora.makeInvisible();
        circulo.makeInvisible();
    }
    
    /**
     * Changes the position of the Traidora
     * @param x position X
     * @param y position Y
     */
    public void changePosition(int x, int y){
        circulo.changePosition(x,y);
        traidora.moveP(x+10, y+10);
        
    }
    /**
     * Changes the permanent color of the Traidora
     * @param nuevoColor the new permanent color of the Traidora. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColorFijo(String nuevoColor){
        circulo.changeColorFijo(nuevoColor);
        traidora.makeVisible();

    } 
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        circulo.changeColor(newColor);
        traidora.makeVisible();
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
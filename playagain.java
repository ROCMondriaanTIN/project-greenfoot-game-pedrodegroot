import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playagain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playagain extends Mover
{
    /**
     * Act - do whatever the playagain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean firstTrun = true;
    public void act() 
    {
       
      if(Greenfoot.mouseClicked(this)||Greenfoot.isKeyDown("space")){
      
          Greenfoot.setWorld(new MyWorld());
         
    }    
}}


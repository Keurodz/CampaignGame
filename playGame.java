import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playGame extends Actor
{
    /**
     * Act - do whatever the playGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        select();
       
    }   
    public void select()
    {
        if ( Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld( new MyWorld());
        }
    }
}

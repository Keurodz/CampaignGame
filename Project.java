import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Project here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Project extends Actor
{
    int speed = 15;
    int cost = 75;
    public Project()
    {
        getImage().scale(30,30);
    }
    public int getCost()
    {
        return cost;
    }
    public void setCost( int a )
    {
        cost = a;
    }
    /**
     * Act - do whatever the Project wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        move(speed);
        despawn();
    }    
    
    public void despawn()
    {
        if (isAtEdge() )
        {
            getWorld().removeObject(this); 
        }
        
    }
    
    public void turnToMouse()
    {
        turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }
}

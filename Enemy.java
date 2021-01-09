import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    int health = 20;
    int damage = 5;
    public void setDamage( int dam)
    {
        damage = dam;
    }
    public int getDamage()
    {
        return damage;
    }
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        chase(1);
        getHit();
    }    
    public void chase(int a)
    {
        Actor player = (Actor)getWorld().getObjects(Player.class).get(0);
        turnTowards(player.getX(), player.getY());
        move(a);
    }
    public void getHit()
    {
        if( isTouching(Project.class))
        {
            removeTouching(Project.class);
            health -= 10;
            if(health <= 0)
            {
                getWorld().removeObject(this);
            }
        }
    }
}

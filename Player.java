import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int health = 100;
    int mana = 20;
    int manaMax = 2000;
    boolean shooting = false;
    public void setMana( int a )
    {
        mana = a;
    }
    public int getHealth()
    {
        return health;
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        moveControl();
        fireProjectile();
        
        
    }    
        
    public void getHit()
    {
        if( isTouching(Enemy.class))
        {
            Enemy enemy;
            enemy = getIntersectingObjects(Enemy.class).get(0);
            health -= enemy.getDamage();
            
             
            if(health <= 0)
            {
                getWorld().removeObject(this);
            }
        }
    }
    public int getMana()
    {
        return mana;
    }
    
    private void fireProjectile()
    {
        if (mana > 0 )
        {
            if(Greenfoot.mousePressed(null) && Greenfoot.getMouseInfo().getButton() == 1)
            {  
                shooting = true;
                Project project = new Project();
                getWorld().addObject(project, getX(), getY());
                project.turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
                mana -= 75;
            }
            else shooting = false;
        }
        
    }

    

    private void moveControl()
    {
        if ( wm() )
        {
            if ( Greenfoot.isKeyDown("a") )
               { setLocation( getX()-5, getY()); 
                   if ( mana < manaMax) mana++;}
                
            if ( Greenfoot.isKeyDown("w") )
               { setLocation( getX(), getY()-5);if ( mana < manaMax) mana++;}
            if ( Greenfoot.isKeyDown("s") )
               { setLocation( getX(), getY()+5);if ( mana < manaMax) mana ++;}
            if ( Greenfoot.isKeyDown("d") )
               { setLocation( getX()+5, getY());if ( mana < manaMax) mana++;}
        }
        ;
    }

    private boolean wm()
    {
        if ( Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("d") )
            return true;
        else return false;
    }
}

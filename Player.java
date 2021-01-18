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
    int speed = 5;
    int hitStun = 60;
    int tspx, tspy;
    boolean dead = false;
    public void setMana( int a )
    {
        mana = a;
    }
    public boolean getDead()
    {
        return dead;
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
        getHit();
        collide();
        
    }    

    public void getHit()
    {
        if ( hitStun == 0)
        {
            if( isTouching(Enemy.class))
            {
                Enemy enemy;
                enemy = getIntersectingObjects(Enemy.class).get(0);
                health -= enemy.getDamage();
                hitStun = 60;
                if(health <= 0)
                {
                    getWorld().removeObject(this);
                    dead = true;
                }
            }
        }
        else hitStun--;
    }

    public int getMana()
    {
        return mana;
    }
    public void collide()
    {
        if (isTouching(Actor.class))
        {
            setLocation( getX()+tspx, getY()+tspy);
            
        }
        
    }
    private void fireProjectile()
    {
        if (mana > 0 )
        {
            if(Greenfoot.mousePressed(null) && Greenfoot.getMouseInfo().getButton() == 1)
            {  
                
                
                Project project = new Project();
                if( mana >= project.getCost())
                {
                getWorld().addObject(project, getX(), getY());
                project.turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
                mana -= 75;
            }
                
            }
            
        }

    }


    private void moveControl()
    {
        if ( wm() )
        {
            if ( Greenfoot.isKeyDown("a") )
            { setLocation( getX()-speed, getY()); 
              tspx = 10;
                }

            if ( Greenfoot.isKeyDown("w") )
            { setLocation( getX(), getY()-speed);tspy = 10;}
            if ( Greenfoot.isKeyDown("s") )
            { setLocation( getX(), getY()+speed);tspy = -10;}
            if ( Greenfoot.isKeyDown("d") )
            { setLocation( getX()+speed, getY()); tspx = -10;}
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

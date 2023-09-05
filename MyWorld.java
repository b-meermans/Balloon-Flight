import greenfoot.*;  
public class MyWorld extends World
{
    public MyWorld()
    {    
        super(800, 600, 1, false); 
        addObject(new Balloon(200, 1, "1", "balloon.png"), 200, 300);
        
        
        addObject(new Mountains(), 400, 300);
        
        var b3 = new Balloon();
        addObject(b3, 500, 375);
        b3.setImage("balloon3.png");
        b3.setUpKey("3");
        b3.setSpeed(0.6);
        
        
        var b2 = new Balloon();
        addObject(b2, 400, 150);
        b2.setImage("balloon2.png");
        b2.setUpKey("2");
        b2.setSpeed(1.2);
    }
}

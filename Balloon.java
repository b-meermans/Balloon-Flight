import greenfoot.*;


// Step 3 - SmoothMover
public class Balloon extends SmoothMover
{
    private String upKey = "space";
    private double speed = 1;
    private double fuel = 1000;
    private double velocity = 0.0;
    
    
    // Step 1
    public void act1() {
        move(1);
        // Add move based on y coordinate - faster movement higher up
        // getY() tells current movement, but that means super fast values
        // 600 - getY() can have faster speeds higher up
        // (600 - getY()) / 100, 200, 300, 500, etc will slow down
        // But eventually we stop moving...why?
        // Let's try printing our result
        // Introduce printing values
        // Print both y coordinate and calculation
        // Why is it that when our ys are below ?, the calculation becomes 0?
        // Wait, why are all our calculations coming out as integers?
        // Let's try something simple: print some basic calculations
        // How do we get decimals?
        // How do we fix this whole thing?
        if (isAtEdge()) {
            setLocation(0, getY());
        }
    }
    

    
    
    // Step 2
    public void act2()
    {
        if (Greenfoot.isKeyDown("space")) {
            setLocation(getX(), getY() - 2);
        } else {
            setLocation(getX(), getY() + 1);
        }
        
        move(1);
        
        if (isAtEdge()) {
            setLocation(0, getY());
        }
    }
    
        
    // Step 2.2 - Uh oh! Teleporting at bottom / top of screen!
    public void act2_1() {
        if (Greenfoot.isKeyDown("space")) {
            setLocation(getX(), getY() - 2);
        } else { 
            setLocation(getX(), getY() + 1);
        }
        move(1);
        
        if (getX() >= 799) {
            setLocation(0, getY());
        }
    }
    
    
    // Step 3 - Falling seems too fast...but we can't fall a decimal amount!
    public void act3()
    {
        if (Greenfoot.isKeyDown("space")) {
            setLocation(getX(), getExactY() - 2);
        } else { 
            setLocation(getX(), getExactY() + 0.2);
        }
        move(1);
        
        if (getX() >= 850) {
            setLocation(0, getY());
        }
    }
    
    // Step 3.1 - Make world unbounded so we can go up and up!
    
    
    
    // Step 4 - Individualize each balloon's controls
    
    // Step 4.1 - Add a 'fuel' level, start it at 100 and make it go down by 1 each time the key is pressed
    // Stop allowing fuel to be used after that.
    
    // Step 4.2 - Add a way for fuel to be individualized, so each Balloon can set its fuel
    // Step 4.3 - Add a way for the forward speed of each balloon to be individualized
    // Step 4.4 - Add a way for each key to be individualized
    public void act4()
    {
        if (fuel >= 0 && Greenfoot.isKeyDown(upKey)) {
            setLocation(getExactX(), getExactY() - 2);
            fuel--;
        } else {
            setLocation(getExactX(), getExactY() + 0.2);
        }
        move(speed);
        
        if (getExactX() >= 900) {
            setLocation(-100, getExactY());
        }
    }
        
    public void setFuelLevel(double fuel) {
        this.fuel = fuel;
    }
    
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    public void setUpKey(String upKey) {
        this.upKey = upKey;
    }
    
    public void act() {
        
        if (fuel >= 0 && Greenfoot.isKeyDown(upKey)) {
            setLocation(getExactX(), getExactY() - 2);
            fuel--;
        } else if (getExactY() > getWorld().getHeight() - getImage().getHeight() / 2) {
            return;
        } else {
            setLocation(getExactX(), getExactY() + 0.2);
        }
            
        velocity += (getWorld().getHeight() - getY()) / 1000.0;
        velocity *= 0.8;
        move(velocity);
        
        if (getExactX() > 900) {
            setLocation(-100, getExactY());
        }
        
        if (getExactX() < -100) {
            setLocation(900, getExactY());
        }
    }
    
    // Step 4.5 - Add a way to customize all of the values at once
    public void setValues(double fuel, double speed, String upKey) {
        this.fuel = fuel;
        this.speed = speed;
        this.upKey = upKey;
    }
    // Step 4.6 - Discuss problems with this! (What if we want to change the number of variables we track later?)
    
    
    // Step 5 - Super annoying to keep adding calls to the World for each Balloon, let's simplify that!
    // Create constructor(s)
    
    // Show what the hidden, default constructor looks like
    
    // If you write this constructor yourself, you can customize what it does. It is then called the 'No arguments' constructor
    public Balloon() {
        fuel = 1000;
        speed = 1;
        upKey = "space";
    }
    
    // But, you can also create additional constructors.
    public Balloon(double initialFuel, double initialSpeed, String upKey, String filename) {
        fuel = initialFuel;
        speed = initialSpeed;
        this.upKey = upKey;
        setImage(filename);
    }
    // This has the same problem as the setValues - that if we want to change the number of fields later, we may need to adjust this constructor add additional ones
    // Beyond the current scope - but one solution for this is called the Builder Pattern
    
    
    
}

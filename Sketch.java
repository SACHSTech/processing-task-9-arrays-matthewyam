import processing.core.PApplet;

public class Sketch extends PApplet {
	
  float[] circleY = new float[25];
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
    for (int i = 0; i < circleY.length; i++) {
      circleY[i] = random(height);
    }
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  

    
    background(210, 255, 173);
    
    ball();
    
    fill(255,255,255);
    for (int i = 0; i < circleY.length; i++) {
      float circleX = width * i / circleY.length;
      ellipse(circleX, circleY[i], 25, 25);
  
      circleY[i]++;
  
      if (circleY[i] > height) {
        circleY[i] = 0;
      }

      if (keyPressed){
        if (keyCode == UP){
          circleY[i] -= 0.5;
        }
        
        if (keyCode == DOWN){
          circleY[i] += 2;
        }
      }
    }
    
    
  }

  public void ball(){
    float ballUp = 0;
    float ballDown = 0;
    float ballLeft = 0;
    float ballRight = 0;

    
    fill(0,0,255);
    ellipse(200, 200, 20, 20);


  }
}
  

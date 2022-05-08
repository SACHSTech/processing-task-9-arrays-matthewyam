import processing.core.PApplet;

public class Sketch extends PApplet {
	
  float[] circleY = new float[10];
  float[] circleX = new float[10];
  boolean[] snow = new boolean[10];
	
  boolean blooUp = false;
  boolean blooDown = false;
  boolean blooLeft = false;
  boolean blooRight = false;
  

  float blooX = 200;
  float blooY = 200; 
  int fallSpeed = 2;

  float health = 90;
  float healthCap = 90;
  float squareW = 90;
  float dist;  

  public void settings() {
    size(400, 400);
    
  }

 
  public void setup() {
    background(210, 255, 173);
    for (int i = 0; i < circleY.length; i++) {
      circleY[i] = random(height);
      circleX[i] = random(width);
      snow[i] = true;
    }
    
  }

  

  public void draw() {
    
    background(210, 255, 173);
    
    ball();
    
    rain();
   
    moveBall();
    
    hpBar();  

    if (health == 0){
      background(255,255,255);
      stop();
    }
    
  
  }

  public void rain(){
    
    fill(255,255,255);
      for (int i = 0; i < circleY.length; i++) {
        if (snow[i] == true){
        ellipse(circleX[i], circleY[i], 20, 20);
        }
      }
      for (int i = 0; i < circleY.length; i++) {
      circleY[i] += fallSpeed;

        if (circleY[i] > height) {
          circleY[i] = 0;
        }

        circleY[i] += fallSpeed;
      
          if (circleY[i] > height) {
            circleY[i] = 0;
          }

        if (dist(blooX, blooY, circleX[i], circleY[i]) <= (10) && (snow[i] == true)){
          health -= 30;
          snow[i] = false;
          }
        }
      }
    


  public void moveBall(){

    if(blooUp){
      blooY--;
    }
    if(blooDown){
      blooY++;
    }
    if(blooLeft){
      blooX--;
    }
    if(blooRight){
      blooX++;
    }  
  }

  public void ball(){
    fill(0,0,255);
    ellipse(blooX, blooY, 20, 20);
  }
  
  public void keyPressed(){
    if (key == 'w') {
      blooUp = true;
    } 
    else if (key == 's') {
      blooDown = true;
    } 
    else if(key == 'a'){
      blooLeft = true;
    }
    else if(key == 'd'){
      blooRight = true; 
    }
    
    
    if (keyCode == UP){
      fallSpeed = 1;
    }
        
    if (keyCode == DOWN){
      fallSpeed = 3;
      }

  }
  public void keyReleased(){
    if (key == 'w') {
      blooUp = false;
    } 
    else if (key == 's') {
      blooDown = false;
    } 
    else if(key == 'a'){
      blooLeft = false;
    }
    else if(key == 'd'){
      blooRight = false; 
    }

    if (keyCode == UP){
      fallSpeed = 2;
    }
        
    if (keyCode == DOWN){
      fallSpeed = 2;
      }
  }

  public void hpBar(){
    float drawWidth = (health / healthCap) * squareW;
    fill(255,0,0);
     rect(0, 0, drawWidth, 30);
 
   stroke(0);
   noFill();
   rect(0, 0, 30, 30);
   rect(0, 0, 60, 30);
   rect(0, 0, 90, 30);

  }

  

  
}

  

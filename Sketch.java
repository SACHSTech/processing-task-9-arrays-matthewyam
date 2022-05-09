import processing.core.PApplet;

public class Sketch extends PApplet {
	
  //Global Variables
  float[] circleY = new float[10];
  float[] circleX = new float[10];
  boolean[] snow = new boolean[20];
	
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
  boolean click = false;  


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
    
    //Calls methods
    ball();
    
    fall();
   
    moveBall();
    
    hpBar();  

    //Makes it so if the HP bar is zero, it turns the screen white and stops the program
    if (health == 0){
      background(255,255,255);
      stop();
    }
    
  
  }

  /**
   * Calls the snow fall with hit detection
   */
  public void fall(){
    
    //Creates the snow and makes it fall randomly
    fill(255,255,255);
      for (int i = 0; i < circleY.length; i++) {
        if (snow[i] == true){
        ellipse(circleX[i], circleY[i], 30, 30);
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
            snow[i] = true;
            circleX[i] = random(width);
          }
      
      //Detection if you get hit by snow
      if (dist(blooX, blooY, circleX[i], circleY[i]) <= (20) && (snow[i] == true)){
        health -= 30;
        snow[i] = false;
        }
      //Detection if you click on a piece of snow
      if(click && (dist(mouseX, mouseY, circleX[i], circleY[i]) <= (20))){
        snow[i] = false;
        }
      }
    }
    
/**
 * Controls used to move the blue ball
 */
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

/**
 * Draws the blue ball on screen
 */
  public void ball(){
    fill(0,0,255);
    ellipse(blooX, blooY, 20, 20);
  }
  

/**
 * Detects what key has been pressed
 */
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

/**
 * Detects what key has been released
 */
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

/** 
 * Draws the HP bar on screen
 */
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
  
  /**
   * Detects when mouse is pressed
   */
  public void mousePressed(){
    click = true;
  }

/** 
 * Detects when mouse is released
 */
  public void mouseReleased(){
    click = false;
}
  

  
}

  

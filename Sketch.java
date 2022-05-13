import processing.core.PApplet;

public class Sketch extends PApplet {
	
	float[] circleY = new float[10];
  float [] circleX =  new float [10];
  float ballY = 340;
  float ballX = 200;
  boolean [] ballHideStatus = new boolean [10];
  int health = 3;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);

    for (int x = 0; x < circleX.length; x++){
      circleX[x] = random(width);
      circleY[x] = random(height);
    }
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    for (int i = 0; i < circleY.length; i++) {
      ballHideStatus[i] = false;
    }
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
      background(0);

    for (int i = 0; i < circleY.length; i++) {
      if (ballHideStatus[i] == false){
        fill(255);
        ellipse(circleX[i], circleY[i], 25, 25);
        stroke(0);
  
      circleY[i]+=2;
 
      if (circleY[i] > height) {
        circleY[i] = 0;
      
    }else if(ballHideStatus[i] == true){
      fill(0);
      ellipse(circleX[i], circleY[i], 25, 25);
      stroke(0);
    }
    
    if ((ballX <= circleX[i] + 20) && (ballX >= circleX[i] - 20)){
      if((ballY <= circleY[i] + 20) && (ballY >= circleY[i] - 20)){
        health = health - 1;
        ballHideStatus[i] = true;

      }
    }
  
    if (mousePressed){
      if ((mouseX <= circleX[i] + 20) && (mouseX >= circleX[i] - 20)){
        if((mouseY <= circleY[i] + 20) && (mouseY >= circleY[i] - 20)){
          ballHideStatus[i] = true;
        }
      }
    }

  // Change snow speed
  if (keyPressed) {
    if (keyCode == UP) {
      circleY[i]--;
    } else if (keyCode == DOWN) {
      circleY[i]+=3;
    } else {
      circleY[i]+=2;
    }
   }
  }
  // Move ball
   if (keyPressed) {
    if (key == 'w') {
      ballY-=.3;
    } 
    else if (key == 'a') {
      ballX-=.3;
    } 
    else if(key == 's'){
      ballY+=.3;
    }
    else if(key == 'd'){
      ballX+=.3; 
      }
    } 
  }
// Draw blue circle
fill(0, 0, 255);
ellipse(ballX, ballY, 40, 40);

// Display health
if(health == 3){
  fill(240, 24, 24);
  rect(280, 10, 30, 30);
  rect(320, 10, 30, 30);
  rect(360, 10, 30, 30);

}else if(health == 2){
  fill(240, 24, 24);
  rect(320, 10, 30, 30);
  rect(360, 10, 30, 30);

}else if(health == 1){
  fill(240, 24, 24);
  rect(360, 10, 30, 30);

}else{
 background(255);
    }
  }
}
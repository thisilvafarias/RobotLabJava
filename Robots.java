/**  * * Robots * *    
 * 
 *
 * V 1.0 
 * 
 * Author: Thiago Silva Farias
 * Date: 05/02/17
 *
 */
import processing.core.PApplet;


public class Robots {
	PApplet parent;

	boolean right = false;	 //Charlie goes right
	boolean left = false;	 //Charlie goes left
	boolean down = false;	 //Charlie goes down
	boolean up = false;		 //Charlie goes up

	boolean freeze = false;		//All all Robots stop in case "y" is pressed or all run if "h" pressed

	float aliceWidth = 50;       // Alice's Width
	float aliceHeight= 50;       // Alice's height

	float bobWidth = 100;        //Bob's Width
	float bobHeight = 100;       //Bob's Height

	float charlieWidth = 100;    // Charlie's Width
	float charlieHeight= 100;    // Charlie's Height 

	float x = 0;  //Alice, Charlie and Bob coordinates
	float y = 0;  

	float aSize;  // Alice's size
	float bSize;  // Bob's size
	float cSize;  // Charlie's size

	float aSpeed;  // Alice's speed
	float cSpeed;  // Chalie's speed
	float bSpeed;  // Bob's speed

	int xdirection = 1;  // Left to Right
	int ydirection = 1;  // Top to Bottom

	String diag = "45degrees";    //Bob starts moving 45degrees down
	String direction = "right";   //Alice starts moving to right 

	int aCol = 0;   // Inicital Alice's color
	int bCol = 20;   // Inicital Bob's color
	int cCol = 40;   // Inicital Charlie's color

	// Contructors//
	public Robots(PApplet p) {
		bSpeed = 6;
		bSize = 1;
		parent = p;
		x = parent.random (bobWidth, parent.width/2 - bobWidth);    // Bob starts in a random place on the screen
		y = parent.random (bobWidth,parent.width/2 - bobWidth); 
	}

	public Robots(PApplet p, float speed, float size) {  // Alice and charlie constructor
		parent = p;  
		aSpeed = speed;
		this.cSpeed = speed;
		this.aSize = size;
		this.cSize = size;

		x = parent.random (charlieWidth, parent.width/2 - charlieWidth); // Alice and Charlie starts in a random place on the screen
		y = parent.random (charlieHeight, parent.height/2 - charlieHeight);
	}


	// ************* - Alice - ************* //
	void display() {  

		parent.pushMatrix();
		parent.translate(x + (aliceWidth/2),y + (aliceHeight/2));                //move X 27.5 right, move Y 25 down
		if (direction == "right") {
			parent.rotate(parent.radians(0));              //No rotate
		} else if (direction == "down") {
			parent.rotate(parent.radians(90));;    //Rotates 90 degrees
		} else if (direction == "left") {
			parent.rotate(parent.radians(180));;       //Rotates 180 degrees
		} else if (direction == "up") {
			parent.rotate(parent.radians(-90));;   //Rotates -90 degrees
		} 

		parent.translate(-aliceWidth/2,-aliceHeight/2);  //move half car left , move half car up


		//Drawing Alice
		parent.colorMode(parent.HSB);
		parent.fill(aCol,255,255);
		parent.scale(aSize);
		parent.stroke(0);
		parent.beginShape();
		parent.vertex(0, 0);
		parent.vertex(50, 25);
		parent.vertex(0, 50);

		parent.endShape(parent.CLOSE);
		parent.ellipseMode(parent.RADIUS);  
		parent.fill(0);  
		parent.ellipse(50, 25, 5, 5);   
		parent.popMatrix();
	}

	public  void drive(){
		if (freeze == false ){   //If "y" pressed Alice stop
			switch (direction) {
			case "right":
				x = x + aSpeed;
				if (x >= (parent.width - aliceWidth)) { //If X greater than width of the screen minus half Alice go DOWN 
					direction = "down";
				}
				break;
			case "down":
				y = y + aSpeed;
				if (y >= (parent.height - aliceHeight)) { //If Y greater than height of the screen minus half Alice go LEFT
					direction = "left";
				}
				break;
			case "left":
				x = x - aSpeed;
				if (x <= 5) {			 //If X equal than 0 go UP
					direction = "up";
				}
				break;
			case "up":
				y = y - aSpeed;
				if (y <= 5) {			 //If Y equal than 0 go RIGHT
					direction = "right";
				}
				break;
			}
		}
	}

	// ************* - Bob - ************* //
	public void drive2() {
		if (freeze == false ){		//If "y" pressed Bob stop
			//update the position of Bob

			x = x + ( bSpeed * xdirection );
			y = y + ( bSpeed * ydirection );



			if (x > (parent.width - bobWidth/2) || x < (bobWidth/2)) {
				xdirection *= - 1;            //go right or left
			}
			if (y > (parent.height - bobHeight/2)|| y < (bobHeight/2)) {
				ydirection *=  - 1;          //go up or down
			}
		}
	}

	public void display2() {

		parent.pushMatrix();
		parent.translate(x,y); 

		switch (diag) { 

		case "45degrees":                  
			parent.rotate(parent.radians(45));                   // Starts 45 degrees

			if (y>(parent.height - bobHeight/2)) {     //if Bob reaches bottom rotate 315 degrees
				diag = "315degrees";
			}
			if (x>(parent.width-bobWidth/2)) {        //if Bob reaches right rotate 135 degrees
				diag = "135degrees";
			}
			break;


		case "315degrees":    	 
			parent.rotate(parent.radians(315));             //if Bob reaches up rotate 45 degrees                   
			if (y<(bobHeight/2)) {              
				diag = "45degrees";
			}
			if (x>(parent.width-bobWidth/2)) {        //if Bob reaches right rotate 225 degrees
				diag = "225degrees";
			}
			break;

		case "135degrees":
			parent.rotate(parent.radians(135));               
			if (y >(parent.height - bobHeight/2)) {     //if Bob reaches bottom rotate 225 degrees
				diag = "225degrees";
			} 
			if (x < bobWidth/2) {                 //if Bob reachs left rotate 45 degrees
				diag = "45degrees";
			}
			break;  

		case "225degrees":
			parent.rotate(parent.radians(225));                  
			if ( y < bobHeight/2) {               //if Bob reachs up rotate 135 degrees
				diag = "135degrees";
			}
			if (x < bobWidth/2) {                 //if Bob reachs buttom rotate 315 degrees
				diag = "315degrees";
			}
			break;
		}


		parent.translate(-bobWidth/2, -bobHeight/2);    //move screen half Bob's size left and up


		parent.colorMode(parent.HSB);
		parent.fill(bCol,255,255);
		parent.scale(bSize);
		parent.beginShape();
		parent.vertex(0, 0);
		parent.vertex(100, 50);
		parent.vertex(0, 100);
		parent.endShape(parent.CLOSE);
		parent.ellipseMode(parent.RADIUS);  
		parent.fill(0);  
		parent.ellipse(100, 50, 5, 5);  
		parent.popMatrix();
	}

	// ************* - Charlie - ************* //

	void drive3() {
		if (freeze == false ){			//If "y" pressed Charlie stop
			if (parent.keyPressed == true){

				if (parent.keyCode == parent.LEFT ) {  // If Arrow left pressed decrement cSpeed from X and add 1 to the left variable. Clean the other varibles
					x-=cSpeed;
					up = false;
					down = false;
					right=false; 
					left=true;

				} else if (parent.keyCode == parent.RIGHT) { //If Arrow right pressed increment cSpeed to X and add  1 to the right variable. Clean the other variables
					x+=cSpeed;   
					up = false;
					down = false;
					left=false; 
					right=true;
				} else if (parent.keyCode == parent.UP) {          // If Arrow up pressed decrement cSpeed from Y and add 1 to the up variable. Clean the other variables
					y-=cSpeed; 
					down = false;
					left=false; 
					right=false;
					up = true;
				} else if (parent.keyCode == parent.DOWN) {  // If Arrow down pressed increment cSpeed from Y and add 1 to the down variable. Clean the other variables
					y+=cSpeed; 
					left=false; 
					right=false;
					up = false;
					down = true;
				}
			}else {
				parent.keyPressed = false;
			}}
	}
	void display3() {
		parent.pushMatrix();   
		parent.translate(x + charlieWidth/2, y+ charlieWidth/2); 
		if (left) {                          //if left is true rotate
			parent.rotate(parent.radians(180));
		}
		if (right) {                        //if right is true rotate
			parent.rotate(0);
		}
		if (down) {                         //if down is true rotate
			parent.rotate(parent.radians(90));
		}
		if (up) {                           //if up is true rotate
			parent.rotate(parent.radians(270));
		}

		parent.translate(- charlieWidth/2, - charlieWidth/2); 

		parent.colorMode(parent.HSB);
		parent.fill(cCol,255,255);
		parent.scale(cSize);
		parent.beginShape();
		parent.vertex(0, 0);
		parent.vertex(100, 50);
		parent.vertex(0, 100);
		parent.endShape(parent.CLOSE);
		parent.ellipseMode(parent.RADIUS);  
		parent.fill(0);  
		parent.ellipse(100, 50, 5, 5);  
		parent.popMatrix(); 
	}

	//************** Other Methods *****************************************

	public  void size() {
		if (parent.keyPressed == true){
			if (parent.key == 'p' || parent.key == 'P') {              //If p pressed increase Alice's size
				aSize += 0.1;
			} else if (parent.key == 'o' || parent.key == 'O') {       //If o pressed decrease Alice's size
				aSize -= 0.1;
			}
			if (parent.key == 'u' || parent.key == 'U') {              //If u pressed increase Bob's size
				bSize += 0.1;
			} else if (parent.key == 'i' || parent.key == 'I') {       //If i pressed decrease Bob's size
				bSize -= 0.1;
			}
			if (parent.key == 'm' || parent.key == 'M') {              //If m pressed increase Charlie's size
				cSize += 0.1;
			} else if (parent.key =='l' || parent.key == 'L') {        //If l pressed increase Charlie's size
				cSize -= 0.1;
			}

		} else {
			parent.keyPressed = false;
		}
	}
	public void speed() {
		if (parent.keyPressed == true){
			if (parent.key == 'w' || parent.key == 'W') {              //If w pressed increase Alice's speed
				aSpeed += 0.1;
			} 

			else if (parent.key == 'x' || parent.key == 'X') {       //If x pressed decrease Alice's speed
				aSpeed -= 0.1;
			}
			if (parent.key == 'c' || parent.key == 'C') {              //If c pressed increase Bob's speed
				bSpeed += 0.1;
			} else if (parent.key == 'v' || parent.key == 'V') {       //If v pressed decrease Bob's speed
				bSpeed -= 0.1;
			}
			if (parent.key == 'b' || parent.key == 'B') {              //If b pressed increase Charlie's speed
				cSpeed += 0.3;
			} else if (parent.key == 'n' || parent.key == 'N') {       //If n pressed decrease Charlie's speed
				cSpeed -= 0.3;
			}

		} else {
			parent.keyPressed = false;
		}	 
	}

	public void setColor() { 
		if (parent.keyPressed == true){
			if (parent.key == 'a' || parent.key == 'A') {              //If a pressed change Alice's colour
				aCol+=20;
				aCol%=255;
			}
			if (parent.key== 'z' || parent.key == 'Z') {              //If z pressed go back Alice's colour
				bCol+=20;
				bCol%=255;
			}
			if (parent.key == 'e' ||parent.key == 'E') {              //If e pressed change Bob's colour
				cCol+=20;
				cCol%=255;    
			}
			if (parent.key == 'y' ||parent.key == 'Y') {              //If e pressed change Bob's colour
				freeze = true;    
			}
			if (parent.key == 'h' ||parent.key == 'H') {              //If e pressed change Bob's colour
				freeze = false;    
			}
		} else {
			parent.keyPressed = false;
		}
	}

}
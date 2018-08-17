/**  * * RobotLab * *    
 * 
 *
 * V 1.0 
 * 
 * Author: Thiago Silva Farias
 * Date: 05/02/17
 *
 */
import processing.core.PApplet;



public class RobotLab extends PApplet{

	Robots[] Alice;			
	Robots[] Bob;			
	Robots[] Charlie;		

	// This is the main method
	public static void main(String[] args){
		PApplet.main("RobotLab");
	}


	//This setting define the size of the window
	public void settings(){
		size(displayWidth/2, displayHeight/2);
	}

	//This method set the objects
	public void setup(){
		Alice = new Robots[1];		
		Bob = new Robots[1];		//
		Charlie = new Robots[1];	//

		Alice[0] = new Robots(this, 5 ,1);
		Bob[0] = new Robots(this);
		Charlie[0] = new Robots(this, 4, 1);

	}

	//the draw method is an infinite loop where the methods in the class are called
	public void draw(){
		background(255);
		for(int i=0; i<Alice.length; i++){
			Alice[i].display();
			Alice[i].drive();
			Alice[i].speed();
			Alice[i].setColor();
			Alice[i].size();

			Bob[i].display2();
			Bob[i].drive2();
			Bob[i].speed();
			Bob[i].setColor();
			Bob[i].size();

			Charlie[i].display3();
			Charlie[i].drive3();
			Charlie[i].speed();
			Charlie[i].setColor();
			Charlie[i].size();

		}

	}	
}
# RobotLabJava
![screen shot 2018-08-17 at 12 21 03](https://user-images.githubusercontent.com/38040414/44263794-382a2100-a218-11e8-9d98-dc8eca4e6834.png)

My code does the following :\
Run three robots in the window, where which one has a direfferent behaviour.

file 1 (RobotLab.java)
Main Method:\
There are threes objects, where they call for display, drive, speed, setColor and size of the objects

file 2 (Robots.java)
Class:\
Alice patrol around the screen  -  Control the Speed, Size and color by the keys bellow:


Speed up       =   w \
Speed down     =   x \
Size  (lager)  =   p \
Size (Smaller) =   o \
Color          =   a 

Bob bounce around of the screen - Control the Speed, Size and color by the keys bellow:

Speed up       =   c\
Speed down     =   v\
Size  (lager)  =   u\
Size (Smaller) =   i\
Color          =   z

Charlie is controlled by the arrows of the keyboard - Control the Speed, Size and color by the keys bellow:

Speed up       =   b\
Speed down     =   n\
Size  (lager)  =   m\
Size (Smaller) =   l\
Color          =   e

Control Charlie by the arrows of the keyboard 

← Left\
↑ Up\
→ Right\
↓ Down


Stop all robots by the key bellow:
To stop        =   y\
To play back   =   h\

********// Compile and Run // ********

	*To compile my code*
Using terminal, find the directory where the files are, so type :

javac -cp .:core.jar RobotLab.java

To compile the java file.

	*To run the file type*


java -cp .:core.jar RobotLab.java


P.S. Please, do not forget to include the file core.jar in the side folder of the RobotLab and Robots 

#define ON HIGH             //defines "ON" as high, i.e. declaring "ON" as turning the LED on.
#define OFF LOW             //defines "ON" as low, i.e. declaring "OFF" as turning the LED off.

//north south traffic lights.
#define REDLEDN   13        //defines REDLEDN to pin 13.
#define AMBERLEDN 12        //defines AMBERLEDN to pin 12.
#define GREENLEDN 11        //defines GREENLEDN to pin 11.

//west east traffic lights.
#define REDLEDW   10        //defines REDLEDW to pin 10.
#define AMBERLEDW 9         //defines AMBERLEDW to pin 9.
#define GREENLEDW 8         //defines GREENLEDW to pin 8.

//pedestrian traffict lights.
#define pedGREEN  7         //defines pedGREEN to pin 7.
#define pedRED    6         //defines pedRED to pin 6.

int incomingByte;           //a variable to read incoming serial data into.

void setup() {
  Serial.begin(9600);       //initialize serial communication:
  pinMode(13, OUTPUT);      //initializes the north red LED pin as an output.
  pinMode(12, OUTPUT);      //initializes the north amber LED pin as an output.
  pinMode(11, OUTPUT);      //initializes the north green LED pin as an output.
  pinMode(10, OUTPUT);      //initializes the west red east pin as an output.
  pinMode(9, OUTPUT);       //initializes the west amber east pin as an output.
  pinMode(8, OUTPUT);       //initializes the west green east pin as an output.
  pinMode(7, OUTPUT);       //initializes the green pedestrian light as an output.
  pinMode(6, OUTPUT);       //initializes the red pedestrian light as an output.
} 

void loop() {
//begins the traffic light system with all the red lights on.
    digitalWrite(REDLEDN, OFF);      //turns the north red LED on.
  digitalWrite(AMBERLEDN, OFF);     //turns the north amber LED off.
  digitalWrite(GREENLEDN, ON);     //turns the north green LED off.
    digitalWrite(REDLEDW, OFF);      //turns the west red LED on.
  digitalWrite(AMBERLEDW, OFF);     //turns the west amber LED off.
  digitalWrite(GREENLEDW, ON);     //turns the west green LED off.
    digitalWrite(pedGREEN, OFF);    //turns the pedestrian green LED off.
  digitalWrite(pedRED, ON);         //turns the pedestrian red LED on.
    delay(3000);

  if (Serial.available() > 0) {         //if there is no input (serial is > 0) do:
    incomingByte = Serial.read();       //checks for an input from the keyboard.
      if (incomingByte == 'H')          //if "H" is pressed do:
        {
//turns the north/west & east/west traffic lights to orange to prepare them to stop.
            digitalWrite(REDLEDN, OFF);      //turns the right red LED off.
          digitalWrite(AMBERLEDN, ON);     //turns the right amber LED on.
          digitalWrite(GREENLEDN, OFF);     //turns the right green LED off.
            digitalWrite(REDLEDW, OFF);      //turns the left red LED on.
          digitalWrite(AMBERLEDW, ON);     //turns the left amber LED on.
          digitalWrite(GREENLEDW, OFF);     //turns the left green LED off.
            digitalWrite(pedGREEN, OFF);    //turns the pedestrian green LED off.
          digitalWrite(pedRED, ON);         //turns the pedestrian red LED on.
            delay(1000);                    //3 second delay.

//turns the north/west & east/west traffic lights to red .
            digitalWrite(REDLEDN, ON);      //turns the north red LED on.
          digitalWrite(AMBERLEDN, OFF);     //turns the north amber LED off.
          digitalWrite(GREENLEDN, OFF);     //turns the north green LED off.
            digitalWrite(REDLEDW, ON);      //turns the west red LED on.
          digitalWrite(AMBERLEDW, OFF);     //turns the west amber LED off.
          digitalWrite(GREENLEDW, OFF);     //turns the west green LED off.
            digitalWrite(pedGREEN, OFF);    //turns the pedestrian green LED off.
          digitalWrite(pedRED, ON);         //turns the pedestrian red LED on.
            delay(1000);                    //half a second delay.

//turns the north/west & east/west traffic lights to red and pedestrian light on for them to cross.
            digitalWrite(REDLEDN, ON);      //turns the north red LED on.
          digitalWrite(AMBERLEDN, OFF);     //turns the north amber LED off.
          digitalWrite(GREENLEDN, OFF);     //turns the north green LED off.
            digitalWrite(REDLEDW, ON);      //turns the west red LED on.
          digitalWrite(AMBERLEDW, OFF);     //turns the west amber LED off.
          digitalWrite(GREENLEDW, OFF);     //turns the west green LED off.
            digitalWrite(pedGREEN, ON);    //turns the pedestrian green LED on.
          digitalWrite(pedRED, OFF);         //turns the pedestrian red LED off.
            delay(1000);                    //5 second delay.

//turns the pedestrian light to red and begins the traffict light system back to normal.
            digitalWrite(REDLEDN, ON);      //turns the north red LED on.
          digitalWrite(AMBERLEDN, OFF);     //turns the north amber LED off.
          digitalWrite(GREENLEDN, OFF);     //turns the north green LED off.
            digitalWrite(REDLEDW, ON);      //turns the west red LED on.
          digitalWrite(AMBERLEDW, OFF);     //turns the west amber LED off.
          digitalWrite(GREENLEDW, OFF);     //turns the west green LED off.
            digitalWrite(pedGREEN, OFF);    //turns the pedestrian green LED on.
          digitalWrite(pedRED, ON);         //turns the pedestrian red LED on.
            delay(1000);                    //5 second delay.

            break;
        }
      else
        {
//turns the north/south red & amber lights on.
            digitalWrite(REDLEDN, ON);      //turns the north red LED on.
          digitalWrite(AMBERLEDN, ON);     //turns the north amber LED on.
          digitalWrite(GREENLEDN, OFF);     //turns the north green LED off.
            digitalWrite(REDLEDW, ON);      //turns the west red LED on.
          digitalWrite(AMBERLEDW, OFF);     //turns the west amber LED off.
          digitalWrite(GREENLEDW, OFF);     //turns the west green LED off.
            digitalWrite(pedGREEN, OFF);    //turns the pedestrian green LED off.
          digitalWrite(pedRED, ON);         //turns the pedestrian red LED on.
            delay(1000);                    //3 second delay.

//turns the north/south green lights on.
            digitalWrite(REDLEDN, OFF);      //turns the north red LED off.
          digitalWrite(AMBERLEDN, OFF);     //turns the north amber LED off.
          digitalWrite(GREENLEDN, ON);     //turns the north green LED on.
            digitalWrite(REDLEDW, OFF);      //turns the west red LED off.
          digitalWrite(AMBERLEDW, OFF);     //turns the west amber LED off.
          digitalWrite(GREENLEDW, OFF);     //turns the west green LED off.
            digitalWrite(pedGREEN, OFF);    //turns the pedestrian green LED 0ff.
          digitalWrite(pedRED, ON);         //turns the pedestrian red LED on.
            delay(1000);                    //3 second delay.

//turns the north/south amber light on.
            digitalWrite(REDLEDN, OFF);      //turns the north red LED off.
          digitalWrite(AMBERLEDN, ON);     //turns the north amber LED on.
          digitalWrite(GREENLEDN, OFF);     //turns the north green LED off.
            digitalWrite(REDLEDW, OFF);      //turns the west red LED off.
          digitalWrite(AMBERLEDW, OFF);     //turns the west amber LED off.
          digitalWrite(GREENLEDW, OFF);     //turns the west green LED off.
            digitalWrite(pedGREEN, OFF);    //turns the pedestrian green LED off.
          digitalWrite(pedRED, ON);         //turns the pedestrian red LED on.
            delay(1000);                    //3 second delay

//turns north/south & east/west red lights on.
            digitalWrite(REDLEDN, ON);      //turns the north red LED on.
          digitalWrite(AMBERLEDN, OFF);     //turns the north amber LED off.
          digitalWrite(GREENLEDN, OFF);     //turns the north green LED off.
            digitalWrite(REDLEDW, ON);      //turns the west red LED on.
          digitalWrite(AMBERLEDW, OFF);     //turns the west amber LED off.
          digitalWrite(GREENLEDW, OFF);     //turns the west green LED off.
            digitalWrite(pedGREEN, OFF);    //turns the pedestrian green LED off.
          digitalWrite(pedRED, ON);         //turns the pedestrian red LED on.
            delay(1000);                    //3 second delay.

//turns east/west red & amber lights on.
            digitalWrite(REDLEDN, ON);      //turns the north red LED on.
          digitalWrite(AMBERLEDN, ON);     //turns the north amber LED on.
          digitalWrite(GREENLEDN, OFF);     //turns the north green LED off.
            digitalWrite(REDLEDW, ON);      //turns the west red LED on.
          digitalWrite(AMBERLEDW, ON);     //turns the west amber LED on.
          digitalWrite(GREENLEDW, OFF);     //turns the west green LED off.
            digitalWrite(pedGREEN, OFF);    //turns the pedestrian green LED off.
          digitalWrite(pedRED, ON);         //turns the pedestrian red LED on.
            delay(1000);                    //3 second delay.

//turns east/west green light on.
            digitalWrite(REDLEDN, OFF);      //turns the north red LED off.
          digitalWrite(AMBERLEDN, OFF);     //turns the north amber LED off.
          digitalWrite(GREENLEDN, OFF);     //turns the north green LED off.
            digitalWrite(REDLEDW, ON);      //turns the west red LED on.
          digitalWrite(AMBERLEDW, OFF);     //turns the west amber LED off.
          digitalWrite(GREENLEDW, OFF);     //turns the west green LED off.
            digitalWrite(pedGREEN, OFF);    //turns the pedestrian green LED off.
          digitalWrite(pedRED, ON);         //turns the pedestrian red LED off.
            delay(1000);                    //3 second delay.

//turns east/west amber light on.
            digitalWrite(REDLEDN, OFF);      //turns the north red LED off.
          digitalWrite(AMBERLEDN, OFF);     //turns the north amber LED off.
          digitalWrite(GREENLEDN, OFF);     //turns the north green LED off.
            digitalWrite(REDLEDW, OFF);      //turns the west red LED off.
          digitalWrite(AMBERLEDW, ON);     //turns the west amber LED on.
          digitalWrite(GREENLEDW, OFF);     //turns the west green LED off.
            digitalWrite(pedGREEN, OFF);    //turns the pedestrian green LED off.
          digitalWrite(pedRED, ON);         //turns the pedestrian red LED on.
            delay(1000);                    //3 second delay.
      }
  }
}

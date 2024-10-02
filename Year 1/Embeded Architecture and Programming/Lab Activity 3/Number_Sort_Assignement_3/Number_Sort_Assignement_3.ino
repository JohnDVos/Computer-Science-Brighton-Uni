int rand_array[50];
int temp;
int i;
int j;
int n;
int incomingByte;
String numHigh;
String numLow;
String result; 

void setup(){
  Serial.begin(9600);                 //initialise serial communication:
  srand(0);                             //generate a random seed
  pinMode(6, OUTPUT);                  //initialise pins 
  pinMode(7, OUTPUT);
  pinMode(8, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(11, OUTPUT);
  pinMode(12, OUTPUT);
  pinMode(13, OUTPUT);

  for (int i = 0; i < 50; i++) {                        //loop through the array 50 times, adding 50 numbers.
    rand_array[i] = rand() % (255 + 1 - 1) + 1;          //add a random number between 0 and 255 to the array at pos i.
  }
}

void loop() {
  if (Serial.available() > 0) {                               // see if there's incoming serial data:
    incomingByte = Serial.read();
      if (incomingByte == 'H'){
        sortAscending();
          for (int j = 0; j < 50; j++){
          Serial.println(rand_array[j]);
        }
      }            
  }
        numHigh = convertionToBinary(rand_array[49]);
        numLow = convertionToBinary(rand_array[0]);
        while(numHigh.length() < 8) {
          numHigh = "0" + numHigh;
        }
          while(numLow.length() < 8) {
            numLow = "0" + numLow;
          }
        Serial.println(numHigh);
        Serial.println(numLow);
        LED(numHigh);
        delay(3000);
        LED(numLow);
        delay(3000);
 }

void sortAscending(){ 
  for (int i = 0; i < 50; i++) {                  //runs the loop 50 times.
    for (int j = i + 1; j < 50; j++) {
      if (rand_array[i] > rand_array[j]) {        //compares two integers, if the first integer is larger than the first, run the statement
        int temp = rand_array[i];                //creates a temporary int to store the first integer.
        rand_array[i] = rand_array[j];            //replace the first integer with the second integer.
        rand_array[j] = temp;                    //replace the second integer with the first integer.
      }
    }
  }
}
  
String convertionToBinary(int num){           //converts the ints to binary.
    String result;
    int Bit, quotient;                       
    while(num > 0){                           //while n > 0 do:
      Bit = num % 2;                          //calculate remainder of input / 2.
      quotient = num/2;                       //create temporary storage for remainder (quotient)
      result = Bit + result;                  //store digit in array
      num = quotient;                         //re-define remainder
    }
    return result;                            //return completed array (binary number)
}

  
void LED(String num){
    if(num.charAt(0) == '1')
      {digitalWrite(13, HIGH);} 
    else {digitalWrite(13, LOW);}
    
    if(num.charAt(1) == '1')
      {digitalWrite(12, HIGH);} 
    else {digitalWrite(12, LOW);}
    
     if(num.charAt(2) == '1')
      {digitalWrite(11, HIGH);}
     else {digitalWrite(11, LOW);}
     
     if(num.charAt(3) == '1')
      {digitalWrite(10, HIGH);}
     else {digitalWrite(10, LOW);}
     
     if(num.charAt(4) == '1')
      {digitalWrite(9, HIGH);}
     else {digitalWrite(9, LOW);}
     
     if(num.charAt(5) == '1')
      {digitalWrite(8, HIGH);}
     else {digitalWrite(8, LOW);}
     
     if(num.charAt(6) == '1')
      {digitalWrite(7, HIGH);}
     else {digitalWrite(7, LOW);}
     
     if(num.charAt(7) == '1')
      {digitalWrite(6, HIGH);} 
     else {digitalWrite(6, LOW);}  
}

var x = 3;
var y = 5; 

console.log(x >= 5);

if (x > y)
    {console.log(x / y)}
else{console.log("x is not greater than y")}

for (var i=1; i <= y; i++)
    {console.log("Hello " + i)}

var day = Math.floor(Math.random() * 7);
switch (day){
    case 1:
        console.log("Monday");
        break;
    case 2:
        console.log("Tuesday");
        break;
    case 3:
        console.log("Wednesday");
        break;
    case 4:
        console.log("Thursday");
        break;
    case 5:
        console.log("Friday");
        break;
    case 6:
        console.log("Saturady");
        break;
    case 7:
        console.log("Sunday");
        break;
}
console.log("hello world!");

var friends = ["Benjamin", "Lilly", "Emily", "Gabriel"];
friends.push("Isabella");
friends.push("Charlotte");
friends.push("Miles");
console.log(friends);

friends.splice(2, 2, "Aria");

console.log(friends);

friends.pop();
friends.unshift("Miles");
console.log(friends);


console.log(friends.push(friends.shift()))
console.log(friends);

console.log(friends.indexOf("Aria"));

if (friends.indexOf("Bob") === true)
    {console.log(true);}
else
    {console.log(false)}

friends.sort();
console.log(friends);

var friend = ["Benjamin", "Lilly", "Emily", "Gabriel"];
console.log(friend.join(", "));
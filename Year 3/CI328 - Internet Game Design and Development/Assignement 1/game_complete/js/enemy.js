//declares object counstructor = to different info about character (in global scope).
let enemy;

//object constructor to create copies, as multiple characters.
function Enemy(enemyType, health, mana, strength, agility, speed) {
    /*  
    *   information about:  which class type was chosen.
    *   stats:              health, mana, strength, agility, speed.
    */
   this.enemyType   =   enemyType;
   this.health      =   health;
   this.mana        =   mana;
   this.strength    =   strength;
   this.agility     =   agility;
   this.speed       =   speed;
}

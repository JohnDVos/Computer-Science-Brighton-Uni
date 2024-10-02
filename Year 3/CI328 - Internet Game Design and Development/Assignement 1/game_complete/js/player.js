//declares object counstructor = to different info about character (in global scope).
let player;

//object constructor to create copies, as multiple characters.
function Player(classType, health, mana, strength, agility, speed) {
    /*  
    *   information about:  which class type was chosen.
    *   stats:              health, mana, strength, agility, speed.
    */
    this.classType  = classType;
    this.health     = health;
    this.mana       = mana;
    this.strength   = strength;
    this.agility    = agility;
    this.speed      = speed;
}

let PlayerMoves = {
    //can add dodge, defend here.
    
    //determines who attacks first.
      calcAttack: function() {
         //determines who attacks first?
         let getPlayerSpeed = player.speed;
         let getEnemySpeed = enemy.speed;
          
        //player attack function.
        let playerAttack = function() {
            
          let calcBaseDamage;
        
          //calculates player damage based on if has mana or not.    
          if (player.mana > 0) {
            calcBaseDamage = player.strength * player.mana / 1000;
          } else {
            calcBaseDamage = player.strength * player.agility / 1000;
          }
            
          let offsetDamage = Math.floor(Math.random() * Math.floor(10));                                            //offsets the damage for variation, which is random between 1 and 10.
          let calcOutputDamage = calcBaseDamage + offsetDamage;                                                     //results in random attack damage for every time.
          let numberOfHits = Math.floor(Math.random() * Math.floor(player.agility / 10) / 2) + 1;                   //number of hits based off agility (/2 so number is not huge, +1 so its never 0 damage).
          let attackValues = [calcOutputDamage, numberOfHits];                                                      //creates am array with attack damage values.
          return attackValues;                                                                                      //returns an array for attack damage
        }
        
        //enemy attack function.
        let enemyAttack = function() {
            
          let calcBaseDamage;
            
          //calculates player damage based on if has mana or not.    
          if (enemy.mana > 0) {
            calcBaseDamage = enemy.strength * enemy.mana / 1000;
          } else {
            calcBaseDamage = enemy.strength * enemy.agility / 1000;
          }
            
          let offsetDamage = Math.floor(Math.random() * Math.floor(10));                                            //offsets the damage for variation, which is random between 1 and 10.
          let calcOutputDamage = calcBaseDamage + offsetDamage;                                                     //results in random attack damage for every time.
          let numberOfHits = Math.floor(Math.random() * Math.floor(enemy.agility / 10) / 2) + 1;                    //number of hits based off agility (/2 so number is not huge, +1 so its never 0 damage).
          let attackValues = [calcOutputDamage, numberOfHits];                                                      //creates am array with attack damage values.
          return attackValues;                                                                                      //returns an array for attack damage.
        }
        
        //gets player and enemy health to change after actions.
        let getPlayerHealth = document.querySelector(".health-player");
        let getEnemyHealth = document.querySelector(".health-enemy");
          
        //initiate attack.
        if (getPlayerSpeed >= getEnemySpeed) {
          let playerAttackValues = playerAttack();
          let totalDamage = playerAttackValues[0] * playerAttackValues[1];                                          //initiate attack.
            
          enemy.health = enemy.health - totalDamage;                                                                //changes enemy health in js by total damage.
          alert("You hit " + playerAttackValues[0] + " damage " + playerAttackValues[1] + " times.");               //pop up messages to tell player amount of damage delt.
            
          if (enemy.health <= 0) {
              alert("You win! Refresh browser to play again.");
              getPlayerHealth.innerHTML = 'Health: ' + player.health;                                                 //even if enemy takes damage past 0 health, 0 health is displayed rather than negative health.
              getEnemyHealth.innerHTML = 'Health: 0';
          } else {
              getEnemyHealth.innerHTML = 'Health: ' + enemy.health;                                                 //gets enemy health
              let enemyAttackValues = enemyAttack();                                                                //gets enemy attack damage values.
              let totalDamage = enemyAttackValues[0] * enemyAttackValues[1];
              player.health = player.health - totalDamage;
              alert("Enemy hit " + enemyAttackValues[0] + " damage " + enemyAttackValues[1] + " times.");
              if (player.health <= 0) {
                  alert("You loose! Refresh browser to play again.");
                  getPlayerHealth.innerHTML = 'Health: 0';
                  getEnemyHealth.innerHTML = 'Health: ' + enemy.health;
            } else {
                  getPlayerHealth.innerHTML = 'Health: ' + player.health;
            }
          }
        } else if (getEnemySpeed >= getPlayerSpeed) {
            let enemyAttackValues = enemyAttack();
            let totalDamage = enemyAttackValues[0] * enemyAttackValues[1];
            
            player.health = player.health - totalDamage;
            alert("Enemy hit " + enemyAttackValues[0] + " damage " + enemyAttackValues[1] + " times.");
            
          if (player.health <= 0) {
              alert("You loose! Refresh browser to play again.");
              getEnemyHealth.innerHTML = 'Health: ' + enemy.health;
              getPlayerHealth.innerHTML = 'Health: 0';
          } else {
              getPlayerHealth.innerHTML = 'Health: ' + player.health;
              let playerAttackValues = playerAttack();                                                                   //player attacks
              
              let totalDamage = playerAttackValues[0] * playerAttackValues[1];
              enemy.health = enemy.health - totalDamage;
              alert("You hit " + playerAttackValues[0] + " damage " + playerAttackValues[1] + " times.");
              
              if (enemy.health <= 0) {
                  alert("You win! Refresh browser to play again.");
                  getEnemyHealth.innerHTML = 'Health: 0';
                  getPlayerHealth.innerHTML = 'Health: ' + player.health;
            } else {
                  getEnemyHealth.innerHTML = 'Health: ' + enemy.health;
            }  
          }
        }
    }

}

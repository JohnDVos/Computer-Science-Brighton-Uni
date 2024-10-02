//creates game object
let GameManager = {
    
    setGameStart: function(classType) {
        //runs resetPlayer and setPreFight when character is chosen.
        this.resetPlayer(classType);
        this.setPreFight();
    },
    
    resetPlayer: function(classType) {
        
        switch (classType) {
          case "Warrior":
            //creates warrior type and allocates stats. 
            player = new Player(classType, 550, 0, 350, 50, 50);
            break;
          case "Rogue":
            //creates roque type and allocates stats.
            player = new Player(classType, 200, 50, 250, 250, 250);
            break;
          case "Mage":
            //creates mage type and allocates stats.
            player = new Player(classType, 150, 350, 100, 200, 200);
            break;
          case "Hunter":
            //creates hunter type and allocates stats.
            player = new Player(classType, 150, 100, 200, 300, 250);
            break;
        case "Assassin":
            player = new Player(classType, 150, 50, 150, 300, 350);
            break;
    }
    
    //takes interface from inside index page then inserts content.
    let getInterface = document.querySelector(".interface");
    getInterface.innerHTML = '<img src="assets/avatar-player/' + classType.toLowerCase() + '.png" class="img-avatar"><div><h3>' + classType + '</h3><p class="health-player">Health: ' + player.health + '</p><p>Mana: ' + player.mana + '</p><p>Strength: ' + player.strength + '</p><p>Agility: ' + player.agility + '</p><p>Speed: ' + player.speed + '</p></div>';
        
  },
    
    setPreFight: function() {
        let getHeader = document.querySelector(".header");
        let getActions = document.querySelector(".actions");
        let getArena = document.querySelector(".arena");
        
        getHeader.innerHTML = '<p>Task: Find an enemy!</p>';
        getActions.innerHTML = '<a href="#" class="btn-prefight" onclick="GameManager.setFight()">Search for enemy!</a>';
        getArena.style.visibility = "visible";
    },
    
    setFight: function() {
        let getHeader = document.querySelector(".header");
        let getActions = document.querySelector(".actions");
        let getEnemy = document.querySelector(".enemy");
        
        //creates enemies
        let enemy00 = new Enemy("goblin", 200, 150, 150, 250, 250);
        let enemy01 = new Enemy("troll", 200, 200, 200, 200, 200);
        let enemy02 = new Enemy("orc", 450, 50, 400, 50, 50);
        let chooseRandomEnemy = Math.floor(Math.random() * Math.floor(2));
        
        switch (chooseRandomEnemy) {
          case 0:
            enemy = enemy00;
            break;
          case 1:
            enemy = enemy01;
            break;
          case 2:
            enemy = enemy02;
            break;
    }
      
    getHeader.innerHTML = '<p>Task: Choose your move!</p>';
    getActions.innerHTML = '<a href="#" class="btn-prefight" onclick="PlayerMoves.calcAttack()">Attack!</a>';
    getEnemy.innerHTML = '<img src="assets/avatar-enemies/' + enemy.enemyType.toLowerCase() + '.png" alt="' + enemy.enemyType + '" class="img-avatar"><div><h3>' + enemy.enemyType + '</h3><p class="health-enemy">Health: ' + enemy.health + '</p><p>Mana: ' + enemy.mana + '</p><p>Strength: ' + enemy.strength + '</p><p>Agility: ' + enemy.agility + '</p><p>Speed: ' + enemy.speed + '</p></div>';
  }
}

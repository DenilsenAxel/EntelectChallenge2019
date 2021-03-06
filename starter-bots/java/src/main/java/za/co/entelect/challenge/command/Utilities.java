package za.co.entelect.challenge.command;

import za.co.entelect.challenge.command.*;
import za.co.entelect.challenge.entities.*;
import za.co.entelect.challenge.enums.CellType;
import za.co.entelect.challenge.enums.Direction;

import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;


public class Utilities {

    public Utilities() {

    }

    public int countMyWorms(GameState gameState){
        int count = 0;
        for(Worm worm : gameState.myPlayer.worms){
            if(worm.health>0){
                count++;
            }
        }
        return count;
    }

    public int countEnemyWorms(GameState gameState){
        int count = 0;
        for(Worm worm : gameState.opponents[0].worms){
            if(worm.health>0){
                count++;
            }
        }
        return count;
    }

    public int calculateMyWormsHealth(GameState gameState){
        int totalHealth = 0;
        for(Worm worm : gameState.myPlayer.worms){
            if(worm.health>0){
                totalHealth+=worm.health;
            }
        }
        return totalHealth;
    }

    public int calculateEnemyWormsHealth(GameState gameState){
        int totalHealth = 0;
        for(Worm worm : gameState.opponents[0].worms){
            if(worm.health>0){
                totalHealth+=worm.health;
            }
        }
        return totalHealth;
    }

    public int getDirtID(List<Cell> surroundingBlocks){
        for(int i=0;i<surroundingBlocks.size();i++){
            if(surroundingBlocks.get(i).type==CellType.DIRT){
                return i;
            }
        }
        return -1;
    }

    public int gradient(Worm w1, Worm w2) {
        int deltaX = w1.position.x - w2.position.x;
        int deltaY = w1.position.y - w2.position.y;
        return deltaY/deltaX;
    }

    public boolean isPathInvalid(Worm enemyWorm, Worm currentWorm,Opponent opponent, int moveX, int moveY, GameState gameState){
        int y = currentWorm.position.y;
        int x = currentWorm.position.x;

        for (Worm cacingMusuh : opponent.worms) {
            if ((cacingMusuh.position.x == moveX  && cacingMusuh.position.y ==moveY && cacingMusuh.health>0) || (gameState.myPlayer.worms[0].position.x==moveX && gameState.myPlayer.worms[0].position.y==moveY && gameState.myPlayer.worms[0].health>0) || (gameState.myPlayer.worms[1].position.x==moveX && gameState.myPlayer.worms[1].position.y==moveY && gameState.myPlayer.worms[1].health>0)|| (gameState.myPlayer.worms[2].position.x==moveX && gameState.myPlayer.worms[2].position.y==moveY && gameState.myPlayer.worms[2].health>0)){
                return true;
            }
        }
        if(gameState.map[moveY][moveX].type == CellType.DEEP_SPACE || gameState.map[moveY][moveX].type == CellType.DIRT || gameState.map[moveY][moveX].type == CellType.LAVA){
            return true;
        }
        return false;
    }

    public boolean isPathInvalid(Worm currentWorm,GameState gameState,int moveX,int moveY){
        int y = currentWorm.position.y;
        int x = currentWorm.position.x;

        for (Worm cacingMusuh : gameState.opponents[0].worms) {
            if ((cacingMusuh.position.x == moveX  && cacingMusuh.position.y ==moveY && cacingMusuh.health>0) || (gameState.myPlayer.worms[0].position.x==moveX && gameState.myPlayer.worms[0].position.y==moveY && gameState.myPlayer.worms[0].health>0) || (gameState.myPlayer.worms[1].position.x==moveX && gameState.myPlayer.worms[1].position.y==moveY && gameState.myPlayer.worms[1].health>0)|| (gameState.myPlayer.worms[2].position.x==moveX && gameState.myPlayer.worms[2].position.y==moveY && gameState.myPlayer.worms[2].health>0)){
                return true;
            }
        }
        if(gameState.map[moveY][moveX].type == CellType.DEEP_SPACE || gameState.map[moveY][moveX].type == CellType.DIRT || gameState.map[moveY][moveX].type == CellType.LAVA){
            return true;
        }
        return false;
    }

    public boolean isOccupied(GameState gameState,int x,int y){
        for(Worm worm: gameState.opponents[0].worms){
            if(worm.position.x == x && worm.position.y == y && worm.health>0){
                return true;
            }
        }
        for(Worm worm: gameState.myPlayer.worms){
            if(worm.position.x == x && worm.position.y == y && worm.health>0){
                return true;
            }
        }
        return false;
    }
}


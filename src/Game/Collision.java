package Game;

import GameObject.Collectables.Collectim;
import GameObject.Entity.Entity;
import GameObject.Entity.Ghost;
import GameObject.Entity.Player;
import GameObject.*;
import GameObject.Environment.*;

public class Collision {
    private static Player player = Player.getInstance();
    public static boolean check(GameObject obj, GameObject other){
        if (
                obj.getUp() <= other.getDown()
                && obj.getDown() >= other.getUp()
                && obj.getLeft() <= other.getRight()
                && obj.getRight() >= other.getLeft()
        ){
            if (obj instanceof Player){
                other.collideWithPlayer((Player)obj);

            } else if (obj instanceof Ghost){
                other.collideWithGhost((Ghost)obj);
            }
            return true;
        }
        return false;
    }
    public static boolean isCollideWithWall(GameObject obj){
        for (int i = 0; i < Wall.list.size(); i++) {

            if(check(obj, Wall.list.get(i))){
                return true;
            }
        }
        return false;
    }
    public static boolean isCollideWithEnvironment(GameObject obj) {
        for (int i = 0; i < Environment.list.size(); i++) {

            if(check(obj, Environment.list.get(i))){
                return true;
            }
        }
        return false;
    }

    public static void checkAll(){
        //player --> ghost
        Entity.list.forEach(e ->  check(player, e));

        //player --> dots
        Collectim.list.forEach(d-> check(player, d));

        //player & ghost --> environment
        Environment.list.forEach(env -> {
            Entity.list.forEach(entity -> {
                check(entity, env);
            });
        });
    }
}

package NguHuynhDe.entities.tile.powerup;

import NguHuynhDe.entities.Entity;
import NguHuynhDe.entities.mob.Player;
import NguHuynhDe.graphics.Sprite;
import java.util.Timer;
import java.util.TimerTask;

public class PowerupUndead extends Powerup {

    public PowerupUndead(int x, int y, int level, Sprite sprite) {
        super(x, y, level, sprite);
    }

    @Override
    public boolean collide(Entity e) {

        if(e instanceof Player) {
            ((Player) e).addPowerup(this);
            remove();
            return true;
        }

        return false;
    }

    @Override
    public void setValues() {
        _active = true;
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 10;

            public void run() {


                Player.undead=true;
                i--;
                if (i < 0) {
                    timer.cancel();
                    Player.undead=false;
                }
            }
        }, 0, 1000);

       // timer.schedule(active(), 2000);
    }




}

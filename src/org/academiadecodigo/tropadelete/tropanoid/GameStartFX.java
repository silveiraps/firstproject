package org.academiadecodigo.tropadelete.tropanoid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.tropadelete.tropanoid.Utils.Sound;


public class GameStartFX {
    private Text textReady;
    private Text textSet;
    private Text textGo;
    private Sound sound;

    public GameStartFX() {

        this.textReady = new Text(240, 320, "READY");
        this.textSet = new Text(240, 320, "SET");
        this.textGo = new Text(240, 320, "GO");
        this.sound = new Sound("/02_hhavok-main.wav");
    }

    public void readyGoText() {

        sound.play(true);

        int count = 0;
        while (count <= 40) {
            textReady.setColor(Color.YELLOW);
            textReady.draw();
            textReady.grow(5, 5);

            try {
                Thread.sleep(5);

            } catch (InterruptedException e) {
            }
            count++;
        }
        textReady.delete();

        int count2 = 0;
        while (count2 <= 40) {
            textSet.setColor(Color.CYAN);
            textSet.draw();
            textSet.grow(5, 5);


            try {
                Thread.sleep(5);
                // textReady.wait(100);
            } catch (InterruptedException e) {
            }
            count2++;
        }

        textSet.delete();

        int count1 = 0;
        while (count1 <= 40) {
            textGo.setColor(Color.MAGENTA);
            textGo.draw();
            textGo.grow(5, 5);


            try {
                Thread.sleep(5);
                // textReady.wait(100);
            } catch (InterruptedException e) {
            }
            count1++;
        }

        textGo.delete();

    }
}

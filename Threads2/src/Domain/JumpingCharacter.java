package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {
     
    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        sprite.add(new Image(new FileInputStream("src/Assets/Jumping2.png")));
        sprite.add(new Image(new FileInputStream("src/Assets/Jumping0.png")));
        sprite.add(new Image(new FileInputStream("src/Assets/Jumping1.png")));
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
//        super.setImage(sprite.get(0));
        int move=0;
        int stay=370;
        while (true) {
            try {
//                Thread.sleep(800);
//                this.setY(270);
//                Thread.sleep(800);
//                this.setY(370);
//                super.setImage(sprite.get(0));
                
                //agregado
                //controla el salto hacia arriba
                if(stay==370){
                    Thread.sleep(50);
                    this.setY(370);
                    super.setImage(sprite.get(0));
                    
                    for(int i=stay; i>270; i=i-10){
                        Thread.sleep(50);
                        this.setY(i+5);
                        super.setImage(sprite.get(1));
                    }
                    stay=270;
                }
                
                //controla cuando baja
                if(stay==270){
                    Thread.sleep(50);
                    this.setY(270);
                    super.setImage(sprite.get(2));
                    
                    for(int i=stay; i<370; i=i+10){
                        Thread.sleep(50);
                        this.setY(i+5);
                        super.setImage(sprite.get(2));
                    }
                    stay=370;
                }
            } 
            catch (InterruptedException ex) {} 
        }
    }
}

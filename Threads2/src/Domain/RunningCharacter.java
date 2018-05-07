package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        for(int i = 0; i < 8; i++){
           // sprite.add(new Image(new FileInputStream("src/Assets/Running0.png")));
            sprite.add(new Image(new FileInputStream("src/Assets/Running"+i+".png")));
        }
        
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        //super.setImage(sprite.get(0));
        int dc=0;
        int move=100;
        while (true) {
            try {
//                super.setImage(sprite.get(dc));
//                super.setX(100);
//                Thread.sleep(800);
//                super.setX(700);
//                Thread.sleep(800);
                
                //agregado
                super.setImage(sprite.get(dc));
                super.setX(move);
                Thread.sleep(80);
                
                //controla la imagen que se llama
                if(dc==7){
                    dc=0;
                }else{
                    dc++;
                }
                
                //controla el espacio de movimiento de la imagen
                if(move>=800){
                    move=100;
                }else{
                    move=move+20;
                }
                
            } 
            catch (InterruptedException ex) {}
        }
    }
}

package inf112.RoboRally.app.Cards;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class TestCardActor extends ImageButton {
    //ProgramCard card;
    public TestCardActor(ProgramCard card) {
        super(new TextureRegionDrawable(card.getTex()));
        //this.card = card;
        getImageCell().prefSize(1.667f, 2f);
        setBounds(0f, 13f, 0f, 13f);
        addListener(new ChangeListener() {
                        @Override
                        public void changed(ChangeEvent changeEvent, Actor actor) {
                            onClicked(card);
                        }
                    });

    }

    public void onClicked(ProgramCard card){
        System.out.println("You clicked me " + card.getFilename());

    }
}

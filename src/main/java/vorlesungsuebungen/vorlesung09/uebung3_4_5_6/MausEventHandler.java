package vorlesungsuebungen.vorlesung09.uebung3_4_5_6;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MausEventHandler implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        System.out.println(event.getSceneX() + ", " + event.getSceneY());
    }
}

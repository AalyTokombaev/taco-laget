package inf112.RoboRally.app.Multiplayer;

public class Action <T extends Object>{
    String act;
    T thing;

    public Action(String act, T t){
        this.act = act;
        this.thing = t;
    }
}

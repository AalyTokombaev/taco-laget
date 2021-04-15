package inf112.RoboRally.app.Multiplayer;

public class Request<E> {
    E data;
    RequestType type;

    public Request(RequestType type ,E data){
        this.data = data;
        this.type = type;
    }
}

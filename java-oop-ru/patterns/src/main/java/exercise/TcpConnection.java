package exercise;

import exercise.connections.Connected;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class TcpConnection {
    private String ipAdress;
    private int port;
    private Connection state;
    List<String> buffer = new ArrayList<>();
//    private StringBuilder builder = new StringBuilder();


    TcpConnection(String ipAdress, int port) {
        this.ipAdress = ipAdress;
        this.port = port;
        this.state = new Disconnected(this);
    }

    public String getCurrentState(){
        return this.state.getStateName();
    }
    public Connection getCurrentStateS(){
        return state;
    }
    public void write(String data) {
        this.getCurrentStateS().write(data);
    }

    public void connect() {
        state.connect();
    }
    public void disconnect() {
        this.state = new Disconnected(this);
        this.state.disconnect();
    }
    public void setState(Connection state) {
        this.state = state;
    }
    public void addToBuffer(String data) {
        buffer.add(data);
    }


}
// END

package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {
    private TcpConnection connection;
    private final String STATE_NAME = "disconnected";

    public Disconnected(TcpConnection connection) {
        this.connection = connection;
    }

    @Override
    public void connect() {
        connection.setState(new Connected(connection));
    }

    @Override
    public void disconnect() {
        System.out.println("Error! Connection already disconnected");
    }

    @Override
    public String getStateName() {
        return STATE_NAME;
    }

    @Override
    public void write(String data) {
        System.out.println("Error! " + data);
    }
}
// END

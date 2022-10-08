package exercise.connections;

public interface Connection {
    // BEGIN
    void connect();
    void disconnect();
    String getStateName();
    void write(String data);
    // END
}

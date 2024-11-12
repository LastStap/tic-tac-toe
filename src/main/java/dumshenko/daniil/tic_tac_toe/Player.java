package dumshenko.daniil.tic_tac_toe;

public class Player {
    private final String username;
    private final PlayerType type;

    public Player(String username, PlayerType type) {
        this.username = username;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public PlayerType getType() {
        return type;
    }
}

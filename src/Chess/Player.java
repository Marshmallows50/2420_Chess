package Chess;

import java.util.ArrayList;

public class Player {

    private Boolean color;
    public ArrayList<Piece> alive = new ArrayList<>(16);
    public ArrayList<Piece> dead = new ArrayList<>();
    private long remainingTime;


    public Player(boolean color) {
        this.color = color;
    }

    public Boolean getColor() {
        return color;
    }

    public long getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(long remainingTime) {
        this.remainingTime = remainingTime;
    }

    public void startTimer() {}

    public void stopTimer() {}

}

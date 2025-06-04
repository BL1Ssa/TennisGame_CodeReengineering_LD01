public class TennisGame3 implements TennisGame {

    private int p1;
    private int p2;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        if (NormalScore()) {
            return getNormalScore();
        } else if (Deuce()) {
            return "Deuce";
        } else {
            return getAdvantageOrWinScore();
        }
    }

    private boolean NormalScore() {
        return p1 < 4 && p2 < 4 && (p1 + p2 != 6);
    }

    private String getNormalScore() {
        String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};
        String score = scores[p1];
        return (p1 == p2) ? score + "-All" : score + "-" + scores[p2];
    }

    private boolean Deuce() {
        return p1 == p2;
    }

    private String getAdvantageOrWinScore() {
        String leadingPlayer = p1 > p2 ? p1N : p2N;
        return Math.abs(p1 - p2) == 1
                ? "Advantage " + leadingPlayer
                : "Win for " + leadingPlayer;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(p1N))
            p1++;
        else if (playerName.equals(p2N))
            p2++;
    }
}

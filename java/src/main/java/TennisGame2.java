public class TennisGame2 implements TennisGame
{
    private static class Player {
        public int point = 0;
        public final String name;
        public Player(String name) {
            this.name = name;
        }
    }

    private final Player player1;
    private final Player player2;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    private String pointToScoreString(int point) {
        switch(point) {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
            default: return "";
        }
    }

    public String getScore() {
        String score = "";
        Player P1 = player1;
        Player P2 = player2;

        if (P1.point == P2.point && P1.point < 4) {
            score = pointToScoreString(P1.point) + "-All";
        } else if (P1.point == P2.point && P1.point >= 3) {
            score = "Deuce";
        } else if (P1.point >= 4 && (P1.point - P2.point) >= 2) {
            score = "Win for " + P1.name;
        } else if (P2.point >= 4 && (P2.point - P1.point) >= 2) {
            score = "Win for " + P2.name;
        } else if (P1.point >= 3 && P2.point >= 3) {
            if (P1.point > P2.point) {
                score = "Advantage " + P1.name;
            } else {
                score = "Advantage " + P2.name;
            }
        } else {
            String p1Score = pointToScoreString(P1.point);
            String p2Score = pointToScoreString(P2.point);
            score = p1Score + "-" + p2Score;
        }
        return score;
    }

    public void SetP1Score(int number) {
        for (int i = 0; i < number; i++) {
            P1Score();
        }
    }

    public void SetP2Score(int number) {
        for (int i = 0; i < number; i++) {
            P2Score();
        }
    }

    public void P1Score() {
        player1.point++;
    }

    public void P2Score() {
        player2.point++;
    }

    public void wonPoint(String player) {
        if (player.equals(player1.name))
            P1Score();
        else
            P2Score();
    }
}
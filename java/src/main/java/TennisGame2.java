public class TennisGame2 implements TennisGame
{
    private static class Player {
        public int point = 0;
        public String res = "";
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

    public String getScore() {
        String score = "";
        Player P1 = player1;
        Player P2 = player2;

        if (P1.point == P2.point && P1.point < 4) {
            if (P1.point == 0)
                score = "Love";
            if (P1.point == 1)
                score = "Fifteen";
            if (P1.point == 2)
                score = "Thirty";
            score += "-All";
        }
        if (P1.point == P2.point && P1.point >= 3)
            score = "Deuce";

        if (P1.point > 0 && P2.point == 0) {
            if (P1.point == 1)
                P1.res = "Fifteen";
            if (P1.point == 2)
                P1.res = "Thirty";
            if (P1.point == 3)
                P1.res = "Forty";
            P2.res = "Love";
            score = P1.res + "-" + P2.res;
        }
        if (P2.point > 0 && P1.point == 0) {
            if (P2.point == 1)
                P2.res = "Fifteen";
            if (P2.point == 2)
                P2.res = "Thirty";
            if (P2.point == 3)
                P2.res = "Forty";
            P1.res = "Love";
            score = P1.res + "-" + P2.res;
        }

        if (P1.point > P2.point && P1.point < 4) {
            if (P1.point == 2)
                P1.res = "Thirty";
            if (P1.point == 3)
                P1.res = "Forty";
            if (P2.point == 1)
                P2.res = "Fifteen";
            if (P2.point == 2)
                P2.res = "Thirty";
            score = P1.res + "-" + P2.res;
        }
        if (P2.point > P1.point && P2.point < 4) {
            if (P2.point == 2)
                P2.res = "Thirty";
            if (P2.point == 3)
                P2.res = "Forty";
            if (P1.point == 1)
                P1.res = "Fifteen";
            if (P1.point == 2)
                P1.res = "Thirty";
            score = P1.res + "-" + P2.res;
        }

        if (P1.point > P2.point && P2.point >= 3) {
            score = "Advantage " + P1.name;
        }

        if (P2.point > P1.point && P1.point >= 3) {
            score = "Advantage " + P2.name;
        }

        if (P1.point >= 4 && P2.point >= 0 && (P1.point - P2.point) >= 2) {
            score = "Win for " + P1.name;
        }
        if (P2.point >= 4 && P1.point >= 0 && (P2.point - P1.point) >= 2) {
            score = "Win for " + P2.name;
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
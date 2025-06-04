
public class TennisGame1 implements TennisGame {
    
    private Player player1;
    private Player player2;

    
    class Player{
    	private String playerName;
    	private int m_score;
    	public Player(String playerName) {
    		this.playerName = playerName;
    		this.m_score = 0;
    	}
		public String getPlayerName() {
			return playerName;
		}
		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}
		public int getM_score() {
			return m_score;
		}
		public void setM_score(int m_score) {
			this.m_score = m_score;
		}
		
    }
    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
           player1.setM_score(player1.getM_score() + 1);
        else
           player2.setM_score(player2.getM_score() + 1);
    }

     public String getScore() {
        if (isDraw()) {
            return drawScore();
        } else if (isEndGame()) {
            return advantageOrWin();
        } else {
            return regularScore();
        }
    }

    private boolean isDraw() {
        return player1.getM_score() == player2.getM_score();
    }

    private String drawScore() {
        switch (player1.getM_score()) {
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
            default: return "Deuce";
        }
    }

    private boolean isEndGame() {
        return player1.getM_score() >= 4 || player2.getM_score() >= 4;
    }

    private String advantageOrWin() {
        int minusResult = player1.getM_score() - player2.getM_score();
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
    }

    
    private String regularScore() {
        int score1 = player1.getM_score();
        int score2 = player2.getM_score();
        String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};
        return scores[score1] + "-" + scores[score2];
    }
}


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
        String score = "";
        int tempScore=0;
        if (player1.getM_score() == player2.getM_score())
        {
            switch (player1.getM_score())
            {
                case 0:
                        score = "Love-All";
                    break;
                case 1:
                        score = "Fifteen-All";
                    break;
                case 2:
                        score = "Thirty-All";
                    break;
                default:
                        score = "Deuce";
                    break;
                
            }
        }
        else if (player1.getM_score()>=4 || player2.getM_score()>=4)
        {
            int minusResult = player1.getM_score()-player2.getM_score();
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player1.getM_score();
                else { score+="-"; tempScore = player2.getM_score();}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }
}

package blackjack.domain.participant;

import java.util.Map;

public class Dealer extends Participant {
    private static final Name name = new Name("딜러");
    private static final int STAY_THRESHOLD = 17;

    public boolean isStay() {
        return calculateResult() >= STAY_THRESHOLD;
    }

    public String getGameResult(Map<String, String> playersGameResult) {
        int winCount = (int) playersGameResult.entrySet().stream()
                .filter(entry -> "승".equals(entry.getValue()))
                .count();
        int loseCount = playersGameResult.size() - winCount;

        return String.format("%d승 %d패", winCount, loseCount);
    }

    public String getFirstCardInfo() {
        return cards.get(0).toString();
    }

    @Override
    public String getName() {
        return name.toString();
    }
}

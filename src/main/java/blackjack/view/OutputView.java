package blackjack.view;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
import blackjack.domain.participant.Player;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String INITIAL_CARDS_INFO_PREFIX_FORMAT = "%s와 %s에게 2장씩 나눴습니다." + System.lineSeparator();
    private static final String CARDS_INFO_FORMAT = "%s카드: %s" + System.lineSeparator();
    public static final String DELIMITER = ", ";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printInitialCardsInfo(Dealer dealer, List<Player> players) {
        printInitialCardsInfoPrefix(dealer, players);
        printDealerCardsInfo(dealer);
        for (Player player : players) {
            printParticipantCardsInfo(player);
        }
        System.out.println();
    }

    private static void printInitialCardsInfoPrefix(Dealer dealer, List<Player> players) {
        String playerNames = players.stream()
                .map(Player::getName)
                .collect(Collectors.joining(DELIMITER));
        System.out.printf(INITIAL_CARDS_INFO_PREFIX_FORMAT,dealer.getName(), playerNames);
    }

    private static void printDealerCardsInfo(Dealer dealer) {
        System.out.printf(CARDS_INFO_FORMAT, dealer.getName(), dealer.getFirstCardsInfoToString());
    }

    public static void printParticipantCardsInfo(Participant participant) {
        System.out.printf(CARDS_INFO_FORMAT, participant.getName(), participant.getCurrentCardsInfo());
    }
}

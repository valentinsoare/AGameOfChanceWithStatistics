package playing.agameofchance.players;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorForPlayer implements Comparator<Player> {
    private String type;
    private final String originalType;

    public ComparatorForPlayer() {
        this("name");
    }

    public ComparatorForPlayer(String type) {
        this.type = type;
        this.originalType = type;
    }

    public String getType() {
        return type;
    }

    public String getOriginalType() {
        return originalType;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int compare(Player o1, Player o2) {
        int valueToReturn = o1.getName().compareToIgnoreCase(o2.getName());

        switch (type) {
            case "name" -> {
                if (valueToReturn == 0) {
                    valueToReturn = Integer.compare(o1.getAge(), o2.getAge());

                    if (valueToReturn == 0) {
                        valueToReturn = o1.getOccupation().compareToIgnoreCase(o2.getOccupation());
                    }
                }
            } case "age" -> {
                valueToReturn = Integer.compare(o1.getAge(), o2.getAge());

                if (valueToReturn == 0) {
                    setType("name");

                    valueToReturn = this.compare(o1, o2);
                }
            } case "occupation" -> {
                valueToReturn = o1.getOccupation().compareToIgnoreCase(o2.getOccupation());

                if (valueToReturn == 0) {
                    setType("name");

                    valueToReturn = this.compare(o1, o2);
                }
            } case "numberOfGamesPlayed" -> {
                valueToReturn = Integer.compare(o1.getStatisticsForPlayer().getNumberOfGamesPlayed(), o2.getStatisticsForPlayer().getNumberOfGamesPlayed());

                if (valueToReturn == 0) {
                    valueToReturn = Double.compare((double) Arrays.stream(o1.getStatisticsForPlayer().getHistoryOfNumberOfGames()).sum() / o1.getStatisticsForPlayer().getHistoryOfNumberOfGames().length,
                            (double) Arrays.stream(o2.getStatisticsForPlayer().getHistoryOfNumberOfGames()).sum() / o2.getStatisticsForPlayer().getHistoryOfNumberOfGames().length);
                }
            } case "historyOfNumberOfGamesAverage" -> {
                valueToReturn = Double.compare((double) Arrays.stream(o1.getStatisticsForPlayer().getHistoryOfNumberOfGames()).sum() / o1.getStatisticsForPlayer().getHistoryOfNumberOfGames().length,
                        (double) Arrays.stream(o2.getStatisticsForPlayer().getHistoryOfNumberOfGames()).sum() / o2.getStatisticsForPlayer().getHistoryOfNumberOfGames().length);

                if (valueToReturn == 0) {
                    valueToReturn = Integer.compare(o1.getStatisticsForPlayer().getNumberOfGamesPlayed(), o2.getStatisticsForPlayer().getNumberOfGamesPlayed());
                }
            } default -> {
                setType("name");
                valueToReturn = this.compare(o1, o2);
            }
        }

        setType(getOriginalType());
        return valueToReturn;
    }
}

package playing.agameofchance.players;

import playing.agameofchance.gamelogicandstatistics.Statistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * We define the player with several attributes that are given when the player is registered.
 */
public class Player implements Comparable<Player> {
    private String name;
    private int age;
    private String occupation;
    private int emptySpace;
    private Statistics statisticsForPlayer;

    public Player(String name, int age, String occupation, int emptySpace) throws InterruptedException {
        this.emptySpace = emptySpace;
        this.name = setName(name, true);
        this.age = setAge(age, true);
        this.occupation = setOccupation(occupation, true);
        this.statisticsForPlayer = new Statistics(getEmptySpace());
    }

    public String getName() {
        return name;
    }

    public String setName(String name, boolean forConstructor) throws InterruptedException {
        StringBuilder valueFromUser = new StringBuilder();
        List<String> tempListWithNameComponents = new ArrayList<>(Arrays.asList(name.toLowerCase().trim().split(" +")));
        String errorMessage = String.format("%n%s%s%n", " ".repeat(emptySpace), "ERROR please provide firstname and lastname for the player!");

        if (name.isBlank()) {
            valueFromUser.append("none");
            System.out.printf("%s", errorMessage);
            TimeUnit.SECONDS.sleep(1);
        } else {
            for (int i = 0; i < tempListWithNameComponents.size(); i++) {
                String element = tempListWithNameComponents.get(i).trim();

                if (!element.isBlank()) {
                    valueFromUser.append(Character.toTitleCase(element.charAt(0))).append(element.substring(1));

                    if (i != (tempListWithNameComponents.size() - 1)) {
                        valueFromUser.append(", ");
                    }
                } else {
                    valueFromUser.delete(0, 2);
                    valueFromUser.append("none");
                    break;
                }
            }
        }

        if (!forConstructor) {
            this.name = valueFromUser.toString();
        }

        return valueFromUser.toString();
    }

    public int getAge() {
        return age;
    }

    public int setAge(int age, boolean forConstructor) throws InterruptedException {
        int valueToReturn = -1;
        String errorMessage = String.format("%n%s%s%n", " ".repeat(getEmptySpace()), "ERROR please use an age equal to or greater than 18!");

        if (age < 18) {
            System.out.printf("%s", errorMessage);
            TimeUnit.SECONDS.sleep(1);
        } else {
            valueToReturn = age;
        }

        if (!forConstructor) {
            this.age = valueToReturn;
        }

        return valueToReturn;
    }

    public String getOccupation() {
        return occupation;
    }

    public String setOccupation(String occupation, boolean forConstructor) throws InterruptedException {
        StringBuilder valueToReturn = new StringBuilder();
        String errorMessage = String.format("%n%s%s%n", " ".repeat(getEmptySpace()), "ERROR please provide a valid occupation!");

        try {
            if (occupation.isBlank() || ((Double.parseDouble(occupation.trim()) * (-1)) != 0)) {
                System.out.printf("%s", errorMessage);
                Thread.sleep(1000);
            }
        } catch (NumberFormatException e) {
            ArrayList<String> occupationAsList = new ArrayList<>(Arrays.asList(occupation.toLowerCase().split(" +")));
            String word;
            if (occupationAsList.size() > 1) {
                for (String s : occupationAsList) {
                    word = s.trim();

                    valueToReturn.append(Character.toTitleCase(word.charAt(0))).append(word.substring(1)).append(" ");
                }
            } else {
                valueToReturn.append(Character.toTitleCase(occupation.trim().charAt(0))).append(occupation.trim().substring(1)).append(" ");
            }
        }

        String occupationProcessed = valueToReturn.toString().trim();

        if (!forConstructor) {
            this.occupation = occupationProcessed;
        }

        return occupationProcessed;
    }

    public int getEmptySpace() {
        return emptySpace;
    }

    public Statistics getStatisticsForPlayer() {
        return statisticsForPlayer;
    }

    @Override
    public int compareTo(Player o) {
        Objects.requireNonNull(o);

        int valueToReturn = o.name.compareToIgnoreCase(name);

        if (valueToReturn == 0) {
            valueToReturn = Integer.compare(o.age, age);

            if (valueToReturn == 0) {
                valueToReturn = o.occupation.compareToIgnoreCase(occupation);
            }
        }

        return valueToReturn;
    }

    @Override
    public boolean equals(Object o) {
        boolean valueToReturn;

        if (this == o) {
            valueToReturn = true;
        } else if (o == null || getClass() != o.getClass()) {
            valueToReturn = false;
        } else {
            Player player = (Player) o;

            if ((!getName().equals(player.getName())) || (player.age != age))  {
                valueToReturn = false;
            } else {
                valueToReturn = getOccupation().equals(player.getOccupation());
            }
        }

        return valueToReturn;
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();

        result = 23 * result + getAge();
        result = 23 * result + getOccupation().hashCode();

        return result;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %s, Occupation: %s", getName(), getAge(), getAge());
    }
}

package playing.agameofchance.menucreation;

import playing.agameofchance.players.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Menu {
    private Integer numberOfEntriesInTheMenu;
    private LinkedList<String> optionsForMenu;
    private String messageAtTheBottom;
    private Integer emptySpacesForMainMenu;
    private final boolean ifMainMenu;
    private Header headerForGame;
    private Player currentPlayer;

    public Menu(Integer numberOfEntriesInTheMenu, String messageAtTheBottom, Integer emptySpacesForMainMenu, boolean ifMainMenu) throws InterruptedException {
        this.emptySpacesForMainMenu = setEmptySpacesForMainMenu(emptySpacesForMainMenu, true);
        this.numberOfEntriesInTheMenu = setNumberOfEntriesInTheMenu(numberOfEntriesInTheMenu, true);
        this.ifMainMenu = ifMainMenu;
        this.optionsForMenu = setOptionsForMenu();
        this.messageAtTheBottom = setMessageAtTheBottom(messageAtTheBottom, true);
        this.currentPlayer = new Player("none", 18, "engineer", 2);
    }

    public int setNumberOfEntriesInTheMenu(Integer numberOfEntriesInTheMenu, boolean forConstructor) throws InterruptedException {
        Integer valueToReturn = (ifMainMenu) ? 2 : 3;
        String errorMessage = String.format("%n%s%s%s%s%s%s%s%n", " ".repeat(getEmptySpacesForMainMenu()), "ERROR please use at least ",
                valueToReturn, " options ", " for ",(isIfMainMenu()) ? "main menu" : "secondary menu", ". In this case it will go to a default value!");

        if ((numberOfEntriesInTheMenu < valueToReturn)) {
            System.out.printf("%s", errorMessage);
            TimeUnit.SECONDS.sleep(1);
        } else {
            valueToReturn = numberOfEntriesInTheMenu;
        }

        if (!forConstructor) {
            this.numberOfEntriesInTheMenu = valueToReturn;
        }

        return valueToReturn;
    }

    public Integer getEmptySpacesForMainMenu() {
        return emptySpacesForMainMenu;
    }

    public Integer setEmptySpacesForMainMenu(Integer emptySpacesForMainMenu, boolean forConstructor) throws InterruptedException {
        Integer valueToReturn = 2;
        String errorMessage = String.format("%n%s%s%n", " ".repeat(valueToReturn), "ERROR please use a value greater than zero for empty spaces!");

        if (emptySpacesForMainMenu < 0) {
            System.out.printf("%s", errorMessage);
            TimeUnit.SECONDS.sleep(1);
        } else {
            valueToReturn = emptySpacesForMainMenu;
        }

        if (!forConstructor) {
            this.emptySpacesForMainMenu = valueToReturn;
        }

        return valueToReturn;
    }

    public LinkedList<String> getOptionsForMenu() {
        return optionsForMenu;
    }

    public LinkedList<String> setOptionsForMenu() {
        if (ifMainMenu) {
            this.optionsForMenu = new LinkedList<>();
        }

        return optionsForMenu;
    }

    public String getMessageAtTheBottom() {
        return messageAtTheBottom;
    }

    public String printMessageAtTheBottom(boolean ifToPrint) {
        if (ifToPrint) {
            System.out.printf("%s%s ", " ".repeat(getEmptySpacesForMainMenu()), getMessageAtTheBottom());
        }

        return messageAtTheBottom;
    }

    public String setMessageAtTheBottom(String messageAtTheBottom, boolean forConstructor) throws InterruptedException {
        StringBuilder valueToReturn;
        String errorMessage = String.format("%n%s%s%n", " ".repeat(getEmptySpacesForMainMenu()), "ERROR please provide a valid message for the moment when you provide an input!");

        valueToReturn = new StringBuilder((isIfMainMenu()) ? "provide an option from above: " : "provide the requested input (back/quit): ");

        if (messageAtTheBottom.isBlank()) {
            System.out.printf("%s", errorMessage);
            TimeUnit.SECONDS.sleep(1);
        } else {
            valueToReturn = new StringBuilder();
            List<String> temp = new ArrayList<>(Arrays.asList(messageAtTheBottom.toLowerCase().split(" +")));

            for (int i = 0; i < temp.size(); i++) {
                valueToReturn.append(temp.get(i).trim());

                if (i != temp.size() - 1) {
                    valueToReturn.append(" ");
                }
            }
        }

        if (!forConstructor) {
            this.messageAtTheBottom = valueToReturn.toString();
        }

        return valueToReturn.toString();
    }

    public boolean isIfMainMenu() {
        return ifMainMenu;
    }

    public Integer getNumberOfEntriesInTheMenu() {
        return numberOfEntriesInTheMenu;
    }

    public void addOptionsForMenu(String givenOptions) {
        List<String> temporaryListWithOptions = new ArrayList<>(List.of(givenOptions.toLowerCase().trim().split(",")));
        StringBuilder optionToBeAdded;

        if (!temporaryListWithOptions.isEmpty()) {
            for (int i = temporaryListWithOptions.size() - 1; i >= 0; i--) {

                String element = temporaryListWithOptions.get(i).trim();

                if (!getOptionsForMenu().contains(element)) {
                    optionToBeAdded = new StringBuilder();

                    for (String word : element.split(" +")) {
                        optionToBeAdded.append(Character.toTitleCase(word.charAt(0)) + word.substring(1)).append(" ");
                    }

                    if (getOptionsForMenu().size() <= getNumberOfEntriesInTheMenu()) {
                        getOptionsForMenu().push(optionToBeAdded.toString());
                    }
                }
            }
        }
    }

    public Header getHeaderForGame() {
        return headerForGame;
    }

    public void printHeaderMenu() throws InterruptedException {
        getHeaderForGame().printHeaderWithAllItsTrimmings();
    }

    public void printHeaderSubMenu(String subMenuMessage, boolean ifSubMenu, int emptySpaceAbove, int emptySpaceBellow, int emptySpaceSubHeader) throws InterruptedException {
        getHeaderForGame().printHeaderWithAllItsTrimmings(subMenuMessage, ifSubMenu, emptySpaceAbove, emptySpaceBellow, emptySpaceSubHeader);
    }

    public Player setCurrentPlayer(Player currentPlayer, boolean forConstructor) {
        if (!forConstructor) {
            this.currentPlayer = currentPlayer;
        }

        return currentPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Header setHeaderForGame(String messageToBeUsed, String additionCharactersInFrontAndBack, String separatingWithCharacters,
                                   int emptySpaces, int emptySpacesAbove, int emptySpacesBellow, boolean forConstructor) throws InterruptedException {
        Header toBeUsed = new Header(messageToBeUsed, additionCharactersInFrontAndBack, separatingWithCharacters,
                emptySpaces, emptySpacesAbove, emptySpacesBellow);

        if (!forConstructor) {
            this.headerForGame = toBeUsed;
        }

        return toBeUsed;
    }

    public List<String> resetOptionsForMainMenu() {
        this.optionsForMenu = new LinkedList<>();
        return optionsForMenu;
    }

    public void printMenu() {
        for (int i = 0; i < optionsForMenu.size(); i++) {
            System.out.printf("%s%s%s%s%s%n", " ".repeat(getEmptySpacesForMainMenu()), "[ ", (i+1), " ] ", optionsForMenu.get(i));
        }

        System.out.printf("%n%s%s%s", " ".repeat(getEmptySpacesForMainMenu()), "player: ", getCurrentPlayer().getName());
        System.out.printf("%n%s%s%n", " ".repeat(getEmptySpacesForMainMenu()), "-".repeat(getHeaderForGame().getMessageToBeUsed().length()));
        printMessageAtTheBottom(true);
    }
}

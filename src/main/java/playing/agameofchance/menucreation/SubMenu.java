package playing.agameofchance.menucreation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SubMenu extends Menu {
    private LinkedList<String> optionsOnOneLine;
    private String content;

    public SubMenu(int numberOfEntriesInTheMenu, String messageAtTheBottom, int emptySpaceForMainMenu, boolean ifMainMenu) throws InterruptedException {
        super(numberOfEntriesInTheMenu, messageAtTheBottom, emptySpaceForMainMenu, ifMainMenu);
        this.optionsOnOneLine = new LinkedList<>();
        this.content = "";
    }

    public List<String> getOptionsOnOneLine() {
        return optionsOnOneLine;
    }

    public void printOptionsForSubMenu(String givenMessage) {
        if (givenMessage.isBlank()) {
            givenMessage = "no proper given message given, please check";
            System.out.printf("%n%s%s", " ".repeat(getEmptySpacesForMainMenu()), givenMessage);
        } else {
            String optionsConvertedToString = String.join(", ", optionsOnOneLine);
            System.out.printf("%n%s%s %s%s", " ".repeat(getEmptySpacesForMainMenu()), givenMessage, optionsConvertedToString, " separated by a comma.");
        }
    }

    public void printMessageForSubMenu() {
        System.out.printf("%n%s%s ", " ".repeat(getEmptySpacesForMainMenu()), getMessageAtTheBottom());
    }

    public void printSeparatedLineBottom() {
        System.out.printf("%n%n%s%s%s", " ".repeat(getEmptySpacesForMainMenu()), "player: ", getCurrentPlayer().getName());
        System.out.printf("%n%s%s", " ".repeat(getEmptySpacesForMainMenu()), getHeaderForGame().getSeparatingWithCharacters().repeat(getHeaderForGame().getMessageToBeUsed().length()));
    }

    public String getContent() {
        return content;
    }

    private String processingContent(String givenContent) {
        List<String> tempListWithContent = new ArrayList<>(Arrays.asList(givenContent.split("\\.")));
        StringBuilder processedStringAndReadyToBePrinted = new StringBuilder();
        int count = 0;

        processedStringAndReadyToBePrinted.append(String.format("%n%s", " ".repeat(getEmptySpacesForMainMenu())));

        for (String s : tempListWithContent) {
            if ((count != 0) && (count % 2 == 0)) {
                processedStringAndReadyToBePrinted.append(String.format("%n%s", " ".repeat(getEmptySpacesForMainMenu())));
            }

            processedStringAndReadyToBePrinted.append(String.format("%s", s.trim())).append(". ");
            count += 1;
        }

        return processedStringAndReadyToBePrinted.toString();
    }

    public String addContent(String valueFromUser, boolean forConstructor) {
        StringBuilder valueAlreadyExists = new StringBuilder(getContent());

        if (!valueFromUser.isBlank()) {
            valueAlreadyExists.append(" ").append(valueFromUser.trim());
        }

        if (!forConstructor) {
            this.content = processingContent(valueAlreadyExists.toString());
        }

        return processingContent(valueAlreadyExists.toString());
    }

    public List<String> addOptionsForSubMenu(String givenValues) throws InterruptedException {
        LinkedList<String> tempWithOptions;
        String errorMessage = String.format("%n%s%s%n", " ".repeat(getEmptySpacesForMainMenu()), "ERROR please use a list of options you want to add separated by a comma!");

        if (givenValues.isBlank()) {
            System.out.printf("%s", errorMessage);
            TimeUnit.SECONDS.sleep(1);
        } else {
            tempWithOptions = new LinkedList<>(Arrays.asList(givenValues.toLowerCase().trim().split(",")));

            for (int i = tempWithOptions.size() - 1; i >= 0; i--) {
                String word = tempWithOptions.get(i).trim();
                this.optionsOnOneLine.push(word);
            }
        }

       return optionsOnOneLine;
    }

    public void printContent() {
        System.out.printf("%s", getContent());
    }
}

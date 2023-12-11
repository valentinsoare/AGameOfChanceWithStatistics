package playing.agameofchance.menucreation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Loading effect used after each integration between player and the app.
 */
public class Loading {
    private Character passed;
    private Character notPassed;
    private String messageMainLoading;

    public Loading(String messageMainLoading, Character notPassed, Character passed) {
        this.messageMainLoading = setMessageMainLoading(messageMainLoading, true);
        this.notPassed = setNotPassed(notPassed, true);
        this.passed = setPassed(passed, true);
    }

    /**
     * Here we run the loading effect which is a progress bar used at the start of the application
     */
    public void loadProgressBar(int barSize, int emptySpaceBellow, int emptySpaceAbove, int emptySpaceInFront) throws InterruptedException {
        String toBePrinted;
        int status, move;

        StringBuilder bar = new StringBuilder();
        bar.append(String.valueOf(notPassed).repeat(Math.max(0, barSize)));

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.printf("%s%s%s%s", "\n".repeat(emptySpaceAbove), " ".repeat(emptySpaceInFront * 3), getMessageMainLoading(), "\n".repeat(emptySpaceBellow));

        for (int i = 1; i <= barSize; i++) {
            status = (100 * (i - 1)) / (barSize - 1);
            move = (barSize * status) / 100;

            toBePrinted = String.format("%s", ("[" + bar.substring(0, move).replace(notPassed, passed) + " " + status + "%" + bar.substring(move, bar.length()) + "]"));
            System.out.printf("\r%s%s", " ".repeat(emptySpaceInFront), toBePrinted);
            Thread.sleep(75);
        }

        System.out.printf("%s%n", " COMPLETE");
        Thread.sleep(1000);
    }

    /**
     * Here is the effect run after each interaction between player and app. It is using a char from user to animate
     * the loading effect with a message in front of it.
     */
    public static void starting(int numberOfChars, char charFromUser, String messageInFront,
                                int timeToSleep, boolean ifDone, String messageEnd) throws InterruptedException {
        System.out.printf("%s", messageInFront);

        for (int i = 0; i < numberOfChars; i++) {
            System.out.printf("%s", charFromUser);
            Thread.sleep(timeToSleep);
        }

        if (ifDone) {
            System.out.printf("%s%n", messageEnd);
        } else {
            System.out.println();
        }
    }

    /**
    We validate the char that is used to display a pass portion from loading with progress bar.
     */
    public char setPassed(Character passed, boolean forConstructor) {
        Character valueToReturn = passed;

        if (passed.toString().isBlank()) {
            valueToReturn = '#';
        }

        if (!forConstructor) {
            this.passed = valueToReturn;
        }

        return valueToReturn;
    }

    /**
     * Same thing like above, but char is for a portion that the current progress didn't reach.
     */
    public char setNotPassed(Character notPassed, boolean forConstructor) {
        Character valueToReturn = notPassed;

        if (notPassed.toString().isEmpty()) {
            valueToReturn = ' ';
        }

        if (!forConstructor) {
            this.notPassed = valueToReturn;
        }

        return valueToReturn;
    }

    /**
     * Validate the main message from the loading` effect.
     */
    public String setMessageMainLoading(String messageMainLoading, boolean forConstructor) {
        StringBuilder valueToReturn = new StringBuilder();

        if (messageMainLoading.isBlank()) {
            valueToReturn.append("Loading");
        } else {
            List<String> tempListWithComponentsOfMessage = new ArrayList<>(Arrays.asList(messageMainLoading.toLowerCase().trim().split(" +")));

            for (String element : tempListWithComponentsOfMessage) {
                valueToReturn.append(element.toUpperCase().charAt(0)).append(element.substring(1)).append(" ");
            }
        }

        if (!forConstructor) {
            this.messageMainLoading = valueToReturn.toString();
        }

        return valueToReturn.toString();
    }

    public String getMessageMainLoading() {
        return messageMainLoading;
    }
}

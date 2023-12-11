package playing.agameofchance;

import playing.agameofchance.gamelogicandstatistics.Action;
import playing.agameofchance.menucreation.Loading;
import playing.agameofchance.menucreation.Menu;

/**
 * From this we lunch the game and give the control to the Action class from the 'gamelogicandstatistics' package
 */
public class Play {
    public static void main(String[] args) throws InterruptedException {
        String valueToCheck = "";
        Action useAction = new Action(2);

        Loading mainMenuLoadingBar = new Loading("loading the game of craps", ' ', '#');

        Menu mainMenu = new Menu(9, "provide an option: ", 2, true);
        mainMenu.setHeaderForGame("playing the game of craps", " # ", "-",
                2, 2, 2, false);
        mainMenu.addOptionsForMenu("Games to be played, play one game, print statistics, register player, change player, reset games statistics, print players ,help, quit");

        mainMenuLoadingBar.loadProgressBar(40, 2, 2, 5);

        while (!"quit".equals(valueToCheck)) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            mainMenu.printHeaderMenu();
            mainMenu.printMenu();
            useAction.readInputFromUser(false);
            valueToCheck = useAction.actOnInputFromMenu();

            if (!useAction.getRegisteredPlayers().isEmpty()) {
                mainMenu.setCurrentPlayer(useAction.getModules().get(0).getCurrentPlayer(), false);
            }
        }
    }
}

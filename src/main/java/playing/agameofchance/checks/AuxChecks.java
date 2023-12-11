package playing.agameofchance.checks;

import playing.agameofchance.menucreation.Loading;

import java.util.concurrent.TimeUnit;


/**
 * Various checks to use in order to validate input.
 */
public class AuxChecks {

    private AuxChecks() {}

    /**
     * @param valueFromUser -> here we have the value from user as an input.
     * @param emptySpaces   -> how many empty spaces from the left of the screen to use on displaying the messages.
     * @param ifMainMenu    -> here we set the type of menu we used when taking input, menu or submenu.
     * Down below there is a method that checks if a player entered from the keyboard 'quit' or 'back', also is doing the
     * checking if any wrong input was provided and if that happened, error message is delivered taking into consideration
     * from where this function was called, menu, submenu.
     * And as you see this method is throwing/pushing InterruptedException up the stack.
     * @throws InterruptedException
     */
    public static String checkForQuitAndBack(String valueFromUser, int emptySpaces, boolean ifMainMenu) throws InterruptedException {
       String valueToReturn = valueFromUser;

        /*
         * Line below is setting the error message considering if boolean value ifMainMenu was set to true or false, if we have
         * a menu or submenu of the application.
         */
        String errorMessage = (ifMainMenu) ? String.format("%n%s%s%n", " ".repeat(emptySpaces),"ERROR please choose an option from those mentioned above!")
               : String.format("%n%s%s%n", " ".repeat(emptySpaces), "ERROR please provide requested input or back/quit!");

       if (valueFromUser.isBlank()) {
           System.out.println(errorMessage);
           TimeUnit.SECONDS.sleep(1);
           valueToReturn = "none";
       } else {
           String inputFromUser = valueFromUser.toLowerCase().trim();

           /*
            * Here it detects if input from player was 'quit' and if this is the case, then displaying the message
            * "Quiting" with loading effect
            */

           if ("quit".equals(inputFromUser)) {
               String quitingMessage = String.format("%n%s%s", " ".repeat(emptySpaces), "Quiting");

               /*
                * This is the loading effect that is displayed after the 'quiting' message.
                */
               Loading.starting(5,'.', quitingMessage, 100, true, "DONE");
               Thread.sleep(100);

               if (ifMainMenu) {
                   return "quit";
               }

               System.exit(0);
           } else if ("back".equals(inputFromUser)) {

               /*
                * Same here like from above with 'quiting', but here we 'back' as an input from user and it is showing "Going back"
                * with loading effect
                */
               valueToReturn = "back";
               String goingBackMessage = String.format("%n%s%s", " ".repeat(emptySpaces), "Going back");

               Loading.starting( 5,'.', goingBackMessage, 200, true, "DONE");
               Thread.sleep(500);
           }
       }

       return valueToReturn;
    }
}

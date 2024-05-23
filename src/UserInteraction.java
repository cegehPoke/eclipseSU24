import java.util.Scanner;

class UserInteraction {
    private Scanner scanner;

    public UserInteraction() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("The commands are: show, new, select, delete, sort, reverse, randomize, save, restore, quit.");
        System.out.print("Please enter a command: ");
    }

    public String getUserInput() {
        return scanner.nextLine().trim().toLowerCase();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
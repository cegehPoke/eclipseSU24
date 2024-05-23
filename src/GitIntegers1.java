import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Class to run the Integer Sets application
public class GitIntegers1 {
    private UserInteraction ui;
    private CollectionSetsOfIntegers collection;

    public GitIntegers1() {
        this.ui = new UserInteraction();
        this.collection = new CollectionSetsOfIntegers();
    }

    public void run() {
        boolean running = true;
        while (running) {
            ui.displayMenu();
            String command = ui.getUserInput();
            switch (command) {
                case "new":
                    handleNewSet();
                    break;
                case "show":
                    handleShowSets();
                    break;
                case "select":
                    handleSelectSet();
                    break;
                case "delete":
                    handleDeleteSet();
                    break;
                case "sort":
                    handleSortSet();
                    break;
                case "reverse":
                    handleReverseSet();
                    break;
                case "randomize":
                    handleRandomizeSet();
                    break;
                case "save":
                    handleSaveSets();
                    break;
                case "restore":
                    handleRestoreSets();
                    break;
                case "quit":
                    running = false;
                    break;
                default:
                    ui.showMessage("Invalid command. Please try again.");
            }
        }
    }

    private void handleNewSet() {
        SetOfIntegers newSet = new SetOfIntegers();
        ui.showMessage("Enter elements for the new set (comma separated):");
        String[] elements = ui.getUserInput().split(",");
        for (String elem : elements) {
            newSet.addElement(Integer.parseInt(elem.trim()));
        }
        collection.addSet(newSet);
        ui.showMessage("New set added.");
    }

    private void handleShowSets() {
        for (int i = 0; i < collection.size(); i++) {
            SetOfIntegers set = collection.getSet(i);
            ui.showMessage("Set " + (i + 1) + ": " + set.getElements() + " (State: " + set.getState() + ")");
        }
    }

    private void handleSelectSet() {
        ui.showMessage("Enter the index of the set to select:");
        int index = Integer.parseInt(ui.getUserInput());
        SetOfIntegers set = collection.getSet(index - 1);
        if (set != null) {
            ui.showMessage("Selected Set " + index + ": " + set.getElements());
        } else {
            ui.showMessage("Invalid index.");
        }
    }

    private void handleSortSet() {
        ui.showMessage("Enter the index of the set to sort:");
        int index = Integer.parseInt(ui.getUserInput());
        SetOfIntegers set = collection.getSet(index - 1);
        if (set != null) {
            ui.showMessage("Sort in increasing order? (true/false):");
            boolean increasing = Boolean.parseBoolean(ui.getUserInput());
            int swaps = set.sort(increasing);
            ui.showMessage("Set sorted with " + swaps + " swaps. New set: " + set.getElements());
        } else {
            ui.showMessage("Invalid index.");
        }
    }

    private void handleReverseSet() {
        ui.showMessage("Enter the index of the set to reverse:");
        int index = Integer.parseInt(ui.getUserInput());
        SetOfIntegers set = collection.getSet(index - 1);
        if (set != null) {
            Collections.reverse(set.getElements());
            set.state = "reversed";
            ui.showMessage("Set reversed. New set: " + set.getElements());
        } else {
            ui.showMessage("Invalid index.");
        }
    }

    private void handleRandomizeSet() {
        ui.showMessage("Enter the index of the set to randomize:");
        int index = Integer.parseInt(ui.getUserInput());
        SetOfIntegers set = collection.getSet(index - 1);
        if (set != null) {
            int swaps = set.randomSort();
            ui.showMessage("Set randomized with " + swaps + " swaps. New set: " + set.getElements());
        } else {
            ui.showMessage("Invalid index.");
        }
    }

    private void handleDeleteSet() {
        ui.showMessage("Enter the index of the set to delete:");
        int index = Integer.parseInt(ui.getUserInput());
        collection.deleteSet(index - 1);
        ui.showMessage("Set deleted.");
    }

    private void handleSaveSets() {
        // Implementation for saving sets
    }

    private void handleRestoreSets() {
        // Implementation for restoring sets
    }

    public static void main(String[] args) {
    	GitIntegers1 app = new GitIntegers1();
        app.run();
    }
}

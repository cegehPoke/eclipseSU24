import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Class representing a set of integers
class SetOfIntegers {
    private List<Integer> elements;
    String state;

    public SetOfIntegers() {
        this.elements = new ArrayList<>();
        this.state = "random";
    }

    public int sort(boolean increasing) {
        int swaps = 0;
        for (int i = 0; i < elements.size() - 1; i++) {
            for (int j = 0; j < elements.size() - i - 1; j++) {
                if ((increasing && elements.get(j) > elements.get(j + 1)) ||
                    (!increasing && elements.get(j) < elements.get(j + 1))) {
                    Collections.swap(elements, j, j + 1);
                    swaps++;
                }
            }
        }
        state = increasing ? "increasing" : "decreasing";
        return swaps;
    }

    public int randomSort() {
        List<Integer> tempList = new ArrayList<>(elements);
        Collections.shuffle(tempList);
        int swaps = 0;
        for (int i = 0; i < elements.size(); i++) {
            if (!elements.get(i).equals(tempList.get(i))) {
                swaps++;
                elements.set(i, tempList.get(i));
            }
        }
        state = "random";
        return swaps;
    }

    public void addElement(int element) {
        elements.add(element);
    }

    public boolean contains(int element) {
        return elements.contains(element);
    }

    public int size() {
        return elements.size();
    }

    public List<Integer> getElements() {
        return elements;
    }

    public String getState() {
        return state;
    }
}
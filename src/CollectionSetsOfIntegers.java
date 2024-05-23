
import java.util.ArrayList;
import java.util.List;


// Class representing a collection of sets of integers
class CollectionSetsOfIntegers {
    private List<SetOfIntegers> sets;
    private String state;

    public CollectionSetsOfIntegers() {
        this.sets = new ArrayList<>();
        this.state = "unsorted";
    }

    public void addSet(SetOfIntegers set) {
        sets.add(set);
    }

    public void deleteSet(int index) {
        if (index >= 0 && index < sets.size()) {
            sets.remove(index);
        }
    }

    public SetOfIntegers getSet(int index) {
        if (index >= 0 && index < sets.size()) {
            return sets.get(index);
        }
        return null;
    }

    public int size() {
        return sets.size();
    }

    public void clear() {
        sets.clear();
    }
}

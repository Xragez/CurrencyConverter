import java.util.ArrayList;

public interface CollectionInterface {
    void add(Currency c);
    Currency getByName(String name);
    ArrayList<String> getNameList();
}

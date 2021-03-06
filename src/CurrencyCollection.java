import java.util.ArrayList;

public class CurrencyCollection implements CollectionInterface{
    private ArrayList<Currency> clist = new ArrayList<>();

    @Override
    public void add(Currency c) {
        clist.add(c);
    }

    @Override
    public Currency getByName(String name) {
        for(Currency c : clist){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    @Override
    public ArrayList<String> getNameList() {
        ArrayList<String> nameList = new ArrayList<String>();
        for(Currency c : clist){
            nameList.add(c.getName());
        }
        return nameList;
    }


}

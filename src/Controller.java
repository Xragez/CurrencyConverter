import java.util.ArrayList;

public class Controller implements ConverterInterface {
    private CurrencyCollection model;
    private View view;

    public Controller(CurrencyCollection model, View view){
        this.model = model;
        this.view = view;
    }

    private ArrayList<String> getCurrencyNames(){
        return model.getNameList();
    }


    public void initView(){
        view.init(getCurrencyNames());
    }

    public void updateView( Double amount, String currencyName1, String currencyName2){
        String result = convert(amount, model.getByName(currencyName1), model.getByName(currencyName2));
        view.updateView(result);
    }

    public void addListener(){
        view.AddListener(this);
    }

    @Override
    public String convert(Double amount, Currency currency1, Currency currency2) {
        Double ret = (amount*currency1.getValue()/currency1.getConverter())/
                (currency2.getValue()/currency2.getConverter());
        ret = Math.floor(ret * 100)/100;
        return ret.toString() + ' ' +currency2.getCode();
    }
}

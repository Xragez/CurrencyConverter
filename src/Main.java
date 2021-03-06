import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

public class Main {
    public static void main(String[] args){
        CurrencyCollection model = loadDataFromXml();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.initView();
        controller.addListener();

    }
    private static Double stringToDouble(String value){
        String temp = value.substring(0,1) + '.' + value.substring(2);
        return Double.parseDouble(temp);
    }

    private static CurrencyCollection loadDataFromXml(){
        String url = "https://www.nbp.pl/kursy/xml/lasta.xml";
        CurrencyCollection collection = new CurrencyCollection();
        String name;
        String code;
        int converter;
        Double value;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new URL(url).openStream());
            doc.getDocumentElement().normalize();
            NodeList nlist = doc.getElementsByTagName("pozycja");
            for(int i = 0; i < nlist.getLength(); i ++){
                Node nNode = nlist.item(i);
                Currency cu = new Currency();

                if(nNode.getNodeType() == Node.ELEMENT_NODE){

                    Element e = (Element) nNode;
                    name = e.getElementsByTagName("nazwa_waluty").item(0).getTextContent();
                    converter = Integer.parseInt(e.getElementsByTagName("przelicznik").item(0).getTextContent());
                    code = e.getElementsByTagName("kod_waluty").item(0).getTextContent();
                    value = stringToDouble(e.getElementsByTagName("kurs_sredni").item(0).getTextContent());

                    cu.setName(name);
                    cu.setConverter(converter);
                    cu.setCode(code);
                    cu.setValue(value);
                }
                collection.add(cu);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return collection;
    }
}

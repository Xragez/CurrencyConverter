public class Currency {
    private String name;
    private String code;
    private Integer converter;
    private Double value;

    public Currency(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getConverter() {
        return converter;
    }

    public void setConverter(Integer converter) {
        this.converter = converter;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}

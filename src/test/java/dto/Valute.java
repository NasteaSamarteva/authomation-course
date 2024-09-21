package dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Valute")
public class Valute {

    @XStreamAlias("ID")
    @XStreamAsAttribute
    private Integer id;

    @XStreamAlias("NumCode")
    private String numCode;

    @XStreamAlias("CharCode")
    private String charCode;

    @XStreamAlias("Nominal")
    private Integer nominal;

    @XStreamAlias("Name")
    private String name;

    @XStreamAlias("Value")
    private Double value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}

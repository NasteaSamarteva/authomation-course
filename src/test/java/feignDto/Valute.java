package feignDto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Valute {

        @JacksonXmlProperty(localName = "ID")
        private Integer id;

        @JacksonXmlProperty(localName = "NumCode")
        private String numCode;

        @JacksonXmlProperty(localName ="CharCode")
        private String charCode;

        @JacksonXmlProperty(localName ="Nominal")
        private Integer nominal;

        @JacksonXmlProperty(localName ="Name")
        private String name;

        @JacksonXmlProperty(localName ="Value")
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

package feignDto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class ValCurs {

        @JacksonXmlProperty(localName = "Date")
        private String date;

        @JacksonXmlProperty(localName ="Name")
        private String name;

        private List<feignDto.Valute> valutes = new ArrayList<>();

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<feignDto.Valute> getValutes() {
            return valutes;
        }

        public void setValutes(List<feignDto.Valute> valutes) {
            this.valutes = valutes;
        }
    }

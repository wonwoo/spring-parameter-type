package ml.wonwoo.springparametertype.data;

import org.springframework.data.web.JsonPath;
import org.springframework.data.web.ProjectedPayload;
import org.xmlbeam.annotation.XBRead;

@ProjectedPayload
public interface PayLoadExample {

    @XBRead("//name1")
    @JsonPath("$..name1")
    String getName();
}
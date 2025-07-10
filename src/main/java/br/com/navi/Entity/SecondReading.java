package br.com.navi.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecondReading implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("referencia")
    private String reference;

    @JsonProperty("titulo")
    private String title;

    @JsonProperty("texto")
    private String text;

    @Override
    public String toString() {
        return "SecondReading{" +
                "reference='" + reference + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

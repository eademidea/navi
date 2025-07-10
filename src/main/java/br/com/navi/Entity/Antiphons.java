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
public class Antiphons implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("entrada")
    private String entrance;

    @JsonProperty("comunhao")
    private String communion;

    @Override
    public String toString() {
        return "Antiphons{" +
                "entrance='" + entrance + '\'' +
                ", communion='" + communion + '\'' +
                '}';
    }
}

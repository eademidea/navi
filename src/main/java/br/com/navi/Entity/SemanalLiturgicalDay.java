package br.com.navi.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SemanalLiturgicalDay implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("data")
    private String date;

    @JsonProperty("liturgia")
    private String liturgy;

    @JsonProperty("cor")
    private String color;

    @JsonProperty("dia")
    private String dayPrayer;

    @JsonProperty("oferendas")
    private String offerings;

    @JsonProperty("comunhao")
    private String communionPrayer;

    @JsonProperty("primeiraLeitura")
    private FirstReading firstReading;

    @JsonProperty("salmo")
    private Psalm psalm;

    @JsonProperty("segundaLeitura")
    private String secondReading;

    @JsonProperty("evangelho")
    private Gospel gospel;

    @JsonProperty("antifonas")
    private Antiphons antiphons;

    @Override
    public String toString() {
        return "LiturgicalDay{" +
                "date='" + date + '\'' +
                ", liturgy='" + liturgy + '\'' +
                ", color='" + color + '\'' +
                ", dayPrayer='" + dayPrayer + '\'' +
                ", offerings='" + offerings + '\'' +
                ", communionPrayer='" + communionPrayer + '\'' +
                ", firstReading=" + firstReading +
                ", psalm=" + psalm +
                ", secondReading=" + secondReading +
                ", gospel=" + gospel +
                ", antiphons=" + antiphons +
                '}';
    }

}

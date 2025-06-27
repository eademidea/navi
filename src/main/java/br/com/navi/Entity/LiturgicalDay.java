package br.com.navi.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LiturgicalDay implements Serializable {
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
    private SecondReading secondReading;

    @JsonProperty("evangelho")
    private Gospel gospel;

    @JsonProperty("antifonas")
    private Antiphons antiphons;

    @ToString
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FirstReading implements Serializable {

        private static final long serialVersionUID = 1L;

        @JsonProperty("referencia")
        private String reference;

        @JsonProperty("titulo")
        private String title;

        @JsonProperty("texto")
        private String text;

        @Override
        public String toString() {
            return "FirstReading{" +
                    "reference='" + reference + '\'' +
                    ", title='" + title + '\'' +
                    ", text='" + text + '\'' +
                    '}';
        }

    }

    @ToString
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Psalm implements Serializable {
        private static final long serialVersionUID = 1L;

        @JsonProperty("referencia")
        private String reference;

        @JsonProperty("refrao")
        private String refrain;

        @JsonProperty("texto")
        private String text;

        @Override
        public String toString() {
            return "Psalm{" +
                    "reference='" + reference + '\'' +
                    ", refrain='" + refrain + '\'' +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    @ToString
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SecondReading implements Serializable {
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

    @ToString
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Gospel implements Serializable {
        private static final long serialVersionUID = 1L;

        @JsonProperty("referencia")
        private String reference;

        @JsonProperty("titulo")
        private String title;

        @JsonProperty("texto")
        private String text;

        @Override
        public String toString() {
            return "Gospel{" +
                    "reference='" + reference + '\'' +
                    ", title='" + title + '\'' +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    @ToString
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Antiphons implements Serializable {
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
}

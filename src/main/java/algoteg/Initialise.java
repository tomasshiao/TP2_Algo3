package algoteg;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import algoteg.Pais;

public class Initialise {
    private Map<String, Object> paises;
    private Map<String, Object> paisesLimitrofes;
    private final List<String> paisesDeAfrica = new ArrayList<String>(Arrays.asList("Egipto", "Etiopia", "Madagascar", "Sahara", "Sudafrica", "Zaire"));
    private final List<String> paisesDeAmericaDelSur = new ArrayList<String>(Arrays.asList("Argentina", "Brasil", "Chile","Colombia", "Peru", "Uruguay"));
    private final List<String> paisesDeAmericaDelNorte = new ArrayList<String>(Arrays.asList("Alaska", "California", "Canada", "Groenlandia","Nueva York", "Mexico", "Oregon", "Terranova", "Yukon"));
    private final List<String> paisesDeAsia = new ArrayList<String>(Arrays.asList("Arabia", "Aral", "China", "Gobi", "India", "Iran", "Israel", "Japon", "Kamchatka", "Malasia", "Mongolia", "Siberia", "Taimir", "Tartaria", "Turquia"));
    private final List<String> paisesDeEuropa = new ArrayList<String>(Arrays.asList("Alemania", "Espana", "Francia", "Gran Bretana", "Islandia", "Italia", "Polonia", "Rusia", "Suecia"));
    private final List<String> paisesDeOceania = new ArrayList<String>(Arrays.asList("Australia", "Borneo", "Java", "Sumatra"));

    private List<Pais> setPaisesAfrica(List<String> paisesDeAfrica){
        List<Pais> paisesAfrica = new ArrayList<Pais>();
        for(String s : paisesDeAfrica){
            Pais p = new Pais(s);
            paisesAfrica.add(p);
        }
        return paisesAfrica;
    }

    private List<Pais> setPaisesAmericaDelSur(List<String> paisesDeAmericaDelSur){
        List<Pais> paisesAmericaDelSur = new ArrayList<Pais>();
        for(String s : paisesDeAmericaDelSur){
            Pais p = new Pais(s);
            paisesAmericaDelSur.add(p);
        }
        return paisesAmericaDelSur;
    }

    private List<Pais> setPaisesAmericaDelNorte(List<String> paisesDeAmericaDelNorte){
        List<Pais> paisesAmericaDelNorte = new ArrayList<Pais>();
        for(String s : paisesDeAmericaDelNorte){
            Pais p = new Pais(s);
            paisesAmericaDelNorte.add(p);
        }
        return paisesAmericaDelNorte;
    }

    private List<Pais> setPaisesAsia(List<String> paisesDeAsia){
        List<Pais> paisesAsia = new ArrayList<Pais>();
        for(String s : paisesDeAsia){
            Pais p = new Pais(s);
            paisesAsia.add(p);
        }
        return paisesAsia;
    }

    private List<Pais> setPaisesEuropa(List<String> paisesDeEuropa){
        List<Pais> paisesEuropa = new ArrayList<Pais>();
        for(String s : paisesDeEuropa){
            Pais p = new Pais(s);
            paisesEuropa.add(p);
        }
        return paisesEuropa;
    }

    private List<Pais> setPaisesOceania(List<String> paisesDeOceania){
        List<Pais> paisesOceania = new ArrayList<Pais>();
        for(String s : paisesDeOceania){
            Pais p = new Pais(s);
            paisesOceania.add(p);
        }
        return paisesOceania;
    }

    private Map<String, Object> setPaises(){
        Map<String, Object> paises = new HashMap<String, Object>();
        paises.put("Africa", this.setPaisesAfrica(paisesDeAfrica));
        paises.put("AmericaDelSur", this.setPaisesAmericaDelSur(paisesDeAmericaDelSur));
        paises.put("AmericaDelNorte", this.setPaisesAmericaDelNorte(paisesDeAmericaDelNorte));
        paises.put("Asia", this.setPaisesAsia(paisesDeAsia));
        paises.put("Europa", this.setPaisesEuropa(paisesDeEuropa));
        paises.put("Oceania", this.setPaisesOceania(paisesDeOceania));
        return paises;
    }

    private Map<String, Object> setPaisesLimitrofes(){
        Map<String, Object> paisesLimitrofes = new HashMap<String, Object>();
        paisesLimitrofes.put("Alaska", new ArrayList<String>(Arrays.asList("Kamchatka", "Oregon", "Yukon")));
        paisesLimitrofes.put("Alemania", new ArrayList<String>(Arrays.asList("Francia", "Gran Bretana", "Italia", "Polonia")));
        paisesLimitrofes.put("Arabia", new ArrayList<String>(Arrays.asList("Israel", "Turquia")));
        paisesLimitrofes.put("Aral", new ArrayList<String>(Arrays.asList("Iran", "Mongolia", "Rusia", "Siberia", "Tartaria")));
        paisesLimitrofes.put("Argentina", new ArrayList<String>(Arrays.asList("Brasil", "Chile", "Peru", "Uruguay")));
        paisesLimitrofes.put("Australia", new ArrayList<String>(Arrays.asList("Borneo", "Chile", "Java", "Sumatra")));
        paisesLimitrofes.put("Borneo", new ArrayList<String>(Arrays.asList("Australia", "Malasia")));
        paisesLimitrofes.put("Brasil", new ArrayList<String>(Arrays.asList("Argentina", "Colombia", "Peru", "Sahara", "Uruguay")));
        paisesLimitrofes.put("California", new ArrayList<String>(Arrays.asList("Mexico", "Nueva York", "Oregon")));
        paisesLimitrofes.put("Canada", new ArrayList<String>(Arrays.asList("Nueva York", "Oregon", "Terranova", "Yukon")));
        paisesLimitrofes.put("Chile", new ArrayList<String>(Arrays.asList("Argentina", "Australia", "Peru")));
        paisesLimitrofes.put("China", new ArrayList<String>(Arrays.asList("Gobi", "India", "Iran", "Japon", "Kamchatka", "Malasia", "Mongolia", "Siberia")));
        paisesLimitrofes.put("Colombia", new ArrayList<String>(Arrays.asList("Brasil", "Mexico", "Peru")));
        paisesLimitrofes.put("Egipto", new ArrayList<String>(Arrays.asList("Etiopia", "Israel", "Madagascar", "Sahara", "Polonia", "Turquia")));
        paisesLimitrofes.put("Espana", new ArrayList<String>(Arrays.asList("Francia", "Gran Bretana", "Sahara")));
        paisesLimitrofes.put("Etiopia", new ArrayList<String>(Arrays.asList("Egipto", "Sahara", "Sudafrica", "Zaire")));
        paisesLimitrofes.put("Francia", new ArrayList<String>(Arrays.asList("Alemania", "Espana", "Italia")));
        paisesLimitrofes.put("Gobi", new ArrayList<String>(Arrays.asList("China", "Iran", "Mongolia")));
        paisesLimitrofes.put("Gran Bretana", new ArrayList<String>(Arrays.asList("Alemania", "Espana", "Islandia")));
        paisesLimitrofes.put("Groenlandia", new ArrayList<String>(Arrays.asList("Islandia", "Labrador", "Nueva York")));
        paisesLimitrofes.put("India", new ArrayList<String>(Arrays.asList("China", "Iran", "Malasia", "Sumatra")));
        paisesLimitrofes.put("Iran", new ArrayList<String>(Arrays.asList("Aral", "China", "Gobi", "India", "Mongolia", "Rusia", "Turquia")));
        paisesLimitrofes.put("Islandia", new ArrayList<String>(Arrays.asList("Gran Bretana", "Groenlandia", "Suecia")));
        paisesLimitrofes.put("Israel", new ArrayList<String>(Arrays.asList("Arabia", "Egipto", "Turquia")));
        paisesLimitrofes.put("Italia", new ArrayList<String>(Arrays.asList("Alemania", "Francia")));
        paisesLimitrofes.put("Japon", new ArrayList<String>(Arrays.asList("China", "Kamchatka")));
        paisesLimitrofes.put("Java", new ArrayList<String>(Arrays.asList("Australia")));
        paisesLimitrofes.put("Kamchatka", new ArrayList<String>(Arrays.asList("Alaska", "China", "Japon", "Siberia")));
        paisesLimitrofes.put("Labrador", new ArrayList<String>(Arrays.asList("Groenlandia", "Terranova")));
        paisesLimitrofes.put("Madagascar", new ArrayList<String>(Arrays.asList("Egipto", "Zaire")));
        paisesLimitrofes.put("Malasia", new ArrayList<String>(Arrays.asList("Borneo", "China", "India")));
        paisesLimitrofes.put("Mexico", new ArrayList<String>(Arrays.asList("California", "Colombia")));
        paisesLimitrofes.put("Mongolia", new ArrayList<String>(Arrays.asList("Aral", "China", "Gobi", "Iran", "Siberia")));
        paisesLimitrofes.put("Nueva York", new ArrayList<String>(Arrays.asList("California", "Canada", "Groenlandia", "Oregon", "Terranova")));
        paisesLimitrofes.put("Oregon", new ArrayList<String>(Arrays.asList("Alaska", "California", "Canada", "Nueva York", "Yukon")));
        paisesLimitrofes.put("Peru", new ArrayList<String>(Arrays.asList("Argentina", "Brasil", "Chile", "Colombia")));
        paisesLimitrofes.put("Polonia", new ArrayList<String>(Arrays.asList("Alemania", "Egipto", "Turquia", "Rusia")));
        paisesLimitrofes.put("Rusia", new ArrayList<String>(Arrays.asList("Aral", "Iran", "Polonia", "Suecia", "Turquia")));
        paisesLimitrofes.put("Sahara", new ArrayList<String>(Arrays.asList("Brasil", "Egipto", "Espana", "Etiopia", "Zaire")));
        paisesLimitrofes.put("Siberia", new ArrayList<String>(Arrays.asList("Aral", "China", "Kamchatka", "Mongolia", "Taimir", "Tartaria")));
        paisesLimitrofes.put("Sudafrica", new ArrayList<String>(Arrays.asList("Etiopia", "Zaire")));
        paisesLimitrofes.put("Suecia", new ArrayList<String>(Arrays.asList("Islandia", "Rusia")));
        paisesLimitrofes.put("Sumatra", new ArrayList<String>(Arrays.asList("Australia", "India")));
        paisesLimitrofes.put("Taimir", new ArrayList<String>(Arrays.asList("Siberia", "Tartaria")));
        paisesLimitrofes.put("Tartaria", new ArrayList<String>(Arrays.asList("Aral", "Siberia", "Taimir")));
        paisesLimitrofes.put("Terranova", new ArrayList<String>(Arrays.asList("Canada", "Labrador", "Nueva York")));
        paisesLimitrofes.put("Turquia", new ArrayList<String>(Arrays.asList("Arabia", "Egipto", "Iran", "Israel", "Polonia", "Rusia")));
        paisesLimitrofes.put("Uruguay", new ArrayList<String>(Arrays.asList("Argentina", "Brasil")));
        paisesLimitrofes.put("Yukon", new ArrayList<String>(Arrays.asList("Alaska", "Canada", "Oregon")));
        paisesLimitrofes.put("Zaire", new ArrayList<String>(Arrays.asList("Etiopia", "Madagascar", "Sahara", "Sudafrica")));
        return paisesLimitrofes;
    }

    public Initialise(){
        this.paises = this.setPaises();
        this.paisesLimitrofes = this.setPaisesLimitrofes();
    }

    public Map<String, Object> toDTO(){
        Map<String, Object> dto = new HashMap<String, Object>();
        dto.put("paises", this.paises);
        dto.put("limitrofes", this.paisesLimitrofes);
        return dto;
    }

}

package algoteg;

import java.util.*;

public class Initialise {
    public Map<String, Object> paises;
    public Map<String, Object> paisesLimitrofes;
    private final List<String> paisesDeAfrica = new ArrayList<>(Arrays.asList("Egipto", "Etiopia", "Madagascar", "Sahara", "Sudafrica", "Zaire"));
    private final List<String> paisesDeAmericaDelSur = new ArrayList<>(Arrays.asList("Argentina", "Brasil", "Chile", "Colombia", "Peru", "Uruguay"));
    private final List<String> paisesDeAmericaDelNorte = new ArrayList<>(Arrays.asList("Alaska", "California", "Canada", "Groenlandia", "Labrador", "Nueva York", "Mexico", "Oregon", "Terranova", "Yukon"));
    private final List<String> paisesDeAsia = new ArrayList<>(Arrays.asList("Arabia", "Aral", "China", "Gobi", "India", "Iran", "Israel", "Japon", "Kamchatka", "Malasia", "Mongolia", "Siberia", "Taimir", "Tartaria", "Turquia"));
    private final List<String> paisesDeEuropa = new ArrayList<>(Arrays.asList("Alemania", "Espana", "Francia", "Gran Bretana", "Islandia", "Italia", "Polonia", "Rusia", "Suecia"));
    private final List<String> paisesDeOceania = new ArrayList<>(Arrays.asList("Australia", "Borneo", "Java", "Sumatra"));

    private List<Pais> setPaisesAfrica(List<String> paisesDeAfrica){
        List<Pais> paisesAfrica = new ArrayList<>();
        for(String s : paisesDeAfrica){
            Pais p = new Pais(s);
            paisesAfrica.add(p);
        }
        return paisesAfrica;
    }

    private List<Pais> setPaisesAmericaDelSur(List<String> paisesDeAmericaDelSur){
        List<Pais> paisesAmericaDelSur = new ArrayList<>();
        for(String s : paisesDeAmericaDelSur){
            Pais p = new Pais(s);
            paisesAmericaDelSur.add(p);
        }
        return paisesAmericaDelSur;
    }

    private List<Pais> setPaisesAmericaDelNorte(List<String> paisesDeAmericaDelNorte){
        List<Pais> paisesAmericaDelNorte = new ArrayList<>();
        for(String s : paisesDeAmericaDelNorte){
            Pais p = new Pais(s);
            paisesAmericaDelNorte.add(p);
        }
        return paisesAmericaDelNorte;
    }

    private List<Pais> setPaisesAsia(List<String> paisesDeAsia){
        List<Pais> paisesAsia = new ArrayList<>();
        for(String s : paisesDeAsia){
            Pais p = new Pais(s);
            paisesAsia.add(p);
        }
        return paisesAsia;
    }

    private List<Pais> setPaisesEuropa(List<String> paisesDeEuropa){
        List<Pais> paisesEuropa = new ArrayList<>();
        for(String s : paisesDeEuropa){
            Pais p = new Pais(s);
            paisesEuropa.add(p);
        }
        return paisesEuropa;
    }

    private List<Pais> setPaisesOceania(List<String> paisesDeOceania){
        List<Pais> paisesOceania = new ArrayList<>();
        for(String s : paisesDeOceania){
            Pais p = new Pais(s);
            paisesOceania.add(p);
        }
        return paisesOceania;
    }

    private Map<String, Object> setPaises(){
        Map<String, Object> paises = new HashMap<>();
        paises.put("Africa", this.setPaisesAfrica(paisesDeAfrica));
        paises.put("AmericaDelSur", this.setPaisesAmericaDelSur(paisesDeAmericaDelSur));
        paises.put("AmericaDelNorte", this.setPaisesAmericaDelNorte(paisesDeAmericaDelNorte));
        paises.put("Asia", this.setPaisesAsia(paisesDeAsia));
        paises.put("Europa", this.setPaisesEuropa(paisesDeEuropa));
        paises.put("Oceania", this.setPaisesOceania(paisesDeOceania));
        return paises;
    }

    private Map<String, Object> setPaisesLimitrofes(){
        Map<String, Object> paisesLimitrofes = new HashMap<>();
        paisesLimitrofes.put("Alaska", new ArrayList<>(Arrays.asList("Brasil", "Chile", "Peru", "Uruguay")));
        paisesLimitrofes.put("Alemania", new ArrayList<>(Arrays.asList("Brasil", "Chile", "Peru", "Uruguay")));
        paisesLimitrofes.put("Arabia", new ArrayList<>(Arrays.asList("Brasil", "Chile", "Peru", "Uruguay")));
        paisesLimitrofes.put("Aral", new ArrayList<>(Arrays.asList("Brasil", "Chile", "Peru", "Uruguay")));
        paisesLimitrofes.put("Argentina", new ArrayList<>(Arrays.asList("Brasil", "Chile", "Peru", "Uruguay")));
        paisesLimitrofes.put("Australia", new ArrayList<>(Arrays.asList("Borneo", "Chile", "Java", "Sumatra")));
        paisesLimitrofes.put("Borneo", new ArrayList<>(Arrays.asList("Australia", "Malasia")));
        paisesLimitrofes.put("Brasil", new ArrayList<>(Arrays.asList("Argentina", "Colombia", "Peru", "Sahara", "Uruguay")));
        paisesLimitrofes.put("California", new ArrayList<>(Arrays.asList("Mexico", "Nueva York", "Oregon")));
        paisesLimitrofes.put("Canada", new ArrayList<>(Arrays.asList("Nueva York", "Oregon", "Terranova", "Yukon")));
        paisesLimitrofes.put("Chile", new ArrayList<>(Arrays.asList("Argentina", "Australia", "Peru")));
        paisesLimitrofes.put("China", new ArrayList<>(Arrays.asList("Gobi", "India", "Iran", "Japon", "Kamchatka", "Malasia", "Mongolia", "Siberia")));
        paisesLimitrofes.put("Colombia", new ArrayList<>(Arrays.asList("Brasil", "Mexico", "Peru")));
        paisesLimitrofes.put("Egipto", new ArrayList<>(Arrays.asList("Etiopia", "Israel", "Madagascar", "Sahara", "Polonia", "Turquia")));
        paisesLimitrofes.put("Espana", new ArrayList<>(Arrays.asList("Francia", "Gran Bretana", "Sahara")));
        paisesLimitrofes.put("Etiopia", new ArrayList<>(Arrays.asList("Egipto", "Sahara", "Sudafrica", "Zaire")));
        paisesLimitrofes.put("Francia", new ArrayList<>(Arrays.asList("Alemania", "Espana", "Italia")));
        paisesLimitrofes.put("Gobi", new ArrayList<>(Arrays.asList("China", "Iran", "Mongolia")));
        paisesLimitrofes.put("Gran Bretana", new ArrayList<>(Arrays.asList("Alemania", "Espana", "Islandia")));
        paisesLimitrofes.put("Groenlandia", new ArrayList<>(Arrays.asList("Islandia", "Labrador", "Nueva York")));
        paisesLimitrofes.put("India", new ArrayList<>(Arrays.asList("China", "Iran", "Malasia", "Sumatra")));
        paisesLimitrofes.put("Iran", new ArrayList<>(Arrays.asList("Aral", "China", "Gobi", "India", "Mongolia", "Rusia", "Turquia")));
        paisesLimitrofes.put("Islandia", new ArrayList<>(Arrays.asList("Gran Bretana", "Groenlandia", "Suecia")));
        paisesLimitrofes.put("Israel", new ArrayList<>(Arrays.asList("Arabia", "Egipto", "Turquia")));
        paisesLimitrofes.put("Italia", new ArrayList<>(Arrays.asList("Alemania", "Francia")));
        paisesLimitrofes.put("Japon", new ArrayList<>(Arrays.asList("China", "Kamchatka")));
        paisesLimitrofes.put("Java", new ArrayList<>(Collections.singletonList("Australia")));
        paisesLimitrofes.put("Kamchatka", new ArrayList<>(Arrays.asList("Alaska", "China", "Japon", "Siberia")));
        paisesLimitrofes.put("Labrador", new ArrayList<>(Arrays.asList("Groenlandia", "Terranova")));
        paisesLimitrofes.put("Madagascar", new ArrayList<>(Arrays.asList("Egipto", "Zaire")));
        paisesLimitrofes.put("Malasia", new ArrayList<>(Arrays.asList("Borneo", "China", "India")));
        paisesLimitrofes.put("Mexico", new ArrayList<>(Arrays.asList("California", "Colombia")));
        paisesLimitrofes.put("Mongolia", new ArrayList<>(Arrays.asList("Aral", "China", "Gobi", "Iran", "Siberia")));
        paisesLimitrofes.put("Nueva York", new ArrayList<>(Arrays.asList("California", "Canada", "Groenlandia", "Oregon", "Terranova")));
        paisesLimitrofes.put("Oregon", new ArrayList<>(Arrays.asList("Alaska", "California", "Canada", "Nueva York", "Yukon")));
        paisesLimitrofes.put("Peru", new ArrayList<>(Arrays.asList("Argentina", "Brasil", "Chile", "Colombia")));
        paisesLimitrofes.put("Polonia", new ArrayList<>(Arrays.asList("Alemania", "Egipto", "Turquia", "Rusia")));
        paisesLimitrofes.put("Rusia", new ArrayList<>(Arrays.asList("Aral", "Iran", "Polonia", "Suecia", "Turquia")));
        paisesLimitrofes.put("Sahara", new ArrayList<>(Arrays.asList("Brasil", "Egipto", "Espana", "Etiopia", "Zaire")));
        paisesLimitrofes.put("Siberia", new ArrayList<>(Arrays.asList("Aral", "China", "Kamchatka", "Mongolia", "Taimir", "Tartaria")));
        paisesLimitrofes.put("Sudafrica", new ArrayList<>(Arrays.asList("Etiopia", "Zaire")));
        paisesLimitrofes.put("Suecia", new ArrayList<>(Arrays.asList("Islandia", "Rusia")));
        paisesLimitrofes.put("Sumatra", new ArrayList<>(Arrays.asList("Australia", "India")));
        paisesLimitrofes.put("Taimir", new ArrayList<>(Arrays.asList("Siberia", "Tartaria")));
        paisesLimitrofes.put("Tartaria", new ArrayList<>(Arrays.asList("Aral", "Siberia", "Taimir")));
        paisesLimitrofes.put("Terranova", new ArrayList<>(Arrays.asList("Canada", "Labrador", "Nueva York")));
        paisesLimitrofes.put("Turquia", new ArrayList<>(Arrays.asList("Arabia", "Egipto", "Iran", "Israel", "Polonia", "Rusia")));
        paisesLimitrofes.put("Uruguay", new ArrayList<>(Arrays.asList("Argentina", "Brasil")));
        paisesLimitrofes.put("Yukon", new ArrayList<>(Arrays.asList("Alaska", "Canada", "Oregon")));
        paisesLimitrofes.put("Zaire", new ArrayList<>(Arrays.asList("Etiopia", "Madagascar", "Sahara", "Sudafrica")));
        return paisesLimitrofes;
    }

    public Initialise(){
        this.paises = this.setPaises();
        this.paisesLimitrofes = this.setPaisesLimitrofes();
    }

    public Map<String, Object> toDTO(){
        Map<String, Object> dto = new HashMap<>();
        dto.put("Paises", this.paises);
        dto.put("PaisesLimitrofes", this.paisesLimitrofes);
        return dto;
    }

}
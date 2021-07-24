package algoteg.datosJuego;

import algoteg.modelo.Continente;
import algoteg.modelo.Jugador;
import algoteg.modelo.Pais;

import java.util.*;



public class InitializePaisesYContinentes {
    private final Map<String, Pais> mapaPaises = new HashMap<>();
    private final Map<String, List<Pais>> paisesPorContinentes;
    private final Map<String, List<String>> paisesLimitrofes;

    private final Jugador jugadorInvalido = new Jugador(-1, "INVALID");

    private final List<Pais> todosLosPaises = new ArrayList<>();
    private final List<Continente> todosLosContinentes = new ArrayList<>();

    private final List<String> paisesDeAfrica = new ArrayList<>(Arrays.asList("Egipto", "Etiopia", "Madagascar", "Sahara", "Sudafrica", "Zaire"));
    private final List<String> paisesDeAmericaDelSur = new ArrayList<>(Arrays.asList("Argentina", "Brasil", "Chile", "Colombia", "Peru", "Uruguay"));
    private final List<String> paisesDeAmericaDelNorte = new ArrayList<>(Arrays.asList("Alaska", "California", "Canada", "Groenlandia", "Labrador", "Nueva York", "Mexico", "Oregon", "Terranova", "Yukon"));
    private final List<String> paisesDeAsia = new ArrayList<>(Arrays.asList("Arabia", "Aral", "China", "Gobi", "India", "Iran", "Israel", "Japon", "Kamchatka", "Malasia", "Mongolia", "Siberia", "Taimir", "Tartaria", "Turquia"));
    private final List<String> paisesDeEuropa = new ArrayList<>(Arrays.asList("Alemania", "Espana", "Francia", "Gran Bretana", "Islandia", "Italia", "Polonia", "Rusia", "Suecia"));
    private final List<String> paisesDeOceania = new ArrayList<>(Arrays.asList("Australia", "Borneo", "Java", "Sumatra"));

    private void inicializarPaises(List<String> listaDePaises, Jugador ocupante, List<Pais> listaPaises){
        for(String s : listaDePaises){
            Pais p = new Pais(s, ocupante);
            listaPaises.add(p);
            this.todosLosPaises.add(p);
            this.mapaPaises.put(s, p);
        }
    }

    private List<Pais> setPaisesAfrica(List<String> paisesDeAfrica, Jugador ocupante){
        List<Pais> paisesAfrica = new ArrayList<>();
        this.inicializarPaises(paisesDeAfrica, ocupante, paisesAfrica);

        return paisesAfrica;
    }

    private List<Pais> setPaisesAmericaDelSur(List<String> paisesDeAmericaDelSur, Jugador ocupante){
        List<Pais> paisesAmericaDelSur = new ArrayList<>();
        this.inicializarPaises(paisesDeAmericaDelSur, ocupante, paisesAmericaDelSur);
        return paisesAmericaDelSur;
    }

    private List<Pais> setPaisesAmericaDelNorte(List<String> paisesDeAmericaDelNorte, Jugador ocupante){
        List<Pais> paisesAmericaDelNorte = new ArrayList<>();
        this.inicializarPaises(paisesDeAmericaDelNorte, ocupante, paisesAmericaDelNorte);
        return paisesAmericaDelNorte;
    }

    private List<Pais> setPaisesAsia(List<String> paisesDeAsia, Jugador ocupante){
        List<Pais> paisesAsia = new ArrayList<>();
        this.inicializarPaises(paisesDeAsia, ocupante, paisesAsia);
        return paisesAsia;
    }

    private List<Pais> setPaisesEuropa(List<String> paisesDeEuropa, Jugador ocupante){
        List<Pais> paisesEuropa = new ArrayList<>();
        this.inicializarPaises(paisesDeEuropa, ocupante, paisesEuropa);
        return paisesEuropa;
    }

    private List<Pais> setPaisesOceania(List<String> paisesDeOceania, Jugador ocupante){
        List<Pais> paisesOceania = new ArrayList<>();
        this.inicializarPaises(paisesDeOceania, ocupante, paisesOceania);
        return paisesOceania;
    }

    private Map<String, List<Pais>> setPaises(){
        Map<String, List<Pais>> paises = new HashMap<>();
        paises.put("Africa", this.setPaisesAfrica(paisesDeAfrica, this.jugadorInvalido));
        paises.put("America Del Sur", this.setPaisesAmericaDelSur(paisesDeAmericaDelSur, this.jugadorInvalido));
        paises.put("America Del Norte", this.setPaisesAmericaDelNorte(paisesDeAmericaDelNorte, this.jugadorInvalido));
        paises.put("Asia", this.setPaisesAsia(paisesDeAsia, this.jugadorInvalido));
        paises.put("Europa", this.setPaisesEuropa(paisesDeEuropa, this.jugadorInvalido));
        paises.put("Oceania", this.setPaisesOceania(paisesDeOceania, this.jugadorInvalido));
        return paises;
    }

    private Continente setContinente(Map<String, List<Pais>> mapaContinentes, String nombreContinente, int bonusTropas) {
        Continente continente = new Continente(nombreContinente, bonusTropas);
        continente.setPaises(mapaContinentes.get(nombreContinente));
        return continente;
    }

    private void setTodosLosContinentes(Map<String, List<Pais>> mapaContinentes){
        this.todosLosContinentes.add(this.setContinente(mapaContinentes, "Africa", 3));
        this.todosLosContinentes.add(this.setContinente(mapaContinentes, "America Del Sur", 3));
        this.todosLosContinentes.add(this.setContinente(mapaContinentes, "America Del Norte", 5));
        this.todosLosContinentes.add(this.setContinente(mapaContinentes, "Asia", 7));
        this.todosLosContinentes.add(this.setContinente(mapaContinentes, "Europa", 5));
        this.todosLosContinentes.add(this.setContinente(mapaContinentes, "Oceania", 2));
    }

    private Map<String, List<String>> setPaisesLimitrofes(){
        Map<String, List<String>> paisesLimitrofes = new HashMap<>();
        paisesLimitrofes.put("Alaska", new ArrayList<>(Arrays.asList("Kamchatka", "Oregon", "Yukon")));
        paisesLimitrofes.put("Alemania", new ArrayList<>(Arrays.asList("Francia", "Gran Bretana", "Italia", "Polonia")));
        paisesLimitrofes.put("Arabia", new ArrayList<>(Arrays.asList("Israel", "Turquia")));
        paisesLimitrofes.put("Aral", new ArrayList<>(Arrays.asList("Iran", "Mongolia", "Rusia", "Siberia", "Tartaria")));
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

    private void setLimitrofes(List<Pais> todosLosPaises, Map<String, List<String>> mapaLimitrofes, Map<String, Pais> mapPaises){

        for(Pais p: todosLosPaises) {
            List<Pais> paisesLimitrofes = new ArrayList<>();
            String nombrePais = p.getNombre();
            List<String> nombrePaisesLimitrofes = mapaLimitrofes.get(nombrePais);
            for (String nombrePaisLimitrofe: nombrePaisesLimitrofes) {
                Pais paisLimitrofe = mapPaises.get(nombrePaisLimitrofe);
                paisesLimitrofes.add(paisLimitrofe);
            }
            p.setPaisesLimitrofes(paisesLimitrofes);
        }

    }

    public InitializePaisesYContinentes(){
        this.paisesPorContinentes = this.setPaises();
        this.paisesLimitrofes = this.setPaisesLimitrofes();
        this.setTodosLosContinentes(paisesPorContinentes);
    }

    public List<Continente> getTodosLosContinentes(){
        return this.todosLosContinentes;
    }

    public List<Pais> getTodosLosPaises(){
        return this.todosLosPaises;
    }

    public Map<String, List<Pais>> getPaisesPorContinentes() {
        return paisesPorContinentes;
    }
}
package juego;

public class Jugador {
    private String color;
    private int id;

    public Jugador(int id, String color) {
        this.id = id;
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public int getId(){
        return id;
    }
}

package fciencias.riesgotec.javaee;

import java.awt.Color;

/**
 * Clase que implmenta un generador de código SVG para crear gráficas.
 */
public class GeneradorSVG {
    
    /* Ancho de la imagen. */
    private int ancho;
    /* Alto de la imagen. */
    private int alto;
    /* Cadena que guardará el código SVG */
    private String codigo;
    /* Color rojo. */
    public static final int ROJO = 0;
    /* Color verde. */
    public static final int VERDE = 1;
    /* Color azul. */
    public static final int AZUL = 2;
    
    /**
     * Constructor por omisión que crea una gráfica de 100x100.
     */
    public GeneradorSVG() {
        ancho = 50;
        alto = 50;
        /* Cabecera */
        codigo = "<?xml version='1.0' encoding='UTF-8' ?>"
                + "\n<svg width='100' height='100'>";
        /* Creamos el eje y */
        codigo += "\n<line x1='0' y1='0' x2='0' y2='100' stroke='black' stroke-width='3'/>";
        /* Creamos el eje x */
        codigo += "\n<line x1='0' y1='100' x2='100' y2='100' stroke='black' stroke-width='3'/>";
    }
    
    /**
     * Constructor que inicializa la gráfica dados dos parámetros.
     * @param ancho Ancho de la imagen.
     * @param alto Alto de la imagen.
     */
    public GeneradorSVG(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        /* Cabecera. */
        codigo = String.format("<?xml version='1.0' encoding='UTF-8' ?>"
                + "\n<svg width='%d' height='%d'>", ancho, alto);
        /* Creamos el eje x */
        codigo += String.format("\n<line x1='0' y1='%d' x2='%d' y2='%d' stroke='black' stroke-width='3'/>", alto, ancho, alto);
        /* Creamos el eje y */
        codigo += String.format("\n<line x1='0' y1='0' x2='0' y2='%d' stroke='black' stroke-width='3'/>", alto);
    }
    
    /**
     * Método que agrega una recta dados dos puntos en el plano. Los puntos se
     * representan como 4 enteros.
     * @param x1 Coordenada x del primer punto.
     * @param y1 Coordenada y del primer punto.
     * @param x2 Coordenada x del segundo punto.
     * @param y2 Coordenada y del segundo punto.
     * @param c Color de la recta.
     */
    public void agregaRecta(int x1, int y1, int x2, int y2, int c) {
        String color = "black";
        if (c == ROJO)
            color = "red";
        if (c == VERDE)
            color = "green";
        if (c == AZUL)
            color = "blue";
        /* Validamos datos. */
        if (x1 < 0 || x1 > ancho || x2 < 0 || x2 > ancho)
            return;
        /* Invertimos coordenadas y. */
        int ny1 = alto - y1;
        int ny2 = alto - y2;
        if (ny1 < 0 || ny2 > alto || ny1 < 0 || ny2 > alto)
            return;
        codigo += String.format("\n<line x1='%d' y1='%d' x2='%d' y2='%d' stroke='%s' stroke-width='2'/>", x1, ny1, x2, ny2, color);
    }
    
    /**
     * Método que devuelve la gráfica actual.
     * @param String cadena del código SVG.
     */
    public String getSVG() {
        return codigo + "\n</svg>";
    }
    
    /* Ejemplo de uso. */
    /*public static void main(String[] args) {
    GeneradorSVG gs = new GeneradorSVG(200, 200);
    gs.agregaRecta(0, 0, 100, 100, GeneradorSVG.VERDE);
    System.out.println(gs.getSVG());
    }*/
}
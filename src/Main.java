import exercicios.Exercicios;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, -23, 10, 5, 4, 3);

        Exercicios exercicios = new Exercicios(numeros);

        exercicios.somaNumerosDivisiveisPorTresECinco();
    }
}
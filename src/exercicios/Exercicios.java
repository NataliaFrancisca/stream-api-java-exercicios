package exercicios;

import java.util.HashSet;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Exercicios {
    List<Integer> numeros;

    public Exercicios(List<Integer> numeros){
        this.numeros = numeros;
    }

    public void numerosOrdemNumerica(){
        //  1. Mostre a lista na ordem numérica
        List<Integer> numerosOrdemNumerica = numeros.stream().sorted().toList();
        numerosOrdemNumerica.forEach(System.out::println);
    }

    public void numerosPares(){
        // 2. Imprima a soma dos números pares da lista:
        Predicate<Integer> numerosPares = numero -> numero % 2 == 0;
        BinaryOperator<Integer> somaNumeros = (num1, num2) -> num1 + num2;

        int somaDosNumerosComPredicate = numeros.stream().filter(numerosPares).reduce(0, somaNumeros);

        int somaDosNumeros = numeros.stream().filter(n -> n % 2 == 0).reduce(0, Integer::sum);
        System.out.println("A soma dos números pares é: " + somaDosNumeros);
    }

    public void todosOsNumerosSaoPositivos(){
        // 3. Verifique se todos os números da lista são positivos
        boolean todosOsNumerosSaoPositivos = numeros.stream().allMatch(n -> n > 0);
        System.out.println("Todos os números dessa lista são positivos? " + (todosOsNumerosSaoPositivos ? "Sim" : "Não"));
    }

    public void listaDeNumerosPares(){
        // 4. Remova todos os valores ímpares:
        List<Integer> listaDeNumerosPares = numeros.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("Lista de números pares: " + listaDeNumerosPares);
    }

    public void mediaNumerosMaioresQueCinco(){
        // 5.  Calcule a média dos números maiores que 5:
        List<Integer> numerosMaioresQueCinco = numeros.stream().filter(n -> n > 5).toList();
        int mediaNumerosMaioresQueCinco = numerosMaioresQueCinco.stream().reduce(0, Integer::sum) / numerosMaioresQueCinco.size();

        // exemplo que vi no github
        OptionalDouble media = numerosMaioresQueCinco.stream().filter(n -> n > 5).mapToDouble(Integer::doubleValue).average();

        System.out.println("A media dos números maiores que 5 é: " + mediaNumerosMaioresQueCinco);
        System.out.println("A media dos números maiores que 5 é: " + media.getAsDouble());
    }

    public void existeNumeroMaiorQueDez(){
        // 6. Verificar se a lista contém algum número maior que 10:
        boolean existeNumeroMaiorQueDez = numeros.stream().anyMatch(n -> n > 10);
        System.out.println("Existe algum número maior que 10? " + (existeNumeroMaiorQueDez ? "Sim" : "Não"));
    }

    public void segundoMaiorNumero(){
        // 7.  Encontrar o segundo número maior da lista:
        int maiorNumero = numeros.stream().max(Integer::compareTo).get();
        List<Integer> listaNumeros = numeros.stream().filter(n -> n < maiorNumero).toList();
        int segundoMaiorNumero = listaNumeros.stream().max(Integer::compareTo).get();

        System.out.println("O maior número da lista: " + maiorNumero);
        System.out.println("O segundo maior número da lista: " + segundoMaiorNumero);
    }

    public void somaDeTodosOsNumeros(){
        // 8. Somar os dígitos de todos os números da lista:
        int somaDeTodosOsNumeros = numeros.stream().reduce(Integer::sum).get();
        System.out.println("A soma dos números é: " + somaDeTodosOsNumeros);
    }

    public void todosOsNumerosSaoDistintos(){
        // 9. Verificar se todos os números da lista são distintos (não se repetem):
        Set<Integer> set = new HashSet<>();
        boolean todosOsNumerosSaoDistintos = numeros.stream().allMatch(set::add); // Set.add() retorna false se o número já estiver presente
        System.out.println("Todos os números são distintos? " +  (todosOsNumerosSaoDistintos ? "Sim" : "Não"));
    }

    public void agruparNumerosMultiplosDeTresECinco(){
        // 10. Agrupe os valores ímpares múltiplos de 3 ou de 5:
        Predicate<Integer> multiplosDeTresOuCinco = (num) -> (num % 3 == 0 || num % 5 == 0) && num % 2 != 0;
        List<Integer> listaMultiplosDeTresOuCinco = numeros.stream().filter(multiplosDeTresOuCinco).toList();
        System.out.println("Os números multiplos de 3 ou 5: " + listaMultiplosDeTresOuCinco);
    }
}

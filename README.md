# Avaliação a Distância em POO
-------------------------

## Objetivo

Implementar uma rede social minimalista, que permita a criação de postagens e curtidas.


## Código Base

```java
public class AD1_2021_1 {
  public static void main(String[] args) {
    Amigo fulano = new Amigo("Fulano");
    Amigo ciclano = new Amigo("Ciclano");
    Amigo beltrano = new Amigo("Beltrano");
    
    Rede paraiso = new Rede();
    paraiso.adicionarAmigo(fulano);
    paraiso.adicionarAmigo(ciclano);
    paraiso.adicionarAmigo(beltrano);
    
    Post bomdia = new Post("Bom dia!");
    Post boatarde = new Post("Boa tarde!");
    Post boanoite = new Post("Boa noite!");
    
    fulano.postar(bomdia);
    fulano.postar(boatarde);
    ciclano.postar(boanoite);
    
    beltrano.curtir(bomdia);
    beltrano.curtir(boatarde);
    beltrano.curtir(boanoite);
    fulano.curtir(boanoite);
    
    System.out.println("Timeline:");
    System.out.println(paraiso.timeline());
    System.out.println("Post mais curtido de um usuário:");
    Post maiscurtido = ciclano.retornaPostMaisCurtido();
    System.out.println(maiscurtido);
    System.out.println("Quem curtiu: " + maiscurtido.retornaNomesQueCurtiram());
  }
}
```

## Exigências

1. Crie todas as classes utilizadas no código acima, para que este rode sem alterações.
2. Utilizar conceitos de OO sempre que possível.
3.  Limite cada classe para tratar somente o que diz respeito a esta.

## Resultado obrigatório

```java
  
  Timeline:
  Fulano: 
  Bom dia!: 1 curtidas
  Boa tarde!: 1 curtidas
  Ciclano: 
  Bom noite!: 2 curtidas
  Beltrano: 
  Post mais curtido de um usuário:Boa noite!: 2 curtidas
  Quem curtiu: Beltrano Fulano 
  
```

## Observações

1. Na implementação do método retornaPostMaisCurtido(), para o caso de empate, ou seja, mais de um post com o mesmo número de curtidas, pode-se retornar qualquer dos posts.
2. Caso não haja postagens para algum usuário, o método retornaPostMaisCurtido() pode retornar o valor null. Entretanto, como essa situação não foi tratada na main(), uma vez que a implementação é minimalista, esta situação não precisa ser considerada.

## Considerações importantes

..* Utilizar Java versão 8
..* Programas com erro de interpretação não serão corrigidos.

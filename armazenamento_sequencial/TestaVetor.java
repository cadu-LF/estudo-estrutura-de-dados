package com.br.caelum.projeto.armazenamento_sequencial;

/**
 *
 * @author Cadu Lourenço
 */
public class TestaVetor {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("João");
        Aluno a2 = new Aluno("Cadu");
        Aluno a3 = new Aluno("Gerald");
        
        Vetor lista = new Vetor();
        
        System.out.println(lista.tamanho());
        lista.add(a1);
        System.out.println(lista.tamanho());
        lista.add(a2);
        System.out.println(lista.tamanho());
        System.out.println(lista);
        System.out.println(lista.contem(a1));
        System.out.println(lista.contem(a3));
        System.out.println(lista.pega(1));
        System.out.println(lista.pega(-1));
        lista.adiciona(1, a3);
        System.out.println(lista);
        lista.remove(1);
        System.out.println(lista);
        
        for(int i = 0; i<300; i++){
            Aluno x = new Aluno("João" + i);
            lista.add(x);
        }
    }
}

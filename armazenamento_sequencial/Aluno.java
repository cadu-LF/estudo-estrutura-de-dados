package com.br.caelum.projeto.armazenamento_sequencial;

/**
 *
 * @author Cadu Lourenço
 */
public class Aluno {
    
    private String nome;
    
    public Aluno(){
     
    }
    
    public Aluno(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    @Override
    public boolean equals(Object obj){ // método utilizado para comparar 2 objs
        Aluno outro = (Aluno) obj;
        return outro.getNome().equals(this.nome);
    }
    
    @Override
    public String toString(){
        return nome;
    }
    /**
     * armazenamento sequencial -> guarda um aluno atrás do outro
     * utiliza-se array
     */
}

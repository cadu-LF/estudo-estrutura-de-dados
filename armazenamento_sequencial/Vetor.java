package com.br.caelum.projeto.armazenamento_sequencial;

import java.util.Arrays;

/**
 *
 * @author Cadu Lourenço
 */
public class Vetor {
    
    private Aluno[] alunos = new Aluno[100]; // inicialização do array com 100 posições
    private int totalAlunos = 0; // variável que identifica o total de Alunos
    
    public void add(Aluno aluno){ // adiciona elemento no final do vetor
        /**
         * for(int i  = 0; i < alunos.length; i++){
         *   if(alunos[i] == null){
         *       alunos[i] = aluno;
         *       break;
         *   }
        } 
         * Esse método não é eficaz, pois quanto maior for o tamanho do array,
         * mais tempo durará sua execulção.
         */
        this.garanteEspaco();
        this.alunos[totalAlunos] = aluno;
        totalAlunos ++;
        /**
         * Essa solução é mais contante, pois independe da quantidade de 
         * elementos dentro do array.
         */
    }
    
    private void garanteEspaco(){ // impede que o array estoure
        if(totalAlunos == alunos.length){
            Aluno[] novoArray = new Aluno[alunos.length*2];
            for(int i = 0; i < alunos.length; i++){
                novoArray[i] = alunos[i];
            }
            this.alunos = novoArray;
        }
      
    }
    
    private boolean posicaoValida(int posicao){ // verefica se a posicao é válida para realocar todos os alunos qua aparecem após a posicao
        return posicao >= 0 && posicao <= totalAlunos;
    }
    
    public void adiciona(int posicao, Aluno aluno){ // adiciona um novo aluno em qualquer posicao
        this.garanteEspaco();
        
        if(!posicaoValida(posicao)){
            throw new IllegalArgumentException("posição inválida");
        }
        for(int i = totalAlunos-1; i >= posicao; i--){
            alunos[i+1] = alunos[i];
        }
        
        alunos[posicao] = aluno;
        totalAlunos++;
        
    }
    
    private boolean posicaoOcupada(int posicao){ // verifica se a posicao passada está sendo ocupada
        return posicao >= 0 && posicao < totalAlunos;
    }
    
    public Aluno pega(int posicao){ // retorna o aluno na posicao informada
        if(!posicaoOcupada(posicao)){
            throw new IllegalArgumentException("posição inválida");
        }
        return alunos[posicao];
    }
    
    public void remove(int posicao){ // retira o aluno na posicao informada
        for(int i = posicao; i < totalAlunos; i++){
            this.alunos[i] = this.alunos[i+1];
        }
        
        totalAlunos--;
    }
    
    public boolean contem(Aluno aluno){ // descobre se o aluno está na lista
        for(int i = 0; i < totalAlunos; i++){
            if (aluno.equals(alunos[i])){
                return true;
            }
        }
        return false;
    }
    
    public int tamanho(){ // retorna a quantidade de elementos na fila
        return totalAlunos;
    }
    
    public String toString(){ // transfora os elementos do vetor em Strings
        return Arrays.toString(alunos);
    
    }
    
}

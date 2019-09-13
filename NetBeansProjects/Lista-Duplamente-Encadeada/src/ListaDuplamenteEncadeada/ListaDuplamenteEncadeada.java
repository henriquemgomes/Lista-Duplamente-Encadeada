/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplamenteEncadeada;

/**
 *
 * @author henrique
 */
public class ListaDuplamenteEncadeada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ficha de pessoas:
        Pessoa pessoa1 = new Pessoa(1, "Carlos", 20, 88993322l);
        Pessoa pessoa2 = new Pessoa(2, "Jeska", 22, 99856288l);
        Pessoa pessoa3 = new Pessoa(3, "Gustavo", 22, 99875428l);
        Pessoa pessoa4 = new Pessoa(4, "Paulão", 23, 999568412l);
        Pessoa pessoa5 = new Pessoa(5, "Creusa", 23, 988245677l);
        
        // Criando a lista:
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada(pessoa1);
        
        // Inserindo na lista:
        lista.insereNaFrente(pessoa2);
        lista.insereNaFrente(pessoa3);
        lista.insereNoFim(pessoa4);
        lista.insereNaPosicao(9, pessoa5);
        lista.excluiUltimo();
        lista.imprimeLista();
        
        // Operações do cursor:
        lista.vaParaPrimeiro();
        System.out.println(lista.getCursor().getPessoa().getNome());
        lista.avanca(2);
        System.out.println(lista.getCursor().getPessoa().getNome());
        lista.retrocede(1);
        System.out.println(lista.getCursor().getPessoa().getNome());
        
        System.out.println(lista.busca(8));
        
    }
    
    private Caixa cabeca;
    private Caixa cursor;
    private Caixa ultima;
    
    
    public ListaDuplamenteEncadeada(Pessoa fichaPessoa){
        this.cabeca = new Caixa(null, fichaPessoa, null);
        this.cursor = this.cabeca;
        this.ultima = this.cabeca;
    }
    
    // Operações do Cursor
    
    //Henrique
    private void vaParaPrimeiro(){
        this.cursor = this.cabeca;
    }
    
    //Caroline
    private void vaParaUltimo(){
        this.cursor = this.ultima;
    }
    
    //Henrique
    private void avanca(int posicao){
        //caso a posicao seja maior q o numero de objetos restantes ele aponta para o ultimo.
        // Ei, eu tirei o <= e deixei só o < porque deslocava uma posição a mais. Carol aqui rs
        for(int i = 0; i < posicao; i++){
            if(this.cursor.getProximo() == null){
                break;
            } else{
                this.cursor = this.cursor.getProximo();
            }
        }
    }
    
    //Caroline
    private void retrocede(int posicao){
        for(int i = 0; i < posicao; i++){
            if(this.cursor.getAnterior() == null){
                break;
            }else{
                this.cursor = this.cursor.getAnterior();
            }
        }
        
    }
    
    //Caroline
    public boolean busca(int id){
        vaParaPrimeiro();
        while(this.cursor.getProximo() != null){
            if(this.cursor.getProximo().getPessoa().getId() == id){
                return true;
            }
            this.cursor = this.cursor.getProximo();
        }
        return false;
    }
    
    // Operações na lista
    
    //Henrique
    public void insereNaFrente(Pessoa fichaPessoa){
        Caixa nova = new Caixa(null, fichaPessoa, this.cabeca);
        this.cabeca.setAnterior(nova);
        this.cabeca = nova;
    }
    
    //Caroline
    public void insereNoFim(Pessoa fichaPessoa){
        Caixa novaCaixa = new Caixa(this.ultima, fichaPessoa, null);
        this.ultima.setProximo(novaCaixa);
        this.ultima = novaCaixa;
    }
    
    //Henrique
    public void insereAposAtual(){
        
    }
    
    //Caroline
    public void insereNaPosicao(int posicao, Pessoa fichaPessoa){
        vaParaPrimeiro();
        avanca(posicao);
        Caixa ultimo = this.cursor.getProximo();
        // Validar como pode ser feito, se chegar ao final volta ou o quê
        if(ultimo == null){
            insereNoFim(fichaPessoa);
        }else{
            Caixa primeiro = this.cursor;
            Caixa novaCaixa = new Caixa(primeiro, fichaPessoa, ultimo);
            primeiro.setProximo(novaCaixa);
            ultimo.setAnterior(novaCaixa);            
        }

    }
    
    //Henrique
    public void excluiPrimeiro(){
        
    }
    
    //Caroline
    public void excluiUltimo(){
        //Para onde vai o cursor do ultimo
        vaParaUltimo();
        this.cursor.getAnterior().setProximo(null);
    }
    
    //Henrique
    public void excluiAtual(){
        
    }
    
    //Caroline
    public Caixa acessaAtual(){
        return this.cursor;
    }
    
    //apenas para testes
    public void imprimeLista(){
        vaParaPrimeiro();
        while(this.cursor.getProximo() != null){
            System.out.print(this.cursor.getPessoa().getNome()+", ");
            this.cursor = this.cursor.getProximo();
        }
        System.out.println(this.cursor.getPessoa().getNome());

    }
    
    // Acho que não precisa porque já tem o acessaAtual()
    //apenas para testes
    public Caixa getCursor(){
        return this.cursor;
    }
    
    
    
}

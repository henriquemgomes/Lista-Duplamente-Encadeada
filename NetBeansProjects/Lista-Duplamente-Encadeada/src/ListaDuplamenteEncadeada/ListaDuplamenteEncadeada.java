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
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada(new Pessoa(1, "Carlos", 20, 88993322l));
        lista.insereNaFrente(new Pessoa(2, "Jeska", 22, 99856288l));
        lista.insereNaFrente(new Pessoa(2, "Gustavo", 22, 99875428l));
        lista.imprimeLista();
        lista.vaParaPrimeiro();
        System.out.println(lista.getCursor().getPessoa().getNome());
        lista.avanca(3);
        System.out.println(lista.getCursor().getPessoa().getNome());
        
    }
    
    /*
        private Caixa primeiraCaixa;
        private Pessoa fichaPessoa;
        private Caixa segundaCaixa;
    */
    // acho q n precisa dessas ai, acho q da pra controlar melhor assim ó:
    
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
        for(int i = 0; i <= posicao; i++){
            //acho que nunca vai ser null, pois this.cursor = this.cabeca;
            if(this.cursor.getProximo() == null){
                break;
            } else{
                this.cursor = this.cursor.getProximo();
            }
        }
    }
    
    //Caroline
    private void retrocede(int posicao){
        for(int i = posicao; i <= posicao; i--){
            this.cursor = this.cursor.getAnterior();
        }
    }
    
    //Caroline
    public boolean busca(String nome){
        while(this.cursor != null){
            if(this.cursor.getProximo().getPessoa().getNome().equals(nome)){
                return true;
            }
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
    public void insereNoFim(){
        
    }
    
    //Henrique
    public void insereAposAtual(){
        
    }
    
    //Caroline
    public void insereNaPosicao(int posicao){
        
    }
    
    //Henrique
    public void excluiPrimeiro(){
        
    }
    
    //Caroline
    public void excluiUltimo(){
        
    }
    
    //Henrique
    public void excluiAtual(){
        
    }
    
    //Caroline
    public void acessaAtual(){
        
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
    
    //apenas para testes
    public Caixa getCursor(){
        return this.cursor;
    }
    
    
    
}

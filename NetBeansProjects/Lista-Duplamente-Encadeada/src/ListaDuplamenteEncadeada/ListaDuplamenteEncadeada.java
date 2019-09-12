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
    
    /*private Caixa primeiraCaixa;
    private Pessoa fichaPessoa;
    private Caixa segundaCaixa;*/
    //acho q n precisa dessas ai, acho q da pra controlar melhor assim ó:
    
    private Caixa cabeca;
    private Caixa cursor;
    private Caixa ultima;
    
    
    public ListaDuplamenteEncadeada(Pessoa fichaPessoa){
        cabeca = new Caixa(null, fichaPessoa, null);
        cursor = cabeca;
        ultima = cabeca;
    }
    
    // Operações do Cursor
    
    //Henrique
    private void vaParaPrimeiro(){
        cursor = cabeca;
    }
    
    //Caroline
    private void vaParaUltimo(){
        cursor = ultima;
    }
    
    //Henrique
    private void avanca(int posicao){
        //caso a posicao seja maior q o numero de objetos restantes ele aponta para o ultimo.
        for(int i = 0; i <= posicao; i++){
            if(cursor.getProximo() == null){
                break;
            } else{
                cursor = cursor.getProximo();
            }
        }
    }
    
    //Caroline
    private void retrocede(int posicao){
        
    }
    
    //Caroline
    public boolean busca(int referencia){
        return false;
    }
    
    // Operações na lista
    
    //Henrique
    public void insereNaFrente(Pessoa fichaPessoa){
        Caixa nova = new Caixa(null, fichaPessoa, cabeca);
        cabeca.setAnterior(nova);
        cabeca = nova;
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
        while(cursor.getProximo() != null){
            System.out.print(cursor.getPessoa().getNome()+", ");
            cursor = cursor.getProximo();
        }
        System.out.println(cursor.getPessoa().getNome());

    }
    
    //apenas para testes
    public Caixa getCursor(){
        return this.cursor;
    }
    
    
    
}

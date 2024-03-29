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
        Pessoa pessoa6 = new Pessoa(6, "Amaro", 33, 981054711l);
        Pessoa pessoa7 = new Pessoa(7, "Michel", 33, 973124432l);

        // Criando a lista:
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada(pessoa1);

        // Inserindo na lista:
        lista.inserirNaFrente(pessoa2);
        lista.inserirNaFrente(pessoa3);
        lista.inserirNoFim(pessoa4);
        lista.inserirNaPosicao(3, pessoa5);
        lista.inserirAntesDoAtual(pessoa6);
        lista.avancarKPosicoes(2);
        lista.inserirAposAtual(pessoa7);
        lista.avancarKPosicoes(2); 
        lista.excluirAtual();
        lista.excluirUltimo();
        lista.excluirPrimeiro();
        lista.imprimirLista();

        // Operações do cursor:
        lista.irParaPrimeiro();
        lista.avancarKPosicoes(5);
        lista.retrocederKPosicoes(4);
        lista.buscar(6);

    }

    private Caixa cabeca;
    private Caixa cursor;
    private Caixa ultima;

    public ListaDuplamenteEncadeada(Pessoa fichaPessoa) {
        this.cabeca = new Caixa(null, fichaPessoa, null);
        this.cursor = this.cabeca;
        this.ultima = this.cabeca;
    }

    //Operações da lista (públicas)
    
    public void inserirAntesDoAtual(Pessoa fichaPessoa) {
        Caixa atual = acessarAtual();
        Caixa anteriorAtual = atual.getAnterior();
        if (anteriorAtual == null) {
            inserirNaFrente(fichaPessoa);
        } else {
            Caixa novaCaixa = new Caixa(anteriorAtual, fichaPessoa, atual);
            atual.setAnterior(novaCaixa);
            anteriorAtual.setProximo(novaCaixa);
            this.cursor = novaCaixa;
        }
    }

    public void inserirAposAtual(Pessoa fichaPessoa) {
        Caixa atual = acessarAtual();
        Caixa proximoAtual = atual.getProximo();
        if (proximoAtual == null) {
            inserirNoFim(fichaPessoa);
        }else {
            Caixa novaCaixa = new Caixa(atual, fichaPessoa, proximoAtual);
            atual.setProximo(novaCaixa);
            proximoAtual.setAnterior(novaCaixa);
            this.cursor = novaCaixa;
        }        
    }

    public void inserirNoFim(Pessoa fichaPessoa) {
        Caixa novaCaixa = new Caixa(this.ultima, fichaPessoa, null);
        this.ultima.setProximo(novaCaixa);
        this.ultima = novaCaixa;
        this.cursor = this.ultima;
    }

    public void inserirNaFrente(Pessoa fichaPessoa) {
        Caixa nova = new Caixa(null, fichaPessoa, this.cabeca);
        this.cabeca.setAnterior(nova);
        this.cabeca = nova;
    }

    public void inserirNaPosicao(int posicao, Pessoa fichaPessoa) {
        irParaPrimeiro();
        avancarKPosicoes(posicao);
        if (this.cursor.getProximo() == null) {
            inserirNoFim(fichaPessoa);
        } else if (posicao == 1) {
            inserirNaFrente(fichaPessoa);
        } else {
            Caixa novaCaixa = new Caixa(this.cursor, fichaPessoa, this.cursor.getProximo());
            Caixa atual = this.cursor;
            Caixa anterior = this.cursor.getAnterior();
            anterior.setProximo(novaCaixa);
            atual.setAnterior(novaCaixa);
            novaCaixa.setProximo(atual);
            novaCaixa.setAnterior(anterior);
            this.cursor = novaCaixa;
        }
    }

    public void excluirAtual() {
        Caixa atual = acessarAtual();
        if(atual.getAnterior() != null){
            Caixa anteriorAtual = atual.getAnterior();
            Caixa proximoAtual = atual.getProximo();

            anteriorAtual.setProximo(proximoAtual);
            proximoAtual.setAnterior(anteriorAtual);
            this.cursor = anteriorAtual;
            atual.setAnterior(null);
            atual.setProximo(null);
        } else{
            excluirPrimeiro();
        }
        
    }

    public void excluirPrimeiro() {
       Caixa primeiro = this.cabeca;
       Caixa novoPrimeiro = this.cabeca.getProximo();
       primeiro.setProximo(null);
       novoPrimeiro.setAnterior(null);
       this.cabeca = novoPrimeiro;
       this.cursor = this.cabeca;
    }

    public void excluirUltimo() {
        irParaUltimo();
        this.cursor.getAnterior().setProximo(null);
        this.cursor = this.cursor.getAnterior();
    }

    public boolean buscar(int id) {
        irParaPrimeiro();
        while (this.cursor.getProximo() != null) {
            if (this.cursor.getProximo().getPessoa().getId() == id) {
                return true;
            }
            this.cursor = this.cursor.getProximo();
        }
        return false;
    }

    public Caixa acessarAtual() {
        return this.cursor;
    }

    private void avancarKPosicoes(int k) {
        //caso a posicao seja maior q o numero de objetos restantes ele aponta para o ultimo.
        for (int i = 1; i < k; i++) {
            if (this.cursor.getProximo() == null) {
                break;
            } else {
                this.cursor = this.cursor.getProximo();
            }
        }
    }

    private void retrocederKPosicoes(int k) {
        for (int i = 1; i < k; i++) {
            if (this.cursor.getAnterior() == null) {
                break;
            } else {
                this.cursor = this.cursor.getAnterior();
            }
        }
    }

    private void irParaPrimeiro() {
        this.cursor = this.cabeca;
    }

    private void irParaUltimo() {
        this.cursor = this.ultima;
    }

    public void imprimirLista() {
        Caixa cursorImpressao = cabeca;
        while (cursorImpressao.getProximo() != null) {
            System.out.print(cursorImpressao.getPessoa().getNome() + ", ");
            cursorImpressao = cursorImpressao.getProximo();
        }
        System.out.println(cursorImpressao.getPessoa().getNome());

    }

}

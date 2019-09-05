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
public class Caixa {
    public Caixa anterior;
    public Pessoa pessoa;
    public Caixa proximo;

    public Caixa(Caixa anterior, Pessoa pessoa) {
        this.anterior = anterior;
        this.pessoa = pessoa;
        this.proximo = null;
    }

    public Caixa(Pessoa pessoa, Caixa proximo) {
        this.anterior = null;
        this.pessoa = pessoa;
        this.proximo = proximo;
    }

    public Caixa(Caixa anterior, Pessoa pessoa, Caixa proximo) {
        this.anterior = anterior;
        this.pessoa = pessoa;
        this.proximo = proximo;
    }
    
    public Caixa( Pessoa pessoa) {
        this.anterior = null;
        this.pessoa = pessoa;
        this.proximo = null;
    }

    public Caixa getAnterior() {
        return anterior;
    }

    public void setAnterior(Caixa anterior) {
        this.anterior = anterior;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Caixa getProximo() {
        return proximo;
    }

    public void setProximo(Caixa proximo) {
        this.proximo = proximo;
    }
    
    

    
    
}

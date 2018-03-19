package model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ibrum
 */
@XmlRootElement
public class Produto implements Serializable {
    private int cod;
    private String nome;
    private double preco;

    public Produto(int cod, String nome, double preco) {
        this.cod = cod;
        this.nome = nome;
        this.preco = preco;
    }

    public Produto() {
    }
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}

package repository;

import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 * @author ibrum
 */
public class RepositoryProdutos {
    private static RepositoryProdutos instance;
    private List<Produto> listaProdutos;
    private int autoIncrement;
    
    private RepositoryProdutos() {
        listaProdutos = new ArrayList<>();
        listaProdutos.add(new Produto(1, "Arroz", 2.50));
        listaProdutos.add(new Produto(2, "Feijao", 5.25));
        listaProdutos.add(new Produto(3, "Arroz", 3.20));
        autoIncrement = 4;
    }
    
    public static synchronized RepositoryProdutos getInstance(){
        if (instance == null) {
            instance = new RepositoryProdutos();
        }
        return instance;
    }
    
    public void inserir(Produto p) {
        if (p.getCod() == 0) {
            p.setCod(autoIncrement++);
        }
        listaProdutos.add(p);
    }
    
    public List<Produto> listar() {
        return listaProdutos;
    }
    
    public Produto buscarPorCodigo(int cod){
        for (Produto p : listaProdutos) {
            if (p.getCod() == cod) {
                return new Produto(p.getCod(), p.getNome(), p.getPreco());
            }
        }
        return null;
    }
    
    public int getIndice(int cod) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getCod() == cod) {
                return i;
            }
        }
        return -1;
    }
    
    public void atualizar(Produto prod) {
        listaProdutos.set(this.getIndice(prod.getCod()), prod);
    }
    
    public void excluir(Produto prod) {
        listaProdutos.remove(this.getIndice(prod.getCod()));
    }
}

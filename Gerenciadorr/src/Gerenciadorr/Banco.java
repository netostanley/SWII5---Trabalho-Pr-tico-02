package Gerenciadorr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
    private static List<Produto> listaProdutos = new ArrayList<>();
    private static Integer chaveSequencial = 1;
    

    public void adicionaProduto(Produto produto) {
        produto.setId(chaveSequencial++);
        listaProdutos.add(produto);
    }

    public List<Produto> getProdutos() {
        return listaProdutos;
    }

    public void removeProduto(Integer id) {
        Iterator<Produto> it = listaProdutos.iterator();
        while (it.hasNext()) {
            Produto prod = it.next();
            if (prod.getId().equals(id)) {
                it.remove();
            }
        }
    }

    public Produto buscaProdutoPeloId(Integer id) {
        for (Produto produto : listaProdutos) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }
        return null;
    }
}
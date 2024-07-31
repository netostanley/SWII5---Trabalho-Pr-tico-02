package Gerenciadorr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/novoProduto")
public class NovoProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomeProduto = request.getParameter("nome");
        int unidadeCompra = Integer.parseInt(request.getParameter("unidadeCompra"));
        String descricao = request.getParameter("descricao");
        double qtdPrevistoMes = Double.parseDouble(request.getParameter("qtdPrevistoMes"));
        double precoMaxComprado = Double.parseDouble(request.getParameter("precoMaxComprado"));

        Produto produto = new Produto();
        produto.setNome(nomeProduto);
        produto.setUnidadeCompra(unidadeCompra);
        produto.setDescricao(descricao);
        produto.setQtdPrevistoMes(qtdPrevistoMes);
        produto.setPrecoMaxComprado(precoMaxComprado);

        Banco banco = new Banco();
        banco.adicionaProduto(produto);

        response.sendRedirect("listaProduto");
    }
}
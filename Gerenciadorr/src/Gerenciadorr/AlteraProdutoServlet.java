package Gerenciadorr;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/alteraProduto")
public class AlteraProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomeProduto = request.getParameter("nome");
        int unidadeCompra = Integer.parseInt(request.getParameter("unidadeCompra"));
        String descricao = request.getParameter("descricao");
        double qtdPrevistoMes = Double.parseDouble(request.getParameter("qtdPrevistoMes"));
        double precoMaxComprado = Double.parseDouble(request.getParameter("precoMaxComprado"));
        int id = Integer.parseInt(request.getParameter("id"));

        Banco banco = new Banco();
        Produto produto = banco.buscaProdutoPeloId(id);
        produto.setNome(nomeProduto);
        produto.setUnidadeCompra(unidadeCompra);
        produto.setDescricao(descricao);
        produto.setQtdPrevistoMes(qtdPrevistoMes);
        produto.setPrecoMaxComprado(precoMaxComprado);

        response.sendRedirect("listaProduto");
    }
}
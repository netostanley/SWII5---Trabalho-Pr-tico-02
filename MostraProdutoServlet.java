package Gerenciadorr;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mostraProduto")
public class MostraProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("action");

        Banco banco = new Banco();
        Produto produto = banco.buscaProdutoPeloId(id);

        if ("edit".equals(action)) {
            request.setAttribute("produto", produto);
            request.getRequestDispatcher("/formAlteraProduto.jsp").forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("Produto: " + produto.getNome() + "<br>");
            out.println("Unidade de Compra: " + produto.getUnidadeCompra()+ "<br>");
            out.println("Descri  o: " + produto.getDescricao()+ "<br>");
            out.println("Quantidade Prevista por M s: " + produto.getQtdPrevistoMes()+ "<br>");
            out.println("Pre o M ximo Comprado: " + produto.getPrecoMaxComprado()+ "<br><br><br>");
            out.println("Criado por: Ivaldo Fernandes - CB3020878");
            out.println("</body></html>");
        }
    }
}
package Gerenciadorr;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaProduto")
public class ListaProdutosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Banco banco = new Banco();
        List<Produto> lista = banco.getProdutos();  // Assuming getProdutos() returns all products
        
        request.setAttribute("listaProduto", lista);  // Set the product list as a request attribute
        request.getRequestDispatcher("/listaProduto.jsp").forward(request, response);  // Forward to JSP
    }
}
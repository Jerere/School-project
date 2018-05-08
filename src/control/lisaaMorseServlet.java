package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Morse;
import model.dao.morseDAO;

@WebServlet("/lisaaMorseServlet")
public class lisaaMorseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public lisaaMorseServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		try {
			
		String idStr = request.getParameter("id");
		int id = new Integer(idStr);
		String nimimerkki = request.getParameter("nimimerkki");
		String morsekoodi = request.getParameter("tulos");
		String teksti = request.getParameter("teksti");
		
		Morse morse = new Morse(id, nimimerkki, teksti, morsekoodi);
		morseDAO morsedao = new morseDAO();
		morsedao.addMorse(morse);
		
		} catch (SQLException e) {
			System.out.println("Sovelluksessa tapahtui virhe (lisaaServlet) " + e.getMessage());
		}
		response.sendRedirect("lista");
	}

}

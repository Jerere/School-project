package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.morseDAO;

@WebServlet("/poista-morse")
public class poistaMorseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public poistaMorseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			String idStr = request.getParameter("morse.id");
			System.out.println(idStr);
			int morseid = new Integer(idStr);
			//LUODAAN MORSEDAO
			morseDAO morsedao = new morseDAO();
			morsedao.removeMorse(morseid);
			
		} catch (SQLException e) {
			System.out.println("Sovelluksessa tapahtui virhe " + e.getMessage());
		}
		response.sendRedirect("lista");
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

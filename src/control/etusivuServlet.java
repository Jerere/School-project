package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/etusivu")
public class etusivuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static String muunnettava;

	public etusivuServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jsp = "/view/etusivu.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			String tekstiAlk = request.getParameter("teksti");
			
		 	String teksti = tekstiAlk.toLowerCase();
			muunnettava = teksti;

			String tulos = muuntaja();
			request.setAttribute("tulos", tulos);
			request.setAttribute("tekstiAlk", tekstiAlk); 
			
			String jsp = "/view/etusivu.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);
			
			
	}

	public static String muuntaja() {

		char[] Eng = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z', 'ä', 'ö', 'å', ' ' };

		String[] Code = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
				"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".-.-",
				"---.", ".--.-", "/" };

		String b = muunnettava; 						// OTETAAN VASTAAN MUUNNETTAVA TEKSTI
		String tulos = ""; 								// ALUSTETAAN LOPULLINEN TULOS (MORSE KOODI)
		for (int x = 0; x < b.length(); x++) { 			// KIRJAIN KERRAALLAAN ETSITÄÄN OIKEA MORSEN AAKKONEN
			for (int y = 0; y < Eng.length; y++) {
				if (Eng[y] == b.charAt(x)) { 			// KUN TEKSTIN KIRJAIMEN PAIKKANUMERO == MORSEN PAIKKANUMERO -->
					tulos = tulos + (Code[y] + " ");	// LISÄTÄÄN TULOS STRINGIIN KIRJAIN
				} 

			}

		}
		return tulos;
	}
}
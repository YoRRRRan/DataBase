package routing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

import db.Bdd;

/**
 * Servlet implementation class ConnectionServlet
 * gère l'accès à la page de connexion utilisateur
 * et son formulaire
 */
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * récupère et affiche la page de formulaire
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// la ligne commentée affichait du texte pur en résultat
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//on va récupérer la page JSP connectView et envoyer son résultat au client
		//d'abord on obtient le contexte de servlet de l'application
		//puis on crée un objet qui renvoie la demande vers l'URL absolue de ma page JSP que le client ne voit pas directement
		//et enfin on envoie la HTTP request avec la méthode forward
		this.getServletContext().getRequestDispatcher("/WEB-INF/connectView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * poste les informations du formulaire
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//j'affiche dans la réponse les informations d'une Map contenant les noms et valeurs des paramètres de requête
		//response.getWriter().append(request.getParameterMap().toString());
		
		//on teste si les identifiants postés correspondent bien à un utilisateur enregistré
		if(this.isValidUser(request.getParameter("username"), request.getParameter("password"))) {
			//je redirige la requête vers une page JSP d'accueil
			this.getServletContext().getRequestDispatcher("/WEB-INF/welcomeView.jsp").forward(request, response);
		}else {
			//si utilisateur invalide on redirige vers la page de connexion
			request.setAttribute("error_connect", "Connexion échouée");
			this.doGet(request, response);
		}
		
		
	}
	
	/**
	 * méthode qui vérifie si deux string passées en paramètres correspondent à un utilisateur présent en BDD
	 * @param username le nom d'utilisateur
	 * @param password le mot de passe de l'utilisateur
	 * @return true si l'utilisateur est trouvé, false sinon
	 */
	protected boolean isValidUser(String username, String password) {
		Connection dbc = Bdd.getConnection();
		try {
			PreparedStatement ps = dbc.prepareStatement("SELECT * FROM t_users WHERE login=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			//comme on a un username unique on peut lire de suite s'il existe
			if(rs.next()) {
				//si on a trouvé l'utilisateur on le signale
				return true;
			}else {
				//s'il n'y a rien à lire c'est qu'on n'a pas trouvé l'utilisateur
				return false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//en cas de pb je bloque la connexion
			return false;
		}
		
	}

}

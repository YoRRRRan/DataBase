package db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bdd {

    private static Connection linkBdd;

    /**
     * méthode récupérant les informations de connexion à la base depuis un fichier externe
     * si le fichier n'est pas trouvé, cette appli web donnera des infos de configuration en dur
     * @param path le nom du fichier
     * @return String[] le tableau des infos : data source name, user, password
     */
    public static String[] loadConfig(String path) {
        String[] config = new String[3];
        // si le fichier n'est pas trouvé, erreur
        
        try {
            // on crée un lecteur de fichier
            FileReader fr = new FileReader(path);
            // on crée un lecteur avancé pour plus de facilité
            BufferedReader br = new BufferedReader(fr);
            // on lit les trois lignes du fichier dans le tableau config
            for (int i = 0; i < 3; i++) {
                config[i] = br.readLine();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
        	config[0] = "jdbc:mysql://localhost:3306/webstore";
        	config[1] = "ywagner";
            config[2] = "java";
        }

        return config;
    }

    /**
     * méthode récupérant la connexion BDD et la créant si elle est nulle
     * @return Connection l'objet Connexion à la BDD
     */
    public static Connection getConnection() {
        if (linkBdd == null) {
            try {
                String[] config = loadConfig("config.txt");
                Class.forName("com.mysql.cj.jdbc.Driver");
                linkBdd = DriverManager.getConnection(config[0], config[1], config[2]);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return linkBdd;
    }

    public static ResultSet requete(String requeteSQL) throws SQLException {
        Connection dbc = Bdd.getConnection();
        Statement requete;
        try {
            requete = dbc.createStatement();
            // on exécute la requête et on récupère le jeu de résultats
            return requete.executeQuery(requeteSQL);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}

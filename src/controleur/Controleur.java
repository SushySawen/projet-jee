package controleur;

import classes.Etudiant;
import classes.GestionFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//!!! dans le projet du prof, après avoir intégré les jpa -> il initialise les valeurs dans le dao.
//il faut normalement les déclarer dans la BDD, mais pas de pénalité si on fait comme lui
@SuppressWarnings("serial")
public class Controleur extends HttpServlet {

    private String urlDetails;
    private String urlEtudiants;
    private String urlAbsences;
    private String urlNotes;


    //INIT
    public void init() throws ServletException {
        urlDetails = getInitParameter("urlDetails");
        urlEtudiants = getInitParameter("urlEtudiants");
        urlAbsences = getInitParameter("urlAbsences");
        urlNotes = getInitParameter("urlNotes");
    }

    // POST
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // on passe la main au GET
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        // On récupère la méthode d'envoi de la requête
        String methode = request.getMethod().toLowerCase();

        // On récupère l'action à exécuter
        String action = request.getPathInfo();
        if (action == null) {
            action = "/index";
            System.out.println("action == null");
        }
        System.out.println("JeuMVC : action = " + action);


        if (action.equals("/index")) {
            doIndex(request, response);

        } else if (methode.equals("get") && action.equals("/details")) {
            doDetails(request, response);
        } else if (methode.equals("get") && action.equals("/absences")) {
            doAbsences(request, response);
        } else if (methode.equals("get") && action.equals("/notes")){
            doNotes(request, response);
        }




    }

    private void doIndex(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {

        // etudiants
        ArrayList<Etudiant> listEtudiants= new ArrayList<>(GestionFactory.getEtudiants());

        // attribut

        request.setAttribute("listeEtudiants", listEtudiants);

        loadJSP(urlEtudiants, request, response);
    }


    //
    private void doDetails(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        //on récupère l'id de l'étudiant
        int id = Integer.valueOf(request.getParameter("id"));

        Etudiant etudiant = GestionFactory.getEtudiantById(id);
        int absences = GestionFactory.getAbsencesByEtudiantId(id);


        // Mettre l'objet jeu en attribut de requête
        request.setAttribute("etudiant", etudiant);
        request.setAttribute("absence", absences);

        loadJSP(urlDetails, request, response);
    }

    private void doAbsences(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
    //<%--faire une hashmap et renvoyer le tout a la jsp contenant id etudiant et nb d'absences--%>
    //faire une liste d'etudiant puis une hashmap avec l'id étudiant en clé et le nombre d'absences en valeur
        //on récupère l'id de l'étudiant

        Collection<Etudiant> etudiants = GestionFactory.getEtudiants();
        HashMap<Integer, Integer> absenceParEtu = new HashMap<>();

        for (Etudiant etudiant : etudiants){
            absenceParEtu.put(etudiant.getId(), GestionFactory.getAbsencesByEtudiantId(etudiant.getId()));
        }

        // Mettre l'objet jeu en attribut de requête
        request.setAttribute("absenceParEtu", absenceParEtu);
        request.setAttribute("etudiants", etudiants);

        loadJSP(urlAbsences, request, response);
    }

    private void doNotes(HttpServletRequest request,
                            HttpServletResponse response) throws ServletException, IOException {
        //<%--faire une hashmap et renvoyer le tout a la jsp contenant id etudiant et nb d'absences--%>
        //faire une liste d'etudiant puis une hashmap avec l'id étudiant en clé et le nombre d'absences en valeur
        //on récupère l'id de l'étudiant

        Collection<Etudiant> etudiants = GestionFactory.getEtudiants();
        HashMap<Integer, Integer> noteParEtu = new HashMap<>();

        for (Etudiant etudiant : etudiants){
            noteParEtu.put(etudiant.getId(), GestionFactory.getNotesByEtudiantId(etudiant.getId()));
        }

        // Mettre l'objet jeu en attribut de requête
        request.setAttribute("noteParEtu", noteParEtu);
        request.setAttribute("etudiants", etudiants);

        loadJSP(urlNotes, request, response);
    }

    /**
     * Charge la JSP indiquée en paramètre
     *
     * @param url
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void loadJSP(String url, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // L'interface RequestDispatcher permet de transférer le contrôle à une
        // autre servlet
        // Deux méthodes possibles :
        // - forward() : donne le contrôle à une autre servlet. Annule le flux
        // de sortie de la servlet courante
        // - include() : inclus dynamiquement une autre servlet
        // + le contrôle est donné à une autre servlet puis revient à la servlet
        // courante (sorte d'appel de fonction).
        // + Le flux de sortie n'est pas supprimé et les deux se cumulent

        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(url);
        rd.forward(request, response);
    }

}

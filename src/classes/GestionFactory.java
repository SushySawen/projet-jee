package classes;

import java.util.*;

public class GestionFactory {

	/////// SIMULATION DE LA PERSISTANCE DES ETUDIANTS ET DES ABSENCES
	
	// CHARGER en premier à l'execution du projet (car constante : static final)
	private static final HashMap<Integer, Etudiant> LISTE_ID_ETUDIANTS = intializeListEtudiants();
	private static final HashMap<Integer, Integer> LISTE_ID_ABSENCES = intializelistEtudiantAbsence();
	private static final HashMap<Integer, Integer> LISTE_ID_NOTES = intializelistEtudiantNotes();

	// Initialisation des étudiants
	private static HashMap<Integer, Etudiant> intializeListEtudiants() {

		// Création des étudiants
		Etudiant etu1 = new Etudiant(0, "Francis", "Brunet-Manquat");
		Etudiant etu2 = new Etudiant(1, "Philippe", "Martin");
		Etudiant etu3 = new Etudiant(2, "Sophie", "Bougherra");
		Etudiant etu4 = new Etudiant(3, "Titouan", "Gisle");
		Etudiant etu5 = new Etudiant(4, "Johan", "Aarons");

		// Création du hasmap (association clé/valeur)
		// Association id -> etudiant
		HashMap<Integer, Etudiant> listEtudiantsTemp = new HashMap<>();
		listEtudiantsTemp.put(etu1.getId(), etu1);
		listEtudiantsTemp.put(etu2.getId(), etu2);
		listEtudiantsTemp.put(etu3.getId(), etu3);
		listEtudiantsTemp.put(etu4.getId(), etu4);
		listEtudiantsTemp.put(etu5.getId(), etu5);

		//
		return listEtudiantsTemp;
	}

	// Initialisation des absences
	private static final HashMap<Integer, Integer> intializelistEtudiantAbsence() {

		// Création du hasmap (association clé/valeur)
		// Association etudiant id -> absences
		HashMap<Integer, Integer> listEtudiantAbsenceTemp = new HashMap<>();
		
		// Le nombre d'absences est généré aléatoirement
		Random rand = new Random();
		for (Etudiant etudiant : LISTE_ID_ETUDIANTS.values()) {
			listEtudiantAbsenceTemp.put(etudiant.getId(), rand.nextInt(10));
		}

		//
		return listEtudiantAbsenceTemp;
	}
	//Initialisation de la liste des notes
	private static final HashMap<Integer, Integer> intializelistEtudiantNotes() {

		// Création du hasmap (association clé/valeur)
		// Association etudiant id -> notes
		HashMap<Integer, Integer> listEtudiantNotesTemp = new HashMap<>();

		// Les notes sont générées aléatoirement
		Random rand = new Random();
		for (Etudiant etudiant : LISTE_ID_ETUDIANTS.values()) {
			listEtudiantNotesTemp.put(etudiant.getId(), rand.nextInt(20));
		}

		//On retourne la liste d'étudiant
		return listEtudiantNotesTemp;
	}

	
	/////// METHODES A UTILISER
	// Retourne l'ensemble des etudiants
	public static Collection<Etudiant> getEtudiants() {
		return LISTE_ID_ETUDIANTS.values();
	}

	// Retourne un étudiant en fonction de son id 
	public static Etudiant getEtudiantById(int id) {
		return LISTE_ID_ETUDIANTS.get(id);
	}

	// Retourne le nombre d'absences d'un etudiant en fonction de son id 
	public static Integer getAbsencesByEtudiantId(int id) {
		return LISTE_ID_ABSENCES.get(id);
	}
	//Retourne les notes d'un étudiant en fonction de son id
	public static Integer getNotesByEtudiantId(int id){
		return LISTE_ID_NOTES.get(id);
	}
}
package classes;

public class TestAbsences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Afficher les étudiants et leurs absences
		for (Etudiant etu : GestionFactory.getEtudiants()) {
			System.out.print("Classes.Etudiant : " + etu.getPrenom() + " " + etu.getNom());
			System.out.println(" -> nombre d'absences : " + GestionFactory.getAbsencesByEtudiantId(etu.getId()));
		}

	}

}

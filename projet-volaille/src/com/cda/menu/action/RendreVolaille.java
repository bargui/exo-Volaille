package com.cda.menu.action;
import static com.cda.model.Ferme.LA_FERME;
import static com.cda.tools.Ihm.IHM_INS;

import java.util.Set;

import com.cda.model.Volaille;
import com.cda.model.abat.VolailleAbattable;
import com.cda.model.nabat.VolailleAGarder;

final class RendreVolaille extends Action {
	private static final int ID = 7;
	private static final String DESC = "rendre une volaille";
	
	 RendreVolaille() {
		super(ID, DESC);
	}

	@Override
	public boolean executer() {
		IHM_INS.afficher("choisissez un type de volaille :");
		IHM_INS.afficher("\t0)- Paon");
		IHM_INS.afficher("\t1)- Cygne");
		
		int vTypeVolaille = IHM_INS.lireEntier();
		
		IHM_INS.afficher("saisissez l'id de la volaille à rendre parmis :");
		Set<Volaille> vVolailles = LA_FERME.getVolailles(true,vTypeVolaille);
		for (Volaille vVolaille : vVolailles) {
			IHM_INS.afficher(vVolaille.toString());
		}
		
		String vIdVolailleARendre = IHM_INS.lireMot();
		VolailleAGarder vVolailleVendue = LA_FERME.rendreVolaille(vTypeVolaille,vIdVolailleARendre);
		if(vVolailleVendue == null) {
			IHM_INS.afficher("> erreur lors de la vente");
		} else {
			IHM_INS.afficher("> voici la volaille rendue "+vVolailleVendue);
		}
		
		return Boolean.TRUE;
	}

}

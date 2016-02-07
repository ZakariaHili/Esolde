package com.HILI.ESolde.metier;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.HILI.ESolde.entities.Administrateur;
import com.HILI.ESolde.entities.Equipe_ESolde;

@Component
@Transactional
public class AdministrateurMetierImpl extends Equipe_ESoldeMetierImpl implements AdministrateurMetier{

	@Override
	public int AjoutEquipe_ESolde(Equipe_ESolde equipe) {
		return dao.AjoutEquipe_ESolde(equipe);
	}

	@Override
	public void SupprimerEquipe_ESolde(int idEquipe) {
		dao.SupprimerEquipe_ESolde(idEquipe);
		
	}

	@Override
	public void ModifierAdministrateur(Administrateur A) {
		dao.ModifierAdministrateur(A);
		
	}

}

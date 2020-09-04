package dev.mission.exec;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import dev.mission.entite.Mission;

import dev.mission.repository.MissionRepository;
import java.time.LocalDate;
import java.util.List;

@Controller
@Profile("listerProchainesMissions")
public class ListerProchainesMissions implements Runnable {
	private MissionRepository missionRepository;

	public ListerProchainesMissions(MissionRepository missionRepository) {
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {
		LocalDate maDate = LocalDate.now();
		List<Mission> listeMissions = this.missionRepository.findByDateDebutAfter(maDate);
		System.out.println(listeMissions.size());
		for (Mission mission : listeMissions) {
			System.out.println(("id=" + mission.getId() + " libelle=" + mission.getLibelle() + " début=" + mission.getDateDebut() + " fin=" + mission.getDateFin() + " tj=" + mission.getTauxJournalier()));
		}
	}

}

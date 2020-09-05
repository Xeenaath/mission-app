package dev.mission.exec;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("listerProchainesMissionsParJTM")
public class ListerProchainesMissionsParTJM implements Runnable {
	private MissionRepository missionRepository;
	private static final Logger LOG = LoggerFactory.getLogger(ListerProchainesMissions.class);

	public ListerProchainesMissionsParTJM(MissionRepository missionRepository) {
		this.missionRepository = missionRepository;
	}
	
	@Override
	public void run() {
		LocalDate date = LocalDate.now();
		BigDecimal tauxJournalier = new BigDecimal("101.00");
		List<Mission> listeMissions = this.missionRepository.findByDateAndByTauxJournalier(date, tauxJournalier);
		System.out.println(listeMissions.size());
		for (Mission mission : listeMissions) {
			System.out.println(mission.toString());
		}	
	}
	
}

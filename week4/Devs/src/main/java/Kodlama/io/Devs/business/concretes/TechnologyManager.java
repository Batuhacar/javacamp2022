package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.technologyRequests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.DeleteTechnologyRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.technologyResponses.GetAllTechnologyResponse;
import Kodlama.io.Devs.business.responses.technologyResponses.GetByIdTechnologyResponse;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {
	private TechnologyRepository technologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository, ProgrammingLanguageRepository programmingLanguageRepository) {
		this.technologyRepository = technologyRepository;
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.getReferenceById(createTechnologyRequest.getProgrammingLanguageId());
		
		Technology technology = new Technology();
		technology.setName(createTechnologyRequest.getName());
		technology.setProgrammingLanguage(programmingLanguage);
		
		List<Technology> technologies = technologyRepository.findAll();
		
		for (Technology t : technologies) {
			if (t.getName().equals(technology.getName())) {
				throw new Exception("İsimler tekrar edemez.");
			}
		}
		
		if (technology.getName().isEmpty()) {
			throw new Exception("Teknoloji ismi boş geçilemez.");
		}
		
		this.technologyRepository.save(technology);
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		Technology technology = new Technology();
		technology.setId(deleteTechnologyRequest.getId());
		
		technologyRepository.delete(technology);
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.getReferenceById(updateTechnologyRequest.getProgrammingLanguageId());
		
		Technology technology = new Technology();
		technology.setId(updateTechnologyRequest.getId());
		technology.setName(updateTechnologyRequest.getName());
		technology.setProgrammingLanguage(programmingLanguage);
		
		List<Technology> technologies = technologyRepository.findAll();
		
		for (Technology t : technologies) {
			if (t.getName().equals(technology.getName())) {
				throw new Exception("İsimler tekrar edemez.");
			}
		}
		
		if (technology.getName().isEmpty()) {
			throw new Exception("Teknoloji ismi boş geçilemez.");
		}
		
		Technology updatedTechnology = technologyRepository.getReferenceById(technology.getId());
		updatedTechnology.setName(technology.getName());
		updatedTechnology.setProgrammingLanguage(programmingLanguage);
		technologyRepository.save(updatedTechnology);
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologyResponse> technologiesResponse = new ArrayList<GetAllTechnologyResponse>();
		
		for (Technology technology : technologies) {
			GetAllTechnologyResponse responseItem = new GetAllTechnologyResponse();
			
			ProgrammingLanguage programmingLanguage = programmingLanguageRepository.getReferenceById(technology.getProgrammingLanguage().getId());
			
			responseItem.setId(technology.getId());
			responseItem.setLanguageName(programmingLanguage.getName());
			responseItem.setName(technology.getName());
			
			technologiesResponse.add(responseItem);
		}
		
		return technologiesResponse;
	}

	@Override
	public GetByIdTechnologyResponse getById(int id) {
		
		Technology technology = technologyRepository.getReferenceById(id);
		
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.getReferenceById(technology.getProgrammingLanguage().getId());
		
		GetByIdTechnologyResponse technologyResponse = new GetByIdTechnologyResponse();
		technologyResponse.setId(technology.getId());
		technologyResponse.setProgrammingLanguageName(programmingLanguage.getName());
		technologyResponse.setName(technology.getName());
		
		return technologyResponse;
	}

}
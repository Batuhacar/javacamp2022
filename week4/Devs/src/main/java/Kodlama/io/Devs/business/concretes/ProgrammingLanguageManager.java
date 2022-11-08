package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.responses.programmingLanguagesResponse.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Devs.business.responses.programmingLanguagesResponse.GetByIdProgrammingLanguageResponse;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setName(createProgrammingLanguageRequest.getName());
		
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		
		for (ProgrammingLanguage pl : programmingLanguages) {
			if(pl.getName().equals(programmingLanguage.getName())) {
				throw new Exception("İsimler tekrar edemez.");
			}
		}
		
		if(programmingLanguage.getName().isEmpty()) {
			throw new Exception("Programlama dili boş geçilemez.");
		}
		
		this.programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setId(deleteProgrammingLanguageRequest.getId());
		
		programmingLanguageRepository.delete(programmingLanguage);
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setId(updateProgrammingLanguageRequest.getId());
		programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
		
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		
		for (ProgrammingLanguage pl : programmingLanguages) {
			if(pl.getName().equals(programmingLanguage.getName())) {
				throw new Exception("İsimler tekrar edemez.");
			}
		}
		
		if(programmingLanguage.getName().isEmpty()) {
			throw new Exception("Programlama dili boş geçilemez.");
		}
		
		
		ProgrammingLanguage updatedProgrammingLanguage = programmingLanguageRepository.getReferenceById(programmingLanguage.getId());
		updatedProgrammingLanguage.setName(programmingLanguage.getName());
		programmingLanguageRepository.save(updatedProgrammingLanguage);
	}

	
	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponse = new ArrayList<GetAllProgrammingLanguagesResponse>();
		
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
			responseItem.setId(programmingLanguage.getId());
			responseItem.setName(programmingLanguage.getName());
			
			programmingLanguagesResponse.add(responseItem);
		}
		
		return programmingLanguagesResponse;
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {
		
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.getReferenceById(id);
		
		GetByIdProgrammingLanguageResponse programmingLanguageResponse = new GetByIdProgrammingLanguageResponse();
		programmingLanguageResponse.setId(programmingLanguage.getId());
		programmingLanguageResponse.setName(programmingLanguage.getName());
		
		return programmingLanguageResponse;
	}

}
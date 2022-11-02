package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

	List<Language> languages;

	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1, "Java"));
		languages.add(new Language(2, "C"));
		languages.add(new Language(3, "Python"));
		languages.add(new Language(4, "PHP"));
		languages.add(new Language(5, "JavaScript"));
	}

	@Override
	public List<Language> getAll() {
		return languages;
	}

	@Override
	public Language getById(int id) throws Exception {
		
		return null;
	}

	@Override
	public void create(Language language) {
		
		
	}

	@Override
	public void update(Language language, int id) throws Exception {
		
		
	}

	@Override
	public void delete(int id) throws Exception {
		
		
	}

}
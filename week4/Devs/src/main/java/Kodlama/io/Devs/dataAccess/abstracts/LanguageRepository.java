package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.Language;

public interface LanguageRepository {

	List<Language> getAll();

	Language getById(int id) throws Exception;

	void create(Language language);

	void update(Language language, int id) throws Exception;

	void delete(int id) throws Exception;

}

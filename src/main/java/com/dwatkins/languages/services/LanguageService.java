package com.dwatkins.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dwatkins.languages.models.Language;
import com.dwatkins.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
	
	public Language createLanguage(Language l) {
		return languageRepository.save(l);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLang = languageRepository.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();			
		}
		else {
			return null;
		}
	}
	
	public Language updateLanguage(Long id, String name, String creator, String currentVersion) {
		Optional<Language> optionalLang = languageRepository.findById(id);
		Language updateLang = optionalLang.get();
		updateLang.setName(name);
		updateLang.setCreator(creator);
		updateLang.setCurrentVersion(currentVersion);
		return languageRepository.save(updateLang);
	}
	
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}
}

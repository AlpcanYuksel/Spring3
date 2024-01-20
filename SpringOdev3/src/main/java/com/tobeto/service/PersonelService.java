package com.tobeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.dao.PersonelDAO;
import com.tobeto.entity.Personel;

//@RequiredArgsConstructor // final olarak yazılan tüm değişkenlerin constructor'a
// otomatik yazılıyor
@Service
public class PersonelService {
	@Autowired // yukarıdaki annotation'un alternatifi. araştır***
	private PersonelDAO personelDAO;

	// al bu personeli yarat diyor personelDAO'ya.
	// diğer methodlar da aynı şekilde çalışıyor
	public void createPersonel(Personel personel) {
		personelDAO.savePersonel(personel);
	}

	public Optional<Personel> getPersonel(String id) {
		return personelDAO.getPersonel(id);
	}

	public void deletePersonel(String id) {
		personelDAO.deletePersonel(id);
	}

	public void updatePersonel(String id, Personel personel) {
		personelDAO.updatePersonel(id, personel);
	}

	public List<Personel> getTumPersoneller() {
		return personelDAO.getTumPersoneller();

	}

}

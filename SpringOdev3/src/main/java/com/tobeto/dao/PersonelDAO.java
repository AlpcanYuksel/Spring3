package com.tobeto.dao;
//Veritabanı işlemleri yapan class'ımız olacak

//ondan dolayı sadece veritabanı işlemleri için metodlar yazılır

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.tobeto.entity.Personel;

@Repository // bu class'ın veritanı ile alakalı olduğunu anlaıyor,
			// component,service gibi şeyler yazsak da aynı anlama geliyor
public class PersonelDAO {
	private List<Personel> personeller = new ArrayList<Personel>();

	public List<Personel> getTumPersoneller() {
		return personeller;
	}

	public Optional<Personel> getPersonel(String id) {
		return personeller.stream().filter(p -> p.getId().equals(id))
				.findFirst();
		// stream yapısı... ile birbirini zincirle
		// çağıran
		// yapıdır. for
		// ile id'leri
		// döneceğimize
		// böyle
		// yapıyoruz
	}

	public void deletePersonel(String id) {
		Optional<Personel> oPersonel = getPersonel(id);
		if (oPersonel.isPresent()) {
			personeller.remove(oPersonel.get());
		}
	}

	public void savePersonel(Personel personel) {
		// veritabanında aynı id'li personel var mı diye bakıyoruz
		Optional<Personel> oPersonel = getPersonel(personel.getId());
		// yoksa veritabanına ekliyoruz
		// yoksa var olan personel'i silip yenisini ekliyoruz
		if (oPersonel.isPresent()) {
			personeller.remove(oPersonel.get());
		}
		personeller.add(personel);

	}

	public void updatePersonel(String id, Personel personel) {
		Optional<Personel> oPersonel = getPersonel(id);
		if (oPersonel.isPresent()) {
			Personel dbPersonel = oPersonel.get();
			dbPersonel.setAdi(personel.getAdi());
			dbPersonel.setSoyadi(personel.getSoyadi());
			dbPersonel.setDogumTarihi(personel.getDogumTarihi());
		}

	}

}
//Anonymous class araştır, Consumer interface
//Collectin java araştır
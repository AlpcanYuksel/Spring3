package com.tobeto.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.entity.Personel;
import com.tobeto.service.PersonelService;

@RestController
public class PersonelController {

	// Controller katmanı, bir isteği alır ve cevap döndürür

	@Autowired // class'ı yaratıyor ve içi dolu bir şekilde yaratıyor
	private PersonelService personelService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String createPersonel(@RequestBody Personel personel) {
		personelService.createPersonel(personel);
		JSONObject sonuc = new JSONObject();
		sonuc.put("sonuc", "Personel Oluşturuldu");
		return sonuc.toString();
	}

	@GetMapping
	public List<Personel> getTumPersoneller() {
		return personelService.getTumPersoneller();
	}

	@GetMapping("/{id}")
	public Personel getPersonel(@PathVariable String id) {
		// yoksa orELseThrow, exception fırlatır.
		return personelService.getPersonel(id).orElseThrow();
	}

	@PutMapping("/{id}")
	public String updatePersonel(@PathVariable String id,
			@RequestBody Personel personel) {
		personelService.updatePersonel(id, personel);
		JSONObject sonuc = new JSONObject();
		sonuc.put("sonuc", "Personel Güncellendi");
		return sonuc.toString();

	}
}

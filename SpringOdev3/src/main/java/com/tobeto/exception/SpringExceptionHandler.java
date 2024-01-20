package com.tobeto.exception;

import java.util.NoSuchElementException;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // projede herhangi bir yerde exception oluşursa, döndürülecek
					// olan cevabı
					// bu class'dan döndürülecek olduğunu belirtir
public class SpringExceptionHandler {
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> hataOlustu(Exception e) {
		JSONObject sonuc = new JSONObject();
		sonuc.put("hata", "Kayıt Bulunamadı");
		return ResponseEntity.internalServerError().body(sonuc.toString());
	}
}

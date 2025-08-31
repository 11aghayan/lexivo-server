package com.lexivo.lexivo.controller;

import com.lexivo.lexivo.exception.DictionaryNotFoundException;
import com.lexivo.lexivo.exception.UserNotFoundException;
import com.lexivo.lexivo.model.Dictionary;
import com.lexivo.lexivo.model.DictionaryPublic;
import com.lexivo.lexivo.service.DictService;
import com.lexivo.lexivo.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dict")
public class DictController {
	@Autowired
	private DictService service;

	@PostMapping("/**")
	public ResponseEntity<String> addDictionary(@RequestBody Dictionary dictionary) {
		//		TODO: Check id dictionary.getId() matches the JWT ID
		try {
			service.addDict(dictionary);
			return ResponseUtil.responseCreated();
		}
		catch (UserNotFoundException e) {
			return ResponseUtil.responseUserNotFound(e.getMessage());
		}
		catch (RuntimeException e) {
			return ResponseUtil.responseServerError();
		}
	}

	@GetMapping("/{id}/**")
	public ResponseEntity<?> getDictionary(@PathVariable String id) {
		try {
			DictionaryPublic dictionary = service.getDictById(id);
			return new ResponseEntity<>(dictionary, HttpStatus.OK);
		}
		catch (DictionaryNotFoundException e) {
			return ResponseUtil.responseDictionaryNotFound(e.getMessage());
		}
		catch (RuntimeException e) {
			return ResponseUtil.responseServerError();
		}
	}

	@GetMapping("/**")
	public ResponseEntity<List<DictionaryPublic>> getAllDictionaries() {
		String ownerId = "d92af10d-68c4-4d84-ab99-0586e599892f";
//		String ownerId = "d6532312-246c-4144-bef0-38060141ccd5";
//		String ownerId = "non-existing-id";
		return new ResponseEntity<>(service.getAllDicts(ownerId), HttpStatus.OK);
	}

	@PutMapping("/**")
	public ResponseEntity<?> updateDictionary(@RequestBody Dictionary dictionary) {
//		TODO: Check id dictionary.getId() matches the JWT ID
		try {
			service.updateDict(dictionary);
			return ResponseUtil.responseOk();
		}
		catch (DictionaryNotFoundException e) {
			return ResponseUtil.responseDictionaryNotFound(e.getMessage());
		}
		catch (UserNotFoundException e) {
			return ResponseUtil.responseUserNotFound(e.getMessage());
		}
		catch (RuntimeException e) {
			return ResponseUtil.responseServerError();
		}
	}

	@DeleteMapping("/{id}/**")
	public ResponseEntity<?> deleteDictionary(@PathVariable String id) {
		//		TODO: Check id dictionary.getId() matches the JWT ID
		try {
			service.deleteDictionary(id);
			return ResponseUtil.responseOk();
		}
		catch(DictionaryNotFoundException e) {
			return ResponseUtil.responseDictionaryNotFound(e.getMessage());
		}
		catch (RuntimeException e) {
			return ResponseUtil.responseServerError();
		}
	}
}

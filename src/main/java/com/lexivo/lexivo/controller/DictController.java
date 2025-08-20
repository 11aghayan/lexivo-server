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

@RestController
@RequestMapping("/dict")
public class DictController {
	@Autowired
	private DictService service;

	@PostMapping("")
	public ResponseEntity<String> addDictionary(@RequestBody Dictionary dictionary) {
		try {
			service.addDict(dictionary);
			return ResponseUtil.responseCreated();
		}
		catch (UserNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (RuntimeException e) {
			return ResponseUtil.responseServerError();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getDictionary(@PathVariable String id) {
		try {
			DictionaryPublic dictionary = service.getDictById(id);
			System.out.println(dictionary);
			return new ResponseEntity<>(dictionary, HttpStatus.OK);
		}
		catch (DictionaryNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		catch (RuntimeException e) {
			return ResponseUtil.responseServerError();
		}
	}
}

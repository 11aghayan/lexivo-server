package com.lexivo.lexivo.controller;

import com.lexivo.lexivo.exception.DictionaryNotFoundException;
import com.lexivo.lexivo.exception.UserNotFoundException;
import com.lexivo.lexivo.model.Dictionary;
import com.lexivo.lexivo.model.DictionaryPublic;
import com.lexivo.lexivo.model.User;
import com.lexivo.lexivo.service.DictService;
import com.lexivo.lexivo.service.UserService;
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
	private DictService dictService;
	@Autowired
	private UserService userService;

	@PostMapping("/**")
	public ResponseEntity<?> addDictionary(@RequestBody Dictionary dictionary) {
		try {
			//		TODO: get the owner from jwt by username instead of id and update the dictionary
			User user = userService.getUserById("d6532312-246c-4144-bef0-38060141ccd5");
			dictionary.setOwner(user);
			if (dictService.getDictById(dictionary.getId()) != null) {
				return updateDictionary(dictionary);
			}

			dictService.addDict(dictionary);
			return ResponseUtil.responseCreated();
		}
		catch (UserNotFoundException e) {
			return ResponseUtil.responseUserNotFound(e.getMessage());
		}
		catch (RuntimeException e) {
			return ResponseUtil.responseServerError(e);
		}
	}

	@GetMapping("/{id}/**")
	public ResponseEntity<?> getDictionary(@PathVariable String id) {
		try {
			DictionaryPublic dictionary = dictService.getDictById(id);
			return dictionary == null ?
					ResponseUtil.responseDictionaryNotFound(id)
					: new ResponseEntity<>(dictionary, HttpStatus.OK);
		}
		catch (RuntimeException e) {
			return ResponseUtil.responseServerError(e);
		}
	}

	@GetMapping("/**")
	public ResponseEntity<List<DictionaryPublic>> getAllDictionaries() {
//		TODO: Get owner from jwt
		String ownerId = "d92af10d-68c4-4d84-ab99-0586e599892f";
//		String ownerId = "d6532312-246c-4144-bef0-38060141ccd5";
//		String ownerId = "non-existing-id";
		return new ResponseEntity<>(dictService.getAllDicts(ownerId), HttpStatus.OK);
	}

	@PutMapping("/**")
	public ResponseEntity<?> updateDictionary(@RequestBody Dictionary dictionary) {
		try {
//				TODO: get the owner from jwt by username instead of id and update the dictionary
//				TODO: if the local dictionary has more of anything than the uploaded one, then save the uploaded one locally and send a request to confirm to override the local dict
			User user = userService.getUserById("d6532312-246c-4144-bef0-38060141ccd5");
			dictionary.setOwner(user);
			dictService.updateDict(dictionary);
			return ResponseUtil.responseOk();
		}
		catch (DictionaryNotFoundException e) {
			return ResponseUtil.responseDictionaryNotFound(e.getMessage());
		}
		catch (UserNotFoundException e) {
			return ResponseUtil.responseUserNotFound(e.getMessage());
		}
		catch (RuntimeException e) {
			return ResponseUtil.responseServerError(e);
		}
	}

	@DeleteMapping("/{id}/**")
	public ResponseEntity<?> deleteDictionary(@PathVariable String id) {
		//		TODO: Check id dictionary.ownerId() matches the JWT ID
		try {
			dictService.deleteDictionary(id);
			return ResponseUtil.responseOk();
		}
		catch(DictionaryNotFoundException e) {
			return ResponseUtil.responseDictionaryNotFound(e.getMessage());
		}
		catch (RuntimeException e) {
			return ResponseUtil.responseServerError(e);
		}
	}
}

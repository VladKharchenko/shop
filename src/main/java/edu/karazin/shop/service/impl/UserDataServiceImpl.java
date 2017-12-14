package edu.karazin.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.stereotype.Service;
import edu.karazin.shop.dao.UserDataRepository;
import edu.karazin.shop.model.UserData;
import edu.karazin.shop.service.UserDataService;

@Service
public class UserDataServiceImpl implements UserDataService {

	private final UserDataRepository userDataRepository;

	@Autowired
	public UserDataServiceImpl(UserDataRepository userDataRepository) {
		this.userDataRepository = userDataRepository;
	}
	
	@Override
	public UserData createUserData(UserData data) {
		return userDataRepository.save(data);
	}

	@Override
	public UserData getUserData(Long id) {
		return userDataRepository.findOne(id);
	}

}

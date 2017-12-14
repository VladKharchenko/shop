package edu.karazin.shop.service;

import edu.karazin.shop.model.UserData;

public interface UserDataService {
	UserData createUserData(UserData data);

	UserData getUserData(Long id);

//	UserData getUserData(String login);
}

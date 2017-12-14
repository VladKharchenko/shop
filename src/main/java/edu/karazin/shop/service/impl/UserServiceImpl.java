package edu.karazin.shop.service.impl;

import edu.karazin.shop.dao.UserRepository;
import edu.karazin.shop.model.User;
import edu.karazin.shop.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUser(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User getUser(String login) {
		return userRepository.findByLogin(login);
	}
}
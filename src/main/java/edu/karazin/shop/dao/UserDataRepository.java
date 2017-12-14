package edu.karazin.shop.dao;

import org.springframework.data.repository.CrudRepository;

import edu.karazin.shop.model.UserData;

public interface UserDataRepository extends CrudRepository<UserData, Long> {

}

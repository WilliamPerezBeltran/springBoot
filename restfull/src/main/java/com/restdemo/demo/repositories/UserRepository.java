package com.restdemo.demo.repositories;

import com.restdemo.demo.domain.User;
import com.restdemo.demo.exceptions.EtAuthException;

public interface UserRepository {
	Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;
	User findByEmailAndPassword(String email, String password) throws EtAuthException;
	Integer getCountByEmail(String email);
	User findById(Integer userId);
}

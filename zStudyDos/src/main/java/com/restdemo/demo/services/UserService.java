package com.restdemo.demo.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.restdemo.demo.domain.User;
import com.restdemo.demo.exceptions.EtAuthException;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public interface UserService {
	User validateUser(String name, String password) throws EtAuthException;
	User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;

}

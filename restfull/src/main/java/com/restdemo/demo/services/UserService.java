package com.restdemo.demo.services;

import com.restdemo.demo.domain.User;
import com.restdemo.demo.exceptions.EtAuthException;

public interface UserService {
	User validateUser(String email, String password) throws EtAuthException;
	User registerUser(String firstName,String lastName,String email, String password) throws EtAuthException;

}

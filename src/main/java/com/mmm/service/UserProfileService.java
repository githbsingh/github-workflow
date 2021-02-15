/**
 * 
 */
package com.mmm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmm.model.UserProfile;
import com.mmm.repository.UserProfileRepository;

/**
 * @author A2KRJZZ
 *
 */
@Service
public class UserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepository;

	public Optional<UserProfile> getUserProfile(String id) {
		return userProfileRepository.findById(id);
	}
	
	public Optional<UserProfile> getUserProfileByName(String name) {
		return userProfileRepository.findByFullName(name);
	}

	public void updateUserProfile(UserProfile userProfile) {
		userProfileRepository.save(userProfile);
	}

	public List<String> searchByUserPin(String keyword) {
		return userProfileRepository.searchByUserPin(keyword);
	}

	public List<String> searchByUserName(String parameter) {
		return userProfileRepository.searchByUserName(parameter);
	}

	public Optional<UserProfile> getUserProfileByIdAndName(String id, String name) {
		return userProfileRepository.getUserProfileByIdAndName(id,name);
	}

}

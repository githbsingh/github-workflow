package com.mmm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mmm.model.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile, String> {

	@Query("SELECT userPin FROM UserProfile where userPin like LOWER(CONCAT('%', :keyword, '%'))")
	public List<String> searchByUserPin(@Param("keyword") String keyword);

	@Query("SELECT firstName + ' ' + lastName FROM UserProfile where firstName like LOWER(CONCAT('%', :parameter, '%'))"
			+ "OR LOWER(lastName) LIKE LOWER(CONCAT('%', :parameter, '%'))")
	public List<String> searchByUserName(@Param("parameter") String parameter);

	public Optional<UserProfile> findByFullName(String name);

	@Query("FROM UserProfile where userPin = LOWER(:id)" + "AND fullName = LOWER(:name)")
	public Optional<UserProfile> getUserProfileByIdAndName(@Param("id") String id, @Param("name") String name);

}

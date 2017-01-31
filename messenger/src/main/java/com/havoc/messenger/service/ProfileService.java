package com.havoc.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.havoc.messenger.database.DatabaseClass;
import com.havoc.messenger.model.Profile;

public class ProfileService {
	
private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("key1", new Profile(1L, "havoc1", "Sujan", "Havoc"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
	
	

}

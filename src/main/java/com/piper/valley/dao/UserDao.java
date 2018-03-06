package com.piper.valley.dao;

import com.piper.valley.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("UserDao")
public class UserDao implements EntityDao<User> {

	private static Map<String, User> entities;

	static {
		entities = new HashMap<String, User>() {
			{
				put("1", new User("1", "Sherif", "sherifabdlnaby", "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92", "sherif@email.com",0));
				put("2", new User("2", "Khaled", "wewark", "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92", "wewark@email.com",1));
				put("3", new User("3", "Refaie", "refaie        ", "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92", "refaie@email.com",2));
			}
		};
	}

	@Override
	public Collection<User> getAllEntities() {
		return entities.values();
	}


	@Override
	public User getEntityById(String id) {
		return entities.get(id);
	}

	@Override
	public boolean removeEntityById(String id) {
		entities.remove(id);
		return true;
	}

	@Override
	public boolean updateEntity(User User) {
		User s = entities.get(User.getId());
		entities.put(User.getId(), User);
		return true;
	}

	@Override
	public boolean insertEntityToDb(User User) {
		entities.put(User.getId(), User);
		return true;
	}

	public User getEntityByUsername(String Username) {
		Collection<User> users = this.getAllEntities();
		for (User user : users) {
			if (user.getUsername().equals(Username))
				return user;
		}
		return null;
	}

	public boolean emailExists(String email) {
		// TODO
		return false;
	}
}
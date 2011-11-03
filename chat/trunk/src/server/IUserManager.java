package server;

import java.util.Map;

import client.IChatUser;

public interface IUserManager extends IUserManagerService {

	public abstract Map<String, IChatUser> getUsers();

}
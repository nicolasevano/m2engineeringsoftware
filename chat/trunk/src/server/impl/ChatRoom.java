package server.impl;

import java.rmi.Remote;

import server.IAuthentificationManager;
import server.IPostManager;
import server.IUserManagerService;



public interface ChatRoom extends Remote,IAuthentificationManager, IPostManager, IUserManagerService {

      
    
}
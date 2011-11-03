package client.impl;

import java.rmi.RemoteException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import client.IChatUser;

public class Main {

	public static void main(String[] args) throws RemoteException {
		
		ApplicationContext beanFactory = new ClassPathXmlApplicationContext( "client_configuration.xml" );
		( ( ChatUserImpl ) beanFactory.getBean( "chatUserImpl" ) ).setBeanFactory( beanFactory );
		( ( Thread ) beanFactory.getBean( "executor" ) ).start();
		
	}

}

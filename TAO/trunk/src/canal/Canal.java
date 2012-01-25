package canal;

import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import client.Screen;

import sensor.EntryVersion;
import sensor.Sensor;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Canal extends Remote,Serializable  {
	/**
	 * Attach function screen implementation to a canal
	 * @param screen
	 */
	public abstract void attach( Screen screen ) throws RemoteException;

	/**
	 * Detach function a screen implementation from a canal(if and only if attached before)
	 * @param screen
	 */
	public abstract void detach( Screen screen ) throws RemoteException;

	/**
	 * Update function notify that current sensor value has been updated
	 */
	public abstract void update() throws RemoteException;

	/**
	 * GetValue function allow to get a future on the new sensor value when it's ready 
	 * @return ScheduledFuture<integer> ticket sensor value
	 */
	public abstract ScheduledFuture<EntryVersion> getValue(int id) throws RemoteException;

	/**
	 * GetSensor function return this attached sensor
	 * @return Sensor
	 * @throws RemoteException
	 */
	public abstract Sensor getSensor() throws RemoteException;
	
	/**
	 * GetTickets function return screen tickets
	 * @return Map<Integer,Integer>
	 * @throws RemoteException
	 */
	public Map<Integer, EntryVersion> getTickets() throws RemoteException;
	
	/**
	 * GetTicket function return screen ticket
	 * @param id
	 * @return integer
	 * @throws RemoteException
	 */
	public EntryVersion getTicket(int id) throws RemoteException;

}
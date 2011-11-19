package org.istic.m2softwareengineering.client;

import java.util.List;

import org.istic.m2softwareengineering.client.Position;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.maps.client.InfoWindowContent;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.Maps;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.maps.client.overlay.MarkerOptions;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TAAGWTLattitude implements EntryPoint {

	/**
	 * Create a remote service proxy to talk to the server-side Lattitude service.
	 */
	private final RLatitudeServiceAsync test = GWT.create( RLatitudeService.class );
	
	/**
	 * called at first http request
	 */
	public void onModuleLoad(){
		loginButton = new Button( "Login" );
		createUserButton = new Button( "Create User" );
		disconnectButton = new Button( "Disconnect" );
		publishPositionButton = new Button( "Publish Position" );
		displayPositionButton = new Button( "Display Position" );
		addContactButton = new Button( "Add Contact" );
		updateVisibleRightButton = new Button( "Update visible right" );
		loggedUser = new TextBox();
		loggedUser.setEnabled( false );
		visibleRight = new TextBox();
		visibleRight.setEnabled( false );
		contactBox = new ListBox();
		
		//RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get( "loginButton" ).add( loginButton );
		RootPanel.get( "createUserButton" ).add( createUserButton );
		RootPanel.get( "disconnectedButton" ).add( disconnectButton );
		RootPanel.get( "publishMyPositionButton" ).add( publishPositionButton );
		RootPanel.get( "displayPositionButton" ).add( displayPositionButton );
		RootPanel.get( "addContactButton" ).add( addContactButton );
		RootPanel.get( "contactsList" ).add( contactBox );
		RootPanel.get( "updateVisibleRight" ).add( updateVisibleRightButton );
		RootPanel.get( "loggedUser" ).add(loggedUser);
		RootPanel.get( "visibleRight" ).add(visibleRight);
		
		//RootPanel.get("errorLabelContainer").add(errorLabel);
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText( "Remote Procedure Call" );
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button( "Close" );
		closeButton.getElement().setId( "closeButton" );
		
		disconnectButton.getElement().setId( "disconnectButtonE" );
		disconnectButton.addClickHandler( new DisconnectHandler() );
		loginButton.getElement().setId( "loginButtonE" );
		createUserButton.getElement().setId( "createUserButtonE" );
		publishPositionButton.getElement().setId( "publishPostionButtonE" );
		displayPositionButton.getElement().setId( "displayPositionButtonE" );
		addContactButton.getElement().setId( "addContactButtonE" );
		updateVisibleRightButton.addClickHandler( new ChangeVisibilyHandler() );
		uid = "";
		
		disconnectedState();
		//add handler for login functionality
		loginDialog = BuildDialogLogin();
		LoginHandler loginHandler = new LoginHandler();
		submitLoginButton.addClickHandler( loginHandler );
		loginInput.addKeyUpHandler( loginHandler );
		passwordInput.addKeyUpHandler( loginHandler );
		loginButton.addClickHandler( new ShowLoginDialogHandler() );
		
		//add handler for publish functionality
		ShowPublishDialogHandler publishHandler = new ShowPublishDialogHandler();
		publishPositionButton.addClickHandler(publishHandler);
		publishPositionDialog = BuildDialogPublishPosition(); 
		submitPublishPositionButton.addClickHandler( new PublishPositionHandler() );
		
		//add handler for create user functionality
		createUserDialog = BuildDialogCreateNewUser();
		submitCreateUserButton.addClickHandler( new SubmitCreateUserHandler() );
		createUserButton.addClickHandler( new ShowCreateUserDialogHandler() );
		
		//add handler for add contact functionality
		newContactDialog = BuildDialogNewContact();
		submitNewContactButton.addClickHandler(new NewContactHandler());
		addContactButton.addClickHandler( new ShowNewContactHandler() );
		
		//add handler for display position
		displayPositionButton.addClickHandler(new displayPositionHandler());
		
		//add feature for contact box
		contactBox.setWidth("11em");
		contactBox.setVisibleItemCount(10);
	}
	
	/**
	 * set allowed action in connected state ( Enable or disable button )
	 *  
	 */
	public void connectedState(){
		
		loginButton.setEnabled( false );
		createUserButton.setEnabled( false );
		disconnectButton.setEnabled( true );
		publishPositionButton.setEnabled( true );
		displayPositionButton.setEnabled( true );
		addContactButton.setEnabled( true );
		updateVisibleRightButton.setEnabled( true );
		test.getVisibility( uid, new GetVisibleRight() );
		
		
	}
	
	/**
	 * set allowed action in disconnected state ( Enable or disable button ) 
	 */
	public void disconnectedState(){
		
		loginButton.setEnabled( true );
		createUserButton.setEnabled( true );
		disconnectButton.setEnabled( false );
		publishPositionButton.setEnabled( false );
		displayPositionButton.setEnabled( false );
		addContactButton.setEnabled( false );
		updateVisibleRightButton.setEnabled( false );
		loggedUser.setText( "" );
		visibleRight.setText( "" );
		RootPanel.get("positionMap").clear();
		
	}
	
	/**
	 * click Handler define action on submit login button
	 * @author nicolas
	 *
	 */
	class LoginHandler implements ClickHandler, KeyUpHandler{

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			loginToServer();
		}

		@Override
		public void onKeyUp(KeyUpEvent event) {
			// TODO Auto-generated method stub
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				loginToServer();
			}
		}
		
		private void loginToServer(){
			test.connect(loginInput.getText(), passwordInput.getText(), new AsyncCallback<String>() {
				
				public void onFailure( Throwable caught ){
					//TODO
					loginDialog.setText("Remote Procedure Call - Failure");
				}
				
				public void onSuccess( String result ){
					if( !result.isEmpty() ){
						loginDialog.setText( "login success" );
						uid = result;
						connected = true;
						connectedState();
						loadContact();
						loginDialog.hide();
					} else {
						loginDialog.setText( "login failure" );
					}
				}
				
			});
		}
	}
	
	/**
	 * implements AsyncCallback<ResolvedUser> design to set IHM user connected parameter
	 * @author nicolas
	 *
	 */
	class GetUserConnected implements AsyncCallback<ResolvedUser>{

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(ResolvedUser result) {
			// TODO Auto-generated method stub
			loggedUser.setText(result.getName() + "-" + result.getFirstName());
		}
		
	}
	
	/**
	 * Show login dialog click handler define action on login button 
	 * @author nicolas
	 *
	 */
	class ShowLoginDialogHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			loginInput.setText( "" );
			passwordInput.setText( "" );
			loginDialog.setText( "Remote Procedure Call" );
			loginDialog.center();
		}
		
	}
	
	/**
	 * Show publish dialog handler define action on publish position button
	 * @author nicolas
	 *
	 */
	class ShowPublishDialogHandler implements ClickHandler{
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			xPosition.setText( "" );
			yPosition.setText( "" );
			zPosition.setText( "" );
			publishPositionDialog.setText( "Remote Procedure Call" );
			publishPositionDialog.center();
		}
		
	}
	
	/**
	 * Disconnect handler define action on disconnect button
	 * @author nicolas
	 *
	 */
	class DisconnectHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			test.disconnect( getUid(), new AsyncCallback<Boolean>(){

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onSuccess(Boolean result) {
					// TODO Auto-generated method stub
					setUid( "" );
					connected = false;
					disconnectedState();
					removeContact();
				}
				
			});
		}
		
	}
	
	class ChangeVisibilyHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			updateVisibleRight( "Show Me".equals( updateVisibleRightButton.getText() ) );
		}
		
	}
	
	/**
	 * Publish position handler define action on submit position button 
	 * @author nicolas
	 *
	 */
	class PublishPositionHandler implements ClickHandler{
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			test.setCurrentPostion( getUid(), new Position( xPosition.getValue(), yPosition.getValue(), zPosition.getValue() ), new AsyncCallback<Void>(){

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					publishPositionDialog.setText( "Remote Procedure Call - Failure" );
				}

				@Override
				public void onSuccess(Void result) {
					
					// TODO Auto-generated method stub
					publishPositionDialog.setText( "PublishPositionSuccess" );
					publishPositionDialog.hide();
				}
				
			});
		}
		
	}
	
	/**
	 * Show create user dialog Define action on show create user button 
	 * @author nicolas
	 *
	 */
	class ShowCreateUserDialogHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			nameUser.setText( "" );
			passwordUser.setText( "" );
			loginUser.setText( "" );
			birthDateUser.setText( "" );
			firstNameUser.setText( "" );
			createUserDialog.center();
		}
		
	}
	
	/**
	 * Submit create user handler define action on submit create user button 
	 * @author nicolas
	 *
	 */
	class SubmitCreateUserHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			CheckLoginPasswordValidity checkUserAuth = new CheckLoginPasswordValidity();
			test.checkPasswordLoginValidity(loginUser.getText(), passwordUser.getText(),checkUserAuth );
		}
		
	}
	
	/**
	 * Show new contact handler define action on show new contact button
	 * @author nicolas
	 *
	 */
	class ShowNewContactHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			nameContact.setText( "" );
			firstNameContact.setText( "" );
			newContactDialog.setText( "Remote Procedure Call" );
			newContactDialog.center();
		}
		
	}
	
	/**
	 * New contact click handler define action on submit new contact handler
	 * @author nicolas
	 *
	 */
	class NewContactHandler implements ClickHandler{
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			
			test.getUser(nameContact.getText(), firstNameContact.getText(), new AsyncCallback< ResolvedUser >(){

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					newContactDialog.setText( "Remote Procedure Call - Failure" );
				}

				@Override
				public void onSuccess(ResolvedUser result) {
					// TODO Auto-generated method stub
					test.addContact(uid, result.getId(), new AsyncCallback<Void>(){

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							newContactDialog.setText( "Remote Procedure Call - Failure" );
						}

						@Override
						public void onSuccess(Void result) {
							// TODO Auto-generated method stub
							newContactDialog.setText( "AddContactSuccess" );
							newContactDialog.hide();
						}
						
					});
					
				}
				
			});
		}
		
	}
	
	
	/**
	 * design build login dialog box
	 * @return
	 */
	private DialogBox BuildDialogLogin(){
		
		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		submitLoginButton = new Button("Login");
		loginInput = new TextBox();
		Label loginLabel = new Label( "login" );
		HorizontalPanel loginPanel = new HorizontalPanel();
		loginPanel.add(loginLabel);
		loginPanel.add(loginInput);
		passwordInput = new TextBox();
		Label passwordLabel = new Label( "password" );
		HorizontalPanel passwordPanel = new HorizontalPanel();
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordInput);
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId( "closeButton" );
		loginInput.getElement().setId( "loginInput" );
		loginInput.getElement().setId( "passwordInput" );
		submitLoginButton.getElement().setId( "submitButton" );
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>login on server:</b>"));
		
		//dialogVPanel.add(textToServerLabel);
		dialogVPanel.add( loginPanel );
		dialogVPanel.add( passwordPanel );
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		HorizontalPanel actionPanel = new HorizontalPanel();
		actionPanel.add( submitLoginButton );
		actionPanel.add( closeButton );
		dialogVPanel.add( actionPanel );
		dialogBox.setWidget(dialogVPanel);

		addCloseHandler( dialogBox, closeButton );
		return dialogBox;
	}
	
	/**
	 * design create new user dialog box
	 * @return
	 */
	private DialogBox BuildDialogCreateNewUser(){
		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		nameUser = new TextBox();
		Label nameLabel = new Label( "name: " );
		HorizontalPanel namePanel = new HorizontalPanel();
		namePanel.add(nameLabel);
		namePanel.add(nameUser);
		
		firstNameUser = new TextBox();
		Label firstNameLabel = new Label( "first name: " );
		HorizontalPanel firstNamePanel = new HorizontalPanel();
		firstNamePanel.add( firstNameLabel );
		firstNamePanel.add( firstNameUser );
		
		birthDateUser = new TextBox();
		Label birthDateLabel = new Label( "birth date: " );
		HorizontalPanel birthDatePanel = new HorizontalPanel();
		birthDatePanel.add( birthDateLabel );
		birthDatePanel.add( birthDateUser );
		
		loginUser = new TextBox();
		Label loginLabel = new Label( "login: " );
		HorizontalPanel loginPanel = new HorizontalPanel();
		loginPanel.add( loginLabel );
		loginPanel.add( loginUser );
		
		passwordUser = new TextBox();
		Label passwordLabel = new Label( "password: " );
		HorizontalPanel passwordPanel = new HorizontalPanel();
		loginPanel.add( passwordLabel );
		loginPanel.add( passwordUser );
		submitCreateUserButton = new Button( "submit new user" );
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add( namePanel );
		dialogVPanel.add( firstNamePanel );
		dialogVPanel.add( birthDatePanel );
		dialogVPanel.add( loginPanel );
		dialogVPanel.add( passwordPanel );
		HorizontalPanel actionPanel = new HorizontalPanel();
		actionPanel.add( submitCreateUserButton );
		actionPanel.add( closeButton );
		dialogVPanel.add( actionPanel );
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogBox.setWidget(dialogVPanel);
		addCloseHandler( dialogBox, closeButton );
		return dialogBox;
	}
	
	/**
	 * design publish position dialog box
	 * @return
	 */
	private DialogBox BuildDialogPublishPosition(){
		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		xPosition = new DoubleBox();
		Label xPositionLabel = new Label( "x position: " );
		HorizontalPanel xPositionPanel = new HorizontalPanel();
		xPositionPanel.add( xPositionLabel );
		xPositionPanel.add( xPosition );
		yPosition = new DoubleBox();
		Label yPositionLabel = new Label( "y position: " );
		HorizontalPanel yPositionPanel = new HorizontalPanel();
		yPositionPanel.add( yPositionLabel );
		yPositionPanel.add( yPosition );
		zPosition = new DoubleBox();
		Label zPositionLabel = new Label( "z position: " );
		HorizontalPanel zPositionPanel = new HorizontalPanel();
		zPositionPanel.add( zPositionLabel );
		zPositionPanel.add( zPosition );
		submitPublishPositionButton = new Button( "submit new position" );
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add( xPositionPanel );
		dialogVPanel.add( yPositionPanel );
		dialogVPanel.add( zPositionPanel );
		HorizontalPanel actionPanel = new HorizontalPanel();
		actionPanel.add( submitPublishPositionButton );
		actionPanel.add( closeButton );
		dialogVPanel.add( actionPanel );
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		addCloseHandler( dialogBox, closeButton );
		return dialogBox;
	}
	
	/**
	 * design a new contact dialog box
	 * @return
	 */
	private DialogBox BuildDialogNewContact(){
		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText( "Remote Procedure Call" );
		dialogBox.setAnimationEnabled( true );
		firstNameContact = new TextBox();
		Label firstNameContactLabel = new Label( "firstName: " );
		HorizontalPanel firstNameContactPanel = new HorizontalPanel();
		firstNameContactPanel.add( firstNameContactLabel );
		firstNameContactPanel.add( firstNameContact );
		
		nameContact = new TextBox();
		Label nameContactLabel = new Label( "name: " );
		HorizontalPanel nameContactPanel = new HorizontalPanel();
		nameContactPanel.add( nameContactLabel );
		nameContactPanel.add( nameContact );
		
		submitNewContactButton = new Button( "submit new contact" );
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add( firstNameContactPanel );
		dialogVPanel.add( nameContactPanel );
		HorizontalPanel actionPanel = new HorizontalPanel();
		actionPanel.add( submitNewContactButton );
		actionPanel.add( closeButton );
		dialogVPanel.add( actionPanel );
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogBox.setWidget(dialogVPanel);
		addCloseHandler( dialogBox, closeButton );
		return dialogBox;
	}
	
	/**
	 * add a click handler on button given in parameter to hide DialogBox given in parameter  
	 * @param toHide
	 * @param closeButton
	 */
	private void addCloseHandler(DialogBox toHide, Button closeButton){
		// Add a handler to close the DialogBox
		closeButton.addClickHandler( new HideHandler(toHide) );
	}
	
	/**
	 * hide handler on clic on close button on a dialogBox
	 * @author nicolas
	 *
	 */
	class HideHandler implements ClickHandler{
		
		HideHandler( DialogBox toHide ){
			this.toHide = toHide;
		}
		
		public void onClick(ClickEvent event) {
			toHide.hide();
		}
		
		private DialogBox toHide;
		
	}

	/**
	 * load each contact of the current connected user and display it
	 */
	void loadContact(){
		test.getContact(uid, new AsyncCallback<List< ResolvedContact >>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<ResolvedContact> results) {
				// TODO Auto-generated method stub
				//contactBox = new ListBox();
				if(!results.isEmpty()){
					contacts = new ResolvedContact[ results.size() ]; 
			    	for(int i = 0; i < results.size();i++){
			    		contacts[i] = results.get(i);
			    		
			    	}
			    	for(int i = 0; i < results.size();i++)
			    		contactBox.addItem(contacts[i].getContact().getName() + "-" +
			    					   contacts[i].getContact().getFirstName());
				}
				test.getUser(uid, new GetUserConnected());
			}
			
		});
	}
	
	/**
	 * display position load map api and ask to design and display map of current connected user
	 */
	void displayPosition(){
		Maps.loadMapsApi("", "2", false, new Runnable() {
		      public void run() {
		    	  //TODO update it with user real given position
		    	  getPosition( uid );
		      }
		    });
	}
	
	/**
	 * click handler on display position button
	 * @author nicolas
	 *
	 */
	class displayPositionHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			displayPosition();
		}
		
	}
	
	/**
	 * With latitude service design map
	 * @param id
	 * @return
	 */
	private Position getPosition( String id){

		GetPosition result = new GetPosition( new Position());
		test.getPosition( id, result );
		return result.getResult();
		
	}
	
	/**
	 * AsyncCallback create map and add all marker on it
	 * @author nicolas
	 *
	 */
	class GetPosition implements AsyncCallback< Position >{	
		
		public GetPosition(Position position){
			this.result = position;
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSuccess(Position result) {
			// TODO Auto-generated method stub
	    	LatLng my = LatLng.newInstance( result.getY(),result.getX() );
	    	//GetContactPosition contactToDisplay = null;
	    	
	    	MapWidget map = new MapWidget( my, 2 );
	    	map.setSize( "75%", "100%" );
	    	// Add some controls for the zoom level
	    	map.addControl( new LargeMapControl() );

	    	// Add a marker
	    	map.addOverlay( new Marker( my ) );
	    	if(contacts != null && contacts.length > 0){
	    		for( int i = 0; i < contacts.length; i++ ){
	    			GetVisibleContactRight contactIsVisible = new GetVisibleContactRight(map,i); 
	    			test.getVisibility(contacts[i].getContact().getId(), contactIsVisible);
	    			//if( contactIsVisible.getResult() ){
	    			//contactToDisplay = new GetContactPosition( map,i );
	    			//test.getPosition( contacts[i].getContact().getId(), contactToDisplay );
	    			//}
	    		}
	    	}
	    	map.getInfoWindow().open( map.getCenter(),
	    			  new InfoWindowContent( "Your position on the world" ) );

	    	DockLayoutPanel dock = new DockLayoutPanel( Unit.PX );
	    	dock.addNorth( map, 500 );

	    	// Add the map to the HTML host page
	    	RootPanel.get("positionMap").add( dock );
			this.result.setX( result.getX() );
			this.result.setY( result.getY() );
		}

		public Position getResult(){
			return this.result;
		}
				
		private Position result;
	}
	
	/**
	 * add on map ech referenced contact position
	 * @author nicolas
	 *
	 */
	class GetContactPosition implements AsyncCallback< Position >{

		public GetContactPosition( MapWidget map, int contactIndex ){
			this.currentMap = map;
			this.contactIndex = contactIndex;
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Position result) {
			// TODO Auto-generated method stub
			if(result != null){
				
				LatLng contactPosition = LatLng.newInstance( result.getY() ,result.getX() );
				MarkerOptions titleMark = MarkerOptions.newInstance();
				titleMark.setTitle(contactBox.getItemText(contactIndex));
				Marker contactMark = new Marker( contactPosition,titleMark);
				currentMap.addOverlay( contactMark );
				
			}
		}
		
		private MapWidget currentMap;
		private int contactIndex;
	}
	
	/**
	 * AsynCallback< Boolean > implementation for get visible right
	 * @author nicolas
	 *
	 */
	class GetVisibleRight implements AsyncCallback< Boolean >{
		public GetVisibleRight(){
			
		}

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Boolean result) {
			// TODO Auto-generated method stub
			visibleRight.setText( ( result )? "visible" : "hided" );
			updateVisibleRightButton.setText( ( result )? "Hide Me" : "Show Me" );
		}
	}
	
	/**
	 * AsynCallback< Boolean > implementation for get visible right contact
	 * @author nicolas
	 *
	 */
	//TODO update it boolean cannot work with callback
	class GetVisibleContactRight implements AsyncCallback< Boolean >{
		
		public GetVisibleContactRight(MapWidget map, int contactIndex){
			this.map = map;
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Boolean result) {
			// TODO Auto-generated method stub
			GetContactPosition contactToDisplay = null;
			contactToDisplay = new GetContactPosition( map, contactIndex );
			test.getPosition( contacts[ contactIndex ].getContact().getId(), contactToDisplay );
		}
		
		private int contactIndex;
		private MapWidget map;
	}
	
	/**
	 * AsynCallback< Boolean > implementation for get visible right
	 * @author nicolas
	 *
	 */
	class SetVisibleRight implements AsyncCallback< Boolean >{
		public SetVisibleRight(){
			
		}

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Boolean result) {
			// TODO Auto-generated method stub
			if( result.booleanValue() ){
				visibleRight.setText( ( visibleRight.getText().contains( "visible" ) )? "hide" : "visible" );
				updateVisibleRightButton.setText( ( updateVisibleRightButton.getText().contains("Show Me") )? "Hide Me" : "Show Me" );
			}
		}
	}
	
	/**
	 * update visibility of connected user from the other one
	 * @param visibility
	 */
	private void updateVisibleRight(boolean visibility){
		
		test.changeMyVisibility( uid, visibility, new SetVisibleRight() );
		
	}
	
	/**
	 * display visibility right of the current connected user
	 *  
	 */
	private void displayVisibleRight(){
		
		test.getVisibility( uid, new GetVisibleRight() );
		
	}
	
	/**
	 * checkLoginPasswordValidity AsyncCallback< Boolean > implementation
	 * @author nicolas
	 *
	 */
	class CheckLoginPasswordValidity implements AsyncCallback< Boolean >{

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(Boolean result) {
			// TODO Auto-generated method stub
			if(result){
				test.publishUser(nameUser.getText(), firstNameUser.getText(), birthDateUser.getText(), new AsyncCallback<String>(){
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						createUserDialog.setText( "Remote Procedure Call - Failure" );
					}

					@Override
					public void onSuccess(String result) {

						// TODO Auto-generated method stub
						if( !result.isEmpty() ){
							setUid(result);
							createUserDialog.setText( "User create set authentication... with uid:" + getUid() );
							test.publishAuthentication(result, loginUser.getText(), passwordUser.getText(), new AsyncCallback<Void>(){

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									createUserDialog.setText( "Remote Procedure Call - Failure" );
								}

								@Override
								public void onSuccess(Void result) {
									// TODO Auto-generated method stub
									createUserDialog.setText( "new user create!" );
									createUserDialog.hide();
									setUid( "" );
								}

							});
						} else {
							createUserDialog.setText( "User already existing!" );
						}

					}
				});
			}
		}
	}
	
	/**
	 * clear contact ihm
	 */
	private void removeContact(){
		contactBox.clear();
		contacts = null;
	}
	
	public String getUid() {
		return uid;
	}

	public void setUid( String uid ) {
		this.uid = uid;
	}
	
	
	private boolean connected = false;
	private String uid;
	
	//element used to login a user
	private Button submitLoginButton;
	private TextBox loginInput;
	private TextBox passwordInput;
	
	//element used to create a new user
	private Button submitCreateUserButton;
	private TextBox nameUser;
	private TextBox passwordUser;
	private TextBox loginUser;
	private TextBox birthDateUser;
	private TextBox firstNameUser;
	
	//element used to publish a position
	private Button submitPublishPositionButton;
	private DoubleBox xPosition;
	private DoubleBox yPosition;
	private DoubleBox zPosition;
	
	//element used to add a contact
	private Button submitNewContactButton;
	private TextBox nameContact;
	private TextBox firstNameContact;
	
	//user allowed action
	private Button loginButton;
	private Button createUserButton;
	private Button disconnectButton;
	private Button publishPositionButton;
	private Button displayPositionButton;
	private Button addContactButton;
	
	//DialogBox of application
	private DialogBox loginDialog;
	private DialogBox createUserDialog;
	private DialogBox publishPositionDialog;
	private DialogBox newContactDialog;
	
	//parameter for contact list when user is connected
	private ListBox contactBox;
    private ResolvedContact [] contacts;
	
	//parameter of logged user
    private TextBox loggedUser;
	private TextBox visibleRight;
	private Button updateVisibleRightButton;
	
}

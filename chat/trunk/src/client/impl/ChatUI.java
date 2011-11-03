package client.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import client.ICommande;
import client.IChatUI;
import client.IChatUser;


public class ChatUI implements IChatUI {

	public ChatUI(ICommande post, ICommande unregister) {
		this.postMessage = post;
		( ( CommandPost ) this.postMessage ).setUi(this);
		this.unregister = unregister;
		
	}
	
	public void initIHM(){
		JPanel panel = (JPanel) this.window.getContentPane();
		JScrollPane sclPane = new JScrollPane( txtOutput );
		panel.add( sclPane, BorderLayout.CENTER );
		JPanel southPanel = new JPanel( new BorderLayout() );
		southPanel.add( this.txtMessage, BorderLayout.CENTER );
		southPanel.add( this.btnSend, BorderLayout.EAST );
		panel.add( southPanel, BorderLayout.SOUTH );

		// Gestion des événements
		window.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ) {
				window_windowClosing( e );
			}
		} );
		
		btnSend.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				btnSend_actionPerformed( e );
			}
		});
		
		txtMessage.addKeyListener(new KeyAdapter() {
			public void keyReleased( KeyEvent event) {
				if ( event.getKeyChar() == '\n' )
					btnSend_actionPerformed(null);
			}
		});

		// Initialisation des attributs
		this.txtOutput.setBackground(new Color(220, 220, 220));
		this.txtOutput.setEditable(false);
		this.window.setSize(500, 400);
		this.window.setVisible(true);
		this.txtMessage.requestFocus();
	}
	
	/* (non-Javadoc)
	 * @see client.impl.IChatUI#window_windowClosing(java.awt.event.WindowEvent)
	 */
	@Override
	public void window_windowClosing(WindowEvent e) {
		try {
			unregister.execute();
		} catch (Exception exc) {
			System.err.println("Desinscription impossible");
		}
		 System.exit(-1);
	}

	/* (non-Javadoc)
	 * @see client.impl.IChatUI#btnSend_actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void btnSend_actionPerformed(ActionEvent e) {
		try {
			message = this.txtMessage.getText();
			postMessage.execute();
		} catch (Exception exception) {
			System.err.println("Envoie message impossible");
		}
		this.txtMessage.setText("");
		this.txtMessage.requestFocus();
	}
	
    /* (non-Javadoc)
	 * @see client.impl.IChatUI#displayMessage(java.lang.String)
	 */
    @Override
	public void displayMessage(String message){
        this.txtOutput.append(message + "\n");
        this.txtOutput.moveCaretPosition(this.txtOutput.getText().length());
    }

    /* (non-Javadoc)
	 * @see client.impl.IChatUI#requestPseudo()
	 */
    @Override
	public String requestPseudo() {
         String pseudo = JOptionPane.showInputDialog(
                this.window, "Entrez votre pseudo : ",
                this.title,  JOptionPane.OK_OPTION
        );
        if (pseudo == null) System.exit(0);
        return pseudo;
    }

	/* (non-Javadoc)
	 * @see client.impl.IChatUI#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}

	public ICommande getUnregister() {
		return unregister;
	}

	public void setUnregister(ICommande unregister) {
		this.unregister = unregister;
	}
	
	public ICommande getPostMessage() {
		return postMessage;
	}

	public void setPostMessage(ICommande postMessage) {
		this.postMessage = postMessage;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public JFrame getWindow() {
		return window;
	}

	public void setWindow(JFrame window) {
		this.window = window;
	}

	public JTextArea getTxtOutput() {
		return txtOutput;
	}

	public void setTxtOutput(JTextArea txtOutput) {
		this.txtOutput = txtOutput;
	}
	
	public JTextField getTxtMessage() {
		return txtMessage;
	}

	public void setTxtMessage(JTextField txtMessage) {
		this.txtMessage = txtMessage;
	}
	
	public JButton getBtnSend() {
		return btnSend;
	}

	public void setBtnSend(JButton btnSend) {
		this.btnSend = btnSend;
	}
	
	protected String message = null;
	
	private ICommande  unregister;
	
	private ICommande  postMessage;
	
	private String title;

	private JFrame window;

	private JTextArea txtOutput;

	private JTextField txtMessage;

	private JButton btnSend;
    
}

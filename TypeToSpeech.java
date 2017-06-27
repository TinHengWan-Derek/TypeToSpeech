import java.awt.event.*;
import javax.swing.*;

import com.sun.speech.freetts.VoiceManager;

public class TypeToSpeech extends JFrame implements KeyListener,ActionListener
{
    JTextArea typingArea;
    CharList cl = new CharList();
    static final String newline = System.getProperty("line.separator");
    
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //Schedule a job for event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
    		TypeToSpeech frame = new TypeToSpeech("Type To Speech Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,500);
        //Set up the content pane.
        frame.addComponentsToPane();
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    private void addComponentsToPane() {
    		typingArea = new JTextArea(10,50);
        typingArea.addKeyListener(this);      
        getContentPane().add(typingArea);
    }
    
    public TypeToSpeech(String name) {
        super(name);
    }
    
    
    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
    }
    
    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
    		speakWhenSpacePressedANDdelCharFromListWhenBackSpacePressed(e);
    }
    
    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e) {
    }
    
    /** Handle the button click. */
    public void actionPerformed(ActionEvent e) {
        //Clear the text components.
        typingArea.setText("");
        //Return the focus to the typing area.
        typingArea.requestFocusInWindow();
    }
    private void speakWhenSpacePressedANDdelCharFromListWhenBackSpacePressed(KeyEvent e){
    		switch(e.getKeyCode()){
    			case 8://Back Space
    				cl.delACharFromCharList();
    			break;
    			case 10:
    				com.sun.speech.freetts.Voice myVoice;
    				myVoice = VoiceManager.getInstance().getVoice("kevin16");
    				myVoice.allocate();
    				myVoice.speak(typingArea.getText());
    				myVoice.deallocate();
    			break;
    			case 32://Space
    				cl.toVoiceAndResetList();
    			break;
    			default :
    				if(!e.isActionKey()){
    					cl.addCharToCharList(e.getKeyChar());
    				}
    			break;
    		}
    }
}


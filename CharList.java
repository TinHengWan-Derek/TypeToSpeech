import java.util.ArrayList;
import com.sun.speech.freetts.*;

public class CharList {
	private ArrayList<Character> charList;
	private com.sun.speech.freetts.Voice systemVoice;
	
	public CharList(){
		charList = new ArrayList<Character>();
		systemVoice = VoiceManager.getInstance().getVoice("kevin16");
		systemVoice.allocate();
	}
	public void addCharToCharList(char c){
		charList.add(c);
	}
	public void delACharFromCharList(){
		if(charList.size() > 0){
			charList.remove(charList.get(charList.size()-1));
		}
	}
	public void toVoice(){
		systemVoice.speak(this.toString());
	}
	public void resetList(){
		charList.clear();
	}
	public void toVoiceAndResetList(){
		toVoice();
		resetList();
	}
	public String toString(){
		String s = "";
		for(int i=0;i<charList.size();i++){
			s += charList.get(i).toString();
		}
		return s;
	}
}

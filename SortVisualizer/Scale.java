import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Scale {
	private Integer[] notesToPlay;
	private MidiChannel instru;
	public Scale(Integer[] notes) throws MidiUnavailableException{
		Synthesizer synth = MidiSystem.getSynthesizer();    
		synth.open();
		this.notesToPlay = notes;
		this.instru = synth.getChannels()[0];
	}
	
	public int getSize(){
		return notesToPlay.length;
	}
	
	public void playNote(int index, boolean isEmphasized){
		if(isEmphasized){
			instru.noteOn(notesToPlay[index % getSize()], 120);
		}
		else{
			instru.noteOn(notesToPlay[index % getSize()], 60);
		}
	}
}
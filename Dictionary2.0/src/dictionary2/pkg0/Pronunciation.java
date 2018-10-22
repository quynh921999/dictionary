/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary2.pkg0;

import com.sun.speech.freetts.VoiceManager;

/**
 *
 * @author quynh
 */
public class Pronunciation {
    private final String name;
    private final com.sun.speech.freetts.Voice voice;
    public Pronunciation(String name){
        this.name = name;
        this.voice = VoiceManager.getInstance().getVoice(this.name);
        this.voice.allocate();
    }
    public void say(String word){
        this.voice.speak(word);
    }    
}

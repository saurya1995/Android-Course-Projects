package com.kaushal.texttospeech;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TextToSpeechActivity extends Activity {
	Button speak,speedin,speeddec;
	EditText text;
	TextToSpeech tts;
	String data;
	float speed;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        speed=(float) 1.0;
        speak=(Button)findViewById(R.id.bspeak);
        text=(EditText)findViewById(R.id.ettext);
        speedin=(Button)findViewById(R.id.bspeedplus);
        speeddec=(Button)findViewById(R.id.bspeedminus);
        tts= new TextToSpeech(this,new TextToSpeech.OnInitListener() {
			
			public void onInit(int status) {
				// TODO Auto-generated method stub
				if(!(status==TextToSpeech.ERROR)){
					tts.setLanguage(Locale.ENGLISH);
				}
			}
		});
        speak.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				data=text.getText().toString();
				tts.speak(data, TextToSpeech.QUEUE_FLUSH, null);
			}
		});
        speedin.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				speed+=0.1;
				tts.setSpeechRate(speed);
			}
		});
        speeddec.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				speed-=0.1;
				tts.setSpeechRate(speed);
			}
		});
    }
}
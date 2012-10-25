package org.mythtv.client.ui.frontends;

import org.mythtv.R;
import org.mythtv.client.ui.frontends.AbstractFrontendFragment.SendActionTask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;;

public class NumbersFragment extends AbstractFrontendFragment implements OnClickListener  {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		//inflate fragment layout
		View view = inflater.inflate(R.layout.fragment_mythmote_numbers, container, false);
		
		//set onclick listener for each button
		((Button)view.findViewById(R.id.numbers_button0)).setOnClickListener(this);
		((Button)view.findViewById(R.id.numbers_button1)).setOnClickListener(this);
		((Button)view.findViewById(R.id.numbers_button2)).setOnClickListener(this);
		((Button)view.findViewById(R.id.numbers_button3)).setOnClickListener(this);
		((Button)view.findViewById(R.id.numbers_button4)).setOnClickListener(this);
		((Button)view.findViewById(R.id.numbers_button5)).setOnClickListener(this);
		((Button)view.findViewById(R.id.numbers_button6)).setOnClickListener(this);
		((Button)view.findViewById(R.id.numbers_button7)).setOnClickListener(this);
		((Button)view.findViewById(R.id.numbers_button8)).setOnClickListener(this);
		((Button)view.findViewById(R.id.numbers_button9)).setOnClickListener(this);
		((Button)view.findViewById(R.id.numbers_button_backspace)).setOnClickListener(this);
		((Button)view.findViewById(R.id.numbers_button_enter)).setOnClickListener(this);
		
		return view;
	}

	@Override
	public void onClick(View v) {
		
		final FrontendsFragment frontends = (FrontendsFragment) getFragmentManager().findFragmentById( R.id.frontends_fragment );
		final Frontend fe = frontends.getSelectedFrontend();
		
		//exit if we don't have a frontend
		if(null == fe) return;
		
		switch(v.getId()){
		case R.id.numbers_button0:
			new SendActionTask().execute(fe.getUrl(), "0");
			break;
			
		case R.id.numbers_button1:
			new SendActionTask().execute(fe.getUrl(), "1");
			break;
			
		case R.id.numbers_button2:
			new SendActionTask().execute(fe.getUrl(), "2");
			break;
			
		case R.id.numbers_button3:
			new SendActionTask().execute(fe.getUrl(), "3");
			break;
			
		case R.id.numbers_button4:
			new SendActionTask().execute(fe.getUrl(), "4");
			break;
			
		case R.id.numbers_button5:
			new SendActionTask().execute(fe.getUrl(), "5");
			break;
			
		case R.id.numbers_button6:
			new SendActionTask().execute(fe.getUrl(), "6");
			break;
			
		case R.id.numbers_button7:
			new SendActionTask().execute(fe.getUrl(), "7");
			break;
			
		case R.id.numbers_button8:
			new SendActionTask().execute(fe.getUrl(), "8");
			break;
			
		case R.id.numbers_button9:
			new SendActionTask().execute(fe.getUrl(), "9");
			break;
			
		case R.id.numbers_button_backspace:
			new SendActionTask().execute(fe.getUrl(), "BACKSPACE");
			break;
			
		case R.id.numbers_button_enter:
			new SendActionTask().execute(fe.getUrl(), "SELECT");
			break;
		};
		
	}
	
	
	
	
	
}
package com.tarks.favorite;

import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import com.actionbarsherlock.app.SherlockFragment;
import com.tarks.favorite.cardsui.MyPlayCard;
import com.tarks.favorite.cardsui.like_card;
import com.tarks.favorite.cardsui.views.CardUI;
import com.tarks.favorite.test.phone_number;
import com.tarks.widget.listviewutil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class mainfragment extends SherlockFragment implements
		OnItemLongClickListener {

	private ListView maListViewPerso;
	private ScrollView sv;
	// 카드 유아이 정의한다.
		CardUI mCardView;
	
	View rootView;

	// On déclare la HashMap qui contiendra les informations pour un item
	HashMap<String, String> map;
	
	//Like me or favorite
	 String like_me_result;
	 String favorite_result;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	rootView = inflater.inflate(R.layout.mainfragment, container, false);
		
		//Set Favorite
		setfavorite();
		//Import ListView
		 
		// 카드 인터페이스를 불러온다.
				// init CardView
				mCardView = (CardUI) rootView.findViewById(R.id.cardsview);
			//	mCardView.setSwipeable(true);
				
			
				like_card header = (new like_card(favorite_result, like_me_result , false));
				
				mCardView.addCard(header);
			
				MyPlayCard notice_banner = (new MyPlayCard(
						getString(R.string.notice), "하하 저를 눌러보고 싶지 않아요?d", "#33b6ea", "#33b6ea",
						false, true));
				
				mCardView.addCard(notice_banner);
				
				
				MyPlayCard qw1 = new MyPlayCard(
						"누구를 좋아하나요?", "좋아하는사람을 추가해보세요.d", "#FFBB00", "#FFBB00",
						false, true);
				
			mCardView.addCard(qw1);
				
				
				// draw cards
				mCardView.refresh();
				
				
		return rootView;
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void setfavorite(){
		// 자신의 신분 설정값을 불러옵니다.
				SharedPreferences prefs = getActivity().getSharedPreferences("setting", getActivity().MODE_PRIVATE);
				int like_me = Integer.parseInt(prefs.getString("like_me", "0"));
				int favorite = Integer.parseInt(prefs.getString("favorite", "0"));
				

				//Import textview
				TextView favorite_text = (TextView) rootView.findViewById(R.id.textView3);
				TextView like_me_text = (TextView) rootView.findViewById(R.id.textView4);
				
				
				//number cut
				NumberFormat nf = NumberFormat.getInstance();
				//  nf.setMaximumIntegerDigits(5); //최대수 지정
				 like_me_result = nf.format(like_me);
				 favorite_result = nf.format(favorite);
				 
					if(like_me > 9999) like_me_result = "9999+";
					if(favorite > 9999)  favorite_result = "9999+";
					
				
	
			
				
	}
	
	
}
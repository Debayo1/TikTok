package com.tik.tok.clone;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {
	
	private HashMap<String, Object> mapvar = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> videos = new ArrayList<>();
	
	private LinearLayout linear1;
	
	private RequestNetwork rn;
	private RequestNetwork.RequestListener _rn_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		rn = new RequestNetwork(this);
		
		_rn_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		
		View inflate = getLayoutInflater().inflate(R.layout.tiktok_main, null);
		linear1.addView(inflate);
		final androidx.recyclerview.widget.RecyclerView list = inflate.findViewById(R.id.recyclerview);
		final androidx.recyclerview.widget.LinearLayoutManager layoutManager = new androidx.recyclerview.widget.LinearLayoutManager(MainActivity.this,androidx.recyclerview.widget.LinearLayoutManager.VERTICAL, false);
		
		androidx.recyclerview.widget.SnapHelper snapHelper = new androidx.recyclerview.widget.PagerSnapHelper();
		 list.setLayoutManager(layoutManager);
		 snapHelper.attachToRecyclerView(list);
		list.setHasFixedSize(true);
		_addData();
		final VideoAdapter adapter = new VideoAdapter(this,videos,initGlide());
		list.setAdapter(adapter);
	}
	
	public void _addData() {
		mapvar = new HashMap<>();
		mapvar.put("username", " @Nyana Stoica");
		mapvar.put("description", "Due to an intense mind fog, all of my thoughts have been grounded until further notice.");
		mapvar.put("usericon", "https://images.unsplash.com/photo-1583452208101-7c1cc44c4132?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1100&q=60");
		mapvar.put("videoPath", "https://docjamal.xyz/wp-content/uploads/2020/08/video1.mp4");
		videos.add(mapvar);
		mapvar = new HashMap<>();
		mapvar.put("username", " @Benjamin");
		mapvar.put("description", "When life gives you a hundred reasons to cry, then show life that you have a thousand reasons to smile.");
		mapvar.put("usericon", "https://images.unsplash.com/photo-1487222477894-8943e31ef7b2?ixlib=rb-1.2.1&auto=format&fit=crop&w=1100&q=60");
		mapvar.put("videoPath", "https://docjamal.xyz/wp-content/uploads/2020/08/video2.mp4");
		videos.add(mapvar);
		mapvar = new HashMap<>();
		mapvar.put("username", " @Charlotte");
		mapvar.put("description", "You never cross the ocean unless you have the courage to lose sight of the shore.");
		mapvar.put("usericon", "https://images.unsplash.com/photo-1485893086445-ed75865251e0?ixlib=rb-1.2.1&auto=format&fit=crop&w=1100&q=60");
		mapvar.put("videoPath", "https://docjamal.xyz/wp-content/uploads/2020/08/video3.mp4");
		videos.add(mapvar);
		mapvar = new HashMap<>();
		mapvar.put("username", " @Alexander");
		mapvar.put("description", "Don’t be afraid of death. Be afraid of non-lived life. You don’t have to live forever, you just have to live.");
		mapvar.put("usericon", "https://images.unsplash.com/photo-1531427186611-ecfd6d936c79?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1100&q=60");
		mapvar.put("videoPath", "https://docjamal.xyz/wp-content/uploads/2020/08/video4.mp4");
		videos.add(mapvar);
		mapvar = new HashMap<>();
		mapvar.put("username", " @Lyanna");
		mapvar.put("description", "Stop letting people who do so little for you control so much of your emotions.");
		mapvar.put("usericon", "https://images.unsplash.com/photo-1520155707862-5b32817388d6?ixlib=rb-1.2.1&auto=format&fit=crop&w=1100&q=60");
		mapvar.put("videoPath", "https://docjamal.xyz/wp-content/uploads/2020/08/video5.mp4");
		videos.add(mapvar);
		mapvar = new HashMap<>();
		mapvar.put("username", " @Elizabeth");
		mapvar.put("description", "My bio is stolen. Please help me to find it.");
		mapvar.put("usericon", "https://images.unsplash.com/photo-1532074205216-d0e1f4b87368?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1100&q=60");
		mapvar.put("videoPath", "https://docjamal.xyz/wp-content/uploads/2020/08/video6.mp4");
		videos.add(mapvar);
		mapvar = new HashMap<>();
		mapvar.put("username", " @Michael");
		mapvar.put("description", "You can’t process me with a normal brain bcoz I am too mad.");
		mapvar.put("usericon", "https://images.unsplash.com/photo-1521572267360-ee0c2909d518?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1100&q=60");
		mapvar.put("videoPath", "https://docjamal.xyz/wp-content/uploads/2020/08/video7.mp4");
		videos.add(mapvar);
		mapvar = new HashMap<>();
		mapvar.put("username", " @Jackson");
		mapvar.put("description", "I try to look cute all day.");
		mapvar.put("usericon", "https://images.unsplash.com/photo-1536164261511-3a17e671d380?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1100&q=60");
		mapvar.put("videoPath", "https://docjamal.xyz/wp-content/uploads/2020/08/video10.mp4");
		videos.add(mapvar);
		mapvar = new HashMap<>();
		mapvar.put("username", " @Jack");
		mapvar.put("description", "If you have been hurt many times and you are still smiling, you are very strong!");
		mapvar.put("usericon", "https://images.unsplash.com/photo-1517070208541-6ddc4d3efbcb?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1234&q=80");
		mapvar.put("videoPath", "https://docjamal.xyz/wp-content/uploads/2020/08/Cubehouse.mp4");
		videos.add(mapvar);
	}
	
	
	public void _library() {
	}
	com.tik.tok.clone.CircleImageView image;
	private com.bumptech.glide.RequestManager initGlide(){
		return Glide.with(getApplicationContext());
	}
	{
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}
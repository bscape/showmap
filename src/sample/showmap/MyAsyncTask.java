package sample.showmap;

import java.io.InputStream;//yosjida
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.AsyncTask;
import android.util.Log;

public class MyAsyncTask extends AsyncTask<String, Integer, String> {

	GoogleMap map = null;
	LatLng[] selectedArea = new LatLng[4];
	
	//�ｿｽR�ｿｽ�ｿｽ�ｿｽX�ｿｽg�ｿｽ�ｿｽ�ｿｽN�ｿｽ^�ｿｽﾅ�ｿｽ�ｿｽC�ｿｽ�ｿｽ�ｿｽX�ｿｽ�ｿｽ�ｿｽb�ｿｽh�ｿｽ�ｿｽmap�ｿｽ�ｿｽ�ｿｽｯ趣ｿｽ�ｿｽ
	public MyAsyncTask(GoogleMap tmp, LatLng[] tmp2){
		map = tmp;
		selectedArea = tmp2;
	}
	

	
	@Override
	protected String doInBackground(String... params) {
		
		HttpURLConnection http = null;
        InputStream in = null;

//---------------------------------------------------------------------------------------------
        //�ｿｽN�ｿｽG�ｿｽ�ｿｽ�ｿｽﾉ托ｿｽ�ｿｽ�ｿｽﾊ置�ｿｽ�ｿｽ�ｿｽW�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾟるた�ｿｽﾟ、�ｿｽl�ｿｽp�ｿｽ`�ｿｽﾌ最擾ｿｽ�ｿｽ�ｿｽﾜ円�ｿｽﾌ抵ｿｽ�ｿｽS�ｿｽ�ｿｽ�ｿｽW�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾟゑｿｽi�ｿｽI�ｿｽ�ｿｽ�ｿｽG�ｿｽ�ｿｽ�ｿｽA�ｿｽﾌ抵ｿｽ�ｿｽS�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾉ、�ｿｽ�ｿｽ�ｿｽaxx�ｿｽL�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾌ店�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽA�ｿｽﾆゑｿｽ�ｿｽ�ｿｽ�ｿｽ`�ｿｽﾅ鯉ｿｽ�ｿｽﾊゑｿｽ�ｿｽi�ｿｽ�ｿｽj
        //�ｿｽC�ｿｽﾓゑｿｽ3�ｿｽ�ｿｽ�ｿｽ_�ｿｽﾌ外�ｿｽﾚ円�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾟ、�ｿｽc�ｿｽ�ｿｽ1�ｿｽ_�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾉゑｿｽ�ｿｽ�ｿｽ�ｿｽOK�ｿｽB�ｿｽﾈゑｿｽ�ｿｽ�ｿｽﾎ別ゑｿｽ3�ｿｽ_�ｿｽﾌ組�ｿｽﾝ搾ｿｽ�ｿｽ墲ｹ�ｿｽﾅ趣ｿｽ�ｿｽ�ｿｽ
        //�ｿｽQ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾊの想�ｿｽ�ｿｽﾅ計�ｿｽZ�ｿｽ�ｿｽ�ｿｽﾄゑｿｽ�ｿｽ驍ｽ�ｿｽﾟ、�ｿｽl�ｿｽp�ｿｽ`�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽt�ｿｽﾏ更�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾜゑｿｽ�ｿｽ�ｿｽ�ｿｽﾅゑｿｽ�ｿｽ�ｿｽ鼾�ｿｽﾍ撰ｿｽ�ｿｽm�ｿｽﾈ鯉ｿｽ�ｿｽﾊゑｿｽ�ｿｽo�ｿｽ�ｿｽ�ｿｽﾈゑｿｽ
        
        double tmp[] = new double[8];
        int a,b,c;
        
        for (int i=0 ; i <=3 ; i++){

        	//�ｿｽC�ｿｽﾓゑｿｽ3�ｿｽ�ｿｽ�ｿｽ_�ｿｽ�ｿｽI�ｿｽﾔゑｿｽ�ｿｽﾟ、selectedArea�ｿｽﾌ添�ｿｽ�ｿｽ�ｿｽﾉゑｿｽ�ｿｽ�ｿｽ�ｿｽﾄゑｿｽ�ｿｽ闢ｾ�ｿｽ�ｿｽS�ｿｽﾄの組�ｿｽﾝ搾ｿｽ�ｿｽ墲ｹ(012,123,230,301)�ｿｽｾゑｿｽ
        	//�ｿｽg�ｿｽﾝ搾ｿｽ�ｿｽ墲ｹ�ｿｽ�ｿｽ�ｿｽ�ｿｽO�ｿｽ�ｿｽ�ｿｽl�ｿｽ�ｿｽi�ｿｽﾆゑｿｽ�ｿｽ驍ｱ�ｿｽﾆゑｿｽ(012,123,230,301)�ｿｽﾌパ�ｿｽ^�ｿｽ[�ｿｽ�ｿｽ�ｿｽｾゑｿｽ
        	a = 0;
        	if (a == i) { a++; }
		    if (a > 3) { a = 0; } 
		    b = a+1;
		    if (b == i) { b++; }
		    if (b > 3) { b = 0; }
		    c = b+1;
		    if (c == i) { c++; }
		    if (c > 3) { c = 0; }
		    
		    //�ｿｽO�ｿｽS�ｿｽ�ｿｽ�ｿｽv�ｿｽZ�ｿｽB�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾍ厄ｿｽ�ｿｽ�ｿｽ�ｿｽﾘ・�ｿｽE�ｿｽE
	        tmp[0] = 2 * (selectedArea[b].longitude - selectedArea[a].longitude);
	        tmp[1] = 2 * (selectedArea[b].latitude - selectedArea[a].latitude);
	        tmp[2] = Math.pow(selectedArea[a].longitude,2) - Math.pow(selectedArea[b].longitude,2) + Math.pow(selectedArea[a].latitude,2) - Math.pow(selectedArea[b].latitude,2);
	        tmp[3] = 2 * (selectedArea[c].longitude - selectedArea[a].longitude);
	        tmp[4] = 2 * (selectedArea[c].latitude - selectedArea[a].latitude);
	        tmp[5] = Math.pow(selectedArea[a].longitude,2) - Math.pow(selectedArea[c].longitude,2) + Math.pow(selectedArea[a].latitude,2) - Math.pow(selectedArea[c].latitude,2);
	        //�ｿｽO�ｿｽS�ｿｽ�ｿｽx�ｿｽ�ｿｽ�ｿｽW�ｿｽ�ｿｽlongitude
	        tmp[6] = ((tmp[1] * tmp[5]) - (tmp[4] * tmp[2])) / ((tmp[0] * tmp[4]) - (tmp[3] * tmp[1]));
	        //�ｿｽO�ｿｽS�ｿｽ�ｿｽy�ｿｽ�ｿｽ�ｿｽW�ｿｽ�ｿｽlatitude
	        tmp[7] = ((tmp[2] * tmp[3]) - (tmp[5] * tmp[0])) / ((tmp[0] * tmp[4]) - (tmp[3] * tmp[1]));
	        
	        //�ｿｽO�ｿｽS�ｿｽﾌ費ｿｽ�ｿｽa
	        double dx = Math.pow(tmp[6] - selectedArea[a].longitude,2);
	        double dy = Math.pow(tmp[7] - selectedArea[a].latitude,2);
	        double distance = Math.sqrt(dx + dy);
	        
	        //�ｿｽO�ｿｽS�ｿｽﾆ残�ｿｽ�ｿｽP�ｿｽ_�ｿｽﾌ具ｿｽ�ｿｽ�ｿｽ
	        double dx2 = Math.pow(tmp[6] - selectedArea[i].longitude,2);
	        double dy2 = Math.pow(tmp[7] - selectedArea[i].latitude,2);
	        double distance2 = Math.sqrt(dx2 + dy2);
	        
	        //�ｿｽO�ｿｽS�ｿｽﾆ残�ｿｽ�ｿｽP�ｿｽ_�ｿｽﾌ具ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽa�ｿｽﾈ難ｿｽ�ｿｽﾅゑｿｽ�ｿｽ�ｿｽﾎ最擾ｿｽ�ｿｽ�ｿｽﾜ円�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾄゑｿｽ�ｿｽ�ｿｽ
	        //�ｿｽ_�ｿｽ�ｿｽ�ｿｽﾈゑｿｽﾊの１�ｿｽ_�ｿｽ�ｿｽ�ｿｽO�ｿｽ�ｿｽ�ｿｽﾄゑｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽx�ｿｽv�ｿｽZ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
	        if (distance2 <= distance) {
	        	break;
	        }
        }

        Log.d("�ｿｽﾅ終�ｿｽﾅ　�ｿｽO�ｿｽS�ｿｽ�ｿｽx�ｿｽ�ｿｽ�ｿｽW",""+tmp[6]);
        Log.d("�ｿｽﾅ終�ｿｽﾅ　�ｿｽO�ｿｽS�ｿｽ�ｿｽy�ｿｽ�ｿｽ�ｿｽW",""+tmp[7]);

//---------------------------------------------------------------------------------------------

        String queryUrl = "http://api.gnavi.co.jp/ver1/RestSearchAPI/";
        String apiKey = "2ef4333acaf2e5ea9388911e3c6acdb2";
        String qPage = "50";
        String keyword = null;;
        String qLat = String.valueOf(tmp[7]);
        String qLng = String.valueOf(tmp[6]);
        String range = "5"; //�ｿｽ�ｿｽ�ｿｽa3km
        
        //�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽL�ｿｽ[�ｿｽ�ｿｽ�ｿｽ[�ｿｽh�ｿｽ�ｿｽUTF-8�ｿｽ�ｿｽURL�ｿｽG�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽf�ｿｽB�ｿｽ�ｿｽ�ｿｽO�ｿｽ�ｿｽ�ｿｽ�ｿｽ
        try {
        	keyword = URLEncoder.encode(params[0], "utf-8");
        }catch (UnsupportedEncodingException e){
        	//do nothing
        }
        // �ｿｽ�ｿｽ�ｿｽ�ｿｽﾈゑｿｽAPI�ｿｽﾖの鯉ｿｽ�ｿｽ�ｿｽ�ｿｽN�ｿｽG�ｿｽ�ｿｽ�ｿｽﾆなゑｿｽURL�ｿｽ�ｿｽ�ｿｽ�成
    	queryUrl += "?keyid="+apiKey+"&hit_per_page="+qPage+"&coordinates_mode=2"+"&freeword=" + keyword + "&range=" + range + "&latitude=" + qLat + "&longitude=" + qLng;
    	
//---------------------------------------------------------------------------------------------
		try {
			//URL�ｿｽ�ｿｽHTTP�ｿｽﾚ托ｿｽ
			URL url = new URL(queryUrl);
			http = (HttpURLConnection)url.openConnection();
			http.setRequestMethod("GET");
			http.connect();
			// InputStream�ｿｽ^�ｿｽﾏ撰ｿｽin�ｿｽﾉデ�ｿｽ[�ｿｽ^�ｿｽ�ｿｽ�ｿｽ_�ｿｽE�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽh
			in = http.getInputStream();
			
			// �ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾊゑｿｽxml�ｿｽ�ｿｽ�ｿｽ�ｿｽK�ｿｽv�ｿｽﾈパ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ^�ｿｽ�ｿｽﾘゑｿｽo�ｿｽ�ｿｽ
			ApiData apiData = new ApiData(in);
			String src = apiData.parse();
			Log.d("XmlPullParser", "parsed");

			//�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽxml�ｿｽe�ｿｽL�ｿｽX�ｿｽg�ｿｽ�ｿｽonPostExcecute�ｿｽﾉ茨ｿｽ�ｿｽ�ｿｽ�ｿｽn�ｿｽ�ｿｽ
			return src;
			
		} catch(Exception e) {
			return e.toString();
	    } finally {
	    	try {
	    		if(http != null)
	    			http.disconnect();
	    		if(in != null) 
	    			in.close();
	    	}catch (Exception e) {}
	    }
	}
	
//	@Override
	protected void onPostExecute(String src){

		//�ｿｽ}�ｿｽ[�ｿｽJ�ｿｽ[�ｿｽﾌオ�ｿｽv�ｿｽV�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽp�ｿｽC�ｿｽ�ｿｽ�ｿｽX�ｿｽ^�ｿｽ�ｿｽ�ｿｽX
		MarkerOptions options = new MarkerOptions();	
		Marker marker;
		
		//1�ｿｽX�ｿｽ�ｿｽ1�ｿｽs�ｿｽﾌ形�ｿｽﾅ切ゑｿｽo�ｿｽ�ｿｽ�ｿｽﾄ配�ｿｽ�ｿｽﾉ格�ｿｽ[
		String[] strAry = src.split("\n");
		
		// 0�ｿｽs�ｿｽﾚゑｿｽnull�ｿｽﾈので、�ｿｽX�ｿｽL�ｿｽb�ｿｽv�ｿｽ�ｿｽ�ｿｽ�ｿｽ1�ｿｽs�ｿｽﾚゑｿｽ�ｿｽ�ｿｽn�ｿｽﾟゑｿｽ
		for (int i = 1 ; i < strAry.length ; i++) {

			//1�ｿｽX�ｿｽﾜの各�ｿｽp�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ^�ｿｽ�ｿｽﾘゑｿｽo�ｿｽ�ｿｽ�ｿｽﾄ配�ｿｽ�ｿｽﾉ格�ｿｽ[
			String[] strAry2 = strAry[i].split(",");
			for (int j = 0 ; j < strAry2.length ; j++) {
			}

			//�ｿｽ�ｿｽ�ｿｽW�ｿｽﾌ値�ｿｽ�ｿｽString�ｿｽ�ｿｽ�ｿｽ�ｿｽDouble�ｿｽﾉ型�ｿｽﾏ奇ｿｽ
			double lat = Double.parseDouble(strAry2[1]);//lat
			double lng = Double.parseDouble(strAry2[0]);//lng
			
	    	// �ｿｽ\�ｿｽ�ｿｽ�ｿｽﾊ置�ｿｽi�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ黷ｽ�ｿｽ�ｿｽ�ｿｽW�ｿｽj�ｿｽｶ撰ｿｽ
			// �ｿｽﾉ端�ｿｽﾉ搾ｿｽ�ｿｽW�ｿｽ�ｿｽ�ｿｽﾟゑｿｽ�ｿｽ鼾�ｿｽﾍ後か�ｿｽ逅ｶ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ黷ｽ�ｿｽs�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾌピ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ繽托ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ轤ｵ�ｿｽ�ｿｽ�ｿｽB�ｿｽu�ｿｽ謔ｩ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽv�ｿｽﾅ鯉ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾆわか�ｿｽ�ｿｽB
	    	LatLng posMapPoint = new LatLng(lat,lng);
	    	
	    	//�ｿｽI�ｿｽ�ｿｽﾍ囲難ｿｽ�ｿｽ�ｿｽ�ｿｽﾇゑｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ閧ｷ�ｿｽ�ｿｽ
	    	//�ｿｽX�ｿｽﾌ搾ｿｽ�ｿｽW�ｿｽﾆ選�ｿｽ�ｿｽﾍ囲の各�ｿｽﾓのベ�ｿｽN�ｿｽg�ｿｽ�ｿｽ�ｿｽﾌ外�ｿｽﾏゑｿｽ4�ｿｽﾓとゑｿｽ�ｿｽ�ｿｽ�ｿｽﾅゑｿｽ�ｿｽ�ｿｽﾎ難ｿｽ�ｿｽ�ｿｽ�ｿｽﾉゑｿｽ�ｿｽ�ｿｽB
	    	
			// �ｿｽs�ｿｽ�ｿｽ�ｿｽﾆタ�ｿｽC�ｿｽg�ｿｽ�ｿｽ�ｿｽi�ｿｽX�ｿｽ�ｿｽ�ｿｽj�ｿｽﾌ設抵ｿｽ
			options.position(posMapPoint);
			options.title(strAry2[2]+i);
			// �ｿｽs�ｿｽ�ｿｽ�ｿｽﾌ追会ｿｽ
			marker = map.addMarker(options);
		}
	}
}
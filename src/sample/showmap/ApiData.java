package sample.showmap;

import java.io.InputStream;
import java.util.HashMap;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;
import android.util.Xml;


public class ApiData {//yoshida
	
	//fukushima


	private InputStream data;

	// �ｿｽR�ｿｽ�ｿｽ�ｿｽX�ｿｽg�ｿｽ�ｿｽ�ｿｽN�ｿｽ^�ｿｽ[�ｿｽﾅ変撰ｿｽsrc�ｿｽ�ｿｽxml�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽｯ趣ｿｽ�ｿｽ
	public ApiData(InputStream in) {
		data = in;
	}

//--------------------------------------------------------------------------------------------
//	�ｿｽﾘゑｿｽo�ｿｽ�ｿｽ�ｿｽp�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ^�ｿｽﾌタ�ｿｽO�ｿｽ�ｿｽ�ｿｽi�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽﾏ撰ｿｽ

//	ID
	private String idTag;
//	�ｿｽX�ｿｽ�ｿｽ
	private String nameTag;
//	�ｿｽﾜ度
	private String latTag;
//	�ｿｽo�ｿｽx
	private String lngTag;
//ID�ｿｽﾆタ�ｿｽO�ｿｽ�ｿｽ�ｿｽﾌ２�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽL�ｿｽ[�ｿｽﾉゑｿｽ�ｿｽz�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ驍ｽ�ｿｽﾟ、hashmap�ｿｽ�ｿｽ�ｿｽ�ｿｽhashmap�ｿｽ�ｿｽ�ｿｽi�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ
	private HashMap<String,String> param;
	private HashMap<String,HashMap<String,String>> rootParam;

//--------------------------------------------------------------------------------------------

	public String parse(){

		Log.d("XmlPullParserSample", "parse start");

		idTag = "id";
		nameTag = "name";
		latTag = "latitude";
		lngTag = "longitude";
		

		//------------------------------------------------------------------------------------
        //�ｿｽp�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ^�ｿｽ�ｿｽﾘゑｿｽo�ｿｽ�ｿｽ

		//XmlPullParser�ｿｽﾌイ�ｿｽ�ｿｽ�ｿｽX�ｿｽ^�ｿｽ�ｿｽ�ｿｽX�ｿｽｾゑｿｽ
		final XmlPullParser xmlPullParser = Xml.newPullParser();

		//2�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽz�ｿｽ�ｿｽB�ｿｽS�ｿｽﾄのデ�ｿｽ[�ｿｽ^�ｿｽ�ｿｽ�ｿｽi�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽhashmap
		rootParam = new HashMap<String,HashMap<String,String>>();

		try {
	    	//xml�ｿｽf�ｿｽ[�ｿｽ^�ｿｽ�ｿｽxmlPullParser�ｿｽﾉ茨ｿｽ�ｿｽ�ｿｽ�ｿｽn�ｿｽ�ｿｽ
	    	xmlPullParser.setInput(data,null);
		}catch (Exception e) {
				 Log.d("XmlPullParserSample", "setInputError");
			}

		//xml�ｿｽ^�ｿｽO�ｿｽﾌス�ｿｽe�ｿｽ[�ｿｽ^�ｿｽX�ｿｽiEND_DOCUMENT�ｿｽ�ｿｽ�ｿｽj�ｿｽ�ｿｽeventType�ｿｽﾉ格�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ
			int eventType = 0;
        try {
			eventType = xmlPullParser.getEventType();
		} catch (XmlPullParserException e) {
			 Log.d("XmlPullParserSample", "setInputError");
		}

        while (eventType != XmlPullParser.END_DOCUMENT) {

        	try {

        	if(eventType == XmlPullParser.START_TAG) {
	            if(xmlPullParser.getName().equals(idTag)) {
	            	//�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽO�ｿｽ�ｿｽkey�ｿｽ�ｿｽvalue�ｿｽ�ｿｽ�ｿｽ繽托ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ驍ｽ�ｿｽﾟ、key�ｿｽﾉゑｿｽid�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾅなゑｿｽid�ｿｽﾌ値�ｿｽ�ｿｽ�ｿｽﾇ会ｿｽ�ｿｽ�ｿｽ�ｿｽﾄゑｿｽ�ｿｽ�ｿｽ
	        		//1�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽz�ｿｽ�ｿｽB1�ｿｽX�ｿｽﾜのデ�ｿｽ[�ｿｽ^�ｿｽﾉつゑｿｽ�ｿｽ�ｿｽﾂゑｿｽhashmap�ｿｽC�ｿｽ�ｿｽ�ｿｽX�ｿｽ^�ｿｽ�ｿｽ�ｿｽX�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽA�ｿｽ�ｿｽ�ｿｽW�ｿｽ�ｿｽ�ｿｽﾌデ�ｿｽ[�ｿｽ^�ｿｽ�ｿｽ�ｿｽi�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ
	            	rootParam.put((new String(xmlPullParser.nextText())) + (new String(xmlPullParser.getName())),(param = new HashMap<String,String>()));
	            }else if (xmlPullParser.getName().equals(nameTag)) {
	            	param.put(new String(xmlPullParser.getName()),new String(xmlPullParser.nextText()));
	            } else if (xmlPullParser.getName().equals(latTag)) {
	            	param.put(new String(xmlPullParser.getName()),new String(xmlPullParser.nextText()));
	            } else if (xmlPullParser.getName().equals(lngTag)) {
	            	param.put(new String(xmlPullParser.getName()),new String(xmlPullParser.nextText()));
	            }
        	}
        }catch (Exception e) {
        	Log.d("xmlPullParser", "WhileError");
        }
            try {
				eventType = xmlPullParser.next();
			} catch (Exception e) {
				Log.d("xmlPullParser", "NextError");
			}
        }
		//------------------------------------------------------------------------------------
        //�ｿｽﾘゑｿｽo�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽp�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ^�ｿｽ�ｿｽString�ｿｽ^�ｿｽﾌ戻ゑｿｽl�ｿｽﾉ詰�ｿｽﾟ搾ｿｽ�ｿｽ�ｿｽ

        //�ｿｽI�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽW�ｿｽﾌ難ｿｽ�ｿｽ�ｿｽ�ｿｽﾅゑｿｽ�ｿｽ驍ｩ�ｿｽﾇゑｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ閧ｷ�ｿｽ�ｿｽ

        int cnt = 0;
        String result = null;

		for (String rootKey : rootParam.keySet()) {
			cnt++;
			Log.d("xmlPullParserResult", "test2="+rootKey+":cnt="+cnt);
			result += "\n";
			for (String paramKey : rootParam.get(rootKey).keySet()) {
				result += rootParam.get(rootKey).get(paramKey)+ ",";
				Log.d("searchresult",rootParam.get(rootKey).get(paramKey));
			}
		}
		rootParam = null; //�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ齒包ｿｽﾆゑｿｽ�ｿｽﾄゑｿｽ�ｿｽ�ｿｽE�ｿｽE�ｿｽE�ｿｽﾂゑｿｽ�ｿｽ�ｿｽ
		return result;
	}
}

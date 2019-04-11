package kr.ac.hanggies.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class FcmService {
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/sendFCM")
	public void sendPush(String msg/*, MobileTokenVO vo*/)
			throws Exception {

		/*List<MobileTokenVO> tokenList = fcmService.loadFCMInfoList(vo);
		
		String token = tokenList.get(count).getDEVICE_ID();*/
		//dF8Ci1rLJio:APA91bF0ql8zTZCkX89e9B7y1UGdx6tc20oBTGpXBuWdm5QFpzhlAatUCu4ebkdKEumx8t224FuvX7CgYiV0vPL8n5dRV6pk_w_GIqyJq-BDQcbCtXiSLSD9_PlhpxdF4YEJDWZ3dAI4
		final String apiKey = "AAAA6cea6CE:APA91bFCvgVAFniyuoz5p7vxvIVse5cuC1JiINnvhgxaycbP10wfDP6MHGMpew6L8mciwiEHduu8lkUr8N1vKOuAQrvNQI0jWTNr-ErLMRGWhkP2tyvNoMxxsDukImYePSwwqc6NYO0F";
		URL url = new URL("https://fcm.googleapis.com/fcm/send");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setUseCaches(false);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Authorization", "key=" + apiKey);
		conn.setDoOutput(true);

		//String userId = (String) request.getSession().getAttribute("ssUserId");

		// 이렇게 보내면 주제를 ALL로 지정해놓은 모든 사람들한테 알림을 날려준다.
		//String input = "{\"notification\" : {\"title\" : \"Smart Diaper\", \"body\" : \"" + msg + " \"}, \"to\":\"/topics/ALL\"}";

		JSONObject root = new JSONObject();
        JSONObject notification = new JSONObject();
        
        //FirebaseMessaging.getInstance().subscribeToTopic("all");
        notification.put("body", msg);
        notification.put("title", "Smart Diaper");
        root.put("notification", notification);
        root.put("to", "/topics/all");
        root.put("click_action", "OPEN_ACTIVITY"); // click_action 추가!
        String input = root.toString();
		
		// 이걸로 보내면 특정 토큰을 가지고있는 어플에만 알림을 날려준다 위에 둘중에 한개 골라서 날려주자
		//String input = "{\"notification\" : {\"title\" : \" 여기다 제목넣기 \", \"body\" : \"여기다 내용 넣기\"}, \"to\":\" 여기가 받을 사람 토큰  \"}";

		OutputStream os = conn.getOutputStream();

		// 서버에서 날려서 한글 깨지는 사람은 아래처럼 UTF-8로 인코딩해서 날려주자
		os.write(input.getBytes("UTF-8"));
		os.flush();
		os.close();

		int responseCode = conn.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + input);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
	}
}

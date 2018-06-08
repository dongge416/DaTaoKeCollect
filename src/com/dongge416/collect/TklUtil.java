package com.dongge416.collect;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.response.TbkTpwdCreateResponse;

public class TklUtil {

	/**
	 * 获取淘口令
	 * @param good
	 * @return
	 */
	public static String getTkl(String  url) {
		String result = "";
		try {
			
		
		TaobaoClient client = new DefaultTaobaoClient(Protocol.URL_serverUrl, Constant.KEY_TAOBAO_APP_KEY, Constant.SECRET_TAOBAO);
		TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
		req.setUserId("123");
		req.setText("省省吃货君");
		req.setUrl(url);
		req.setLogo("https://uland.taobao.com/");
		req.setExt("{}");
		TbkTpwdCreateResponse rsp = client.execute(req);
		System.out.println(""+rsp.getBody());
		}catch(Exception e){
			e.printStackTrace();
		}
		return result ;
	}
	
}

package com.dongge416.collect;

import okhttp3.OkHttpClient;

public class Main {
	
	public static void main(String[] args) {
//		System.out.println(Protocol.URL_WEBSITE);
//		System.out.println("---------------------");
//		String result = OKHttpUtil.httpGet(Protocol.URL_WEBSITE);
//		System.out.println(""+result);
		//http://api.dataoke.com/index.php?r=goodsLink/www&type=www_quan&appkey=9413b1fab6&v=2&page=2
		//http://api.dataoke.com/index.php?r=goodsLink/www&type=www_quan&appkey=9413b1fab6&v=2
		
		String _01Str = "https://s.click.taobao.com/asaFwPw";
		String _02Str = "https://s.click.taobao.com/wWWFwPw";
		String _03Str = "https://s.click.taobao.com/UTWFwPw";
		String _04Str = "https://s.click.taobao.com/hGaFwPw";
		String _05Str = "https://s.click.taobao.com/z0OFwPw";
		String _06Str = "https://s.click.taobao.com/mWTFwPw";
		String _07Str = "https://s.click.taobao.com/UzSFwPw";
		String _08Str = "https://s.click.taobao.com/QcLFwPw";
		String _09Str = "https://s.click.taobao.com/BaLFwPw";
		String _10Str = "https://s.click.taobao.com/N3NFwPw";
		String _11Str = "https://s.click.taobao.com/hUJFwPw";
		String[] _arrayStr = {_01Str,_02Str,_03Str,_04Str,_05Str,_06Str,_07Str,_08Str,_09Str,_10Str,_11Str};
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < _arrayStr.length; i++) {
					String result = TklUtil.getTkl(_arrayStr[i]);
					System.out.println("第"+(i+1)+"个");
					System.out.println(result);
				}
			}
		}).start();
		
		
	}

}

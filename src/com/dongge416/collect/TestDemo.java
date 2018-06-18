package com.dongge416.collect;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;



public class TestDemo {

	public static void main(String[] args) throws Exception {
		String rawPath = WeiXinApp.class.getResource("/").getPath();
		rawPath = rawPath.replace("bin/", "");
//		QrcodeUtil.createQrCode(new FileOutputStream(new File(rawPath+"Raw/qrcode.jpg")),"http://tm.tshtts.cn/custom/getletters.html?letters=YFPy0C5QKsO&address=&image=",900,"JPEG");
		
	
//		//定义二维码的样式  
//        int width = 150;  
//        int height = 150;  
//        String format = "jpeg";  
//        String contents = "http://tm.tshtts.cn/custom/getletters.html?letters=YFPy0C5QKsO&address=&image=";//扫描二维码时产生的连接  
//          
//        //定义二维码的参数  
//        HashMap hints = new HashMap();  
//        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");  
//        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);//设置二维码的容错等级  
//        hints.put(EncodeHintType.MARGIN, 0);//边距  
//          
//        try {  
//            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);  
//            Path file = new File(rawPath+"Raw/qrcode.jpg").toPath();//保存的路径  
//            MatrixToImageWriter.writeToPath(bitMatrix, format, file); 
//            System.out.println("success");
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        }  
		
		
//		OKHttpUtil.httpGetPic("https://www.baidu.com/img/dong_f5d87adc75aff5d3690392e526a20b6e.gif", rawPath+"Raw/temp.jpg");
		
		
	}
	
}

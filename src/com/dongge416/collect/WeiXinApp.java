package com.dongge416.collect;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultBoundedRangeModel;

public class WeiXinApp {

	public static void main(String[] args) throws Exception{
		
		String rawPath = WeiXinApp.class.getResource("/").getPath();
		rawPath = rawPath.replace("bin/", "");
		System.out.println(rawPath);
		InputStream imagein = new FileInputStream(rawPath+"/Raw/target.jpg");  
        InputStream imagein2 = new FileInputStream(rawPath+"/Raw/bg.jpg");
        InputStream imageInQrcode = new FileInputStream(rawPath+"/Raw/qrcode.jpg");
        BufferedImage image = ImageIO.read(imagein);  
        BufferedImage image2 = ImageIO.read(imagein2);  
        
//        BufferedImage imageQrcode = QrcodeUtil.creatQrBufferImage("http://tm.tshtts.cn/custom/getletters.html?letters=YFPy0C5QKsO&address=&image=","jpeg",150,rawPath+"Raw/qrcode.jpg");
        BufferedImage imageQrcode = ImageIO.read(imageInQrcode); 
        Graphics2D g = (Graphics2D)image2.getGraphics();  
        g.drawImage(image, 0, 0,  
        		image.getWidth() , image.getHeight() , null);  
        g.drawImage(imageQrcode, image2.getWidth()-175, image.getHeight()+20, 150, 150, null); 
        
        
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);  
//        g.setRenderingHint(hintKey, hintValue);
        //设置标题
        Font fontTitle = new Font("黑体",Font.PLAIN,20);
        g.setFont(fontTitle); 
        g.setColor(Color.BLACK);
        g.drawString("零钱包女手拿包韩版包包", 10, image.getHeight()+40);
        
//        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_DEFAULT);  
        //设置原价
        Font fontOrgPrice = new Font("黑体",Font.PLAIN,16);
        g.setFont(fontOrgPrice);
        g.setColor(Color.GRAY);
        g.drawString("原价", 10, image.getHeight()+70);
        g.drawString("29.9", 55, image.getHeight()+70);
        g.drawLine(50, image.getHeight()+65, 100, image.getHeight()+65);
        
        //设置券后价
        
        g.setFont(new Font("黑体",Font.PLAIN,16));
        g.drawString("券后", 10, image.getHeight()+95);
        g.setFont(new Font("黑体",Font.PLAIN,20));
        g.setColor(Color.RED);
        g.drawString("29.9", 55, image.getHeight()+95);
        Color tagColor = new Color(254, 102, 0);
        g.setColor(tagColor);
        RoundRectangle2D rect=new RoundRectangle2D.Double(130,image.getHeight()+72,80,25,0,0);//创建矩//形对象
        //我的
        g.draw(rect);
        g.fillRoundRect((int)rect.getX(), (int)rect.getY(), 80, 25,0,0);
        g.setColor(Color.WHITE);
        g.drawString("券 30元", 135, image.getHeight()+92);
        
        g.setColor(Color.RED);
        g.setFont(new Font("黑体", Font.PLAIN, 16));
        String introduceTxt = "【独立小包随走随带】精选优质枸杞，颗粒饱满，口感回甘，小包装的，吃着也方便，史上最流弊的活动，错过绝对不再有！【赠运费险】";
//        introduceTxt.ss
        List<String> listIntroduce = StringUtil.getStrList(introduceTxt, 17);
        int height = 130;
        for (int i = 0; i < listIntroduce.size(); i++) {
        		g.drawString(listIntroduce.get(i), 10, image.getHeight()+height);
        		height = height+20;
		}
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("黑体", Font.PLAIN, 16));
        g.drawString("长按识别二维码", image2.getWidth()-160, image2.getHeight()-20);
//        g.drawString("", 10, image.getHeight()+130);
        
        
        g.dispose();
        OutputStream outImage = new FileOutputStream(rawPath+"Raw/result.jpg");  
        ImageIO.write(image2, "jpeg", outImage);
//        JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(outImage);  
//        enc.encode(image);  
        imagein.close();  
        imagein2.close();  
        outImage.close(); 
        System.out.println("success");
	}
	
}

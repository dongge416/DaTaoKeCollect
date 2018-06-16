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
        BufferedImage image = ImageIO.read(imagein);  
        BufferedImage image2 = ImageIO.read(imagein2);  
        Graphics2D g = (Graphics2D)image2.getGraphics();  
        g.drawImage(image, 0, 0,  
        		image.getWidth() , image.getHeight() , null);  
//        g.setRenderingHint(hintKey, hintValue);
        Font fontTitle = new Font("黑体",Font.PLAIN,20);
        g.setFont(fontTitle); 
        g.setColor(Color.BLACK);
        g.drawString("零钱包女手拿包韩版包包", 10, image.getHeight()+60);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);  
//        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_DEFAULT);  
        Font fontPrice = new Font("黑体",Font.PLAIN,20);
        g.setFont(fontPrice);
        g.setColor(Color.GRAY);
        g.drawString("券后", 10, image.getHeight()+90);
        g.setColor(Color.RED);
        g.drawString("29.9", 55, image.getHeight()+90);
        
        g.setColor(Color.GRAY);
        g.drawString("原价39.9", 100, image.getHeight()+90);
//        Line2D line=new Line2D.Double(100,10,100,300);//创建line对象
        g.setColor(Color.GRAY);
        g.drawLine(100, image.getHeight()+85, 190, image.getHeight()+85);
        Color tagColor = new Color(254, 102, 0);
        g.setColor(tagColor);
        RoundRectangle2D rect=new RoundRectangle2D.Double(200,image.getHeight()+68,100,30,20,20);//创建矩//形对象
        //我的
        g.draw(rect);
        g.fillRoundRect((int)rect.getX(), (int)rect.getY(), 100, 30,20,20);
        g.setColor(Color.WHITE);
        g.drawString("券 30元", 215, image.getHeight()+90);
        
        g.setColor(Color.RED);
        g.setFont(new Font("黑体", Font.PLAIN, 16));
        String introduceTxt = "【独立小包随走随带】精选优质枸杞，颗粒饱满，口感回甘，小包装的，吃着也方便，史上最流弊的活动，错过绝对不再有！【赠运费险】";
//        introduceTxt.ss
        List<String> listIntroduce = StringUtil.getStrList(introduceTxt, 14);
        int height = 120;
        for (int i = 0; i < listIntroduce.size(); i++) {
        		g.drawString(listIntroduce.get(i), 10, image.getHeight()+height);
        		height = height+20;
		}
        
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

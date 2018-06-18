package com.dongge416.collect;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

public class PosterUtil {

	public static boolean creatPoster(GoodModel goodModel) {
		boolean result = false;
		String rawPath = WeiXinApp.class.getResource("/").getPath();
		rawPath = rawPath.replace("bin/", "");
		InputStream imageinTarget = null;
		InputStream imageinBg = null;
		OutputStream outImage = null;
//		InputStream imageInQrcode = null;
		String targetPicUrl = goodModel.getPic()+"_500x500.jpg";
		String taoWrod = goodModel.getTaoWord().replace("￥", "");
		String taoWordUrl = "http://tm.tshtts.cn/custom/getletters.html?letters="+taoWrod+"&address=&image=";
		try {
			 imageinTarget = OKHttpUtil.httpGetPicInputStream(targetPicUrl); 
	         imageinBg = new FileInputStream(rawPath+"/Raw/bg.jpg");
//	         imageInQrcode = new FileInputStream(rawPath+"/Raw/qrcode.jpg");
	         
	         
	         
	         BufferedImage imageTargetPic = ImageIO.read(imageinTarget);  
	         BufferedImage imageBg = ImageIO.read(imageinBg);  
	         BufferedImage imageQrcode = QrcodeUtil.creatQrBufferImage(taoWordUrl, "jpeg", 150);
	         Graphics2D g = (Graphics2D)imageBg.getGraphics();  
	         //合并主图
	         g.drawImage(imageTargetPic, 0, 0,  
	        		 imageTargetPic.getWidth() , imageTargetPic.getHeight() , null);  
	         //合并二维码
	         g.drawImage(imageQrcode, imageBg.getWidth()-175, imageTargetPic.getHeight()+20, 150, 150, null); 
	         //字体平滑
	         g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);  
	         //设置标题
	         Font fontTitle = new Font("黑体",Font.PLAIN,20);
	         g.setFont(fontTitle); 
	         g.setColor(Color.BLACK);
	         g.drawString(goodModel.getD_title(), 10, imageTargetPic.getHeight()+40);
	         
	         //设置原价
	         Font fontOrgPrice = new Font("黑体",Font.PLAIN,16);
	         g.setFont(fontOrgPrice);
	         g.setColor(Color.GRAY);
	         g.drawString("原价", 10, imageTargetPic.getHeight()+70);
	         g.drawString(goodModel.getOrg_Price(), 55, imageTargetPic.getHeight()+70);
	         g.drawLine(50, imageTargetPic.getHeight()+65, 100, imageTargetPic.getHeight()+65);
	         
	         //设置券后价
	         g.setFont(new Font("黑体",Font.PLAIN,16));
	         g.drawString("券后", 10, imageTargetPic.getHeight()+95);
	         g.setFont(new Font("黑体",Font.PLAIN,20));
	         g.setColor(Color.RED);
	         g.drawString(goodModel.getPrice(), 55, imageTargetPic.getHeight()+95);
	         Color tagColor = new Color(254, 102, 0);
	         g.setColor(tagColor);
	         RoundRectangle2D rect=new RoundRectangle2D.Double(130,imageTargetPic.getHeight()+72,80,25,0,0);//创建矩//形对象
	         //我的
	         g.draw(rect);
	         g.fillRoundRect((int)rect.getX(), (int)rect.getY(), 80, 25,0,0);
	         g.setColor(Color.WHITE);
	         String quan = goodModel.getQuan_price().replace(".00", "");
	         g.drawString("券 "+quan+"元", 135, imageTargetPic.getHeight()+92);
	         
	         g.setColor(Color.RED);
	         g.setFont(new Font("黑体", Font.PLAIN, 16));
	         String introduceTxt = goodModel.getIntroduce();
//	         introduceTxt.ss
	         List<String> listIntroduce = StringUtil.getStrList(introduceTxt, 17);
	         int height = 130;
	         for (int i = 0; i < listIntroduce.size(); i++) {
	         		g.drawString(listIntroduce.get(i), 10, imageTargetPic.getHeight()+height);
	         		height = height+20;
	 		}
	         g.setColor(Color.BLACK);
	         g.setFont(new Font("黑体", Font.PLAIN, 16));
	         g.drawString("长按识别二维码", imageBg.getWidth()-160, imageBg.getHeight()-20);
	         
	         g.dispose();
	         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	         String datetime = sdf.format(new Date());
	         String fileName = datetime+"_"+goodModel.getGoodsID()+".jpg";
	         
	          outImage = new FileOutputStream(Constant.PIC_PATH+""+fileName);  
	         ImageIO.write(imageBg, "jpeg", outImage);
	         result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(imageinTarget!=null) {
				try {
					imageinTarget.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(imageinBg!=null) {
				try {
					imageinBg.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(outImage!=null) {
				try {
					outImage.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
		
	}
	
}

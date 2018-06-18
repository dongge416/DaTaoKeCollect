package com.dongge416.collect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Main {
	
//	static  JTextArea txtArea;
	static StringBuffer sb = new StringBuffer();
	public static List<GoodModel> goodsList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		boolean creatDir = FileUtil.creatDir();
		LogUtil.writeLog("打开软件");
		
		 // 1. 创建一个顶层容器（窗口）
        JFrame jf = new JFrame("测试窗口");          // 创建窗口
        jf.setSize(600, 600);         // 设置窗口大小
        jf.setLayout(null);
        jf.setLocationRelativeTo(null);             // 把窗口位置设置到屏幕中心
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 当点击窗口的关闭按钮时退出程序（没有这一句，程序不会退出）
        // 2. 创建中间容器（面板容器）
//        JPanel panel = new JPanel();                // 创建面板容器，使用默认的布局管理器
//        panel.setBounds(0, 0, 600, 600);
        JButton btnStart = new JButton("开始");
        btnStart.setBounds(0, 0, 150, 40);
        
        JLabel hongbaoLabel01 = new JLabel("红包口令01:");
        hongbaoLabel01.setBounds(10, 45, 80, 40);
        JTextField hongbao01TxtField = new JTextField();
        hongbao01TxtField.setBounds(92, 45, 100, 40);
        
        JLabel hongbaoLabel02 = new JLabel("红包口令02:");
        hongbaoLabel02.setBounds(10, 100, 80, 40);
        JTextField hongbao02TxtField = new JTextField();
        hongbao02TxtField.setBounds(92, 100, 100, 40);
        
        ButtonGroup btnGroup = new ButtonGroup();
        JRadioButton jrb1  = new JRadioButton("天又蓝cc");
        jrb1.setBounds(10, 150, 150, 40);
        JRadioButton jrb2  = new JRadioButton("zhaoliuping1967");
        jrb2.setBounds(170, 150, 150, 40);
        JRadioButton jrb3  = new JRadioButton("chenzhuxi5255");
        jrb3.setBounds(330, 150, 150, 40);

        btnGroup.add(jrb1);
        btnGroup.add(jrb2);
        btnGroup.add(jrb3);
       
        jf.add(btnStart);
        jf.add(hongbaoLabel01);
        jf.add(hongbao01TxtField);
        jf.add(hongbaoLabel02);
        jf.add(hongbao02TxtField);
        jf.add(jrb1);
        jf.add(jrb2);
        jf.add(jrb3);
        
        jf.setVisible(true);
        
        ItemListener itemListener = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == jrb1) {
					LogUtil.writeLog("");
				}else if(e.getSource() == jrb2) {
					
				}else if(e.getSource() == jrb3) {
					
				}
			}
		};
		
		jrb1.addItemListener(itemListener);
		jrb2.addItemListener(itemListener);
		jrb3.addItemListener(itemListener);
        
        btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						String result = OKHttpUtil.httpGet(Protocol.URL_WEBSITE);
//						System.out.println(result);
						JSONObject jsonObject = JSONObject.parseObject(result);
						String resultData = jsonObject.getString("data");
						JSONObject jsonObjectArray = JSONObject.parseObject(resultData);
						JSONArray jsonArrayGoodModels = jsonObjectArray.getJSONArray("result");
						goodsList.clear();
						for (int i = 0; i < jsonArrayGoodModels.size(); i++) {
							
							if(goodsList.size()>30) {
								break;
							}
							GoodModel goodModel = new GoodModel();
							
							JSONObject tempObjGoodModel = (JSONObject) jsonArrayGoodModels.get(i);
					        String goodsID = tempObjGoodModel.getString("GoodsID");
					        goodModel.setGoodsID(goodsID);
					        String title = tempObjGoodModel.getString("Title");
					        goodModel.setTitle(title);
					        String d_title = tempObjGoodModel.getString("D_title");
					        goodModel.setD_title(d_title);
					        String pic = tempObjGoodModel.getString("Pic");
					        if(!pic.contains("https://img.alicdn.com")) {
					        	continue;
					        }
					        goodModel.setPic(pic);
					        String cid = tempObjGoodModel.getString("Cid");
					        goodModel.setCid(cid);
					        String org_Price = tempObjGoodModel.getString("Org_Price");
					        goodModel.setOrg_Price(org_Price);
					        String price = tempObjGoodModel.getString("Price");
					        goodModel.setPrice(price);
					        String isTmall = tempObjGoodModel.getString("IsTmall");
					        goodModel.setIsTmall(isTmall);
					        String sales_num = tempObjGoodModel.getString("Sales_num");
					        goodModel.setSales_num(sales_num);
					        String dsr = tempObjGoodModel.getString("Dsr");	  
					        goodModel.setDsr(dsr);
					        String sellerID = tempObjGoodModel.getString("SellerID");
					        goodModel.setSellerID(sellerID);
					        String commission_jihua = tempObjGoodModel.getString("Commission_jihua");
					        goodModel.setCommission_jihua(commission_jihua);
					        String commission_queqiao = tempObjGoodModel.getString("Commission_queqiao");
					        goodModel.setCommission_queqiao(commission_queqiao);
					        String jihua_link = tempObjGoodModel.getString("Jihua_link");
					        goodModel.setJihua_link(jihua_link);
					        String introduce = tempObjGoodModel.getString("Introduce");
					        goodModel.setIntroduce(introduce);
					        String quan_id = tempObjGoodModel.getString("Quan_id");
					        goodModel.setQuan_id(quan_id);
					        String quan_price = tempObjGoodModel.getString("Quan_price");
					        goodModel.setQuan_price(quan_price);
					        String quan_time = tempObjGoodModel.getString("Quan_time");
					        goodModel.setQuan_time(quan_time);
					        String quan_surplus = tempObjGoodModel.getString("Quan_surplus");
					        goodModel.setQuan_surplus(quan_surplus);
					        String quan_receive = tempObjGoodModel.getString("Quan_receive");
					        goodModel.setQuan_receive(quan_receive);
					        String quan_condition = tempObjGoodModel.getString("Quan_condition");
					        goodModel.setQuan_condition(quan_condition);
					        String quan_link = tempObjGoodModel.getString("Quan_link");
					        goodModel.setQuan_link(quan_link);
					        String quan_m_link = tempObjGoodModel.getString("Quan_m_link");
					        goodModel.setQuan_m_link(quan_m_link);
					        String yongjin_type = tempObjGoodModel.getString("Yongjin_type");
					        goodModel.setYongjin_type(yongjin_type);
					        String ali_click = tempObjGoodModel.getString("ali_click");
					        goodModel.setAli_click(ali_click);
					        //转换淘口令
					        if(ali_click.contains("s.click")) {
					        	String tempTaoWork = TklUtil.getTkl(ali_click);
					        	goodModel.setTaoWord(tempTaoWork);
					        	goodsList.add(goodModel);
					        }
//					        System.out.println("宝贝标题:"+goodModel.getTitle()+",cid:"+goodModel.getCid());
					       
						}
						
						for (int i = 0; i < goodsList.size(); i++) {
							boolean flag = PosterUtil.creatPoster(goodsList.get(i));
							System.out.println((i+1)+":"+flag);
						}
						
						
//						int productSize = goodsList.size();
//						int index = productSize % 2; 
//						if(index!=0) {
//							goodsList.remove(productSize-1);						
//							productSize = goodsList.size();
//						}
//						int resultIndex = productSize / 2;
//						
//						List<String> list = new ArrayList<>();
//						for (int i = 0; i < productSize; i++) {
//							String productDiv = HtmlUtil.creatDiv(goodsList.get(i));
//							list.add(productDiv);
//						}
//						System.out.println("goodsList长度:"+goodsList.size());
//						System.out.println("list长度:"+list.size());
//						System.out.println("==="+(resultIndex-1));
//						list.add((resultIndex),"</div><div class=\"main-right\">\n");
//						
//						list.add(0,"<div class=\"main-left\">\n");
//						list.add((list.size()),"</div>\n");
//						for (int i = 0; i < list.size(); i++) {
//							System.out.println("----------"+i+"-------------");
//							System.out.println(list.get(i));
//						}
//						
//						StringBuffer sbContent = new StringBuffer();
//						
//						for (int i = 0; i < list.size(); i++) {
//							sbContent.append(list.get(i));
//						}
//						
//						
//						HtmlUtil.creatHtml("C:\\Users\\Administrator\\Desktop\\淘客数据采集工具\\tempHtml.html", HtmlUtil.header+sbContent.toString()+HtmlUtil.footer);
						
						JOptionPane.showMessageDialog(
		                        jf,
		                        "采集成功,详情查看日志",
		                        "消息标题",
		                        JOptionPane.WARNING_MESSAGE
		                );
						
					}
				}).start();
				
			}
		});
        
        
    
		
		
	}
	
	/**
	 * 
	 * @param _cid 
	 * @return
	 */
	public static List<GoodModel> sortGoodsByPid(String _cid){
		List<GoodModel> resultList = new ArrayList<>();
		List<GoodModel> tempList = new ArrayList<>();
		tempList.addAll(goodsList);
		Iterator<GoodModel> it = tempList.iterator();
		while (it.hasNext()) {
			GoodModel tempGood = it.next();
			if (tempGood.getCid().equals(_cid)) {
				resultList.add(tempGood);
				goodsList.remove(tempGood);
				System.out.println("goodList size:"+goodsList.size());
			}
			
		}
		
		
//		for (int i = 0; i < goodsList.size(); i++) {
//			String cid = goodsList.get(i).getCid();
//			if(cid.equals(_cid)) {
//				GoodModel tempGood = goodsList.get(i);
//				resultList.add(tempGood);
//				goodsList.remove(i);
//			}
//		}
		
		return resultList;
	}
	
}

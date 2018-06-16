package com.dongge416.collect;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class HtmlUtil {

	public static String header = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"    <meta charset=\"UTF-8\">\r\n" + 
			"	\r\n" + 
			"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
			"    \r\n" + 
			"	<link rel=\"stylesheet\" href=\"https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
			"	<script src=\"https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js\"></script>\r\n" + 
			"	<script src=\"https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
			"    <title>宽度自适应两列布局</title>\r\n" + 
			"<style>\r\n" + 
			"*{margin:0;padding:0;}\r\n" + 
			"\r\n" + 
			".main-left{\r\n" + 
			"    width:50%;\r\n" + 
			"    height:auto;\r\n" + 
			"    background:white;\r\n" + 
			"    float:left;\r\n" + 
			"}\r\n" + 
			".main-right{\r\n" + 
			"    width:50%;\r\n" + 
			"    height:auto;\r\n" + 
			"    background:white;\r\n" + 
			"    float:right;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".lingquan_style{\r\n" + 
			"	color:white;\r\n" + 
			"	background-color:rgb(254,125,140);\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".product_title_style{\r\n" + 
			"	overflow: hidden;\r\n" + 
			"	text-overflow:ellipsis;\r\n" + 
			"	white-space: nowrap;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".price_style{\r\n" + 
			"	color:rgb(254,125,140);\r\n" + 
			"	font-size:16px;\r\n" + 
			"	font-weight:bold;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".price_text_style{\r\n" + 
			"	color:gray;\r\n" + 
			"	font-size:12px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".success_title_style{\r\n" + 
			"	width:100%;\r\n" + 
			"	font-size:20px;\r\n" + 
			"	margin-bottom: 10px;\r\n" + 
			"}\r\n" + 
			".success_content_style{\r\n" + 
			"	width:100%;\r\n" + 
			"	margin-top: 10px;\r\n" + 
			"	margin-bottom: 10px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".yuohui_title{\r\n" + 
			"	width:100%;\r\n" + 
			"	font-size:20px;\r\n" + 
			"	margin-top: 20px;\r\n" + 
			"	margin-bottom: 20px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".kouling_style{\r\n" + 
			"	width:100%;\r\n" + 
			"	font-size:18px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".copy_error_tips{\r\n" + 
			"	width:100%;\r\n" + 
			"	color:red;\r\n" + 
			"	align:center;\r\n" + 
			"	margin-top: 20px;\r\n" + 
			"	margin-bottom: 20px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".use_instruction_style{\r\n" + 
			"	width:100%;\r\n" + 
			"	color:rgb(191,191,191);;\r\n" + 
			"	background-color:rgb(239,239,239);\r\n" + 
			"	align:center;\r\n" + 
			"	padding-top:20px;\r\n" + 
			"	padding-bottom:20px;\r\n" + 
			"	padding-left:40px;\r\n" + 
			"	padding-right:40px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"fieldset{padding:.35em .625em .75em;margin:0 2px;border:1px solid silver}\r\n" + 
			"\r\n" + 
			"legend{font-size:12px;background:green;color:white;align:center;padding:.5em;border:0;width:auto}\r\n" + 
			"\r\n" + 
			"p.topmargin {margin-top: 5cm}\r\n" + 
			"\r\n" + 
			"</style>\r\n" + 
			"</head>\r\n" + 
			"<body>";
	public static String footer = "<script type=\"text/javascript\" src=\"js/clipboard.min.js\"></script>\r\n" + 
			"<script>\r\n" + 
			"\r\n" + 
			"//捕捉点击DIV 的属性\r\n" + 
			"$('.thumbnail').click(function(e){  \r\n" + 
			"	var value = $(this).attr('id');\r\n" + 
			"	\r\n" + 
			"	$(this).attr('data-clipboard-text',\"￥\"+value+\"￥\");\r\n" + 
			"	//alert(\"点击\"+value);\r\n" + 
			"    \r\n" + 
			"    var clipboard = new Clipboard('.thumbnail');\r\n" + 
			"\r\n" + 
			"    clipboard.on('success', function(e) {\r\n" + 
			"        \r\n" + 
			"		\r\n" + 
			"		\r\n" + 
			"		\r\n" + 
			"		\r\n" + 
			"		$('#successModal1').modal('show');\r\n" + 
			"		//setTimeout(function(){$(\"#successModal1\").modal(\"hide\")},3000);\r\n" + 
			"		\r\n" + 
			"    });\r\n" + 
			"\r\n" + 
			"    clipboard.on('error', function(e) {\r\n" + 
			"		//alert(\"复制失败\");\r\n" + 
			"		document.getElementById(\"dialog_content\").innerHTML = \"￥\"+value+\"￥\";\r\n" + 
			"		var word = document.querySelector('#dialog_content');\r\n" + 
			"		\r\n" + 
			"		document.addEventListener(\"selectionchange\",\r\n" + 
			"		function(e) {\r\n" + 
			"			window.getSelection().selectAllChildren(word);\r\n" + 
			"		},\r\n" + 
			"		false);\r\n" + 
			"		$('#failModal1').modal('show');\r\n" + 
			"         //document.getElementById(\"input_p\").innerHTML = \"复制失败\";\r\n" + 
			"    });\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"});\r\n" + 
			"\r\n" + 
			"		\r\n" + 
			"        \r\n" + 
			"		\r\n" + 
			"</script>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"		<!-- 模态框（Modal） -->\r\n" + 
			"        <div class=\"modal fade\" id=\"successModal1\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n" + 
			"            <div class=\"modal-dialog\">\r\n" + 
			"                <div class=\"modal-content\">\r\n" + 
			"					\r\n" + 
			"                    <div class=\"modal-header\" >\r\n" + 
			"　　　　　　　　　　    \r\n" + 
			"						<P class=\"success_title_style\" align=\"center\" >复制成功</p>\r\n" + 
			"						\r\n" + 
			"                    </div>\r\n" + 
			"					\r\n" + 
			"                    <div class=\"modal-body\"  style=\"background-color:rgb(239,239,239)\">\r\n" + 
			"					\r\n" + 
			"						<div >\r\n" + 
			"							\r\n" + 
			"                        	<p class=\"success_content_style\" align=\"center\" id=\"success_dialog_content\">优惠券匋口令已经复制，打开【手机匋宝】，直接领券付款即可！</p>\r\n" + 
			"							\r\n" + 
			"						</div>	\r\n" + 
			"					    \r\n" + 
			"						\r\n" + 
			"						\r\n" + 
			"                    </div>\r\n" + 
			"					\r\n" + 
			"                </div>\r\n" + 
			"                <!-- /.modal-content -->\r\n" + 
			"            </div>\r\n" + 
			"            <!-- /.modal -->\r\n" + 
			"        </div>\r\n" + 
			"		\r\n" + 
			"\r\n" + 
			"        <!-- 模态框（Modal） -->\r\n" + 
			"        <div class=\"modal fade\" id=\"failModal1\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n" + 
			"            <div class=\"modal-dialog\">\r\n" + 
			"                <div class=\"modal-content\">\r\n" + 
			"					<!--\r\n" + 
			"                    <div class=\"modal-header\" >\r\n" + 
			"　　　　　　　　　　　　　\r\n" + 
			"\r\n" + 
			"                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">\r\n" + 
			"                    &times;\r\n" + 
			"                </button>\r\n" + 
			"				\r\n" + 
			"                        \r\n" + 
			"						<h4 class=\"modal-title\" id=\"myModalLabel\">模态框（Modal）标题</h4>\r\n" + 
			"						\r\n" + 
			"                    </div>\r\n" + 
			"					-->\r\n" + 
			"                    <div class=\"modal-body\" >\r\n" + 
			"						\r\n" + 
			"						<div>\r\n" + 
			"							<P class=\"yuohui_title\" align=\"center\" >优惠券口令</p>\r\n" + 
			"						\r\n" + 
			"						</div>\r\n" + 
			"					\r\n" + 
			"						<div>\r\n" + 
			"							<fieldset>\r\n" + 
			"								 <legend align=\"center\">长按框内->复制</legend>\r\n" + 
			"                        		<p class=\"kouling_style\" align=\"center\" id=\"dialog_content\">000iii</p>\r\n" + 
			"							</fieldset>\r\n" + 
			"						</div>	\r\n" + 
			"					    \r\n" + 
			"						\r\n" + 
			"						<P class=\"copy_error_tips\" align=\"center\" id=\"copy_error_02\">请长按框内口令手动复制</p>\r\n" + 
			"						<P class=\"use_instruction_style\"  id=\"use_instruction\">使用说明:复制口.令后，打开匋堡直接领卷付款即可!</p>\r\n" + 
			"                    </div>\r\n" + 
			"					<!--\r\n" + 
			"                    <div class=\"modal-footer\">\r\n" + 
			"                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">知道了</button>\r\n" + 
			"                     \r\n" + 
			"                    </div>\r\n" + 
			"					-->\r\n" + 
			"                </div>\r\n" + 
			"                <!-- /.modal-content -->\r\n" + 
			"            </div>\r\n" + 
			"            <!-- /.modal -->\r\n" + 
			"        </div>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"</body>\r\n" + 
			"</html>";
	
	
	public static String creatDiv(GoodModel goodModel) {
		String result = "";
		String taoWord = goodModel.getTaoWord().replaceAll("￥", "");
		String d_title = goodModel.getD_title();
		String pic = goodModel.getPic();
		String price = goodModel.getPrice();
		String org_price = goodModel.getOrg_Price();
		String quan = goodModel.getQuan_price();
		
		String start_div_thumbnail = "<div class=\"thumbnail\" id=\""+taoWord+"\"  data-clipboard-text=\"\" >\n";
		String div_img = "<img src=\""+pic+"\" alt=\"图片加载失败\">\n ";
		String p_quan = "<p class=\"lingquan_style\" align=\"center\">领券省"+quan+"元</p>\n";
		String p_title = "<p class=\"product_title_style\">"+d_title+"</p>\n";
		String detail_div = "<div>\n<p class=\"price_text_style\">券后价<span class=\"price_style\">￥"+price+"</span><span style=\"text-decoration:line-through;\"> ￥"+org_price+"</span></p>\n</div>\n";
		
		String end_div_thumbnail = " </div>";
		
		result = start_div_thumbnail + div_img +p_quan+p_title+detail_div+end_div_thumbnail;
		return result;
	}
	
	public static boolean creatHtml(String outputFilePath,String content) {
		boolean flag = false;
		try {
			// 写出
			FileOutputStream out = new FileOutputStream(outputFilePath);
			OutputStreamWriter outWriter = new OutputStreamWriter(out, "utf-8");
			BufferedWriter bufWrite = new BufferedWriter(outWriter);
			
			bufWrite.write(content);
			bufWrite.close();
			outWriter.close();
			out.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static String test = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"    <meta charset=\"UTF-8\">\r\n" + 
			"	\r\n" + 
			"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
			"    \r\n" + 
			"	<link rel=\"stylesheet\" href=\"https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
			"	<script src=\"https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js\"></script>\r\n" + 
			"	<script src=\"https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
			"    <title>宽度自适应两列布局</title>\r\n" + 
			"<style>\r\n" + 
			"*{margin:0;padding:0;}\r\n" + 
			"\r\n" + 
			".main-left{\r\n" + 
			"    width:50%;\r\n" + 
			"    height:auto;\r\n" + 
			"    background:white;\r\n" + 
			"    float:left;\r\n" + 
			"}\r\n" + 
			".main-right{\r\n" + 
			"    width:50%;\r\n" + 
			"    height:auto;\r\n" + 
			"    background:white;\r\n" + 
			"    float:right;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".lingquan_style{\r\n" + 
			"	color:white;\r\n" + 
			"	background-color:rgb(254,125,140);\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".product_title_style{\r\n" + 
			"	overflow: hidden;\r\n" + 
			"	text-overflow:ellipsis;\r\n" + 
			"	white-space: nowrap;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".price_style{\r\n" + 
			"	color:rgb(254,125,140);\r\n" + 
			"	font-size:16px;\r\n" + 
			"	font-weight:bold;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".price_text_style{\r\n" + 
			"	color:gray;\r\n" + 
			"	font-size:12px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".success_title_style{\r\n" + 
			"	width:100%;\r\n" + 
			"	font-size:20px;\r\n" + 
			"	margin-bottom: 10px;\r\n" + 
			"}\r\n" + 
			".success_content_style{\r\n" + 
			"	width:100%;\r\n" + 
			"	margin-top: 10px;\r\n" + 
			"	margin-bottom: 10px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".yuohui_title{\r\n" + 
			"	width:100%;\r\n" + 
			"	font-size:20px;\r\n" + 
			"	margin-top: 20px;\r\n" + 
			"	margin-bottom: 20px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".kouling_style{\r\n" + 
			"	width:100%;\r\n" + 
			"	font-size:18px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".copy_error_tips{\r\n" + 
			"	width:100%;\r\n" + 
			"	color:red;\r\n" + 
			"	align:center;\r\n" + 
			"	margin-top: 20px;\r\n" + 
			"	margin-bottom: 20px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".use_instruction_style{\r\n" + 
			"	width:100%;\r\n" + 
			"	color:rgb(191,191,191);;\r\n" + 
			"	background-color:rgb(239,239,239);\r\n" + 
			"	align:center;\r\n" + 
			"	padding-top:20px;\r\n" + 
			"	padding-bottom:20px;\r\n" + 
			"	padding-left:40px;\r\n" + 
			"	padding-right:40px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"fieldset{padding:.35em .625em .75em;margin:0 2px;border:1px solid silver}\r\n" + 
			"\r\n" + 
			"legend{font-size:12px;background:green;color:white;align:center;padding:.5em;border:0;width:auto}\r\n" + 
			"\r\n" + 
			"p.topmargin {margin-top: 5cm}\r\n" + 
			"\r\n" + 
			"</style>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"\r\n" + 
			"<div class=\"main-left\">\r\n" + 
			"    <div class=\"thumbnail\" id=\"first_div\"  data-clipboard-text=\"\" >\r\n" + 
			"        <img src=\"https://img.alicdn.com/imgextra/i3/1080314806/TB2zLoxmhTI8KJjSspiXXbM4FXa_!!1080314806.jpg\"\r\n" + 
			"             alt=\"图片加载失败\"> \r\n" + 
			"	\r\n" + 
			"			<p class=\"lingquan_style\" align=\"center\">领券省5元</p>\r\n" + 
			"			<p class=\"product_title_style\">【三只松鼠旗舰店】红宝石蔓越莓干108gx2袋</p>\r\n" + 
			"			<div>\r\n" + 
			"				<p class=\"price_text_style\">券后价<span class=\"price_style\">￥29.9</span><span style=\"text-decoration:line-through;\"> ￥29.9</span></p>\r\n" + 
			"			</div>\r\n" + 
			"        \r\n" + 
			"    </div>\r\n" + 
			"	\r\n" + 
			"	\r\n" + 
			"    <div class=\"thumbnail\" id=\"three_div\"  data-clipboard-text=\"\" >\r\n" + 
			"        <img src=\"https://img.alicdn.com/imgextra/i2/2365125141/TB2essUxuuSBuNjSsziXXbq8pXa_!!2365125141.jpg\"\r\n" + 
			"             alt=\"图片加载失败\"> \r\n" + 
			"	\r\n" + 
			"			<p class=\"lingquan_style\" align=\"center\">领券5元</p>\r\n" + 
			"			<p class=\"product_title_style\">【三只松鼠旗舰店】红宝石蔓越莓干108gx2袋</p>\r\n" + 
			"			<div>\r\n" + 
			"				<p class=\"price_text_style\">券后价<span class=\"price_style\">￥29.9</span><span style=\"text-decoration:line-through;\"> ￥29.9</span></p>\r\n" + 
			"			</div>\r\n" + 
			"        \r\n" + 
			"    </div>\r\n" + 
			"	\r\n" + 
			"</div>\r\n" + 
			"<div class=\"main-right\">\r\n" + 
			"    <div class=\"thumbnail\" id=\"two_div\" data-clipboard-text=\"\">\r\n" + 
			"        <img src=\"https://img.alicdn.com/imgextra/i4/1783351337/TB26hDaj49YBuNjy0FfXXXIsVXa_!!1783351337.jpg\"\r\n" + 
			"             alt=\"图片加载失败\"> \r\n" + 
			"	\r\n" + 
			"			<p class=\"lingquan_style\" align=\"center\">领券5元</p>\r\n" + 
			"			<p class=\"product_title_style\">【三只松鼠旗舰店】红宝石蔓越莓干108gx2袋</p>\r\n" + 
			"			<div>\r\n" + 
			"				<p class=\"price_text_style\">券后价<span class=\"price_style\">￥29.9</span><span style=\"text-decoration:line-through;\"> ￥29.9</span></p>\r\n" + 
			"			</div>\r\n" + 
			"        \r\n" + 
			"    </div>\r\n" + 
			"	\r\n" + 
			"	\r\n" + 
			"    <div class=\"thumbnail\" id=\"four_div\" data-clipboard-text=\"\">\r\n" + 
			"        <img src=\"https://img.alicdn.com/imgextra/i3/3167224859/TB2_tQgwVuWBuNjSszbXXcS7FXa_!!3167224859.jpg\"\r\n" + 
			"             alt=\"图片加载失败\"> \r\n" + 
			"	\r\n" + 
			"			<p class=\"lingquan_style\" align=\"center\">领券5元</p>\r\n" + 
			"			<p class=\"product_title_style\">【三只松鼠旗舰店】红宝石蔓越莓干108gx2袋</p>\r\n" + 
			"			<div>\r\n" + 
			"				<p class=\"price_text_style\">券后价<span class=\"price_style\">￥29.9</span><span style=\"text-decoration:line-through;\"> ￥29.9</span></p>\r\n" + 
			"			</div>\r\n" + 
			"        \r\n" + 
			"    </div>\r\n" + 
			"	\r\n" + 
			"</div>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<script type=\"text/javascript\" src=\"js/clipboard.min.js\"></script>\r\n" + 
			"<script>\r\n" + 
			"\r\n" + 
			"//捕捉点击DIV 的属性\r\n" + 
			"$('.thumbnail').click(function(e){  \r\n" + 
			"	var value = $(this).attr('id');\r\n" + 
			"	\r\n" + 
			"	$(this).attr('data-clipboard-text',\"￥\"+value+\"￥\");\r\n" + 
			"	//alert(\"点击\"+value);\r\n" + 
			"    \r\n" + 
			"    var clipboard = new Clipboard('.thumbnail');\r\n" + 
			"\r\n" + 
			"    clipboard.on('success', function(e) {\r\n" + 
			"        \r\n" + 
			"		\r\n" + 
			"		\r\n" + 
			"		\r\n" + 
			"		\r\n" + 
			"		$('#successModal1').modal('show');\r\n" + 
			"		//setTimeout(function(){$(\"#successModal1\").modal(\"hide\")},3000);\r\n" + 
			"		\r\n" + 
			"    });\r\n" + 
			"\r\n" + 
			"    clipboard.on('error', function(e) {\r\n" + 
			"		//alert(\"复制失败\");\r\n" + 
			"		document.getElementById(\"dialog_content\").innerHTML = \"￥\"+value+\"￥\";\r\n" + 
			"		var word = document.querySelector('#dialog_content');\r\n" + 
			"		\r\n" + 
			"		document.addEventListener(\"selectionchange\",\r\n" + 
			"		function(e) {\r\n" + 
			"			window.getSelection().selectAllChildren(word);\r\n" + 
			"		},\r\n" + 
			"		false);\r\n" + 
			"		$('#failModal1').modal('show');\r\n" + 
			"         //document.getElementById(\"input_p\").innerHTML = \"复制失败\";\r\n" + 
			"    });\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"});\r\n" + 
			"\r\n" + 
			"		\r\n" + 
			"        \r\n" + 
			"		\r\n" + 
			"</script>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"		<!-- 模态框（Modal） -->\r\n" + 
			"        <div class=\"modal fade\" id=\"successModal1\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n" + 
			"            <div class=\"modal-dialog\">\r\n" + 
			"                <div class=\"modal-content\">\r\n" + 
			"					\r\n" + 
			"                    <div class=\"modal-header\" >\r\n" + 
			"　　　　　　　　　　    \r\n" + 
			"						<P class=\"success_title_style\" align=\"center\" >复制成功</p>\r\n" + 
			"						\r\n" + 
			"                    </div>\r\n" + 
			"					\r\n" + 
			"                    <div class=\"modal-body\"  style=\"background-color:rgb(239,239,239)\">\r\n" + 
			"					\r\n" + 
			"						<div >\r\n" + 
			"							\r\n" + 
			"                        	<p class=\"success_content_style\" align=\"center\" id=\"success_dialog_content\">优惠券匋口令已经复制，打开【手机匋宝】，直接领券付款即可！</p>\r\n" + 
			"							\r\n" + 
			"						</div>	\r\n" + 
			"					    \r\n" + 
			"						\r\n" + 
			"						\r\n" + 
			"                    </div>\r\n" + 
			"					\r\n" + 
			"                </div>\r\n" + 
			"                <!-- /.modal-content -->\r\n" + 
			"            </div>\r\n" + 
			"            <!-- /.modal -->\r\n" + 
			"        </div>\r\n" + 
			"		\r\n" + 
			"\r\n" + 
			"        <!-- 模态框（Modal） -->\r\n" + 
			"        <div class=\"modal fade\" id=\"failModal1\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n" + 
			"            <div class=\"modal-dialog\">\r\n" + 
			"                <div class=\"modal-content\">\r\n" + 
			"					<!--\r\n" + 
			"                    <div class=\"modal-header\" >\r\n" + 
			"　　　　　　　　　　　　　\r\n" + 
			"\r\n" + 
			"                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">\r\n" + 
			"                    &times;\r\n" + 
			"                </button>\r\n" + 
			"				\r\n" + 
			"                        \r\n" + 
			"						<h4 class=\"modal-title\" id=\"myModalLabel\">模态框（Modal）标题</h4>\r\n" + 
			"						\r\n" + 
			"                    </div>\r\n" + 
			"					-->\r\n" + 
			"                    <div class=\"modal-body\" >\r\n" + 
			"						\r\n" + 
			"						<div>\r\n" + 
			"							<P class=\"yuohui_title\" align=\"center\" >优惠券口令</p>\r\n" + 
			"						\r\n" + 
			"						</div>\r\n" + 
			"					\r\n" + 
			"						<div>\r\n" + 
			"							<fieldset>\r\n" + 
			"								 <legend align=\"center\">长按框内->复制</legend>\r\n" + 
			"                        		<p class=\"kouling_style\" align=\"center\" id=\"dialog_content\">000iii</p>\r\n" + 
			"							</fieldset>\r\n" + 
			"						</div>	\r\n" + 
			"					    \r\n" + 
			"						\r\n" + 
			"						<P class=\"copy_error_tips\" align=\"center\" id=\"copy_error_02\">请长按框内口令手动复制</p>\r\n" + 
			"						<P class=\"use_instruction_style\"  id=\"use_instruction\">使用说明:复制口.令后，打开匋堡直接领卷付款即可!</p>\r\n" + 
			"                    </div>\r\n" + 
			"					<!--\r\n" + 
			"                    <div class=\"modal-footer\">\r\n" + 
			"                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">知道了</button>\r\n" + 
			"                     \r\n" + 
			"                    </div>\r\n" + 
			"					-->\r\n" + 
			"                </div>\r\n" + 
			"                <!-- /.modal-content -->\r\n" + 
			"            </div>\r\n" + 
			"            <!-- /.modal -->\r\n" + 
			"        </div>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"</body>\r\n" + 
			"</html>";
	
}

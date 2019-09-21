package com.swq.BlogSystem.sevlet;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(description = "get code", urlPatterns = { "/getCode"},loadOnStartup=1)
public class codeServlet  extends HttpServlet{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private static int width = 60;// 定义图片的width
    private static int height = 28;// 定义图片的height
    private static int codeCount = 4;// 定义图片上显示验证码的个�?
    private static int xx = 15;
    private static int fontHeight = 20;
    private static  int codeY = 16;
    private static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    
    private static String[] args = {"REGISTER_NAME","LOGIN_NAME"};
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String modelName = req.getParameter("modelName");
    	if(modelName == null || modelName == "") {
    		return;
    	}
    	
    		List<String> list= Arrays.asList(args);
    		if(!list.contains(modelName)) {
    			return;
    	}
    		
    	
    	BufferedImage buffImg = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
    	Graphics gd = buffImg.getGraphics();
    	Random rd = new Random();
    	
    	//创建图片的轮�?
    	gd.setColor(Color.white);
    	gd.fillRect(0, 0, width, height);
    	
    	//设置字体
    	Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
    	gd.setFont(font);
    	
    	//画边�?
    	gd.setColor(Color.BLACK);
    	gd.drawRect(0, 0, width-1, height-1);
    	
    	gd.setColor(Color.BLACK);
    	
    	for(int i=0;i<5;i++) {
    		int x = rd.nextInt(width);
    		int y = rd.nextInt(height);
    		int x1 = rd.nextInt(12);
    		int y1 = rd.nextInt(12);
    		
    		gd.drawLine(x, y, x+x1, y+y1);
    	}
    	
    	StringBuffer buff = new StringBuffer();
    	
    	int red=0;
    	int green=0;
    	int blue=0;
    	
    	
    	for(int i=0;i<4;i++) {
    		
    		String str = String.valueOf(codeSequence[rd.nextInt(36)]);
    		
    		red =rd.nextInt(255);
    		green = rd.nextInt(255);
    		blue = rd.nextInt(255);
    		
    		gd.setColor(new Color(red,green,blue));
    		gd.drawString(str, (i+1)*10, 20);;
    		
    		buff.append(str);
    	}
    	
    	//存验证码到session�?
    	HttpSession session = req.getSession();
    	
    	session.setAttribute(modelName, buff.toString());
    	
        // 禁止图像缓存�?
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", -1);
        
        resp.setContentType("image/jpeg");
        
        ServletOutputStream output = null;
        
        //将图片写到前�?
        try {
        output = resp.getOutputStream();
        ImageIO.write((RenderedImage)buffImg, "jpeg", output);
        
        output.close();
        }catch(IOException e){
        	e.printStackTrace();
        }
        	
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

}
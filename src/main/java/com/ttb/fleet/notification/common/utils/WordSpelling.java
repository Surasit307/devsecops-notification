package com.ttb.fleet.notification.common.utils;

public class WordSpelling {

	
	public static String engToThai(String input,String type) {
		 StringBuilder str = new StringBuilder();
		  String[] inputStr = input.split("");	  
		  
		  for (String i : inputStr) {
		   str.append("-");
		   if (i.equals("!"))
		    str.append("อัศเจรีย์");  
		   if (i.equals("1"))
			str.append("หนึ่ง");
		   if (i.equals("@"))
			str.append("แอทไซน์");
		   if (i.equals("2"))
			str.append("สอง");
		   if (i.equals("#"))
		    str.append("ชาร์ปไซน์");
		   if (i.equals("3"))
			str.append("สาม");
		   if (i.equals("$"))
		    str.append("ดอลล่าไซน์");
		   if (i.equals("4"))
			str.append("สี่");
		   if (i.equals("%"))
			str.append("เปอร์เซ็นต์ไซน์");
		   if (i.equals("5"))
			str.append("ห้า");
		   if (i.equals("^"))
			str.append("แคเรต"); 
		   if (i.equals("6"))
			str.append("หก");
		   if (i.equals("&"))
			str.append("แอมเพอร์แซนด์"); 
		   if (i.equals("7"))
			str.append("เจ็ด");
		   if (i.equals("*"))
			str.append("ดอกจัน");
		   if (i.equals("8"))
			str.append("แปด");
		   if (i.equals("("))
			str.append("นขลิขิตเปิด"); 
		   if (i.equals("9"))
			str.append("เก้า");
		   if (i.equals(")"))
			str.append("นขลิขิตปิด"); 
		   if (i.equals("0"))
			str.append("ศูนย์");
		   if (i.equals("_"))
			str.append("อันเดอร์สกอร์");
		   if (i.equals("-"))
			str.append("ยัติภังค์");
		   if (i.equals("+"))
			str.append("บวก");  
		   if (i.equals("="))
			str.append("เท่ากับ"); 
		   if (i.equals("Q"))
			str.append("คิว(ใหญ่)");
		   if (i.equals("q"))
			str.append("คิว(เล็ก)");
		   if (i.equals("W"))
			str.append("ดับเบิลยู(ใหญ่)");
		   if (i.equals("w"))
			str.append("ดับเบิลยู(เล็ก)");
		   if (i.equals("E"))
			str.append("อี(ใหญ่)");
		   if (i.equals("e"))
			str.append("อี(เล็ก)");
		   if (i.equals("R"))
			str.append("อาร์(ใหญ่)");
		   if (i.equals("r"))
			str.append("อาร์(เล็ก)");
		   if (i.equals("T"))
			str.append("ที(ใหญ่)");
		   if (i.equals("t"))
			str.append("ที(เล็ก)");
		   if (i.equals("Y"))
			str.append("วาย(ใหญ่)");
		   if (i.equals("y"))
			str.append("วาย(เล็ก)");
		   if (i.equals("U"))
			str.append("ยู(ใหญ่)");
		   if (i.equals("u"))
			str.append("ยู(เล็ก)");
		   if (i.equals("I"))
			str.append("ไอ(ใหญ่)");
		   if (i.equals("i"))
			str.append("ไอ(เล็ก)");
		   if (i.equals("O"))
			str.append("โอ(ใหญ่)");
		   if (i.equals("o"))
			str.append("โอ(เล็ก)");
		   if (i.equals("P"))
			str.append("พี(ใหญ่)");
		   if (i.equals("p"))
			str.append("พี(เล็ก)");
		   if (i.equals("{"))
			str.append("วงเล็บปีกกาเปิด");
		   if (i.equals("["))
			str.append("วงเล็บเหลี่ยมเปิด");
		   if (i.equals("}"))
			str.append("วงเล็บปีกกาปิด");
		   if (i.equals("]"))
			str.append("วงเล็บเหลี่ยมปิด");
		   if (i.equals("|"))
			str.append("ขีดตั้ง");
		   if (i.equals("A"))
			str.append("เอ(ใหญ่)");
		   if (i.equals("a"))
			str.append("เอ(เล็ก)");
		   if (i.equals("S"))
			str.append("เอส(ใหญ่)");
		   if (i.equals("s"))
			str.append("เอส(เล็ก)");
		   if (i.equals("D"))
			str.append("ดี(ใหญ่)");
		   if (i.equals("d"))
			str.append("ดี(เล็ก)");
		   if (i.equals("F"))
			str.append("เอฟ(ใหญ่)");
		   if (i.equals("f"))
			str.append("เอฟ(เล็ก)");
		   if (i.equals("G"))
			str.append("จี(ใหญ่)");
		   if (i.equals("g"))
			str.append("จี(เล็ก)");
		   if (i.equals("H"))
			str.append("เอช(ใหญ่)");
		   if (i.equals("h"))
			str.append("เอช(เล็ก)");
		   if (i.equals("J"))
			str.append("เจ(ใหญ่)");
		   if (i.equals("j"))
			str.append("เจ(เล็ก)");
		   if (i.equals("K"))
			str.append("เค(ใหญ่)");
		   if (i.equals("k"))
			str.append("เค(เล็ก)");
		   if (i.equals("L"))
			str.append("แอล(ใหญ่)");
		   if (i.equals("l"))
			str.append("แอล(เล็ก)");
		   if (i.equals(":"))
			str.append("ทวิภาค");
		   if (i.equals(";"))
			str.append("อัฒภาค");
		   if (i.equals("\""))
			str.append("บุพสัญญา"); 
		   if (i.equals("'"))
			str.append("อัญประกาศเดี่ยว");
		   if (i.equals("Z"))
			str.append("แซด(ใหญ่)");
		   if (i.equals("z"))
			str.append("แซด(เล็ก)");
		   if (i.equals("X"))
			str.append("เอ็กซ์(ใหญ่)");
		   if (i.equals("x"))
			str.append("เอ็กซ์(เล็ก)");
		   if (i.equals("C"))
			str.append("ซี(ใหญ่)");
		   if (i.equals("c"))
			str.append("ซี(เล็ก)");
		   if (i.equals("V"))
			str.append("วี(ใหญ่)");
		   if (i.equals("v"))
			str.append("วี(เล็ก)");
		   if (i.equals("B"))
			str.append("บี(ใหญ่)");
		   if (i.equals("b"))
			str.append("บี(เล็ก)");
		   if (i.equals("N"))
			str.append("เอ็น(ใหญ่)");
		   if (i.equals("n"))
			str.append("เอ็น(เล็ก)");
		   if (i.equals("M"))
			str.append("เอ็ม(ใหญ่)");
		   if (i.equals("m"))
			str.append("เอ็ม(เล็ก)");
		   if (i.equals("<"))
			str.append("น้อยกว่า"); 
		   if (i.equals(","))
			str.append("จุลภาค");
		   if (i.equals(">"))
			str.append("มากกว่า"); 
		   if (i.equals("."))
			str.append("มหัพภาค");
		   if (i.equals("?"))
			str.append("ปรัศนี");
		   if (i.equals("/"))
			str.append("ทับ");
		   if (i.equals("\\")) 
		 	str.append("แบ็กสแลช"); 

		  }

		  return str.toString().substring(1);
		
	}
}

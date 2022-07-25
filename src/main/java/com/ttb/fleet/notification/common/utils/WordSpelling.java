package com.ttb.fleet.notification.common.utils;

public class WordSpelling {

	
	public static String engToSpellThai(String input,String type) {
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
	
	
	public static String engToSpellEng(String input,String type) {
		 StringBuilder str = new StringBuilder();
		  String[] inputStr = input.split("");	  
		  
		  for (String i : inputStr) {
		   str.append("-");
		   if (i.equals("!"))
		    str.append("Exclamation Mark");  
		   if (i.equals("1"))
			str.append("one");
		   if (i.equals("@"))
			str.append("at sign");
		   if (i.equals("2"))
			str.append("two");
		   if (i.equals("#"))
		    str.append("shape");
		   if (i.equals("3"))
			str.append("three");
		   if (i.equals("$"))
		    str.append("dollar sign");
		   if (i.equals("4"))
			str.append("four");
		   if (i.equals("%"))
			str.append("percent sign");
		   if (i.equals("5"))
			str.append("five");
		   if (i.equals("^"))
			str.append("circumflex Accent"); 
		   if (i.equals("6"))
			str.append("six");
		   if (i.equals("&"))
			str.append("ampersand"); 
		   if (i.equals("7"))
			str.append("seven");
		   if (i.equals("*"))
			str.append("star");
		   if (i.equals("8"))
			str.append("eight");
		   if (i.equals("("))
			str.append("left parenthesis"); 
		   if (i.equals("9"))
			str.append("nine");
		   if (i.equals(")"))
			str.append("right parenthesis"); 
		   if (i.equals("0"))
			str.append("zero");
		   if (i.equals("_"))
			str.append("under score");
		   if (i.equals("-"))
			str.append("minus sign");
		   if (i.equals("+"))
			str.append("plus sign");  
		   if (i.equals("="))
			str.append("equal sign"); 
		   if (i.equals("Q"))
			str.append("Q(uppercase)");
		   if (i.equals("q"))
			str.append("q(lowercase)");
		   if (i.equals("W"))
			str.append("W(uppercase)");
		   if (i.equals("w"))
			str.append("w(lowercase)");
		   if (i.equals("E"))
			str.append("E(uppercase)");
		   if (i.equals("e"))
			str.append("e(lowercase)");
		   if (i.equals("R"))
			str.append("R(uppercase)");
		   if (i.equals("r"))
			str.append("r(lowercase)");
		   if (i.equals("T"))
			str.append("T(uppercase)");
		   if (i.equals("t"))
			str.append("t(lowercase)");
		   if (i.equals("Y"))
			str.append("Y(uppercase)");
		   if (i.equals("y"))
			str.append("y(lowercase)");
		   if (i.equals("U"))
			str.append("U(uppercase)");
		   if (i.equals("u"))
			str.append("u(lowercase)");
		   if (i.equals("I"))
			str.append("I(uppercase)");
		   if (i.equals("i"))
			str.append("i(lowercase)");
		   if (i.equals("O"))
			str.append("O(uppercase)");
		   if (i.equals("o"))
			str.append("o(lowercase)");
		   if (i.equals("P"))
			str.append("P(uppercase)");
		   if (i.equals("p"))
			str.append("p(lowercase)");
		   if (i.equals("{"))
			str.append("left curly bracket");
		   if (i.equals("["))
			str.append("left square bracket");
		   if (i.equals("}"))
			str.append("right curly bracket");
		   if (i.equals("]"))
			str.append("right square bracket");
		   if (i.equals("|"))
			str.append("vertical line");
		   if (i.equals("A"))
			str.append("A(uppercase)");
		   if (i.equals("a"))
			str.append("a(lowercase)");
		   if (i.equals("S"))
			str.append("S(uppercase)");
		   if (i.equals("s"))
			str.append("s(lowercase)");
		   if (i.equals("D"))
			str.append("D(uppercase)");
		   if (i.equals("d"))
			str.append("d(lowercase)");
		   if (i.equals("F"))
			str.append("F(uppercase)");
		   if (i.equals("f"))
			str.append("f(lowercase)");
		   if (i.equals("G"))
			str.append("G(uppercase)");
		   if (i.equals("g"))
			str.append("g(lowercase)");
		   if (i.equals("H"))
			str.append("H(uppercase)");
		   if (i.equals("h"))
			str.append("h(lowercase)");
		   if (i.equals("J"))
			str.append("J(uppercase)");
		   if (i.equals("j"))
			str.append("j(lowercase)");
		   if (i.equals("K"))
			str.append("K(uppercase)");
		   if (i.equals("k"))
			str.append("k(lowercase)");
		   if (i.equals("L"))
			str.append("L(uppercase)");
		   if (i.equals("l"))
			str.append("l(lowercase)");
		   if (i.equals(":"))
			str.append("colon");
		   if (i.equals(";"))
			str.append("semicolon");
		   if (i.equals("\""))
			str.append("back slash"); 
		   if (i.equals("'"))
			str.append("apostrophe");
		   if (i.equals("Z"))
			str.append("Z(uppercase)");
		   if (i.equals("z"))
			str.append("z(lowercase)");
		   if (i.equals("X"))
			str.append("X(uppercase)");
		   if (i.equals("x"))
			str.append("x(lowercase)");
		   if (i.equals("C"))
			str.append("C(uppercase)");
		   if (i.equals("c"))
			str.append("c(lowercase)");
		   if (i.equals("V"))
			str.append("V(uppercase)");
		   if (i.equals("v"))
			str.append("v(lowercase)");
		   if (i.equals("B"))
			str.append("B(uppercase)");
		   if (i.equals("b"))
			str.append("b(lowercase)");
		   if (i.equals("N"))
			str.append("N(uppercase)");
		   if (i.equals("n"))
			str.append("n(lowercase)");
		   if (i.equals("M"))
			str.append("M(uppercase)");
		   if (i.equals("m"))
			str.append("m(lowercase)");
		   if (i.equals("<"))
			str.append("less than sign"); 
		   if (i.equals(","))
			str.append("comma");
		   if (i.equals(">"))
			str.append("more than sign"); 
		   if (i.equals("."))
			str.append("full stop");
		   if (i.equals("?"))
			str.append("question mark");
		   if (i.equals("/"))
			str.append("slash");
		   if (i.equals("\\")) 
		 	str.append("back slash"); 

		  }

		  return str.toString().substring(1);
	}
}

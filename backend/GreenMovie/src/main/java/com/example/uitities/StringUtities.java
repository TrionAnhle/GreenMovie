package com.example.uitities;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtities {
	public static String toCode(String s) {
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String code = pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "d");

        String[] codes = code.split(" ");
        StringBuilder codeNew = new StringBuilder(codes[0]);
        for(int i=1;i<codes.length;i++) codeNew.append("-"+codes[i]);
        return codeNew.toString().toLowerCase();
	}
}

package com.abstractmedia.projects.epoxydesign.features.randomString;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class StringPatterns {
    
    
    public final int SMALL_SIZE = 10;
    public final int MEDIUM_SIZE = 20;
    public final int LARGE_SIZE = 30;
   
    public Random random;
    
    public StringPatterns(){
        
    }
        
    public String generate(Chars c,Size s){
        String str = "";
        int size = 0;
        String randomString = "";
        
        switch(c){
            case LETTER_CHARS:
                str = "qwertyuiopasdfghjklzxcvbnm";
                break;
            case ALL_CHARS:
                str = "5qw4er1t6yu9i0opasdf7ghjklz3x28cvbnm_#$*!@^";
                break;
        }
        switch(s){
            case TINY_SIZE:
                size = 5;
                break;
            case SMALL_SIZE:
                size = 10;
                break;
            case MEDIUM_SIZE:
                size =20;
                break;
            case LARGE_SIZE:
                size = 30;
                break;
        }
        randomString =  generateRandomStr(str, size);
        return randomString;
    }
    
    private String generateRandomStr(String str,int size){
         
   
         random = new Random();
         StringBuilder sb = new StringBuilder();
         
         for (int i = 0; i < size; i++) {
             int r = random.nextInt(str.length());
             String a_letter = Character.toString(str.charAt(r));;
           
            sb.append(a_letter);
        }
        
       return sb.toString();
    }
}

package com.test.grads;

public class Util {
  public static String removeSpaces(String text) {
    while(text.indexOf("  ")!=-1)
      text=text.replace("  "," ");
    return text;
  }

}

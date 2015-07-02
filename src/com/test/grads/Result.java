package com.test.grads;

import java.awt.image.BufferedImage;

public class Result {
  private int status=0;
  private BufferedImage image;
  private String[] output;

  public void setStatus(int status) { this.status=status; }
  public int getStatus() { return status; }

  public String[] getOutput() { return output; }

  public BufferedImage getImage() { return image; }
  public void setImage(BufferedImage image) { this.image=image; }

  public Result(String[] output) {
    this.output=output;
    this.image=null;
    this.status=0;
  }

  public String toString() {
    String result="";
    if (output!=null) {
      for(int i=0;i<output.length;i++) {
        result+="O"+i+":"+output[i]+"\n";
      }
    }
    return result;
  }
}

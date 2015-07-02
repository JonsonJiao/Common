package com.test.grads;


public class Var {

  private String name;
  private int nLevels;
  private int gribCode;
  private String desc;
  private String unit;

  public Var(String name, int nLevels, int gribCode, String desc, String unit) {
    this.name=name;
    this.nLevels=nLevels;
    this.gribCode=gribCode;
    this.desc=desc;
    this.unit=unit;
  }

  public Var(String line) {
    line=line.trim();
    String[] parts=line.split(" ");
    name=parts[0];
    nLevels=Integer.parseInt(parts[1]);
    gribCode=Integer.parseInt(parts[2]);
    String temp="";
    for (int i=3;i<parts.length;i++)
      temp+=parts[i]+" ";
    temp=temp.trim();

    int pos=temp.indexOf("(");
    unit=temp.substring(pos+1,temp.length()-1);
    desc=temp.substring(0,pos-2);
  }

  public String toString() {
    return name+" "+nLevels+" "+gribCode+" "+desc+" ("+unit+")";
  }

  public static void main(String[] args) {
    String line="umet 19 0 Rotated wind component (m s-1)";
    Var var=new Var(line);
    System.out.println(line+"\n"+var);
  }
}

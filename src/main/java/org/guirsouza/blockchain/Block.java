package org.guirsouza.blockchain;

import java.util.regex.Matcher;

public class Block {
  private Integer index;
  private String hash;
  private String previousHash;
  private String data; //our data will be a simple message.
  private Long timeStamp; //as number of milliseconds since 1/1/1970.
  private Integer nonce = 0;

  public Block(String data, String previousHash) {
    this.data = data;
    this.previousHash = previousHash;
    this.timeStamp = System.currentTimeMillis();
    mine();
  }

  public String calculateHash() {
    return StringUtil.applySha256(this.index + this.previousHash + this.data + this.timeStamp + this.nonce);
  }

  public void mine() {
    Matcher m = null;
    String temp = "";
    do {
      this.nonce++;
      temp = this.calculateHash();
    } while (!temp.startsWith("00"));
    this.hash = temp;
  }

  public String getHash() {
    return this.hash;
  }

  public Integer getIndex() {
    return this.index;
  }

  public String getPreviousHash() {
    return this.previousHash;
  }

}

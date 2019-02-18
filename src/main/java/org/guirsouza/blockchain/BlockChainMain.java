package org.guirsouza.blockchain;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class BlockChainMain {

  public static void main(String[] args) {

    ArrayList<Block> blockchain = new ArrayList<Block>();

    //add our blocks to the blockchain ArrayList:
    blockchain.add(new Block("Hi im the first block", "0"));
    blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).getHash()));
    blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).getHash()));

    String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
    System.out.println(blockchainJson);

  }

}

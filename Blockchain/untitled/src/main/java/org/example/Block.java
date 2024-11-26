package org.example;

public class Block {
    private String previousHash;
    private String data;
    private String timestamp;
    private String hash;
    private String signature;

    public Block(String previousHash, String data) {
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = String.valueOf(System.currentTimeMillis());
        this.hash = Utils.calculateHash(this);
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public String getHash() {
        return hash;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    public String getTimestamp() { // Agregado
        return timestamp;
    }
}

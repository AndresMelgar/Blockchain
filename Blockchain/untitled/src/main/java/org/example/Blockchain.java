package org.example;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> blockchain;

    public Blockchain() {
        blockchain = new ArrayList<>();
    }

    public void addBlock(String data) {
        String previousHash = (blockchain.size() > 0) ? blockchain.get(blockchain.size() - 1).getHash() : "0";
        Block newBlock = new Block(previousHash, data);

        // Obtener firma del árbitro
        String signature = SKey.getSignatureFromArbitrator(newBlock.getHash());
        if (signature != null) {
            newBlock.setSignature(signature);
            blockchain.add(newBlock);
            System.out.println("Block added: " + newBlock.getData() + ", Signature: " + newBlock.getSignature());
        } else {
            System.out.println("Error obtaining signature from the arbitrator.");
        }
    }

    public boolean verifyBlockchain() {
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);

            // Verificar el hash anterior
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                System.out.println("Blockchain is invalid: previous hash does not match.");
                return false;
            }

            // Verificar que el hash actual es correcto
            if (!currentBlock.getHash().equals(Utils.calculateHash(currentBlock))) {
                System.out.println("Blockchain is invalid: hash does not match.");
                return false;
            }
        }
        System.out.println("Blockchain is valid.");
        return true;
    }
}

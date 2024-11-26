package org.example;

public class BlockchainApp {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();

        // Añadir bloques de ejemplo
        blockchain.addBlock("Block 1 Data");
        blockchain.addBlock("Block 2 Data");
        blockchain.addBlock("Block 3 Data");

        // Verificar la integridad de la cadena de bloques
        blockchain.verifyBlockchain();
    }
}

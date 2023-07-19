package Utils;

import Decoder.HuffmanDecoder;
import Encoder.HuffmanEncoder;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class Tester {

    public String read(String filePath){
        TextReader r = new TextReader(filePath);
        StringBuilder res = new StringBuilder();
        while(true){
            int asciiValue = r.readNextChar();
            if(asciiValue < 0){
                break;
            }

            char currentCharacter = (char) asciiValue;
            res.append(currentCharacter);
        }
        return res.toString();
    }

    public void getDecompressionSuccessRate(String original, String uncompressed){
        double numChars = Math.max(original.length(), uncompressed.length());
        double matched = 0;
        for(int i = 0; i < numChars; i ++){
            if(original.charAt(i) == uncompressed.charAt(i)){
                matched += 1;
            }
        }
        System.out.println("Huffman Recovery Rate: " + matched/numChars);
    }

    public void getEncodingOptimality(double compressedSize, String compressedFile){
        try {
            BufferedBitReader br = new BufferedBitReader(compressedFile);
            double bitsRead = getBitsRead(br);
            double percentIncrease = (100.0 * (bitsRead / compressedSize - 1));
            double pointsLost = 0;

            if(percentIncrease > 0){
                percentIncrease = Math.floor(percentIncrease);
                pointsLost = percentIncrease / 2;

                System.out.println("You wrote out " + bitsRead + " bits.");
                System.out.println("This is " + percentIncrease + " percent more than expected");
            }
        } catch (IOException e){
        }
    }

    public double getBitsRead(BufferedBitReader br){
        double bitsRead = 0;
        try {
            while (true) {
                int bit = br.readBit();
                if (bit == -1) {
                    return bitsRead;
                }
                bitsRead += 1;
            }
        } catch (IOException e){
            return bitsRead;
        }
    }

    @Test
    void testConstitution() {
        System.out.println("Testing Constitution");
        double compressedSize = 25432 * 8;

        String inputFile = "data/constitution.txt";
        String compressedFile = "data/constitution_compressed.txt";
        String uncompressedFile = "data/constitution_recovered.txt";

        // Encode and decode
        HuffmanEncoder.encodeFile(inputFile, compressedFile);
        HuffmanDecoder.decodeFile(compressedFile, uncompressedFile);

        // Check uncompression success rate
        String original = read("data/constitution.txt");
        String uncompressed = read("data/constitution_recovered.txt");
        getDecompressionSuccessRate(original, uncompressed);

        // Check encoding optimality
        getEncodingOptimality(compressedSize, compressedFile);

        System.out.println();
    }

    @Test
    void testLOTF() {
        System.out.println("Testing Part of LOTF");
        double compressedSize = 322 * 8;

        String inputFile = "data/lotf.txt";
        String compressedFile = "data/lotf_compressed.txt";
        String uncompressedFile = "data/lotf_recovered.txt";

        // Encode and decode
        HuffmanEncoder.encodeFile(inputFile, compressedFile);
        HuffmanDecoder.decodeFile(compressedFile, uncompressedFile);

        // Check uncompression success rate
        String original = read("data/lotf.txt");
        String uncompressed = read("data/lotf_recovered.txt");
        getDecompressionSuccessRate(original, uncompressed);

        // Check encoding optimality
        getEncodingOptimality(compressedSize, compressedFile);

        System.out.println();
    }

    @Test
    void testWarAndPeace() {
        System.out.println("Testing War and Peace");
        double compressedSize = 1811854 * 8;

        String inputFile = "data/warandpeace.txt";
        String compressedFile = "data/warandpeace_compressed.txt";
        String uncompressedFile = "data/warandpeace_recovered.txt";

        // Encode and decode
        HuffmanEncoder.encodeFile(inputFile, compressedFile);
        HuffmanDecoder.decodeFile(compressedFile, uncompressedFile);

        // Check uncompression success rate
        String original = read("data/warandpeace.txt");
        String uncompressed = read("data/warandpeace_recovered.txt");
        getDecompressionSuccessRate(original, uncompressed);

        // Check encoding optimality
        getEncodingOptimality(compressedSize, compressedFile);

        System.out.println();
    }


}

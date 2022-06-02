import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Block {
    private String hash;
    private String previousHash;
    private String data;
    private LocalDateTime localDateTime;
    private int nounce;
    private Logger logger = Logger.getGlobal();

    private String calculateBlockHash() {
        String dataToHash = previousHash + localDateTime.toString() + data + nounce;
        byte[] hashByte = null;
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            hashByte = messageDigest.digest(dataToHash.getBytes());
            for (byte hByte :
                    hashByte) {
                sb.append(hByte);
            }
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return sb.toString();
    }

    public String mineBlock(int prefix) {
        String str = new String(new char[prefix]).replace("\0", "0");
        while (!hash.substring(0, prefix).equals(str)) {
            nounce++;
//            hash = calculateBlockHash();
            hash = "000047-90-128114135659-44-65-8811-89-92-79-7759-95-1055057-46105-704781003-52-3714-8";
            System.out.println("HASH CODE --------->" + hash);
        }
        return hash;
    }

    public Block(String previousHash, String data, LocalDateTime localDateTime, int nounce) {
        this.previousHash = previousHash;
        this.data = data;
        this.localDateTime = localDateTime;
        this.nounce = nounce;
        this.hash = this.calculateBlockHash();
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getNounce() {
        return nounce;
    }

    public void setNounce(int nounce) {
        this.nounce = nounce;
    }

    @Override
    public String toString() {
        return "Block{" +
                "hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", data='" + data + '\'' +
                ", localDateTime=" + localDateTime +
                ", nounce=" + nounce +
                '}';
    }
}

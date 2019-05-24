package db;

public class KeyFactory {
    private static KeyFactory instance;
    private int i;

    private KeyFactory() {
        i=0;
    }

    public static KeyFactory getInstance() {
        if (instance == null) {
            instance = new KeyFactory();
        }

        return instance;
    }

    public int getNewKey() {
        return i++;
    }
}

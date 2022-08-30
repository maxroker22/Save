import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int health;
    private final int weapons;
    private final int lvl;
    private final double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    public static void main(String[] args) throws IOException {
        GameProgress gameProgress = new GameProgress(90, 90, 90, 90.1);
        GameProgress gameProgress1 = new GameProgress(91, 91, 91, 91.1);
        GameProgress gameProgress2 = new GameProgress(92, 92, 92, 92.2);
        saveGame("D://Games/savegames/save.dat", gameProgress);
        saveGame("D://Games/savegames/save2.dat", gameProgress1);
        saveGame("D://Games/savegames/save3.dat", gameProgress2);
        List<String> list = new ArrayList<>();
        list.add("save.dat");
        list.add("save2.dat");
        list.add("save3.dat");
        zipFiles("D://Games/savegames/zip.zip", list);


    }



    private static void zipFiles(String result , List<String> list) {
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(result));
             FileInputStream fis = new FileInputStream("zip.zip")) {
            for (String list2 : list) {
                ZipEntry entry = new ZipEntry(list2);
                zip.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                zip.write(buffer);
            }
            zip.closeEntry();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void saveGame(String result ,GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream("zip.zip");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public String toString() {
        return "GameProgress{ " +
                "health = " + health +
                ", weapons = " + weapons +
                ", lvl = " + lvl +
                ", distance = " + distance +
                '}';
    }
}
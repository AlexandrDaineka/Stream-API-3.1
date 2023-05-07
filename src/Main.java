import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {

        File gamesDir = new File("C:/Games/Games");
        gamesDir.mkdir();

        File srcDir = new File(gamesDir, "src");
        srcDir.mkdir();

        File mainDir = new File(srcDir, "main");
        mainDir.mkdir();

        File testDir = new File(srcDir, "test");
        testDir.mkdir();

        File mainJava = new File(mainDir, "Main.java");
        try {
            mainJava.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        File utilsJava = new File(mainDir, "Utils.java");
        try {
            utilsJava.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        File resDir = new File(gamesDir, "res");
        resDir.mkdir();

        File drawablesDir = new File(resDir, "drawables");
        drawablesDir.mkdir();

        File vectorsDir = new File(resDir, "vectors");
        vectorsDir.mkdir();

        File iconsDir = new File(resDir, "icons");
        iconsDir.mkdir();

        File savegamesDir = new File(gamesDir, "savegames");
        savegamesDir.mkdir();

        File tempDir = new File(gamesDir, "temp");
        tempDir.mkdir();

        File tempFile = new File(tempDir, "temp.txt");
        try {
            tempFile.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        StringBuilder log = new StringBuilder();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        String currentUser = System.getProperty("user.name");

        log.append(dateFormat.format(date)).append(": ");
        log.append(currentUser).append(" установил(а) следующие файлы:\n");
        log.append(mainJava.getPath()).append("\n");
        log.append(utilsJava.getPath()).append("\n");
        log.append(drawablesDir.getPath()).append("\n");
        log.append(vectorsDir.getPath()).append("\n");
        log.append(iconsDir.getPath()).append("\n");
        log.append(savegamesDir.getPath()).append("\n");
        log.append(tempDir.getPath()).append("\n");
        log.append(tempFile.getPath()).append("\n");
        log.append("Совокупное время установки всех файлов: ").append(System.currentTimeMillis()).append(" милисекунд\n");

        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(log.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
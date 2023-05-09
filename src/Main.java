import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    private static ArrayList filesList = new ArrayList<>();
    public static void main(String[] args) {
        createDirectories();
        createFiles();
        writeLog();
    }

    private static void createDirectories() {
        createDirectory("C:/Games/Games");
        createSubDirectories("C:/Games/Games/src", "C:/Games/Games/res", "C:/Games/Games/savegames", "C:/Games/Games/temp");
        createSubDirectories("C:/Games/Games/src/main", "C:/Games/Games/src/test");
        createSubDirectories("C:/Games/Games/res/drawables", "C:/Games/Games/res/vectors", "C:/Games/Games/res/icons");
    }

    private static void createFiles() {
        createFile("C:/Games/Games/src/main/Main.java");
        createFile("C:/Games/Games/src/main/Utils.java");
        createFile("C:/Games/Games/temp/temp.txt");
        filesList.add("C:/Games/Games/res/drawables");
        filesList.add("C:/Games/Games/res/vectors");
        filesList.add("C:/Games/Games/res/icons");
        filesList.add("C:/Games/Games/savegames");
        filesList.add("C:/Games/Games/temp");
    }

    private static void writeLog() {
        File tempFile = new File("C:/Games/Games/temp/temp.txt");
        StringBuilder log = new StringBuilder();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String currentUser = System.getProperty("user.name");

        log.append(dateFormat.format(date)).append(": ");
        log.append(currentUser).append(" установил(а) следующие файлы:\n");

        for (Object file : filesList) {
            log.append(file).append("\n");
        }

        log.append("Совокупное время установки всех файлов: ").append(System.currentTimeMillis()).append(" милисекунд\n");

        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(log.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createDirectory(String path) {
        File newDir = new File(path);
        boolean isCreated = newDir.mkdir();
        if (isCreated) {
            String successMessage = "Папка " + path + " успешно создана";
            System.out.println(successMessage);
            filesList.add(path);
        } else {
            String errorMessage = "Не удалось создать папку " + path;
            System.out.println(errorMessage);
        }
    }

    private static void createFile(String path) {
        File newFile = new File(path);
        boolean isCreated;
        try {
            isCreated = newFile.createNewFile();
        } catch (IOException ex) {
            isCreated = false;
        }
        if (isCreated) {
            String successMessage = "Файл " + path + " успешно создан";
            System.out.println(successMessage);
            filesList.add(path);
        } else {
            String errorMessage = "Не удалось создать файл " + path;
            System.out.println(errorMessage);
        }
    }

    private static void createSubDirectories(String... paths) {
        for (String path : paths) {
            createDirectory(path);
        }
    }
}
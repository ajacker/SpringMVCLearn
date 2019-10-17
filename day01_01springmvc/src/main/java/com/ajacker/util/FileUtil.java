package com.ajacker.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * @author ajacker
 * @date 2019/10/18 0:49
 */
public class FileUtil {

    // 上传文件
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    // 删除文件,返回值表示是否删除成功
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            return file.delete();
        } else {
            return false;
        }
    }

    // 重命名文件
    public static String renameToUUID(String fileName) {
        return UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}

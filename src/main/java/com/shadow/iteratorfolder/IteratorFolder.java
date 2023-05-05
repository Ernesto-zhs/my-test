package com.shadow.iteratorfolder;

import com.sun.management.OperatingSystemMXBean;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 遍历当前系统所有文件
 */
public class IteratorFolder {

    public static void main(String[] args) throws IOException {
        getDiskInfo();
        getMemoryInfo();
    }

    /**
     * 获取系统各个硬盘的总容量、已经使用的容量、剩余容量和使用率
     */
    public static void getDiskInfo() throws IOException {
        DecimalFormat df = new DecimalFormat("#0.00");
        File[] disks = File.listRoots();
        AtomicInteger count = new AtomicInteger(0);
        for (File file : disks) {
            count.getAndAdd(1);
            // 获取盘符
            System.out.print(file.getCanonicalPath() + "   ");
            // 获取总容量
            long totalSpace = file.getTotalSpace();
            // 获取剩余容量
            long usableSpace = file.getUsableSpace();
            // 获取已经使用的容量
            long freeSpace = totalSpace - usableSpace;
            // 获取使用率
            float useRate = (float) ((freeSpace * 1.0 / totalSpace) * 100);
            System.out.print("总容量： " + transformation(totalSpace));
            System.out.print("已经使用： " + transformation(freeSpace));
            System.out.print("剩余容量： " + transformation(usableSpace));
            System.out.println("使用率： " + Double.parseDouble(df.format(useRate)) + "%   ");
            printAllFile(file, count);
        }
        System.out.println("本系统的文件加文件夹总数为： " + count.get());
    }

    private static void printAllFile(File file, AtomicInteger count) {
        count.getAndAdd(1);
        System.out.println(file.getAbsolutePath());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (Objects.isNull(files)) {
                return;
            }
            for (File listFile : files) {
                printAllFile(listFile, count);
            }
        }
    }

    /**
     * 获取内存使用情况
     */
    public static void getMemoryInfo() {
        OperatingSystemMXBean mem = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        // 获取内存总容量
        long totalMemorySize = mem.getTotalPhysicalMemorySize();
        // 获取可用内存容量
        long freeMemorySize = mem.getFreePhysicalMemorySize();
        System.out.println("内存总容量：" + transformation(totalMemorySize));
        System.out.println("可用容量：" + transformation(freeMemorySize));
    }

    /**
     * 将字节容量转化为GB
     */
    public static String transformation(long size) {
        return size / 1024 / 1024 / 1024 + "GB" + "   ";
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.jdevel.utils;

import java.io.File;
import java.util.Date;

/**
 *
 * @author Marek Piechut
 */
public class JAccessTimeUnix {

    static {
        System.loadLibrary("jAccessTimeC");
    }

    /**
     * 
     * @param path
     * @return
     */
    native private static int getLastAccessTime(String path);

    public static Date getLastAccessTime(File file) {
        long time = getLastAccessTime(file.getPath());
        //Last access time is stored in seconds, thus * 1000
        time *= 1000;
        Date date = new Date(time);
        return date;
    }
    
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Last Access Time of: " + args[0]);
            System.out.println(getLastAccessTime(new File(args[0])));
        } else {
            System.out.println("Pass file path as parameter");
        }
    }
}

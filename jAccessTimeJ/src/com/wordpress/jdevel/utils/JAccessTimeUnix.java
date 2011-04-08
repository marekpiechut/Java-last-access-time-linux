/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.jdevel.utils;

/**
 *
 * @author Marek Piechut <mco (at) o2.pl>
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
    native public static int getLastAccessTime(String path);

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Last Access Time of: " + args[0]);
            System.out.println("" + getLastAccessTime(args[0]));
        } else {
            System.out.println("Pass file path as parameter");
        }
    }
}

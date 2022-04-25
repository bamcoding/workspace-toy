package com.bamcoding.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationMainTest {

    @DisplayName("별찍기5")
    @Test
    void star5Test(){
        int n = 5;

        String starLine = "";
        String blank = "";
        for (int i=0;i<n;i++) {
            blank = "";
            for(int b=0;b<n-i-1;b++) {
                blank += " ";
            }
            starLine = "";
            for(int j=0;j<2*(i+1)-1;j++) {
                starLine += "*";
            }
            System.out.println(blank+starLine);
        }

        assertEquals("*********",starLine);
    }

    @DisplayName("별찍기4")
    @Test
    void star4Test(){
        int n = 5;

        String starLine = "";
        String blank = "";
        for (int i=n;i>0;i--) {
            starLine = "";
            for(int j=0;j<i;j++) {
                starLine += "*";
            }
            blank = "";
            for(int b=0;b<n-i;b++) {
                blank += " ";
            }
            System.out.println(blank+starLine);
        }

        assertEquals("   *",starLine);
    }

    @DisplayName("별찍기3")
    @Test
    void star3Test(){
        int n = 5;

        String starLine = "";
        for (int i=n;i>0;i--) {
            starLine = "";
            for(int j=0;j<i;j++) {
                starLine += "*";
            }
            System.out.println(starLine);
        }
        assertEquals("*",starLine);
    }

    @DisplayName("별찍기2")
    @Test
    void star2Test(){
        int n = 5;

        String starLine = "";
        String blank = "";
        for (int i=0;i<n;i++) {
            blank = "";
            for(int j=n-1-i;0<j;j--) {
                blank += " ";
            }
            starLine += "*";
            System.out.println(blank+starLine);
        }
        assertEquals("*****",starLine);
    }

    @DisplayName("별찍기1")
    @Test
    void star1Test(){
        int n = 5;

        String starLine = "";
        for (int i=0;i<n;i++) {
            starLine += "*";
            System.out.println(starLine);
        }

        assertEquals("*****",starLine);
    }
}

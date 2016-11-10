package Itello;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cof on 2016-11-07.
 */
public class MainTest {
    @Test
    public void crunchy() {
        String n = "crunchy";
        String numberEncryption = Main.getNumberEncryption(n);
        assertEquals("3-18-21-14-3-8-25", numberEncryption);
    }

    @Test
    public void PeanutButter() {
        String n = "Peanut Butter Jordnötssmör";
        String numberEncryption = Main.getNumberEncryption(n);
        assertEquals("16-5-1-14-21-20 2-21-20-20-5-18 10-15-18-4-14-29-20-19-19-13-29-18", numberEncryption);
    }

    @Test
    public void Glass() {
        String n = "Glass";
        String numberEncryption = Main.getNumberEncryption(n);
        assertEquals("7-12-1-19-19", numberEncryption);
    }

    @Test
    public void mening() {
        String n = "This is a sentence!";
        String numberEncryption = Main.getNumberEncryption(n);
        assertEquals("20-8-9-19 9-19 1 19-5-14-20-5-14-3-5!", numberEncryption);
    }

    @Test
    public void cat() {
        String n = "I am a cat! Meow? Meow!";
        String numberEncryption = Main.getNumberEncryption(n);
        assertEquals("9 1-13 1 3-1-20! 13-5-15-23? 13-5-15-23!", numberEncryption);
    }

    @Test
    public void c() {
        String n = "c";
        String numberEncryption = Main.getNumberEncryption(n);
        assertEquals("3", numberEncryption);
    }

    @Test
    public void num() {
        String n = "0123456789";
        String numberEncryption = Main.getNumberEncryption(n);
        assertEquals("0123456789", numberEncryption);
    }

    @Test
    public void weirdsymbols() {
        String n = "ÅÄÖ[\\]åäö{|}";
        String numberEncryption = Main.getNumberEncryption(n);
        assertEquals("27-28-29[\\]27-28-29{|}", numberEncryption);
    }

    @Test
    public void Exclamation() {
        String n = "!";
        String numberEncryption = Main.getNumberEncryption(n);
        assertEquals("!", numberEncryption);
    }
    @Test
    public void swedishAsciiCheck() {
        String n = "å Å ä Ä ö Ö";
        String numberEncryption = Main.getNumberEncryption(n);
        assertEquals("27 27 28 28 29 29", numberEncryption);
    }
}
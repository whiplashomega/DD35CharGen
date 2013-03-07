/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ddgame;

import TextIO.TextIO;
import java.util.ArrayList;
import ddgame.*;

/**
 *
 * @author Joe
 */
public class Enchantment {
    public int ID;
    public String name;
    public int enhancementamount;
    public double setcost;
    public boolean armor;
    public boolean shield;
    public boolean meleeweapon;
    public boolean rangedweapon;
    public String description;
    public String code;
    public static ArrayList<String> EnchantmentNames = new ArrayList<>();
    public static ArrayList<Enchantment> EnchantmentList = new ArrayList<>();
    private static String nextWord() {
        String buffer = "";
        char next;
        while(TextIO.peek() != '~' && TextIO.eof()==false && TextIO.peek() != '?') {
            next = TextIO.getAnyChar();
            buffer = buffer + next;
        }
        if(TextIO.peek()=='~') {
            TextIO.getAnyChar(); //dispose of the comma
        }
        //TextIO.put(buffer + ";"); debug purposes only
        return buffer;
    }
    public static void createEnchantmentList() {
        TextIO.readFile("enchantments.txt");
        TextIO.getln();
        while(TextIO.eof()==false) {
            Enchantment thisenchantment = new Enchantment();
            thisenchantment.ID = Integer.parseInt(nextWord());
            thisenchantment.name = nextWord();
            EnchantmentNames.add(thisenchantment.ID,thisenchantment.name);
            thisenchantment.enhancementamount = Integer.parseInt(nextWord());
            thisenchantment.setcost = Double.parseDouble(nextWord());
            thisenchantment.armor = Boolean.parseBoolean(nextWord());
            thisenchantment.shield = Boolean.parseBoolean(nextWord());
            thisenchantment.meleeweapon = Boolean.parseBoolean(nextWord());
            thisenchantment.rangedweapon = Boolean.parseBoolean(nextWord());
            thisenchantment.description = nextWord();
            thisenchantment.code = nextWord();
            TextIO.getln();
            EnchantmentList.add(thisenchantment);
        }
        TextIO.readStandardInput();
    }
    public static ArrayList<Enchantment> getEnchantmentList() {
        return EnchantmentList;
    }
    public static String[] getArmorEnchantmentNames() {
        String[] names = new String[EnchantmentNames.size()];
        for(int x = 0;x<names.length;x++) {
            if(EnchantmentList.get(x).armor) {
                names[x] = EnchantmentNames.get(x);
            }
        }
        return names;
    }
    public static String[] getShieldEnchantmentNames() {
        String[] names = new String[EnchantmentNames.size()];
        for(int x = 0;x<names.length;x++) {
            if(EnchantmentList.get(x).shield) {
                names[x] = EnchantmentNames.get(x);
            }
        }
        return names;
    }
    public static String[] getMeleeEnchantmentNames() {
        String[] names = new String[EnchantmentNames.size()];
        for(int x = 0;x<names.length;x++) {
            if(EnchantmentList.get(x).meleeweapon) {
                names[x] = EnchantmentNames.get(x);
            }
        }
        return names;
    }
    public static String[] getRangedEnchantmentNames() {
        String[] names = new String[EnchantmentNames.size()];
        for(int x = 0;x<names.length;x++) {
            if(EnchantmentList.get(x).rangedweapon) {
                names[x] = EnchantmentNames.get(x);
            }
        }
        return names;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ddgame;
import TextIO.TextIO;
import java.util.ArrayList;

/**
 *
 * @author Joe
 */
public class Armor {
    public int ID;
    public String ArmorName;
    public double weight;
    public int ACbonus;
    public Integer maxDexBonus;
    public int arcaneFailure;
    public int armorCheckPenalty;
    public double basecost;
    public static enum ArmorType {heavy, medium, light, unarmored, lightShield, heavyShield, towerShield}
    public static enum ArmorMaterial {standard, cloth, wood, leather, steel, mithril, adamantine, dragonhide, darkwood}
    public static enum ArmorAttack {none, spiked};
    public ArmorAttack armorAttack;
    public ArmorMaterial armorMaterial;
    public ArmorType armorType;
    public static enum Enhancement {standard, masterwork, plus1, plus2, plus3, plus4, plus5 };
    public Enhancement enhancementBonus;
    public static ArrayList<String> ArmorNameList = new ArrayList<>();
    public int enchantment1;
    public int enchantment2;
    public int enchantment3;
    public static ArrayList<Armor> ArmorList = new ArrayList<>();
    public static ArrayList<Armor> ShieldList = new ArrayList<>();
    public static ArrayList<String> ShieldNameList = new ArrayList<>();
    
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
    public static String[] getArmorNameListArray() {
        String[] ArmorNamesList = new String[ArmorNameList.size()];
        for(int x = 0;x<ArmorNamesList.length;x++) {
            ArmorNamesList[x] = ArmorNameList.get(x);
        }
        return ArmorNamesList;
    }
    public static String[] getShieldNameListArray() {
        String[] ShieldNamesList = new String[ShieldNameList.size()];
        for(int x = 0;x<ShieldNamesList.length;x++) {
            ShieldNamesList[x] = ShieldNameList.get(x);
        }
        return ShieldNamesList;
    }
    public static void createArmorList() {
        TextIO.readFile("armor.txt");
        TextIO.getln();
        TextIO.writeFile("armordebug.txt");
        while(TextIO.eof()==false) {
            Armor buffer = new Armor();
            buffer.ID = Integer.parseInt(nextWord());
            buffer.ArmorName = nextWord();
            ArmorNameList.add(buffer.ArmorName);
            String debugger = nextWord();
            TextIO.put(debugger);
            buffer.basecost = Integer.parseInt(debugger);
            buffer.ACbonus = Integer.parseInt(nextWord());
            String nexty = nextWord();
            if(nexty.equals("")) { 
                buffer.maxDexBonus = Integer.MAX_VALUE;
            }
            else {
                buffer.maxDexBonus = Integer.parseInt(nexty);
            }
            buffer.armorCheckPenalty = Integer.parseInt(nextWord());
            buffer.arcaneFailure = Integer.parseInt(nextWord());
            buffer.weight = Double.parseDouble(nextWord());
            buffer.armorMaterial = ArmorMaterial.valueOf(nextWord());
            buffer.armorType = ArmorType.valueOf(nextWord());
            buffer.enhancementBonus = Enhancement.valueOf(nextWord());
            buffer.enchantment1 = Integer.parseInt(nextWord());
            buffer.enchantment2 = Integer.parseInt(nextWord());
            buffer.enchantment3 = Integer.parseInt(nextWord());
            ArmorList.add(buffer);
            TextIO.getln();
        }
        TextIO.readStandardInput();
    }
    public static void createShieldList() {
        TextIO.readFile("shields.txt");
        TextIO.getln();
        TextIO.writeFile("shielddebug.txt");
        while(TextIO.eof()==false) {
            Armor buffer = new Armor();
            buffer.ID = Integer.parseInt(nextWord());
            buffer.ArmorName = nextWord();
            ShieldNameList.add(buffer.ArmorName);
            String debugger = nextWord();
            TextIO.put(debugger);
            buffer.basecost = Integer.parseInt(debugger);
            buffer.ACbonus = Integer.parseInt(nextWord());
            String nexty = nextWord();
            if(nexty.equals("")) { 
                buffer.maxDexBonus = Integer.MAX_VALUE;
            }
            else {
                buffer.maxDexBonus = Integer.parseInt(nexty);
            }
            buffer.armorCheckPenalty = Integer.parseInt(nextWord());
            buffer.arcaneFailure = Integer.parseInt(nextWord());
            buffer.weight = Integer.parseInt(nextWord());
            buffer.armorMaterial = ArmorMaterial.valueOf(nextWord());
            buffer.armorType = ArmorType.valueOf(nextWord());
            buffer.enhancementBonus = Enhancement.valueOf(nextWord());
            buffer.enchantment1 = Integer.parseInt(nextWord());
            buffer.enchantment2 = Integer.parseInt(nextWord());
            buffer.enchantment3 = Integer.parseInt(nextWord());
            ShieldList.add(buffer);
            TextIO.getln();
        }
        TextIO.readStandardInput();
        TextIO.writeStandardOutput();
    }
    public static Armor copy(Armor original) {
        Armor newarmor = new Armor();
        newarmor.armorType = original.armorType;
        newarmor.ACbonus = original.ACbonus;
        newarmor.ID = original.ID;
        newarmor.ArmorName = original.ArmorName;
        newarmor.arcaneFailure = original.arcaneFailure;
        newarmor.armorAttack = original.armorAttack;
        newarmor.armorCheckPenalty = original.armorCheckPenalty;
        newarmor.armorMaterial = original.armorMaterial;
        newarmor.basecost = original.basecost;
        newarmor.enchantment1 = original.enchantment1;
        newarmor.enchantment2 = original.enchantment2;
        newarmor.enchantment3 = original.enchantment3;
        newarmor.enhancementBonus = original.enhancementBonus;
        newarmor.maxDexBonus = original.maxDexBonus;
        newarmor.weight = original.weight;
        return newarmor;
    }
    public void setArmorValues(PlayerChar curChar) {
        //things that change armor check penalty
        int totalenhancement = 0;
        if(this.enhancementBonus != Enhancement.standard && this.armorMaterial.equals(ArmorList.get(ID).armorMaterial)) {
            this.armorCheckPenalty -= 1;
            this.basecost +=150;
        }
        else if(this.armorMaterial.equals(ArmorMaterial.mithril) || this.armorMaterial.equals(ArmorMaterial.darkwood)) {
            this.armorCheckPenalty -= 2;
            if(this.armorMaterial.equals(ArmorMaterial.mithril)) {
                this.maxDexBonus+=2;
                this.arcaneFailure-=10;
                if(this.armorType.equals(ArmorType.heavy)) {
                    basecost+=9000;
                }
                else if(this.armorType.equals(ArmorType.medium)) {
                    basecost+=4000;
                }
                else {
                    basecost+=1000;
                }
            }
            else {
                this.basecost += 150 + this.weight*10;
                this.weight *= 0.5;
            }
        }
        if(this.enhancementBonus.equals(Enhancement.plus1)) {
            totalenhancement++;
            this.ACbonus +=1;
        }
        else if(this.enhancementBonus.equals(Enhancement.plus2)) {
            totalenhancement+=2;
            this.ACbonus +=2;
        }
        else if(this.enhancementBonus.equals(Enhancement.plus3)) {
            totalenhancement+=3;
            this.ACbonus +=3;
        }
        else if(this.enhancementBonus.equals(Enhancement.plus4)) {
            totalenhancement+=4;
            this.ACbonus +=4;
        }
        else if(this.enhancementBonus.equals(Enhancement.plus5)) {
            totalenhancement+=5;
            this.ACbonus +=5;
        }
        if(this.armorMaterial.equals(ArmorMaterial.adamantine)) {
            if(this.armorType.equals(ArmorType.light) || this.armorType.equals(ArmorType.lightShield)) {
                this.basecost+=5000;
            }
            else if(this.armorType.equals(ArmorType.medium) || this.armorType.equals(ArmorType.heavyShield)) {
                this.basecost+=10000;
            }
            else if(this.armorType.equals(ArmorType.heavy)) {
                this.basecost+=15000;
            }
        }
        if(armorMaterial.equals(ArmorMaterial.dragonhide)) {
            basecost*=2;
        }
        if(armorAttack.equals(ArmorAttack.spiked)) {
            if(armorType.equals(ArmorType.light) || armorType.equals(ArmorType.medium) || armorType.equals(ArmorType.heavy)) {
                weight+=10;
            }
            else {
                weight+=5;
            }
        }
        if(curChar.race.getSizeMod()<=-2) {
            weight*=0.1;
            basecost*=0.5;
            ACbonus*=0.5;
        }
        else if(curChar.race.getSizeMod()==-1) {
            weight*=0.5;
        }
        else if(curChar.race.getSizeMod()==1) {
            weight*=2;
            basecost*=2;
        }
        else if(curChar.race.getSizeMod()==2) {
            weight*=5;
            basecost*=4;
        }
        else if(curChar.race.getSizeMod()==3) {
            weight*=8;
            basecost*=8;
        }
        else if(curChar.race.getSizeMod()==4) {
            weight*=12;
            basecost*=16;
        }
        totalenhancement+=Enchantment.EnchantmentList.get(enchantment1).enhancementamount;
        totalenhancement+=Enchantment.EnchantmentList.get(enchantment2).enhancementamount;
        totalenhancement+=Enchantment.EnchantmentList.get(enchantment3).enhancementamount;
        basecost+=Enchantment.EnchantmentList.get(enchantment1).setcost;
        basecost+=Enchantment.EnchantmentList.get(enchantment2).setcost;
        basecost+=Enchantment.EnchantmentList.get(enchantment3).setcost;
        basecost+= totalenhancement*totalenhancement*1000;
        curChar.EquipmentBonuses.add(Enchantment.EnchantmentList.get(enchantment1));
        curChar.EquipmentBonuses.add(Enchantment.EnchantmentList.get(enchantment2));
        curChar.EquipmentBonuses.add(Enchantment.EnchantmentList.get(enchantment3));
    }
}

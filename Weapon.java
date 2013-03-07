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
public class Weapon {
    protected int ID;
    protected String WeaponName;
    protected int numAttackDice;
    protected int dieSize;
    protected double basecost;
    protected int critmin;
    protected int critmult;
    protected int rangeincrement;
    protected int attackbonus;
    protected int damagebonus;
    protected double weight;
    protected DamageType damagetype1;
    protected DamageType damagetype2;
    protected WeaponType weapontype;
    protected Size weaponsize;
    protected boolean simpleWeapon;
    protected boolean martialWeapon;
    protected boolean exoticWeapon;
    protected boolean rogueWeapon;
    protected boolean wizardWeapon;
    protected boolean monkWeapon;
    protected boolean druidWeapon;
    protected boolean bardWeapon;
    protected static enum DamageType {bludgeoning, piercing, slashing, none};
    protected static enum Size {medium, fine, diminutive, tiny, small, large, huge, gargantuan, colossal};
    protected static enum WeaponType {unarmed, light, onehanded, twohanded, thrown, ranged};
    protected static enum WeaponMaterial {standard, wood, leather, steel, mithril, adamantine, coldIron, silver, darkwood};
    protected static enum Enhancement {standard, masterwork, plus1, plus2, plus3, plus4, plus5};
    protected WeaponMaterial weaponMaterial;
    protected Enhancement enhancementbonus;
    protected Integer enchantment1;
    protected Integer enchantment2;
    protected Integer enchantment3;
    protected static ArrayList<Weapon> WeaponList = new ArrayList<>();
    protected static ArrayList<String> WeaponNames = new ArrayList<>();
    
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
        
    protected static void createWeaponList() {
        TextIO.readFile("weapons.txt");
        TextIO.getln();
        while(TextIO.eof()==false) {
            Weapon thisweapon = new Weapon();
            thisweapon.ID = Integer.parseInt(nextWord());
            thisweapon.WeaponName = nextWord();
            WeaponNames.add(thisweapon.ID,thisweapon.WeaponName);
            thisweapon.basecost = Double.parseDouble(nextWord());
            thisweapon.numAttackDice = Integer.parseInt(nextWord());
            thisweapon.dieSize = Integer.parseInt(nextWord());
            thisweapon.critmin = Integer.parseInt(nextWord());
            thisweapon.critmult = Integer.parseInt(nextWord());
            thisweapon.rangeincrement = Integer.parseInt(nextWord());
            thisweapon.weight = Double.parseDouble(nextWord());
            thisweapon.damagetype1 = DamageType.valueOf(nextWord());
            thisweapon.damagetype2 = DamageType.valueOf(nextWord());
            thisweapon.weapontype = WeaponType.valueOf(nextWord());
            thisweapon.weaponsize = Size.valueOf(nextWord());
            thisweapon.simpleWeapon = Boolean.parseBoolean(nextWord());
            thisweapon.martialWeapon = Boolean.parseBoolean(nextWord());
            thisweapon.exoticWeapon = Boolean.parseBoolean(nextWord());
            thisweapon.rogueWeapon = Boolean.parseBoolean(nextWord());
            thisweapon.wizardWeapon = Boolean.parseBoolean(nextWord());
            thisweapon.monkWeapon = Boolean.parseBoolean(nextWord());
            thisweapon.druidWeapon = Boolean.parseBoolean(nextWord());
            thisweapon.bardWeapon = Boolean.parseBoolean(nextWord());
            thisweapon.weaponMaterial = WeaponMaterial.valueOf(nextWord());
            thisweapon.enhancementbonus = Enhancement.valueOf(nextWord());
            thisweapon.enchantment1 = Integer.parseInt(nextWord());
            thisweapon.enchantment2 = Integer.parseInt(nextWord());
            thisweapon.enchantment3 = Integer.parseInt(nextWord());
            WeaponList.add(thisweapon);
            TextIO.getln();
        }
        TextIO.readStandardInput();
    }
    protected static String[] getWeaponNames() {
        String[] names = new String[WeaponNames.size()];
        for(int x = 0;x<names.length;x++) {
            names[x] = WeaponNames.get(x);
        }
        return names;
    }
    protected static Weapon copy(Weapon original) {
        Weapon newweapon = new Weapon();
        newweapon.ID = original.ID;
        newweapon.WeaponName = original.WeaponName;
        newweapon.bardWeapon = original.bardWeapon;
        newweapon.basecost = original.basecost;
        newweapon.critmin = original.critmin;
        newweapon.critmult = original.critmult;
        newweapon.damagetype1 = original.damagetype1;
        newweapon.damagetype2 = original.damagetype2;
        newweapon.dieSize = original.dieSize;
        newweapon.druidWeapon = original.druidWeapon;
        newweapon.enchantment1 = original.enchantment1;
        newweapon.enchantment2 = original.enchantment2;
        newweapon.enchantment3 = original.enchantment3;
        newweapon.enhancementbonus = original.enhancementbonus;
        newweapon.exoticWeapon = original.exoticWeapon;
        newweapon.martialWeapon = original.martialWeapon;
        newweapon.monkWeapon = original.monkWeapon;
        newweapon.numAttackDice = original.numAttackDice;
        newweapon.rangeincrement = original.rangeincrement;
        newweapon.rogueWeapon = original.rogueWeapon;
        newweapon.simpleWeapon = original.simpleWeapon;
        newweapon.weaponMaterial = original.weaponMaterial;
        newweapon.weaponsize = original.weaponsize;
        newweapon.weapontype = original.weapontype;
        newweapon.weight = original.weight;
        newweapon.wizardWeapon = original.wizardWeapon;
        return newweapon;
    }
    protected void alterWeaponSize(PlayerChar curChar) {
        int sizechange = 0;
        if(weaponsize.equals(Size.small)) {
            sizechange--;
            weight*=0.5;
            if(curChar.race.getSizeMod()==-2 || curChar.race.getSizeMod()==0) {
                attackbonus-=2;
            }
            else if(curChar.race.getSizeMod()==-1) {}
            else {
                attackbonus-=50;
            }
        }
        else if(weaponsize.equals(Size.tiny)) {
            sizechange-=2;
            basecost*=0.5;
            weight*=0.1;
            if(curChar.race.getSizeMod()==-3 || curChar.race.getSizeMod()==-1) {
                attackbonus-=2;
            }
            else if(curChar.race.getSizeMod()==-2) {}
            else {
                attackbonus-=50;
            }
        }
        else if(weaponsize.equals(Size.diminutive)) {
            sizechange-=3;
            basecost*=0.5;
            weight*=0.1;
            if(curChar.race.getSizeMod()==-4 || curChar.race.getSizeMod()==-2) {
                attackbonus-=2;
            }
            else if(curChar.race.getSizeMod()==-3) {}
            else {
                attackbonus-=50;
            }
        }
        else if(weaponsize.equals(Size.fine)) {
            sizechange-=4;
            basecost*=0.5;
            weight*=0.1;
            if(curChar.race.getSizeMod()==-3) {
                attackbonus-=2;
            }
            else if(curChar.race.getSizeMod()==-4) {}
            else {
                attackbonus-=50;
            }
        }
        else if(weaponsize.equals(Size.large)) {
            sizechange+=1;
            basecost*=2;
            weight*=2;
            if(curChar.race.getSizeMod()==0 || curChar.race.getSizeMod()==2) {
                attackbonus-=2;
            }
            else if(curChar.race.getSizeMod()==1) {}
            else {
                attackbonus-=50;
            }
        }
        else if(weaponsize.equals(Size.huge)) {
            sizechange+=2;
            basecost*=4;
            weight*=5;
            if(curChar.race.getSizeMod()==1 || curChar.race.getSizeMod()==3) {
                attackbonus-=2;
            }
            else if(curChar.race.getSizeMod()==2) {}
            else {
                attackbonus-=50;
            }
        }
        else if(weaponsize.equals(Size.gargantuan)) {
            sizechange+=3;
            basecost*=8;
            weight*=8;
            if(curChar.race.getSizeMod()==2 || curChar.race.getSizeMod()==4) {
                attackbonus-=2;
            }
            else if(curChar.race.getSizeMod()==3) {}
            else {
                attackbonus-=50;
            }
        }
        else if(weaponsize.equals(Size.colossal)) {
            sizechange+=4;
            basecost*=16;
            weight*=12;
            if(curChar.race.getSizeMod()==3) {
                attackbonus-=2;
            }
            else if(curChar.race.getSizeMod()==4) {}
            else {
                attackbonus-=50;
            }
        }
        else if(weaponsize.equals(Size.medium)) {
            if(curChar.race.getSizeMod()==-1 || curChar.race.getSizeMod()==1) {
                attackbonus-=2;
            }
            else if(curChar.race.getSizeMod()==0) {}
            else {
                attackbonus-=50;
            }
        }
        while(sizechange<0) {
            if(numAttackDice==1) {
                if(dieSize==2) {
                    dieSize=1;
                }
                else if(dieSize==3) {
                    dieSize=2;
                }
                else if(dieSize==4) {
                    dieSize=3;
                }
                else if(dieSize==6) {
                    dieSize=4;
                }
                else if(dieSize==8) {
                    dieSize=6;
                }
                else if(dieSize==10) {
                    dieSize=8;
                }
                else if(dieSize==12) {
                    dieSize=10;
                }
            }
            else if(numAttackDice==2) {
                if(dieSize==4) {
                    numAttackDice=1;
                    dieSize=6;
                }
                else if(dieSize==6) {
                    numAttackDice=1;
                    dieSize=10;
                }
                else if(dieSize==8) {
                    dieSize=6;
                }
                else if(dieSize==10) {
                    dieSize=8;
                }
            }
            sizechange++;
        }
        while(sizechange>0) {
            if(numAttackDice==1) {
                if(dieSize==2) {
                    dieSize=3;
                }
                else if(dieSize==3) {
                    dieSize=4;
                }
                else if(dieSize==4) {
                    dieSize=6;
                }
                else if(dieSize==6) {
                    dieSize=8;
                }
                else  if(dieSize==8) {
                    dieSize=6;
                    numAttackDice=2;
                }
                else if(dieSize==10) {
                    dieSize=8;
                    numAttackDice=2;
                }
                else if(dieSize==12) {
                    dieSize=6;
                    numAttackDice=3;
                }
            }
            else if(numAttackDice==2) {
                if(dieSize==4) {
                    dieSize=6;
                }
                else if(dieSize==6 || dieSize==8) {
                    numAttackDice=3;
                }
                else if(dieSize==10) {
                    numAttackDice=4;
                    dieSize=8;
                }
            }
            else if(numAttackDice==3) {
                numAttackDice++;
            }
            else if(numAttackDice>=4) {
                numAttackDice+=2;
            }
            weight*=2;
            sizechange--;
        }
    }
    protected void setWeaponValues(PlayerChar curChar) {
        alterWeaponSize(curChar);
        int totalEnhancement = 0;
        attackbonus -= 4;
        attackbonus += curChar.BAB;
        if(weapontype.equals(WeaponType.ranged) || weapontype.equals(WeaponType.thrown)) {
            attackbonus += curChar.bonusarray[1];
            if(weapontype.equals(WeaponType.thrown)) {
                damagebonus += curChar.bonusarray[0];
            }
        }
        else if((weapontype.equals(WeaponType.light) || ID == 38 || ID == 69 || 
                ID == 71) && curChar.Feats.contains(CharAbility.getFeatsList().get(128)) 
                && curChar.bonusarray[1] > curChar.bonusarray[0]) {
            attackbonus += curChar.bonusarray[1];
            damagebonus += curChar.bonusarray[0];
        }
        else {
            attackbonus += curChar.bonusarray[0];
            damagebonus += curChar.bonusarray[0];
        }
        for(int x = 0; x<curChar.Classes.size();x++) {
            CharAbility[] martialWeaponFeats = {CharAbility.getFeatsList().get(75), CharAbility.getFeatsList().get(76), CharAbility.getFeatsList().get(77)};
            CharAbility[] exoticWeaponFeats = {CharAbility.getFeatsList().get(30), CharAbility.getFeatsList().get(31), CharAbility.getFeatsList().get(32), CharAbility.getFeatsList().get(33)};
            CharAbility[] simpleWeaponFeats = {CharAbility.getFeatsList().get(100), CharAbility.getFeatsList().get(101), CharAbility.getFeatsList().get(102)};
            if((((curChar.Classes.get(x).getSimpleWeaponProf() && curChar.Classes.get(x).getLevel()>0) 
                        || curChar.Feats.contains(simpleWeaponFeats[0]) 
                        || curChar.Feats.contains(simpleWeaponFeats[1]) 
                        || curChar.Feats.contains(simpleWeaponFeats[2])) && simpleWeapon)
                    || (((curChar.Classes.get(x).getMartialWeaponProf() && curChar.Classes.get(x).getLevel()>0) 
                        || curChar.Feats.contains(martialWeaponFeats[0]) 
                        || curChar.Feats.contains(martialWeaponFeats[1]) 
                        || curChar.Feats.contains(martialWeaponFeats[2])) && martialWeapon)
                    || (curChar.Classes.get(x).getRogueWeaponProf() && rogueWeapon && curChar.Classes.get(x).getLevel()>0)
                    || (curChar.Classes.get(x).getWizardWeaponProf() && wizardWeapon && curChar.Classes.get(x).getLevel()>0)
                    || (curChar.Classes.get(x).getBardWeaponProf() && bardWeapon && curChar.Classes.get(x).getLevel()>0)
                    || (curChar.Classes.get(x).getDruidWeaponProf() && druidWeapon && curChar.Classes.get(x).getLevel()>0)
                    || (curChar.Classes.get(x).getMonkWeaponProf() && monkWeapon && curChar.Classes.get(x).getLevel()>0)
                    || ((curChar.Feats.contains(exoticWeaponFeats[0])
                        || curChar.Feats.contains(exoticWeaponFeats[1])
                        || curChar.Feats.contains(exoticWeaponFeats[2])
                        || curChar.Feats.contains(exoticWeaponFeats[3]))
                        && exoticWeapon)) {
                
                attackbonus+=4;
                break;
            }
        }
        for(int x = 0; x<curChar.Classes.size();x++) {
            if(curChar.Classes.get(x).getLevel()>0) {
                if((curChar.Classes.get(x).getLightArmorProf()==false && curChar.armor.armorType.equals(Armor.ArmorType.light))
                        || (curChar.Classes.get(x).getMediumArmorProf()==false && curChar.armor.armorType.equals(Armor.ArmorType.medium))
                        || (curChar.Classes.get(x).getHeavyArmorProf()==false && curChar.armor.armorType.equals(Armor.ArmorType.heavy))) {
                    attackbonus-=curChar.armor.armorCheckPenalty;
                    break;
                }
            }
        }
        for(int x = 0; x<curChar.Classes.size();x++) {
            if(curChar.Classes.get(x).getLevel()>0) {
                if((curChar.Classes.get(x).getLightShieldProf()==false && curChar.shield.armorType.equals(Armor.ArmorType.lightShield))
                    || (curChar.Classes.get(x).getHeavyShieldProf()==false && curChar.shield.armorType.equals(Armor.ArmorType.heavyShield))
                    || (curChar.Classes.get(x).getTowerShieldProf()==false && curChar.shield.armorType.equals(Armor.ArmorType.towerShield))) {
                attackbonus-=curChar.armor.armorCheckPenalty;
                break;
                }
            }
        }
        if(enhancementbonus.equals(Enhancement.masterwork)) {
            attackbonus++;
            if(weaponMaterial.equals(WeaponMaterial.steel) || weaponMaterial.equals(WeaponMaterial.leather) || weaponMaterial.equals(WeaponMaterial.wood) || weaponMaterial.equals(WeaponMaterial.standard)) {
                basecost+=150;
            }
        }
        else if(enhancementbonus.equals(Enhancement.plus1)) {
            attackbonus++;
            damagebonus++;
            totalEnhancement+=1;
        }
        else if(enhancementbonus.equals(Enhancement.plus2)) {
            attackbonus+=2;
            damagebonus+=2;
            totalEnhancement+=2;
        }
        else if(enhancementbonus.equals(Enhancement.plus3)) {
            attackbonus+=3;
            damagebonus+=3;
            totalEnhancement+=3;
        }
        else if(enhancementbonus.equals(Enhancement.plus4)) {
            attackbonus+=4;
            damagebonus+=4;
            totalEnhancement+=4;
        }
        else if(enhancementbonus.equals(Enhancement.plus5)) {
            attackbonus+=5;
            damagebonus+=5;
            totalEnhancement+=5;
        }
        if(weaponMaterial.equals(WeaponMaterial.darkwood)) {
            basecost+=150;
            basecost+=10*weight;
            weight*=0.5;
            
        }
        else if(weaponMaterial.equals(WeaponMaterial.adamantine)) {
            basecost+=3000;
        }
        else if(weaponMaterial.equals(WeaponMaterial.coldIron)) {
            basecost*=2;
            if(enhancementbonus!=Enhancement.masterwork && enhancementbonus != Enhancement.standard) {
                basecost+=2000;
            }
            if(enchantment1 != 0) {
                basecost+=2000;
            }
            if(enchantment2 != 0) {
                basecost+=2000;
            }
            if(enchantment3 != 0) {
                basecost+=2000;
            }
        }
        else if(weaponMaterial.equals(WeaponMaterial.mithril)) {
            basecost+=500*weight;
            weight*=0.5;
        }
        else if(weaponMaterial.equals(WeaponMaterial.silver)) {
            damagebonus-=1;
            if(weapontype.equals(WeaponType.light)) {
                basecost+=20;
            }
            if(weapontype.equals(WeaponType.onehanded) || weapontype.equals(WeaponType.thrown)) {
                basecost+=90;
            }
            if(weapontype.equals(WeaponType.twohanded) || weapontype.equals(WeaponType.ranged)) {
                basecost+=180;
            }
        }
        totalEnhancement += Enchantment.EnchantmentList.get(enchantment1).enhancementamount;
        totalEnhancement += Enchantment.EnchantmentList.get(enchantment2).enhancementamount;
        totalEnhancement += Enchantment.EnchantmentList.get(enchantment3).enhancementamount;
        basecost += Enchantment.EnchantmentList.get(enchantment1).setcost;
        basecost += Enchantment.EnchantmentList.get(enchantment2).setcost;
        basecost += Enchantment.EnchantmentList.get(enchantment3).setcost;
        basecost += totalEnhancement*totalEnhancement*2000;
        curChar.EquipmentBonuses.add(Enchantment.EnchantmentList.get(enchantment1));
        curChar.EquipmentBonuses.add(Enchantment.EnchantmentList.get(enchantment2));
        curChar.EquipmentBonuses.add(Enchantment.EnchantmentList.get(enchantment3));
    }
}

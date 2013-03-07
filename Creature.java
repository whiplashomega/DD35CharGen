/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ddgame;
import TextIO.*;
import java.util.ArrayList;

/**
 *The creature class is used to create a new Creature object containing all of 
 * the basic information for a new creature using D&D 3.5 rules
 * @author Joe
 */
public class Creature {
    //every creature has a name!
    public String name = "";
    /**
     * basic stats, in order strength, dexterity, constitution, 
     *intelligence, wisdom, charisma
    */
    public int[] effectivestatarray = {0,0,0,0,0,0};
    public int[] statarray = {0,0,0,0,0,0};
    public int[] basestatarray = {0,0,0,0,0,0};
    //attack bonuses
    public int BAB = 0;
    //saves
    public int willSave = 0;
    public int reflexSave = 0;
    public int fortitudeSave = 0;
    //calculated attack values
    public int meleeAttack = 0;
    public int rangeAttack = 0;
    public int grapple = 0;
    public int tripAttack = 0;
    public int bullRushAttack = 0;
    public int overrunAttack = 0;
    public int tripDefense = 0;
    public int bullRushDefense = 0;
    public int overrunDefense = 0;
    //AC and bonuses
    public int AC = 10;
    public int ACTouch = 10;
    public int ACFlatFooted = 10;
    public int miscACBonus = 0;
    public int dodgeACBonus = 0;
    //HP
    public int HPCurrent = 0;
    public int HPMax = 0;
    public int[] storedHPTotals = new int[20];
    //skills
    public double[] skillRanks = new double[79];
    public int[] miscSkillBonus = new int[79];
    public int[] competenceSkillBonus = new int[79];
    public int[] skillAbilityMods = new int[79];
    public int[] skillModifiers = new int[79];
    public ArrayList<Integer> skillAttributeArray = new ArrayList<>();
    public ArrayList<String> skillNames = new ArrayList<>();
    //speed
    public int charSpeed;
    //Abilities and feats
    public ArrayList<Boolean> featsSelected = new ArrayList<>();
    public ArrayList<CharAbility> RaceAbilities = new ArrayList<>();
    public ArrayList<CharAbility> Feats = new ArrayList<>();
    public double totalweightcarried = 0;
    public int lightload = 0;
    public int mediumload = 0;
    public int heavyload = 0;
    /**
     * stat bonuses, calculated from statarray, in order strength, dexterity,
     * constitution, intelligence, wisdom, charisma
     */
    public int[] bonusarray = {-5,-5,-5,-5,-5,-5};
    public CharRace race;
    public int racenum = 0; //an integer that when used as the index with racelist
    public Armor armor = new Armor();
    public Armor shield = new Armor();
    public Weapon[] weapons = new Weapon[4];
    //should produce the creatures race.
    /**
     * This method uses the objects values for strength, dexterity, constitution
     * intelligence, wisdom, and charisma contained in statarray
     * to calculate the related strength
     * bonus etc.
     */
    public void loadcalc() {
        if(statarray[0]<=10) {
            heavyload=statarray[0]*10;
        }
        else {
            double stuff = Math.round(20*Math.pow(Math.pow(2, 0.2),statarray[0]-10));
            heavyload = (int)stuff*5;
        }
        mediumload=heavyload*2/3;
        lightload=heavyload*1/3;
    }
    public void encumbrancecalc() {
        if(totalweightcarried>mediumload || armor.armorType.equals(Armor.ArmorType.heavy)) {
            armor.maxDexBonus = Math.max(armor.maxDexBonus, 1);
            armor.armorCheckPenalty = Math.min(armor.armorCheckPenalty, -6);
            int temp = charSpeed/5;
            temp*=0.67;
            charSpeed = temp*5;
        }
        else if(totalweightcarried>lightload || armor.armorType.equals(Armor.ArmorType.medium)) {
            armor.maxDexBonus = Math.max(armor.maxDexBonus,3);
            armor.armorCheckPenalty = Math.min(armor.maxDexBonus,-3);
            int temp = charSpeed/5;
            temp*=0.67;
            charSpeed = temp*5;
        }
        else if(totalweightcarried>heavyload) {
            armor.maxDexBonus = 0;
            armor.armorCheckPenalty = Math.min(armor.armorCheckPenalty, -6);
            charSpeed = 5;
        }
    }
    public void setstatarray (int[] stats) {
        statarray[0] = stats[0] + race.getRaceStr();
        statarray[1] = stats[1] + race.getRaceDex();
        statarray[2] = stats[2] + race.getRaceCon();
        statarray[3] = stats[3] + race.getRaceInt();
        statarray[4] = stats[4] + race.getRaceWis();
        statarray[5] = stats[5] + race.getRaceCha();
        System.arraycopy(statarray, 0, effectivestatarray, 0, statarray.length);
    } 
    public void setbonusarray () {
        
        for(int x=0;x<bonusarray.length;x++) {
            int buffer = (statarray[x]-10);
            if(buffer<0 && Math.abs(buffer%2)==1) {
                buffer--;
            }
            
            buffer = buffer/2;
            bonusarray[x] = (int)buffer;
        }
    }
    public void setBAB() { //this method should be implemented in child classes
        
    }
    public int getBAB() {
        return BAB;
    }
    public void setWillSave() { //method should be implemented in child classes
        
    }
    public int getWillSave() {
        return willSave;
    }
    public void setFortitudeSave() { //method should be implemented in child classes
        
    }
    public int getFortitudeSave() {
        return fortitudeSave;
    }
    public void setReflexSave() { //method should be implemented in child classes
        
    }
    public int getReflexSave() {
        return reflexSave;
    }
    public void setMeleeAttack() {
        meleeAttack = BAB + bonusarray[0] - race.getSizeMod();
    }
    public int getMeleeAttack() {
        return meleeAttack;
    }
    public void setRangeAttack() {
        rangeAttack = BAB + bonusarray[1] - race.getSizeMod();
    }
    public int getRangeAttack() {
        return rangeAttack;
    }
    public void setGrapple() {
        grapple = BAB + bonusarray[0] + race.getSizeMod()*4;
    }
    public int getGrapple() {
        return grapple;
    }
    public void setTripAttack() {
        tripAttack = bonusarray[0];
    }
    public int getTripAttack() {
        return tripAttack;
    }
    public ArrayList<CharAbility> getRaceAbilities() {
        return RaceAbilities;
    }
    public ArrayList<CharAbility> getFeats() {
        return Feats;
    }
    public void setTripDefense() {
        if(bonusarray[0]>=bonusarray[1]) {
            tripDefense = bonusarray[0];
        }
        else {
            tripDefense = bonusarray[1];
        }
    }
    public int getTripDefense() {
        return tripDefense;
    }
    public void setBullRushAttack() {
        bullRushAttack = bonusarray[0] + race.getSizeMod()*4;
    }
    public int getBullRushAttack() {
        return bullRushAttack;
    }
    public void setBullRushDefense() {
        bullRushDefense = bonusarray[0] + race.getSizeMod()*4;
    }
    public int getBullRushDefense() {
        return bullRushDefense;
    }
    public void setOverrunAttack() {
        overrunAttack = bonusarray[0] + race.getSizeMod()*4;
    }
    public int getOverrunAttack() {
        return overrunAttack;
    }
    public void setOverrunDefense() {
        if(bonusarray[0]>=bonusarray[1]) {
            overrunDefense = bonusarray[0] + race.getSizeMod()*4;
        }
        else {
            overrunDefense = bonusarray[1] + race.getSizeMod()*4;
        }
    }
    public int getOverrunDefense() {
        return overrunDefense;
    }
    public int getCharSpeed() {
        return charSpeed;
    }
    public void setSpeed() {
        charSpeed = race.getRaceSpeed();
    }
    public void setAC() {
        AC = 10 + armor.ACbonus + shield.ACbonus + bonusarray[1] + miscACBonus + dodgeACBonus - race.getSizeMod();
        ACTouch = 10 + bonusarray[1] + miscACBonus + dodgeACBonus - race.getSizeMod();
        ACFlatFooted = 10 + armor.ACbonus + shield.ACbonus + miscACBonus - race.getSizeMod();
        if(bonusarray[1]<0) {
            ACFlatFooted += bonusarray[1];
        }
    }
    public int getAC() {
        return AC;
    }
    public int getACTouch() {
        return ACTouch;
    }
    public int getACFlatFooted() {
        return ACFlatFooted;
    }
    public void setHPMax() { //should be overriden by subclasses
        
    }
    public int getHPMax() {
        return HPMax;
    }
    public void setCombatMods() {
        setBAB();
        setMeleeAttack();
        setRangeAttack();
        setGrapple();
        setTripAttack();
        setTripDefense();
        setBullRushAttack();
        setBullRushDefense();
        setOverrunAttack();
        setOverrunDefense();
        setAC();
    }
    public void setSkillNames() {
        TextIO.readFile("skillnames.txt");
        while(TextIO.eof()==false) {
            skillAttributeArray.add(Integer.parseInt(TextIO.getWord()));
            skillNames.add(TextIO.getln());
        }
        TextIO.readStandardInput();
    }
    /**
     * This static function creates the racelist to be referenced by all
     * creatures.  There is only one racelist that does not change, pulled from
     * a file whenever a new object of type creature is initialized.
     */

    /**
     * the constructor for the class creates a new creature for use, can either
     * specify a name immediately, which gets set to the variable name, or
     * call without any name for an unnamed creature. constructors based on this
     * should declare values for statarray and bonusarray, which have 6 values
     * each.
     */
    public Creature(String x) {
        name = x;
        for(int y = 0;y<statarray.length;y++) {
            statarray[y] = 0;
            bonusarray[y] = -5;
            CharRace.createRaceList();
        }
    }
    public Creature() {
        for(int y = 0;y<statarray.length;y++) {
            statarray[y] = 0;
            bonusarray[y] = -5;
            CharRace.createRaceList();
        }
    }
}

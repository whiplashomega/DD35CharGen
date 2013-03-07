/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ddgame;
import TextIO.*;
import java.util.ArrayList;

/**
 *
 * @author Joe
 */
public class CharClass{
    private String ClassName; //name of character class
    private int levels; //how many levels character has in class
    private int hitDie; //size of hit die for class, should be 4,6,8,10, or 12
    private int skillPoints; //base number of skill points per level 2,4,6, or 8
    private boolean lightArmorProf = false; //is it proficient with light armor
    private boolean mediumArmorProf = false; //is it proficient with medium armor
    private boolean heavyArmorProf = false; //is it proficient with heavy armor
    private boolean lightShieldProf = false; //is it proficient with light shields
    private boolean heavyShieldProf = false; //is it proficient with heavy shields
    private boolean towerShieldProf = false; //is it proficient with tower shields
    private boolean simpleWeaponProf = false; //is it proficient with simple weapons
    private boolean wizardWeaponProf = false; //is it proficient with wizard weapons
    private boolean rogueWeaponProf = false; //is it proficient with rogue weapons
    private boolean bardWeaponProf = false; //is it proficient with bard weapons
    private boolean monkWeaponProf = false; //is it proficient with monk weapons
    private boolean druidWeaponProf = false; //is it proficient with druid weapons
    private boolean martialWeaponProf = false; //is it proficient with martial weapons
    private double bab; //BAB per level, should be 0.5 0.75 or 1
    private double fortitude; //Fortitude save per level should be 0.5 or 0.34
    private double reflex; //reflex save per level should be 0.5 or 0.34
    private double will; //will save per level should be 0.5 or 0.34
    private boolean exRule = false; //can you be disqualified from this class
    private String castingStat; //what is the ability used for determining bonus spells per day
    private String castingSaveStat; //what is the ability used to determine saving through verse spells
    private int[][] spellsKnownTable = new int[20][10]; //table of spells known rows are class levels, columns are spell levels
    private int[][] spellsPerDayTable = new int[20][10]; //as above but spells per day
    private boolean[] ClassSkills = new boolean[79]; //which skills are class skills, as referenced to the AllSkills string array
    private ArrayList<Integer[]> ClassAbilities = new ArrayList<>(); //list of class abilities

    private static String[] AllSkills = new String[80]; //the static list of all skills
    private static ArrayList<CharClass> ClassList = new ArrayList<>(); //the static list of all character classes
    private static ArrayList<String> CharClassNames = new ArrayList<>(); //the static list of all the names of character classes
    private static String[] inputFiles = new String[12]; //holds the filenames for the CharClass tables
    /**
     * This static method when called should create the class list from a file, storing
     * it in ClassList and the reference names in CharClassNames.  It should only need
     * to be called once.
     */
    /**
     * 
     * @return the next word in the inputstream delimited by commas 
     */
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
    public static void CreateClassList() {
        TextIO.readFile("classes.txt"); //open the file for input
        TextIO.writeFile("debug.txt");
        TextIO.getln(); //skip the first line, it is labels
        while (TextIO.eof() == false) {
            CharClass temp = new CharClass();
                int ID = Integer.parseInt(nextWord());
                temp.ClassName = nextWord(); //first item in line is classname
                TextIO.put(temp.ClassName);
                CharClassNames.add(temp.ClassName); //need to index these seperately as well
                temp.levels = Integer.parseInt(nextWord()); //next thing is number of levels, usually 0
                temp.hitDie = Integer.parseInt(nextWord()); //next thing is the hit die size
                temp.skillPoints = Integer.parseInt(nextWord()); //then skill points
                //proficiencies
                temp.lightArmorProf = Boolean.parseBoolean(nextWord()); //can class use light armor
                temp.mediumArmorProf = Boolean.parseBoolean(nextWord()); //can class use medium armor
                temp.heavyArmorProf = Boolean.parseBoolean(nextWord()); //can class use heavy armor
                temp.lightShieldProf = Boolean.parseBoolean(nextWord()); //can class use light shields
                temp.heavyShieldProf = Boolean.parseBoolean(nextWord()); //can class use heavy shields
                temp.towerShieldProf = Boolean.parseBoolean(nextWord()); //can class use tower shields
                temp.simpleWeaponProf = Boolean.parseBoolean(nextWord()); //can class use simple weapons
                temp.wizardWeaponProf = Boolean.parseBoolean(nextWord()); //can class use wizard weapons
                temp.rogueWeaponProf = Boolean.parseBoolean(nextWord()); //can class use rogue weapons
                temp.bardWeaponProf = Boolean.parseBoolean(nextWord()); //can use bard weapons
                temp.druidWeaponProf = Boolean.parseBoolean(nextWord()); //can use druid weapons
                temp.monkWeaponProf = Boolean.parseBoolean(nextWord());
                temp.martialWeaponProf = Boolean.parseBoolean(nextWord()); //can class use martial weapons
                //and the doubles
                temp.bab = Double.parseDouble(nextWord()); //base attack bonus per level
                temp.fortitude = Double.parseDouble(nextWord()); //fortitude saving throw bonus per level
                temp.reflex = Double.parseDouble(nextWord()); //reflex saving throw bonus per level
                temp.will = Double.parseDouble(nextWord()); //will save bonus per level
                temp.exRule = Boolean.parseBoolean(nextWord()); //does the class have an ex-Rule
                temp.castingStat = nextWord(); //the casting stat
                temp.castingSaveStat = nextWord(); //the saving throw stat
                String spellsknown = nextWord();
                String spellsperday = nextWord();
                int index = 0;
                for (int y = 0; y < temp.spellsKnownTable.length; y++) {
                    for (int z = 0; z < temp.spellsKnownTable[y].length; z++) {
                        //TextIO.put(ClassList[x].spellsKnownTable[y].length);
                        temp.spellsKnownTable[y][z] = Integer.parseInt(spellsknown.substring(index, index+1)); //first the spells known table
                        TextIO.putln(index + ";" +spellsknown.substring(index, index+1));
                        index++;
                    }
               }
               index = 0;
                for (int y = 0; y < temp.spellsPerDayTable.length; y++) {
                    for (int z = 0; z < temp.spellsPerDayTable[y].length; z++) {
                        temp.spellsPerDayTable[y][z] = Integer.parseInt(spellsknown.substring(index, index+1)); //then the spells per day table
                        index++;
                    }
                }

                for (int y = 0; y < temp.ClassSkills.length; y++) {
                    if (nextWord().equals("TRUE")) { //excel booleans
                        temp.ClassSkills[y] = true; //class skills
                    } else {
                        temp.ClassSkills[y] = false; //non-class skills
                    }
                }
                TextIO.getln(); //move to next line, and next class
                for(int x = 0;x<CharAbility.getClassAbilities().size();x++) {
                    if(CharAbility.getClassAbilities().get(x)[0].compareTo(ID) == 0) {
                        Integer[] thisset = {CharAbility.getClassAbilities().get(x)[1],CharAbility.getClassAbilities().get(x)[2]};
                        temp.ClassAbilities.add(thisset);
                    }
                }
                ClassList.add(temp);
            }
        TextIO.readStandardInput(); //closes the file and returns input to standard, so that we can then read the tables
    }
    //Getter and Setter methods from here to constructors
    static public ArrayList<CharClass> getClassList() {
        return ClassList;
    }
    static public String[] getCharClassNames() {
        String[] ClassNames = new String[CharClassNames.size()];
        for(int x = 0;x<ClassNames.length;x++) {
            ClassNames[x] = CharClassNames.get(x);
        }
        return ClassNames;
    }
    public String getName () {
        return ClassName;
    }
    public void setLevel (int levelsInput) {
        levels = levelsInput;
    }
    public int getLevel () {
        return levels;
    }
    public int getHitDie () {
        return hitDie;
    }
    public int getSkillPoints () {
        return skillPoints;
    }
    public boolean getLightArmorProf () {
        return lightArmorProf;
    }
    public boolean getMediumArmorProf () {
        return mediumArmorProf;
    }
    public boolean getHeavyArmorProf() {
        return heavyArmorProf;
    }
    public boolean getLightShieldProf() {
        return lightShieldProf;
    }
    public boolean getHeavyShieldProf() {
        return heavyShieldProf;
    }
    public boolean getTowerShieldProf() {
        return towerShieldProf;
    }
    public boolean getSimpleWeaponProf() {
        return simpleWeaponProf;
    }
    public boolean getWizardWeaponProf() {
        return wizardWeaponProf;
    }
    public boolean getRogueWeaponProf() {
        return rogueWeaponProf;
    }
    public boolean getMartialWeaponProf() {
        return martialWeaponProf;
    }
    public boolean getBardWeaponProf() {
        return bardWeaponProf;
    }
    public boolean getDruidWeaponProf() {
        return druidWeaponProf;
    }
    public boolean getMonkWeaponProf() {
        return monkWeaponProf;
    }
    public double getBAB() {
        return bab;
    }
    public double getFortitude() {
        return fortitude;
    }
    public double getReflex() {
        return reflex;
    }
    public double getWill() {
        return will;
    }
    public boolean getExRule() {
        return exRule;
    }
    public boolean[] getClassSkills() {
        return ClassSkills;
    }
    public ArrayList<Integer[]> getClassAbilities() {
        return ClassAbilities;
    }
    public String getCastingStat() {
        return castingStat;
    }
    public String getCastingSaveStat() {
        return castingSaveStat;
    }
    public int[][] getSpellsKnownTable() {
        return spellsKnownTable;
    }
    public int[][] getSpellsPerDayTable() {
        return spellsPerDayTable;
    }
    public String[] getAllSkills() {
        return AllSkills;
    }
    static public void setAllSkills(String[] SkillList) {
        for(int x=0;x<SkillList.length && x<AllSkills.length; x++) {
            AllSkills[x] = SkillList[x];
        }
    }
    public void setClassName(String name) {
        ClassName = name;
    }
    public CharClass () {
        
    }
}

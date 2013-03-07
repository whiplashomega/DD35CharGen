package ddgame;
import TextIO.TextIO;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * PlayerChar is used to construct player characters, a subclass of creature.
 * Unlike creatures, PlayerChars have an experience value, level, and class levels.  This class
 * along with the creature class it extends, does most of the calculating, and calls
 *  a great deal of the calculations in the support classes.
 * @author Joe
 */
public class PlayerChar extends Creature {
    public int exp = 0; //entered by user, used by setLevel to determine level
    public int level = 1; //derived from exp, used for comparisons to see how which selected class levels are applicable
    public ArrayList<CharClass> Classes = new ArrayList<>(); //holds all of the classes this character has
    public int[] storedSelected = new int[20]; //stores the selected classes where index is the character level
    public int[] levelpoints = new int[21]; //the amounts of experience to add 1 to level.
    public boolean[][] classSkillArray = new boolean[79][21]; //for classSkillArray[x][y] true means that skill x is a class skill at level y
    public double[][] skillRanksByLevel = new double[79][20]; //similar to classSkillArray, but instead the distribution of skill ranks
    public ArrayList<CharAbility> ClassAbilities = new ArrayList<>(); //the characters class abilities
    public ArrayList<Enchantment> EquipmentBonuses = new ArrayList<>();
    public ArrayList<Integer> ClassCounter = new ArrayList<>(); //number of distinct classes
    public int totalClassLevels = 0; //total number of selected class levels
    public int[] DomainsSelected = new int[6];
    public int[] monkFeats = new int[3];
    public int[] favoredEnemySelected = new int[9];
    public int turnAttempts = 0;
    public int turnCheckMod = 0;
    public int turnDamageMod = 0;
    public int bonusFeats = 0;
    public int rangerCombatStyle = 0;
    public int[] allOtherSkillBonus = new int[79];
    public boolean[] rogueAbilities = new boolean[10];
    public int[] wizardSpecialty = new int[3];
    public ArrayList<double[]> itemweightvalues = new ArrayList<>();
    	/**
    	 * only called internally, used to set the players total level based on experience
    	 */
    private void setLevel() {
        level = (int)(-1+Math.sqrt(1+4*(((double)exp)/500)))/2+1;
    }
    /**
     * imports the class list into the player character.
     */
    private void createClasses() {
        for(int x = 0;x<CharClass.getClassList().size();x++) {
            Classes.add(x, (CharClass)CharClass.getClassList().get(x));
        }
    }
    /**
     * this method creates the Class Abilities list based on selected 
     * class levels and options.
     */
    private void setClassAbilities() {
        ClassAbilities.clear();
        for(CharAbility Ability : CharAbility.getAllAbilities()) {
            for(CharClass ThisClass : Classes) {
                for(int x = 0;x< ThisClass.getClassAbilities().size();x++) {
                    
                    if(ThisClass.getClassAbilities().get(x)[0]==Ability.getAbilityCode() 
                            && ThisClass.getLevel()>=ThisClass.getClassAbilities().get(x)[1]) {
                        ClassAbilities.add(Ability);
                    }
                }
            }
        }
    }
    /**
     * this method sets the characters race abilities based on the selected character race and options.
     */
    private void setRaceAbilities() {
        RaceAbilities.clear();
        for(CharAbility Ability : CharAbility.getAllAbilities()) {
            for(int x : race.getRaceAbilities()) {
                if(x==Ability.getAbilityCode()) {
                    RaceAbilities.add(Ability);
                }  
            }
        }
    }
    /**
     * set the character levels based on an array of selected values passed to it, and stores
     * those values for future use in storeSelected.  this method is called by the ClassUpdater and Updater
     * ClassUpdater passes the values from the JComboBoxes on that page, Updater passes the values in storedSelected
     * @param Selected the passed array of values, should be an array of integers with length 20
     */
    public void setCharLevels(int[] Selected) {
        totalClassLevels = 0;
        System.arraycopy(Selected, 0, storedSelected, 0, storedSelected.length);
        int[] numberSelectedPerClass = new int[Classes.size()];
        setLevel(); //make sure the character is at the correct level
        for(int x = 0; x<Selected.length;x++) {
            if(Selected[x]!=-1) {
                if(x<level) {
                     numberSelectedPerClass[Selected[x]]++;
                     totalClassLevels++;
                }
            }
        }
        for(int x = 0;x<numberSelectedPerClass.length;x++) {
            ClassCounter.add(x,numberSelectedPerClass[x]);
            Classes.get(x).setLevel(numberSelectedPerClass[x]);
        }
        setBAB();
        createClassSkillArray();
    }
    
    public void createClassSkillArray() {
        for(int x = 0;x<classSkillArray.length;x++) {
            for(int y = 1;y<classSkillArray[x].length;y++) {
                if(storedSelected[y-1]>-1) {
                    if(Classes.get(storedSelected[y-1]).getClassSkills()[x]) {
                        classSkillArray[x][y] = true;
                    }
                }
            }
            
        }
    }
    /**
     * sets the BAB based on the character classes, called internally, but can be called externally
     */
    @Override
    public void setBAB() {
        double BABTotal = 0;
        for(CharClass aClass : Classes) {
            BABTotal = BABTotal + (aClass.getLevel()*aClass.getBAB());
        }
        BAB = (int)BABTotal;
    }
    /**
     * sets the fortitude save based on the characters classes and stats
     */
    @Override
    public void setFortitudeSave() {
        double FortTotal = 0;
        int intTotal;
        for(CharClass aClass : Classes) {
            if(aClass.getFortitude()==0.5 && aClass.getLevel()>0) {
                FortTotal = FortTotal + 2 + aClass.getFortitude()*aClass.getLevel();
            }
            else if(aClass.getFortitude()==0.34 && aClass.getLevel()>0) {
                FortTotal = FortTotal + aClass.getFortitude() * aClass.getLevel();
            }
            else {
                
            }
        }
        intTotal = (int)FortTotal;
        intTotal = intTotal + bonusarray[2];
        fortitudeSave = intTotal;
    }
    /**
     * 
     * @return ArrayList<CharAbility> of Character's Class Abilities
     */
    public ArrayList<CharAbility> getClassAbilities() {
        return ClassAbilities;
    }
    /**
     * sets the reflex save based on the characters class and saves
     */
    @Override
    public void setReflexSave() {
        double ReflexTotal = 0;
        int intTotal;
        for(CharClass aClass : Classes) {
            if(aClass.getReflex()==0.5 && aClass.getLevel()>0) {
                ReflexTotal = ReflexTotal + 2 + aClass.getReflex()*aClass.getLevel();
            }
            else if(aClass.getReflex()==0.34 && aClass.getLevel()>0) {
                ReflexTotal = ReflexTotal + aClass.getReflex() * aClass.getLevel();
            }
            else {
                
            }
        }
        intTotal = (int)ReflexTotal;
        intTotal = intTotal + bonusarray[1];
        reflexSave = intTotal;
    }
    /**
     * sets the will save based on the characters classes and stats
     */
    @Override
    public void setWillSave() {
        double WillTotal = 0;
        int intTotal;
        for(CharClass aClass : Classes) {
            if(aClass.getWill()==0.5 && aClass.getLevel()>0) {
                WillTotal = WillTotal + 2 + aClass.getWill()*aClass.getLevel();
            }
            else if(aClass.getWill()==0.34 && aClass.getLevel()>0) {
                WillTotal = WillTotal + aClass.getWill() * aClass.getLevel();
            }
            else {
                
            }
        }
        intTotal = (int)WillTotal;
        intTotal = intTotal + bonusarray[4];
        willSave = intTotal;
    }
    /**
     * compiles skillRanksByLevel to get the total skillRanks for each skill
     * also generates skill ability modifiers and total skill modifiers
     */
    protected void setSkillRanks() {
        for(int x = 0;x<skillRanksByLevel.length;x++) {
            skillRanks[x] = 0;
            for(int y = 0;y<skillRanksByLevel[x].length;y++) {
                skillRanks[x] = skillRanks[x] + skillRanksByLevel[x][y];
                if(skillAttributeArray.get(x)!=6) {
                    skillAbilityMods[x] = bonusarray[skillAttributeArray.get(x)];
                }
                else {
                    skillAbilityMods[x] = 0;
                }
            }
        }
    }
    protected void setSkillModifiers() {
        for(int x = 0; x<skillModifiers.length;x++) {
            allOtherSkillBonus[x] = miscSkillBonus[x] + competenceSkillBonus[x] + 
                    race.getRaceSkillBonuses()[x];
            skillModifiers[x] = (int)skillRanks[x] + skillAbilityMods[x] + allOtherSkillBonus[x];
        }
    }
    private void addSkillSynergies() {
        if(skillRanks[3] >= 5) {
            miscSkillBonus[15] +=2;
            miscSkillBonus[17] +=2;
            miscSkillBonus[25] +=2;
            miscSkillBonus[69] +=2;
        }
        if(skillRanks[21] >=5) {
            miscSkillBonus[65] +=2;
        }
        if(skillRanks[26] >=5) {
            miscSkillBonus[75] +=2;
        }
        if(skillRanks[27] >=5) {
            miscSkillBonus[71] +=2;
        }
        if(skillRanks[32] >=5) {
            miscSkillBonus[20] +=2;
        }
        if(skillRanks[35] >=5) {
            miscSkillBonus[15] +=2;
        }
        if(skillRanks[67] >=5) {
            miscSkillBonus[15] +=2;
        }
        if(skillRanks[73] >=5) {
            miscSkillBonus[34] +=2;
        }
        if(skillRanks[75] >=5) {
            miscSkillBonus[2] +=2;
            miscSkillBonus[26] +=2;
        }
    }
    /**
     *  compiles the characters HPMax from the entered values, selected options, and constitution score.
     * @param HPTotals is an array of integers, that is supposed to be the hit point rolls for each
     * level.
     */
    protected void setHPMax(int[] HPTotals) {
        HPMax = 0;
        System.arraycopy(HPTotals, 0, storedHPTotals, 0, storedHPTotals.length);
        for(int x = 0;x<storedHPTotals.length && x<level;x++) {
            HPMax += storedHPTotals[x] + bonusarray[2];
        }
    }
    /**
     * creates the characters feat list based on the feats selected
     */
    public void setFeats() {
        Feats.clear();
        for(int x = 0;x<CharAbility.getFeatsList().size();x++) {
            if(featsSelected.get(x)) {
               Feats.add(CharAbility.getFeatsList().get(x));
            }
        }
    }
    protected void weightcalc() {
        totalweightcarried = 0;
        totalweightcarried += armor.weight;
        totalweightcarried += shield.weight;
        for(Weapon weapon : weapons) {
            totalweightcarried+=weapon.weight;
        }
        for(double[] item : itemweightvalues) {
            totalweightcarried+=item[0];
        }
    }
    /**
     * a one stop shop method that sets most of the variables for the character sheet, either by itself
     * or by calling other methods.  Takes in a number of parameters from the gui in order to extract
     * values entered by the user.
     * @param charNameInsertBox a JTextField that should contain the character's name
     * @param expInsertBox a JTextField that should contain the characters total experience
     * @param STRInsertBox a JTextField that should contain the characters strength roll
     * @param DEXInsertBox a JTextField that should contain the characters dexterity roll
     * @param CONInsertBox a JTextField that should contain the characters constitution roll
     * @param INTInsertBox a JTextField that should contain the characters intelligence roll
     * @param WISInsertBox a JTextField that should contain the characters wisdom roll
     * @param CHAInsertBox a JTextField that should contain the characters charisma roll
     * @param RaceSelector a JComboBox, the selected entry should provide an index for the characters race
     * @param skillpoints a huge array of numbers that has all of the characters skill points as distributed
     * in the SkillsInsertTable
     * @param featsSelected a boolean arraylist that contains all of the selected feats.
     * @param DomainsSelected an array of 6 integers that reference the domains selected by the character.
     * @param HPCurrent a JTextField that should contain the characters current HP.
     */
    protected void setVars(JTextField charNameInsertBox, int[] stats, 
            JComboBox<String> RaceSelector, double[][] skillpoints, ArrayList<Boolean> featsSelected, 
            int[] DomainsSelected, int[] monkFeats, int[] favoredEnemySelected, 
            int rangerCombatStyle, boolean[] rogueAbilities, int[] wizardSpecialty, 
            Armor armor, Armor shield, Weapon[] weapons, ArrayList<double[]> items) {
        this.featsSelected.clear();
        itemweightvalues.clear();
        for(int x=0;x<items.size();x++) {
            this.itemweightvalues.add(x,items.get(x));
        }
        this.armor = armor;
        this.shield = shield;
        this.weapons = weapons;
        turnAttempts = 0;
        turnCheckMod = 0;
        turnDamageMod = 0;
        bonusFeats = 0;
        miscACBonus = 0;
        System.arraycopy(monkFeats, 0, this.monkFeats, 0, monkFeats.length);
        System.arraycopy(favoredEnemySelected,0,this.favoredEnemySelected,0,favoredEnemySelected.length);
        System.arraycopy(rogueAbilities, 0, this.rogueAbilities, 0, rogueAbilities.length);
        this.rangerCombatStyle = rangerCombatStyle;
        name = charNameInsertBox.getText(); //set the characters name! easy peasy
        System.arraycopy(skillpoints, 0, skillRanksByLevel, 0, skillpoints.length);
        this.featsSelected.addAll(featsSelected);
        for(int x = 0;x < miscSkillBonus.length;x++) { //need to clear this before feats and abilities add to it.
            miscSkillBonus[x] = 0;
        }
        System.arraycopy(DomainsSelected, 0, this.DomainsSelected, 0, DomainsSelected.length);
        System.arraycopy(stats,0,this.basestatarray,0,statarray.length);
        System.arraycopy(wizardSpecialty,0,this.wizardSpecialty,0,wizardSpecialty.length);
        exp = stats[6];
        HPCurrent = stats[7];
        
        //set the characters race
        racenum = RaceSelector.getSelectedIndex(); //by retreiving the selected index
        race = CharRace.getRaceList().get(racenum); //and then looking that up in the race list
        setCharLevels(storedSelected); //level up the character and set class levels
        setstatarray(basestatarray); //set the stats
        setbonusarray(); //set the ability bonuses
        setSkillRanks();
        setFeats();
        setCombatMods(); //set them once just in case abilities check them.
        setHPMax(storedHPTotals);
        setSpeed();
        setFortitudeSave(); //set saves
        setReflexSave(); //and reflex
        setWillSave(); //and will
        setClassAbilities();
        setRaceAbilities();
        addSkillSynergies();
        this.armor.setArmorValues(this);
        this.shield.setArmorValues(this);
        for(Weapon weapon : this.weapons) {
            weapon.setWeaponValues(this);
        }
        weightcalc();
        loadcalc();
        for(CharAbility Ability : getClassAbilities()) {
            Ability.testOverrideConditions(this);
            if(Ability.getOverriden()==false) {
                Ability.execute(this);            
            }
        }
        for(CharAbility Ability : getRaceAbilities()) {
            Ability.execute(this);
        }
        for(CharAbility Feat : getFeats()) {
            Feat.executeFeats(this);
        }
        encumbrancecalc();
        setCombatMods(); //set the combat values including BAB etc after modifications by abilities.
        setSkillModifiers();
    }
    /**
     * Creates an empty PlayerChar object with no preset name
     * since curChar is created at initialization, we also use this opportunity
     * to create the static lists in the other classes.
     */
    protected PlayerChar() {
        for(int x = 1;x<levelpoints.length;x++) {
                levelpoints[x] = (levelpoints[x-1]+x*1000);
        }
        for(int y = 0;y<statarray.length;y++) {
            statarray[y] = 10;
            bonusarray[y] = 0;
        }
        if(CharAbility.getAllAbilities().size()<1) {
            CharAbility.createAbilityList();
            CharAbility.createClassAbilities();
            CharAbility.createRaceAbilities();
            TextIO.writeStandardOutput();
            TextIO.putln(CharAbility.getRaceAbilities().size());
        } 
        if(CharClass.getClassList().size()<1) { //if there aren't any character classes, make them!
            CharClass.CreateClassList();
        }
        CharRace.createRaceList();
        
        if(CharAbility.getFavoredEnemyList().size()<1) {
            CharAbility.setFavoredEnemyList();
        }
        if(Armor.ArmorList.size()<1) {
            Armor.createArmorList();
            Armor.createShieldList();
            Enchantment.createEnchantmentList();
            Weapon.createWeaponList();
        }
        createClasses(); //import the character classes so that the character can gain levels in them
        for(int x = 0; x<storedSelected.length; x++) {
            storedSelected[x]=-1;
        }
        setSkillNames();
        CharAbility.setFeatsList();
        Domain.createDomainList();
    }
}

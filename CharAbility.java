package ddgame;
import TextIO.TextIO;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Joe
 */
public class CharAbility {
    private int AbilityCode;
    private String AbilityText = "";
    private String AbilityName = "";
    private static ArrayList<CharAbility> AllAbilities = new ArrayList<>();
    private static ArrayList<CharAbility> FeatsList = new ArrayList<>();
    private boolean overriden = false;
    private String Code = "";
    private static ArrayList<String> FavoredEnemyList = new ArrayList();
    private static ArrayList<Integer[]> RaceAbilities = new ArrayList();
    private static ArrayList<Integer[]> ClassAbilities = new ArrayList();
    
    
    public static ArrayList<CharAbility> getAllAbilities() {
        return AllAbilities;
    }
    public static String[] getFavoredEnemyListArray() {
        String[] FavoredEnemyListArray = new String[FavoredEnemyList.size()];
        for(int x = 0;x<FavoredEnemyListArray.length;x++) {
            FavoredEnemyListArray[x] = FavoredEnemyList.get(x);
        }
        return FavoredEnemyListArray;
    }
    public static ArrayList<String> getFavoredEnemyList() {
        return FavoredEnemyList;
    }
    public static void setFavoredEnemyList() {
        String[] templist = {"aberation","animal","construct","dragon","elemental"
                ,"fey","giant","humanoid(aquatic)","humanoid(dwarf)","humanoid(elf)"
                ,"humanoid(goblinoid)","humanoid(gnoll)","humanoid(gnome)","humanoid(halfling)"
                ,"humanoid(human)","humanoid(orc)","humanoid(reptilian)","magical beast"
                ,"monstrous humanoid","ooze","outsider(air)","outsider(chaotic)"
                ,"outsider(earth)","outsider(evil)","outsider(fire)","outsider(good)"
                ,"outsider(lawful)","outsider(native)","outsider(water)","plant"
                ,"undead","vermin"};
        FavoredEnemyList.addAll(Arrays.asList(templist));
    }
    public int getAbilityCode() {
        return AbilityCode;
    }
    public static ArrayList<CharAbility> getFeatsList() {
        return FeatsList;
    }
    public String getAbilityText() {
        return AbilityText;
    }
    public void setAbilityText(String text) {
        AbilityText = text;
    }
    public String getAbilityName() {
        return AbilityName;
    }
    public void setAbilityName(String name) {
        AbilityName = name;
    }
    public boolean getOverriden() {
        return overriden;
    }
    public void testOverrideConditions(PlayerChar curChar) {
        if(AbilityCode==15) {
            for(int x = 52;x<58;x++) {
                if(curChar.skillRanks[x]>=3) {
                    overriden = false;
                    break;
                }
            }
        }
        else if(AbilityCode==16) {
            for(int x = 52;x<58;x++) {
                if(curChar.skillRanks[x]>=6) {
                    overriden = false;
                    break;
                }
            }            
        }
        else if(AbilityCode==17) {
            for(int x = 52;x<58;x++) {
                if(curChar.skillRanks[x]>=9) {
                    overriden = false;
                    break;
                }
            }            
        }
        else if(AbilityCode==18) {
            for(int x = 52;x<58;x++) {
                if(curChar.skillRanks[x]>=12) {
                    overriden = false;
                    break;
                }
            }            
        }
        else if(AbilityCode==19) {
            for(int x = 52;x<58;x++) {
                if(curChar.skillRanks[x]>=15) {
                    overriden = false;
                    break;
                }
            }            
        }
        else if(AbilityCode==20) {
            for(int x = 52;x<58;x++) {
                if(curChar.skillRanks[x]>=18) {
                    overriden = false;
                    break;
                }
            }            
        }
        else if(AbilityCode==21) {
            for(int x = 52;x<58;x++) {
                if(curChar.skillRanks[x]>=21) {
                    overriden = false;
                    break;
                }
            }            
        }
        else if(AbilityCode >=106 && AbilityCode<=115) {
            int x = AbilityCode - 106;
            if(curChar.rogueAbilities[x]) {
                overriden = false;
            }
        }
    }
    public void execute(PlayerChar curChar) {
        //barbarian rage
        if(AbilityCode==0) { //Rage
            int RageLevel = curChar.Classes.get(1).getLevel(); //Class 0 is Barbarian
            int numrages = RageLevel/4+1;
            int ragerounds = curChar.bonusarray[2] + 3;
            AbilityName = "Rage is awesome " + numrages + "/day";
            AbilityText = numrages +"/day this character can fly into a rage in which he"
                    + " gains +4 strength +4 Constitution +2 bonus on will saves"
                    + " -2 AC for " + ragerounds + " rounds after which he is fatigued";
            for(CharAbility Ability : curChar.getClassAbilities()) {
                if(((Integer)Ability.AbilityCode).equals(7)) { //Has Greater Rage
                    AbilityText = numrages +"/day this character can fly into a rage in which he"
                    + " gains +6 strength +6 Constitution +3 bonus on will saves"
                    + " -2 AC for " + ragerounds + " rounds after which he is fatigued";
                }
            }
            for(CharAbility Ability : curChar.getClassAbilities()) {
                if(((Integer)Ability.AbilityCode).equals(10)) { //Has Mighty Rage
                    AbilityText = numrages +"/day this character can fly into a rage in which he"
                    + " gains +8 strength +8 Constitution +4 bonus on will saves"
                    + " -2 AC for " + ragerounds + " rounds after which he is fatigued";
                }
            }
        }
        else if(AbilityCode==1) {
            if(curChar.totalweightcarried<curChar.mediumload) { 
                curChar.charSpeed = curChar.charSpeed + 10;
            }
        }
        else if(AbilityCode==3) {
            curChar.ACFlatFooted += curChar.bonusarray[1];
        }
        else if(AbilityCode==4) {

        }
        else if(AbilityCode==5) {
            
        }
        else if(AbilityCode==6) {

        }
        else if(AbilityCode==7) {

        }
        else if(AbilityCode==8) {

        }
        else if(AbilityCode==9) {

        }
        else if(AbilityCode==10) {

        }
        else if(AbilityCode==11) {
            int knowledgeMod = curChar.Classes.get(1).getLevel() + curChar.bonusarray[3];
            if(curChar.skillRanks[31] >=5) {
                knowledgeMod +=2;
            }
            AbilityText = "may make bardic knowledge check with " + knowledgeMod + 
                    " modifier to find out about local people items and places";
        }
        else if(AbilityCode==12) {
            for(int x = 52;x<58;x++) {
                if(curChar.skillRanks[x]>=3) {
                    overriden = false;
                    break;
                }
            }
        }
        else if(AbilityCode==13) {
            for(int x = 52;x<58;x++) {
                if(curChar.skillRanks[x]>=3) {
                    overriden = false;
                    break;
                }
            }
        }
        else if(AbilityCode==14) {
            for(int x = 52;x<58;x++) {
                if(curChar.skillRanks[x]>=3) {
                    overriden = false;
                    break;
                }
            }
        }
        else if(AbilityCode==15) {
            int ICLevels = curChar.Classes.get(2).getLevel();
            int ICBonus = 1 + (ICLevels-2)/6;
            AbilityName = "Inspire Courage +" + ICBonus;
            AbilityText = "may use bardic music to inspire courage in allies granting a +" + ICBonus + " morale bonus to attack and damage rolls.";
        }
        else if(AbilityCode==23) {
            curChar.bonusFeats++;
        }
        else if(AbilityCode==41) {
        	for(int x = 7;x<14;x++) {
        		if("craft alchemy".equals(curChar.skillNames.get(x).toLowerCase())) {
        			curChar.race.getRaceSkillBonuses()[x]=2;
        		}
        	}
        }
        else if(AbilityCode==45) { //halfling racial bonus to saves
        	curChar.fortitudeSave++;
        	curChar.reflexSave++;
        	curChar.willSave++;
        }
        else if(AbilityCode==48) {//turn undead
            //TODO add handling code
            curChar.turnAttempts = 3 + curChar.bonusarray[5];
            curChar.turnCheckMod = curChar.bonusarray[5];
            if(curChar.skillRanks[38]>=5) {
                curChar.turnCheckMod+=2;
            }
            curChar.turnDamageMod = curChar.Classes.get(3).getLevel()+curChar.bonusarray[5];
            if(curChar.Classes.get(7).getLevel()>=4) {
                curChar.turnDamageMod += curChar.Classes.get(7).getLevel()-3;
            }
            AbilityText = "can turn undead " + curChar.turnAttempts + "/day with a +" + curChar.turnCheckMod + " modifier and dealing 2d6+" + curChar.turnDamageMod + " turning damage";
        }
        else if(AbilityCode>=49 && AbilityCode<=54) { //domains
            int Domainnum = AbilityCode-49;
            Domain thisDomain = Domain.getDomainsList().get(curChar.DomainsSelected[Domainnum]);
            AbilityName = "Domain: " + thisDomain.name;
            AbilityText = thisDomain.description;
            thisDomain.executeDomain(curChar);
        }
        else if(AbilityCode == 56) {
            curChar.miscSkillBonus[34] += 2;
            curChar.miscSkillBonus[73] += 2;
        }
        else if(AbilityCode == 57) {
            int empathyMod = curChar.Classes.get(4).getLevel() + curChar.bonusarray[4];
            if(curChar.skillRanks[21] >=5) {
                empathyMod +=2;
            }
            AbilityText = "This character can make a wild empathy check to improve the demeanor of an animal with a +" + empathyMod +" modifier.";
        }
        else if(AbilityCode == 61) {
            int numwildshapes = 1;
            for(int x = 5;x<curChar.Classes.get(4).getLevel() && x<8;x++) {
                numwildshapes++;
                AbilityText = "This character can change shape into any small or medium animal " + numwildshapes + "/day.";
            }
            if(curChar.Classes.get(4).getLevel() > 7) {
                AbilityText = "This character can change shape into any small, medium, or large animal " + numwildshapes + "/day.";
            }
            if(curChar.Classes.get(4).getLevel() > 9) {
                numwildshapes++;
                AbilityText = "This character can change shape into any small, medium, or large animal " + numwildshapes + "/day.";
            }
            if(curChar.Classes.get(4).getLevel() > 11) {
                AbilityText = "This character can change shape into any tiny, small, medium, or large animal " + numwildshapes + "/day.";
            }
            if(curChar.Classes.get(4).getLevel() > 12) {
                AbilityText = "This character can change shape into any tiny, small, medium, or large animal or plant type creature " + numwildshapes + "/day.";

            }
            if(curChar.Classes.get(4).getLevel() > 13) {
                numwildshapes++;
                AbilityText = "This character can change shape into any tiny, small, medium, or large animal or plant type creature " + numwildshapes + "/day.";
            }
            if(curChar.Classes.get(4).getLevel() > 14) {
                AbilityText = "This character can change shape into any tiny, small, medium, large, or huge animal or plant type creature " + numwildshapes + "/day.";
            }
            if(curChar.Classes.get(4).getLevel() > 17) {
                numwildshapes++;
                AbilityText = "This character can change shape into any tiny, small, medium, large, or huge animal or plant type creature " + numwildshapes + "/day.";
            }
        }
        else if(AbilityCode == 62) {
            if(curChar.Classes.get(4).getLevel() > 17) {
                AbilityText = "This character can now wild shape into a small medium or large elemental type creature 2/day.";
            }
            if(curChar.Classes.get(4).getLevel() > 19) {
                AbilityText = "This character can now wild shape into a small, medium, large, or huge elemental type creature 3/day.";
            }
        }
        else if(AbilityCode == 66) {
            int numtoadd = 1;
            numtoadd += curChar.Classes.get(4).getLevel()/2;
            curChar.bonusFeats += numtoadd;
        }
        else if(AbilityCode == 67) {
            if(curChar.totalweightcarried<=curChar.lightload && curChar.armor.armorType.equals(Armor.ArmorType.unarmored)) {
                curChar.miscACBonus += curChar.bonusarray[4];
                curChar.miscACBonus += curChar.Classes.get(5).getLevel()/5;
            }
        }
        else if(AbilityCode == 69) {
            curChar.Feats.add(FeatsList.get(68));
        }
        else if(AbilityCode == 70) {
            if(curChar.Classes.get(6).getLevel()>0) {
                if(curChar.monkFeats[0] == 0) {
                    curChar.Feats.add(FeatsList.get(119));
                }
                else {
                    curChar.Feats.add(FeatsList.get(59));
                }
            }
            if(curChar.Classes.get(6).getLevel()>1) {
                if(curChar.monkFeats[1] == 0) {
                    curChar.Feats.add(FeatsList.get(14));
                }
                else {
                    curChar.Feats.add(FeatsList.get(21));
                }
            }
            if(curChar.Classes.get(6).getLevel()>5) {
                if(curChar.monkFeats[2] == 0) {
                    curChar.Feats.add(FeatsList.get(57));
                }
                else {
                    curChar.Feats.add(FeatsList.get(65));
                }
            }
        }
        else if(AbilityCode == 72) {
            int speedmult = 3*curChar.Classes.get(6).getLevel()/3;
            speedmult*=10;
            curChar.charSpeed+=speedmult;
        }
        else if(AbilityCode == 77) {
            int slowfallDistance = curChar.Classes.get(6).getLevel()/2;
            slowfallDistance *=10;
            AbilityText = "This character can use walls to slow her descent such that the fall is treated as if it were " + slowfallDistance + " feet shorter than it is.";
            if(curChar.Classes.get(6).getLevel() >= 20) {
            AbilityText = "This character can use walls to slow her descent such that the fall is treated as if it were any distance shorter than it is.";
            }
        }
        else if(AbilityCode == 79) {
            int WholenessTotal = curChar.Classes.get(6).getLevel()*2;
            AbilityText = "This character can heal their own wounds equal to " + WholenessTotal + " hitpoints and can spread this healing among several uses.";
        }
        else if(AbilityCode == 82) {
            int casterLevel = curChar.Classes.get(6).getLevel()/2;
            AbilityText = "This character can slip magically between spaces as if using the dimension door spell 1/day with a caster level of " + casterLevel;
        }
        else if(AbilityCode == 83) {
            int spellResistence = curChar.Classes.get(6).getLevel()+10;
            AbilityText = "This character gains spell resistence equal to " + spellResistence;
        }
        else if(AbilityCode == 84) {
            int saveDC = curChar.Classes.get(6).getLevel()/2;
            saveDC += curChar.bonusarray[4] + 10;
            AbilityText = "May make a quivering palm attack once per week(see PHB 42) with a save DC equal to " + saveDC;
        }
        else if(AbilityCode == 86) {
            int effectTime = curChar.Classes.get(6).getLevel();
            AbilityText = "This character can assume an ethereal state for " + effectTime + " rounds";
        }
        else if(AbilityCode == 88) {
            int auraStrength = curChar.Classes.get(7).getLevel();
            AbilityText = "Emits an aura of good equal to " + auraStrength;
        }
        else if(AbilityCode == 90) {
            int numPerDay = curChar.Classes.get(7).getLevel()/5 + 1;
            int attackBonus = curChar.bonusarray[5];
            int damageBonus = curChar.Classes.get(7).getLevel();
            AbilityText = "Can smite evil "+ numPerDay + "/day adding +" + attackBonus + " to the attack roll and +" + damageBonus + " to the damage.";
        }
        else if(AbilityCode == 91) {
            curChar.reflexSave += curChar.bonusarray[5];
            curChar.fortitudeSave += curChar.bonusarray[5];
            curChar.willSave += curChar.bonusarray[5];
            AbilityText = "Adds +" + curChar.bonusarray[5] + " to all saving throws.";
        }
        else if(AbilityCode == 91) {
            int LayOnHands = curChar.bonusarray[5] * curChar.Classes.get(7).getLevel();
            AbilityText = "Can heal wounds by touch.  Can heal " + LayOnHands + " hitpoints per day.";
        }
        else if(AbilityCode == 96) {
            int RemoveDisease = (curChar.Classes.get(7).getLevel()-3)/3;
            AbilityText = "Can remove disease " + RemoveDisease + "/week.";
        }
        else if(AbilityCode == 97) {
            int[] FavoredEnemyBonuses = new int[FavoredEnemyList.size()];
            for(int x = 0;x<FavoredEnemyBonuses.length;x++) {
                FavoredEnemyBonuses[x] = 0;
            }
            int RangerLevel = curChar.Classes.get(8).getLevel();
            int numbonuses = RangerLevel/5;
            numbonuses*=2;
            numbonuses++;
            for(int x = 0;x<numbonuses;x++) {
                FavoredEnemyBonuses[curChar.favoredEnemySelected[x]]+=2;
            }
            AbilityText = "this character gains a bonus on certain opposed checks and weapon damage rolls namely:";
            for(int x = 0;x<FavoredEnemyBonuses.length;x++) {
                if(FavoredEnemyBonuses[x]>0) {
                    AbilityText = AbilityText + "\n    +" + FavoredEnemyBonuses[x] + " against " + FavoredEnemyList.get(x);
                }
            }
        }
        else if(AbilityCode==98) {
            curChar.Feats.add(FeatsList.get(124));
        }
        else if(AbilityCode==99) {
            AbilityText = "this character can select a combat style gaining bonus feats as long as he is only lightly encumbered and wearing only light armor.";
            if(curChar.rangerCombatStyle==0) {
                AbilityText = AbilityText + " This character excels in two-weapon fighting.";
                curChar.Feats.add(FeatsList.get(127));
                if(curChar.Classes.get(8).getLevel()>5) {
                    curChar.Feats.add(FeatsList.get(67));
                }
                if(curChar.Classes.get(8).getLevel()>10) {
                    curChar.Feats.add(FeatsList.get(46));
                }
            }
            if(curChar.rangerCombatStyle==1) {
                AbilityText = AbilityText + " This character excels in archery.";
                curChar.Feats.add(FeatsList.get(92));
                if(curChar.Classes.get(8).getLevel()>5) {
                    curChar.Feats.add(FeatsList.get(74));
                }
                if(curChar.Classes.get(8).getLevel()>10) {
                    curChar.Feats.add(FeatsList.get(62));
                }
            }
        }
        else if(AbilityCode==100) {
            curChar.Feats.add(FeatsList.get(27));
        }
        else if(AbilityCode==104) {
            int sneakAttackDice = 1 + curChar.Classes.get(9).getLevel()/2;
            AbilityText = "whenever an opponent is denied its dexterity bonus to AC or flanked by the rogue she does an extra " + sneakAttackDice + "d6 damage on her attacks.";            
        }
        else if(AbilityCode==110) {
            int skillsSelect = 3 + curChar.bonusarray[3];
            AbilityText = "Select " + skillsSelect + " skills.  When making skill checks with one of these skills she may take 10 even when distracted.";
        }
        else if(AbilityCode>=112 && AbilityCode <=115) {
            curChar.bonusFeats++;
        }
        else if(AbilityCode==116) {
            curChar.Feats.add(FeatsList.get(95));
        }
        else if(AbilityCode==118) {
            int numberBonus = curChar.Classes.get(11).getLevel()/5;
            curChar.bonusFeats+=numberBonus;
        }
        else if(AbilityCode==119) { //this handles the specialist wizards.
            String[] bannedSchools = new String[2];
            TextIO.readFile("wizard.csv");
            for(int x = 0;x<22;x++) { //skip the spells known table
                TextIO.getln();
            }
            for(int x = 0; x<curChar.Classes.get(11).getSpellsPerDayTable().length;x++) {
                for(int y = 0;y<curChar.Classes.get(11).getSpellsPerDayTable()[y].length;y++) {
                    if(curChar.Classes.get(11).getSpellsPerDayTable()[x][y]>=0) {
                        String nexty = nextWord();
                        curChar.Classes.get(11).getSpellsPerDayTable()[x][y] = Integer.parseInt(nexty);
                    }
                }
                TextIO.getln();
            }
            for(int x = 1;x<=2;x++) {
                if(curChar.wizardSpecialty[x] == 0) {
                    bannedSchools[x-1] = "abjuration";
                }
                else if(curChar.wizardSpecialty[x] == 1) {
                    bannedSchools[x-1] = "conjuration";
                }
                else if(curChar.wizardSpecialty[x] == 2) {
                    bannedSchools[x-1] = "enchantment";
                }
                else if(curChar.wizardSpecialty[x] == 3) {
                    bannedSchools[x-1] = "evocation";
                }
                else if(curChar.wizardSpecialty[x] == 4) {
                    bannedSchools[x-1] = "illusion";
                }
                else if(curChar.wizardSpecialty[x] == 5) {
                    bannedSchools[x-1] = "necromancy";
                }
                else if(curChar.wizardSpecialty[x] == 6) {
                    bannedSchools[x-1] = "transmutation";
                }
            }
            if(curChar.wizardSpecialty[0]==0) {
                curChar.Classes.get(11).setClassName("Wizard");
                AbilityText = "This character is a generalist wizard and can cast spells from any school";
            }
            else if(curChar.wizardSpecialty[0]==1) {
                curChar.Classes.get(11).setClassName("Abjurer");
                AbilityText = "This character is an abjurer and gets bonus abjurations spells per day but cannot cast spells from the " + bannedSchools[0] + " or " + bannedSchools[1] + " schools";
                for(int x = 0; x<curChar.Classes.get(11).getSpellsPerDayTable().length;x++) {
                    for(int y = 0;y<curChar.Classes.get(11).getSpellsPerDayTable()[y].length;y++) {
                        if(curChar.Classes.get(11).getSpellsPerDayTable()[x][y]>=0) {
                            curChar.Classes.get(11).getSpellsPerDayTable()[x][y]++;
                        }
                    }
                }
            }
            else if(curChar.wizardSpecialty[0]==2) {
                curChar.Classes.get(11).setClassName("Conjurer");
                AbilityText = "This character is a conjurer and gets bonus conjuration spells per day but cannot cast spells from the " + bannedSchools[0] + " or " + bannedSchools[1] + " schools";
                for(int x = 0; x<curChar.Classes.get(11).getSpellsPerDayTable().length;x++) {
                    for(int y = 0;y<curChar.Classes.get(11).getSpellsPerDayTable()[y].length;y++) {
                        if(curChar.Classes.get(11).getSpellsPerDayTable()[x][y]>=0) {
                            curChar.Classes.get(11).getSpellsPerDayTable()[x][y]++;
                        }
                    }
                }
            }
            else if(curChar.wizardSpecialty[0]==4) {
                curChar.Classes.get(11).setClassName("Enchanter");
                AbilityText = "This character is an enchanter and gets bonus enchantment spells per day but cannot cast spells from the " + bannedSchools[0] + " or " + bannedSchools[1] + " schools";
                for(int x = 0; x<curChar.Classes.get(11).getSpellsPerDayTable().length;x++) {
                    for(int y = 0;y<curChar.Classes.get(11).getSpellsPerDayTable()[y].length;y++) {
                        if(curChar.Classes.get(11).getSpellsPerDayTable()[x][y]>=0) {
                            curChar.Classes.get(11).getSpellsPerDayTable()[x][y]++;
                        }
                    }
                }
            }
            else if(curChar.wizardSpecialty[0]==3) {
                curChar.Classes.get(11).setClassName("Diviner");
                AbilityText = "This character is an abjurer and gets bonus divination spells per day but cannot cast spells from the " + bannedSchools[0] + " school";
                for(int x = 0; x<curChar.Classes.get(11).getSpellsPerDayTable().length;x++) {
                    for(int y = 0;y<curChar.Classes.get(11).getSpellsPerDayTable()[y].length;y++) {
                        if(curChar.Classes.get(11).getSpellsPerDayTable()[x][y]>=0) {
                            curChar.Classes.get(11).getSpellsPerDayTable()[x][y]++;
                        }
                    }
                }
            }
            else if(curChar.wizardSpecialty[0]==5) {
                curChar.Classes.get(11).setClassName("Evoker");
                AbilityText = "This character is an evoker and gets bonus evocation spells per day but cannot cast spells from the " + bannedSchools[0] + " or " + bannedSchools[1] + " schools";
                for(int x = 0; x<curChar.Classes.get(11).getSpellsPerDayTable().length;x++) {
                    for(int y = 0;y<curChar.Classes.get(11).getSpellsPerDayTable()[y].length;y++) {
                        if(curChar.Classes.get(11).getSpellsPerDayTable()[x][y]>=0) {
                            curChar.Classes.get(11).getSpellsPerDayTable()[x][y]++;
                        }
                    }
                }
            }
            else if(curChar.wizardSpecialty[0]==6) {
                curChar.Classes.get(11).setClassName("Illusionist");
                AbilityText = "This character is an illusionist and gets bonus illusion spells per day but cannot cast spells from the " + bannedSchools[0] + " or " + bannedSchools[1] + " schools";
                for(int x = 0; x<curChar.Classes.get(11).getSpellsPerDayTable().length;x++) {
                    for(int y = 0;y<curChar.Classes.get(11).getSpellsPerDayTable()[y].length;y++) {
                        if(curChar.Classes.get(11).getSpellsPerDayTable()[x][y]>=0) {
                            curChar.Classes.get(11).getSpellsPerDayTable()[x][y]++;
                        }
                    }
                }
            }
            else if(curChar.wizardSpecialty[0]==7) {
                curChar.Classes.get(11).setClassName("Necromancer");
                AbilityText = "This character is a necromancer and gets bonus necromancy spells per day but cannot cast spells from the " + bannedSchools[0] + " or " + bannedSchools[1] + " schools";
                for(int x = 0; x<curChar.Classes.get(11).getSpellsPerDayTable().length;x++) {
                    for(int y = 0;y<curChar.Classes.get(11).getSpellsPerDayTable()[y].length;y++) {
                        if(curChar.Classes.get(11).getSpellsPerDayTable()[x][y]>=0) {
                            curChar.Classes.get(11).getSpellsPerDayTable()[x][y]++;
                        }
                    }
                }
            }
            else if(curChar.wizardSpecialty[0]==8) {
                curChar.Classes.get(11).setClassName("Transmuter");
                AbilityText = "This character is a transmuter and gets bonus transmutation spells per day but cannot cast spells from the " + bannedSchools[0] + " or " + bannedSchools[1] + " schools";
                for(int x = 0; x<curChar.Classes.get(11).getSpellsPerDayTable().length;x++) {
                    for(int y = 0;y<curChar.Classes.get(11).getSpellsPerDayTable()[y].length;y++) {
                        if(curChar.Classes.get(11).getSpellsPerDayTable()[x][y]>=0) {
                            curChar.Classes.get(11).getSpellsPerDayTable()[x][y]++;
                        }
                    }
                }
            }
        }
    }
    public void executeFeats(PlayerChar curChar) {
    	//TODO add handling code for feats.
        if(AbilityCode == 0) { //acrobatic
            curChar.miscSkillBonus[26]+=2;
            curChar.miscSkillBonus[75]+=2;
        }
        else if(AbilityCode == 1) { //agile
            curChar.miscSkillBonus[2]+=2;
            curChar.miscSkillBonus[18]+=2;
        }
        else if(AbilityCode == 2) { //alertness
            curChar.miscSkillBonus[48]+=2;
            curChar.miscSkillBonus[72]+=2;
        }
        else if(AbilityCode == 3) { //animal affinity
            curChar.miscSkillBonus[21]+=2;
            curChar.miscSkillBonus[65]+=2;
        }
        else if(AbilityCode == 4) { //armor proficiency heavy
            
        }
    }
    
    private static String nextWord() {
        String buffer = "";
        char next;
        while(TextIO.peek() != '~' && TextIO.eof()==false && TextIO.peek() !='?') {
            next = TextIO.getAnyChar();
            buffer = buffer + next;
        }
        if(TextIO.peek()=='~') {
            TextIO.getAnyChar(); //dispose of the comma
        }
        //TextIO.put(buffer + ";");
        return buffer;
    }
    
    public static void createAbilityList() {
        TextIO.readFile("abilities.txt");
        TextIO.writeFile("abilitiesdebug.txt");
        TextIO.getln();
        while(TextIO.eof()==false) {
            CharAbility thisability = new CharAbility();
            int ID = Integer.parseInt(nextWord());
            thisability.AbilityCode = ID;
            thisability.AbilityName = nextWord();
            thisability.overriden = Boolean.parseBoolean(nextWord());
            thisability.AbilityText = nextWord();
            thisability.Code = nextWord();
            AllAbilities.add(ID, thisability);
            TextIO.getln();
        }
        TextIO.readStandardInput();
        TextIO.writeStandardOutput();
    }
    public static void createRaceAbilities() {
        TextIO.readFile("raceabilities.txt");
        TextIO.writeFile("abilitiesdebug.txt");
        TextIO.getln();
        while(TextIO.eof()==false) {
            Integer[] thismatch = new Integer[2];
            thismatch[0] = Integer.parseInt(nextWord());
            thismatch[1] = Integer.parseInt(nextWord());
            TextIO.putln("" + thismatch[0] + ";" + thismatch[1]);
            TextIO.getln();
            RaceAbilities.add(thismatch);
        }
        TextIO.readStandardInput();
    }
    public static void createClassAbilities() {
        TextIO.readFile("classabilities.txt");
        TextIO.getln();
        while(TextIO.eof()==false) {
            Integer[] thismatch = new Integer[3];
            thismatch[0] = Integer.parseInt(nextWord());
            thismatch[1] = Integer.parseInt(nextWord());
            thismatch[2] = Integer.parseInt(nextWord());
            TextIO.getln();
            ClassAbilities.add(thismatch);
        }
        TextIO.readStandardInput();
    }
    public static ArrayList<Integer[]> getRaceAbilities() {
        return RaceAbilities;
    }
    public static ArrayList<Integer[]> getClassAbilities() {
        return ClassAbilities;
    }
    public static void setFeatsList() {
        TextIO.readFile("feats.txt");
        TextIO.getln();//skip labels
        while(TextIO.eof()==false) {
            CharAbility thisability = new CharAbility();
            int ID = Integer.parseInt(nextWord());
            thisability.AbilityCode = ID;
            thisability.AbilityName = nextWord();
            thisability.overriden = false;
            thisability.AbilityText = nextWord();
            thisability.Code = nextWord();
            FeatsList.add(thisability);
            TextIO.getln();
        }
        TextIO.readStandardInput();
    }
    CharAbility(int AbilityCode, 
            String AbilityName, 
            boolean overriden, 
            String AbilityText,
            String Code) {
        this.AbilityCode = AbilityCode;
        this.AbilityName = AbilityName;
        this.overriden = overriden;
        this.AbilityText = AbilityText;
        this.Code = Code;
    }
    CharAbility() {
        
    }
}

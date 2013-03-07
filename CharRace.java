/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ddgame;

import TextIO.TextIO;
import java.util.ArrayList;

/**
 * This is a container class used to contain all of the attributes of a D&D
 * character race.  Used to create the racelist array.
 * @author Joe
 */
public class CharRace {
    Integer ID;
    String raceName = "";
    private int raceSTR = 0;
    private int raceDEX = 0;
    private int raceCON = 0;
    private int raceINT = 0;
    private int raceWIS = 0;
    private int raceCHA = 0;
    private int sizeMod = 0;
    private int raceSpeed = 0;
    private int[] raceSkillBonuses = new int[79];
    private ArrayList<Integer> raceAbilities = new ArrayList<>();
    private static ArrayList<CharRace> racelist = new ArrayList<>();
    private static ArrayList<String> raceNames = new ArrayList<>();
    
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
        if(true) {
            TextIO.put(buffer + "~");
        }
        return buffer;
    }
        protected static ArrayList<CharRace> getRaceList() {
            return racelist;
        }
        /**
         * 
         * @return raceNames converted to a standard String array rather than an ArrayList
         */
        protected static String[] getRaceNamesStringArray() {
        	String[] raceName = new String[raceNames.size()];
        	for(int x = 0;x<raceNames.size();x++) {
        		raceName[x] = raceNames.get(x);
        	}
            return raceName;
        }
        /**
         * 
         * @return returns ArrayList<String> of a list of the character race names
         */
        protected static ArrayList<String> getRaceNames() {
        	return raceNames;
        }
        public int[] getRaceSkillBonuses() {
    		return raceSkillBonuses;
    	}
        protected int getRaceStr() {
            return raceSTR;
        }
        protected int getRaceDex() {
            return raceDEX;
        }
        protected int getRaceCon() {
            return raceCON;
        }
        protected int getRaceInt() {
            return raceINT;
        }
        protected int getRaceWis() {
            return raceWIS;
        }
        protected int getRaceCha() {
            return raceCHA;
        }
        protected int getRaceSpeed() {
            return raceSpeed;
        }
        protected ArrayList<Integer> getRaceAbilities() {
            return raceAbilities;
        }
        protected static void createRaceList() {
        racelist.clear();
        raceNames.clear();
        TextIO.readFile("racedb.txt");
        TextIO.writeFile("racedebug.txt");
        TextIO.getln();
        while(TextIO.eof()==false) {
            CharRace ThisRace = new CharRace();
            ThisRace.ID = Integer.parseInt(nextWord());
            ThisRace.raceName = nextWord();
            raceNames.add(ThisRace.raceName);
            ThisRace.raceSTR = Integer.parseInt(nextWord());
            ThisRace.raceDEX = Integer.parseInt(nextWord());
            ThisRace.raceCON = Integer.parseInt(nextWord());
            ThisRace.raceINT = Integer.parseInt(nextWord());
            ThisRace.raceWIS = Integer.parseInt(nextWord());
            ThisRace.raceCHA = Integer.parseInt(nextWord());
            ThisRace.setSizeMod(Integer.parseInt(nextWord()));
            ThisRace.raceSpeed = Integer.parseInt(nextWord());
            for(int y = 0;y<ThisRace.raceSkillBonuses.length;y++) {
            	ThisRace.raceSkillBonuses[y] = Integer.parseInt(nextWord());
            }
            TextIO.writeFile("stuff.txt");
            TextIO.putln(CharAbility.getRaceAbilities().size());
            for(int x=0;x<CharAbility.getRaceAbilities().size();x++) {
            	if(CharAbility.getRaceAbilities().get(x)[0].compareTo(ThisRace.ID)==0) {
                    ThisRace.raceAbilities.add(CharAbility.getRaceAbilities().get(x)[1]);
                }
            }
            racelist.add(ThisRace.ID,ThisRace);
            if(TextIO.eof() == false) {
                TextIO.getln();
            }
        }
        TextIO.readStandardInput();
        TextIO.writeStandardOutput();
    }
		public int getSizeMod() {
			return sizeMod;
		}
		public void setSizeMod(int sizeMod) {
			this.sizeMod = sizeMod;
		}
}

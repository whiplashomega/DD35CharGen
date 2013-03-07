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
public class Domain {
    public int ID;
    public String name;
    public boolean overriden;
    public String description;
    public int[] domainspells = new int[9];
    public String Code;
    private static ArrayList<Domain> DomainsList = new ArrayList<>();
    private static ArrayList<String> DomainNamesList = new ArrayList<>();
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
    public static void createDomainList() {
        TextIO.readFile("domains.txt");
        TextIO.getln();
        while(TextIO.eof()==false) {
            Domain thisdomain = new Domain();
            thisdomain.ID = Integer.parseInt(nextWord());
            thisdomain.name = nextWord();
            DomainNamesList.add(thisdomain.ID,thisdomain.name);
            thisdomain.overriden = Boolean.parseBoolean(nextWord());
            thisdomain.description = nextWord();
            for(int x = 0; x<thisdomain.domainspells.length;x++) {
                thisdomain.domainspells[x] = Integer.parseInt(nextWord());
            }
            thisdomain.Code = nextWord();
            DomainsList.add(thisdomain);
            TextIO.getln();            
        }
    }
    public static ArrayList<Domain> getDomainsList() {
        return DomainsList;
    }
    public static ArrayList<String> getDomainNamesList() {
        return DomainNamesList;
    }
    public static String[] getDomainNamesListArray() {
        String[] DomainNamesListArray = new String[DomainNamesList.size()];
        for(int x = 0;x<DomainNamesListArray.length;x++) {
            DomainNamesListArray[x] = DomainNamesList.get(x);
        }
        return DomainNamesListArray;
    }
    public void executeDomain(ddgame.PlayerChar curChar) {
        //TODO add domains to list and add handling code
    }
}

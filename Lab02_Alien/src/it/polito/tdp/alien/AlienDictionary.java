package it.polito.tdp.alien;
import java.util.*;
public class AlienDictionary {
List<Word> listaparole=new ArrayList<Word>();
public void addWord(String alienWord,String translation) {
	Word par=new Word(alienWord,translation);
	for(Word w:listaparole) {
		if (w.getAlienWord().compareTo(alienWord)==0)
		{
			listaparole.remove(w);
			listaparole.add(par);
			return;
		}
	}
	listaparole.add(par);
	
}
}

package lotto2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {
    private int kihuzottSzamokDB;
    private List<Integer> lottoSzamok;
    private int szamokSzama;
    private int huzasokSzama;
    private Random rnd;
    
    public Lotto(int szamokSzama, int huzasokSzama){
        this.lottoSzamok = new ArrayList<>();
        this.szamokSzama = szamokSzama;
        this.huzasokSzama = huzasokSzama;
        this.kihuzottSzamokDB = 0;
        this.rnd = new Random();
    }
    public int getMaxSzamok(){
        return this.szamokSzama;
    }
    
    public int getMaxHuzasSzam(){
        return this.huzasokSzama;
    }
    public void ujLottoSzamHuzas(){
        if (this.kihuzottSzamokDB< this.huzasokSzama) {
            int szam;
            int i;
            do{
                szam = this.rnd.nextInt(szamokSzama)+1;
                i = 0;
                while(i<this.lottoSzamok.size()&& this.lottoSzamok.get(i) != szam){
                i++;
                }
            }while(i<this.lottoSzamok.size());            
            this.lottoSzamok.add(szam);
            this.kihuzottSzamokDB++;
        }
    }
    public void novekvoSzamsorrend(){
        this.lottoSzamok.sort(null);
    }
    @Override
    public String toString(){
        String s = "";
        for(Integer lsz : this.lottoSzamok){
            s+= lsz+ " ";
        }
        return s;
    }
    public void sorsol(){
        for (int i = 0; i < this.huzasokSzama; i++) {
            this.ujLottoSzamHuzas();
            this.novekvoSzamsorrend();
        }
    }
}

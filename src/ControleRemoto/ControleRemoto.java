package ControleRemoto;

import javax.sound.midi.Soundbank;
import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ControleRemoto implements Controlador{
    //atributos:
    private int volume;
    private boolean ligado;
    private boolean tocando;

//métodos personalizados - abstratos da interface Controlador:
    @Override//override significa sobrescrever
    public void ligar() {
    this.setLigado(true);
    }

    @Override
    public void desligar() {
    this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
        if(getLigado()) {
            System.out.println("------MENU------");
            System.out.println("Está ligado?" + this.getLigado());
            System.out.println("Está tocando?" + this.getTocando());
            System.out.print("Volume " + this.getVolume());
            for (int i = 1; i <= this.getVolume(); i += 10) {
                System.out.print("|");
            }
            System.out.println("");
        }else{
            System.out.println("Impossível abrir menu!");
        }
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando menu...");
    }

    @Override
    public void maisVolume() {
    if(this.getLigado()){
        this.setVolume(this.getVolume()+5);
    }
    }

    @Override
    public void menosVolume() {
    if(this.getLigado()){
        this.setVolume(this.getVolume()-5);
    }
    }

    @Override
    public void ligarMudo() {
    if(this.getLigado() && this.getVolume()>0){
        this.setVolume(0);
    }
    }

    @Override
    public void desligarMudo() {
    if(getLigado() && getVolume()== 0){
        setVolume(50);
    }
    }

    @Override
    public void play() {
    if(this.getLigado() && !(this.getTocando())){
        this.setTocando(true);
    }
    }

    @Override
    public void pause() {
        if(this.getLigado() && this.getTocando()){
            this.setTocando(false);
        }

    }
    //métodos especiais - getters and setters
    private int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    private boolean getLigado() {
        return ligado;
    }

    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    private boolean getTocando() {
        return tocando;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }
    //método construtor:
    public ControleRemoto() {
        this.volume = 50;
        this.ligado = true;
        this.tocando = false;
    }
}

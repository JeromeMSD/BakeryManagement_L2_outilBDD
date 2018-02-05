/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Nicolas
 */
public enum Activité {

  Jardinage("Jardinage"),
  Plomberie("Plomberie"),
  Serrurerie("Serrurerie"),
  Maçonnerie("Maçonnerie"),
  Electricité("Électricité"),
  Alarme("Alarme");

   
  private String nomActivité = "";
   
  Activité(String nom){
    this.nomActivité = nom;
  }
  
  public void getNomActivité(){
      System.out.println("Domaine d\'activité :" + nomActivité);
  }
  
  public ObservableList<String> getActivites(){
      return FXCollections.observableArrayList("Jadinage","Plomberie","Serrurerie","Maçonnerie","Electricité","Alarme");
  }
  
  public static Activité get(String s){
      switch(s){
          case "Jadinage":
              return Activité.Jardinage;
          case "Plomberie":
              return Activité.Plomberie;
          case "Serrurerie":
              return Activité.Serrurerie;
          case "Maçonnerie":
              return Activité.Maçonnerie;
          case "Electricité":
              return Activité.Electricité;
          case "Alarme":
              return Activité.Alarme;
      }
      return Activité.Alarme;
  }
  
  @Override
  public String toString(){
    return nomActivité;
  }
}

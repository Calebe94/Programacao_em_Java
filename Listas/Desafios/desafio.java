import  java.util.*;
/*
    Getters and Setters:
        getCountryName()
        getCountryCapital()
        getCountryFrontier()
        setAnotherFrontier()
    Verifiers:
        SameCountry()
        isNeighbor()
*/
public class desafio{
  private String name;
  private String capital;
  private int dimension;
  //That list will be used to allocate memory dynamically to store country's frontier
  private ArrayList<desafio> frontierList;
  private List frontiers = new ArrayList();
  
  private int how_many_borders = 0;
  private String[] frontier = new String[4];
  public desafio(String country,String capital, int dimension){
    this.name = country;
    this.capital = capital;
    this.dimension = dimension;
    this.how_many_borders = 3;
    //Allocate more memory to list itens 
    this.frontierList = new ArrayList<>();
    
    for (int index = 0 ; index < 3 ; index++){
      this.frontier[index] = border_countries[index];
    }
  }
  String getCountryName(){
    return this.name;
  }
  String getCountryCapital(){
    return this.capital;
  }
  String[] getCountryFrontier(){
    String[] frontier = new String[this.how_many_borders];
    for(int index = 0; index < how_many_borders; index++){
      frontier[index] = this.frontier[index];
    }
    return frontier;
  }
  Boolean setAnotherFrontier(String another){
    if(another == this.name){
      return false;
    }else{
      how_many_borders++;
      this.frontier[how_many_borders] = another;
      return true;
    }
  }
  Boolean SameCountry(String country1,String frontier1,String country2,String frontier2){
    if (country1==country2){
      if(frontier1==frontier2){
          return true;
      }
    }
    return false;
  }
  Boolean isNeighbor(String country){
    for ( int index = 0 ;index < how_many_borders ; index ++){
      if (country == this.frontier[index]){
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String[] frontier1 = new String[3];
    frontier1[0] = "Paraguai";
    frontier1[1] = "Argentina";
    frontier1[2] = "Uruguai";
    desafio country1 = new desafio("Brasil","Brasilia",120000,frontier1);

    frontier1[0] = "Paraguai";
    frontier1[1] = "Uruguai";
    frontier1[2] = "Chile";

    desafio country2 = new desafio("Argentina","Buenos Aires",120000,frontier1);

    frontier1[0] = "Chile";
    frontier1[1] = null;
    frontier1[2] = null;
    desafio country3 = new desafio("Paraguai","La Paz",120000,frontier1);

    frontier1[0] = "Paraguai";
    frontier1[1] = null;
    frontier1[2] = null;
    desafio country4 = new desafio("Chile","Santiago",120000,frontier1);

    frontier1[0] = "Brasil";
    frontier1[1] = "Argentina";
    frontier1[2] = null;
    desafio country5 = new desafio("Uruguai","Montevidel",120000,frontier1);
    System.out.println();
    System.out.println(country5.getCountryName());
    System.out.println(Arrays.toString(country5.getCountryFrontier()));

    if(country5.isNeighbor(country1.getCountryName()) == true){
      System.out.println(country5.getCountryName()+" É Vizinho de:"+country1.getCountryName());
    }else{
      System.out.println(country5.getCountryName()+" Não é Vizinho de:"+country1.getCountryName());
    }
    System.out.println();
    System.out.println(country4.getCountryName());
    System.out.println(Arrays.toString(country4.getCountryFrontier()));

    if(country4.isNeighbor(country5.getCountryName()) == true){
      System.out.println(country4.getCountryName()+" É Vizinho de:"+country5.getCountryName());
    }else{
      System.out.println(country4.getCountryName()+" Não é Vizinho de:"+country5.getCountryName());
    }
    System.out.println();
    System.out.println(country4.getCountryName());
    System.out.println(Arrays.toString(country4.getCountryFrontier()));

    if(country4.isNeighbor(country2.getCountryName()) == true){
      System.out.println(country4.getCountryName()+" É Vizinho de:"+country2.getCountryName());
    }else{
      System.out.println(country4.getCountryName()+" Não é Vizinho de:"+country2.getCountryName());
    }
    System.out.println();
    System.out.println(country3.getCountryName());
    System.out.println(Arrays.toString(country3.getCountryFrontier()));

    if(country3.isNeighbor(country5.getCountryName()) == true){
      System.out.println(country3.getCountryName()+" É Vizinho de:"+country5.getCountryName());
    }else{
      System.out.println(country3.getCountryName()+" Não é Vizinho de:"+country5.getCountryName());
    }
    }
  }

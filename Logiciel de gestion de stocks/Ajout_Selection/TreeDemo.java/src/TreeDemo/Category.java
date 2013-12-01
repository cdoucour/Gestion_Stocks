package TreeDemo;

import java.util.LinkedList;
import java.util.List;


public class Category {
	String name;
	List<Category> children;
	
	 // Liste des instances des la classe categorie
	 // Variable de classe
        private static ArrayList<Category> instances = new ArrayList<Category>();
	
	public Category(String n){
		this.name = n;
		children = new LinkedList<Category>();
	}
	
	public void addChild(Category c){
		children.add(c); 
	}
	
	public List<Category> getChildren(){
		return this.children;
	}

	public void setName(String n){
		this.name = n;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String toString(){
		return this.name;
            
	}
	
	public void afficherPrix(Category c){
		if(c.getChildren().size()==0){
			Product p = (Product)c;
			System.out.println(p.getPrice());
		}
		else{
			for(Category cat:c.getChildren()){
				afficherPrix(cat);
			}
		}
	}
	
	
	/*
	* Methode de classe
	* Methode permettant de renvoyer une categorie parmi les categories deja cree a partir du nom de la 
	* categorie de recher
	* parametre en entree : String (nom de la categorie qu'on cherche)
	*/
	public static Category getLookedCategory(String nom){
        	Category cat = new Category("");
        	boolean equals=false;
        	
        	for (Category cat1 : instances){
        		
        		if (cat1.getName().equals(nom)){
        			cat=cat1;
        		}
        	}        
        	
        	return cat;
        }

		public static ArrayList<Category> getInstances() {
			return instances;
		}
}

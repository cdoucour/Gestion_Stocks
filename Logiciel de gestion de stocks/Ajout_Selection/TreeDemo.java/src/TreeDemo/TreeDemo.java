package TreeDemo;


import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.net.URL;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class TreeDemo extends JPanel
                      implements TreeSelectionListener {
    private JEditorPane htmlPane;
    private JTree tree;
    private URL helpURL;
    private static boolean DEBUG = false;

    
    
    private static boolean playWithLineStyle = false;
    private static String lineStyle = "Horizontal";
    
    
    private static boolean useSystemLookAndFeel = false;

    public TreeDemo() {
        super(new GridLayout(1,0));

        //Crée les noeuds
        DefaultMutableTreeNode top =
            new DefaultMutableTreeNode("magasin");
        createNodes(top);

        // Crée un arbre qui accepte une sélection
        tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode
            (TreeSelectionModel.SINGLE_TREE_SELECTION);

    
    tree.addTreeSelectionListener(this);

        if (playWithLineStyle) {
            System.out.println("line style = " + lineStyle);
            tree.putClientProperty("JTree.lineStyle", lineStyle);
        }

        // Crée le panneau défilant et y ajoute l'arbre 
        JScrollPane treeView = new JScrollPane(tree);
        
        
        
        JButton addProduct = new JButton("  Creer un nouveau produit  ");
		JButton addCategory = new JButton("Creer une nouvelle categorie");
		JButton deleteCategory = new JButton("Supprimer categorie ou produit");
		JButton modifyProduct = new JButton("    Modifier un produit    ");
		JButton modifyTree = new JButton("    Deplacer une categorie    ");
		JButton renameCategorie = new JButton("Renommer categorie ou produit");
		
		
		// ******************* Actions Listener  ****************************
		// Boutton "Creer un nouveau produit"
		addProduct.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){               
				
                            Formulaire fenetre1 = new Formulaire();
                            
			}
		});
		
		// Boutton "Creer une nouvelle categorie"
		/*
		 * A compléter
		 */
		
		
		// Boutton "Supprimer categorie ou produi"		
		/*
		 * A completer
		 */
		
		
		// Boutton "Modifier un produit"
		/*
		 * A completer
		 */
		
		// Boutton "Deplacer une categorie"
		/*
		 * A completer
		 */
		
		// Boutton "Renommer categorie ou produit"
		/*
		 * A completer
		 */
		
		
		
		// *******************   Arrangement des bouttons ************************
		JPanel buttonZone = new JPanel();
		/*GridLayout south = new GridLayout();
		south.setColumns(3);
		south.setRows(2);
		south.setHgap(5);
		south.setVgap(5);
                */
		
		//buttonZone.setLayout(south);
		buttonZone.add(addProduct);
		buttonZone.add(addCategory);
		buttonZone.add(deleteCategory);
		buttonZone.add(modifyProduct);
		buttonZone.add(modifyTree);
		buttonZone.add(renameCategorie);
		buttonZone.setVisible(true);
		
                add(buttonZone);

      

        
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(treeView);
        

        Dimension minimumSize = new Dimension(100, 50);
        
        treeView.setMinimumSize(minimumSize);
        splitPane.setDividerLocation(100); 
        splitPane.setPreferredSize(new Dimension(500, 300));

        
        add(splitPane);
    }

    /** Indispensable pour TreeSelectionListener  */
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                           tree.getLastSelectedPathComponent();

        if (node == null) return;
        
        //La sélection des objets commence ici.

        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()) {
            Category book = (Category)nodeInfo;
            System.out.print(book.toString());
            
            if (DEBUG) {
                System.out.print(book.toString());
            }
        } else {
            Category book = (Category)nodeInfo;
            System.out.print(book.toString());
             
        }
        if (DEBUG) {
            System.out.println(nodeInfo.toString());
        }
    }


    

   

    

    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode book = null;

        category = new DefaultMutableTreeNode("Categorie 1");
        top.add(category);

        
        book = new DefaultMutableTreeNode(new Category
            ("Bananes"));
        category.add(book);

        
        book = new DefaultMutableTreeNode(new Category("Mangues"));
        category.add(book);

        
        book = new DefaultMutableTreeNode(new Category("Surgelés"));
        category.add(book);

        
        book = new DefaultMutableTreeNode(new Category("Pizza"));
        category.add(book);

        
        book = new DefaultMutableTreeNode(new Category("Produits Frais"));
        category.add(book);

        book = new DefaultMutableTreeNode(new Category("Riz"));
        category.add(book);

        category = new DefaultMutableTreeNode("Categorie 2");
        top.add(category);

        
        book = new DefaultMutableTreeNode(new Category("Nouilles"));
        category.add(book);

        
        book = new DefaultMutableTreeNode(new Category("Pates"));
        category.add(book);
    }
        
    
    private static void createAndShowGUI() {
        if (useSystemLookAndFeel) {
            try {
                UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("Impossible d'utiliser look and feel.");
            }
        }

        //Crée le panneau d'affichage principal
        JFrame frame = new JFrame("TreeDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Ajoute le contenu au panneau d'affichage
        frame.add(new TreeDemo());

        //Affiche la fenêtre
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
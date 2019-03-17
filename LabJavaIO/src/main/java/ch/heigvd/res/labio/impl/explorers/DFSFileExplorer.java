package ch.heigvd.res.labio.impl.explorers;

import ch.heigvd.res.labio.interfaces.IFileExplorer;
import ch.heigvd.res.labio.interfaces.IFileVisitor;
import java.io.File;
import java.util.Arrays;

/**
 * This implementation of the IFileExplorer interface performs a depth-first
 * exploration of the file system and invokes the visitor for every encountered
 * node (file and directory). When the explorer reaches a directory, it visits all
 * files in the directory and then moves into the subdirectories.
 * 
 * @author Olivier Liechti
 */
public class DFSFileExplorer implements IFileExplorer {

  @Override
  public void explore(File rootDirectory, IFileVisitor visitor) {
    if(rootDirectory != null){
      //on visite le rootDirectory
      visitor.visit(rootDirectory);
      //on recupere la liste de fichiers
      File[] fichiers = rootDirectory.listFiles();

      if(fichiers != null){
        Arrays.sort(fichiers); //on doit les trier pour passer le test

        for(File f : fichiers){
          if(f.isDirectory()){ //si dossier on explore et visite l'interieur
            explore(f,visitor);
          }
          else
            visitor.visit(f); //si fichier on visiste simplement
        }

      }
    }
  }

}

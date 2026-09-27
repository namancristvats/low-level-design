package lowleveldesign.Project1_DocumentEditor.badDesign;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class DocumentEditor {
    List<String> documentElements;
    private String renderedDocuments;

    public DocumentEditor(){
        this.documentElements=new ArrayList<>();
        renderedDocuments="";
    }
    public void addElement(String element){
        documentElements.add(element);
    }
    public void removeElement(String element){
        documentElements.remove(element);
    }
    public String renderedElement(){
        if(renderedDocuments.isEmpty()){
            StringBuilder builder=new StringBuilder();
            for(String element:documentElements){
                if(element.length()>4 && element.endsWith(".png")||element.startsWith(".jpg")){
                    builder.append("[Image: ").append(element).append("]\n");
                }
                else{
                    builder.append(element).append("\n");
                }
            }
            renderedDocuments= builder.toString();
        }
        return renderedDocuments;
    }
    public void saveToFile(){
        try {
            FileWriter writer=new FileWriter("document.text");
            writer.write(renderedElement());
            writer.close();
            System.out.println("Document saved to document.txt");
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}
public class DocumentEditorClient{
    public static void main(String args[]){
        DocumentEditor editor=new DocumentEditor();
        editor.addElement("Hello,World!!!");
        editor.addElement("picture.jpg");
        editor.addElement("This is a document editor!!!");
        System.out.println(editor.renderedElement());
        editor.saveToFile();

    }

}


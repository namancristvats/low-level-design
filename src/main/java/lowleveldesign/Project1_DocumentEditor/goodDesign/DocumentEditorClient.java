package lowleveldesign.Project1_DocumentEditor.goodDesign;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

interface Elements{
    String render();
}
class Text implements Elements{
    private String text;
    public Text(String element){
        this.text=element;
    }
    @Override
    public String render() {
        return text;
    }
}
class Image implements Elements{
    private String image;
    public Image(String image){
        this.image=image;
    }
    @Override
    public String render() {
        return "[Image: "+image+" ]";
    }
}
class Newline implements Elements{
    @Override
    public String render() {
        return "\n";
    }
}
class TabSpace implements Elements{
    @Override
    public String render() {
        return "\t";
    }
}
class Document{
    List<Elements> documentElementList;
    public Document(){
        this.documentElementList=new ArrayList<>();
    }
    public void addElement(Elements element){
        documentElementList.add(element);
    }
    public String renderDocument(){
        StringBuilder result = new StringBuilder();
        for (Elements element : documentElementList) {
            result.append(element.render());
        }
        return result.toString();
    }
}
interface Persistance{
    void save(String data);
}
class SavedToFile implements Persistance{

    @Override
    public void save(String data) {
        try {
            FileWriter writer=new FileWriter("goodDesign.txt");
            writer.write(data);
            writer.close();
            System.out.println("Document saved to goodDesign.txt");
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}
class SavedToDb implements Persistance{

    @Override
    public void save(String data) {
        System.out.println("Document saved to DB");
    }
}
class DocumentEditor{
    Document doc;
    Persistance db;
    private String renderedDocument="";
    public DocumentEditor(Document doc,Persistance db){
        this.doc=doc;
        this.db=db;
    }
    public void addText(String text){
        doc.addElement(new Text(text));
    }
    public void addImage(String image){
        doc.addElement(new Image(image));
    }
    public void addNewLine(){
        doc.addElement(new Newline());
    }
    public void addTabSpace(){
        doc.addElement(new TabSpace());
    }
    public String renderedDocument(){
        if(renderedDocument.isEmpty()){
            renderedDocument=doc.renderDocument();
        }
        return renderedDocument;
    }
    public void saveDocument(){
        db.save(renderedDocument);
    }
}
public class DocumentEditorClient {
    public static void main(String args[]){
    Document document=new Document();
    Persistance db=new SavedToFile();
    DocumentEditor editor=new DocumentEditor(document,db);
        editor.addText("Hello, world!");
        editor.addNewLine();
        editor.addText("This is a real-world document editor example.");
        editor.addNewLine();
        editor.addTabSpace();
        editor.addText("Indented text after a tab space.");
        editor.addNewLine();
        editor.addImage("picture.jpg");
        System.out.println(editor.renderedDocument());

        editor.saveDocument();
    }


}

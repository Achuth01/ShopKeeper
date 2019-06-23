package application.oneToMany;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class FriendsService {

    @Autowired
    private FriendsRepo friendsRepo;

    public Friends add(Friends friends){
        return friendsRepo.saveorUpdate(friends);
    }

    public Friends update(Friends friends){
        return friendsRepo.saveorUpdate(friends);
    }

    public void delete(Integer id){
        friendsRepo.delete(id);
    }

    public Friends get(Integer id){
        return friendsRepo.get(id);
    }

    public List<Friends> getAll(){
        return friendsRepo.getAll();
    }


    public XWPFDocument downloadDoc() throws IOException, XDocReportException {

        XWPFDocument srcDoc = new XWPFDocument(new FileInputStream("C:/Users/achut/Downloads/adtgene.docx"));

        for(XWPFParagraph paragraph :srcDoc.getParagraphs()){
            for(XWPFRun run:paragraph.getRuns()) {
                if (run.getColor() != null && run.getColor().equalsIgnoreCase("C00000"))
                    run.setText(null, 0);
            }
        }

        for(XWPFTable table:srcDoc.getTables()){
            int size=table.getRows().size();
            for(int i=0;i<size;i++){
                table=filterTable(table);
            }
        }

        /*OutputStream out = new FileOutputStream("C:/Users/achut/Downloads/demo2.docx");
        srcDoc.write(out);
        out.close();*/

        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        srcDoc.write(byteArrayOutputStream);
        InputStream inputStream=new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.writeTo(new FileOutputStream("C:/Users/achut/Downloads/demo2.docx"));

        return srcDoc;
    }

    /*List<XWPFTable> filterTables(List<XWPFTable> tables){
        for(XWPFTable table:tables){
            for(int i=0;i<table.getRows().size();i++) {
                XWPFTableRow row=table.getRow(i);
                for (int j=0;j<row.getTableCells().size();j++) {
                    XWPFTableCell cell=row.getCell(j);
                    if (cell.getColor() != null && cell.getColor().equalsIgnoreCase("00B050")) {
                        cell.removeParagraph(0);
                        System.out.println("cell.getText() = " + cell.getText());
                        table.removeRow(i);
                    }
                }
            }
        }
        return tables;
    }
*/

   XWPFTable filterTable(XWPFTable table){
       int size=table.getRows().size();
       for(int i=0;i<size;i++) {
           XWPFTableRow row = table.getRow(i);
           for (int j = 0; j < row.getTableCells().size(); j++) {
               XWPFTableCell cell = row.getCell(j);
               if (cell.getColor() != null && cell.getColor().equalsIgnoreCase("00B050")) {
                   System.out.println("cell.getText() = " + cell.getText());
                   table.removeRow(i);
                   return table;
               }
           }
       }
       return table;
    }

}

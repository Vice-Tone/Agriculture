package com.ruoyi.project.agricultrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

public class PrintTest {
    /**
     * 调用打印机功能
     *
     * @author Administrator
     */

    public static void main(String[] args) {
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        PrintService[] pservices = PrintServiceLookup.lookupPrintServices(flavor, aset);
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        PrintService service = ServiceUI.printDialog(null, 200, 200, pservices,
                defaultService, flavor, aset);

        String fileName = "D:\\videos\\csv\\header.csv";

        if (service != null) {
            try {
                DocPrintJob pj = service.createPrintJob();
                FileInputStream fis = new FileInputStream(fileName);
                DocAttributeSet das = new HashDocAttributeSet();
                Doc doc = new SimpleDoc(fis, flavor, das);
                pj.print(doc, aset);
            } catch (FileNotFoundException fe) {
                fe.printStackTrace();
            } catch (PrintException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("打印失败");
        }
    }

}

package Model;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.extgstate.PdfExtGState;
import com.itextpdf.text.pdf.PdfGState;   // For iText 5

import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
public class BackgroundColorEvent extends PdfPageEventHelper {
    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        PdfContentByte cb = writer.getDirectContentUnder();
        Rectangle rect = document.getPageSize();
        BaseColor backgroundColor = new BaseColor(
                Integer.valueOf("#ecd9b3".substring(1, 3), 16),  // Red
                Integer.valueOf("#ecd9b3".substring(3, 5), 16),  // Green
                Integer.valueOf("#ecd9b3".substring(5, 7), 16)   // Blue
            );
        cb.setColorFill(backgroundColor);  // Set your desired color here
        cb.rectangle(rect.getLeft(), rect.getBottom(), rect.getWidth(), rect.getHeight());
        cb.fill();
        
        BaseColor paneColor1 = new BaseColor(
                Integer.valueOf("#ffffff".substring(1, 3), 16),  // Red
                Integer.valueOf("#ffffff".substring(3, 5), 16),  // Green
                Integer.valueOf("#ffffff".substring(5, 7), 16)   // Blue
            );  // or any color of your choice
        
        BaseColor paneColor2 = new BaseColor(
                Integer.valueOf("#ffffff".substring(1, 3), 16),  // Red
                Integer.valueOf("#ffffff".substring(3, 5), 16),  // Green
                Integer.valueOf("#ffffff".substring(5, 7), 16)   // Blue
            );  // or any color of your choice
        
        PdfGState state = new PdfGState();
        state.setFillOpacity(0.5f);
        cb.setGState(state);
        
        cb.setColorFill(paneColor1);
        cb.roundRectangle(30, 25, 530, 800, 10f);
        cb.fill();
        
//        cb.setColorFill(paneColor2);
//        cb.roundRectangle(310, 525, 240, 220, 10f);
//        cb.fill();
    }
}

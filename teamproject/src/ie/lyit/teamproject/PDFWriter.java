package ie.lyit.teamproject;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFWriter {
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 24,
			Font.BOLD);
	private static Font underlineTitle = new Font(Font.FontFamily.TIMES_ROMAN, 19,
			Font.BOLD | Font.UNDERLINE);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
			Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 16,
			Font.BOLD);
	private static Font tableText = new Font(Font.FontFamily.TIMES_ROMAN, 10);
	private static String[] headerDetails;
	private static Object[][] displayArray;
	private static String fileNameToSave;
	private static DecimalFormat df = new DecimalFormat("###,###.00");
	private static DecimalFormat intf = new DecimalFormat("###,###");
	private static 	double grandTotal;
	static ResultSet rs;

	public static void writeFile() {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(
					getFileNameToSave()));
			document.open();
			addMetaData(document);
			addTitlePage(document);
			addContent(document);
			document.close();

			if (getFileNameToSave().toString().endsWith(".pdf")) {
				Runtime.getRuntime().exec(
						"rundll32 url.dll,FileProtocolHandler "
								+ getFileNameToSave());
			} else {
				// For cross platform use
				Desktop desktop = Desktop.getDesktop();

				File fileToOpen = new File(getFileNameToSave());
				desktop.open(fileToOpen);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String[] getHeaderDetails() {
		return headerDetails;
	}

	public static void setHeaderDetails(String[] headDets) {
		headerDetails = headDets;
	}

	public static Object[][] getTableContent() {
		return displayArray;
	}

	public static void setTableContent(Object[][] displayDets) {
		displayArray = displayDets;
	}

	public static String getFileNameToSave() {
		return fileNameToSave;
	}

	public static void setFileNameToSave(String fileToSave) {
		PDFWriter.fileNameToSave = fileToSave;
	}

	// iText allows to add metadata to the PDF which can be viewed in your Adobe
	// Reader
	// under File -> Properties
	private static void addMetaData(Document document) {
		document.addTitle("Building Material Calculator");
		document.addSubject("Using iText");
		document.addKeywords("Java, PDF, iText");
		document.addAuthor("Liam Waugh");
		document.addCreator("Liam Waugh");
	}

	private static void addTitlePage(Document document)
			throws DocumentException, MalformedURLException, IOException {
		Paragraph preface = new Paragraph();
		// We add one empty line
		
		// Lets write a big header
		

		addEmptyLine(preface, 1);
		Image image1 = Image.getInstance("Images/logo.jpg");
		preface.add(image1);
		image1.setAbsolutePosition(300f, 650f);
		addEmptyLine(preface, 8);
		preface.add(new Paragraph(
				("Proposed Quantity and Pricing Lists"), catFont));
		addEmptyLine(preface, 8);
		preface.add(new Paragraph("Project Details", underlineTitle));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Job:               " +headerDetails[1], smallBold));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Client:          " + headerDetails[0], smallBold));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Architect:    " + headerDetails[2], smallBold));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Engineer:     " + headerDetails[3], smallBold));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Builder:        " + headerDetails[4], smallBold));
		
		

		document.add(preface);
		// Start a new page
		document.newPage();
	}

	private static void addContent(Document document) throws DocumentException {
		Anchor anchor = new Anchor("Main", catFont);
		anchor.setName("Main");

		// Second parameter is the number of the chapter
		Chapter catPart = new Chapter(new Paragraph(anchor), 1);

		Paragraph subPara = new Paragraph("Table", underlineTitle);
		Section subCatPart = catPart.addSection(subPara);
		subCatPart.add(new Paragraph("Pricing and Quantity Breakdown", underlineTitle));
		
		subPara.setIndentationLeft(25);
		subCatPart.setIndentationLeft(25);

		// add a list
		createList(subCatPart);
		Paragraph paragraph = new Paragraph();
		addEmptyLine(paragraph, 3);
		subCatPart.add(paragraph);

		// add a table
		createTable(subCatPart);
		
		Paragraph totalPara = new Paragraph("Total", underlineTitle);
		Section totalSubPara = catPart.addSection(totalPara);
		totalSubPara.add(new Paragraph("Price", underlineTitle));
		
		totalSubPara.add(new Paragraph("Grand Total:        €" + headerDetails[5], smallBold));
		
		totalSubPara.setIndentationLeft(25);

		// now add all this to the document
		document.add(catPart);

		// Next section
		anchor = new Anchor("Terms and Conditions", catFont);
		anchor.setName("Second Chapter");

		// Second parameter is the number of the chapter
		catPart = new Chapter(new Paragraph(anchor), 1);

		Paragraph disclaimer = new Paragraph("Disclaimer", underlineTitle);
		Section subDisclaimer = catPart.addSection(disclaimer);
		addEmptyLine(disclaimer, 1);
		subDisclaimer.add(new Paragraph("The prices produced in this document are by no means final, these prices are"
				+ " estimates.The prices can fluxuate on quantities bought and demand of products."
				+ " Also the produced price does not contain fees charged by work that is out sourced from this company i.e. Architects and Engineers."
				+ " Also the produced price does not factor in the cost of labor charged by Builders."));
		disclaimer.setIndentationLeft(25);
		subDisclaimer.setIndentationLeft(25);
		
		
		Paragraph contactPara = new Paragraph("Administrators and Contact Info", underlineTitle);
		Section sectionContactPara = catPart.addSection(contactPara);
		addEmptyLine(contactPara, 1);
		sectionContactPara.add(new Paragraph(""
				+ "    Name:                  Cathal Diver \n"
				+ "    Telephone No.:    0862546095 \n"
				+ "    Email:                   L00096309@student.lyit.ie \n \n"
				+ "    Name:                  Liam Waugh \n"
				+ "    Telephone No.:    087695112 \n"
				+ "    Email:                   L00097721@student.lyit.ie \n \n"
				+ "    Name:                  Eamon McSharry \n"
				+ "    Telephone No.:    0872853739 \n"
				+ "    Email:                   L00094341@student.lyit.ie \n \n"
				+ "    Name:                  Luke Toland \n"
				+ "    Telephone No.:    0872853739 \n"
				+ "    Email:                   L00097070@student.lyit.ie"));
		
		contactPara.setIndentationLeft(25);
		sectionContactPara.setIndentationLeft(25);
		
		Paragraph legalPara = new Paragraph("Legal", underlineTitle);
		Section sectionLegalPara = catPart.addSection(legalPara);
		addEmptyLine(legalPara, 1);
		sectionLegalPara.add(new Paragraph("The java code used to run this building materials calculater is the intelectual property"
				+ " of Mr. Cathal Diver"
				+ ", Mr. Liam Waugh"
				+ ", Mr. Eamon McSharry"
				+ " and Mr. Luke Toland"
				+ ". Any infringments of said intelectual property will be met with legal action. Layouts and algorithms are also trademarked."));
		
		legalPara.setIndentationLeft(25);
		sectionLegalPara.setIndentationLeft(25);

		// now add all this to the document
		document.add(catPart);

	}

	private static void createTable(Section subCatPart)
			throws BadElementException {
		PdfPTable table = new PdfPTable(6);
		table.setTotalWidth(500);

		// t.setBorderColor(BaseColor.GRAY);
		// t.setPadding(4);
		// t.setSpacing(4);
		// t.setBorderWidth(1);
		PdfPCell c1 = new PdfPCell(new Phrase("Category", tableText));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Description", tableText));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setColspan(2);
		// c1.setBorder(Rectangle.OUT_BOTTOM);
		// c1.setBorder(Rectangle.OUT_LEFT);
		// c1.setBorder(Rectangle.OUT_RIGHT);
		// c1.setBorder(Rectangle.OUT_TOP);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Quantity", tableText));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Price", tableText));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Total", tableText));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		table.setHeaderRows(1);

		PdfPCell nCell = new PdfPCell();

		for (int i = 0; i < displayArray.length; i++) {
			
			
			nCell = new PdfPCell(new Phrase("" + displayArray[i][0], tableText));
			table.addCell(nCell);
			nCell = new PdfPCell(new Phrase("" + displayArray[i][1], tableText));
			nCell.setColspan(2);
			table.addCell(nCell);
			nCell = new PdfPCell(new Phrase("" + intf.format(displayArray[i][2]), tableText));
			nCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(nCell);
			nCell = new PdfPCell(new Phrase("" + df.format(displayArray[i][3]), tableText));
			nCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(nCell);
			nCell = new PdfPCell(new Phrase("" + df.format(displayArray[i][4]), tableText));
			nCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(nCell);
			// jtfTotal.setText("" + df.format(rs.getDouble(4)));
			
		}

		subCatPart.add(table);

	}

	private static void createList(Section subCatPart) {
		List list = new List(true, false, 10);
		list.add(new ListItem(""));
		list.add(new ListItem(""));
		list.add(new ListItem(""));
		subCatPart.add(list);
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}

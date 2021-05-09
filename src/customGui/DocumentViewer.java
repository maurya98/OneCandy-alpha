package customGui;

import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class DocumentViewer {
	public static JPanel documentViewer(String path) throws ClassNotFoundException, InstantiationException, UnsupportedLookAndFeelException, IllegalAccessException {
		SwingController controller = new SwingController();

        SwingViewBuilder factory = new SwingViewBuilder(controller);

        JPanel viewerComponentPanel = factory.buildViewerPanel();

        // add interactive mouse link annotation support via callback
        controller.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                        controller.getDocumentViewController()));

        // Now that the GUI is all in place, we can try openning a PDF
        controller.openDocument(path);
        return viewerComponentPanel;
	}
}

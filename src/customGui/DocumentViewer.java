package customGui;

import javax.swing.JPanel;

import org.icepdf.core.util.GraphicsRenderingHints;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class DocumentViewer {
	public static JPanel documentViewer(String path) throws Exception {
		SwingController controller = new SwingController();
        SwingViewBuilder factory = new SwingViewBuilder(controller);
        //System.getProperties().put("-Dorg.icepdf.core.imageReference", "VALUE_INTERPOLATION_BICUBIC");
        //System.getProperties().put("oorg.icepdf.core.minMemory", "10M");
       // System.getProperties().put("org.icepdf.core.imageReference", "smoothScaled");
        System.getProperties().put("org.icepdf.core.target.colorRender", "VALUE_COLOR_RENDER_QUALITY");
        System.getProperties().put("org.icepdf.core.ccittfax.jai ", "true");
        System.getProperties().put("org.icepdf.core.awtFontLoading ", "true");
        JPanel viewerComponentPanel = factory.buildViewerPanel();
       
        // add interactive mouse link annotation support via callback
        controller.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                        controller.getDocumentViewController()));

        // Now that the GUI is all in place, we can try opening a PDF
        controller.openDocument(path);
        return viewerComponentPanel;
	}
}

package shape;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Serializable;

public class TransferableDessin extends Dessin implements Transferable,
		Serializable {

	public TransferableDessin(){
		
	}

	@Override
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		Object result = null;
		if(flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType)){
			result = this;
		} else {
			result = null;
		}
		return result;
	}
	
	@Override
	public DataFlavor[] getTransferDataFlavors() {
		DataFlavor []data = new DataFlavor[2];
		try{
			data[0] = new DataFlavor( DataFlavor.javaJVMLocalObjectMimeType );
			data[1] = new DataFlavor( Dessin.class, null );
		} catch(java.lang.ClassNotFoundException e){}
		return data;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor arg0) {
		return ((arg0.isMimeTypeEqual( DataFlavor.javaJVMLocalObjectMimeType ) ) ||
				arg0.isMimeTypeEqual( new DataFlavor(Dessin.class, null)));
	}
	
	private static final long serialVersionUID = 1L;

}

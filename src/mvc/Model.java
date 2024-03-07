package mvc;

import java.io.Serializable;

public abstract class Model extends Publisher implements Serializable {

    Boolean unsavedChanges = false;
    String fileName = null;

    // TODO: All methods below
    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setUnsavedChanges(boolean unsavedChanges) {
        this.unsavedChanges = unsavedChanges;
    }
}

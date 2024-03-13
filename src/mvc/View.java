package mvc;

import javax.swing.JPanel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class View extends JPanel implements PropertyChangeListener {
    protected Model model;

    public View(Model model) {
        setModel(model);
    }

    public void setModel(Model model) {
        if (this.model != null) {
            this.model.removePropertyChangeListener(this);
        }
        this.model = model;
        if (this.model != null) {
            this.model.addPropertyChangeListener(this);
        }
        updateView();
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource() == model) {
            updateView();
        }
    }

    protected abstract void updateView();
}

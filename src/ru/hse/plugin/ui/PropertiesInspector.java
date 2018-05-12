package ru.hse.plugin.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import ru.hse.plugin.core.entities.ComponentEntity;
import ru.hse.plugin.core.entities.PropertyEntity;

public class PropertiesInspector {
    private JPanel panel1;
    private JScrollPane jScrollPane;
    private JPanel propertiesPanel;
    private JPanel requiredLabelPanel;
    private JPanel optionalLabelPanel;
    private ComponentEntity componentEntity;

    public PropertiesInspector() {
        requiredLabelPanel = new JPanel();
        requiredLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        JLabel requiredLabel = new JLabel("Required properties");
        requiredLabel.setHorizontalAlignment(SwingConstants.LEFT);
        requiredLabelPanel.add(requiredLabel);
        optionalLabelPanel = new JPanel();
        optionalLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        JLabel optionalLabel = new JLabel("Optional properties");
        optionalLabel.setHorizontalAlignment(SwingConstants.LEFT);
        optionalLabelPanel.add(optionalLabel);
    }

    public PropertiesInspector(ComponentEntity componentEntity) {
        this();
        setComponentEntity(componentEntity);
    }

    public void setComponentEntity(ComponentEntity componentEntity) {
        this.componentEntity = componentEntity;
        propertiesPanel = new JPanel();
        propertiesPanel.setLayout(new BoxLayout(propertiesPanel, BoxLayout.Y_AXIS));
        List<PropertyEntity> requiredProperties = componentEntity.getRequiredPropertyEntities();
        List<PropertyEntity> optionalProperties = componentEntity.getOptionalEntities();
        if (requiredProperties.size() != 0) {
            propertiesPanel.add(requiredLabelPanel);
            for (PropertyEntity propertyEntity : componentEntity.getRequiredPropertyEntities()) {
                propertiesPanel.add(new PropertyUIItem(propertyEntity).$$$getRootComponent$$$());
            }
        }
        if (optionalProperties.size() != 0) {
            propertiesPanel.add(optionalLabelPanel);
            for (PropertyEntity propertyEntity : componentEntity.getOptionalEntities()) {
                propertiesPanel.add(new PropertyUIItem(propertyEntity).$$$getRootComponent$$$());
            }
        }
        jScrollPane.setViewportView(propertiesPanel);
    }

    public void clear() {
        propertiesPanel.removeAll();
    }

    public ComponentEntity getComponentEntity() {
        return componentEntity;
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Properties Inspector", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, -1, -1, panel1.getFont())));
        jScrollPane = new JScrollPane();
        panel1.add(jScrollPane, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 230), null, null, 0, false));
        jScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), null));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}

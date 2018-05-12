package ru.hse.plugin.ui;

import ru.hse.plugin.core.entities.ComponentEntity;
import ru.hse.plugin.core.entities.PropertyEntity;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PropertyUIItem {
    private JCheckBox checkbox;
    private JPanel panel1;
    PropertyEntity propertyEntity;
    ComponentEntity componentEntity;

    private JSlider getJSlider() {
        JSlider jslider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        jslider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(e.toString());
            }
        });
        jslider.setMajorTickSpacing(10);
        jslider.setMinorTickSpacing(0);
        jslider.setPaintTicks(true);
        jslider.setPaintLabels(true);
        return jslider;
    }

    private JCheckBox getCheckbox() {
        JCheckBox jCheckBox = new JCheckBox();
        jCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(e.getSource());
            }
        });
        return jCheckBox;
    }

    private JTextField getTextField() {
        JTextField jTextField = new JTextField(10);
        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getSource());
            }
        });
        return jTextField;
    }

    private JComboBox getCombobox() {
        String repr = propertyEntity.getTypeStringRepr();
        int from = repr.indexOf('(') + 1;
        int to = repr.indexOf(')');
        String enums = repr.substring(from + 1, to).replaceAll("\'", "");
        String[] options = enums.split(",");
        JComboBox comboBox = new JComboBox(options);
        comboBox.setSelectedIndex(0);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getSource());
            }
        });
        return comboBox;
    }

    public PropertyUIItem(PropertyEntity propertyEntity, ComponentEntity componentEntity) {
        this.propertyEntity = propertyEntity;
        this.componentEntity = componentEntity;
        checkbox.setText(propertyEntity.getShortName());
        checkbox.setSelected(propertyEntity.isSelected());
        checkbox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                componentEntity.toggleProperty(propertyEntity);
            }
        });
        switch (propertyEntity.getType()) {
            case number:
                panel1.add(getJSlider());
                break;
            case bool:
                panel1.add(getCheckbox());
                break;
            case string:
                panel1.add(getTextField());
                break;
            case enumeration:
                panel1.add(getCombobox());
                break;
            default:
                panel1.add(getTextField());
        }
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
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        checkbox = new JCheckBox();
        checkbox.setHorizontalAlignment(2);
        checkbox.setHorizontalTextPosition(4);
        checkbox.setText("CheckBox");
        panel1.add(checkbox);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}

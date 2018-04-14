package ru.hse.plugin.ui;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBList;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.jetbrains.annotations.NotNull;
import ru.hse.plugin.core.ComponentCellRenderer;
import ru.hse.plugin.core.ComponentCollection;
import ru.hse.plugin.core.Component;
import ru.hse.plugin.core.Platform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainToolWindow implements ToolWindowFactory {
    private ToolWindow mainToolWindow;
    private JPanel contentPanel;
    private JTabbedPane tabbedPane1;
    private JPanel ios;
    private JPanel android;
    private JPanel common;
    private JTextField searchField;
    private JLabel searchLabel;
    private JPanel iosPanel;
    private JPanel androidPanel;
    private JPanel commonPanel;
    private JList<Component> iosList;
    private JList<Component> androidList;
    private JList<Component> commonList;
    Component[] builtinComponents = ComponentCollection.getBuiltinComponents();


    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        mainToolWindow = toolWindow;
        iosPanel.setLayout(new BoxLayout(iosPanel, BoxLayout.Y_AXIS));
        androidPanel.setLayout(new BoxLayout(androidPanel, BoxLayout.Y_AXIS));
        commonPanel.setLayout(new BoxLayout(commonPanel, BoxLayout.Y_AXIS));

        this.createUIComponents();
        this.loadComponents();
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(contentPanel, "", false);
        toolWindow.getContentManager().addContent(content);
    }

    private void createUIComponents() {
        DefaultListModel<Component> iosModel = new DefaultListModel<>();
        DefaultListModel<Component> androidModel = new DefaultListModel<>();
        DefaultListModel<Component> commonModel = new DefaultListModel<>();

        for (Component component : builtinComponents) {
            if (component.getPlatform() == Platform.IOS) {
                iosModel.addElement(component);
            }
            if (component.getPlatform() == Platform.ANDROID) {
                androidModel.addElement(component);
            }
            if (component.getPlatform() == Platform.BOTH) {
                commonModel.addElement(component);
            }
        }
        JBList iosList = new JBList(iosModel);
        JBList androidList = new JBList(androidModel);
        JBList commonList = new JBList(commonModel);
        iosList.setCellRenderer(new ComponentCellRenderer());
        androidList.setCellRenderer(new ComponentCellRenderer());
        commonList.setCellRenderer(new ComponentCellRenderer());
        iosPanel.add(iosList);
        androidPanel.add(androidList);
        commonPanel.add(commonList);
    }

    private void loadComponents() {
//        for (Component component : components) {
//            if (component.getPlatform() == Platform.IOS) {
//                iosList.add(component.getName(), null);
//            }
//            if (component.getPlatform() == Platform.ANDROID) {
//                androidList.add(component.getName(), null);
//            }
//            if (component.getPlatform() == Platform.BOTH) {
//                commonList.add(component.getName(), null);
//            }
//        }
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
        contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayoutManager(2, 1, new Insets(4, 4, 4, 4), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 2, new Insets(0, 5, 0, 0), -1, -1));
        panel1.setBackground(new Color(-1250068));
        contentPanel.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        tabbedPane1 = new JTabbedPane();
        panel1.add(tabbedPane1, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        ios = new JPanel();
        ios.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("IOS", ios);
        final JBScrollPane jBScrollPane1 = new JBScrollPane();
        ios.add(jBScrollPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        iosPanel = new JPanel();
        iosPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        jBScrollPane1.setViewportView(iosPanel);
        android = new JPanel();
        android.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Android", android);
        final JBScrollPane jBScrollPane2 = new JBScrollPane();
        android.add(jBScrollPane2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        androidPanel = new JPanel();
        androidPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        jBScrollPane2.setViewportView(androidPanel);
        common = new JPanel();
        common.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Common", common);
        final JBScrollPane jBScrollPane3 = new JBScrollPane();
        common.add(jBScrollPane3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        commonPanel = new JPanel();
        commonPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        jBScrollPane3.setViewportView(commonPanel);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 2, new Insets(0, 10, 0, 5), -1, -1));
        panel1.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchLabel = new JLabel();
        searchLabel.setBackground(new Color(-1));
        searchLabel.setText("Search");
        panel2.add(searchLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchField = new JTextField();
        panel2.add(searchField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        contentPanel.add(panel3, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(-1, 200), null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPanel;
    }
}

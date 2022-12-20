package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawMap {
    private Frame frame = new Frame("USA");
    private MyCanvas myCanvas = new MyCanvas();
    private Button close = new Button("close");

    public void init() {
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //定义一个Panel，装载两个按钮
        Panel p = new Panel();
        p.add(close);

        //把panel添加到frame底部
        myCanvas.setPreferredSize(new Dimension(1920,900));

        frame.add(myCanvas);
        //frame.pack();
        frame.setVisible(true);
        frame.add(p,BorderLayout.SOUTH);


    }


    public static void main(String[] args) {
        new DrawMap().init();
    }
}

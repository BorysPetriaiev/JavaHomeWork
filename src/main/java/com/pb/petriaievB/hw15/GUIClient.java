package com.pb.petriaievB.hw15;

import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIClient extends JFrame {

    JTextArea client;
    JTextArea server;
    JPanel jPanel;
    JScrollPane jScrollPane;
    JButton send = new JButton("Сообщение");
    Container cont;

    public GUIClient() {
        cont = getContentPane();
        setSize(700, 700);
        setTitle("GUIClient");
        jPanel = new JPanel();
        //str = new JTextField(30);
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        client = new JTextArea(20, 20);
        server = new JTextArea(20, 20);
        jScrollPane = new JScrollPane(client);
        jPanel.add(client);
        jPanel.add(server);
        jPanel.add(send);
        cont.add(jPanel);

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Socket s = null;
                try {
                    s = new Socket("127.0.0.1", 9999);
                } catch (UnknownHostException unknownHostException) {
                    unknownHostException.printStackTrace();
                    s = null;
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    s = null;
                }
                if (s == null)
                    System.exit(-1);
                BufferedReader in = null;
                PrintWriter out = null;
                try {
                    in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    out = new PrintWriter(s.getOutputStream(), true);
                    out.flush();
                    String temp = client.getText();
                    out.println(temp);
                    server.setText(in.readLine());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } finally {
                    try {
                        out.close();
                        in.close();
                        s.close();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUIClient guiClient = new GUIClient();
                guiClient.setVisible(true);
            }
        });
    }
}
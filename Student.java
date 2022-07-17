import java.io.*;
import java.nio.CharBuffer;

public class Student extends File {
    private int id;
    private String name, lastName;
    private float grade;

    public Student(int i, String n, String ln, float g, String p) {
        super(p);
        id = i;
        name = n;
        lastName = ln;
        grade = g;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public float getGrade() {
        return grade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public void write(Student s) {
        try {
            FileOutputStream fos = new FileOutputStream(String.valueOf(new File(s.getPath())));
            DataOutputStream dout = new DataOutputStream(fos);
            if (s.getAdaptorType() == _FixRecFixStrAdap) {
                String ch;
                ch = String.format("%4d,%2.2f,%10s,%20s\n", s.id, s.grade, s.name, s.lastName);
                dout.writeUTF(ch);
            } else if (s.getAdaptorType() == _FixRecDynStrAdap) {
                String ch;
                ch = String.format("%4d,%2.2f,%s,%s\n", s.id, s.grade, s.name, s.lastName);
                dout.writeUTF(ch);
            } else if (s.getAdaptorType() == _DynRecFixStrAdap) {
                dout.writeByte(s.id);
                dout.writeFloat(s.grade);
                String ch;
                ch = String.format("%10s,%20s", s.name, s.lastName);
                dout.writeUTF(ch);
                dout.writeChars("\n");
            } else if (s.getAdaptorType() == _DynRecDynStrAdap) {
                dout.writeByte(s.id);
                dout.writeFloat(s.grade);
                dout.writeUTF(s.name);
                dout.writeChars(",");
                dout.writeUTF(s.lastName);
                dout.writeChars("\n");
            }
            fos.close();
            dout.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public Student search(String s, int row) {
        String line;
        try {
            FileReader fr = new FileReader(this.getPath());
            BufferedReader br = new BufferedReader(fr);

            row = 1;

            if (this.getAdaptorType() == _FixRecFixStrAdap) {
                while (br.readLine() != null) {
                    line = br.readLine();
                    if (line.equals(s)) {
                        int id;
                        float gr;
                        String n, ln;

                        id = Integer.parseInt(line.substring(0, 4));
                        gr = Float.parseFloat(line.substring(5, 10));
                        n = line.substring(11, 21);
                        ln = line.substring(22, 42);
                        n = n.replaceAll(" ", "");
                        ln = ln.replaceAll(" ", "");
                        return new Student(id, n, ln, gr, this.getPath());
                    }
                    row += 1;
                }
                return new Student(-1, "", "", 0, this.getPath());
            } else if (this.getAdaptorType() == _FixRecDynStrAdap) {
                while (br.readLine() != null) {
                    line = br.readLine();
                    if (line.equals(s)) {
                        int id;
                        float gr;
                        String n, ln;

                        id = Integer.parseInt(line.substring(0, 4));
                        gr = Float.parseFloat(line.substring(5, 10));
                        n = line.substring(11, line.indexOf(","));
                        ln = line.substring(line.indexOf(","));
                        n = n.replaceAll(" ", "");
                        ln = ln.replaceAll(" ", "");
                        return new Student(id, n, ln, gr, this.getPath());
                    }
                    row += 1;
                }
                return new Student(-1, "", "", 0, this.getPath());
            } else if (this.getAdaptorType() == _DynRecFixStrAdap) {
                while (br.readLine() != null) {
                    int id = 0;
                    float gr = 0;
                    char[] temp = new char[20];
                    String n, ln;

                    br.read(CharBuffer.wrap(String.valueOf(id)));
                    br.read(CharBuffer.wrap(String.valueOf(gr)));
                    br.read(temp, 0, 10);
                    n = String.valueOf(temp);
                    br.read(temp, 10, 20);
                    ln = String.valueOf(temp);
                    return new Student(id, n, ln, gr, this.getPath());
                }
                row += 1;
                return new Student(-1, "", "", 0, this.getPath());
            } else if (this.getAdaptorType() == _DynRecDynStrAdap) {
                while (br.readLine() != null) {
                    int id = 0;
                    float gr = 0;
                    char[] temp = new char[20];
                    String n, ln;

                    br.read(CharBuffer.wrap(String.valueOf(id)));
                    br.read(CharBuffer.wrap(String.valueOf(gr)));
                    line = br.readLine();
                    n = line.substring(0, line.indexOf(","));
                    ln = line.substring(line.indexOf(",") + 1);
                    n = n.replaceAll(" ", "");
                    ln = ln.replaceAll(" ", "");
                    return new Student(id, n, ln, gr, this.getPath());
                }
                row += 1;
                return new Student(-1, "", "", 0, this.getPath());
            }

            fr.close();
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public Student search(float g, int row) {
        return this.search(String.valueOf(g), row);
    }

    public Student search(int i, int row) {
        return this.search(String.valueOf(i), row);
    }

    public String toSring() {
        String ch;
        ch = String.format("%d, %2.2f, %s, %s\n", this.id, this.grade, this.name, this.lastName);
        return ch;
    }


    public void printAll() throws FileNotFoundException {

        String line;
        try {
            FileReader fr = new FileReader(this.getPath());
            BufferedReader br = new BufferedReader(fr);

            if (this.getAdaptorType() == _FixRecFixStrAdap) {
                while (br.readLine() != null) {
                    line = br.readLine();
                    int id;
                    float gr;
                    String n, ln;

                    id = Integer.parseInt(line.substring(0, 4));
                    gr = Float.parseFloat(line.substring(5, 10));
                    n = line.substring(11, 21);
                    ln = line.substring(22, 42);
                    n = n.replaceAll(" ", "");
                    ln = ln.replaceAll(" ", "");
                    System.out.println(new Student(id, n, ln, gr, this.getPath()).toSring());
                }
            } else if (this.getAdaptorType() == _FixRecDynStrAdap)
            {
                while (br.readLine() != null) {
                    line = br.readLine();
                        int id;
                        float gr;
                        String n, ln;

                        id = Integer.parseInt(line.substring(0, 4));
                        gr = Float.parseFloat(line.substring(5, 10));
                        n = line.substring(11, line.indexOf(","));
                        ln = line.substring(line.indexOf(","));
                        n = n.replaceAll(" ", "");
                        ln = ln.replaceAll(" ", "");
                    System.out.println(new Student(id, n, ln, gr, this.getPath()).toSring());
                }
            } else if (this.getAdaptorType() == _DynRecFixStrAdap)
            {
                while (br.readLine() != null) {
                    int id = 0;
                    float gr = 0;
                    char[] temp = new char[20];
                    String n, ln;

                    br.read(CharBuffer.wrap(String.valueOf(id)));
                    br.read(CharBuffer.wrap(String.valueOf(gr)));
                    br.read(temp, 0, 10);
                    n = String.valueOf(temp);
                    br.read(temp, 10, 20);
                    ln = String.valueOf(temp);
                    System.out.println(new Student(id, n, ln, gr, this.getPath()).toSring());
                }
            } else if (this.getAdaptorType() == _DynRecDynStrAdap)
            {
                while (br.readLine() != null) {
                    int id = 0;
                    float gr = 0;
                    char[] temp = new char[20];
                    String n, ln;

                    br.read(CharBuffer.wrap(String.valueOf(id)));
                    br.read(CharBuffer.wrap(String.valueOf(gr)));
                    line = br.readLine();
                    n = line.substring(0, line.indexOf(","));
                    ln = line.substring(line.indexOf(",") + 1);
                    n = n.replaceAll(" ", "");
                    ln = ln.replaceAll(" ", "");
                    System.out.println(new Student(id, n, ln, gr, this.getPath()).toSring());
                }
            }
            fr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


import java.io.*;
import java.nio.CharBuffer;

public class Book extends File{
    private int id;
    private String name, writerName;
    private int edition;


    public Book(int i, String n, String wn, int ed, String p){
        super(p);
        id = i;
        name = n;
        writerName = wn;
        edition = ed;
    }
    public void setID(int i){
        id = i;
    }

    public int getID(){
        return id;
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public void setWriterName(String ln){
        writerName = ln;
    }

    public String getWriterName(){
        return writerName;
    }

    public void setEdition(int ed){
        edition = ed;
    }

    public int getEdition(){
        return edition;
    }

    public void write(Book b){
        try {
            FileOutputStream fos = new FileOutputStream(String.valueOf(new File(b.getPath())));
            DataOutputStream dout = new DataOutputStream(fos);
            if (b.getAdaptorType() == _FixRecFixStrAdap) {
                String ch;
                ch = String.format("%4d,%4d,%10s,%20s\n", b.id, b.edition, b.name, b.writerName);
                dout.writeUTF(ch);
            } else if (b.getAdaptorType() == _FixRecDynStrAdap) {
                String ch;
                ch = String.format("%4d,%4d,%s,%s\n", b.id, b.edition, b.name, b.writerName);
                dout.writeUTF(ch);
            } else if (b.getAdaptorType() == _DynRecFixStrAdap) {
                dout.writeByte(b.id);
                dout.writeFloat(b.edition);
                String ch;
                ch = String.format("%10s,%20s", b.name, b.writerName);
                dout.writeUTF(ch);
                dout.writeChars("\n");
            } else if (b.getAdaptorType() == _DynRecDynStrAdap) {
                dout.writeByte(b.id);
                dout.writeFloat(b.edition);
                dout.writeUTF(b.name);
                dout.writeChars(",");
                dout.writeUTF(b.writerName);
                dout.writeChars("\n");
            }
            fos.close();
            dout.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    public Book search(String s, int row){
        String line;
        try {
            FileReader fr = new FileReader(this.getPath());
            BufferedReader br = new BufferedReader(fr);

            row = 1;

            if (this.getAdaptorType() == _FixRecFixStrAdap) {
                while (br.readLine() != null) {
                    line = br.readLine();
                    if (line.equals(s)) {
                        int id, ed;
                        String n, wn;

                        id = Integer.parseInt(line.substring(0, 4));
                        ed = Integer.parseInt(line.substring(5, 10));
                        n = line.substring(11, 21);
                        wn = line.substring(22, 42);
                        n = n.replaceAll(" ", "");
                        wn = wn.replaceAll(" ", "");
                        return new Book(id, n, wn, ed, this.getPath());
                    }
                    row += 1;
                }
                return new Book(-1, "", "", 0, this.getPath());
            } else if (this.getAdaptorType() == _FixRecDynStrAdap) {
                while (br.readLine() != null) {
                    line = br.readLine();
                    if (line.equals(s)) {
                        int id, ed;
                        String n, wn;

                        id = Integer.parseInt(line.substring(0, 4));
                        ed = Integer.parseInt(line.substring(5, 10));
                        n = line.substring(11, line.indexOf(","));
                        wn = line.substring(line.indexOf(","));
                        n = n.replaceAll(" ", "");
                        wn = wn.replaceAll(" ", "");
                        return new Book(id, n, wn, ed, this.getPath());
                    }
                    row += 1;
                }
                return new Book(-1, "", "", 0, this.getPath());
            } else if (this.getAdaptorType() == _DynRecFixStrAdap) {
                while (br.readLine() != null) {
                    int id = 0, ed = 0;
                    char[] temp = new char[20];
                    String n, wn;

                    br.read(CharBuffer.wrap(String.valueOf(id)));
                    br.read(CharBuffer.wrap(String.valueOf(ed)));
                    br.read(temp, 0, 10);
                    n = String.valueOf(temp);
                    br.read(temp, 10, 20);
                    wn = String.valueOf(temp);
                    return new Book(id, n, wn, ed, this.getPath());
                }
                row += 1;
                return new Book(-1, "", "", 0, this.getPath());
            } else if (this.getAdaptorType() == _DynRecDynStrAdap) {
                while (br.readLine() != null) {
                    int id = 0, ed = 0;
                    char[] temp = new char[20];
                    String n, wn;

                    br.read(CharBuffer.wrap(String.valueOf(id)));
                    br.read(CharBuffer.wrap(String.valueOf(ed)));
                    line = br.readLine();
                    n = line.substring(0, line.indexOf(","));
                    wn = line.substring(line.indexOf(",") + 1);
                    n = n.replaceAll(" ", "");
                    wn = wn.replaceAll(" ", "");
                    return new Book(id, n, wn, ed, this.getPath());
                }
                row += 1;
                return new Book(-1, "", "", 0, this.getPath());
            }

            fr.close();
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public Book  search(int i, int row){
        return this.search(String.valueOf(i), row);
    }

    public String toSring(){
        String ch;
        ch = String.format("%d, %d, %s, %s\n", this.id, this.edition, this.name, this.writerName);
        return ch;
    }


    public void  printAll() {
        String line;
        try {
            FileReader fr = new FileReader(this.getPath());
            BufferedReader br = new BufferedReader(fr);

            if (this.getAdaptorType() == _FixRecFixStrAdap) {
                while (br.readLine() != null) {
                    line = br.readLine();
                        int id, ed;
                        String n, wn;

                        id = Integer.parseInt(line.substring(0, 4));
                        ed = Integer.parseInt(line.substring(5, 10));
                        n = line.substring(11, 21);
                        wn = line.substring(22, 42);
                        n = n.replaceAll(" ", "");
                        wn = wn.replaceAll(" ", "");
                        System.out.println(new Book(id, n, wn, ed, this.getPath()).toSring());
                }
            } else if (this.getAdaptorType() == _FixRecDynStrAdap) {
                while (br.readLine() != null) {
                    line = br.readLine();
                        int id, ed;
                        String n, wn;

                        id = Integer.parseInt(line.substring(0, 4));
                        ed = Integer.parseInt(line.substring(5, 10));
                        n = line.substring(11, line.indexOf(","));
                        wn = line.substring(line.indexOf(","));
                        n = n.replaceAll(" ", "");
                        wn = wn.replaceAll(" ", "");
                         System.out.println(new Book(id, n, wn, ed, this.getPath()).toSring());
                }
            } else if (this.getAdaptorType() == _DynRecFixStrAdap) {
                while (br.readLine() != null) {
                    int id = 0, ed = 0;
                    char[] temp = new char[20];
                    String n, wn;

                    br.read(CharBuffer.wrap(String.valueOf(id)));
                    br.read(CharBuffer.wrap(String.valueOf(ed)));
                    br.read(temp, 0, 10);
                    n = String.valueOf(temp);
                    br.read(temp, 10, 20);
                    wn = String.valueOf(temp);
                    System.out.println(new Book(id, n, wn, ed, this.getPath()).toSring());
                }
            } else if (this.getAdaptorType() == _DynRecDynStrAdap) {
                while (br.readLine() != null) {
                    int id = 0, ed = 0;
                    char[] temp = new char[20];
                    String n, wn;

                    br.read(CharBuffer.wrap(String.valueOf(id)));
                    br.read(CharBuffer.wrap(String.valueOf(ed)));
                    line = br.readLine();
                    n = line.substring(0, line.indexOf(","));
                    wn = line.substring(line.indexOf(",") + 1);
                    n = n.replaceAll(" ", "");
                    wn = wn.replaceAll(" ", "");
                    System.out.println(new Book(id, n, wn, ed, this.getPath()).toSring());
                }
            }
            fr.close();
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

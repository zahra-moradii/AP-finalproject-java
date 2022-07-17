import java.io.*;
import java.nio.CharBuffer;
import java.util.Date;

public class Library extends File{
    private int studentId,bookID;
    private Date borrowTime;

    public Library(int si, int bi, Date t, String p) {
        super(p);
        studentId = si;
        bookID = bi;
        borrowTime = t;
    }

    public int getStudentID() {
        return studentId;
    }

    public int getBookID() {
        return bookID;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public void write(Library lib) throws IOException {
        FileOutputStream fos = new FileOutputStream(String.valueOf(new File(lib.getPath())));
        DataOutputStream dout = new DataOutputStream(fos);

        dout.write(lib.studentId);
        dout.write(lib.bookID);
        //dout.write(lib.borrowTime);
    }

    public Library search(int id, int r) throws IOException {
        return this.search(String.valueOf(id), r);
    }

    public Library search(Date t, int r) throws IOException {
        return this.search(String.valueOf(t), r);
    }


    public Library search(String s, int r) throws IOException {

        FileReader fr = new FileReader(this.getPath());
        BufferedReader br = new BufferedReader(fr);

        while (br.readLine() != null)
        {
            int sId = 0, bId = 0;
            Date t = null;

            br.read(CharBuffer.wrap(String.valueOf(sId)));
            br.read(CharBuffer.wrap(String.valueOf(bId)));
            br.read(CharBuffer.wrap(String.valueOf(t)));

                return new Library(sId, bId, t, this.getPath());
        }
        fr.close();
        br.close();
        Date t = new Date();
        return new Library(-1, -1, t, this.getPath());
    }

    public String toSring() {
        String ch;
        System.out.println(this.borrowTime);
        ch = String.format("student id: %d, book id: %d, time: %s\n",this.studentId, this.bookID);
        return ch;
    }

    public void printAll() throws IOException {

        FileReader fr = new FileReader(this.getPath());
        BufferedReader br = new BufferedReader(fr);

        while (br.readLine() != null)
        {
            int sId = 0, bId = 0;
            Date t = null;

            br.read(CharBuffer.wrap(String.valueOf(sId)));
            br.read(CharBuffer.wrap(String.valueOf(bId)));
            br.read(CharBuffer.wrap(String.valueOf(t)));

            System.out.println(new Library(sId, bId, t, this.getPath()).toSring());

        }
        fr.close();
        br.close();
    }
}

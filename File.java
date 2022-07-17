import java.io.*;
import java.nio.charset.StandardCharsets;

public class File extends Adaptor{
    private String path;

    public File(String path) {
        this.path = path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }


    public String read() throws IOException {
        String line;
        FileReader fr = new FileReader(this.getPath());
        BufferedReader br = new BufferedReader(fr);
        line = br.readLine();
        fr.close();
        br.close();
        return line;
    }

    public void write(String s) throws IOException {
        FileOutputStream fos = new FileOutputStream(String.valueOf(new File(this.getPath())));
        DataOutputStream dout = new DataOutputStream(fos);
        dout.write(s.getBytes(StandardCharsets.UTF_8));
        fos.close();
        dout.close();
    }


    public void rest(int adapt) {
        setAdaptorType(adapt);

    }


//    public void deleteLine(final String file_name, int n) throws IOException {
//        FileReader fr = new FileReader(file_name);
//        BufferedReader br = new BufferedReader(fr);
//        FileOutputStream fos = new FileOutputStream("temp.txt");
//        DataOutputStream dout = new DataOutputStream(fos)
//
//        String c = null;
//        int line_no = 1;
//        while (br.readLine() != null)
//        {
//
//            if (line_no != n)
//                ofs << c;
//            if (c == '\n')
//                line_no++;
//        }
//
//        fr.close();
//        br.close();
//        fos.close();
//        dout.close();
//
//        remove(file_name);
//        rename("temp.txt", file_name);
//    }
}

import java.io.IOException;
import java.util.Scanner;
import java.util.Date;

public class FinalProject {
    public static void main(String[] args) throws IOException {
        final String studentPath = "student.dat";
        final String bookPath = "book.dat";
        final String libPath = "library.dat";

        int state = 0, in;
        File F = new File(bookPath);

        while (true) {
            if (state == 0)
            {
                state = -1;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("---------- LIBRARY ----------\n");
                System.out.print("press number of your funcation\n");
                System.out.print("1- add student\n");
                System.out.print("2- search student\n");
                System.out.print("3- edit student\n");
                System.out.print("4- add book\n");
                System.out.print("5- search book\n");
                System.out.print("6- edit book\n");
                System.out.print("7- borrowing book\n");
                System.out.print("8- search borrowing book record\n");
                System.out.print("9- print all student\n");
                System.out.print("10- print all book\n");
                System.out.print("11- print all borrowing record\n");

                Scanner s = new Scanner(System.in);
                in = s.nextInt();
                switch (in)
                {
                    case 1:
                        state = 1;
                        break;
                    case 2:
                        state = 2;
                        break;
                    case 3:
                        state = 3;
                        break;
                    case 4:
                        state = 4;
                        break;
                    case 5:
                        state = 5;
                        break;
                    case 6:
                        state = 6;
                        break;
                    case 7:
                        state = 7;
                        break;
                    case 8:
                        state = 8;
                        break;
                    case 9:
                        state = 9;
                        break;
                    case 10:
                        state = 10;
                        break;
                    case 11:
                        state = 11;
                        break;

                    default:
                        break;
                }
            }
            else if (state == 1)
            {
                state = 0;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("---------- add student ----------\n");
                int id;
                String n, ln;
                float g;
                System.out.println("Enter id: ");
                Scanner i = new Scanner(System.in);
                id = i.nextInt();
                System.out.println("Enter Name: ");
                Scanner nn = new Scanner(System.in);
                n = nn.nextLine();
                System.out.println("Enter Last Name: ");
                Scanner lnn = new Scanner(System.in);
                ln = lnn.nextLine();
                System.out.println("Enter grade: ");
                Scanner gg = new Scanner(System.in);
                g = gg.nextFloat();

                Student s = new Student(id,n,ln,g, studentPath);
                s.write(s);
            }
            else if (state == 2)
            {
                state = 0;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("---------- search student ----------\n");
                String str;
                Student s = new Student(0, " ", " ", 0, studentPath);
                System.out.println("Enter id or name or last name or grade: ");
                Scanner st = new Scanner(System.in);
                str = st.nextLine();
                int tempRow = 0;
                s = s.search(str, tempRow);
                if (s.getID() != -1)
                    System.out.println(s.toSring());
                else
                    System.out.println("can't finde this student\n");

                System.out.println("press any key to return to menu");
                Scanner temp = new Scanner(System.in);
                temp.nextLine();

            }
            else if (state == 3)
            {
                state = 0;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("---------- edite student ----------\n");
                String str;
                Student s = new Student(0, " ", " ", 0, studentPath);
                System.out.println("Enter id or name or last name or grade of student you want edit: ");
                Scanner st = new Scanner(System.in);
                str = st.nextLine();
                int tempRow = 0;
                s = s.search(str,tempRow);
                if (s.getID() != -1){
                    System.out.println("edit this student: ");
                    System.out.println(s.toSring());
                }
                else
                    System.out.println("can't finde this student\n");
                //s.deleteLine(studentPath, tempRow);

                int id;
                String n, ln;
                float g;
                System.out.println("Enter new id: ");
                Scanner i = new Scanner(System.in);
                id = i.nextInt();
                System.out.println("Enter new Name: ");
                Scanner nn = new Scanner(System.in);
                n = nn.nextLine();
                System.out.println("Enter new Last Name: ");
                Scanner lnn = new Scanner(System.in);
                ln = lnn.nextLine();
                System.out.println("Enter new grade: ");
                Scanner gg = new Scanner(System.in);
                g = gg.nextFloat();

                s.setId(id);
                s.setName(n);
                s.setLastName(ln);
                s.setGrade(g);

                s.write(s);

                System.out.println("edited student: ");
                System.out.println(s.toSring());
                System.out.println("\n");
                System.out.println("press any key to return to menu");
                Scanner temp = new Scanner(System.in);
                temp.nextLine();

            }
            else if (state == 4)
            {
                state = 0;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("---------- add book ----------\n");
                int id,ed;
                String n, wn;
                System.out.println("Enter book id: ");
                Scanner i = new Scanner(System.in);
                id = i.nextInt();
                System.out.println("Enter book Name: ");
                Scanner nn = new Scanner(System.in);
                n = nn.nextLine();
                System.out.println("Enter writer Name: ");
                Scanner wnn = new Scanner(System.in);
                wn = wnn.nextLine();
                System.out.println("Enter edition: ");
                Scanner edd = new Scanner(System.in);
                ed = edd.nextInt();
                Book b = new Book(id, n, wn, ed, bookPath);
                b.write(b);

            }
            else if (state == 5)
            {
                state = 0;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("---------- search book ----------\n");
                String str;
                Book b = new Book(0, " ", " ", 0, bookPath);
                System.out.println("Enter id or name or Writer or edition: ");
                Scanner st = new Scanner(System.in);
                str = st.nextLine();
                int tempRow = 0;
                b = b.search(str, tempRow);
                if (b.getID() != -1)
                    System.out.println( b.toSring());
                else
                    System.out.println("can't finde this book\n");

                System.out.println("press any key to return to menu");
                Scanner temp = new Scanner(System.in);
                temp.nextLine();

            }
            else if (state == 6)
            {
                state = 0;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("---------- edit book ----------\n");
                String str;
                Book b = new Book(0, " ", " ", 0, bookPath);
                System.out.println("Enter id or name or writer name or edotion of book you want edit: ");
                Scanner st = new Scanner(System.in);
                str = st.nextLine();
                int tempRow = 0;
                b = b.search(str, tempRow);
                if (b.getID() != -1) {
                    System.out.println("edit this book: ");
                    System.out.println(b.toSring());
                } else
                    System.out.println( "can't finde this book\n");
                //b.deleteLine(bookPath, tempRow);

                int id,ed;
                String n, wn;

                System.out.println("Enter new id: ");
                Scanner i = new Scanner(System.in);
                id = i.nextInt();
                System.out.println("Enter new Name: ");
                Scanner nn = new Scanner(System.in);
                n = nn.nextLine();
                System.out.println("Enter new writer Name: ");
                Scanner wnn = new Scanner(System.in);
                wn = wnn.nextLine();
                System.out.println("Enter new edition: ");
                Scanner edd = new Scanner(System.in);
                ed = edd.nextInt();

                b.setID(id);
                b.setName(n);
                b.setWriterName(wn);
                b.setEdition(ed);

                b.write(b);

                System.out.println("edited book: " );
                System.out.println(b.toSring());
                System.out.println("\n");
                System.out.println("press any key to return to menu");
                Scanner temp = new Scanner(System.in);
                temp.nextLine();


            }
            else if (state == 7)
            {
                state = 0;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("---------- borrowing book ----------\n");
                int sId,bId;
                Date t = new Date();

                System.out.println("Enter student id: ");
                Scanner sid = new Scanner(System.in);
                sId = sid.nextInt();
                System.out.println("Enter book id: ");
                Scanner bid = new Scanner(System.in);
                bId = bid.nextInt();

                Library lib = new Library(sId, bId ,t , libPath);
                lib.write(lib);
            }
            else if (state == 8)
            {
                state = 0;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("---------- search borrowing book record ----------\n");
                String str;
                Date t = new Date();
                Library lib = new Library(-1, -1, t, libPath);
                System.out.println("Enter student or book id ");
                Scanner st = new Scanner(System.in);
                str = st.nextLine();
                int tempRow = 0;
                lib = lib.search(str, tempRow);
                if (lib.getStudentID() != -1)
                    System.out.println(lib.toSring());
                else
                    System.out.println("can't finde this record\n");

                System.out.println("press any key to return to menu");
                Scanner temp = new Scanner(System.in);
                temp.nextLine();

            }
            else if (state == 9)
            {
                state = 0;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("---------- print all students ----------\n");
                Student s = new Student(0, " ", " ", 0, studentPath);
                s.printAll();
                System.out.println("press any key to return to menu");
                Scanner temp = new Scanner(System.in);
                temp.nextLine();
            }
            else if (state == 10)
            {
                state = 0;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("---------- print all book ----------\n");
                Book b = new Book(0, " ", " ", 0, bookPath);
                b.printAll();
                System.out.println("press any key to return to menu");
                Scanner temp = new Scanner(System.in);
                temp.nextLine();
            }
            else if (state == 11)
            {
                state = 0;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("---------- print all borrowing record ----------\n");
                Date t = new Date();
                Library lib = new Library(-1, -1, t, libPath);
                lib.printAll();
                System.out.println("press any key to return to menu");
                Scanner temp = new Scanner(System.in);
                temp.nextLine();
            }
        }


    }
}
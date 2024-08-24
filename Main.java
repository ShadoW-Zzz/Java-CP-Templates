import java.io.*;
import java.util.*;

//template for cp fast io.

public class Main {
    public static void main(String[] args) {
        FastIO sc = new FastIO();
        FastWriter out = new FastWriter();

        // Your code here

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }

        // #region FastIO and FastWriter
    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar, numChars;

        public FastIO() {
            this(System.in, System.out);
        }

        public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }

        public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }

        private int nextByte() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars == -1)
                    return -1; // End of file
            }
            return buf[curChar++];
        }

        public String next() {
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > ' ');
            return res.toString();
        }

        public int nextInt() {
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }

        public long nextLong() {
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            StringBuilder res = new StringBuilder();
            int c = nextByte();
            
            // If the current character is a new line, read the next character
            if (c == '\n') {
                c = nextByte();
            }

            // Read until the end of the line or the end of the stream
            while (c != -1 && c != '\n') {
                res.appendCodePoint(c);
                c = nextByte();
            }

            return res.toString();
        }

        public char nextChar() {
            int c = nextByte();
            while (c <= ' ')
                c = nextByte();
            return (char) c;
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }
    }

    static class FastWriter {
        private final StringBuilder sb;

        public FastWriter() {
            this.sb = new StringBuilder();
        }

        public void print(Object object) {
            sb.append(object);
        }

        public void println(Object object) {
            sb.append(object).append("\n");
        }

        public void print(char c) {
            sb.append(c);
        }

        public void println(char c) {
            sb.append(c).append("\n");
        }

        public void print(int i) {
            sb.append(i);
        }

        public void println(int i) {
            sb.append(i).append("\n");
        }

        public void print(long l) {
            sb.append(l);
        }

        public void println(long l) {
            sb.append(l).append("\n");
        }

        public void print(double d) {
            sb.append(d);
        }

        public void println(double d) {
            sb.append(d).append("\n");
        }

        public void close() throws IOException {
            System.out.print(sb);
        }
    }
        // #endregion
}
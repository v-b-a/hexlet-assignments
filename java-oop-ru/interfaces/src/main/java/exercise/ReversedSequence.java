package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    String text;

    public ReversedSequence(String text) {
        this.text = text;
    }
    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int i) {
        return text.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return null;
    }

    public String toString(String text) {
        char[] result = new char[text.length()];
        for (int i = text.length(); i >= 0; i--) {
            result[i] = text.charAt(i);
        }
        return result.toString();
    }
}
// END

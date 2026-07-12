class TextEditor {

    private StringBuilder builder;
    private int cursor;

    public TextEditor() {
        this.builder = new StringBuilder();
        this.cursor = 0;
    }

    public void addText(String text) {
        // hello
        this.builder.insert(this.cursor, text);
        this.cursor += text.length();
    }

    public int deleteText(int k) {
        int start = Math.max(0, this.cursor - k);
        int end = this.cursor;
        this.builder.delete(start, end);
        this.cursor = start;

        return end - start;
    }

    public String cursorLeft(int k) {
        // System.out.println("-----cursorLeft----");
        // System.out.println(this.cursor);
        // System.out.println(k);
        // System.out.println(this.cursor - k);
        this.cursor = Math.max(0, this.cursor - k);
        int start = Math.max(0, this.cursor - 10);
        int end = this.cursor;
        // System.out.println("start:" + start + "; end:" + end);
        // System.out.println(builder.toString());
        return builder.substring(start, end);
    }

    public String cursorRight(int k) {
        // System.out.println("-----cursorRight----");
        // System.out.println(this.cursor);
        // System.out.println(k);
        // System.out.println(this.cursor + k);
        this.cursor = Math.min(this.cursor + k, this.builder.length());
        // int start = this.cursor;
        // int end = Math.min(this.cursor + 10, this.builder.length());
        int start = Math.max(0, this.cursor - 10);
        int end = this.cursor;
        // System.out.println("start:" + start + "; end:" + end);
        // System.out.println(builder.toString());
        return builder.substring(start, end);
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
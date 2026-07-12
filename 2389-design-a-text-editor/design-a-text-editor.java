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

        this.cursor = Math.max(0, this.cursor - k);

        return leftSubString();

    }

    public String cursorRight(int k) {

        this.cursor = Math.min(this.cursor + k, this.builder.length());

        return leftSubString();
    }

    private String leftSubString() {
        int start = Math.max(0, this.cursor - 10);
        int end = this.cursor;

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